
#ifndef AVUTIL_MEM_H
#define AVUTIL_MEM_H

void av_free(void *ptr);
void av_freep(void *ptr);
void *av_malloc(size_t size) av_malloc_attrib av_alloc_size(1);

#endif /* AVUTIL_MEM_H */
