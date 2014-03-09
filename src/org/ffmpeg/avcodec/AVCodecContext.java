package org.ffmpeg.avcodec;

import org.bridj.BridJ;
import org.bridj.Callback;
import org.bridj.IntValuedEnum;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
import org.bridj.ann.Ptr;
import org.ffmpeg.avcodec.AvcodecLibrary.AVCodecID;
import org.ffmpeg.avcodec.AvcodecLibrary.AVSubtitle;
import org.ffmpeg.avutil.AVClass;
import org.ffmpeg.avutil.AVFrame;
import org.ffmpeg.avutil.AVRational;
import org.ffmpeg.avutil.AvutilLibrary.AVMediaType;
import org.ffmpeg.avutil.AvutilLibrary.AVPixelFormat;
import org.ffmpeg.avutil.AvutilLibrary.AVSampleFormat;

/**
 * Manually constructed data type from libavcodec.h
 * 
 */
@Library("avcodec")
public abstract class AVCodecContext extends StructObject {
	static {
		BridJ.register();
	}

	/** C type : AVMediaType */
	@Field(2)
	public IntValuedEnum<AVMediaType> codec_type() {
		return this.io.getEnumField(this, 2);
	}

	/** C type : AVMediaType */
	@Field(2)
	public AVCodecContext codec_type(IntValuedEnum<AVMediaType> codec_type) {
		this.io.setEnumField(this, 2, codec_type);
		return this;
	}

	/** const struct AVCodec *codec; */
	@Field(3)
	public Pointer<AVCodec> codec() {
		return this.io.getPointerField(this, 3);
	}

	@Field(3)
	public AVCodecContext codec(Pointer<AVCodec> codec) {
		this.io.setPointerField(this, 3, codec);
		return this;
	}

	/** C type : AVCodecID */
	@Field(5)
	public IntValuedEnum<AVCodecID> codec_id() {
		return this.io.getEnumField(this, 5);
	}

	/** C type : AVCodecID */
	@Field(5)
	public AVCodecContext codec_id(IntValuedEnum<AVCodecID> codec_id) {
		this.io.setEnumField(this, 5, codec_id);
		return this;
	}

	/** void *priv_data; */
	@Field(8)
	public Pointer<?> priv_data() {
		return this.io.getPointerField(this, 8);
	}

	@Field(8)
	public AVCodecContext priv_data(Pointer<?> priv_data) {
		this.io.setPointerField(this, 8, priv_data);
		return this;
	}

	/** void *opaque;10 */
	@Field(10)
	public Pointer<?> opaque() {
		return this.io.getPointerField(this, 10);
	}

	@Field(10)
	public AVCodecContext opaque(Pointer<?> opaque) {
		this.io.setPointerField(this, 10, opaque);
		return this;
	}

	@Field(11)
	public int bit_rate() {
		return this.io.getIntField(this, 11);
	}

	@Field(11)
	public AVCodecContext bit_rate(int bit_rate) {
		this.io.setIntField(this, 11, bit_rate);
		return this;
	}

	@Field(12)
	public int bit_rate_tolerance() {
		return this.io.getIntField(this, 12);
	}

	@Field(12)
	public AVCodecContext bit_rate_tolerance(int bit_rate_tolerance) {
		this.io.setIntField(this, 12, bit_rate_tolerance);
		return this;
	}

	@Field(15)
	public int flags() {
		return this.io.getIntField(this, 15);
	}

	@Field(15)
	public AVCodecContext flags(int flags) {
		this.io.setIntField(this, 15, flags);
		return this;
	}

	/** uint8_t *extradata;16 */
	@Field(16)
	public Pointer<Byte> extradata() {
		return this.io.getPointerField(this, 16);
	}

	@Field(16)
	public AVCodecContext extradata(Pointer<Byte> extradata) {
		this.io.setPointerField(this, 16, extradata);
		return this;
	}

	@Field(17)
	public int extradata_size() {
		return this.io.getIntField(this, 17);
	}

	@Field(17)
	public AVCodecContext extradata_size(int extradata_size) {
		this.io.setIntField(this, 17, extradata_size);
		return this;
	}

	/** C type : AVRational */
	@Field(18)
	public AVRational time_base() {
		return this.io.getNativeObjectField(this, 18);
	}

	/** C type : AVRational */
	@Field(18)
	public AVCodecContext sample_aspect_ratio(AVRational time_base) {
		this.io.setNativeObjectField(this, 18, time_base);
		return this;
	}

	@Field(20)
	public int ticks_per_frame() {
		return this.io.getIntField(this, 20);
	}

	@Field(20)
	public AVCodecContext ticks_per_frame(int ticks_per_frame) {
		this.io.setIntField(this, 20, ticks_per_frame);
		return this;
	}

	@Field(22)
	public int getWidth() {
		return this.io.getIntField(this, 22);
	}

	@Field(22)
	public AVCodecContext setWidth(int width) {
		this.io.setIntField(this, 22, width);
		return this;
	}

	@Field(23)
	public int getHeight() {
		return this.io.getIntField(this, 23);
	}

	@Field(23)
	public AVCodecContext setHeight(int height) {
		this.io.setIntField(this, 23, height);
		return this;
	}

	@Field(26)
	public int gop_size() {
		return this.io.getIntField(this, 26);
	}

	@Field(26)
	public AVCodecContext gop_size(int gop_size) {
		this.io.setIntField(this, 26, gop_size);
		return this;
	}

	/** C type : AVPixelFormat */
	@Field(27)
	public IntValuedEnum<AVPixelFormat> pix_fmt() {
		return this.io.getEnumField(this, 27);
	}

	/** C type : AVPixelFormat */
	@Field(27)
	public AVCodecContext pix_fmt(IntValuedEnum<AVPixelFormat> pix_fmt) {
		this.io.setEnumField(this, 27, pix_fmt);
		return this;
	}

	@Field(29)
	public int max_b_frames() {
		return this.io.getIntField(this, 29);
	}

	@Field(29)
	public AVCodecContext max_b_frames(int max_b_frames) {
		this.io.setIntField(this, 29, max_b_frames);
		return this;
	}

	@Field(34)
	public int has_b_frames() {
		return this.io.getIntField(this, 34);
	}

	@Field(34)
	public AVCodecContext has_b_frames(int has_b_frames) {
		this.io.setIntField(this, 34, has_b_frames);
		return this;
	}

	/** enum AVSampleFormat sample_fmt; ///< sample format */
	@Field(115)
	public IntValuedEnum<AVSampleFormat> sample_fmt() {
		return this.io.getEnumField(this, 115);
	}

	@Field(115)
	public AVCodecContext sample_fmt(IntValuedEnum<AVSampleFormat> sample_fmt) {
		this.io.setEnumField(this, 115, sample_fmt);
		return this;
	}

	@Field(170)
	public int strict_std_compliance() {
		return this.io.getIntField(this, 170);
	}

	@Field(170)
	public AVCodecContext strict_std_compliance(int strict_std_compliance) {
		this.io.setIntField(this, 170, strict_std_compliance);
		return this;
	}

	/** C type AVFrame */
	@Field(183)
	public Pointer<AVFrame> coded_frame() {
		return this.io.getPointerField(this, 183);
	}

	@Field(183)
	public AVCodecContext coded_frame(Pointer<AVFrame> coded_frame) {
		this.io.setPointerField(this, 183, coded_frame);
		return this;
	}

	/** uint8_t *subtitle_header */
	@Field(195)
	public Pointer<Byte> subtitle_header() {
		return this.io.getPointerField(this, 195);
	}

	@Field(195)
	public AVCodecContext subtitle_header(Pointer<Byte> subtitle_header) {
		this.io.setPointerField(this, 195, subtitle_header);
		return this;
	}

}
