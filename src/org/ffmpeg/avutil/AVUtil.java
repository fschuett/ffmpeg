package org.ffmpeg.avutil;

public class AVUtil {
	public static final long AV_NOPTS_VALUE = 0;

	/** Inline-Funktion rational.h */
	public static double av_q2d(AVRational a) {
               return a.num() / (double) a.den();
       }

	public static String av_ts_make_string(long ts) {
               if (ts == AV_NOPTS_VALUE)
                       return "NOPTS";
               else
                       return Long.toHexString(ts);
       }

	/**
	 * Original signaturre : #define av_ts2str(ts)
	 * av_ts_make_string((char[AV_TS_MAX_STRING_SIZE]){0}, ts)
	 */
	public static String av_ts2str(long ts) {
               return av_ts_make_string(ts);
       }

	public static String av_ts_make_time_string(long ts,
                       AVRational tb) {
               if (ts == AV_NOPTS_VALUE)
                       return "NOPTS";
               else {
                       String s = String.format("%.6g", av_q2d(tb) * ts);
                       return s;
               }
       }

	/**
	 * Original signature : #define av_ts2timestr(ts, tb)
	 * av_ts_make_time_string((char[AV_TS_MAX_STRING_SIZE]){0}, ts, tb)
	 */
	public static String av_ts2timestr(long ts, AVRational tb) {
               return av_ts_make_time_string(ts, tb);
       }

}
