ffmpeg-3.3
==========
a java library interface to access ffmpeg 3.3 c library.

example demuxing.c -> demuxing.java compiles

build
=====
ant build-jar builds the jar file and copies it with its bridj dependency
to the dist/ directory.

usage
=====
You need ffmpeg-3.3.jar, bridj-0.7-SNAPSHOT.jar installed in /usr/share/java/ffmpeg,
which are in the dist directory.
Set the environment variable f.e. FFMPEG_HOME=/usr/share/java/ffmpeg
for use with tracker.

You need the ffmpeg c libraries

libavcodec57,
libavdevice57,
libavfilter6,
libavformat57,
libavresample3,
libavutil55,
libpostproc54,
libswresample2,
libswscale4,

which all belong to ffmpeg 3.3.

Copyright
=========
The jar ffmpeg-3.3.jar is copyright 2014-2017 Frank Schütte.

the homepage of the bridj project is http://code.google.com/p/bridj/wiki/FAQ.
