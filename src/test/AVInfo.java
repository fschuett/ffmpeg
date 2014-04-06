package test;

import static org.ffmpeg.avformat.AvformatLibrary.av_dump_format;
import static org.ffmpeg.avformat.AvformatLibrary.av_register_all;
import static org.ffmpeg.avformat.AvformatLibrary.avformat_close_input;
import static org.ffmpeg.avformat.AvformatLibrary.avformat_open_input;

import java.io.IOException;

import org.bridj.Pointer;
import org.ffmpeg.avformat.AVFormatContext;
import org.ffmpeg.avformat.AVStream;

public class AVInfo {
	public static String src_filename;
	public static Pointer<AVFormatContext> fmt_ctx;
	public static Pointer<AVStream> stream;
	
	public static void main(String[] args) {
		int ret = 0;

		if (args.length != 1) {
			System.err.printf("usage: AVInfo input_file \n"
					+ "API example program to show input file infos.\n" + "\n");
			System.exit(1);
		}
		src_filename = args[0];
		try {
			/* register all formats and codecs */
			av_register_all();

			/* open input file, and allocate format context */
			Pointer<Pointer<AVFormatContext>> pfmt_ctx = Pointer
					.allocatePointer(AVFormatContext.class);
			if (avformat_open_input(pfmt_ctx,
					Pointer.pointerToCString(src_filename), null, null) < 0) {
				System.err.printf("Could not open source file %s\n",
						src_filename);
				System.exit(1);
			}

			fmt_ctx = pfmt_ctx.get();
			/* dump input information to stderr */
			av_dump_format(fmt_ctx, 0, Pointer.pointerToCString(src_filename), 0);

			int streams = fmt_ctx.get().nb_streams();
			for(int index = 0;index<streams;index++){
				stream = fmt_ctx.get().streams().get(index);
				
			}
			// } catch (IOException e) {
			// e.printStackTrace();
			// System.exit(1);
		} finally {
			System.err.print("freeing fmt_ctx...");
			if (fmt_ctx != null) {
				avformat_close_input(fmt_ctx.getReference());
			}
			System.err.println("freed");
			System.exit(ret);
		}
	}

}
