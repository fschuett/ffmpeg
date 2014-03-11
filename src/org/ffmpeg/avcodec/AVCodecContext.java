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
public class AVCodecContext extends StructObject {
	static {
		BridJ.register();
	}

	/** C type : AVMediaType */
	@Field(0)
	public IntValuedEnum<AVMediaType> codec_type() {
		return this.io.getEnumField(this, 0);
	}

	/** C type : AVMediaType */
	@Field(0)
	public AVCodecContext codec_type(IntValuedEnum<AVMediaType> codec_type) {
		this.io.setEnumField(this, 0, codec_type);
		return this;
	}

	/** const struct AVCodec *codec; */
	@Field(1)
	public Pointer<AVCodec> codec() {
		return this.io.getPointerField(this, 1);
	}

	@Field(1)
	public AVCodecContext codec(Pointer<AVCodec> codec) {
		this.io.setPointerField(this, 1, codec);
		return this;
	}

	/** C type : AVCodecID */
	@Field(2)
	public IntValuedEnum<AVCodecID> codec_id() {
		return this.io.getEnumField(this, 2);
	}

	/** C type : AVCodecID */
	@Field(2)
	public AVCodecContext codec_id(IntValuedEnum<AVCodecID> codec_id) {
		this.io.setEnumField(this, 2, codec_id);
		return this;
	}

	/** void *priv_data; */
	@Field(3)
	public Pointer<?> priv_data() {
		return this.io.getPointerField(this, 3);
	}

	@Field(3)
	public AVCodecContext priv_data(Pointer<?> priv_data) {
		this.io.setPointerField(this, 3, priv_data);
		return this;
	}

	/** void *opaque;4 */
	@Field(4)
	public Pointer<?> opaque() {
		return this.io.getPointerField(this, 4);
	}

	@Field(4)
	public AVCodecContext opaque(Pointer<?> opaque) {
		this.io.setPointerField(this, 4, opaque);
		return this;
	}

	@Field(5)
	public int bit_rate() {
		return this.io.getIntField(this, 5);
	}

	@Field(5)
	public AVCodecContext bit_rate(int bit_rate) {
		this.io.setIntField(this, 5, bit_rate);
		return this;
	}

	@Field(6)
	public int bit_rate_tolerance() {
		return this.io.getIntField(this, 6);
	}

	@Field(6)
	public AVCodecContext bit_rate_tolerance(int bit_rate_tolerance) {
		this.io.setIntField(this, 6, bit_rate_tolerance);
		return this;
	}

	@Field(7)
	public int flags() {
		return this.io.getIntField(this, 7);
	}

	@Field(7)
	public AVCodecContext flags(int flags) {
		this.io.setIntField(this, 7, flags);
		return this;
	}

	/** uint8_t *extradata;8 */
	@Field(8)
	public Pointer<Byte> extradata() {
		return this.io.getPointerField(this, 8);
	}

	@Field(8)
	public AVCodecContext extradata(Pointer<Byte> extradata) {
		this.io.setPointerField(this, 8, extradata);
		return this;
	}

	@Field(9)
	public int extradata_size() {
		return this.io.getIntField(this, 9);
	}

	@Field(9)
	public AVCodecContext extradata_size(int extradata_size) {
		this.io.setIntField(this, 9, extradata_size);
		return this;
	}

	/** C type : AVRational */
	@Field(10)
	public AVRational time_base() {
		return this.io.getNativeObjectField(this, 10);
	}

	/** C type : AVRational */
	@Field(10)
	public AVCodecContext sample_aspect_ratio(AVRational time_base) {
		this.io.setNativeObjectField(this, 10, time_base);
		return this;
	}

	@Field(11)
	public int ticks_per_frame() {
		return this.io.getIntField(this, 11);
	}

	@Field(11)
	public AVCodecContext ticks_per_frame(int ticks_per_frame) {
		this.io.setIntField(this, 11, ticks_per_frame);
		return this;
	}

	@Field(12)
	public int width() {
		return this.io.getIntField(this, 12);
	}

	@Field(12)
	public AVCodecContext width(int width) {
		this.io.setIntField(this, 12, width);
		return this;
	}

	@Field(13)
	public int height() {
		return this.io.getIntField(this, 13);
	}

	@Field(13)
	public AVCodecContext height(int height) {
		this.io.setIntField(this, 13, height);
		return this;
	}

	@Field(14)
	public int gop_size() {
		return this.io.getIntField(this, 14);
	}

	@Field(14)
	public AVCodecContext gop_size(int gop_size) {
		this.io.setIntField(this, 14, gop_size);
		return this;
	}

	/** C type : AVPixelFormat */
	@Field(15)
	public IntValuedEnum<AVPixelFormat> pix_fmt() {
		return this.io.getEnumField(this, 15);
	}

	/** C type : AVPixelFormat */
	@Field(15)
	public AVCodecContext pix_fmt(IntValuedEnum<AVPixelFormat> pix_fmt) {
		this.io.setEnumField(this, 15, pix_fmt);
		return this;
	}

	@Field(16)
	public int max_b_frames() {
		return this.io.getIntField(this, 16);
	}

	@Field(16)
	public AVCodecContext max_b_frames(int max_b_frames) {
		this.io.setIntField(this, 16, max_b_frames);
		return this;
	}

	@Field(17)
	public int has_b_frames() {
		return this.io.getIntField(this, 17);
	}

	@Field(17)
	public AVCodecContext has_b_frames(int has_b_frames) {
		this.io.setIntField(this, 17, has_b_frames);
		return this;
	}

	@Field(18)
	public int sample_rate() {
		return this.io.getIntField(this, 18);
	}
	
	@Field(18)
	public AVCodecContext sample_rate(int sample_rate) {
		this.io.setIntField(this, 18, sample_rate);
		return this;
	}
	
	@Field(19)
	public int channels() {
		return this.io.getIntField(this, 19);
	}
	
	@Field(19)
	public AVCodecContext channels(int channels) {
		this.io.setIntField(this, 19, channels);
		return this;
	}
	
	/** enum AVSampleFormat sample_fmt; ///< sample format */
	@Field(20)
	public IntValuedEnum<AVSampleFormat> sample_fmt() {
		return this.io.getEnumField(this, 20);
	}

	@Field(20)
	public AVCodecContext sample_fmt(IntValuedEnum<AVSampleFormat> sample_fmt) {
		this.io.setEnumField(this, 20, sample_fmt);
		return this;
	}

	@Field(21)
	public int strict_std_compliance() {
		return this.io.getIntField(this, 21);
	}

	@Field(21)
	public AVCodecContext strict_std_compliance(int strict_std_compliance) {
		this.io.setIntField(this, 21, strict_std_compliance);
		return this;
	}

	/** C type AVFrame */
	@Field(22)
	public Pointer<AVFrame> coded_frame() {
		return this.io.getPointerField(this, 22);
	}

	@Field(22)
	public AVCodecContext coded_frame(Pointer<AVFrame> coded_frame) {
		this.io.setPointerField(this, 22, coded_frame);
		return this;
	}

	/** uint8_t *subtitle_header */
	@Field(23)
	public Pointer<Byte> subtitle_header() {
		return this.io.getPointerField(this, 23);
	}

	@Field(23)
	public AVCodecContext subtitle_header(Pointer<Byte> subtitle_header) {
		this.io.setPointerField(this, 23, subtitle_header);
		return this;
	}

}
