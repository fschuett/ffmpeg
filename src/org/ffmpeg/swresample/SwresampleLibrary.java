package org.ffmpeg.swresample;
import java.util.Collections;
import java.util.Iterator;
import org.bridj.BridJ;
import org.bridj.CRuntime;
import org.bridj.FlagSet;
import org.bridj.IntValuedEnum;
import org.bridj.Pointer;
import org.bridj.ann.Library;
import org.bridj.ann.Ptr;
import org.bridj.ann.Runtime;
import org.ffmpeg.avutil.AVClass;
import org.ffmpeg.avutil.AVFrame;
import org.ffmpeg.avutil.AvutilLibrary.AVMatrixEncoding;
import org.ffmpeg.avutil.AvutilLibrary.AVSampleFormat;
/**
 * Wrapper for library <b>swresample</b><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("swresample") 
@Runtime(CRuntime.class) 
public class SwresampleLibrary {
	static {
		BridJ.register();
	}
	/**
	 * Dithering algorithms<br>
	 * enum values<br>
	 * <i>native declaration : libswresample/swresample.h:17</i>
	 */
	public enum SwrDitherType implements IntValuedEnum<SwrDitherType > {
		SWR_DITHER_NONE(0),
		SWR_DITHER_RECTANGULAR(1),
		SWR_DITHER_TRIANGULAR(2),
		SWR_DITHER_TRIANGULAR_HIGHPASS(3),
		/** < not part of API/ABI */
		SWR_DITHER_NS(64),
		SWR_DITHER_NS_LIPSHITZ(65),
		SWR_DITHER_NS_F_WEIGHTED(66),
		SWR_DITHER_NS_MODIFIED_E_WEIGHTED(67),
		SWR_DITHER_NS_IMPROVED_E_WEIGHTED(68),
		SWR_DITHER_NS_SHIBATA(69),
		SWR_DITHER_NS_LOW_SHIBATA(70),
		SWR_DITHER_NS_HIGH_SHIBATA(71),
		/** < not part of API/ABI */
		SWR_DITHER_NB(72);
		SwrDitherType(long value) {
			this.value = value;
		}
		public final long value;
		public long value() {
			return this.value;
		}
		public Iterator<SwrDitherType > iterator() {
			return Collections.singleton(this).iterator();
		}
		public static IntValuedEnum<SwrDitherType > fromValue(int value) {
			return FlagSet.fromValue(value, values());
		}
	};
	/**
	 * Resampling Engines<br>
	 * enum values<br>
	 * <i>native declaration : libswresample/swresample.h:24</i>
	 */
	public enum SwrEngine implements IntValuedEnum<SwrEngine > {
		/** < SW Resampler */
		SWR_ENGINE_SWR(0),
		/** < SoX Resampler */
		SWR_ENGINE_SOXR(1),
		/** < not part of API/ABI */
		SWR_ENGINE_NB(2);
		SwrEngine(long value) {
			this.value = value;
		}
		public final long value;
		public long value() {
			return this.value;
		}
		public Iterator<SwrEngine > iterator() {
			return Collections.singleton(this).iterator();
		}
		public static IntValuedEnum<SwrEngine > fromValue(int value) {
			return FlagSet.fromValue(value, values());
		}
	};
	/**
	 * Resampling Filter Types<br>
	 * enum values<br>
	 * <i>native declaration : libswresample/swresample.h:30</i>
	 */
	public enum SwrFilterType implements IntValuedEnum<SwrFilterType > {
		/** < Cubic */
		SWR_FILTER_TYPE_CUBIC(0),
		/** < Blackman Nuttall windowed sinc */
		SWR_FILTER_TYPE_BLACKMAN_NUTTALL(1),
		/** < Kaiser windowed sinc */
		SWR_FILTER_TYPE_KAISER(2);
		SwrFilterType(long value) {
			this.value = value;
		}
		public final long value;
		public long value() {
			return this.value;
		}
		public Iterator<SwrFilterType > iterator() {
			return Collections.singleton(this).iterator();
		}
		public static IntValuedEnum<SwrFilterType > fromValue(int value) {
			return FlagSet.fromValue(value, values());
		}
	};
	/**
	 * Conversion Error : a.num<br>
	 * SKIPPED:<br>
	 * <i>native declaration : libavutil/rational.h:30</i><br>
	 * const int64_t tmp = a.num * (int64_t)b.den - b.num * (int64_t)a.den;
	 */
	/** <i>native declaration : ./libswresample/version.h</i> */
	public static final int LIBSWRESAMPLE_VERSION_INT = (int)((2) << 16 | (7) << 8 | (100));
	/** <i>native declaration : ./libswresample/version.h</i> */
	public static final int LIBSWRESAMPLE_BUILD = (int)((2) << 16 | (7) << 8 | (100));
	/**
	 * define<br>
	 * Conversion Error : 2.7.<br>
	 * SKIPPED:<br>
	 * <i>native declaration : ./libswresample/version.h:0</i><br>
	 * 2.7.
	 */
	/** <i>native declaration : ./libswresample/version.h</i> */
	public static final int LIBSWRESAMPLE_VERSION_MICRO = (int)100;
	/** <i>native declaration : libswresample/swresample.h</i> */
	public static final int SWR_FLAG_RESAMPLE = (int)1;
	/** <i>native declaration : ./libswresample/version.h</i> */
	public static final int LIBSWRESAMPLE_VERSION_MAJOR = (int)2;
	/** <i>native declaration : ./libswresample/version.h</i> */
	public static final int LIBSWRESAMPLE_VERSION_MINOR = (int)7;
	/** <i>native declaration : ./libswresample/version.h</i> */
	public static final String LIBSWRESAMPLE_IDENT = (String)"SwR2.7.100";
	/**
	 * Get the AVClass for SwrContext. It can be used in combination with<br>
	 * AV_OPT_SEARCH_FAKE_OBJ for examining options.<br>
	 * * @see av_opt_find().<br>
	 * @return the AVClass of SwrContext<br>
	 * Original signature : <code>AVClass* swr_get_class()</code><br>
	 * <i>native declaration : libswresample/swresample.h:47</i>
	 */
	public static Pointer<AVClass > swr__get_class() {
		return Pointer.pointerToAddress(swr_get_class(), AVClass.class);
	}
	@Ptr 
	protected native static long swr_get_class();
	/**
	 * Allocate SwrContext.<br>
	 * * If you use this function you will need to set the parameters (manually or<br>
	 * with swr_alloc_set_opts()) before calling swr_init().<br>
	 * * @see swr_alloc_set_opts(), swr_init(), swr_free()<br>
	 * @return NULL on error, allocated context otherwise<br>
	 * Original signature : <code>SwrContext* swr_alloc()</code><br>
	 * <i>native declaration : libswresample/swresample.h:56</i>
	 */
	public static Pointer<SwrContext > swr__alloc() {
		return Pointer.pointerToAddress(swr_alloc(), SwrContext.class);
	}
	@Ptr 
	protected native static long swr_alloc();
	/**
	 * Initialize context after user parameters have been set.<br>
	 * @note The context must be configured using the AVOption API.<br>
	 * * @see av_opt_set_int()<br>
	 * @see av_opt_set_dict()<br>
	 * * @param[in,out]   s Swr context to initialize<br>
	 * @return AVERROR error code in case of failure.<br>
	 * Original signature : <code>int swr_init(SwrContext*)</code><br>
	 * <i>native declaration : libswresample/swresample.h:66</i>
	 */
	public static int swr_init(Pointer<SwrContext > s) {
		return swr_init(Pointer.getPeer(s));
	}
	protected native static int swr_init(@Ptr long s);
	/**
	 * Check whether an swr context has been initialized or not.<br>
	 * * @param[in]       s Swr context to check<br>
	 * @see swr_init()<br>
	 * @return positive if it has been initialized, 0 if not initialized<br>
	 * Original signature : <code>int swr_is_initialized(SwrContext*)</code><br>
	 * <i>native declaration : libswresample/swresample.h:74</i>
	 */
	public static int swr_is_initialized(Pointer<SwrContext > s) {
		return swr_is_initialized(Pointer.getPeer(s));
	}
	protected native static int swr_is_initialized(@Ptr long s);
	/**
	 * Allocate SwrContext if needed and set/reset common parameters.<br>
	 * * This function does not require s to be allocated with swr_alloc(). On the<br>
	 * other hand, swr_alloc() can use swr_alloc_set_opts() to set the parameters<br>
	 * on the allocated context.<br>
	 * * @param s               existing Swr context if available, or NULL if not<br>
	 * @param out_ch_layout   output channel layout (AV_CH_LAYOUT_*)<br>
	 * @param out_sample_fmt  output sample format (AV_SAMPLE_FMT_*).<br>
	 * @param out_sample_rate output sample rate (frequency in Hz)<br>
	 * @param in_ch_layout    input channel layout (AV_CH_LAYOUT_*)<br>
	 * @param in_sample_fmt   input sample format (AV_SAMPLE_FMT_*).<br>
	 * @param in_sample_rate  input sample rate (frequency in Hz)<br>
	 * @param log_offset      logging level offset<br>
	 * @param log_ctx         parent logging context, can be NULL<br>
	 * * @see swr_init(), swr_free()<br>
	 * @return NULL on error, allocated context otherwise<br>
	 * Original signature : <code>SwrContext* swr_alloc_set_opts(SwrContext*, int64_t, AVSampleFormat, int, int64_t, AVSampleFormat, int, int, void*)</code><br>
	 * <i>native declaration : libswresample/swresample.h:93</i>
	 */
	public static Pointer<SwrContext > swr_alloc_set_opts(Pointer<SwrContext > s, long out_ch_layout, IntValuedEnum<AVSampleFormat > out_sample_fmt, int out_sample_rate, long in_ch_layout, IntValuedEnum<AVSampleFormat > in_sample_fmt, int in_sample_rate, int log_offset, Pointer<? > log_ctx) {
		return Pointer.pointerToAddress(swr_alloc_set_opts(Pointer.getPeer(s), out_ch_layout, (int)out_sample_fmt.value(), out_sample_rate, in_ch_layout, (int)in_sample_fmt.value(), in_sample_rate, log_offset, Pointer.getPeer(log_ctx)), SwrContext.class);
	}
	@Ptr 
	protected native static long swr_alloc_set_opts(@Ptr long s, long out_ch_layout, int out_sample_fmt, int out_sample_rate, long in_ch_layout, int in_sample_fmt, int in_sample_rate, int log_offset, @Ptr long log_ctx);
	/**
	 * Free the given SwrContext and set the pointer to NULL.<br>
	 * * @param[in] s a pointer to a pointer to Swr context<br>
	 * Original signature : <code>void swr_free(SwrContext**)</code><br>
	 * <i>native declaration : libswresample/swresample.h:99</i>
	 */
	public static void swr_free(Pointer<Pointer<SwrContext > > s) {
		swr_free(Pointer.getPeer(s));
	}
	protected native static void swr_free(@Ptr long s);
	/**
	 * Closes the context so that swr_is_initialized() returns 0.<br>
	 * * The context can be brought back to life by running swr_init(),<br>
	 * swr_init() can also be used without swr_close().<br>
	 * This function is mainly provided for simplifying the usecase<br>
	 * where one tries to support libavresample and libswresample.<br>
	 * * @param[in,out] s Swr context to be closed<br>
	 * Original signature : <code>void swr_close(SwrContext*)</code><br>
	 * <i>native declaration : libswresample/swresample.h:109</i>
	 */
	public static void swr_close(Pointer<SwrContext > s) {
		swr_close(Pointer.getPeer(s));
	}
	protected native static void swr_close(@Ptr long s);
	/**
	 * Convert audio.<br>
	 * * in and in_count can be set to 0 to flush the last few samples out at the<br>
	 * end.<br>
	 * * If more input is provided than output space, then the input will be buffered.<br>
	 * You can avoid this buffering by using swr_get_out_samples() to retrieve an<br>
	 * upper bound on the required number of output samples for the given number of<br>
	 * input samples. Conversion will run directly without copying whenever possible.<br>
	 * * @param s         allocated Swr context, with parameters set<br>
	 * @param out       output buffers, only the first one need be set in case of packed audio<br>
	 * @param out_count amount of space available for output in samples per channel<br>
	 * @param in        input buffers, only the first one need to be set in case of packed audio<br>
	 * @param in_count  number of input samples available in one channel<br>
	 * * @return number of samples output per channel, negative value on error<br>
	 * Original signature : <code>int swr_convert(SwrContext*, uint8_t**, int, const uint8_t**, int)</code><br>
	 * <i>native declaration : libswresample/swresample.h:126</i>
	 */
	public static int swr_convert(Pointer<SwrContext > s, Pointer<Pointer<Byte > > out, int out_count, Pointer<Pointer<Byte > > in, int in_count) {
		return swr_convert(Pointer.getPeer(s), Pointer.getPeer(out), out_count, Pointer.getPeer(in), in_count);
	}
	protected native static int swr_convert(@Ptr long s, @Ptr long out, int out_count, @Ptr long in, int in_count);
	/**
	 * Convert the next timestamp from input to output<br>
	 * timestamps are in 1/(in_sample_rate * out_sample_rate) units.<br>
	 * * @note There are 2 slightly differently behaving modes.<br>
	 *       @li When automatic timestamp compensation is not used, (min_compensation >= FLT_MAX)<br>
	 *              in this case timestamps will be passed through with delays compensated<br>
	 *       @li When automatic timestamp compensation is used, (min_compensation < FLT_MAX)<br>
	 *              in this case the output timestamps will match output sample numbers.<br>
	 *              See ffmpeg-resampler(1) for the two modes of compensation.<br>
	 * * @param s[in]     initialized Swr context<br>
	 * @param pts[in]   timestamp for the next input sample, INT64_MIN if unknown<br>
	 * @see swr_set_compensation(), swr_drop_output(), and swr_inject_silence() are<br>
	 *      function used internally for timestamp compensation.<br>
	 * @return the output timestamp for the next output sample<br>
	 * Original signature : <code>int64_t swr_next_pts(SwrContext*, int64_t)</code><br>
	 * <i>native declaration : libswresample/swresample.h:143</i>
	 */
	public static long swr_next_pts(Pointer<SwrContext > s, long pts) {
		return swr_next_pts(Pointer.getPeer(s), pts);
	}
	protected native static long swr_next_pts(@Ptr long s, long pts);
	/**
	 * Activate resampling compensation ("soft" compensation). This function is<br>
	 * internally called when needed in swr_next_pts().<br>
	 * * @param[in,out] s             allocated Swr context. If it is not initialized,<br>
	 *                              or SWR_FLAG_RESAMPLE is not set, swr_init() is<br>
	 *                              called with the flag set.<br>
	 * @param[in]     sample_delta  delta in PTS per sample<br>
	 * @param[in]     compensation_distance number of samples to compensate for<br>
	 * @return    >= 0 on success, AVERROR error codes if:<br>
	 *            @li @c s is NULL,<br>
	 *            @li @c compensation_distance is less than 0,<br>
	 *            @li @c compensation_distance is 0 but sample_delta is not,<br>
	 *            @li compensation unsupported by resampler, or<br>
	 *            @li swr_init() fails when called.<br>
	 * Original signature : <code>int swr_set_compensation(SwrContext*, int, int)</code><br>
	 * <i>native declaration : libswresample/swresample.h:160</i>
	 */
	public static int swr_set_compensation(Pointer<SwrContext > s, int sample_delta, int compensation_distance) {
		return swr_set_compensation(Pointer.getPeer(s), sample_delta, compensation_distance);
	}
	protected native static int swr_set_compensation(@Ptr long s, int sample_delta, int compensation_distance);
	/**
	 * Set a customized input channel mapping.<br>
	 * * @param[in,out] s           allocated Swr context, not yet initialized<br>
	 * @param[in]     channel_map customized input channel mapping (array of channel<br>
	 *                            indexes, -1 for a muted channel)<br>
	 * @return >= 0 on success, or AVERROR error code in case of failure.<br>
	 * Original signature : <code>int swr_set_channel_mapping(SwrContext*, const int*)</code><br>
	 * <i>native declaration : libswresample/swresample.h:169</i>
	 */
	public static int swr_set_channel_mapping(Pointer<SwrContext > s, Pointer<Integer > channel_map) {
		return swr_set_channel_mapping(Pointer.getPeer(s), Pointer.getPeer(channel_map));
	}
	protected native static int swr_set_channel_mapping(@Ptr long s, @Ptr long channel_map);
	/**
	 * Generate a channel mixing matrix.<br>
	 * * This function is the one used internally by libswresample for building the<br>
	 * default mixing matrix. It is made public just as a utility function for<br>
	 * building custom matrices.<br>
	 * * @param in_layout           input channel layout<br>
	 * @param out_layout          output channel layout<br>
	 * @param center_mix_level    mix level for the center channel<br>
	 * @param surround_mix_level  mix level for the surround channel(s)<br>
	 * @param lfe_mix_level       mix level for the low-frequency effects channel<br>
	 * @param rematrix_maxval     if 1.0, coefficients will be normalized to prevent<br>
	 *                            overflow. if INT_MAX, coefficients will not be<br>
	 *                            normalized.<br>
	 * @param[out] matrix         mixing coefficients; matrix[i + stride * o] is<br>
	 *                            the weight of input channel i in output channel o.<br>
	 * @param stride              distance between adjacent input channels in the<br>
	 *                            matrix array<br>
	 * @param matrix_encoding     matrixed stereo downmix mode (e.g. dplii)<br>
	 * @param log_ctx             parent logging context, can be NULL<br>
	 * @return                    0 on success, negative AVERROR code on failure<br>
	 * Original signature : <code>int swr_build_matrix(uint64_t, uint64_t, double, double, double, double, double, double*, int, AVMatrixEncoding, void*)</code><br>
	 * <i>native declaration : libswresample/swresample.h:192</i>
	 */
	public static int swr_build_matrix(long in_layout, long out_layout, double center_mix_level, double surround_mix_level, double lfe_mix_level, double rematrix_maxval, double rematrix_volume, Pointer<Double > matrix, int stride, IntValuedEnum<AVMatrixEncoding > matrix_encoding, Pointer<? > log_ctx) {
		return swr_build_matrix(in_layout, out_layout, center_mix_level, surround_mix_level, lfe_mix_level, rematrix_maxval, rematrix_volume, Pointer.getPeer(matrix), stride, (int)matrix_encoding.value(), Pointer.getPeer(log_ctx));
	}
	protected native static int swr_build_matrix(long in_layout, long out_layout, double center_mix_level, double surround_mix_level, double lfe_mix_level, double rematrix_maxval, double rematrix_volume, @Ptr long matrix, int stride, int matrix_encoding, @Ptr long log_ctx);
	/**
	 * Set a customized remix matrix.<br>
	 * * @param s       allocated Swr context, not yet initialized<br>
	 * @param matrix  remix coefficients; matrix[i + stride * o] is<br>
	 *                the weight of input channel i in output channel o<br>
	 * @param stride  offset between lines of the matrix<br>
	 * @return  >= 0 on success, or AVERROR error code in case of failure.<br>
	 * Original signature : <code>int swr_set_matrix(SwrContext*, const double*, int)</code><br>
	 * <i>native declaration : libswresample/swresample.h:202</i>
	 */
	public static int swr_set_matrix(Pointer<SwrContext > s, Pointer<Double > matrix, int stride) {
		return swr_set_matrix(Pointer.getPeer(s), Pointer.getPeer(matrix), stride);
	}
	protected native static int swr_set_matrix(@Ptr long s, @Ptr long matrix, int stride);
	/**
	 * Drops the specified number of output samples.<br>
	 * * This function, along with swr_inject_silence(), is called by swr_next_pts()<br>
	 * if needed for "hard" compensation.<br>
	 * * @param s     allocated Swr context<br>
	 * @param count number of samples to be dropped<br>
	 * * @return >= 0 on success, or a negative AVERROR code on failure<br>
	 * Original signature : <code>int swr_drop_output(SwrContext*, int)</code><br>
	 * <i>native declaration : libswresample/swresample.h:212</i>
	 */
	public static int swr_drop_output(Pointer<SwrContext > s, int count) {
		return swr_drop_output(Pointer.getPeer(s), count);
	}
	protected native static int swr_drop_output(@Ptr long s, int count);
	/**
	 * Injects the specified number of silence samples.<br>
	 * * This function, along with swr_drop_output(), is called by swr_next_pts()<br>
	 * if needed for "hard" compensation.<br>
	 * * @param s     allocated Swr context<br>
	 * @param count number of samples to be dropped<br>
	 * * @return >= 0 on success, or a negative AVERROR code on failure<br>
	 * Original signature : <code>int swr_inject_silence(SwrContext*, int)</code><br>
	 * <i>native declaration : libswresample/swresample.h:222</i>
	 */
	public static int swr_inject_silence(Pointer<SwrContext > s, int count) {
		return swr_inject_silence(Pointer.getPeer(s), count);
	}
	protected native static int swr_inject_silence(@Ptr long s, int count);
	/**
	 * Gets the delay the next input sample will experience relative to the next output sample.<br>
	 * * Swresample can buffer data if more input has been provided than available<br>
	 * output space, also converting between sample rates needs a delay.<br>
	 * This function returns the sum of all such delays.<br>
	 * The exact delay is not necessarily an integer value in either input or<br>
	 * output sample rate. Especially when downsampling by a large value, the<br>
	 * output sample rate may be a poor choice to represent the delay, similarly<br>
	 * for upsampling and the input sample rate.<br>
	 * * @param s     swr context<br>
	 * @param base  timebase in which the returned delay will be:<br>
	 *              @li if it's set to 1 the returned delay is in seconds<br>
	 *              @li if it's set to 1000 the returned delay is in milliseconds<br>
	 *              @li if it's set to the input sample rate then the returned<br>
	 *                  delay is in input samples<br>
	 *              @li if it's set to the output sample rate then the returned<br>
	 *                  delay is in output samples<br>
	 *              @li if it's the least common multiple of in_sample_rate and<br>
	 *                  out_sample_rate then an exact rounding-free delay will be<br>
	 *                  returned<br>
	 * @returns     the delay in 1 / @c base units.<br>
	 * Original signature : <code>int64_t swr_get_delay(SwrContext*, int64_t)</code><br>
	 * <i>native declaration : libswresample/swresample.h:246</i>
	 */
	public static long swr_get_delay(Pointer<SwrContext > s, long base) {
		return swr_get_delay(Pointer.getPeer(s), base);
	}
	protected native static long swr_get_delay(@Ptr long s, long base);
	/**
	 * Find an upper bound on the number of samples that the next swr_convert<br>
	 * call will output, if called with in_samples of input samples. This<br>
	 * depends on the internal state, and anything changing the internal state<br>
	 * (like further swr_convert() calls) will may change the number of samples<br>
	 * swr_get_out_samples() returns for the same number of input samples.<br>
	 * * @param in_samples    number of input samples.<br>
	 * @note any call to swr_inject_silence(), swr_convert(), swr_next_pts()<br>
	 *       or swr_set_compensation() invalidates this limit<br>
	 * @note it is recommended to pass the correct available buffer size<br>
	 *       to all functions like swr_convert() even if swr_get_out_samples()<br>
	 *       indicates that less would be used.<br>
	 * @returns an upper bound on the number of samples that the next swr_convert<br>
	 *          will output or a negative value to indicate an error<br>
	 * Original signature : <code>int swr_get_out_samples(SwrContext*, int)</code><br>
	 * <i>native declaration : libswresample/swresample.h:263</i>
	 */
	public static int swr_get_out_samples(Pointer<SwrContext > s, int in_samples) {
		return swr_get_out_samples(Pointer.getPeer(s), in_samples);
	}
	protected native static int swr_get_out_samples(@Ptr long s, int in_samples);
	/**
	 * Return the @ref LIBSWRESAMPLE_VERSION_INT constant.<br>
	 * * This is useful to check if the build-time libswresample has the same version<br>
	 * as the run-time one.<br>
	 * * @returns     the unsigned int-typed version<br>
	 * Original signature : <code>int swresample_version()</code><br>
	 * <i>native declaration : libswresample/swresample.h:271</i>
	 */
	public static native int swresample_version();
	/**
	 * Return the swr build-time configuration.<br>
	 * * @returns     the build-time @c ./configure flags<br>
	 * Original signature : <code>char* swresample_configuration()</code><br>
	 * <i>native declaration : libswresample/swresample.h:277</i>
	 */
	public static Pointer<Byte > swresample__configuration() {
		return Pointer.pointerToAddress(swresample_configuration(), Byte.class);
	}
	@Ptr 
	protected native static long swresample_configuration();
	/**
	 * Return the swr license.<br>
	 * * @returns     the license of libswresample, determined at build-time<br>
	 * Original signature : <code>char* swresample_license()</code><br>
	 * <i>native declaration : libswresample/swresample.h:283</i>
	 */
	public static Pointer<Byte > swresample__license() {
		return Pointer.pointerToAddress(swresample_license(), Byte.class);
	}
	@Ptr 
	protected native static long swresample_license();
	/**
	 * Convert the samples in the input AVFrame and write them to the output AVFrame.<br>
	 * * Input and output AVFrames must have channel_layout, sample_rate and format set.<br>
	 * * If the output AVFrame does not have the data pointers allocated the nb_samples<br>
	 * field will be set using av_frame_get_buffer()<br>
	 * is called to allocate the frame.<br>
	 * * The output AVFrame can be NULL or have fewer allocated samples than required.<br>
	 * In this case, any remaining samples not written to the output will be added<br>
	 * to an internal FIFO buffer, to be returned at the next call to this function<br>
	 * or to swr_convert().<br>
	 * * If converting sample rate, there may be data remaining in the internal<br>
	 * resampling delay buffer. swr_get_delay() tells the number of<br>
	 * remaining samples. To get this data as output, call this function or<br>
	 * swr_convert() with NULL input.<br>
	 * * If the SwrContext configuration does not match the output and<br>
	 * input AVFrame settings the conversion does not take place and depending on<br>
	 * which AVFrame is not matching AVERROR_OUTPUT_CHANGED, AVERROR_INPUT_CHANGED<br>
	 * or the result of a bitwise-OR of them is returned.<br>
	 * * @see swr_delay()<br>
	 * @see swr_convert()<br>
	 * @see swr_get_delay()<br>
	 * * @param swr             audio resample context<br>
	 * @param output          output AVFrame<br>
	 * @param input           input AVFrame<br>
	 * @return                0 on success, AVERROR on failure or nonmatching<br>
	 *                        configuration.<br>
	 * Original signature : <code>int swr_convert_frame(SwrContext*, AVFrame*, const AVFrame*)</code><br>
	 * <i>native declaration : libswresample/swresample.h:312</i>
	 */
	public static int swr_convert_frame(Pointer<SwrContext > swr, Pointer<AVFrame > output, Pointer<AVFrame > input) {
		return swr_convert_frame(Pointer.getPeer(swr), Pointer.getPeer(output), Pointer.getPeer(input));
	}
	protected native static int swr_convert_frame(@Ptr long swr, @Ptr long output, @Ptr long input);
	/**
	 * Configure or reconfigure the SwrContext using the information<br>
	 * provided by the AVFrames.<br>
	 * * The original resampling context is reset even on failure.<br>
	 * The function calls swr_close() internally if the context is open.<br>
	 * * @see swr_close();<br>
	 * * @param swr             audio resample context<br>
	 * @param output          output AVFrame<br>
	 * @param input           input AVFrame<br>
	 * @return                0 on success, AVERROR on failure.<br>
	 * Original signature : <code>int swr_config_frame(SwrContext*, const AVFrame*, const AVFrame*)</code><br>
	 * <i>native declaration : libswresample/swresample.h:325</i>
	 */
	public static int swr_config_frame(Pointer<SwrContext > swr, Pointer<AVFrame > out, Pointer<AVFrame > in) {
		return swr_config_frame(Pointer.getPeer(swr), Pointer.getPeer(out), Pointer.getPeer(in));
	}
	protected native static int swr_config_frame(@Ptr long swr, @Ptr long out, @Ptr long in);
}
