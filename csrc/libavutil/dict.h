
#ifndef AVUTIL_DICT_H
#define AVUTIL_DICT_H

#define AV_DICT_MATCH_CASE      1
#define AV_DICT_IGNORE_SUFFIX   2
#define AV_DICT_DONT_STRDUP_KEY 4   /**< Take ownership of a key that's been
                                         allocated with av_malloc() and children. */
#define AV_DICT_DONT_STRDUP_VAL 8   /**< Take ownership of a value that's been
                                         allocated with av_malloc() and chilren. */
#define AV_DICT_DONT_OVERWRITE 16   ///< Don't overwrite existing entries.
#define AV_DICT_APPEND         32   /**< If the entry already exists, append to it.  Note that no
                                      delimiter is added, the strings are simply concatenated. */

typedef struct AVDictionaryEntry {
    char *key;
    char *value;
} AVDictionaryEntry;

typedef struct AVDictionary {
    int dummy;
} AVDictionary;

void av_dict_copy(AVDictionary **dst, AVDictionary *src, int flags);
void av_dict_free(AVDictionary **m);

#endif
