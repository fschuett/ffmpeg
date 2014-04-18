package org.ffmpeg;

import org.ffmpeg.avcodec.AvcodecLibrary;
import org.ffmpeg.avformat.AvformatLibrary;
import org.ffmpeg.avutil.AvutilLibrary;
import org.ffmpeg.swscale.SwscaleLibrary;

public class FFMPeg {

	public static void main(String[] args) {
		System.out.println("Java-Bibliothek ffmpeg.jar");
		System.out.println("==========================");
		System.out.println("Die Bibliothek ffmpeg ist nur in den Bruchteilen implementiert, die für\n"
				+ "Open Source Physics tracker benötigt werden.");
		System.out.println("ffmpeg in Version "+AvutilLibrary.FFMPEG_VERSION);
		System.out.println("Bestandteile:");
		System.out.println("avutil in Version "+AvutilLibrary.avutil_version());
		System.out.println("avcodec in Version "+AvcodecLibrary.avcodec_version());
		System.out.println("avformat in Version "+AvformatLibrary.avformat_version());
		System.out.println("swscale in Version "+SwscaleLibrary.swscale_version());
	}
	
	public static String getVersion() {
		return AvutilLibrary.FFMPEG_VERSION;
	}
	
}
