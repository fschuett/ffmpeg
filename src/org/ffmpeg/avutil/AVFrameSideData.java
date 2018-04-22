package org.ffmpeg.avutil;
import org.bridj.BridJ;
import org.bridj.IntValuedEnum;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
import org.ffmpeg.avutil.AvutilLibrary.AVFrameSideDataType;
/**
 * <i>native declaration : libavutil/frame.h:109</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("avutil") 
public class AVFrameSideData extends StructObject {
	static {
		BridJ.register();
	}
	/** C type : AVFrameSideDataType */
	@Field(0) 
	public IntValuedEnum<AVFrameSideDataType > type() {
		return this.io.getEnumField(this, 0);
	}
	/** C type : AVFrameSideDataType */
	@Field(0) 
	public AVFrameSideData type(IntValuedEnum<AVFrameSideDataType > type) {
		this.io.setEnumField(this, 0, type);
		return this;
	}
	/** C type : uint8_t* */
	@Field(1) 
	public Pointer<Byte > data() {
		return this.io.getPointerField(this, 1);
	}
	/** C type : uint8_t* */
	@Field(1) 
	public AVFrameSideData data(Pointer<Byte > data) {
		this.io.setPointerField(this, 1, data);
		return this;
	}
	@Field(2) 
	public int size() {
		return this.io.getIntField(this, 2);
	}
	@Field(2) 
	public AVFrameSideData size(int size) {
		this.io.setIntField(this, 2, size);
		return this;
	}
	/** C type : AVDictionary* */
	@Field(3) 
	public Pointer<AVDictionary > metadata() {
		return this.io.getPointerField(this, 3);
	}
	/** C type : AVDictionary* */
	@Field(3) 
	public AVFrameSideData metadata(Pointer<AVDictionary > metadata) {
		this.io.setPointerField(this, 3, metadata);
		return this;
	}
	/** C type : AVBufferRef* */
	@Field(4) 
	public Pointer<AVBufferRef > buf() {
		return this.io.getPointerField(this, 4);
	}
	/** C type : AVBufferRef* */
	@Field(4) 
	public AVFrameSideData buf(Pointer<AVBufferRef > buf) {
		this.io.setPointerField(this, 4, buf);
		return this;
	}
	public AVFrameSideData() {
		super();
	}
	public AVFrameSideData(Pointer pointer) {
		super(pointer);
	}
}
