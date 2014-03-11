
#ifndef AVUTIL_IMGUTILS_H
#define AVUTIL_IMGUTILS_H

void av_image_copy(uint8_t *dst_data[4], int dst_linesizes[4],
                   const uint8_t *src_data[4], const int src_linesizes[4],
                   enum AVPixelFormat pix_fmt, int width, int height);

#endif /* AVUTIL_IMGUTILS_H */
