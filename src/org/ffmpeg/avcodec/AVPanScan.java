package org.ffmpeg.avcodec;
import org.bridj.BridJ;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Array;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
/**
 * <i>native declaration : ./libavcodec/avcodec.h:582</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("avcodec") 
public class AVPanScan extends StructObject {
	static {
		BridJ.register();
	}
	/**
	 * id<br>
	 * - encoding: Set by user.<br>
	 * - decoding: Set by libavcodec.
	 */
	@Field(0) 
	public int id() {
		return this.io.getIntField(this, 0);
	}
	/**
	 * id<br>
	 * - encoding: Set by user.<br>
	 * - decoding: Set by libavcodec.
	 */
	@Field(0) 
	public AVPanScan id(int id) {
		this.io.setIntField(this, 0, id);
		return this;
	}
	/**
	 * width and height in 1/16 pel<br>
	 * - encoding: Set by user.<br>
	 * - decoding: Set by libavcodec.
	 */
	@Field(1) 
	public int width() {
		return this.io.getIntField(this, 1);
	}
	/**
	 * width and height in 1/16 pel<br>
	 * - encoding: Set by user.<br>
	 * - decoding: Set by libavcodec.
	 */
	@Field(1) 
	public AVPanScan width(int width) {
		this.io.setIntField(this, 1, width);
		return this;
	}
	@Field(2) 
	public int height() {
		return this.io.getIntField(this, 2);
	}
	@Field(2) 
	public AVPanScan height(int height) {
		this.io.setIntField(this, 2, height);
		return this;
	}
	/**
	 * position of the top left corner in 1/16 pel for up to 3 fields/frames<br>
	 * - encoding: Set by user.<br>
	 * - decoding: Set by libavcodec.<br>
	 * C type : int16_t[3][2]
	 */
	@Array({3, 2}) 
	@Field(3) 
	public Pointer<Short > position() {
		return this.io.getPointerField(this, 3);
	}
	public AVPanScan() {
		super();
	}
	public AVPanScan(Pointer pointer) {
		super(pointer);
	}
}
