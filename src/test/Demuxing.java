package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.bridj.IntValuedEnum;
import org.bridj.Pointer;
import org.ffmpeg.avcodec.AVCodec;
import org.ffmpeg.avcodec.AVCodecContext;
import org.ffmpeg.avcodec.AvcodecLibrary;
import org.ffmpeg.avcodec.AVPacket;
import org.ffmpeg.avformat.AVFormatContext;
import org.ffmpeg.avformat.AVStream;
import org.ffmpeg.avformat.AvformatLibrary;
import org.ffmpeg.avutil.AVFrame;
import org.ffmpeg.avutil.AvutilLibrary;
import org.ffmpeg.avutil.AvutilLibrary.AVMediaType;
import org.ffmpeg.avutil.AvutilLibrary.AVSampleFormat;

import static org.ffmpeg.avcodec.AvcodecLibrary.*;
import static org.ffmpeg.avutil.AvutilLibrary.*;
import static org.ffmpeg.avformat.AvformatLibrary.*;
import static org.ffmpeg.avutil.AVUtil.*;
import static org.ffmpeg.avutil.AvutilLibrary.AVSampleFormat.*;

/**
 * @file libavformat demuxing API use example.
 * 
 *       Show how to use the libavformat and libavcodec API to demux and decode
 *       audio and video data.
 * @example doc/examples/demuxing.c
 */

public class Demuxing {
	static Pointer<AVFormatContext> fmt_ctx = null;
	static Pointer<AVCodecContext> video_dec_ctx = null, audio_dec_ctx;
	static Pointer<AVStream> video_stream = null, audio_stream = null;
	static Pointer<Byte> streamptr = null; 
	static String src_filename = null;
	static String video_dst_filename = null;
	static String audio_dst_filename = null;
	static FileOutputStream video_dst_file = null;
	static FileOutputStream audio_dst_file = null;

	static Pointer<Pointer<Byte>> video_dst_data = Pointer.allocatePointers(Byte.class, 4);
	static Pointer<Integer> video_dst_linesize = Pointer.allocateInts(4);
	static int video_dst_bufsize;

	static Pointer<Integer> video_stream_idx = Pointer.allocateInt(), 
			audio_stream_idx = Pointer.allocateInt();
	static Pointer<AVFrame> frame = null;
	static Pointer<AVPacket> pkt = null;
	static int video_frame_count = 0;
	static int audio_frame_count = 0;
	static AvformatLibrary lavf = new AvformatLibrary();
	static AvcodecLibrary lavc = new AvcodecLibrary();
	static AvutilLibrary lavu = new AvutilLibrary();

	static int decode_packet(Pointer<Integer> got_frame, int cached)
			throws IOException {
		int ret = 0;
		int decoded = pkt.get().size();

		if (pkt.get().stream_index() == video_stream_idx.get()) {
			/* decode video frame */
			ret = avcodec_decode_video2(video_dec_ctx, frame, got_frame,
					pkt);
			if (ret < 0) {
				System.err.printf("Error decoding video frame\n");
				return ret;
			}

			if (got_frame.get() != 0) {
				System.out.printf("video_frame%s n:%d coded_n:%d pts:%s\n",
						cached != 0 ? "(cached)" : "", video_frame_count++,
						frame.get().coded_picture_number(), av_ts2timestr(
								frame.get().pts(), video_dec_ctx.get().time_base()));

				/*
				 * copy decoded frame to destination buffer: this is required
				 * since rawvideo expects non aligned data
				 */
				av_image_copy(video_dst_data, video_dst_linesize,
						frame.get().data(), frame.get().linesize(), video_dec_ctx.get().pix_fmt(),
						video_dec_ctx.get().width(), video_dec_ctx.get().height());

				/* write to rawvideo file */
				streamptr = video_dst_data.get();
				video_dst_file.write(streamptr.getBytes(video_dst_bufsize));
			}
		} else if (pkt.get().stream_index() == audio_stream_idx.get()) {
			/* decode audio frame */
			ret = avcodec_decode_audio4(audio_dec_ctx, frame, got_frame,
					pkt);
			if (ret < 0) {
				System.err.printf("Error decoding audio frame\n");
				return ret;
			}
			/*
			 * Some audio decoders decode only part of the packet, and have to
			 * be called again with the remainder of the packet data. Sample:
			 * fate-suite/lossless-audio/luckynight-partial.shn Also, some
			 * decoders might over-read the packet.
			 */
			decoded = Math.min(ret, pkt.get().size());

			if (got_frame.get() != 0) {
				int unpadded_linesize = frame.get().nb_samples()
						* av_get_bytes_per_sample(AVSampleFormat.fromValue(frame.get().format()));
				System.out.printf("audio_frame%s n:%d nb_samples:%d pts:%s\n",
						cached != 0 ? "(cached)" : "", audio_frame_count++,
						frame.get().nb_samples(), av_ts2timestr(frame.get().pts(),
								audio_dec_ctx.get().time_base()));

				/*
				 * Write the raw audio data samples of the first plane. This
				 * works fine for packed formats (e.g. AV_SAMPLE_FMT_S16).
				 * However, most audio decoders output planar audio, which uses
				 * a separate plane of audio samples for each channel (e.g.
				 * AV_SAMPLE_FMT_S16P). In other words, this code will write
				 * only the first audio channel in these cases. You should use
				 * libswresample or libavfilter to convert the frame to packed
				 * data.
				 */
				streamptr = frame.get().extended_data().get();
				audio_dst_file.write(streamptr.getBytes(unpadded_linesize));
			}
		}

		return decoded;
	}

	static int open_codec_context(Pointer<Integer> stream_idx,
			Pointer<AVFormatContext> fmt_ctx, AVMediaType type) {
		int ret;
		Pointer<AVStream> st;
		Pointer<AVCodecContext> dec_ctx = null;
		Pointer<AVCodec> dec = null;

		ret = av_find_best_stream(fmt_ctx, type, -1, -1, null, 0);
		if (ret < 0) {
			System.err.printf("Could not find %s stream in input file '%s'\n",
					av_get_media_type_string(type).getCString(), src_filename);
			return ret;
		} else {
			stream_idx.set(ret);
			st = fmt_ctx.get().streams().get(stream_idx.get());

			/* find decoder for the stream */
			dec_ctx = st.get().codec();
			dec = avcodec_find_decoder(dec_ctx.get().codec_id());
			if (dec == null) {
				System.err.printf("Failed to find %s codec\n",
						av_get_media_type_string(type));
				return ret;
			}

			if ((ret = avcodec_open2(dec_ctx, dec, null)) < 0) {
				System.err.printf("Failed to open %s codec\n",
						av_get_media_type_string(type));
				return ret;
			}
		}

		return 0;
	}

	static String get_format_from_sample_fmt(IntValuedEnum<AVSampleFormat> sample_fmt) {
		if(sample_fmt.value() == AV_SAMPLE_FMT_U8.value())
			return "u8";
		else if(sample_fmt.value() == AV_SAMPLE_FMT_S16.value())
			return "s16le";
		else if(sample_fmt.value() == AV_SAMPLE_FMT_S32.value())
			return "s32le";
		else if(sample_fmt.value() == AV_SAMPLE_FMT_FLT.value())
			return "f32le";
		else if(sample_fmt.value() == AV_SAMPLE_FMT_DBL.value())
			return "f64le";
		System.err.printf(
				"sample format %s is not supported as output format\n",
				av_get_sample_fmt_name(sample_fmt));
		return null;
	}

	public static void main(String[] args) throws IOException {
		int ret = 0;
		Pointer<Integer> got_frame = Pointer.allocateInt();
		video_stream_idx.set(-1);
		audio_stream_idx.set(-1);
		if (args.length != 3) {
			System.err
					.printf("usage: Demuxing input_file video_output_file audio_output_file\n"
							+ "API example program to show how to read frames from an input file.\n"
							+ "This program reads frames from a file, decodes them, and writes decoded\n"
							+ "video frames to a rawvideo file named video_output_file, and decoded\n"
							+ "audio frames to a rawaudio file named audio_output_file.\n"
							+ "\n");
			System.exit(1);
		}
		src_filename = args[0];
		video_dst_filename = args[1];
		audio_dst_filename = args[2];

		try {
			/* register all formats and codecs */
			av_register_all();

			/* open input file, and allocate format context */
			Pointer<Pointer<AVFormatContext>> pfmt_ctx = Pointer.allocatePointer(AVFormatContext.class);
			if (avformat_open_input(pfmt_ctx, Pointer.pointerToCString(src_filename), null, null) < 0) {
				System.err.printf("Could not open source file %s\n",
						src_filename);
				System.exit(1);
			}

			fmt_ctx = pfmt_ctx.get();
			/* retrieve stream information */
			if (avformat_find_stream_info(fmt_ctx, null) < 0) {
				System.err.printf("Could not find stream information\n");
				System.exit(1);
			}
			
			if (open_codec_context(video_stream_idx, fmt_ctx,
					AVMediaType.AVMEDIA_TYPE_VIDEO) >= 0) {
				video_stream = fmt_ctx.get().streams().get(video_stream_idx.get());
				video_dec_ctx = video_stream.get().codec();

				try {
					video_dst_file = new FileOutputStream(video_dst_filename);
				} catch (IOException e) {
					System.err.printf("Could not open destination file %s\n",
							video_dst_filename);
					ret = 1;
					System.exit(1);
				}

				/* allocate image where the decoded image will be put */
				ret = av_image_alloc(video_dst_data, video_dst_linesize,
						video_dec_ctx.get().width(), video_dec_ctx.get().height(),
						video_dec_ctx.get().pix_fmt(), 1);
				if (ret < 0) {
					System.err.printf("Could not allocate raw video buffer\n");
					System.exit(ret);
				}
				video_dst_bufsize = ret;
			}

			if (open_codec_context(audio_stream_idx, fmt_ctx,
					AVMediaType.AVMEDIA_TYPE_AUDIO) >= 0) {
				audio_stream = fmt_ctx.get().streams().get(audio_stream_idx.get());
				audio_dec_ctx = audio_stream.get().codec();
				try {
					audio_dst_file = new FileOutputStream(audio_dst_filename);
				} catch (IOException e) {
					System.err.printf("Could not open destination file %s\n",
							video_dst_filename);
					System.exit(1);
				}
			}

			/* dump input information to stderr */
			av_dump_format(fmt_ctx, 0, Pointer.pointerToCString(src_filename), 0);

			if (audio_stream == null && video_stream == null) {
				System.err
						.printf("Could not find audio or video stream in the input, aborting\n");
				System.exit(1);
			}

			frame = alloc_frame();
			if (frame == null) {
				System.err.printf("Could not allocate frame\n");
				System.exit(1);
			}

			/* initialize packet, set data to null, let the demuxer fill it */
			pkt = Pointer.allocate(AVPacket.class);
			av_init_packet(pkt);
			pkt.get().data(null);
			pkt.get().size(0);

			if (video_stream != null)
				System.out.printf("Demuxing video from file '%s' into '%s'\n",
						src_filename, video_dst_filename);
			if (audio_stream != null)
				System.out.printf("Demuxing audio from file '%s' into '%s'\n",
						src_filename, audio_dst_filename);

			/* read frames from the file */
			while (av_read_frame(fmt_ctx, pkt) >= 0) {
				Pointer<AVPacket> orig_pkt = pkt;
				do {
					ret = decode_packet(got_frame, 0);
					if (ret < 0)
						break;
					long ptr = pkt.get().data().getPeer();
					ptr+=ret;
					pkt.get().data((Pointer<Byte>)Pointer.pointerToAddress(ptr));
					pkt.get().size(pkt.get().size()-ret);
				} while (pkt.get().size() > 0);
				av_free_packet(orig_pkt);
			}

			/* flush cached frames */
			pkt.get().data(null);
			pkt.get().size(0);
			do {
				decode_packet(got_frame, 1);
			} while (got_frame.get() != 0);

			System.out.printf("Demuxing succeeded.\n");

			if (video_stream != null) {
				System.out
						.printf("Play the output video file with the command:\n"
								+ "ffplay -f rawvideo -pix_fmt %s -video_size %dx%d %s\n",
								av_get_pix_fmt_name(video_dec_ctx.get().pix_fmt()).getCString(),
								video_dec_ctx.get().width(), video_dec_ctx.get().height(),
								video_dst_filename);
			}

			if (audio_stream != null) {
				IntValuedEnum<AVSampleFormat> sfmt = audio_dec_ctx.get().sample_fmt();
				int n_channels = audio_dec_ctx.get().channels();
				String fmt;

				if (av_sample_fmt_is_planar(sfmt) != 0) {
					String packed = av_get_sample_fmt_name(sfmt).getCString();
					System.out
							.printf("Warning: the sample format the decoder produced is planar "
									+ "(%s). This example will output the first channel only.\n",
									packed != null ? packed : "?");
					sfmt = av_get_packed_sample_fmt(sfmt);
					n_channels = 1;
				}

				if ((fmt = get_format_from_sample_fmt(sfmt)) == null)
					System.exit(-1);
				ret = 0;
				System.out.printf(
						"Play the output audio file with the command:\n"
								+ "ffplay -f %s -ac %d -ar %d %s\n", fmt,
						n_channels, audio_dec_ctx.get().sample_rate(),
						audio_dst_filename);
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			System.err.print("freeing video_dec_ctx..");
			if (video_dec_ctx != null)
				avcodec_close(video_dec_ctx);
			System.err.println("freed");
			System.err.print("freeing audio_dec_ctx...");
			if (audio_dec_ctx != null)
				avcodec_close(audio_dec_ctx);
			System.err.println("freed");
			System.err.print("freeing fmt_ctx...");
			if(fmt_ctx != null) {
				avformat_close_input(fmt_ctx.getReference());
			}
			System.err.println("freed");
			if (video_dst_file != null)
				video_dst_file.close();
			if (audio_dst_file != null)
				audio_dst_file.close();
			System.err.print("freeing frame...");
			if(frame != null)
				av_free(frame);
			System.err.println("freed");
			System.err.print("freeing video_dst_data...");
			if(video_dst_data != null && video_dst_data.getValidElements() > 0)
				av_freep(video_dst_data);
			System.err.println("freed");
		}
		System.exit(ret);
	}
}
