
#ifndef AVUTIL_FRAME_H
#define AVUTIL_FRAME_H

enum AVColorSpace{
    AVCOL_SPC_RGB         = 0,
    AVCOL_SPC_BT709       = 1, ///< also ITU-R BT1361 / IEC 61966-2-4 xvYCC709 / SMPTE RP177 Annex B
    AVCOL_SPC_UNSPECIFIED = 2,
    AVCOL_SPC_FCC         = 4,
    AVCOL_SPC_BT470BG     = 5, ///< also ITU-R BT601-6 625 / ITU-R BT1358 625 / ITU-R BT1700 625 PAL & SECAM / IEC 61966-2-4 xvYCC601
    AVCOL_SPC_SMPTE170M   = 6, ///< also ITU-R BT601-6 525 / ITU-R BT1358 525 / ITU-R BT1700 NTSC / functionally identical to above
    AVCOL_SPC_SMPTE240M   = 7,
    AVCOL_SPC_YCOCG       = 8, ///< Used by Dirac / VC-2 and H.264 FRext, see ITU-T SG16
    AVCOL_SPC_NB             , ///< Not part of ABI
};

enum AVColorRange{
    AVCOL_RANGE_UNSPECIFIED = 0,
    AVCOL_RANGE_MPEG        = 1, ///< the normal 219*2^(n-8) "MPEG" YUV ranges
    AVCOL_RANGE_JPEG        = 2, ///< the normal     2^n-1   "JPEG" YUV ranges
    AVCOL_RANGE_NB             , ///< Not part of ABI
};

enum AVFrameSideDataType {
    /**
     * The data is the AVPanScan struct defined in libavcodec.
     */
    AV_FRAME_DATA_PANSCAN,
};

typedef struct AVFrameSideData {
    enum AVFrameSideDataType type;
    uint8_t *data;
    int      size;
    AVDictionary *metadata;
} AVFrameSideData;

#define AV_NUM_DATA_POINTERS 8

typedef struct AVFrame {
    uint8_t *data[AV_NUM_DATA_POINTERS];
    int linesize[AV_NUM_DATA_POINTERS];
    uint8_t **extended_data;
    int width, height;
    int nb_samples;
    int format;
    int key_frame;
    enum AVPictureType pict_type;
    AVRational sample_aspect_ratio;
    int64_t pts;
    int64_t pkt_pts;
    int64_t pkt_dts;
    int coded_picture_number;
    int display_picture_number;
    int quality;
    void *opaque;
    uint64_t error[AV_NUM_DATA_POINTERS];
    int repeat_pict;
    int interlaced_frame;
    int top_field_first;
    int palette_has_changed;
    int64_t reordered_opaque;
    int sample_rate;
    uint64_t channel_layout;
    void *buf[AV_NUM_DATA_POINTERS];
    void **extended_buf;
    int        nb_extended_buf;
    AVFrameSideData **side_data;
    int            nb_side_data;
    int64_t best_effort_timestamp;
    int64_t pkt_pos;
    int64_t pkt_duration;
    AVDictionary *metadata;
    int decode_error_flags;
    int channels;
    int pkt_size;
    enum AVColorSpace colorspace;
    enum AVColorRange color_range;
    void *qp_table_buf;
} AVFrame;

#endif
