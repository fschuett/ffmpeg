
#ifndef AVUTIL_COMMON_H
#define AVUTIL_COMMON_H

#define MKTAG(a,b,c,d) ((a) | ((b) << 8) | ((c) << 16) | ((unsigned)(d) << 24))
#define MKBETAG(a,b,c,d) ((d) | ((c) << 8) | ((b) << 16) | ((unsigned)(a) << 24))
#define FFMAX(a,b) ((a) > (b) ? (a) : (b))

#endif
