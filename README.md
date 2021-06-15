ffmpeg-4.4
==========
a java library interface to access ffmpeg 4.4 c library.

example demuxing.c -> demuxing.java compiles

build
=====
ant build-jar builds the jar file and copies it with its bridj dependency
to the dist/ directory.

usage
=====
You need ffmpeg-4.4.jar, bridj-0.7-SNAPSHOT.jar installed in /usr/share/java/ffmpeg,
which are in the dist directory.
Set the environment variable f.e. FFMPEG_HOME=/usr/share/java/ffmpeg
for use with tracker.

You need the ffmpeg c libraries

ffmpeg-4-libavcodec,
ffmpeg-4-libavdevice,
ffmpeg-4-libavfilter,
ffmpeg-4-libavformat,
ffmpeg-4-libavresample,
ffmpeg-4-libavutil,
ffmpeg-4-libpostproc,
ffmpeg-4-libswresample,
ffmpeg-4-libswscale,

which all belong to ffmpeg 4.4.

Copyright
=========
The jar ffmpeg-4.4.jar is copyright 2014-2021 Frank Schütte.

the homepage of the bridj project is http://code.google.com/p/bridj/wiki/FAQ.
