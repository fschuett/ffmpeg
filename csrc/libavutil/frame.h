
#ifndef AVUTIL_FRAME_H
#define AVUTIL_FRAME_H

#include <stdint.h>

#include "avutil.h"
#include "buffer.h"
#include "dict.h"
#include "rational.h"
#include "samplefmt.h"
#include "version.h"


enum AVColorSpace{
    AVCOL_SPC_RGB         =  0,
    AVCOL_SPC_BT709       =  1, ///< also ITU-R BT1361 / IEC 61966-2-4 xvYCC709 / SMPTE RP177 Annex B
    AVCOL_SPC_UNSPECIFIED =  2,
    AVCOL_SPC_FCC         =  4,
    AVCOL_SPC_BT470BG     =  5, ///< also ITU-R BT601-6 625 / ITU-R BT1358 625 / ITU-R BT1700 625 PAL & SECAM / IEC 61966-2-4 xvYCC601
    AVCOL_SPC_SMPTE170M   =  6, ///< also ITU-R BT601-6 525 / ITU-R BT1358 525 / ITU-R BT1700 NTSC / functionally identical to above
    AVCOL_SPC_SMPTE240M   =  7,
    AVCOL_SPC_YCOCG       =  8, ///< Used by Dirac / VC-2 and H.264 FRext, see ITU-T SG16
    AVCOL_SPC_BT2020_NCL  =  9, ///< ITU-R BT2020 non-constant luminance system
    AVCOL_SPC_BT2020_CL   = 10, ///< ITU-R BT2020 constant luminance system
    AVCOL_SPC_NB              , ///< Not part of ABI
};

enum AVColorRange{
    AVCOL_RANGE_UNSPECIFIED = 0,
    AVCOL_RANGE_MPEG        = 1, ///< the normal 219*2^(n-8) "MPEG" YUV ranges
    AVCOL_RANGE_JPEG        = 2, ///< the normal     2^n-1   "JPEG" YUV ranges
    AVCOL_RANGE_NB             , ///< Not part of ABI
};


enum AVFrameSideDataType {
    AV_FRAME_DATA_PANSCAN,
    AV_FRAME_DATA_A53_CC,
    AV_FRAME_DATA_STEREO3D,
    AV_FRAME_DATA_MATRIXENCODING,
    AV_FRAME_DATA_DOWNMIX_INFO,
};

typedef struct AVFrameSideData {
    enum AVFrameSideDataType type;
    uint8_t *data;
    int      size;
    AVDictionary *metadata;
} AVFrameSideData;


typedef struct AVFrame {
#define AV_NUM_DATA_POINTERS 8
    uint8_t *data[AV_NUM_DATA_POINTERS];
    int linesize[AV_NUM_DATA_POINTERS];
    uint8_t **extended_data;
    int width, height;
    int nb_samples;
    int format;
    int key_frame;
    enum AVPictureType pict_type;

#if FF_API_AVFRAME_LAVC
    uint8_t *base[AV_NUM_DATA_POINTERS];
#endif
    AVRational sample_aspect_ratio;
    int64_t pts;
    int64_t pkt_pts;
    int64_t pkt_dts;
    int coded_picture_number;
    int display_picture_number;
    int quality;
#if FF_API_AVFRAME_LAVC
    int reference;
    int8_t *qscale_table;
    int qstride;
    int qscale_type;
    uint8_t *mbskip_table;
    int16_t (*motion_val[2])[2];
    uint32_t *mb_type;
    short *dct_coeff;
    int8_t *ref_index[2];
#endif
    void *opaque;
    uint64_t error[AV_NUM_DATA_POINTERS];
#if FF_API_AVFRAME_LAVC
    int type;
#endif
    int repeat_pict;
    int interlaced_frame;
    int top_field_first;
    int palette_has_changed;
#if FF_API_AVFRAME_LAVC
    int buffer_hints;
    struct AVPanScan *pan_scan;
#endif
    int64_t reordered_opaque;
#if FF_API_AVFRAME_LAVC
    void *hwaccel_picture_private;
    struct AVCodecContext *owner;
    void *thread_opaque;
    uint8_t motion_subsample_log2;
#endif
    int sample_rate;
    uint64_t channel_layout;
    AVBufferRef *buf[AV_NUM_DATA_POINTERS];
    AVBufferRef **extended_buf;
    int        nb_extended_buf;

    AVFrameSideData **side_data;
    int            nb_side_data;
#define AV_FRAME_FLAG_CORRUPT       (1 << 0)
    int flags;
    int64_t best_effort_timestamp;
    int64_t pkt_pos;
    int64_t pkt_duration;
    AVDictionary *metadata;
    int decode_error_flags;
#define FF_DECODE_ERROR_INVALID_BITSTREAM   1
#define FF_DECODE_ERROR_MISSING_REFERENCE   2
    int channels;
    int pkt_size;
    enum AVColorSpace colorspace;
    enum AVColorRange color_range;
    AVBufferRef *qp_table_buf;
} AVFrame;

#endif /* AVUTIL_FRAME_H */
