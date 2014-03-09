package org.ffmpeg;

import org.ffmpeg.avformat.AVStream;
import org.ffmpeg.avcodec.AvcodecLibrary;

public class FFMPeg {

	private static AvcodecLibrary avcodec;
	
	public static void main(String[] args) {
		System.out.println("Java-Bibliothek ffmpeg.jar");
		System.out.println("==========================");
		System.out.println("Die Bibliothek ffmpeg ist nur in den Bruchteilen implementiert, die für\n"
				+ "Open Source Physics tracker benötigt werden.");
		System.out.println("Bestandteile:");
		System.out.println("avutil in Version ...");
		System.out.println("avcodec in Version ...");
		System.out.println("avformat in Version ...");
		System.out.println("swscale in Version ...");
		avcodec = new AvcodecLibrary();
	}
	
	public void stream_close(AVStream stream) {
		avcodec.avcodec_close(stream.codec());
	}

}
