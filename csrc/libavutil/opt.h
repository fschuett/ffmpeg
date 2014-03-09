
#ifndef AVUTIL_OPT_H
#define AVUTIL_OPT_H

#include "common.h"
#include "rational.h"

enum AVOptionType{
    AV_OPT_TYPE_FLAGS,
    AV_OPT_TYPE_INT,
    AV_OPT_TYPE_INT64,
    AV_OPT_TYPE_DOUBLE,
    AV_OPT_TYPE_FLOAT,
    AV_OPT_TYPE_STRING,
    AV_OPT_TYPE_RATIONAL,
    AV_OPT_TYPE_BINARY,  ///< offset must point to a pointer immediately followed by an int for the length
    AV_OPT_TYPE_CONST = 128,
    AV_OPT_TYPE_IMAGE_SIZE = MKBETAG('S','I','Z','E'), ///< offset must point to two consecutive integers
    AV_OPT_TYPE_PIXEL_FMT  = MKBETAG('P','F','M','T'),
    AV_OPT_TYPE_SAMPLE_FMT = MKBETAG('S','F','M','T'),
    AV_OPT_TYPE_VIDEO_RATE = MKBETAG('V','R','A','T'), ///< offset must point to AVRational
    AV_OPT_TYPE_DURATION   = MKBETAG('D','U','R',' '),
    AV_OPT_TYPE_COLOR      = MKBETAG('C','O','L','R'),
    AV_OPT_TYPE_CHANNEL_LAYOUT = MKBETAG('C','H','L','A'),
};


typedef struct AVOption {
    const char *name;
    const char *help;
    int offset;
    enum AVOptionType type;
    union {
        int64_t i64;
        double dbl;
        const char *str;
        /* TODO those are unused now */
        AVRational q;
    } default_val;
    double min;                 ///< minimum valid value for the option
    double max;                 ///< maximum valid value for the option
    int flags;
    const char *unit;
} AVOption;

typedef struct AVOptionRange {
    const char *str;
    double value_min, value_max;             ///< For string ranges this represents the min/max length, for dimensions this represents the min/max pixel count
    double component_min, component_max;     ///< For string this represents the unicode range for chars, 0-127 limits to ASCII
    int is_range;                            ///< if set to 1 the struct encodes a range, if set to 0 a single value
} AVOptionRange;

typedef struct AVOptionRanges {
    AVOptionRange **range;
    int nb_ranges;
} AVOptionRanges;

void av_opt_set_defaults(void *s);
void av_opt_free(void *obj);
int av_opt_set_dict(void *obj, struct AVDictionary **options);

#endif /* AVUTIL_OPT_H */
