package org.ffmpeg.avcodec;
import org.bridj.BridJ;
import org.bridj.Callback;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Array;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
import org.bridj.ann.Ptr;
import org.bridj.util.DefaultParameterizedType;
/**
 * <i>native declaration : ./libavcodec/avcodec.h:3596</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("avcodec") 
public class AVCodecParser extends StructObject {
	static {
		BridJ.register();
	}
	/**
	 * several codec IDs are permitted<br>
	 * C type : int[5]
	 */
	@Array({5}) 
	@Field(0) 
	public Pointer<Integer > codec_ids() {
		return this.io.getPointerField(this, 0);
	}
	@Field(1) 
	public int priv_data_size() {
		return this.io.getIntField(this, 1);
	}
	@Field(1) 
	public AVCodecParser priv_data_size(int priv_data_size) {
		this.io.setIntField(this, 1, priv_data_size);
		return this;
	}
	/** C type : parser_init_callback* */
	@Field(2) 
	public Pointer<AVCodecParser.parser_init_callback > parser_init() {
		return this.io.getPointerField(this, 2);
	}
	/** C type : parser_init_callback* */
	@Field(2) 
	public AVCodecParser parser_init(Pointer<AVCodecParser.parser_init_callback > parser_init) {
		this.io.setPointerField(this, 2, parser_init);
		return this;
	}
	/**
	 * This callback never returns an error, a negative value means that<br>
	 * the frame start was in a previous packet.<br>
	 * C type : parser_parse_callback*
	 */
	@Field(3) 
	public Pointer<AVCodecParser.parser_parse_callback > parser_parse() {
		return this.io.getPointerField(this, 3);
	}
	/**
	 * This callback never returns an error, a negative value means that<br>
	 * the frame start was in a previous packet.<br>
	 * C type : parser_parse_callback*
	 */
	@Field(3) 
	public AVCodecParser parser_parse(Pointer<AVCodecParser.parser_parse_callback > parser_parse) {
		this.io.setPointerField(this, 3, parser_parse);
		return this;
	}
	/** C type : parser_close_callback* */
	@Field(4) 
	public Pointer<AVCodecParser.parser_close_callback > parser_close() {
		return this.io.getPointerField(this, 4);
	}
	/** C type : parser_close_callback* */
	@Field(4) 
	public AVCodecParser parser_close(Pointer<AVCodecParser.parser_close_callback > parser_close) {
		this.io.setPointerField(this, 4, parser_close);
		return this;
	}
	/** C type : split_callback* */
	@Field(5) 
	public Pointer<AVCodecParser.split_callback > split() {
		return this.io.getPointerField(this, 5);
	}
	/** C type : split_callback* */
	@Field(5) 
	public AVCodecParser split(Pointer<AVCodecParser.split_callback > split) {
		this.io.setPointerField(this, 5, split);
		return this;
	}
	/** C type : AVCodecParser* */
	@Field(6) 
	public Pointer<AVCodecParser > next() {
		return this.io.getPointerField(this, 6);
	}
	/** C type : AVCodecParser* */
	@Field(6) 
	public AVCodecParser next(Pointer<AVCodecParser > next) {
		this.io.setPointerField(this, 6, next);
		return this;
	}
	/** <i>native declaration : ./libavcodec/avcodec.h:3592</i> */
	public static abstract class parser_init_callback extends Callback<parser_init_callback > {
		public int apply(Pointer<AVCodecParserContext > s) {
			return apply(Pointer.getPeer(s));
		}
		public int apply(@Ptr long s) {
			return apply(Pointer.pointerToAddress(s, AVCodecParserContext.class));
		}
	};
	/** <i>native declaration : ./libavcodec/avcodec.h:3593</i> */
	public static abstract class parser_parse_callback extends Callback<parser_parse_callback > {
		public int apply(Pointer<AVCodecParserContext > s, Pointer<AVCodecContext > avctx, Pointer<Pointer > poutbuf, Pointer<Integer > poutbuf_size, Pointer<Byte > buf, int buf_size) {
			return apply(Pointer.getPeer(s), Pointer.getPeer(avctx), Pointer.getPeer(poutbuf), Pointer.getPeer(poutbuf_size), Pointer.getPeer(buf), buf_size);
		}
		public int apply(@Ptr long s, @Ptr long avctx, @Ptr long poutbuf, @Ptr long poutbuf_size, @Ptr long buf, int buf_size) {
			return apply(Pointer.pointerToAddress(s, AVCodecParserContext.class), Pointer.pointerToAddress(avctx, AVCodecContext.class), Pointer.pointerToAddress(poutbuf, Pointer.class), Pointer.pointerToAddress(poutbuf_size, Integer.class), Pointer.pointerToAddress(buf, Byte.class), buf_size);
		}
	};
	/** <i>native declaration : ./libavcodec/avcodec.h:3594</i> */
	public static abstract class parser_close_callback extends Callback<parser_close_callback > {
		public void apply(Pointer<AVCodecParserContext > s) {
			apply(Pointer.getPeer(s));
		}
		public void apply(@Ptr long s) {
			apply(Pointer.pointerToAddress(s, AVCodecParserContext.class));
		}
	};
	/** <i>native declaration : ./libavcodec/avcodec.h:3595</i> */
	public static abstract class split_callback extends Callback<split_callback > {
		public int apply(Pointer<AVCodecContext > avctx, Pointer<Byte > buf, int buf_size) {
			return apply(Pointer.getPeer(avctx), Pointer.getPeer(buf), buf_size);
		}
		public int apply(@Ptr long avctx, @Ptr long buf, int buf_size) {
			return apply(Pointer.pointerToAddress(avctx, AVCodecContext.class), Pointer.pointerToAddress(buf, Byte.class), buf_size);
		}
	};
	public AVCodecParser() {
		super();
	}
	public AVCodecParser(Pointer pointer) {
		super(pointer);
	}
}
