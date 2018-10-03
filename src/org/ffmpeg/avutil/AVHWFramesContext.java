package org.ffmpeg.avutil;
import org.bridj.BridJ;
import org.bridj.Callback;
import org.bridj.IntValuedEnum;
import org.bridj.Pointer;
import org.bridj.StructObject;
import org.bridj.ann.Field;
import org.bridj.ann.Library;
import org.bridj.ann.Ptr;
import org.ffmpeg.avutil.AvutilLibrary.AVPixelFormat;
/**
 * <i>native declaration : ./libavutil/hwcontext.h:173</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("avutil") 
public class AVHWFramesContext extends StructObject {
	static {
		BridJ.register();
	}
	/**
	 * A class for logging.<br>
	 * C type : const AVClass*
	 */
	@Field(0) 
	public Pointer<AVClass > av_class() {
		return this.io.getPointerField(this, 0);
	}
	/**
	 * A class for logging.<br>
	 * C type : const AVClass*
	 */
	@Field(0) 
	public AVHWFramesContext av_class(Pointer<AVClass > av_class) {
		this.io.setPointerField(this, 0, av_class);
		return this;
	}
	/**
	 * Private data used internally by libavutil. Must not be accessed in any<br>
	 * way by the caller.<br>
	 * C type : AVHWFramesInternal*
	 */
	@Field(1) 
	public Pointer<AVHWFramesInternal > internal() {
		return this.io.getPointerField(this, 1);
	}
	/**
	 * Private data used internally by libavutil. Must not be accessed in any<br>
	 * way by the caller.<br>
	 * C type : AVHWFramesInternal*
	 */
	@Field(1) 
	public AVHWFramesContext internal(Pointer<AVHWFramesInternal > internal) {
		this.io.setPointerField(this, 1, internal);
		return this;
	}
	/**
	 * A reference to the parent AVHWDeviceContext. This reference is owned and<br>
	 * managed by the enclosing AVHWFramesContext, but the caller may derive<br>
	 * additional references from it.<br>
	 * C type : AVBufferRef*
	 */
	@Field(2) 
	public Pointer<AVBufferRef > device_ref() {
		return this.io.getPointerField(this, 2);
	}
	/**
	 * A reference to the parent AVHWDeviceContext. This reference is owned and<br>
	 * managed by the enclosing AVHWFramesContext, but the caller may derive<br>
	 * additional references from it.<br>
	 * C type : AVBufferRef*
	 */
	@Field(2) 
	public AVHWFramesContext device_ref(Pointer<AVBufferRef > device_ref) {
		this.io.setPointerField(this, 2, device_ref);
		return this;
	}
	/**
	 * The parent AVHWDeviceContext. This is simply a pointer to<br>
	 * device_ref->data provided for convenience.<br>
	 * * Set by libavutil in av_hwframe_ctx_init().<br>
	 * C type : AVHWDeviceContext*
	 */
	@Field(3) 
	public Pointer<AVHWDeviceContext > device_ctx() {
		return this.io.getPointerField(this, 3);
	}
	/**
	 * The parent AVHWDeviceContext. This is simply a pointer to<br>
	 * device_ref->data provided for convenience.<br>
	 * * Set by libavutil in av_hwframe_ctx_init().<br>
	 * C type : AVHWDeviceContext*
	 */
	@Field(3) 
	public AVHWFramesContext device_ctx(Pointer<AVHWDeviceContext > device_ctx) {
		this.io.setPointerField(this, 3, device_ctx);
		return this;
	}
	/**
	 * The format-specific data, allocated and freed automatically along with<br>
	 * this context.<br>
	 * * Should be cast by the user to the format-specific context defined in the<br>
	 * corresponding header (hwframe_*.h) and filled as described in the<br>
	 * documentation before calling av_hwframe_ctx_init().<br>
	 * * After any frames using this context are created, the contents of this<br>
	 * struct should not be modified by the caller.<br>
	 * C type : void*
	 */
	@Field(4) 
	public Pointer<? > hwctx() {
		return this.io.getPointerField(this, 4);
	}
	/**
	 * The format-specific data, allocated and freed automatically along with<br>
	 * this context.<br>
	 * * Should be cast by the user to the format-specific context defined in the<br>
	 * corresponding header (hwframe_*.h) and filled as described in the<br>
	 * documentation before calling av_hwframe_ctx_init().<br>
	 * * After any frames using this context are created, the contents of this<br>
	 * struct should not be modified by the caller.<br>
	 * C type : void*
	 */
	@Field(4) 
	public AVHWFramesContext hwctx(Pointer<? > hwctx) {
		this.io.setPointerField(this, 4, hwctx);
		return this;
	}
	/**
	 * This field may be set by the caller before calling av_hwframe_ctx_init().<br>
	 * * If non-NULL, this callback will be called when the last reference to<br>
	 * this context is unreferenced, immediately before it is freed.<br>
	 * C type : free_callback*
	 */
	@Field(5) 
	public Pointer<AVHWFramesContext.free_callback > free() {
		return this.io.getPointerField(this, 5);
	}
	/**
	 * This field may be set by the caller before calling av_hwframe_ctx_init().<br>
	 * * If non-NULL, this callback will be called when the last reference to<br>
	 * this context is unreferenced, immediately before it is freed.<br>
	 * C type : free_callback*
	 */
	@Field(5) 
	public AVHWFramesContext free(Pointer<AVHWFramesContext.free_callback > free) {
		this.io.setPointerField(this, 5, free);
		return this;
	}
	/**
	 * Arbitrary user data, to be used e.g. by the free() callback.<br>
	 * C type : void*
	 */
	@Field(6) 
	public Pointer<? > user_opaque() {
		return this.io.getPointerField(this, 6);
	}
	/**
	 * Arbitrary user data, to be used e.g. by the free() callback.<br>
	 * C type : void*
	 */
	@Field(6) 
	public AVHWFramesContext user_opaque(Pointer<? > user_opaque) {
		this.io.setPointerField(this, 6, user_opaque);
		return this;
	}
	/**
	 * A pool from which the frames are allocated by av_hwframe_get_buffer().<br>
	 * This field may be set by the caller before calling av_hwframe_ctx_init().<br>
	 * The buffers returned by calling av_buffer_pool_get() on this pool must<br>
	 * have the properties described in the documentation in the corresponding hw<br>
	 * type's header (hwcontext_*.h). The pool will be freed strictly before<br>
	 * this struct's free() callback is invoked.<br>
	 * * This field may be NULL, then libavutil will attempt to allocate a pool<br>
	 * internally. Note that certain device types enforce pools allocated at<br>
	 * fixed size (frame count), which cannot be extended dynamically. In such a<br>
	 * case, initial_pool_size must be set appropriately.<br>
	 * C type : AVBufferPool*
	 */
	@Field(7) 
	public Pointer<AVBufferPool > pool() {
		return this.io.getPointerField(this, 7);
	}
	/**
	 * A pool from which the frames are allocated by av_hwframe_get_buffer().<br>
	 * This field may be set by the caller before calling av_hwframe_ctx_init().<br>
	 * The buffers returned by calling av_buffer_pool_get() on this pool must<br>
	 * have the properties described in the documentation in the corresponding hw<br>
	 * type's header (hwcontext_*.h). The pool will be freed strictly before<br>
	 * this struct's free() callback is invoked.<br>
	 * * This field may be NULL, then libavutil will attempt to allocate a pool<br>
	 * internally. Note that certain device types enforce pools allocated at<br>
	 * fixed size (frame count), which cannot be extended dynamically. In such a<br>
	 * case, initial_pool_size must be set appropriately.<br>
	 * C type : AVBufferPool*
	 */
	@Field(7) 
	public AVHWFramesContext pool(Pointer<AVBufferPool > pool) {
		this.io.setPointerField(this, 7, pool);
		return this;
	}
	/**
	 * Initial size of the frame pool. If a device type does not support<br>
	 * dynamically resizing the pool, then this is also the maximum pool size.<br>
	 * * May be set by the caller before calling av_hwframe_ctx_init(). Must be<br>
	 * set if pool is NULL and the device type does not support dynamic pools.
	 */
	@Field(8) 
	public int initial_pool_size() {
		return this.io.getIntField(this, 8);
	}
	/**
	 * Initial size of the frame pool. If a device type does not support<br>
	 * dynamically resizing the pool, then this is also the maximum pool size.<br>
	 * * May be set by the caller before calling av_hwframe_ctx_init(). Must be<br>
	 * set if pool is NULL and the device type does not support dynamic pools.
	 */
	@Field(8) 
	public AVHWFramesContext initial_pool_size(int initial_pool_size) {
		this.io.setIntField(this, 8, initial_pool_size);
		return this;
	}
	/**
	 * The pixel format identifying the underlying HW surface type.<br>
	 * * Must be a hwaccel format, i.e. the corresponding descriptor must have the<br>
	 * AV_PIX_FMT_FLAG_HWACCEL flag set.<br>
	 * * Must be set by the user before calling av_hwframe_ctx_init().<br>
	 * C type : AVPixelFormat
	 */
	@Field(9) 
	public IntValuedEnum<AVPixelFormat > format() {
		return this.io.getEnumField(this, 9);
	}
	/**
	 * The pixel format identifying the underlying HW surface type.<br>
	 * * Must be a hwaccel format, i.e. the corresponding descriptor must have the<br>
	 * AV_PIX_FMT_FLAG_HWACCEL flag set.<br>
	 * * Must be set by the user before calling av_hwframe_ctx_init().<br>
	 * C type : AVPixelFormat
	 */
	@Field(9) 
	public AVHWFramesContext format(IntValuedEnum<AVPixelFormat > format) {
		this.io.setEnumField(this, 9, format);
		return this;
	}
	/**
	 * The pixel format identifying the actual data layout of the hardware<br>
	 * frames.<br>
	 * * Must be set by the caller before calling av_hwframe_ctx_init().<br>
	 * * @note when the underlying API does not provide the exact data layout, but<br>
	 * only the colorspace/bit depth, this field should be set to the fully<br>
	 * planar version of that format (e.g. for 8-bit 420 YUV it should be<br>
	 * AV_PIX_FMT_YUV420P, not AV_PIX_FMT_NV12 or anything else).<br>
	 * C type : AVPixelFormat
	 */
	@Field(10) 
	public IntValuedEnum<AVPixelFormat > sw_format() {
		return this.io.getEnumField(this, 10);
	}
	/**
	 * The pixel format identifying the actual data layout of the hardware<br>
	 * frames.<br>
	 * * Must be set by the caller before calling av_hwframe_ctx_init().<br>
	 * * @note when the underlying API does not provide the exact data layout, but<br>
	 * only the colorspace/bit depth, this field should be set to the fully<br>
	 * planar version of that format (e.g. for 8-bit 420 YUV it should be<br>
	 * AV_PIX_FMT_YUV420P, not AV_PIX_FMT_NV12 or anything else).<br>
	 * C type : AVPixelFormat
	 */
	@Field(10) 
	public AVHWFramesContext sw_format(IntValuedEnum<AVPixelFormat > sw_format) {
		this.io.setEnumField(this, 10, sw_format);
		return this;
	}
	/**
	 * The allocated dimensions of the frames in this pool.<br>
	 * * Must be set by the user before calling av_hwframe_ctx_init().
	 */
	@Field(11) 
	public int width() {
		return this.io.getIntField(this, 11);
	}
	/**
	 * The allocated dimensions of the frames in this pool.<br>
	 * * Must be set by the user before calling av_hwframe_ctx_init().
	 */
	@Field(11) 
	public AVHWFramesContext width(int width) {
		this.io.setIntField(this, 11, width);
		return this;
	}
	/**
	 * The allocated dimensions of the frames in this pool.<br>
	 * * Must be set by the user before calling av_hwframe_ctx_init().
	 */
	@Field(12) 
	public int height() {
		return this.io.getIntField(this, 12);
	}
	/**
	 * The allocated dimensions of the frames in this pool.<br>
	 * * Must be set by the user before calling av_hwframe_ctx_init().
	 */
	@Field(12) 
	public AVHWFramesContext height(int height) {
		this.io.setIntField(this, 12, height);
		return this;
	}
	/** <i>native declaration : ./libavutil/hwcontext.h:168</i> */
	public static abstract class free_callback extends Callback<free_callback > {
		public void apply(Pointer<AVHWFramesContext > ctx) {
			apply(Pointer.getPeer(ctx));
		}
		public void apply(@Ptr long ctx) {
			apply(Pointer.pointerToAddress(ctx, AVHWFramesContext.class));
		}
	};
	public AVHWFramesContext() {
		super();
	}
	public AVHWFramesContext(Pointer pointer) {
		super(pointer);
	}
}
