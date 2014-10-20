
#ifndef SWSCALE_VERSION_H
#define SWSCALE_VERSION_H

#include "libavutil/version.h"

#define LIBSWSCALE_VERSION_MAJOR 2
#define LIBSWSCALE_VERSION_MINOR 6
#define LIBSWSCALE_VERSION_MICRO 100

#define LIBSWSCALE_VERSION_INT  AV_VERSION_INT(LIBSWSCALE_VERSION_MAJOR, \
                                               LIBSWSCALE_VERSION_MINOR, \
                                               LIBSWSCALE_VERSION_MICRO)
#define LIBSWSCALE_VERSION      AV_VERSION(LIBSWSCALE_VERSION_MAJOR, \
                                           LIBSWSCALE_VERSION_MINOR, \
                                           LIBSWSCALE_VERSION_MICRO)
#define LIBSWSCALE_BUILD        LIBSWSCALE_VERSION_INT

#define LIBSWSCALE_IDENT        "SwS2.6.100"

/**
 * FF_API_* defines may be placed below to indicate public API that will be
 * dropped at a future version bump. The defines themselves are not part of
 * the public API and may change, break or disappear at any time.
 */

#ifndef FF_API_SWS_GETCONTEXT
#define FF_API_SWS_GETCONTEXT  (LIBSWSCALE_VERSION_MAJOR < 3)
#endif
#ifndef FF_API_SWS_CPU_CAPS
#define FF_API_SWS_CPU_CAPS    (LIBSWSCALE_VERSION_MAJOR < 3)
#endif
#ifndef FF_API_SWS_FORMAT_NAME
#define FF_API_SWS_FORMAT_NAME  (LIBSWSCALE_VERSION_MAJOR < 3)
#endif
#ifndef FF_API_ARCH_BFIN
#define FF_API_ARCH_BFIN       (LIBSWSCALE_VERSION_MAJOR < 3)
#endif

#endif /* SWSCALE_VERSION_H */
