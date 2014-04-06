package org.ffmpeg;

import org.ffmpeg.avcodec.AvcodecLibrary;
import org.ffmpeg.avformat.AvformatLibrary;
import org.ffmpeg.avutil.AvutilLibrary;

public class FFMPeg {

	private static AvcodecLibrary avc;
	private static AvutilLibrary avu;
	private static AvformatLibrary avf;
	
	public static void main(String[] args) {
		System.out.println("Java-Bibliothek ffmpeg.jar");
		System.out.println("==========================");
		System.out.println("Die Bibliothek ffmpeg ist nur in den Bruchteilen implementiert, die für\n"
				+ "Open Source Physics tracker benötigt werden.");
		System.out.println("Bestandteile:");
		avc = new AvcodecLibrary();
		avu = new AvutilLibrary();
		avf = new AvformatLibrary();
		System.out.println("avutil in Version "+avu.avutil_version());
		System.out.println("avcodec in Version "+avc.avcodec_version());
		System.out.println("avformat in Version "+avf.avformat_version());
		System.out.println("swscale in Version ");
	}
	
}
