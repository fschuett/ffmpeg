ffmpeg-2.6
==========
parts of a java library interface to access ffmpeg 2.6 c library.
Only parts that are needed in opensourcephysics tracker are 
included.

example demuxing.c -> demuxing.java compiles

build
=====
ant build-jar builds the jar file and copies it with its bridj dependency
to the dist/ directory.

usage
=====
You need ffmpeg-2.6.jar, bridj-0.7-SNAPSHOT.jar installed in /usr/share/java/ffmpeg,
which are in the dist directory.
Set the environment variable f.e. FFMPEG_HOME=/usr/share/java/ffmpeg
for use with tracker.

You need the ffmpeg c libraries
libavformat56, libavcodec56, libavutil54, libswscale3, which all belong to ffmpeg 2.6.

Copyright
=========
The jar ffmpeg-2.6.jar is copyright 2014-2015 Frank Schütte.

the homepage of the bridj project is http://code.google.com/p/bridj/wiki/FAQ.