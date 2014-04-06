
#ifndef AVUTIL_DICT_H
#define AVUTIL_DICT_H

#define AV_DICT_MATCH_CASE      1   /**< Only get an entry with exact-case key match. Only relevant in av_dict_get(). */
#define AV_DICT_IGNORE_SUFFIX   2   /**< Return first entry in a dictionary whose first part corresponds to the search key,
                                         ignoring the suffix of the found key string. Only relevant in av_dict_get(). */
#define AV_DICT_DONT_STRDUP_KEY 4   /**< Take ownership of a key that's been
                                         allocated with av_malloc() or another memory allocation function. */
#define AV_DICT_DONT_STRDUP_VAL 8   /**< Take ownership of a value that's been
                                         allocated with av_malloc() or another memory allocation function. */
#define AV_DICT_DONT_OVERWRITE 16   ///< Don't overwrite existing entries.
#define AV_DICT_APPEND         32   /**< If the entry already exists, append to it.  Note that no
                                      delimiter is added, the strings are simply concatenated. */

typedef struct AVDictionaryEntry;

typedef struct AVDictionary {
    int dummy;
} AVDictionary;

void av_dict_copy(AVDictionary **dst, AVDictionary *src, int flags);
void av_dict_free(AVDictionary **m);

#endif /* AVUTIL_DICT_H */
