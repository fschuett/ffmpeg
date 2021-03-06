package org.ffmpeg.avutil;
import org.bridj.BridJ;
import org.bridj.IntValuedEnum;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
import org.ffmpeg.avutil.AvutilLibrary.AVPixelFormat;
/**
 * <i>native declaration : ./libavutil/hwcontext.h:388</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("avutil") 
public class AVHWFramesConstraints extends StructObject {
	static {
		BridJ.register();
	}
	/**
	 * A list of possible values for format in the hw_frames_ctx,<br>
	 * terminated by AV_PIX_FMT_NONE.  This member will always be filled.<br>
	 * C type : AVPixelFormat*
	 */
	@Field(0) 
	public Pointer<IntValuedEnum<AVPixelFormat > > valid_hw_formats() {
		return this.io.getPointerField(this, 0);
	}
	/**
	 * A list of possible values for format in the hw_frames_ctx,<br>
	 * terminated by AV_PIX_FMT_NONE.  This member will always be filled.<br>
	 * C type : AVPixelFormat*
	 */
	@Field(0) 
	public AVHWFramesConstraints valid_hw_formats(Pointer<IntValuedEnum<AVPixelFormat > > valid_hw_formats) {
		this.io.setPointerField(this, 0, valid_hw_formats);
		return this;
	}
	/**
	 * A list of possible values for sw_format in the hw_frames_ctx,<br>
	 * terminated by AV_PIX_FMT_NONE.  Can be NULL if this information is<br>
	 * not known.<br>
	 * C type : AVPixelFormat*
	 */
	@Field(1) 
	public Pointer<IntValuedEnum<AVPixelFormat > > valid_sw_formats() {
		return this.io.getPointerField(this, 1);
	}
	/**
	 * A list of possible values for sw_format in the hw_frames_ctx,<br>
	 * terminated by AV_PIX_FMT_NONE.  Can be NULL if this information is<br>
	 * not known.<br>
	 * C type : AVPixelFormat*
	 */
	@Field(1) 
	public AVHWFramesConstraints valid_sw_formats(Pointer<IntValuedEnum<AVPixelFormat > > valid_sw_formats) {
		this.io.setPointerField(this, 1, valid_sw_formats);
		return this;
	}
	/**
	 * The minimum size of frames in this hw_frames_ctx.<br>
	 * (Zero if not known.)
	 */
	@Field(2) 
	public int min_width() {
		return this.io.getIntField(this, 2);
	}
	/**
	 * The minimum size of frames in this hw_frames_ctx.<br>
	 * (Zero if not known.)
	 */
	@Field(2) 
	public AVHWFramesConstraints min_width(int min_width) {
		this.io.setIntField(this, 2, min_width);
		return this;
	}
	@Field(3) 
	public int min_height() {
		return this.io.getIntField(this, 3);
	}
	@Field(3) 
	public AVHWFramesConstraints min_height(int min_height) {
		this.io.setIntField(this, 3, min_height);
		return this;
	}
	/**
	 * The maximum size of frames in this hw_frames_ctx.<br>
	 * (INT_MAX if not known / no limit.)
	 */
	@Field(4) 
	public int max_width() {
		return this.io.getIntField(this, 4);
	}
	/**
	 * The maximum size of frames in this hw_frames_ctx.<br>
	 * (INT_MAX if not known / no limit.)
	 */
	@Field(4) 
	public AVHWFramesConstraints max_width(int max_width) {
		this.io.setIntField(this, 4, max_width);
		return this;
	}
	@Field(5) 
	public int max_height() {
		return this.io.getIntField(this, 5);
	}
	@Field(5) 
	public AVHWFramesConstraints max_height(int max_height) {
		this.io.setIntField(this, 5, max_height);
		return this;
	}
	public AVHWFramesConstraints() {
		super();
	}
	public AVHWFramesConstraints(Pointer pointer) {
		super(pointer);
	}
}
