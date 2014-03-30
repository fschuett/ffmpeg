
#ifndef AVUTIL_MEM_H
#define AVUTIL_MEM_H

#include <limits.h>
#include <stdint.h>

#include "attributes.h"
#include "error.h"
#include "avutil.h"

#if AV_GCC_VERSION_AT_LEAST(3,1)
    #define av_malloc_attrib __attribute__((__malloc__))
#else
    #define av_malloc_attrib
#endif

#if AV_GCC_VERSION_AT_LEAST(4,3)
    #define av_alloc_size(...) __attribute__((alloc_size(__VA_ARGS__)))
#else
    #define av_alloc_size(...)
#endif

void *av_malloc(size_t size) av_malloc_attrib av_alloc_size(1);

void av_free(void *ptr);

void av_freep(void *ptr);

#endif /* AVUTIL_MEM_H */
