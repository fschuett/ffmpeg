package test;

import java.lang.reflect.Field;
import java.util.List;

import org.bridj.StructFieldDescription;
import org.bridj.StructObject;
import org.ffmpeg.avcodec.AVPacket;
import org.ffmpeg.avutil.AVFrame;

public class StructInfo {
	
	public static void printAVFrame(AVFrame f) {
		System.out.println(f);
		List<StructFieldDescription> fields = f.getDescriptions();
		for(int index=0;index<fields.size();index++)
			try {
				System.out.println("\t["+index+"]: "+fields.get(index)+ printField(f,index));
			} catch (IllegalArgumentException e){
				System.out.println("Illegal Argument Exception");
			} catch (SecurityException e) {
				System.out.println("Security Exception");
			}
	}

	public static void printAVPacket(AVPacket f) {
		System.out.println(f);
		List<StructFieldDescription> fields = f.getDescriptions();
		for(int index=0;index<fields.size();index++)
			try {
				System.out.println("\t["+index+"]: "+fields.get(index)+ printField(f,index));
			} catch (IllegalArgumentException e){
				System.out.println("Illegal Argument Exception");
			} catch (SecurityException e) {
				System.out.println("Security Exception");
			}
	}

	public static String printField(StructObject f, int index) {
		String ret = "";
		Field[] fields = f.getClass().getFields();
		if(fields.length < index+1)
			return ret;
		Field fi = fields[index];
		ret = "("+fi.getName()+"|";
		try {
			ret = ret + fi.get(f)+")";
		} catch (IllegalArgumentException e) {
			ret = ret + " - )";
		} catch (IllegalAccessException e) {
			ret = ret + " - )";
		}
		return ret;
	}
}
