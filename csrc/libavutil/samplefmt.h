
#ifndef AVUTIL_SAMPLEFMT_H
#define AVUTIL_SAMPLEFMT_H

enum AVSampleFormat {
    AV_SAMPLE_FMT_NONE = -1,
    AV_SAMPLE_FMT_U8,          ///< unsigned 8 bits
    AV_SAMPLE_FMT_S16,         ///< signed 16 bits
    AV_SAMPLE_FMT_S32,         ///< signed 32 bits
    AV_SAMPLE_FMT_FLT,         ///< float
    AV_SAMPLE_FMT_DBL,         ///< double

    AV_SAMPLE_FMT_U8P,         ///< unsigned 8 bits, planar
    AV_SAMPLE_FMT_S16P,        ///< signed 16 bits, planar
    AV_SAMPLE_FMT_S32P,        ///< signed 32 bits, planar
    AV_SAMPLE_FMT_FLTP,        ///< float, planar
    AV_SAMPLE_FMT_DBLP,        ///< double, planar

    AV_SAMPLE_FMT_NB           ///< Number of sample formats. DO NOT USE if linking dynamically
};

const char *av_get_sample_fmt_name(enum AVSampleFormat sample_fmt);

int av_sample_fmt_is_planar(enum AVSampleFormat sample_fmt);

int av_get_bytes_per_sample(enum AVSampleFormat sample_fmt);

enum AVSampleFormat av_get_sample_fmt(const char *name);

enum AVSampleFormat av_get_packed_sample_fmt(enum AVSampleFormat sample_fmt);

#endif /* AVUTIL_SAMPLEFMT_H */
