package org.ffmpeg.util;

import java.util.List;

import org.bridj.Platform;
import org.bridj.StructCustomizer;
import org.bridj.StructDescription;
import org.bridj.StructFieldDescription;
import org.bridj.ann.Alignment;

@SuppressWarnings("deprecation")
public class AlignmentCustomizer extends StructCustomizer {
	@Override
	public void beforeLayout(StructDescription desc,
			List<StructFieldDescription> aggregatedFields) {
		for (StructFieldDescription field : aggregatedFields) {
			if(field.field.isAnnotationPresent(Alignment.class))
				continue;
			if (Platform.isLinux() && !Platform.is64Bits()) {
				field.alignment = 4;
			} else {
				field.alignment = 8;
			}
		}
	}
}
