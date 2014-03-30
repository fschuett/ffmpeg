package test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.ffmpeg.avcodec.AVCodec;
import org.ffmpeg.avcodec.AVCodecContext;
import org.ffmpeg.avcodec.AVPacket;
import org.ffmpeg.avcodec.AvcodecLibrary;
import org.ffmpeg.avformat.AVFormatContext;
import org.ffmpeg.avformat.AVStream;
import org.ffmpeg.avformat.AvformatLibrary;
import org.ffmpeg.avutil.AVDictionary;
import org.ffmpeg.avutil.AVFrame;
import org.ffmpeg.avutil.AVUtil;
import org.ffmpeg.avutil.AvutilLibrary;
import org.ffmpeg.avutil.AvutilLibrary.AVMediaType;
import org.ffmpeg.avutil.AvutilLibrary.AVSampleFormat;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;

/**
 * @file libavformat demuxing API use example.
 * 
 *       Show how to use the libavformat and libavcodec API to demux and decode
 *       audio and video data.
 * @example doc/examples/demuxing.c
 */

public class Demuxing {
	static AVFormatContext.ByReference[] fmt_ctx = null;
	static AVCodecContext video_dec_ctx = null, audio_dec_ctx;
	static AVStream video_stream = null, audio_stream = null;
	static String src_filename = null;
	static String video_dst_filename = null;
	static String audio_dst_filename = null;
	static FileOutputStream video_dst_file = null;
	static FileOutputStream audio_dst_file = null;

	static ByteBuffer[] video_dst_data = null;
	static IntBuffer video_dst_linesize = IntBuffer.allocate(4);
	static int video_dst_bufsize;

	static IntByReference video_stream_idx = new IntByReference(),
			audio_stream_idx = new IntByReference();
	static AVFrame frame = null;
	static AVPacket pkt = null;
	static int video_frame_count = 0;
	static int audio_frame_count = 0;
	static AvformatLibrary lavf = AvformatLibrary.INSTANCE;
	static AvcodecLibrary lavc = AvcodecLibrary.INSTANCE;
	static AvutilLibrary lavu = AvutilLibrary.INSTANCE;

	static int decode_packet(IntBuffer got_frame, int cached)
			throws IOException {
		int ret = 0;
		int decoded = pkt.size();

		if (pkt.stream_index == video_stream_idx.getValue()) {
			/* decode video frame */
			ret = lavc.avcodec_decode_video2(video_dec_ctx, frame, got_frame,
					pkt);
			if (ret < 0) {
				System.err.printf("Error decoding video frame\n");
				return ret;
			}

			if (got_frame.get() != 0) {
				System.out.printf("video_frame%s n:%d coded_n:%d pts:%s\n",
						cached != 0 ? "(cached)" : "", video_frame_count++,
						frame.coded_picture_number, AVUtil.av_ts2timestr(
								frame.pts, video_dec_ctx.time_base));

				/*
				 * copy decoded frame to destination buffer: this is required
				 * since rawvideo expects non aligned data
				 */
				lavu.av_image_copy(video_dst_data, video_dst_linesize,
						frame.data, frame.linesize, video_dec_ctx.pix_fmt,
						video_dec_ctx.width, video_dec_ctx.height);

				/* write to rawvideo file */
				video_dst_file.write(video_dst_data[0].array());
			}
		} else if (pkt.stream_index == audio_stream_idx.getValue()) {
			/* decode audio frame */
			ret = lavc.avcodec_decode_audio4(audio_dec_ctx, frame, got_frame,
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
			decoded = Math.min(ret, pkt.size());

			if (got_frame.get() != 0) {
				int unpadded_linesize = frame.nb_samples
						* lavu.av_get_bytes_per_sample(frame.format);
				System.out.printf("audio_frame%s n:%d nb_samples:%d pts:%s\n",
						cached != 0 ? "(cached)" : "", audio_frame_count++,
						frame.nb_samples, AVUtil.av_ts2timestr(frame.pts,
								audio_dec_ctx.time_base));

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
				audio_dst_file.write(frame.extended_data.getValue()
						.getByteArray(0, unpadded_linesize));
			}
		}

		return decoded;
	}

	static int open_codec_context(IntByReference stream_idx,
			AVFormatContext fmt_ctx, int type) {
		int ret;
		AVStream st;
		AVCodecContext dec_ctx = null;
		AVCodec dec = null;

		ret = lavf.av_find_best_stream(fmt_ctx, type, -1, -1,
				(AVCodec.ByReference[]) null, 0);
		if (ret < 0) {
			System.err.printf("Could not find %s stream in input file '%s'\n",
					lavu.av_get_media_type_string(type), src_filename);
			return ret;
		} else {
			stream_idx.setValue(ret);
			st = fmt_ctx.streams[stream_idx.getValue()];

			/* find decoder for the stream */
			dec_ctx = st.codec;
			dec = lavc.avcodec_find_decoder(dec_ctx.codec_id);
			if (dec == null) {
				System.err.printf("Failed to find %s codec\n",
						lavu.av_get_media_type_string(type));
				return ret;
			}

			if ((ret = lavc.avcodec_open2(dec_ctx, dec,
					(AVDictionary.ByReference[]) null)) < 0) {
				System.err.printf("Failed to open %s codec\n",
						lavu.av_get_media_type_string(type));
				return ret;
			}
		}

		return 0;
	}

	static String get_format_from_sample_fmt(int sample_fmt) {
		switch (sample_fmt) {
		case AVSampleFormat.AV_SAMPLE_FMT_U8:
			return "u8";
		case AVSampleFormat.AV_SAMPLE_FMT_S16:
			return "s16le";
		case AVSampleFormat.AV_SAMPLE_FMT_S32:
			return "s32le";
		case AVSampleFormat.AV_SAMPLE_FMT_FLT:
			return "f32le";
		case AVSampleFormat.AV_SAMPLE_FMT_DBL:
			return "f64le";
		default:
			break;
		}
		System.err.printf(
				"sample format %s is not supported as output format\n",
				lavu.av_get_sample_fmt_name(sample_fmt));
		return null;
	}

	public static void main(String[] args) throws IOException {
		int ret = 0;
		IntBuffer got_frame = IntBuffer.allocate(1);
		video_stream_idx.setValue(-1);
		audio_stream_idx.setValue(-1);
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
			lavf.av_register_all();

			/* open input file, and allocate format context */
			if (lavf.avformat_open_input(fmt_ctx, src_filename, null, null) < 0) {
				System.err.printf("Could not open source file %s\n",
						src_filename);
				System.exit(1);
			}
			/* retrieve stream information */
			if (lavf.avformat_find_stream_info(fmt_ctx[0],
					(AVDictionary.ByReference[]) null) < 0) {
				System.err.printf("Could not find stream information\n");
				System.exit(1);
			}

			if (open_codec_context(video_stream_idx, fmt_ctx[0],
					AVMediaType.AVMEDIA_TYPE_VIDEO) >= 0) {
				video_stream = fmt_ctx[0].streams[video_stream_idx.getValue()];
				video_dec_ctx = video_stream.codec;

				try {
					video_dst_file = new FileOutputStream(video_dst_filename);
				} catch (IOException e) {
					System.err.printf("Could not open destination file %s\n",
							video_dst_filename);
					ret = 1;
					System.exit(1);
				}

				/* allocate image where the decoded image will be put */
				ret = lavu.av_image_alloc(video_dst_data, video_dst_linesize,
						video_dec_ctx.width, video_dec_ctx.height,
						video_dec_ctx.pix_fmt, 1);
				if (ret < 0) {
					System.err.printf("Could not allocate raw video buffer\n");
					System.exit(ret);
				}
				video_dst_bufsize = ret;
			}

			if (open_codec_context(audio_stream_idx, fmt_ctx[0],
					AVMediaType.AVMEDIA_TYPE_AUDIO) >= 0) {
				audio_stream = fmt_ctx[0].streams[audio_stream_idx.getValue()];
				audio_dec_ctx = audio_stream.codec;
				try {
					audio_dst_file = new FileOutputStream(audio_dst_filename);
				} catch (IOException e) {
					System.err.printf("Could not open destination file %s\n",
							video_dst_filename);
					System.exit(1);
				}
			}

			/* dump input information to stderr */
			lavf.av_dump_format(fmt_ctx[0], 0, src_filename, 0);

			if (audio_stream == null && video_stream == null) {
				System.err
						.printf("Could not find audio or video stream in the input, aborting\n");
				System.exit(1);
			}

			frame = lavc.avcodec_alloc_frame();
			if (frame == null) {
				System.err.printf("Could not allocate frame\n");
				System.exit(1);
			}

			/* initialize packet, set data to null, let the demuxer fill it */
			pkt = new AVPacket();
			lavc.av_init_packet(pkt);
			pkt.data = null;
			pkt.size = 0;

			if (video_stream != null)
				System.out.printf("Demuxing video from file '%s' into '%s'\n",
						src_filename, video_dst_filename);
			if (audio_stream != null)
				System.out.printf("Demuxing audio from file '%s' into '%s'\n",
						src_filename, audio_dst_filename);

			/* read frames from the file */
			while (lavf.av_read_frame(fmt_ctx[0], pkt) >= 0) {
				AVPacket orig_pkt = pkt;
				do {
					System.err.println("decode_packet");
					ret = decode_packet(got_frame, 0);
					if (ret < 0)
						break;
					System.err.println("modify data ptr");
					pkt.data = pkt.data.share(ret);
					pkt.size -= ret;
					System.err.println("modify data ptr completed");
				} while (pkt.size() > 0);
				System.err.println("av_free_packet");
				lavc.av_free_packet(orig_pkt);
				System.err.println("av_free_packet completed");
			}

			/* flush cached frames */
			pkt.data = null;
			pkt.size = 0;
			do {
				decode_packet(got_frame, 1);
			} while (got_frame.get() != 0);

			System.out.printf("Demuxing succeeded.\n");

			if (video_stream != null) {
				System.out
						.printf("Play the output video file with the command:\n"
								+ "ffplay -f rawvideo -pix_fmt %s -video_size %dx%d %s\n",
								lavu.av_get_pix_fmt_name(video_dec_ctx.pix_fmt),
								video_dec_ctx.width, video_dec_ctx.height,
								video_dst_filename);
			}

			if (audio_stream != null) {
				int sfmt = audio_dec_ctx.sample_fmt;
				int n_channels = audio_dec_ctx.channels;
				String fmt;

				if (lavu.av_sample_fmt_is_planar(sfmt) != 0) {
					String packed = lavu.av_get_sample_fmt_name(sfmt);
					System.out
							.printf("Warning: the sample format the decoder produced is planar "
									+ "(%s). This example will output the first channel only.\n",
									packed != null ? packed : "?");
					sfmt = lavu.av_get_packed_sample_fmt(sfmt);
					n_channels = 1;
				}

				if ((fmt = get_format_from_sample_fmt(sfmt)) == null)
					System.exit(-1);
				ret = 0;
				System.out.printf(
						"Play the output audio file with the command:\n"
								+ "ffplay -f %s -ac %d -ar %d %s\n", fmt,
						n_channels, audio_dec_ctx.sample_rate,
						audio_dst_filename);
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			System.err.print("freeing video_dec_ctx..");
			if (video_dec_ctx != null)
				lavc.avcodec_close(video_dec_ctx);
			System.err.println("freed");
			System.err.print("freeing audio_dec_ctx...");
			if (audio_dec_ctx != null)
				lavc.avcodec_close(audio_dec_ctx);
			System.err.println("freed");
			System.err.print("freeing fmt_ctx...");
			lavf.avformat_close_input(fmt_ctx);
			System.err.println("freed");
			if (video_dst_file != null)
				video_dst_file.close();
			if (audio_dst_file != null)
				audio_dst_file.close();
			System.err.print("freeing frame...");
			lavu.av_free(frame.getPointer());
			System.err.println("freed");
			System.err.print("freeing video_dst_data...");
			lavu.av_freep(Native.getDirectBufferPointer(video_dst_data[0]));
			System.err.println("freed");
		}
		System.exit(ret);
	}
}
