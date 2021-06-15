package org.ffmpeg.avformat;
import org.bridj.BridJ;
import org.bridj.IntValuedEnum;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Array;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
import org.bridj.ann.Struct;
import org.ffmpeg.avcodec.AVCodecContext;
import org.ffmpeg.avcodec.AVCodecParameters;
import org.ffmpeg.avcodec.AVCodecParserContext;
import org.ffmpeg.avcodec.AVPacket;
import org.ffmpeg.avcodec.AVPacketSideData;
import org.ffmpeg.avcodec.AvcodecLibrary.AVDiscard;
import org.ffmpeg.avformat.AvformatLibrary.AVStreamParseType;
import org.ffmpeg.avutil.AVDictionary;
import org.ffmpeg.avutil.AVRational;
import org.ffmpeg.util.AlignmentCustomizer;
/**
 * <i>native declaration : libavformat/avformat.h:489</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("avformat") 
public class AVStream extends StructObject {
	static {
		BridJ.register();
	}
	/** < stream index in AVFormatContext */
	@Field(0) 
	public int index() {
		return this.io.getIntField(this, 0);
	}
	/** < stream index in AVFormatContext */
	@Field(0) 
	public AVStream index(int index) {
		this.io.setIntField(this, 0, index);
		return this;
	}
	/**
	 * Format-specific stream ID.<br>
	 * decoding: set by libavformat<br>
	 * encoding: set by the user, replaced by libavformat if left unset
	 */
	@Field(1) 
	public int id() {
		return this.io.getIntField(this, 1);
	}
	/**
	 * Format-specific stream ID.<br>
	 * decoding: set by libavformat<br>
	 * encoding: set by the user, replaced by libavformat if left unset
	 */
	@Field(1) 
	public AVStream id(int id) {
		this.io.setIntField(this, 1, id);
		return this;
	}
	/** C type : AVCodecContext* */
	@Field(2) 
	public Pointer<AVCodecContext > codec() {
		return this.io.getPointerField(this, 2);
	}
	/** C type : AVCodecContext* */
	@Field(2) 
	public AVStream codec(Pointer<AVCodecContext > codec) {
		this.io.setPointerField(this, 2, codec);
		return this;
	}
	/** C type : void* */
	@Field(3) 
	public Pointer<? > priv_data() {
		return this.io.getPointerField(this, 3);
	}
	/** C type : void* */
	@Field(3) 
	public AVStream priv_data(Pointer<? > priv_data) {
		this.io.setPointerField(this, 3, priv_data);
		return this;
	}
	/**
	 * This is the fundamental unit of time (in seconds) in terms<br>
	 * of which frame timestamps are represented.<br>
	 * * decoding: set by libavformat<br>
	 * encoding: May be set by the caller before avformat_write_header() to<br>
	 *           provide a hint to the muxer about the desired timebase. In<br>
	 *           avformat_write_header(), the muxer will overwrite this field<br>
	 *           with the timebase that will actually be used for the timestamps<br>
	 *           written into the file (which may or may not be related to the<br>
	 *           user-provided one, depending on the format).<br>
	 * C type : AVRational
	 */
	@Field(4) 
	public AVRational time_base() {
		return this.io.getNativeObjectField(this, 4);
	}
	/**
	 * This is the fundamental unit of time (in seconds) in terms<br>
	 * of which frame timestamps are represented.<br>
	 * * decoding: set by libavformat<br>
	 * encoding: May be set by the caller before avformat_write_header() to<br>
	 *           provide a hint to the muxer about the desired timebase. In<br>
	 *           avformat_write_header(), the muxer will overwrite this field<br>
	 *           with the timebase that will actually be used for the timestamps<br>
	 *           written into the file (which may or may not be related to the<br>
	 *           user-provided one, depending on the format).<br>
	 * C type : AVRational
	 */
	@Field(4) 
	public AVStream time_base(AVRational time_base) {
		this.io.setNativeObjectField(this, 4, time_base);
		return this;
	}
	/**
	 * Decoding: pts of the first frame of the stream in presentation order, in stream time base.<br>
	 * Only set this if you are absolutely 100% sure that the value you set<br>
	 * it to really is the pts of the first frame.<br>
	 * This may be undefined (AV_NOPTS_VALUE).<br>
	 * @note The ASF header does NOT contain a correct start_time the ASF<br>
	 * demuxer must NOT set this.
	 */
	@Field(5) 
	public long start_time() {
		return this.io.getLongField(this, 5);
	}
	/**
	 * Decoding: pts of the first frame of the stream in presentation order, in stream time base.<br>
	 * Only set this if you are absolutely 100% sure that the value you set<br>
	 * it to really is the pts of the first frame.<br>
	 * This may be undefined (AV_NOPTS_VALUE).<br>
	 * @note The ASF header does NOT contain a correct start_time the ASF<br>
	 * demuxer must NOT set this.
	 */
	@Field(5) 
	public AVStream start_time(long start_time) {
		this.io.setLongField(this, 5, start_time);
		return this;
	}
	/**
	 * Decoding: duration of the stream, in stream time base.<br>
	 * If a source file does not specify a duration, but does specify<br>
	 * a bitrate, this value will be estimated from bitrate and file size.<br>
	 * * Encoding: May be set by the caller before avformat_write_header() to<br>
	 * provide a hint to the muxer about the estimated duration.
	 */
	@Field(6) 
	public long duration() {
		return this.io.getLongField(this, 6);
	}
	/**
	 * Decoding: duration of the stream, in stream time base.<br>
	 * If a source file does not specify a duration, but does specify<br>
	 * a bitrate, this value will be estimated from bitrate and file size.<br>
	 * * Encoding: May be set by the caller before avformat_write_header() to<br>
	 * provide a hint to the muxer about the estimated duration.
	 */
	@Field(6) 
	public AVStream duration(long duration) {
		this.io.setLongField(this, 6, duration);
		return this;
	}
	/** < number of frames in this stream if known or 0 */
	@Field(7) 
	public long nb_frames() {
		return this.io.getLongField(this, 7);
	}
	/** < number of frames in this stream if known or 0 */
	@Field(7) 
	public AVStream nb_frames(long nb_frames) {
		this.io.setLongField(this, 7, nb_frames);
		return this;
	}
	/** < AV_DISPOSITION_* bit field */
	@Field(8) 
	public int disposition() {
		return this.io.getIntField(this, 8);
	}
	/** < AV_DISPOSITION_* bit field */
	@Field(8) 
	public AVStream disposition(int disposition) {
		this.io.setIntField(this, 8, disposition);
		return this;
	}
	/**
	 * < Selects which packets can be discarded at will and do not need to be demuxed.<br>
	 * C type : AVDiscard
	 */
	@Field(9) 
	public IntValuedEnum<AVDiscard > discard() {
		return this.io.getEnumField(this, 9);
	}
	/**
	 * < Selects which packets can be discarded at will and do not need to be demuxed.<br>
	 * C type : AVDiscard
	 */
	@Field(9) 
	public AVStream discard(IntValuedEnum<AVDiscard > discard) {
		this.io.setEnumField(this, 9, discard);
		return this;
	}
	/**
	 * sample aspect ratio (0 if unknown)<br>
	 * - encoding: Set by user.<br>
	 * - decoding: Set by libavformat.<br>
	 * C type : AVRational
	 */
	@Field(10) 
	public AVRational sample_aspect_ratio() {
		return this.io.getNativeObjectField(this, 10);
	}
	/**
	 * sample aspect ratio (0 if unknown)<br>
	 * - encoding: Set by user.<br>
	 * - decoding: Set by libavformat.<br>
	 * C type : AVRational
	 */
	@Field(10) 
	public AVStream sample_aspect_ratio(AVRational sample_aspect_ratio) {
		this.io.setNativeObjectField(this, 10, sample_aspect_ratio);
		return this;
	}
	/** C type : AVDictionary* */
	@Field(11) 
	public Pointer<AVDictionary > metadata() {
		return this.io.getPointerField(this, 11);
	}
	/** C type : AVDictionary* */
	@Field(11) 
	public AVStream metadata(Pointer<AVDictionary > metadata) {
		this.io.setPointerField(this, 11, metadata);
		return this;
	}
	/**
	 * Average framerate<br>
	 * * - demuxing: May be set by libavformat when creating the stream or in<br>
	 *             avformat_find_stream_info().<br>
	 * - muxing: May be set by the caller before avformat_write_header().<br>
	 * C type : AVRational
	 */
	@Field(12) 
	public AVRational avg_frame_rate() {
		return this.io.getNativeObjectField(this, 12);
	}
	/**
	 * Average framerate<br>
	 * * - demuxing: May be set by libavformat when creating the stream or in<br>
	 *             avformat_find_stream_info().<br>
	 * - muxing: May be set by the caller before avformat_write_header().<br>
	 * C type : AVRational
	 */
	@Field(12) 
	public AVStream avg_frame_rate(AVRational avg_frame_rate) {
		this.io.setNativeObjectField(this, 12, avg_frame_rate);
		return this;
	}
	/**
	 * For streams with AV_DISPOSITION_ATTACHED_PIC disposition, this packet<br>
	 * will contain the attached picture.<br>
	 * * decoding: set by libavformat, must not be modified by the caller.<br>
	 * encoding: unused<br>
	 * C type : AVPacket
	 */
	@Field(13) 
	public AVPacket attached_pic() {
		return this.io.getNativeObjectField(this, 13);
	}
	/**
	 * For streams with AV_DISPOSITION_ATTACHED_PIC disposition, this packet<br>
	 * will contain the attached picture.<br>
	 * * decoding: set by libavformat, must not be modified by the caller.<br>
	 * encoding: unused<br>
	 * C type : AVPacket
	 */
	@Field(13) 
	public AVStream attached_pic(AVPacket attached_pic) {
		this.io.setNativeObjectField(this, 13, attached_pic);
		return this;
	}
	/**
	 * An array of side data that applies to the whole stream (i.e. the<br>
	 * container does not allow it to change between packets).<br>
	 * * There may be no overlap between the side data in this array and side data<br>
	 * in the packets. I.e. a given side data is either exported by the muxer<br>
	 * (demuxing) / set by the caller (muxing) in this array, then it never<br>
	 * appears in the packets, or the side data is exported / sent through<br>
	 * the packets (always in the first packet where the value becomes known or<br>
	 * changes), then it does not appear in this array.<br>
	 * * - demuxing: Set by libavformat when the stream is created.<br>
	 * - muxing: May be set by the caller before avformat_write_header().<br>
	 * * Freed by libavformat in avformat_free_context().<br>
	 * * @see av_format_inject_global_side_data()<br>
	 * C type : AVPacketSideData*
	 */
	@Field(14) 
	public Pointer<AVPacketSideData > side_data() {
		return this.io.getPointerField(this, 14);
	}
	/**
	 * An array of side data that applies to the whole stream (i.e. the<br>
	 * container does not allow it to change between packets).<br>
	 * * There may be no overlap between the side data in this array and side data<br>
	 * in the packets. I.e. a given side data is either exported by the muxer<br>
	 * (demuxing) / set by the caller (muxing) in this array, then it never<br>
	 * appears in the packets, or the side data is exported / sent through<br>
	 * the packets (always in the first packet where the value becomes known or<br>
	 * changes), then it does not appear in this array.<br>
	 * * - demuxing: Set by libavformat when the stream is created.<br>
	 * - muxing: May be set by the caller before avformat_write_header().<br>
	 * * Freed by libavformat in avformat_free_context().<br>
	 * * @see av_format_inject_global_side_data()<br>
	 * C type : AVPacketSideData*
	 */
	@Field(14) 
	public AVStream side_data(Pointer<AVPacketSideData > side_data) {
		this.io.setPointerField(this, 14, side_data);
		return this;
	}
	/** The number of elements in the AVStream.side_data array. */
	@Field(15) 
	public int nb_side_data() {
		return this.io.getIntField(this, 15);
	}
	/** The number of elements in the AVStream.side_data array. */
	@Field(15) 
	public AVStream nb_side_data(int nb_side_data) {
		this.io.setIntField(this, 15, nb_side_data);
		return this;
	}
	/**
	 * Flags indicating events happening on the stream, a combination of<br>
	 * AVSTREAM_EVENT_FLAG_*.<br>
	 * * - demuxing: may be set by the demuxer in avformat_open_input(),<br>
	 *   avformat_find_stream_info() and av_read_frame(). Flags must be cleared<br>
	 *   by the user once the event has been handled.<br>
	 * - muxing: may be set by the user after avformat_write_header(). to<br>
	 *   indicate a user-triggered event.  The muxer will clear the flags for<br>
	 *   events it has handled in av_[interleaved]_write_frame().
	 */
	@Field(16) 
	public int event_flags() {
		return this.io.getIntField(this, 16);
	}
	/**
	 * Flags indicating events happening on the stream, a combination of<br>
	 * AVSTREAM_EVENT_FLAG_*.<br>
	 * * - demuxing: may be set by the demuxer in avformat_open_input(),<br>
	 *   avformat_find_stream_info() and av_read_frame(). Flags must be cleared<br>
	 *   by the user once the event has been handled.<br>
	 * - muxing: may be set by the user after avformat_write_header(). to<br>
	 *   indicate a user-triggered event.  The muxer will clear the flags for<br>
	 *   events it has handled in av_[interleaved]_write_frame().
	 */
	@Field(16) 
	public AVStream event_flags(int event_flags) {
		this.io.setIntField(this, 16, event_flags);
		return this;
	}
	/**
	 * Real base framerate of the stream.<br>
	 * This is the lowest framerate with which all timestamps can be<br>
	 * represented accurately (it is the least common multiple of all<br>
	 * framerates in the stream). Note, this value is just a guess!<br>
	 * For example, if the time base is 1/90000 and all frames have either<br>
	 * approximately 3600 or 1800 timer ticks, then r_frame_rate will be 50/1.<br>
	 * C type : AVRational
	 */
	@Field(17) 
	public AVRational r_frame_rate() {
		return this.io.getNativeObjectField(this, 17);
	}
	/**
	 * Real base framerate of the stream.<br>
	 * This is the lowest framerate with which all timestamps can be<br>
	 * represented accurately (it is the least common multiple of all<br>
	 * framerates in the stream). Note, this value is just a guess!<br>
	 * For example, if the time base is 1/90000 and all frames have either<br>
	 * approximately 3600 or 1800 timer ticks, then r_frame_rate will be 50/1.<br>
	 * C type : AVRational
	 */
	@Field(17) 
	public AVStream r_frame_rate(AVRational r_frame_rate) {
		this.io.setNativeObjectField(this, 17, r_frame_rate);
		return this;
	}
	/** C type : char* */
	@Field(18) 
	public Pointer<Byte > recommended_encoder_configuration() {
		return this.io.getPointerField(this, 18);
	}
	/** C type : char* */
	@Field(18) 
	public AVStream recommended_encoder_configuration(Pointer<Byte > recommended_encoder_configuration) {
		this.io.setPointerField(this, 18, recommended_encoder_configuration);
		return this;
	}
	/**
	 * Codec parameters associated with this stream. Allocated and freed by<br>
	 * libavformat in avformat_new_stream() and avformat_free_context()<br>
	 * respectively.<br>
	 * * - demuxing: filled by libavformat on stream creation or in<br>
	 *             avformat_find_stream_info()<br>
	 * - muxing: filled by the caller before avformat_write_header()<br>
	 * C type : AVCodecParameters*
	 */
	@Field(19) 
	public Pointer<AVCodecParameters > codecpar() {
		return this.io.getPointerField(this, 19);
	}
	/**
	 * Codec parameters associated with this stream. Allocated and freed by<br>
	 * libavformat in avformat_new_stream() and avformat_free_context()<br>
	 * respectively.<br>
	 * * - demuxing: filled by libavformat on stream creation or in<br>
	 *             avformat_find_stream_info()<br>
	 * - muxing: filled by the caller before avformat_write_header()<br>
	 * C type : AVCodecParameters*
	 */
	@Field(19) 
	public AVStream codecpar(Pointer<AVCodecParameters > codecpar) {
		this.io.setPointerField(this, 19, codecpar);
		return this;
	}
	/**
	 * kept for ABI compatibility only, do not access in any way<br>
	 * C type : void*
	 */
	@Field(20) 
	public Pointer<? > unused() {
		return this.io.getPointerField(this, 20);
	}
	/**
	 * kept for ABI compatibility only, do not access in any way<br>
	 * C type : void*
	 */
	@Field(20) 
	public AVStream unused(Pointer<? > unused) {
		this.io.setPointerField(this, 20, unused);
		return this;
	}
	/** < number of bits in pts (used for wrapping control) */
	@Field(21) 
	public int pts_wrap_bits() {
		return this.io.getIntField(this, 21);
	}
	/** < number of bits in pts (used for wrapping control) */
	@Field(21) 
	public AVStream pts_wrap_bits(int pts_wrap_bits) {
		this.io.setIntField(this, 21, pts_wrap_bits);
		return this;
	}
	/**
	 * Timestamp corresponding to the last dts sync point.<br>
	 * * Initialized when AVCodecParserContext.dts_sync_point >= 0 and<br>
	 * a DTS is received from the underlying container. Otherwise set to<br>
	 * AV_NOPTS_VALUE by default.
	 */
	@Field(22) 
	public long first_dts() {
		return this.io.getLongField(this, 22);
	}
	/**
	 * Timestamp corresponding to the last dts sync point.<br>
	 * * Initialized when AVCodecParserContext.dts_sync_point >= 0 and<br>
	 * a DTS is received from the underlying container. Otherwise set to<br>
	 * AV_NOPTS_VALUE by default.
	 */
	@Field(22) 
	public AVStream first_dts(long first_dts) {
		this.io.setLongField(this, 22, first_dts);
		return this;
	}
	@Field(23) 
	public long cur_dts() {
		return this.io.getLongField(this, 23);
	}
	@Field(23) 
	public AVStream cur_dts(long cur_dts) {
		this.io.setLongField(this, 23, cur_dts);
		return this;
	}
	@Field(24) 
	public long last_IP_pts() {
		return this.io.getLongField(this, 24);
	}
	@Field(24) 
	public AVStream last_IP_pts(long last_IP_pts) {
		this.io.setLongField(this, 24, last_IP_pts);
		return this;
	}
	@Field(25) 
	public int last_IP_duration() {
		return this.io.getIntField(this, 25);
	}
	@Field(25) 
	public AVStream last_IP_duration(int last_IP_duration) {
		this.io.setIntField(this, 25, last_IP_duration);
		return this;
	}
	/** Number of packets to buffer for codec probing */
	@Field(26) 
	public int probe_packets() {
		return this.io.getIntField(this, 26);
	}
	/** Number of packets to buffer for codec probing */
	@Field(26) 
	public AVStream probe_packets(int probe_packets) {
		this.io.setIntField(this, 26, probe_packets);
		return this;
	}
	/** Number of frames that have been demuxed during avformat_find_stream_info() */
	@Field(27) 
	public int codec_info_nb_frames() {
		return this.io.getIntField(this, 27);
	}
	/** Number of frames that have been demuxed during avformat_find_stream_info() */
	@Field(27) 
	public AVStream codec_info_nb_frames(int codec_info_nb_frames) {
		this.io.setIntField(this, 27, codec_info_nb_frames);
		return this;
	}
	/**
	 * av_read_frame() support<br>
	 * C type : AVStreamParseType
	 */
	@Field(28) 
	public IntValuedEnum<AVStreamParseType > need_parsing() {
		return this.io.getEnumField(this, 28);
	}
	/**
	 * av_read_frame() support<br>
	 * C type : AVStreamParseType
	 */
	@Field(28) 
	public AVStream need_parsing(IntValuedEnum<AVStreamParseType > need_parsing) {
		this.io.setEnumField(this, 28, need_parsing);
		return this;
	}
	/** C type : AVCodecParserContext* */
	@Field(29) 
	public Pointer<AVCodecParserContext > parser() {
		return this.io.getPointerField(this, 29);
	}
	/** C type : AVCodecParserContext* */
	@Field(29) 
	public AVStream parser(Pointer<AVCodecParserContext > parser) {
		this.io.setPointerField(this, 29, parser);
		return this;
	}
	/**
	 * kept for ABI compatibility only, do not access in any way<br>
	 * C type : void*
	 */
	@Field(30) 
	public Pointer<? > unused7() {
		return this.io.getPointerField(this, 30);
	}
	/**
	 * kept for ABI compatibility only, do not access in any way<br>
	 * C type : void*
	 */
	@Field(30) 
	public AVStream unused7(Pointer<? > unused7) {
		this.io.setPointerField(this, 30, unused7);
		return this;
	}
	/** C type : AVProbeData */
	@Field(31) 
	public AVProbeData unused6() {
		return this.io.getNativeObjectField(this, 31);
	}
	/** C type : AVProbeData */
	@Field(31) 
	public AVStream unused6(AVProbeData unused6) {
		this.io.setNativeObjectField(this, 31, unused6);
		return this;
	}
	/** C type : int64_t[16 + 1] */
	@Array({16 + 1}) 
	@Field(32) 
	public Pointer<Long > unused5() {
		return this.io.getPointerField(this, 32);
	}
	/**
	 * < Only used if the format does not<br>
	 * support seeking natively.<br>
	 * C type : AVIndexEntry*
	 */
	@Field(33) 
	public Pointer<AVIndexEntry > index_entries() {
		return this.io.getPointerField(this, 33);
	}
	/**
	 * < Only used if the format does not<br>
	 * support seeking natively.<br>
	 * C type : AVIndexEntry*
	 */
	@Field(33) 
	public AVStream index_entries(Pointer<AVIndexEntry > index_entries) {
		this.io.setPointerField(this, 33, index_entries);
		return this;
	}
	@Field(34) 
	public int nb_index_entries() {
		return this.io.getIntField(this, 34);
	}
	@Field(34) 
	public AVStream nb_index_entries(int nb_index_entries) {
		this.io.setIntField(this, 34, nb_index_entries);
		return this;
	}
	@Field(35) 
	public int index_entries_allocated_size() {
		return this.io.getIntField(this, 35);
	}
	@Field(35) 
	public AVStream index_entries_allocated_size(int index_entries_allocated_size) {
		this.io.setIntField(this, 35, index_entries_allocated_size);
		return this;
	}
	/**
	 * Stream Identifier<br>
	 * This is the MPEG-TS stream identifier +1<br>
	 * 0 means unknown
	 */
	@Field(36) 
	public int stream_identifier() {
		return this.io.getIntField(this, 36);
	}
	/**
	 * Stream Identifier<br>
	 * This is the MPEG-TS stream identifier +1<br>
	 * 0 means unknown
	 */
	@Field(36) 
	public AVStream stream_identifier(int stream_identifier) {
		this.io.setIntField(this, 36, stream_identifier);
		return this;
	}
	/** kept for ABI compatibility only, do not access in any way */
	@Field(37) 
	public int unused8() {
		return this.io.getIntField(this, 37);
	}
	/** kept for ABI compatibility only, do not access in any way */
	@Field(37) 
	public AVStream unused8(int unused8) {
		this.io.setIntField(this, 37, unused8);
		return this;
	}
	@Field(38) 
	public int unused9() {
		return this.io.getIntField(this, 38);
	}
	@Field(38) 
	public AVStream unused9(int unused9) {
		this.io.setIntField(this, 38, unused9);
		return this;
	}
	@Field(39) 
	public int unused10() {
		return this.io.getIntField(this, 39);
	}
	@Field(39) 
	public AVStream unused10(int unused10) {
		this.io.setIntField(this, 39, unused10);
		return this;
	}
	/**
	 * An opaque field for libavformat internal usage.<br>
	 * Must not be accessed in any way by callers.<br>
	 * C type : AVStreamInternal*
	 */
	@Field(40) 
	public Pointer<AVStreamInternal > internal() {
		return this.io.getPointerField(this, 40);
	}
	/**
	 * An opaque field for libavformat internal usage.<br>
	 * Must not be accessed in any way by callers.<br>
	 * C type : AVStreamInternal*
	 */
	@Field(40) 
	public AVStream internal(Pointer<AVStreamInternal > internal) {
		this.io.setPointerField(this, 40, internal);
		return this;
	}
	public AVStream() {
		super();
	}
	public AVStream(Pointer pointer) {
		super(pointer);
	}
}
