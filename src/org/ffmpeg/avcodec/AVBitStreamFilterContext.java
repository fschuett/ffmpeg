package org.ffmpeg.avcodec;
import org.bridj.BridJ;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
/**
 * <i>native declaration : ./libavcodec/avcodec.h:4041</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("avcodec") 
public class AVBitStreamFilterContext extends StructObject {
	static {
		BridJ.register();
	}
	/** C type : void* */
	@Field(0) 
	public Pointer<? > priv_data() {
		return this.io.getPointerField(this, 0);
	}
	/** C type : void* */
	@Field(0) 
	public AVBitStreamFilterContext priv_data(Pointer<? > priv_data) {
		this.io.setPointerField(this, 0, priv_data);
		return this;
	}
	/** C type : AVBitStreamFilter* */
	@Field(1) 
	public Pointer<AVBitStreamFilter > filter() {
		return this.io.getPointerField(this, 1);
	}
	/** C type : AVBitStreamFilter* */
	@Field(1) 
	public AVBitStreamFilterContext filter(Pointer<AVBitStreamFilter > filter) {
		this.io.setPointerField(this, 1, filter);
		return this;
	}
	/** C type : AVCodecParserContext* */
	@Field(2) 
	public Pointer<AVCodecParserContext > parser() {
		return this.io.getPointerField(this, 2);
	}
	/** C type : AVCodecParserContext* */
	@Field(2) 
	public AVBitStreamFilterContext parser(Pointer<AVCodecParserContext > parser) {
		this.io.setPointerField(this, 2, parser);
		return this;
	}
	/** C type : AVBitStreamFilterContext* */
	@Field(3) 
	public Pointer<AVBitStreamFilterContext > next() {
		return this.io.getPointerField(this, 3);
	}
	/** C type : AVBitStreamFilterContext* */
	@Field(3) 
	public AVBitStreamFilterContext next(Pointer<AVBitStreamFilterContext > next) {
		this.io.setPointerField(this, 3, next);
		return this;
	}
	/**
	 * Internal default arguments, used if NULL is passed to av_bitstream_filter_filter().<br>
	 * Not for access by library users.<br>
	 * C type : char*
	 */
	@Field(4) 
	public Pointer<Byte > args() {
		return this.io.getPointerField(this, 4);
	}
	/**
	 * Internal default arguments, used if NULL is passed to av_bitstream_filter_filter().<br>
	 * Not for access by library users.<br>
	 * C type : char*
	 */
	@Field(4) 
	public AVBitStreamFilterContext args(Pointer<Byte > args) {
		this.io.setPointerField(this, 4, args);
		return this;
	}
	public AVBitStreamFilterContext() {
		super();
	}
	public AVBitStreamFilterContext(Pointer pointer) {
		super(pointer);
	}
}
