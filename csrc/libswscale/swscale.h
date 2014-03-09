
#ifndef SWSCALE_SWSCALE_H
#define SWSCALE_SWSCALE_H

unsigned swscale_version(void);

typedef struct SwsContext {
   int dummy;
} SwsContext;

int sws_scale(struct SwsContext *c, const uint8_t *const srcSlice[],
              const int srcStride[], int srcSliceY, int srcSliceH,
              uint8_t *const dst[], const int dstStride[]);


#endif /* SWSCALE_SWSCALE_H */
