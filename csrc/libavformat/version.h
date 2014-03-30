
#ifndef AVFORMAT_VERSION_H
#define AVFORMAT_VERSION_H

#include "libavutil/version.h"

#define LIBAVFORMAT_VERSION_MAJOR 55
#define LIBAVFORMAT_VERSION_MINOR 33
#define LIBAVFORMAT_VERSION_MICRO 100

#define LIBAVFORMAT_VERSION_INT AV_VERSION_INT(LIBAVFORMAT_VERSION_MAJOR, \
                                               LIBAVFORMAT_VERSION_MINOR, \
                                               LIBAVFORMAT_VERSION_MICRO)
#define LIBAVFORMAT_VERSION     AV_VERSION(LIBAVFORMAT_VERSION_MAJOR,   \
                                           LIBAVFORMAT_VERSION_MINOR,   \
                                           LIBAVFORMAT_VERSION_MICRO)
#define LIBAVFORMAT_BUILD       LIBAVFORMAT_VERSION_INT

#define LIBAVFORMAT_IDENT       "Lavf55.33.100"

/**
 * FF_API_* defines may be placed below to indicate public API that will be
 * dropped at a future version bump. The defines themselves are not part of
 * the public API and may change, break or disappear at any time.
 */
#ifndef FF_API_REFERENCE_DTS
#define FF_API_REFERENCE_DTS            (LIBAVFORMAT_VERSION_MAJOR < 56)
#endif

#ifndef FF_API_ALLOC_OUTPUT_CONTEXT
#define FF_API_ALLOC_OUTPUT_CONTEXT    (LIBAVFORMAT_VERSION_MAJOR < 56)
#endif
#ifndef FF_API_FORMAT_PARAMETERS
#define FF_API_FORMAT_PARAMETERS       (LIBAVFORMAT_VERSION_MAJOR < 56)
#endif
#ifndef FF_API_NEW_STREAM
#define FF_API_NEW_STREAM              (LIBAVFORMAT_VERSION_MAJOR < 56)
#endif
#ifndef FF_API_SET_PTS_INFO
#define FF_API_SET_PTS_INFO            (LIBAVFORMAT_VERSION_MAJOR < 56)
#endif
#ifndef FF_API_CLOSE_INPUT_FILE
#define FF_API_CLOSE_INPUT_FILE        (LIBAVFORMAT_VERSION_MAJOR < 56)
#endif
#ifndef FF_API_READ_PACKET
#define FF_API_READ_PACKET             (LIBAVFORMAT_VERSION_MAJOR < 56)
#endif
#ifndef FF_API_ASS_SSA
#define FF_API_ASS_SSA                 (LIBAVFORMAT_VERSION_MAJOR < 56)
#endif
#ifndef FF_API_R_FRAME_RATE
#define FF_API_R_FRAME_RATE            1
#endif
#endif /* AVFORMAT_VERSION_H */
