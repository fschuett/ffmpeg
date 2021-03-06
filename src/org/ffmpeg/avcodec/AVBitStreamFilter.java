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
import org.ffmpeg.avutil.AVClass;
/**
 * <i>native declaration : ./libavcodec/bsf.h:74</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("avcodec") 
public class AVBitStreamFilter extends StructObject {
	static {
		BridJ.register();
	}
	/** C type : const char* */
	@Field(0) 
	public Pointer<Byte > name() {
		return this.io.getPointerField(this, 0);
	}
	/** C type : const char* */
	@Field(0) 
	public AVBitStreamFilter name(Pointer<Byte > name) {
		this.io.setPointerField(this, 0, name);
		return this;
	}
	/**
	 * A list of codec ids supported by the filter, terminated by<br>
	 * AV_CODEC_ID_NONE.<br>
	 * May be NULL, in that case the bitstream filter works with any codec id.<br>
	 * C type : AVCodecID*
	 */
	@Field(1) 
	public Pointer<IntValuedEnum<AVCodecID > > codec_ids() {
		return this.io.getPointerField(this, 1);
	}
	/**
	 * A list of codec ids supported by the filter, terminated by<br>
	 * AV_CODEC_ID_NONE.<br>
	 * May be NULL, in that case the bitstream filter works with any codec id.<br>
	 * C type : AVCodecID*
	 */
	@Field(1) 
	public AVBitStreamFilter codec_ids(Pointer<IntValuedEnum<AVCodecID > > codec_ids) {
		this.io.setPointerField(this, 1, codec_ids);
		return this;
	}
	/**
	 * A class for the private data, used to declare bitstream filter private<br>
	 * AVOptions. This field is NULL for bitstream filters that do not declare<br>
	 * any options.<br>
	 * * If this field is non-NULL, the first member of the filter private data<br>
	 * must be a pointer to AVClass, which will be set by libavcodec generic<br>
	 * code to this class.<br>
	 * C type : const AVClass*
	 */
	@Field(2) 
	public Pointer<AVClass > priv_class() {
		return this.io.getPointerField(this, 2);
	}
	/**
	 * A class for the private data, used to declare bitstream filter private<br>
	 * AVOptions. This field is NULL for bitstream filters that do not declare<br>
	 * any options.<br>
	 * * If this field is non-NULL, the first member of the filter private data<br>
	 * must be a pointer to AVClass, which will be set by libavcodec generic<br>
	 * code to this class.<br>
	 * C type : const AVClass*
	 */
	@Field(2) 
	public AVBitStreamFilter priv_class(Pointer<AVClass > priv_class) {
		this.io.setPointerField(this, 2, priv_class);
		return this;
	}
	@Field(3) 
	public int priv_data_size() {
		return this.io.getIntField(this, 3);
	}
	@Field(3) 
	public AVBitStreamFilter priv_data_size(int priv_data_size) {
		this.io.setIntField(this, 3, priv_data_size);
		return this;
	}
	/** C type : init_callback* */
	@Field(4) 
	public Pointer<org.ffmpeg.avfilter.AVFilter.init_callback > init() {
		return this.io.getPointerField(this, 4);
	}
	/** C type : init_callback* */
	@Field(4) 
	public AVBitStreamFilter init(Pointer<org.ffmpeg.avfilter.AVFilter.init_callback > init) {
		this.io.setPointerField(this, 4, init);
		return this;
	}
	/** C type : filter_callback* */
	@Field(5) 
	public Pointer<AVBitStreamFilter.filter_callback > filter() {
		return this.io.getPointerField(this, 5);
	}
	/** C type : filter_callback* */
	@Field(5) 
	public AVBitStreamFilter filter(Pointer<AVBitStreamFilter.filter_callback > filter) {
		this.io.setPointerField(this, 5, filter);
		return this;
	}
	/** C type : close_callback* */
	@Field(6) 
	public Pointer<org.ffmpeg.avcodec.AVCodec.close_callback > close() {
		return this.io.getPointerField(this, 6);
	}
	/** C type : close_callback* */
	@Field(6) 
	public AVBitStreamFilter close(Pointer<org.ffmpeg.avcodec.AVCodec.close_callback > close) {
		this.io.setPointerField(this, 6, close);
		return this;
	}
	/** C type : flush_callback* */
	@Field(7) 
	public Pointer<org.ffmpeg.avcodec.AVCodec.flush_callback > flush() {
		return this.io.getPointerField(this, 7);
	}
	/** C type : flush_callback* */
	@Field(7) 
	public AVBitStreamFilter flush(Pointer<org.ffmpeg.avcodec.AVCodec.flush_callback > flush) {
		this.io.setPointerField(this, 7, flush);
		return this;
	}
	/** <i>native declaration : ./libavcodec/bsf.h:70</i> */
	public static abstract class init_callback extends Callback<init_callback > {
		public int apply(Pointer<AVBSFContext > ctx) {
			return apply(Pointer.getPeer(ctx));
		}
		public int apply(@Ptr long ctx) {
			return apply(Pointer.pointerToAddress(ctx, AVBSFContext.class));
		}
	};
	/** <i>native declaration : ./libavcodec/bsf.h:71</i> */
	public static abstract class filter_callback extends Callback<filter_callback > {
		public int apply(Pointer<AVBSFContext > ctx, Pointer<AVPacket > pkt) {
			return apply(Pointer.getPeer(ctx), Pointer.getPeer(pkt));
		}
		public int apply(@Ptr long ctx, @Ptr long pkt) {
			return apply(Pointer.pointerToAddress(ctx, AVBSFContext.class), Pointer.pointerToAddress(pkt, AVPacket.class));
		}
	};
	/** <i>native declaration : ./libavcodec/bsf.h:72</i> */
	public static abstract class close_callback extends Callback<close_callback > {
		public void apply(Pointer<AVBSFContext > ctx) {
			apply(Pointer.getPeer(ctx));
		}
		public void apply(@Ptr long ctx) {
			apply(Pointer.pointerToAddress(ctx, AVBSFContext.class));
		}
	};
	/** <i>native declaration : ./libavcodec/bsf.h:73</i> */
	public static abstract class flush_callback extends Callback<flush_callback > {
		public void apply(Pointer<AVBSFContext > ctx) {
			apply(Pointer.getPeer(ctx));
		}
		public void apply(@Ptr long ctx) {
			apply(Pointer.pointerToAddress(ctx, AVBSFContext.class));
		}
	};
	public AVBitStreamFilter() {
		super();
	}
	public AVBitStreamFilter(Pointer pointer) {
		super(pointer);
	}
}
