package org.ffmpeg.avresample;
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
/**
 * Wrapper for library <b>avresample</b><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> or <a href="http://bridj.googlecode.com/">BridJ</a> .
 */
@Library("avresample") 
@Runtime(CRuntime.class) 
public class AvresampleLibrary {
	static {
		BridJ.register();
	}
	/**
	 * @deprecated use libswresample<br>
	 * * Mixing Coefficient Types<br>
	 * enum values<br>
	 * <i>native declaration : libavresample/avresample.h:12</i>
	 */
	public enum AVMixCoeffType implements IntValuedEnum<AVMixCoeffType > {
		/** 16-bit 8.8 fixed-point */
		AV_MIX_COEFF_TYPE_Q8(0),
		/** 32-bit 17.15 fixed-point */
		AV_MIX_COEFF_TYPE_Q15(1),
		/** floating-point */
		AV_MIX_COEFF_TYPE_FLT(2),
		/** Number of coeff types. Not part of ABI */
		AV_MIX_COEFF_TYPE_NB(3);
		AVMixCoeffType(long value) {
			this.value = value;
		}
		public final long value;
		public long value() {
			return this.value;
		}
		public Iterator<AVMixCoeffType > iterator() {
			return Collections.singleton(this).iterator();
		}
		public static IntValuedEnum<AVMixCoeffType > fromValue(int value) {
			return FlagSet.fromValue(value, values());
		}
	};
	/**
	 * @deprecated use libswresample<br>
	 * * Resampling Filter Types<br>
	 * enum values<br>
	 * <i>native declaration : libavresample/avresample.h:21</i>
	 */
	public enum AVResampleFilterType implements IntValuedEnum<AVResampleFilterType > {
		/** < Cubic */
		AV_RESAMPLE_FILTER_TYPE_CUBIC(0),
		/** < Blackman Nuttall Windowed Sinc */
		AV_RESAMPLE_FILTER_TYPE_BLACKMAN_NUTTALL(1),
		/** < Kaiser Windowed Sinc */
		AV_RESAMPLE_FILTER_TYPE_KAISER(2);
		AVResampleFilterType(long value) {
			this.value = value;
		}
		public final long value;
		public long value() {
			return this.value;
		}
		public Iterator<AVResampleFilterType > iterator() {
			return Collections.singleton(this).iterator();
		}
		public static IntValuedEnum<AVResampleFilterType > fromValue(int value) {
			return FlagSet.fromValue(value, values());
		}
	};
	/**
	 * @deprecated use libswresample<br>
	 * enum values<br>
	 * <i>native declaration : libavresample/avresample.h:30</i>
	 */
	public enum AVResampleDitherMethod implements IntValuedEnum<AVResampleDitherMethod > {
		/** < Do not use dithering */
		AV_RESAMPLE_DITHER_NONE(0),
		/** < Rectangular Dither */
		AV_RESAMPLE_DITHER_RECTANGULAR(1),
		/** < Triangular Dither */
		AV_RESAMPLE_DITHER_TRIANGULAR(2),
		/** < Triangular Dither with High Pass */
		AV_RESAMPLE_DITHER_TRIANGULAR_HP(3),
		/** < Triangular Dither with Noise Shaping */
		AV_RESAMPLE_DITHER_TRIANGULAR_NS(4),
		/** < Number of dither types. Not part of ABI. */
		AV_RESAMPLE_DITHER_NB(5);
		AVResampleDitherMethod(long value) {
			this.value = value;
		}
		public final long value;
		public long value() {
			return this.value;
		}
		public Iterator<AVResampleDitherMethod > iterator() {
			return Collections.singleton(this).iterator();
		}
		public static IntValuedEnum<AVResampleDitherMethod > fromValue(int value) {
			return FlagSet.fromValue(value, values());
		}
	};
	/**
	 * Conversion Error : a.num<br>
	 * SKIPPED:<br>
	 * <i>native declaration : libavutil/rational.h:0</i><br>
	 * const int64_t tmp = a.num * (int64_t)b.den - b.num * (int64_t)a.den;
	 */
	/** <i>native declaration : ./libavresample/version.h</i> */
	public static final int LIBAVRESAMPLE_VERSION_MICRO = (int)0;
	/** <i>native declaration : ./libavresample/version.h</i> */
	public static final int LIBAVRESAMPLE_VERSION_INT = (int)((4) << 16 | (0) << 8 | (0));
	/** <i>native declaration : ./libavresample/version.h</i> */
	public static final String LIBAVRESAMPLE_IDENT = (String)"Lavr4.0.0";
	/** <i>native declaration : ./libavresample/version.h</i> */
	public static final int LIBAVRESAMPLE_BUILD = (int)((4) << 16 | (0) << 8 | (0));
	/** <i>native declaration : ./libavresample/version.h</i> */
	public static final int LIBAVRESAMPLE_VERSION_MINOR = (int)0;
	/** <i>native declaration : ./libavresample/version.h</i> */
	public static final int LIBAVRESAMPLE_VERSION_MAJOR = (int)4;
	/** <i>native declaration : libavresample/avresample.h</i> */
	public static final int AVRESAMPLE_MAX_CHANNELS = (int)32;
	/**
	 * define<br>
	 * Conversion Error : 4.0.<br>
	 * SKIPPED:<br>
	 * <i>native declaration : ./libavresample/version.h:0</i><br>
	 * 4.0.
	 */
	/**
	 * Original signature : <code>int avresample_version()</code><br>
	 * <i>native declaration : libavresample/avresample.h:32</i>
	 */
	public static native int avresample_version();
	/**
	 * Original signature : <code>char* avresample_configuration()</code><br>
	 * <i>native declaration : libavresample/avresample.h:34</i>
	 */
	public static Pointer<Byte > avresample__configuration() {
		return Pointer.pointerToAddress(avresample_configuration(), Byte.class);
	}
	@Ptr 
	protected native static long avresample_configuration();
	/**
	 * Original signature : <code>char* avresample_license()</code><br>
	 * <i>native declaration : libavresample/avresample.h:36</i>
	 */
	public static Pointer<Byte > avresample__license() {
		return Pointer.pointerToAddress(avresample_license(), Byte.class);
	}
	@Ptr 
	protected native static long avresample_license();
	/**
	 * Original signature : <code>AVClass* avresample_get_class()</code><br>
	 * <i>native declaration : libavresample/avresample.h:38</i>
	 */
	public static Pointer<AVClass > avresample__get_class() {
		return Pointer.pointerToAddress(avresample_get_class(), AVClass.class);
	}
	@Ptr 
	protected native static long avresample_get_class();
	/**
	 * Original signature : <code>AVAudioResampleContext* avresample_alloc_context()</code><br>
	 * <i>native declaration : libavresample/avresample.h:40</i>
	 */
	public static Pointer<AVAudioResampleContext > avresample__alloc_context() {
		return Pointer.pointerToAddress(avresample_alloc_context(), AVAudioResampleContext.class);
	}
	@Ptr 
	protected native static long avresample_alloc_context();
	/**
	 * Original signature : <code>int avresample_open(AVAudioResampleContext*)</code><br>
	 * <i>native declaration : libavresample/avresample.h:42</i>
	 */
	public static int avresample_open(Pointer<AVAudioResampleContext > avr) {
		return avresample_open(Pointer.getPeer(avr));
	}
	protected native static int avresample_open(@Ptr long avr);
	/**
	 * Original signature : <code>int avresample_is_open(AVAudioResampleContext*)</code><br>
	 * <i>native declaration : libavresample/avresample.h:44</i>
	 */
	public static int avresample_is_open(Pointer<AVAudioResampleContext > avr) {
		return avresample_is_open(Pointer.getPeer(avr));
	}
	protected native static int avresample_is_open(@Ptr long avr);
	/**
	 * Original signature : <code>void avresample_close(AVAudioResampleContext*)</code><br>
	 * <i>native declaration : libavresample/avresample.h:46</i>
	 */
	public static void avresample_close(Pointer<AVAudioResampleContext > avr) {
		avresample_close(Pointer.getPeer(avr));
	}
	protected native static void avresample_close(@Ptr long avr);
	/**
	 * Original signature : <code>void avresample_free(AVAudioResampleContext**)</code><br>
	 * <i>native declaration : libavresample/avresample.h:48</i>
	 */
	public static void avresample_free(Pointer<Pointer<AVAudioResampleContext > > avr) {
		avresample_free(Pointer.getPeer(avr));
	}
	protected native static void avresample_free(@Ptr long avr);
	/**
	 * Original signature : <code>int avresample_build_matrix(uint64_t, uint64_t, double, double, double, int, double*, int, AVMatrixEncoding)</code><br>
	 * <i>native declaration : libavresample/avresample.h:50</i>
	 */
	public static int avresample_build_matrix(long in_layout, long out_layout, double center_mix_level, double surround_mix_level, double lfe_mix_level, int normalize, Pointer<Double > matrix, int stride, IntValuedEnum<AVMatrixEncoding > matrix_encoding) {
		return avresample_build_matrix(in_layout, out_layout, center_mix_level, surround_mix_level, lfe_mix_level, normalize, Pointer.getPeer(matrix), stride, (int)matrix_encoding.value());
	}
	protected native static int avresample_build_matrix(long in_layout, long out_layout, double center_mix_level, double surround_mix_level, double lfe_mix_level, int normalize, @Ptr long matrix, int stride, int matrix_encoding);
	/**
	 * Original signature : <code>int avresample_get_matrix(AVAudioResampleContext*, double*, int)</code><br>
	 * <i>native declaration : libavresample/avresample.h:52</i>
	 */
	public static int avresample_get_matrix(Pointer<AVAudioResampleContext > avr, Pointer<Double > matrix, int stride) {
		return avresample_get_matrix(Pointer.getPeer(avr), Pointer.getPeer(matrix), stride);
	}
	protected native static int avresample_get_matrix(@Ptr long avr, @Ptr long matrix, int stride);
	/**
	 * Original signature : <code>int avresample_set_matrix(AVAudioResampleContext*, const double*, int)</code><br>
	 * <i>native declaration : libavresample/avresample.h:54</i>
	 */
	public static int avresample_set_matrix(Pointer<AVAudioResampleContext > avr, Pointer<Double > matrix, int stride) {
		return avresample_set_matrix(Pointer.getPeer(avr), Pointer.getPeer(matrix), stride);
	}
	protected native static int avresample_set_matrix(@Ptr long avr, @Ptr long matrix, int stride);
	/**
	 * Original signature : <code>int avresample_set_channel_mapping(AVAudioResampleContext*, const int*)</code><br>
	 * <i>native declaration : libavresample/avresample.h:56</i>
	 */
	public static int avresample_set_channel_mapping(Pointer<AVAudioResampleContext > avr, Pointer<Integer > channel_map) {
		return avresample_set_channel_mapping(Pointer.getPeer(avr), Pointer.getPeer(channel_map));
	}
	protected native static int avresample_set_channel_mapping(@Ptr long avr, @Ptr long channel_map);
	/**
	 * Original signature : <code>int avresample_set_compensation(AVAudioResampleContext*, int, int)</code><br>
	 * <i>native declaration : libavresample/avresample.h:58</i>
	 */
	public static int avresample_set_compensation(Pointer<AVAudioResampleContext > avr, int sample_delta, int compensation_distance) {
		return avresample_set_compensation(Pointer.getPeer(avr), sample_delta, compensation_distance);
	}
	protected native static int avresample_set_compensation(@Ptr long avr, int sample_delta, int compensation_distance);
	/**
	 * Original signature : <code>int avresample_get_out_samples(AVAudioResampleContext*, int)</code><br>
	 * <i>native declaration : libavresample/avresample.h:60</i>
	 */
	public static int avresample_get_out_samples(Pointer<AVAudioResampleContext > avr, int in_nb_samples) {
		return avresample_get_out_samples(Pointer.getPeer(avr), in_nb_samples);
	}
	protected native static int avresample_get_out_samples(@Ptr long avr, int in_nb_samples);
	/**
	 * Original signature : <code>int avresample_convert(AVAudioResampleContext*, uint8_t**, int, int, const uint8_t**, int, int)</code><br>
	 * <i>native declaration : libavresample/avresample.h:62</i>
	 */
	public static int avresample_convert(Pointer<AVAudioResampleContext > avr, Pointer<Pointer<Byte > > output, int out_plane_size, int out_samples, Pointer<Pointer<Byte > > input, int in_plane_size, int in_samples) {
		return avresample_convert(Pointer.getPeer(avr), Pointer.getPeer(output), out_plane_size, out_samples, Pointer.getPeer(input), in_plane_size, in_samples);
	}
	protected native static int avresample_convert(@Ptr long avr, @Ptr long output, int out_plane_size, int out_samples, @Ptr long input, int in_plane_size, int in_samples);
	/**
	 * Original signature : <code>int avresample_get_delay(AVAudioResampleContext*)</code><br>
	 * <i>native declaration : libavresample/avresample.h:64</i>
	 */
	public static int avresample_get_delay(Pointer<AVAudioResampleContext > avr) {
		return avresample_get_delay(Pointer.getPeer(avr));
	}
	protected native static int avresample_get_delay(@Ptr long avr);
	/**
	 * Original signature : <code>int avresample_available(AVAudioResampleContext*)</code><br>
	 * <i>native declaration : libavresample/avresample.h:66</i>
	 */
	public static int avresample_available(Pointer<AVAudioResampleContext > avr) {
		return avresample_available(Pointer.getPeer(avr));
	}
	protected native static int avresample_available(@Ptr long avr);
	/**
	 * Original signature : <code>int avresample_read(AVAudioResampleContext*, uint8_t**, int)</code><br>
	 * <i>native declaration : libavresample/avresample.h:68</i>
	 */
	public static int avresample_read(Pointer<AVAudioResampleContext > avr, Pointer<Pointer<Byte > > output, int nb_samples) {
		return avresample_read(Pointer.getPeer(avr), Pointer.getPeer(output), nb_samples);
	}
	protected native static int avresample_read(@Ptr long avr, @Ptr long output, int nb_samples);
	/**
	 * Original signature : <code>int avresample_convert_frame(AVAudioResampleContext*, AVFrame*, AVFrame*)</code><br>
	 * <i>native declaration : libavresample/avresample.h:70</i>
	 */
	public static int avresample_convert_frame(Pointer<AVAudioResampleContext > avr, Pointer<AVFrame > output, Pointer<AVFrame > input) {
		return avresample_convert_frame(Pointer.getPeer(avr), Pointer.getPeer(output), Pointer.getPeer(input));
	}
	protected native static int avresample_convert_frame(@Ptr long avr, @Ptr long output, @Ptr long input);
	/**
	 * Original signature : <code>int avresample_config(AVAudioResampleContext*, AVFrame*, AVFrame*)</code><br>
	 * <i>native declaration : libavresample/avresample.h:72</i>
	 */
	public static int avresample_config(Pointer<AVAudioResampleContext > avr, Pointer<AVFrame > out, Pointer<AVFrame > in) {
		return avresample_config(Pointer.getPeer(avr), Pointer.getPeer(out), Pointer.getPeer(in));
	}
	protected native static int avresample_config(@Ptr long avr, @Ptr long out, @Ptr long in);
}
