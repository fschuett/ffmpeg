
#ifndef AVFORMAT_AVIO_H
#define AVFORMAT_AVIO_H

#include "libavutil/common.h"
#include "libavutil/dict.h"
#include "libavutil/log.h"

typedef struct AVIOInterruptCB {
    int dummy;
} AVIOInterruptCB;

typedef struct AVIOContext {
    int dummy;
} AVIOContext;

AVIOContext *avio_alloc_context(
                  unsigned char *buffer,
                  int buffer_size,
                  int write_flag,
                  void *opaque,
                  int (*read_packet)(void *opaque, uint8_t *buf, int buf_size),
                  int (*write_packet)(void *opaque, uint8_t *buf, int buf_size),
                  int64_t (*seek)(void *opaque, int64_t offset, int whence));
void avio_flush(AVIOContext *s);

#define AVIO_FLAG_READ  1                                      /**< read-only */
#define AVIO_FLAG_WRITE 2                                      /**< write-only */
#define AVIO_FLAG_READ_WRITE (AVIO_FLAG_READ|AVIO_FLAG_WRITE)  /**< read-write pseudo flag */
#define AVIO_FLAG_NONBLOCK 8
#define AVIO_FLAG_DIRECT 0x8000

int avio_open(AVIOContext **s, const char *url, int flags);
int avio_open2(AVIOContext **s, const char *url, int flags,
               const AVIOInterruptCB *int_cb, AVDictionary **options);
int avio_close(AVIOContext *s);

#endif /* AVFORMAT_AVIO_H */
