package org.ffmpeg.avcodec;
import org.bridj.BridJ;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
/**
 * <i>native declaration : ./libavcodec/packet.h:309</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("avcodec") 
public class AVPacketList extends StructObject {
	static {
		BridJ.register();
	}
	/** C type : AVPacket */
	@Field(0) 
	public AVPacket pkt() {
		return this.io.getNativeObjectField(this, 0);
	}
	/** C type : AVPacket */
	@Field(0) 
	public AVPacketList pkt(AVPacket pkt) {
		this.io.setNativeObjectField(this, 0, pkt);
		return this;
	}
	/** C type : AVPacketList* */
	@Field(1) 
	public Pointer<AVPacketList > next() {
		return this.io.getPointerField(this, 1);
	}
	/** C type : AVPacketList* */
	@Field(1) 
	public AVPacketList next(Pointer<AVPacketList > next) {
		this.io.setPointerField(this, 1, next);
		return this;
	}
	public AVPacketList() {
		super();
	}
	public AVPacketList(Pointer pointer) {
		super(pointer);
	}
}
