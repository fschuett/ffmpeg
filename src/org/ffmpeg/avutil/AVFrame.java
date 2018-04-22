package org.ffmpeg.avutil;
import java.util.List;
import org.bridj.StructFieldDescription;
import org.bridj.ann.Alignment;
import org.bridj.ann.Struct;
import org.ffmpeg.util.AlignmentCustomizer;
import org.bridj.BridJ;
import org.bridj.IntValuedEnum;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Array;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
import org.bridj.ann.Ptr;
import org.ffmpeg.avutil.AvutilLibrary.AVChromaLocation;
import org.ffmpeg.avutil.AvutilLibrary.AVColorPrimaries;
import org.ffmpeg.avutil.AvutilLibrary.AVColorRange;
import org.ffmpeg.avutil.AvutilLibrary.AVColorSpace;
import org.ffmpeg.avutil.AvutilLibrary.AVColorTransferCharacteristic;
import org.ffmpeg.avutil.AvutilLibrary.AVPictureType;
/**
 * <i>native declaration : libavutil/frame.h:387</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("avutil") 
public class AVFrame extends StructObject {
	static {
		BridJ.register();
	}
	/**
	 * pointer to the picture/channel planes.<br>
	 * This might be different from the first allocated byte<br>
	 * * Some decoders access areas outside 0,0 - width,height, please<br>
	 * see avcodec_align_dimensions2(). Some filters and swscale can read<br>
	 * up to 16 bytes beyond the planes, if these filters are to be used,<br>
	 * then 16 extra bytes must be allocated.<br>
	 * * NOTE: Except for hwaccel formats, pointers not needed by the format<br>
	 * MUST be set to NULL.<br>
	 * C type : uint8_t*[8]
	 */
	@Array({8}) 
	@Field(0) 
	public Pointer<Pointer<Byte > > data() {
		return this.io.getPointerField(this, 0);
	}
	/**
	 * For video, size in bytes of each picture line.<br>
	 * For audio, size in bytes of each plane.<br>
	 * * For audio, only linesize[0] may be set. For planar audio, each channel<br>
	 * plane must be the same size.<br>
	 * * For video the linesizes should be multiples of the CPUs alignment<br>
	 * preference, this is 16 or 32 for modern desktop CPUs.<br>
	 * Some code requires such alignment other code can be slower without<br>
	 * correct alignment, for yet other it makes no difference.<br>
	 * * @note The linesize may be larger than the size of usable data -- there<br>
	 * may be extra padding present for performance reasons.<br>
	 * C type : int[8]
	 */
	@Array({8}) 
	@Field(1) 
	public Pointer<Integer > linesize() {
		return this.io.getPointerField(this, 1);
	}
	/**
	 * pointers to the data planes/channels.<br>
	 * * For video, this should simply point to data[].<br>
	 * * For planar audio, each channel has a separate data pointer, and<br>
	 * linesize[0] contains the size of each channel buffer.<br>
	 * For packed audio, there is just one data pointer, and linesize[0]<br>
	 * contains the total size of the buffer for all channels.<br>
	 * * Note: Both data and extended_data should always be set in a valid frame,<br>
	 * but for planar audio with more channels that can fit in data,<br>
	 * extended_data must be used in order to access all channels.<br>
	 * C type : uint8_t**
	 */
	@Field(2) 
	public Pointer<Pointer<Byte > > extended_data() {
		return this.io.getPointerField(this, 2);
	}
	/**
	 * pointers to the data planes/channels.<br>
	 * * For video, this should simply point to data[].<br>
	 * * For planar audio, each channel has a separate data pointer, and<br>
	 * linesize[0] contains the size of each channel buffer.<br>
	 * For packed audio, there is just one data pointer, and linesize[0]<br>
	 * contains the total size of the buffer for all channels.<br>
	 * * Note: Both data and extended_data should always be set in a valid frame,<br>
	 * but for planar audio with more channels that can fit in data,<br>
	 * extended_data must be used in order to access all channels.<br>
	 * C type : uint8_t**
	 */
	@Field(2) 
	public AVFrame extended_data(Pointer<Pointer<Byte > > extended_data) {
		this.io.setPointerField(this, 2, extended_data);
		return this;
	}
	/**
	 * @name Video dimensions<br>
	 * Video frames only. The coded dimensions (in pixels) of the video frame,<br>
	 * i.e. the size of the rectangle that contains some well-defined values.<br>
	 * * @note The part of the frame intended for display/presentation is further<br>
	 * restricted by the @ref cropping "Cropping rectangle".<br>
	 * @{
	 */
	@Field(3) 
	public int width() {
		return this.io.getIntField(this, 3);
	}
	/**
	 * @name Video dimensions<br>
	 * Video frames only. The coded dimensions (in pixels) of the video frame,<br>
	 * i.e. the size of the rectangle that contains some well-defined values.<br>
	 * * @note The part of the frame intended for display/presentation is further<br>
	 * restricted by the @ref cropping "Cropping rectangle".<br>
	 * @{
	 */
	@Field(3) 
	public AVFrame width(int width) {
		this.io.setIntField(this, 3, width);
		return this;
	}
	/**
	 * @name Video dimensions<br>
	 * Video frames only. The coded dimensions (in pixels) of the video frame,<br>
	 * i.e. the size of the rectangle that contains some well-defined values.<br>
	 * * @note The part of the frame intended for display/presentation is further<br>
	 * restricted by the @ref cropping "Cropping rectangle".<br>
	 * @{
	 */
	@Field(4) 
	public int height() {
		return this.io.getIntField(this, 4);
	}
	/**
	 * @name Video dimensions<br>
	 * Video frames only. The coded dimensions (in pixels) of the video frame,<br>
	 * i.e. the size of the rectangle that contains some well-defined values.<br>
	 * * @note The part of the frame intended for display/presentation is further<br>
	 * restricted by the @ref cropping "Cropping rectangle".<br>
	 * @{
	 */
	@Field(4) 
	public AVFrame height(int height) {
		this.io.setIntField(this, 4, height);
		return this;
	}
	/** number of audio samples (per channel) described by this frame */
	@Field(5) 
	public int nb_samples() {
		return this.io.getIntField(this, 5);
	}
	/** number of audio samples (per channel) described by this frame */
	@Field(5) 
	public AVFrame nb_samples(int nb_samples) {
		this.io.setIntField(this, 5, nb_samples);
		return this;
	}
	/**
	 * format of the frame, -1 if unknown or unset<br>
	 * Values correspond to enum AVPixelFormat for video frames,<br>
	 * enum AVSampleFormat for audio)
	 */
	@Field(6) 
	public int format() {
		return this.io.getIntField(this, 6);
	}
	/**
	 * format of the frame, -1 if unknown or unset<br>
	 * Values correspond to enum AVPixelFormat for video frames,<br>
	 * enum AVSampleFormat for audio)
	 */
	@Field(6) 
	public AVFrame format(int format) {
		this.io.setIntField(this, 6, format);
		return this;
	}
	/** 1 -> keyframe, 0-> not */
	@Field(7) 
	public int key_frame() {
		return this.io.getIntField(this, 7);
	}
	/** 1 -> keyframe, 0-> not */
	@Field(7) 
	public AVFrame key_frame(int key_frame) {
		this.io.setIntField(this, 7, key_frame);
		return this;
	}
	/**
	 * Picture type of the frame.<br>
	 * C type : AVPictureType
	 */
	@Field(8) 
	public IntValuedEnum<AVPictureType > pict_type() {
		return this.io.getEnumField(this, 8);
	}
	/**
	 * Picture type of the frame.<br>
	 * C type : AVPictureType
	 */
	@Field(8) 
	public AVFrame pict_type(IntValuedEnum<AVPictureType > pict_type) {
		this.io.setEnumField(this, 8, pict_type);
		return this;
	}
	/**
	 * Sample aspect ratio for the video frame, 0/1 if unknown/unspecified.<br>
	 * C type : AVRational
	 */
	@Field(9) 
	public AVRational sample_aspect_ratio() {
		return this.io.getNativeObjectField(this, 9);
	}
	/**
	 * Sample aspect ratio for the video frame, 0/1 if unknown/unspecified.<br>
	 * C type : AVRational
	 */
	@Field(9) 
	public AVFrame sample_aspect_ratio(AVRational sample_aspect_ratio) {
		this.io.setNativeObjectField(this, 9, sample_aspect_ratio);
		return this;
	}
	/** Presentation timestamp in time_base units (time when frame should be shown to user). */
	@Alignment(4)
	@Field(10) 
	public long pts() {
		return this.io.getLongField(this, 10);
	}
	/** Presentation timestamp in time_base units (time when frame should be shown to user). */
	@Alignment(4)
	@Field(10) 
	public AVFrame pts(long pts) {
		this.io.setLongField(this, 10, pts);
		return this;
	}
	/**
	 * PTS copied from the AVPacket that was decoded to produce this frame.<br>
	 * @deprecated use the pts field instead
	 */
	@Alignment(4)
	@Field(11) 
	public long pkt_pts() {
		return this.io.getLongField(this, 11);
	}
	/**
	 * PTS copied from the AVPacket that was decoded to produce this frame.<br>
	 * @deprecated use the pts field instead
	 */
	@Alignment(4)
	@Field(11) 
	public AVFrame pkt_pts(long pkt_pts) {
		this.io.setLongField(this, 11, pkt_pts);
		return this;
	}
	/**
	 * DTS copied from the AVPacket that triggered returning this frame. (if frame threading isn't used)<br>
	 * This is also the Presentation time of this AVFrame calculated from<br>
	 * only AVPacket.dts values without pts values.
	 */
	@Alignment(4)
 	@Field(12) 
	public long pkt_dts() {
		return this.io.getLongField(this, 12);
	}
	/**
	 * DTS copied from the AVPacket that triggered returning this frame. (if frame threading isn't used)<br>
	 * This is also the Presentation time of this AVFrame calculated from<br>
	 * only AVPacket.dts values without pts values.
	 */
	@Alignment(4)
 	@Field(12) 
	public AVFrame pkt_dts(long pkt_dts) {
		this.io.setLongField(this, 12, pkt_dts);
		return this;
	}
	/** picture number in bitstream order */
	@Field(13) 
	public int coded_picture_number() {
		return this.io.getIntField(this, 13);
	}
	/** picture number in bitstream order */
	@Field(13) 
	public AVFrame coded_picture_number(int coded_picture_number) {
		this.io.setIntField(this, 13, coded_picture_number);
		return this;
	}
	/** picture number in display order */
	@Field(14) 
	public int display_picture_number() {
		return this.io.getIntField(this, 14);
	}
	/** picture number in display order */
	@Field(14) 
	public AVFrame display_picture_number(int display_picture_number) {
		this.io.setIntField(this, 14, display_picture_number);
		return this;
	}
	/** quality (between 1 (good) and FF_LAMBDA_MAX (bad)) */
	@Field(15) 
	public int quality() {
		return this.io.getIntField(this, 15);
	}
	/** quality (between 1 (good) and FF_LAMBDA_MAX (bad)) */
	@Field(15) 
	public AVFrame quality(int quality) {
		this.io.setIntField(this, 15, quality);
		return this;
	}
	/**
	 * for some private data of the user<br>
	 * C type : void*
	 */
	@Field(16) 
	public Pointer<? > opaque() {
		return this.io.getPointerField(this, 16);
	}
	/**
	 * for some private data of the user<br>
	 * C type : void*
	 */
	@Field(16) 
	public AVFrame opaque(Pointer<? > opaque) {
		this.io.setPointerField(this, 16, opaque);
		return this;
	}
	/**
	 * @deprecated unused<br>
	 * C type : uint64_t[8]
	 */
	@Array({8}) 
	@Field(17) 
	public Pointer<Long > error() {
		return this.io.getPointerField(this, 17);
	}
	/**
	 * When decoding, this signals how much the picture must be delayed.<br>
	 * extra_delay = repeat_pict / (2*fps)
	 */
	@Field(18) 
	public int repeat_pict() {
		return this.io.getIntField(this, 18);
	}
	/**
	 * When decoding, this signals how much the picture must be delayed.<br>
	 * extra_delay = repeat_pict / (2*fps)
	 */
	@Field(18) 
	public AVFrame repeat_pict(int repeat_pict) {
		this.io.setIntField(this, 18, repeat_pict);
		return this;
	}
	/** The content of the picture is interlaced. */
	@Field(19) 
	public int interlaced_frame() {
		return this.io.getIntField(this, 19);
	}
	/** The content of the picture is interlaced. */
	@Field(19) 
	public AVFrame interlaced_frame(int interlaced_frame) {
		this.io.setIntField(this, 19, interlaced_frame);
		return this;
	}
	/** If the content is interlaced, is top field displayed first. */
	@Field(20) 
	public int top_field_first() {
		return this.io.getIntField(this, 20);
	}
	/** If the content is interlaced, is top field displayed first. */
	@Field(20) 
	public AVFrame top_field_first(int top_field_first) {
		this.io.setIntField(this, 20, top_field_first);
		return this;
	}
	/** Tell user application that palette has changed from previous frame. */
	@Field(21) 
	public int palette_has_changed() {
		return this.io.getIntField(this, 21);
	}
	/** Tell user application that palette has changed from previous frame. */
	@Field(21) 
	public AVFrame palette_has_changed(int palette_has_changed) {
		this.io.setIntField(this, 21, palette_has_changed);
		return this;
	}
	/**
	 * reordered opaque 64 bits (generally an integer or a double precision float<br>
	 * PTS but can be anything).<br>
	 * The user sets AVCodecContext.reordered_opaque to represent the input at<br>
	 * that time,<br>
	 * the decoder reorders values as needed and sets AVFrame.reordered_opaque<br>
	 * to exactly one of the values provided by the user through AVCodecContext.reordered_opaque<br>
	 * @deprecated in favor of pkt_pts
	 */
	@Alignment(4)
 	@Field(22) 
	public long reordered_opaque() {
		return this.io.getLongField(this, 22);
	}
	/**
	 * reordered opaque 64 bits (generally an integer or a double precision float<br>
	 * PTS but can be anything).<br>
	 * The user sets AVCodecContext.reordered_opaque to represent the input at<br>
	 * that time,<br>
	 * the decoder reorders values as needed and sets AVFrame.reordered_opaque<br>
	 * to exactly one of the values provided by the user through AVCodecContext.reordered_opaque<br>
	 * @deprecated in favor of pkt_pts
	 */
	@Alignment(4)
 	@Field(22) 
	public AVFrame reordered_opaque(long reordered_opaque) {
		this.io.setLongField(this, 22, reordered_opaque);
		return this;
	}
	/** Sample rate of the audio data. */
	@Field(23) 
	public int sample_rate() {
		return this.io.getIntField(this, 23);
	}
	/** Sample rate of the audio data. */
	@Field(23) 
	public AVFrame sample_rate(int sample_rate) {
		this.io.setIntField(this, 23, sample_rate);
		return this;
	}
	/** Channel layout of the audio data. */
	@Field(24) 
	public long channel_layout() {
		return this.io.getLongField(this, 24);
	}
	/** Channel layout of the audio data. */
	@Field(24) 
	public AVFrame channel_layout(long channel_layout) {
		this.io.setLongField(this, 24, channel_layout);
		return this;
	}
	/**
	 * AVBuffer references backing the data for this frame. If all elements of<br>
	 * this array are NULL, then this frame is not reference counted. This array<br>
	 * must be filled contiguously -- if buf[i] is non-NULL then buf[j] must<br>
	 * also be non-NULL for all j < i.<br>
	 * * There may be at most one AVBuffer per data plane, so for video this array<br>
	 * always contains all the references. For planar audio with more than<br>
	 * AV_NUM_DATA_POINTERS channels, there may be more buffers than can fit in<br>
	 * this array. Then the extra AVBufferRef pointers are stored in the<br>
	 * extended_buf array.<br>
	 * C type : AVBufferRef*[8]
	 */
	@Array({8}) 
	@Field(25) 
	public Pointer<Pointer<AVBufferRef > > buf() {
		return this.io.getPointerField(this, 25);
	}
	/**
	 * For planar audio which requires more than AV_NUM_DATA_POINTERS<br>
	 * AVBufferRef pointers, this array will hold all the references which<br>
	 * cannot fit into AVFrame.buf.<br>
	 * * Note that this is different from AVFrame.extended_data, which always<br>
	 * contains all the pointers. This array only contains the extra pointers,<br>
	 * which cannot fit into AVFrame.buf.<br>
	 * * This array is always allocated using av_malloc() by whoever constructs<br>
	 * the frame. It is freed in av_frame_unref().<br>
	 * C type : AVBufferRef**
	 */
	@Field(26) 
	public Pointer<Pointer<AVBufferRef > > extended_buf() {
		return this.io.getPointerField(this, 26);
	}
	/**
	 * For planar audio which requires more than AV_NUM_DATA_POINTERS<br>
	 * AVBufferRef pointers, this array will hold all the references which<br>
	 * cannot fit into AVFrame.buf.<br>
	 * * Note that this is different from AVFrame.extended_data, which always<br>
	 * contains all the pointers. This array only contains the extra pointers,<br>
	 * which cannot fit into AVFrame.buf.<br>
	 * * This array is always allocated using av_malloc() by whoever constructs<br>
	 * the frame. It is freed in av_frame_unref().<br>
	 * C type : AVBufferRef**
	 */
	@Field(26) 
	public AVFrame extended_buf(Pointer<Pointer<AVBufferRef > > extended_buf) {
		this.io.setPointerField(this, 26, extended_buf);
		return this;
	}
	/** Number of elements in extended_buf. */
	@Field(27) 
	public int nb_extended_buf() {
		return this.io.getIntField(this, 27);
	}
	/** Number of elements in extended_buf. */
	@Field(27) 
	public AVFrame nb_extended_buf(int nb_extended_buf) {
		this.io.setIntField(this, 27, nb_extended_buf);
		return this;
	}
	/** C type : AVFrameSideData** */
	@Field(28) 
	public Pointer<Pointer<AVFrameSideData > > side_data() {
		return this.io.getPointerField(this, 28);
	}
	/** C type : AVFrameSideData** */
	@Field(28) 
	public AVFrame side_data(Pointer<Pointer<AVFrameSideData > > side_data) {
		this.io.setPointerField(this, 28, side_data);
		return this;
	}
	@Field(29) 
	public int nb_side_data() {
		return this.io.getIntField(this, 29);
	}
	@Field(29) 
	public AVFrame nb_side_data(int nb_side_data) {
		this.io.setIntField(this, 29, nb_side_data);
		return this;
	}
	/** Frame flags, a combination of @ref lavu_frame_flags */
	@Field(30) 
	public int flags() {
		return this.io.getIntField(this, 30);
	}
	/** Frame flags, a combination of @ref lavu_frame_flags */
	@Field(30) 
	public AVFrame flags(int flags) {
		this.io.setIntField(this, 30, flags);
		return this;
	}
	/**
	 * MPEG vs JPEG YUV range.<br>
	 * - encoding: Set by user<br>
	 * - decoding: Set by libavcodec<br>
	 * C type : AVColorRange
	 */
	@Field(31) 
	public IntValuedEnum<AVColorRange > color_range() {
		return this.io.getEnumField(this, 31);
	}
	/**
	 * MPEG vs JPEG YUV range.<br>
	 * - encoding: Set by user<br>
	 * - decoding: Set by libavcodec<br>
	 * C type : AVColorRange
	 */
	@Field(31) 
	public AVFrame color_range(IntValuedEnum<AVColorRange > color_range) {
		this.io.setEnumField(this, 31, color_range);
		return this;
	}
	/** C type : AVColorPrimaries */
	@Field(32) 
	public IntValuedEnum<AVColorPrimaries > color_primaries() {
		return this.io.getEnumField(this, 32);
	}
	/** C type : AVColorPrimaries */
	@Field(32) 
	public AVFrame color_primaries(IntValuedEnum<AVColorPrimaries > color_primaries) {
		this.io.setEnumField(this, 32, color_primaries);
		return this;
	}
	/** C type : AVColorTransferCharacteristic */
	@Field(33) 
	public IntValuedEnum<AVColorTransferCharacteristic > color_trc() {
		return this.io.getEnumField(this, 33);
	}
	/** C type : AVColorTransferCharacteristic */
	@Field(33) 
	public AVFrame color_trc(IntValuedEnum<AVColorTransferCharacteristic > color_trc) {
		this.io.setEnumField(this, 33, color_trc);
		return this;
	}
	/**
	 * YUV colorspace type.<br>
	 * - encoding: Set by user<br>
	 * - decoding: Set by libavcodec<br>
	 * C type : AVColorSpace
	 */
	@Field(34) 
	public IntValuedEnum<AVColorSpace > colorspace() {
		return this.io.getEnumField(this, 34);
	}
	/**
	 * YUV colorspace type.<br>
	 * - encoding: Set by user<br>
	 * - decoding: Set by libavcodec<br>
	 * C type : AVColorSpace
	 */
	@Field(34) 
	public AVFrame colorspace(IntValuedEnum<AVColorSpace > colorspace) {
		this.io.setEnumField(this, 34, colorspace);
		return this;
	}
	/** C type : AVChromaLocation */
	@Field(35) 
	public IntValuedEnum<AVChromaLocation > chroma_location() {
		return this.io.getEnumField(this, 35);
	}
	/** C type : AVChromaLocation */
	@Field(35) 
	public AVFrame chroma_location(IntValuedEnum<AVChromaLocation > chroma_location) {
		this.io.setEnumField(this, 35, chroma_location);
		return this;
	}
	/**
	 * frame timestamp estimated using various heuristics, in stream time base<br>
	 * - encoding: unused<br>
	 * - decoding: set by libavcodec, read by user.
	 */
	@Field(36) 
	public long best_effort_timestamp() {
		return this.io.getLongField(this, 36);
	}
	/**
	 * frame timestamp estimated using various heuristics, in stream time base<br>
	 * - encoding: unused<br>
	 * - decoding: set by libavcodec, read by user.
	 */
	@Field(36) 
	public AVFrame best_effort_timestamp(long best_effort_timestamp) {
		this.io.setLongField(this, 36, best_effort_timestamp);
		return this;
	}
	/**
	 * reordered pos from the last AVPacket that has been input into the decoder<br>
	 * - encoding: unused<br>
	 * - decoding: Read by user.
	 */
	@Field(37) 
	public long pkt_pos() {
		return this.io.getLongField(this, 37);
	}
	/**
	 * reordered pos from the last AVPacket that has been input into the decoder<br>
	 * - encoding: unused<br>
	 * - decoding: Read by user.
	 */
	@Field(37) 
	public AVFrame pkt_pos(long pkt_pos) {
		this.io.setLongField(this, 37, pkt_pos);
		return this;
	}
	/**
	 * duration of the corresponding packet, expressed in<br>
	 * AVStream->time_base units, 0 if unknown.<br>
	 * - encoding: unused<br>
	 * - decoding: Read by user.
	 */
	@Field(38) 
	public long pkt_duration() {
		return this.io.getLongField(this, 38);
	}
	/**
	 * duration of the corresponding packet, expressed in<br>
	 * AVStream->time_base units, 0 if unknown.<br>
	 * - encoding: unused<br>
	 * - decoding: Read by user.
	 */
	@Field(38) 
	public AVFrame pkt_duration(long pkt_duration) {
		this.io.setLongField(this, 38, pkt_duration);
		return this;
	}
	/**
	 * metadata.<br>
	 * - encoding: Set by user.<br>
	 * - decoding: Set by libavcodec.<br>
	 * C type : AVDictionary*
	 */
	@Field(39) 
	public Pointer<AVDictionary > metadata() {
		return this.io.getPointerField(this, 39);
	}
	/**
	 * metadata.<br>
	 * - encoding: Set by user.<br>
	 * - decoding: Set by libavcodec.<br>
	 * C type : AVDictionary*
	 */
	@Field(39) 
	public AVFrame metadata(Pointer<AVDictionary > metadata) {
		this.io.setPointerField(this, 39, metadata);
		return this;
	}
	/**
	 * decode error flags of the frame, set to a combination of<br>
	 * FF_DECODE_ERROR_xxx flags if the decoder produced a frame, but there<br>
	 * were errors during the decoding.<br>
	 * - encoding: unused<br>
	 * - decoding: set by libavcodec, read by user.
	 */
	@Field(40) 
	public int decode_error_flags() {
		return this.io.getIntField(this, 40);
	}
	/**
	 * decode error flags of the frame, set to a combination of<br>
	 * FF_DECODE_ERROR_xxx flags if the decoder produced a frame, but there<br>
	 * were errors during the decoding.<br>
	 * - encoding: unused<br>
	 * - decoding: set by libavcodec, read by user.
	 */
	@Field(40) 
	public AVFrame decode_error_flags(int decode_error_flags) {
		this.io.setIntField(this, 40, decode_error_flags);
		return this;
	}
	/**
	 * number of audio channels, only used for audio.<br>
	 * - encoding: unused<br>
	 * - decoding: Read by user.
	 */
	@Field(41) 
	public int channels() {
		return this.io.getIntField(this, 41);
	}
	/**
	 * number of audio channels, only used for audio.<br>
	 * - encoding: unused<br>
	 * - decoding: Read by user.
	 */
	@Field(41) 
	public AVFrame channels(int channels) {
		this.io.setIntField(this, 41, channels);
		return this;
	}
	/**
	 * size of the corresponding packet containing the compressed<br>
	 * frame.<br>
	 * It is set to a negative value if unknown.<br>
	 * - encoding: unused<br>
	 * - decoding: set by libavcodec, read by user.
	 */
	@Field(42) 
	public int pkt_size() {
		return this.io.getIntField(this, 42);
	}
	/**
	 * size of the corresponding packet containing the compressed<br>
	 * frame.<br>
	 * It is set to a negative value if unknown.<br>
	 * - encoding: unused<br>
	 * - decoding: set by libavcodec, read by user.
	 */
	@Field(42) 
	public AVFrame pkt_size(int pkt_size) {
		this.io.setIntField(this, 42, pkt_size);
		return this;
	}
	/**
	 * QP table<br>
	 * C type : int8_t*
	 */
	@Field(43) 
	public Pointer<Byte > qscale_table() {
		return this.io.getPointerField(this, 43);
	}
	/**
	 * QP table<br>
	 * C type : int8_t*
	 */
	@Field(43) 
	public AVFrame qscale_table(Pointer<Byte > qscale_table) {
		this.io.setPointerField(this, 43, qscale_table);
		return this;
	}
	/** QP store stride */
	@Field(44) 
	public int qstride() {
		return this.io.getIntField(this, 44);
	}
	/** QP store stride */
	@Field(44) 
	public AVFrame qstride(int qstride) {
		this.io.setIntField(this, 44, qstride);
		return this;
	}
	@Field(45) 
	public int qscale_type() {
		return this.io.getIntField(this, 45);
	}
	@Field(45) 
	public AVFrame qscale_type(int qscale_type) {
		this.io.setIntField(this, 45, qscale_type);
		return this;
	}
	/** C type : AVBufferRef* */
	@Field(46) 
	public Pointer<AVBufferRef > qp_table_buf() {
		return this.io.getPointerField(this, 46);
	}
	/** C type : AVBufferRef* */
	@Field(46) 
	public AVFrame qp_table_buf(Pointer<AVBufferRef > qp_table_buf) {
		this.io.setPointerField(this, 46, qp_table_buf);
		return this;
	}
	/**
	 * For hwaccel-format frames, this should be a reference to the<br>
	 * AVHWFramesContext describing the frame.<br>
	 * C type : AVBufferRef*
	 */
	@Field(47) 
	public Pointer<AVBufferRef > hw_frames_ctx() {
		return this.io.getPointerField(this, 47);
	}
	/**
	 * For hwaccel-format frames, this should be a reference to the<br>
	 * AVHWFramesContext describing the frame.<br>
	 * C type : AVBufferRef*
	 */
	@Field(47) 
	public AVFrame hw_frames_ctx(Pointer<AVBufferRef > hw_frames_ctx) {
		this.io.setPointerField(this, 47, hw_frames_ctx);
		return this;
	}
	/**
	 * AVBufferRef for free use by the API user. FFmpeg will never check the<br>
	 * contents of the buffer ref. FFmpeg calls av_buffer_unref() on it when<br>
	 * the frame is unreferenced. av_frame_copy_props() calls create a new<br>
	 * reference with av_buffer_ref() for the target frame's opaque_ref field.<br>
	 * * This is unrelated to the opaque field, although it serves a similar<br>
	 * purpose.<br>
	 * C type : AVBufferRef*
	 */
	@Field(48) 
	public Pointer<AVBufferRef > opaque_ref() {
		return this.io.getPointerField(this, 48);
	}
	/**
	 * AVBufferRef for free use by the API user. FFmpeg will never check the<br>
	 * contents of the buffer ref. FFmpeg calls av_buffer_unref() on it when<br>
	 * the frame is unreferenced. av_frame_copy_props() calls create a new<br>
	 * reference with av_buffer_ref() for the target frame's opaque_ref field.<br>
	 * * This is unrelated to the opaque field, although it serves a similar<br>
	 * purpose.<br>
	 * C type : AVBufferRef*
	 */
	@Field(48) 
	public AVFrame opaque_ref(Pointer<AVBufferRef > opaque_ref) {
		this.io.setPointerField(this, 48, opaque_ref);
		return this;
	}
	/**
	 * @anchor cropping<br>
	 * @name Cropping<br>
	 * Video frames only. The number of pixels to discard from the the<br>
	 * top/bottom/left/right border of the frame to obtain the sub-rectangle of<br>
	 * the frame intended for presentation.<br>
	 * @{
	 */
	@Ptr 
	@Field(49) 
	public long crop_top() {
		return this.io.getSizeTField(this, 49);
	}
	/**
	 * @anchor cropping<br>
	 * @name Cropping<br>
	 * Video frames only. The number of pixels to discard from the the<br>
	 * top/bottom/left/right border of the frame to obtain the sub-rectangle of<br>
	 * the frame intended for presentation.<br>
	 * @{
	 */
	@Ptr 
	@Field(49) 
	public AVFrame crop_top(long crop_top) {
		this.io.setSizeTField(this, 49, crop_top);
		return this;
	}
	@Ptr 
	@Field(50) 
	public long crop_bottom() {
		return this.io.getSizeTField(this, 50);
	}
	@Ptr 
	@Field(50) 
	public AVFrame crop_bottom(long crop_bottom) {
		this.io.setSizeTField(this, 50, crop_bottom);
		return this;
	}
	@Ptr 
	@Field(51) 
	public long crop_left() {
		return this.io.getSizeTField(this, 51);
	}
	@Ptr 
	@Field(51) 
	public AVFrame crop_left(long crop_left) {
		this.io.setSizeTField(this, 51, crop_left);
		return this;
	}
	@Ptr 
	@Field(52) 
	public long crop_right() {
		return this.io.getSizeTField(this, 52);
	}
	@Ptr 
	@Field(52) 
	public AVFrame crop_right(long crop_right) {
		this.io.setSizeTField(this, 52, crop_right);
		return this;
	}
	@Struct(customizer=AlignmentCustomizer.class)
	public AVFrame() {
		super();
	}
	@Struct(customizer=AlignmentCustomizer.class)
	public AVFrame(Pointer pointer) {
		super(pointer);
	}
	
	public List<StructFieldDescription> getDescriptions() {
		return this.io.desc.getAggregatedFields();
	}
}
