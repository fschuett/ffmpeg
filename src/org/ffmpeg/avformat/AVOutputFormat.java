package org.ffmpeg.avformat;
import org.bridj.BridJ;
import org.bridj.Callback;
import org.bridj.FlagSet;
import org.bridj.IntValuedEnum;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
import org.bridj.ann.Ptr;
import org.bridj.util.DefaultParameterizedType;
import org.ffmpeg.avcodec.AVPacket;
import org.ffmpeg.avcodec.AvcodecLibrary.AVCodecID;
import org.ffmpeg.avdevice.AVDeviceCapabilitiesQuery;
import org.ffmpeg.avdevice.AVDeviceInfoList;
import org.ffmpeg.avutil.AVClass;
import org.ffmpeg.avutil.AVFrame;
/**
 * <i>native declaration : libavformat/avformat.h:173</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("avformat") 
public class AVOutputFormat extends StructObject {
	static {
		BridJ.register();
	}
	/** C type : const char* */
	@Field(0) 
	public Pointer<Byte > name() {
		return this.io.getPointerField(this, 0);
	}
	/** C type : const char* */
	@Field(0) 
	public AVOutputFormat name(Pointer<Byte > name) {
		this.io.setPointerField(this, 0, name);
		return this;
	}
	/**
	 * Descriptive name for the format, meant to be more human-readable<br>
	 * than name. You should use the NULL_IF_CONFIG_SMALL() macro<br>
	 * to define it.<br>
	 * C type : const char*
	 */
	@Field(1) 
	public Pointer<Byte > long_name() {
		return this.io.getPointerField(this, 1);
	}
	/**
	 * Descriptive name for the format, meant to be more human-readable<br>
	 * than name. You should use the NULL_IF_CONFIG_SMALL() macro<br>
	 * to define it.<br>
	 * C type : const char*
	 */
	@Field(1) 
	public AVOutputFormat long_name(Pointer<Byte > long_name) {
		this.io.setPointerField(this, 1, long_name);
		return this;
	}
	/** C type : const char* */
	@Field(2) 
	public Pointer<Byte > mime_type() {
		return this.io.getPointerField(this, 2);
	}
	/** C type : const char* */
	@Field(2) 
	public AVOutputFormat mime_type(Pointer<Byte > mime_type) {
		this.io.setPointerField(this, 2, mime_type);
		return this;
	}
	/**
	 * < comma-separated filename extensions<br>
	 * C type : const char*
	 */
	@Field(3) 
	public Pointer<Byte > extensions() {
		return this.io.getPointerField(this, 3);
	}
	/**
	 * < comma-separated filename extensions<br>
	 * C type : const char*
	 */
	@Field(3) 
	public AVOutputFormat extensions(Pointer<Byte > extensions) {
		this.io.setPointerField(this, 3, extensions);
		return this;
	}
	/**
	 * output support<br>
	 * < default audio codec<br>
	 * C type : AVCodecID
	 */
	@Field(4) 
	public IntValuedEnum<AVCodecID > audio_codec() {
		return this.io.getEnumField(this, 4);
	}
	/**
	 * output support<br>
	 * < default audio codec<br>
	 * C type : AVCodecID
	 */
	@Field(4) 
	public AVOutputFormat audio_codec(IntValuedEnum<AVCodecID > audio_codec) {
		this.io.setEnumField(this, 4, audio_codec);
		return this;
	}
	/**
	 * < default video codec<br>
	 * C type : AVCodecID
	 */
	@Field(5) 
	public IntValuedEnum<AVCodecID > video_codec() {
		return this.io.getEnumField(this, 5);
	}
	/**
	 * < default video codec<br>
	 * C type : AVCodecID
	 */
	@Field(5) 
	public AVOutputFormat video_codec(IntValuedEnum<AVCodecID > video_codec) {
		this.io.setEnumField(this, 5, video_codec);
		return this;
	}
	/**
	 * < default subtitle codec<br>
	 * C type : AVCodecID
	 */
	@Field(6) 
	public IntValuedEnum<AVCodecID > subtitle_codec() {
		return this.io.getEnumField(this, 6);
	}
	/**
	 * < default subtitle codec<br>
	 * C type : AVCodecID
	 */
	@Field(6) 
	public AVOutputFormat subtitle_codec(IntValuedEnum<AVCodecID > subtitle_codec) {
		this.io.setEnumField(this, 6, subtitle_codec);
		return this;
	}
	/**
	 * can use flags: AVFMT_NOFILE, AVFMT_NEEDNUMBER,<br>
	 * AVFMT_GLOBALHEADER, AVFMT_NOTIMESTAMPS, AVFMT_VARIABLE_FPS,<br>
	 * AVFMT_NODIMENSIONS, AVFMT_NOSTREAMS, AVFMT_ALLOW_FLUSH,<br>
	 * AVFMT_TS_NONSTRICT, AVFMT_TS_NEGATIVE
	 */
	@Field(7) 
	public int flags() {
		return this.io.getIntField(this, 7);
	}
	/**
	 * can use flags: AVFMT_NOFILE, AVFMT_NEEDNUMBER,<br>
	 * AVFMT_GLOBALHEADER, AVFMT_NOTIMESTAMPS, AVFMT_VARIABLE_FPS,<br>
	 * AVFMT_NODIMENSIONS, AVFMT_NOSTREAMS, AVFMT_ALLOW_FLUSH,<br>
	 * AVFMT_TS_NONSTRICT, AVFMT_TS_NEGATIVE
	 */
	@Field(7) 
	public AVOutputFormat flags(int flags) {
		this.io.setIntField(this, 7, flags);
		return this;
	}
	/**
	 * List of supported codec_id-codec_tag pairs, ordered by "better<br>
	 * choice first". The arrays are all terminated by AV_CODEC_ID_NONE.<br>
	 * C type : AVCodecTag**
	 */
	@Field(8) 
	public Pointer<Pointer<AVCodecTag > > codec_tag() {
		return this.io.getPointerField(this, 8);
	}
	/**
	 * List of supported codec_id-codec_tag pairs, ordered by "better<br>
	 * choice first". The arrays are all terminated by AV_CODEC_ID_NONE.<br>
	 * C type : AVCodecTag**
	 */
	@Field(8) 
	public AVOutputFormat codec_tag(Pointer<Pointer<AVCodecTag > > codec_tag) {
		this.io.setPointerField(this, 8, codec_tag);
		return this;
	}
	/**
	 * < AVClass for the private context<br>
	 * C type : const AVClass*
	 */
	@Field(9) 
	public Pointer<AVClass > priv_class() {
		return this.io.getPointerField(this, 9);
	}
	/**
	 * < AVClass for the private context<br>
	 * C type : const AVClass*
	 */
	@Field(9) 
	public AVOutputFormat priv_class(Pointer<AVClass > priv_class) {
		this.io.setPointerField(this, 9, priv_class);
		return this;
	}
	/**
	 * No fields below this line are part of the public API. They<br>
	 * may not be used outside of libavformat and can be changed and<br>
	 * removed at will.<br>
	 * New public fields should be added right above.<br>
	 * ****************************************************************<br>
	 * C type : AVOutputFormat*
	 */
	@Field(10) 
	public Pointer<AVOutputFormat > next() {
		return this.io.getPointerField(this, 10);
	}
	/**
	 * No fields below this line are part of the public API. They<br>
	 * may not be used outside of libavformat and can be changed and<br>
	 * removed at will.<br>
	 * New public fields should be added right above.<br>
	 * ****************************************************************<br>
	 * C type : AVOutputFormat*
	 */
	@Field(10) 
	public AVOutputFormat next(Pointer<AVOutputFormat > next) {
		this.io.setPointerField(this, 10, next);
		return this;
	}
	/** size of private data so that it can be allocated in the wrapper */
	@Field(11) 
	public int priv_data_size() {
		return this.io.getIntField(this, 11);
	}
	/** size of private data so that it can be allocated in the wrapper */
	@Field(11) 
	public AVOutputFormat priv_data_size(int priv_data_size) {
		this.io.setIntField(this, 11, priv_data_size);
		return this;
	}
	/** C type : write_header_callback* */
	@Field(12) 
	public Pointer<AVOutputFormat.write_header_callback > write_header() {
		return this.io.getPointerField(this, 12);
	}
	/** C type : write_header_callback* */
	@Field(12) 
	public AVOutputFormat write_header(Pointer<AVOutputFormat.write_header_callback > write_header) {
		this.io.setPointerField(this, 12, write_header);
		return this;
	}
	/**
	 * Write a packet. If AVFMT_ALLOW_FLUSH is set in flags,<br>
	 * pkt can be NULL in order to flush data buffered in the muxer.<br>
	 * When flushing, return 0 if there still is more data to flush,<br>
	 * or 1 if everything was flushed and there is no more buffered<br>
	 * data.<br>
	 * C type : write_packet_callback*
	 */
	@Field(13) 
	public Pointer<AVOutputFormat.write_packet_callback > write_packet() {
		return this.io.getPointerField(this, 13);
	}
	/**
	 * Write a packet. If AVFMT_ALLOW_FLUSH is set in flags,<br>
	 * pkt can be NULL in order to flush data buffered in the muxer.<br>
	 * When flushing, return 0 if there still is more data to flush,<br>
	 * or 1 if everything was flushed and there is no more buffered<br>
	 * data.<br>
	 * C type : write_packet_callback*
	 */
	@Field(13) 
	public AVOutputFormat write_packet(Pointer<AVOutputFormat.write_packet_callback > write_packet) {
		this.io.setPointerField(this, 13, write_packet);
		return this;
	}
	/** C type : write_trailer_callback* */
	@Field(14) 
	public Pointer<AVOutputFormat.write_trailer_callback > write_trailer() {
		return this.io.getPointerField(this, 14);
	}
	/** C type : write_trailer_callback* */
	@Field(14) 
	public AVOutputFormat write_trailer(Pointer<AVOutputFormat.write_trailer_callback > write_trailer) {
		this.io.setPointerField(this, 14, write_trailer);
		return this;
	}
	/**
	 * Currently only used to set pixel format if not YUV420P.<br>
	 * C type : interleave_packet_callback*
	 */
	@Field(15) 
	public Pointer<AVOutputFormat.interleave_packet_callback > interleave_packet() {
		return this.io.getPointerField(this, 15);
	}
	/**
	 * Currently only used to set pixel format if not YUV420P.<br>
	 * C type : interleave_packet_callback*
	 */
	@Field(15) 
	public AVOutputFormat interleave_packet(Pointer<AVOutputFormat.interleave_packet_callback > interleave_packet) {
		this.io.setPointerField(this, 15, interleave_packet);
		return this;
	}
	/**
	 * Test if the given codec can be stored in this container.<br>
	 * * @return 1 if the codec is supported, 0 if it is not.<br>
	 *         A negative number if unknown.<br>
	 *         MKTAG('A', 'P', 'I', 'C') if the codec is only supported as AV_DISPOSITION_ATTACHED_PIC<br>
	 * C type : query_codec_callback*
	 */
	@Field(16) 
	public Pointer<AVOutputFormat.query_codec_callback > query_codec() {
		return this.io.getPointerField(this, 16);
	}
	/**
	 * Test if the given codec can be stored in this container.<br>
	 * * @return 1 if the codec is supported, 0 if it is not.<br>
	 *         A negative number if unknown.<br>
	 *         MKTAG('A', 'P', 'I', 'C') if the codec is only supported as AV_DISPOSITION_ATTACHED_PIC<br>
	 * C type : query_codec_callback*
	 */
	@Field(16) 
	public AVOutputFormat query_codec(Pointer<AVOutputFormat.query_codec_callback > query_codec) {
		this.io.setPointerField(this, 16, query_codec);
		return this;
	}
	/** C type : get_output_timestamp_callback* */
	@Field(17) 
	public Pointer<AVOutputFormat.get_output_timestamp_callback > get_output_timestamp() {
		return this.io.getPointerField(this, 17);
	}
	/** C type : get_output_timestamp_callback* */
	@Field(17) 
	public AVOutputFormat get_output_timestamp(Pointer<AVOutputFormat.get_output_timestamp_callback > get_output_timestamp) {
		this.io.setPointerField(this, 17, get_output_timestamp);
		return this;
	}
	/**
	 * Allows sending messages from application to device.<br>
	 * C type : control_message_callback*
	 */
	@Field(18) 
	public Pointer<AVOutputFormat.control_message_callback > control_message() {
		return this.io.getPointerField(this, 18);
	}
	/**
	 * Allows sending messages from application to device.<br>
	 * C type : control_message_callback*
	 */
	@Field(18) 
	public AVOutputFormat control_message(Pointer<AVOutputFormat.control_message_callback > control_message) {
		this.io.setPointerField(this, 18, control_message);
		return this;
	}
	/**
	 * Write an uncoded AVFrame.<br>
	 * * See av_write_uncoded_frame() for details.<br>
	 * * The library will free *frame afterwards, but the muxer can prevent it<br>
	 * by setting the pointer to NULL.<br>
	 * C type : write_uncoded_frame_callback*
	 */
	@Field(19) 
	public Pointer<AVOutputFormat.write_uncoded_frame_callback > write_uncoded_frame() {
		return this.io.getPointerField(this, 19);
	}
	/**
	 * Write an uncoded AVFrame.<br>
	 * * See av_write_uncoded_frame() for details.<br>
	 * * The library will free *frame afterwards, but the muxer can prevent it<br>
	 * by setting the pointer to NULL.<br>
	 * C type : write_uncoded_frame_callback*
	 */
	@Field(19) 
	public AVOutputFormat write_uncoded_frame(Pointer<AVOutputFormat.write_uncoded_frame_callback > write_uncoded_frame) {
		this.io.setPointerField(this, 19, write_uncoded_frame);
		return this;
	}
	/**
	 * Returns device list with it properties.<br>
	 * @see avdevice_list_devices() for more details.<br>
	 * C type : get_device_list_callback*
	 */
	@Field(20) 
	public Pointer<org.ffmpeg.avformat.AVInputFormat.get_device_list_callback > get_device_list() {
		return this.io.getPointerField(this, 20);
	}
	/**
	 * Returns device list with it properties.<br>
	 * @see avdevice_list_devices() for more details.<br>
	 * C type : get_device_list_callback*
	 */
	@Field(20) 
	public AVOutputFormat get_device_list(Pointer<org.ffmpeg.avformat.AVInputFormat.get_device_list_callback > get_device_list) {
		this.io.setPointerField(this, 20, get_device_list);
		return this;
	}
	/**
	 * Initialize device capabilities submodule.<br>
	 * @see avdevice_capabilities_create() for more details.<br>
	 * C type : create_device_capabilities_callback*
	 */
	@Field(21) 
	public Pointer<org.ffmpeg.avformat.AVInputFormat.create_device_capabilities_callback > create_device_capabilities() {
		return this.io.getPointerField(this, 21);
	}
	/**
	 * Initialize device capabilities submodule.<br>
	 * @see avdevice_capabilities_create() for more details.<br>
	 * C type : create_device_capabilities_callback*
	 */
	@Field(21) 
	public AVOutputFormat create_device_capabilities(Pointer<org.ffmpeg.avformat.AVInputFormat.create_device_capabilities_callback > create_device_capabilities) {
		this.io.setPointerField(this, 21, create_device_capabilities);
		return this;
	}
	/**
	 * Free device capabilities submodule.<br>
	 * @see avdevice_capabilities_free() for more details.<br>
	 * C type : free_device_capabilities_callback*
	 */
	@Field(22) 
	public Pointer<org.ffmpeg.avformat.AVInputFormat.free_device_capabilities_callback > free_device_capabilities() {
		return this.io.getPointerField(this, 22);
	}
	/**
	 * Free device capabilities submodule.<br>
	 * @see avdevice_capabilities_free() for more details.<br>
	 * C type : free_device_capabilities_callback*
	 */
	@Field(22) 
	public AVOutputFormat free_device_capabilities(Pointer<org.ffmpeg.avformat.AVInputFormat.free_device_capabilities_callback > free_device_capabilities) {
		this.io.setPointerField(this, 22, free_device_capabilities);
		return this;
	}
	/**
	 * < default data codec<br>
	 * C type : AVCodecID
	 */
	@Field(23) 
	public IntValuedEnum<AVCodecID > data_codec() {
		return this.io.getEnumField(this, 23);
	}
	/**
	 * < default data codec<br>
	 * C type : AVCodecID
	 */
	@Field(23) 
	public AVOutputFormat data_codec(IntValuedEnum<AVCodecID > data_codec) {
		this.io.setEnumField(this, 23, data_codec);
		return this;
	}
	/**
	 * Initialize format. May allocate data here, and set any AVFormatContext or<br>
	 * AVStream parameters that need to be set before packets are sent.<br>
	 * This method must not write output.<br>
	 * * Return 0 if streams were fully configured, 1 if not, negative AVERROR on failure<br>
	 * * Any allocations made here must be freed in deinit().<br>
	 * C type : init_callback*
	 */
	@Field(24) 
	public Pointer<org.ffmpeg.avfilter.AVFilter.init_callback > init() {
		return this.io.getPointerField(this, 24);
	}
	/**
	 * Initialize format. May allocate data here, and set any AVFormatContext or<br>
	 * AVStream parameters that need to be set before packets are sent.<br>
	 * This method must not write output.<br>
	 * * Return 0 if streams were fully configured, 1 if not, negative AVERROR on failure<br>
	 * * Any allocations made here must be freed in deinit().<br>
	 * C type : init_callback*
	 */
	@Field(24) 
	public AVOutputFormat init(Pointer<org.ffmpeg.avfilter.AVFilter.init_callback > init) {
		this.io.setPointerField(this, 24, init);
		return this;
	}
	/**
	 * Deinitialize format. If present, this is called whenever the muxer is being<br>
	 * destroyed, regardless of whether or not the header has been written.<br>
	 * * If a trailer is being written, this is called after write_trailer().<br>
	 * * This is called if init() fails as well.<br>
	 * C type : deinit_callback*
	 */
	@Field(25) 
	public Pointer<AVOutputFormat.deinit_callback > deinit() {
		return this.io.getPointerField(this, 25);
	}
	/**
	 * Deinitialize format. If present, this is called whenever the muxer is being<br>
	 * destroyed, regardless of whether or not the header has been written.<br>
	 * * If a trailer is being written, this is called after write_trailer().<br>
	 * * This is called if init() fails as well.<br>
	 * C type : deinit_callback*
	 */
	@Field(25) 
	public AVOutputFormat deinit(Pointer<AVOutputFormat.deinit_callback > deinit) {
		this.io.setPointerField(this, 25, deinit);
		return this;
	}
	/**
	 * Set up any necessary bitstream filtering and extract any extra data needed<br>
	 * for the global header.<br>
	 * Return 0 if more packets from this stream must be checked; 1 if not.<br>
	 * C type : check_bitstream_callback*
	 */
	@Field(26) 
	public Pointer<AVOutputFormat.check_bitstream_callback > check_bitstream() {
		return this.io.getPointerField(this, 26);
	}
	/**
	 * Set up any necessary bitstream filtering and extract any extra data needed<br>
	 * for the global header.<br>
	 * Return 0 if more packets from this stream must be checked; 1 if not.<br>
	 * C type : check_bitstream_callback*
	 */
	@Field(26) 
	public AVOutputFormat check_bitstream(Pointer<AVOutputFormat.check_bitstream_callback > check_bitstream) {
		this.io.setPointerField(this, 26, check_bitstream);
		return this;
	}
	/** <i>native declaration : libavformat/avformat.h:155</i> */
	public static abstract class write_header_callback extends Callback<write_header_callback > {
		public int apply(Pointer<AVFormatContext > AVFormatContextPtr1) {
			return apply(Pointer.getPeer(AVFormatContextPtr1));
		}
		public int apply(@Ptr long AVFormatContextPtr1) {
			return apply(Pointer.pointerToAddress(AVFormatContextPtr1, AVFormatContext.class));
		}
	};
	/** <i>native declaration : libavformat/avformat.h:156</i> */
	public static abstract class write_packet_callback extends Callback<write_packet_callback > {
		public int apply(Pointer<AVFormatContext > AVFormatContextPtr1, Pointer<AVPacket > pkt) {
			return apply(Pointer.getPeer(AVFormatContextPtr1), Pointer.getPeer(pkt));
		}
		public int apply(@Ptr long AVFormatContextPtr1, @Ptr long pkt) {
			return apply(Pointer.pointerToAddress(AVFormatContextPtr1, AVFormatContext.class), Pointer.pointerToAddress(pkt, AVPacket.class));
		}
	};
	/** <i>native declaration : libavformat/avformat.h:157</i> */
	public static abstract class write_trailer_callback extends Callback<write_trailer_callback > {
		public int apply(Pointer<AVFormatContext > AVFormatContextPtr1) {
			return apply(Pointer.getPeer(AVFormatContextPtr1));
		}
		public int apply(@Ptr long AVFormatContextPtr1) {
			return apply(Pointer.pointerToAddress(AVFormatContextPtr1, AVFormatContext.class));
		}
	};
	/** <i>native declaration : libavformat/avformat.h:158</i> */
	public static abstract class interleave_packet_callback extends Callback<interleave_packet_callback > {
		public int apply(Pointer<AVFormatContext > AVFormatContextPtr1, Pointer<AVPacket > out, Pointer<AVPacket > in, int flush) {
			return apply(Pointer.getPeer(AVFormatContextPtr1), Pointer.getPeer(out), Pointer.getPeer(in), flush);
		}
		public int apply(@Ptr long AVFormatContextPtr1, @Ptr long out, @Ptr long in, int flush) {
			return apply(Pointer.pointerToAddress(AVFormatContextPtr1, AVFormatContext.class), Pointer.pointerToAddress(out, AVPacket.class), Pointer.pointerToAddress(in, AVPacket.class), flush);
		}
	};
	/** <i>native declaration : libavformat/avformat.h:161</i> */
	public static abstract class query_codec_callback extends Callback<query_codec_callback > {
		public int apply(IntValuedEnum<AVCodecID > id, int std_compliance) {
			return apply((int)id.value(), std_compliance);
		}
		public int apply(int id, int std_compliance) {
			return apply(FlagSet.fromValue(id, AVCodecID.class), std_compliance);
		}
	};
	/** <i>native declaration : libavformat/avformat.h:162</i> */
	public static abstract class get_output_timestamp_callback extends Callback<get_output_timestamp_callback > {
		public void apply(Pointer<AVFormatContext > s, int stream, Pointer<Long > dts, Pointer<Long > wall) {
			apply(Pointer.getPeer(s), stream, Pointer.getPeer(dts), Pointer.getPeer(wall));
		}
		public void apply(@Ptr long s, int stream, @Ptr long dts, @Ptr long wall) {
			apply(Pointer.pointerToAddress(s, AVFormatContext.class), stream, Pointer.pointerToAddress(dts, Long.class), Pointer.pointerToAddress(wall, Long.class));
		}
	};
	/** <i>native declaration : libavformat/avformat.h:163</i> */
	public static abstract class control_message_callback extends Callback<control_message_callback > {
		public int apply(Pointer<AVFormatContext > s, int type, Pointer<? > data, @Ptr long data_size) {
			return apply(Pointer.getPeer(s), type, Pointer.getPeer(data), data_size);
		}
		public int apply(@Ptr long s, int type, @Ptr long data, @Ptr long data_size) {
			return apply(Pointer.pointerToAddress(s, AVFormatContext.class), type, Pointer.pointerToAddress(data), data_size);
		}
	};
	/** <i>native declaration : libavformat/avformat.h:164</i> */
	public static abstract class write_uncoded_frame_callback extends Callback<write_uncoded_frame_callback > {
		public int apply(Pointer<AVFormatContext > AVFormatContextPtr1, int stream_index, Pointer<Pointer > frame, int flags) {
			return apply(Pointer.getPeer(AVFormatContextPtr1), stream_index, Pointer.getPeer(frame), flags);
		}
		public int apply(@Ptr long AVFormatContextPtr1, int stream_index, @Ptr long frame, int flags) {
			return apply(Pointer.pointerToAddress(AVFormatContextPtr1, AVFormatContext.class), stream_index, Pointer.pointerToAddress(frame, Pointer.class), flags);
		}
	};
	/** <i>native declaration : libavformat/avformat.h:165</i> */
	public static abstract class get_device_list_callback extends Callback<get_device_list_callback > {
		public int apply(Pointer<AVFormatContext > s, Pointer<AVDeviceInfoList > device_list) {
			return apply(Pointer.getPeer(s), Pointer.getPeer(device_list));
		}
		public int apply(@Ptr long s, @Ptr long device_list) {
			return apply(Pointer.pointerToAddress(s, AVFormatContext.class), Pointer.pointerToAddress(device_list, AVDeviceInfoList.class));
		}
	};
	/** <i>native declaration : libavformat/avformat.h:166</i> */
	public static abstract class create_device_capabilities_callback extends Callback<create_device_capabilities_callback > {
		public int apply(Pointer<AVFormatContext > s, Pointer<AVDeviceCapabilitiesQuery > caps) {
			return apply(Pointer.getPeer(s), Pointer.getPeer(caps));
		}
		public int apply(@Ptr long s, @Ptr long caps) {
			return apply(Pointer.pointerToAddress(s, AVFormatContext.class), Pointer.pointerToAddress(caps, AVDeviceCapabilitiesQuery.class));
		}
	};
	/** <i>native declaration : libavformat/avformat.h:167</i> */
	public static abstract class free_device_capabilities_callback extends Callback<free_device_capabilities_callback > {
		public int apply(Pointer<AVFormatContext > s, Pointer<AVDeviceCapabilitiesQuery > caps) {
			return apply(Pointer.getPeer(s), Pointer.getPeer(caps));
		}
		public int apply(@Ptr long s, @Ptr long caps) {
			return apply(Pointer.pointerToAddress(s, AVFormatContext.class), Pointer.pointerToAddress(caps, AVDeviceCapabilitiesQuery.class));
		}
	};
	/** <i>native declaration : libavformat/avformat.h:170</i> */
	public static abstract class init_callback extends Callback<init_callback > {
		public int apply(Pointer<AVFormatContext > AVFormatContextPtr1) {
			return apply(Pointer.getPeer(AVFormatContextPtr1));
		}
		public int apply(@Ptr long AVFormatContextPtr1) {
			return apply(Pointer.pointerToAddress(AVFormatContextPtr1, AVFormatContext.class));
		}
	};
	/** <i>native declaration : libavformat/avformat.h:171</i> */
	public static abstract class deinit_callback extends Callback<deinit_callback > {
		public void apply(Pointer<AVFormatContext > AVFormatContextPtr1) {
			apply(Pointer.getPeer(AVFormatContextPtr1));
		}
		public void apply(@Ptr long AVFormatContextPtr1) {
			apply(Pointer.pointerToAddress(AVFormatContextPtr1, AVFormatContext.class));
		}
	};
	/** <i>native declaration : libavformat/avformat.h:172</i> */
	public static abstract class check_bitstream_callback extends Callback<check_bitstream_callback > {
		public int apply(Pointer<AVFormatContext > AVFormatContextPtr1, Pointer<AVPacket > pkt) {
			return apply(Pointer.getPeer(AVFormatContextPtr1), Pointer.getPeer(pkt));
		}
		public int apply(@Ptr long AVFormatContextPtr1, @Ptr long pkt) {
			return apply(Pointer.pointerToAddress(AVFormatContextPtr1, AVFormatContext.class), Pointer.pointerToAddress(pkt, AVPacket.class));
		}
	};
	public AVOutputFormat() {
		super();
	}
	public AVOutputFormat(Pointer pointer) {
		super(pointer);
	}
}
