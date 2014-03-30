
#ifndef AVUTIL_RATIONAL_H
#define AVUTIL_RATIONAL_H

#include <stdint.h>
#include <limits.h>
#include "attributes.h"

typedef struct AVRational{
    int num; ///< numerator
    int den; ///< denominator
} AVRational;

int av_reduce(int *dst_num, int *dst_den, int64_t num, int64_t den, int64_t max);

AVRational av_d2q(double d, int max) av_const;

#endif /* AVUTIL_RATIONAL_H */
