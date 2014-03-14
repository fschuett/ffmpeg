
#ifndef AVCODEC_AVCODEC_H
#define AVCODEC_AVCODEC_H

#include "../libavutil/common.h"
#include "../libavutil/rational.h"
#include "../libavutil/log.h"
#include "../libavutil/avutil.h"
#include "../libavutil/frame.h"
#include "../libavutil/dict.h"
#include "../libavutil/pixfmt.h"
#include "../libavutil/samplefmt.h"

#define CODEC_FLAG_UNALIGNED 0x0001
#define CODEC_FLAG_QSCALE 0x0002  ///< Use fixed qscale.
#define CODEC_FLAG_4MV    0x0004  ///< 4 MV per MB allowed / advanced prediction for H.263.
#define CODEC_FLAG_QPEL   0x0010  ///< Use qpel MC.
#define CODEC_FLAG_GMC    0x0020  ///< Use GMC.
#define CODEC_FLAG_MV0    0x0040  ///< Always try a MB with MV=<0,0>.
#define CODEC_FLAG_INPUT_PRESERVED 0x0100
#define CODEC_FLAG_PASS1           0x0200   ///< Use internal 2pass ratecontrol in first pass mode.
#define CODEC_FLAG_PASS2           0x0400   ///< Use internal 2pass ratecontrol in second pass mode.
#define CODEC_FLAG_GRAY            0x2000   ///< Only decode/encode grayscale.
#define CODEC_FLAG_EMU_EDGE        0x4000   ///< Don't draw edges.
#define CODEC_FLAG_PSNR            0x8000   ///< error[?] variables will be set during encoding.
#define CODEC_FLAG_TRUNCATED       0x00010000 /* Input bitstream might be truncated at a random
                                                  location instead of only at frame boundaries. */
#define CODEC_FLAG_NORMALIZE_AQP  0x00020000 ///< Normalize adaptive quantization.
#define CODEC_FLAG_INTERLACED_DCT 0x00040000 ///< Use interlaced DCT.
#define CODEC_FLAG_LOW_DELAY      0x00080000 ///< Force low delay.
#define CODEC_FLAG_GLOBAL_HEADER  0x00400000 ///< Place global headers in extradata instead of every keyframe.
#define CODEC_FLAG_BITEXACT       0x00800000 ///< Use only bitexact stuff (except (I)DCT).
/* Fx : Flag for h263+ extra options */
#define CODEC_FLAG_AC_PRED        0x01000000 ///< H.263 advanced intra coding / MPEG-4 AC prediction
#define CODEC_FLAG_LOOP_FILTER    0x00000800 ///< loop filter
#define CODEC_FLAG_INTERLACED_ME  0x20000000 ///< interlaced motion estimation
#define CODEC_FLAG_CLOSED_GOP     0x80000000
#define CODEC_FLAG2_FAST          0x00000001 ///< Allow non spec compliant speedup tricks.
#define CODEC_FLAG2_NO_OUTPUT     0x00000004 ///< Skip bitstream encoding.
#define CODEC_FLAG2_LOCAL_HEADER  0x00000008 ///< Place global headers at every keyframe instead of in extradata.
#define CODEC_FLAG2_DROP_FRAME_TIMECODE 0x00002000 ///< timecode is in drop frame format. DEPRECATED!!!!
#define CODEC_FLAG2_IGNORE_CROP   0x00010000 ///< Discard cropping information from SPS.

#define CODEC_FLAG2_CHUNKS        0x00008000 ///< Input bitstream might be truncated at a packet boundaries instead of only at frame boundaries.
#define CODEC_FLAG2_SHOW_ALL      0x00400000 ///< Show all frames before the first keyframe

#define CODEC_CAP_DRAW_HORIZ_BAND 0x0001 ///< Decoder can use draw_horiz_band callback.
#define CODEC_CAP_DR1             0x0002
#define CODEC_CAP_TRUNCATED       0x0008
#define CODEC_CAP_HWACCEL         0x0010
#define CODEC_CAP_DELAY           0x0020
#define CODEC_CAP_SMALL_LAST_FRAME 0x0040
#define CODEC_CAP_HWACCEL_VDPAU    0x0080
#define CODEC_CAP_SUBFRAMES        0x0100
#define CODEC_CAP_EXPERIMENTAL     0x0200
#define CODEC_CAP_CHANNEL_CONF     0x0400
#define CODEC_CAP_NEG_LINESIZES    0x0800
#define CODEC_CAP_FRAME_THREADS    0x1000
#define CODEC_CAP_SLICE_THREADS    0x2000
#define CODEC_CAP_PARAM_CHANGE     0x4000
#define CODEC_CAP_AUTO_THREADS     0x8000
#define CODEC_CAP_VARIABLE_FRAME_SIZE 0x10000
#define CODEC_CAP_INTRA_ONLY       0x40000000
#define CODEC_CAP_LOSSLESS         0x80000000
#define MB_TYPE_INTRA4x4   0x0001
#define MB_TYPE_INTRA16x16 0x0002 //FIXME H.264-specific
#define MB_TYPE_INTRA_PCM  0x0004 //FIXME H.264-specific
#define MB_TYPE_16x16      0x0008
#define MB_TYPE_16x8       0x0010
#define MB_TYPE_8x16       0x0020
#define MB_TYPE_8x8        0x0040
#define MB_TYPE_INTERLACED 0x0080
#define MB_TYPE_DIRECT2    0x0100 //FIXME
#define MB_TYPE_ACPRED     0x0200
#define MB_TYPE_GMC        0x0400
#define MB_TYPE_SKIP       0x0800
#define MB_TYPE_P0L0       0x1000
#define MB_TYPE_P1L0       0x2000
#define MB_TYPE_P0L1       0x4000
#define MB_TYPE_P1L1       0x8000
#define MB_TYPE_L0         (MB_TYPE_P0L0 | MB_TYPE_P1L0)
#define MB_TYPE_L1         (MB_TYPE_P0L1 | MB_TYPE_P1L1)
#define MB_TYPE_L0L1       (MB_TYPE_L0   | MB_TYPE_L1)
#define MB_TYPE_QUANT      0x00010000
#define MB_TYPE_CBP        0x00020000
#define FF_QSCALE_TYPE_MPEG1 0
#define FF_QSCALE_TYPE_MPEG2 1
#define FF_QSCALE_TYPE_H264  2
#define FF_QSCALE_TYPE_VP56  3
#define FF_BUFFER_TYPE_INTERNAL 1
#define FF_BUFFER_TYPE_USER     2 ///< direct rendering buffers (image is (de)allocated by user)
#define FF_BUFFER_TYPE_SHARED   4 ///< Buffer from somewhere else; don't deallocate image (data/base), all other tables are not shared.
#define FF_BUFFER_TYPE_COPY     8 ///< Just a (modified) copy of some other buffer, don't deallocate anything.

#define FF_BUFFER_HINTS_VALID    0x01 // Buffer hints value is meaningful (if 0 ignore).
#define FF_BUFFER_HINTS_READABLE 0x02 // Codec will read from buffer.
#define FF_BUFFER_HINTS_PRESERVE 0x04 // User must not alter buffer content.
#define FF_BUFFER_HINTS_REUSABLE 0x08 // Codec will reuse the buffer (update).
#define AV_GET_BUFFER_FLAG_REF (1 << 0)

enum AVDiscard{
    /* We leave some space between them for extensions (drop some
     * keyframes for intra-only or drop just some bidir frames). */
    AVDISCARD_NONE    =-16, ///< discard nothing
    AVDISCARD_DEFAULT =  0, ///< discard useless packets like 0 size packets in avi
    AVDISCARD_NONREF  =  8, ///< discard all non reference
    AVDISCARD_BIDIR   = 16, ///< discard all bidirectional frames
    AVDISCARD_NONKEY  = 32, ///< discard all frames except keyframes
    AVDISCARD_ALL     = 48, ///< discard all
};

enum AVColorPrimaries{
    AVCOL_PRI_BT709       = 1, ///< also ITU-R BT1361 / IEC 61966-2-4 / SMPTE RP177 Annex B
    AVCOL_PRI_UNSPECIFIED = 2,
    AVCOL_PRI_BT470M      = 4,
    AVCOL_PRI_BT470BG     = 5, ///< also ITU-R BT601-6 625 / ITU-R BT1358 625 / ITU-R BT1700 625 PAL & SECAM
    AVCOL_PRI_SMPTE170M   = 6, ///< also ITU-R BT601-6 525 / ITU-R BT1358 525 / ITU-R BT1700 NTSC
    AVCOL_PRI_SMPTE240M   = 7, ///< functionally identical to above
    AVCOL_PRI_FILM        = 8,
    AVCOL_PRI_NB             , ///< Not part of ABI
};

enum AVColorTransferCharacteristic{
    AVCOL_TRC_BT709       = 1, ///< also ITU-R BT1361
    AVCOL_TRC_UNSPECIFIED = 2,
    AVCOL_TRC_GAMMA22     = 4, ///< also ITU-R BT470M / ITU-R BT1700 625 PAL & SECAM
    AVCOL_TRC_GAMMA28     = 5, ///< also ITU-R BT470BG
    AVCOL_TRC_SMPTE240M   = 7,
    AVCOL_TRC_NB             , ///< Not part of ABI
};

enum AVChromaLocation{
    AVCHROMA_LOC_UNSPECIFIED = 0,
    AVCHROMA_LOC_LEFT        = 1, ///< mpeg2/4, h264 default
    AVCHROMA_LOC_CENTER      = 2, ///< mpeg1, jpeg, h263
    AVCHROMA_LOC_TOPLEFT     = 3, ///< DV
    AVCHROMA_LOC_TOP         = 4,
    AVCHROMA_LOC_BOTTOMLEFT  = 5,
    AVCHROMA_LOC_BOTTOM      = 6,
    AVCHROMA_LOC_NB             , ///< Not part of ABI
};

enum AVAudioServiceType {
    AV_AUDIO_SERVICE_TYPE_MAIN              = 0,
    AV_AUDIO_SERVICE_TYPE_EFFECTS           = 1,
    AV_AUDIO_SERVICE_TYPE_VISUALLY_IMPAIRED = 2,
    AV_AUDIO_SERVICE_TYPE_HEARING_IMPAIRED  = 3,
    AV_AUDIO_SERVICE_TYPE_DIALOGUE          = 4,
    AV_AUDIO_SERVICE_TYPE_COMMENTARY        = 5,
    AV_AUDIO_SERVICE_TYPE_EMERGENCY         = 6,
    AV_AUDIO_SERVICE_TYPE_VOICE_OVER        = 7,
    AV_AUDIO_SERVICE_TYPE_KARAOKE           = 8,
    AV_AUDIO_SERVICE_TYPE_NB                   , ///< Not part of ABI
};

enum AVFieldOrder {
    AV_FIELD_UNKNOWN,
    AV_FIELD_PROGRESSIVE,
    AV_FIELD_TT,          //< Top coded_first, top displayed first
    AV_FIELD_BB,          //< Bottom coded first, bottom displayed first
    AV_FIELD_TB,          //< Top coded first, bottom displayed first
    AV_FIELD_BT,          //< Bottom coded first, top displayed first
};

typedef struct AVProfile {
    int profile;
    const char *name; ///< short name for the profile
} AVProfile;

typedef struct AVPacket {
    void *buf;
    int64_t pts;
    int64_t dts;
    uint8_t *data;
    int   size;
    int   stream_index;
    int   flags;
    void *side_data;
    int side_data_elems;
    int   duration;
    int64_t pos;                            ///< byte position in stream, -1 if unknown
    int64_t convergence_duration;
} AVPacket;

#define AV_PKT_FLAG_KEY     0x0001 ///< The packet contains a keyframe
#define AV_PKT_FLAG_CORRUPT 0x0002 ///< The packet content is corrupted

typedef struct AVCodecDescriptor {
    enum AVCodecID     id;
    enum AVMediaType type;
    const char      *name;
    const char *long_name;
    int             props;
} AVCodecDescriptor;

typedef struct AVCodecContext {
    const AVClass *av_class;
    int log_level_offset;
    enum AVMediaType codec_type; /* see AVMEDIA_TYPE_xxx */
    const struct AVCodec  *codec;
    char             codec_name[32];
    enum AVCodecID     codec_id; /* see AV_CODEC_ID_xxx */
    unsigned int codec_tag;
    unsigned int stream_codec_tag;
    void *priv_data;
    void *internal;
    void *opaque;
    int bit_rate;
    int bit_rate_tolerance;
    int global_quality;
    int compression_level;
    int flags;
    int flags2;
    uint8_t *extradata;
    int extradata_size;
    AVRational time_base;
    int ticks_per_frame;
    int delay;
    int width;
    int height;
    int coded_width;
    int coded_height;
    int gop_size;
    enum AVPixelFormat pix_fmt;
    int me_method;
    int max_b_frames;
    float b_quant_factor;
    int rc_strategy;
    int b_frame_strategy;
    float b_quant_offset;
    int has_b_frames;
    int mpeg_quant;
    float i_quant_factor;
    float i_quant_offset;
    float lumi_masking;
    float temporal_cplx_masking;
    float spatial_cplx_masking;
    float p_masking;
    float dark_masking;
    int slice_count;
    int prediction_method;
    int *slice_offset;
    AVRational sample_aspect_ratio;
    int me_cmp;
    int me_sub_cmp;
    int mb_cmp;
    int ildct_cmp;
    int dia_size;
    int last_predictor_count;
    int pre_me;
    int me_pre_cmp;
    int pre_dia_size;
    int me_subpel_quality;
    int dtg_active_format;
    int me_range;
    int intra_quant_bias;
    int inter_quant_bias;
    int slice_flags;
    int xvmc_acceleration;
    int mb_decision;
    uint16_t *intra_matrix;
    uint16_t *inter_matrix;
    int scenechange_threshold;
    int noise_reduction;
    int me_threshold;
    int mb_threshold;
    int intra_dc_precision;
    int skip_top;
    int skip_bottom;
    float border_masking;
    int mb_lmin;
    int mb_lmax;
    int me_penalty_compensation;
    int bidir_refine;
    int brd_scale;
    int keyint_min;
    int refs;
    int chromaoffset;
    int scenechange_factor;
    int mv0_threshold;
    int b_sensitivity;
    enum AVColorPrimaries color_primaries;
    enum AVColorTransferCharacteristic color_trc;
    enum AVColorSpace colorspace;
    enum AVColorRange color_range;
    enum AVChromaLocation chroma_sample_location;
    int slices;
    enum AVFieldOrder field_order;
    int sample_rate; ///< samples per second
    int channels;    ///< number of audio channels
    enum AVSampleFormat sample_fmt;  ///< sample format
    int frame_size;
    int frame_number;
    int block_align;
    int cutoff;
    int request_channels;
    uint64_t channel_layout;
    uint64_t request_channel_layout;
    enum AVAudioServiceType audio_service_type;
    enum AVSampleFormat request_sample_fmt;
    int refcounted_frames;
    float qcompress;  ///< amount of qscale change between easy & hard scenes (0.0-1.0)
    float qblur;      ///< amount of qscale smoothing over time (0.0-1.0)
    int qmin;
    int qmax;
    int max_qdiff;
    float rc_qsquish;
    float rc_qmod_amp;
    int rc_qmod_freq;
    int rc_buffer_size;
    int rc_override_count;
    void *rc_override;
    const char *rc_eq;
    int rc_max_rate;
    int rc_min_rate;
    float rc_buffer_aggressivity;
    float rc_initial_cplx;
    float rc_max_available_vbv_use;
    float rc_min_vbv_overflow_use;
    int rc_initial_buffer_occupancy;
    int coder_type;
    int context_model;
    int lmin;
    int lmax;
    int frame_skip_threshold;
    int frame_skip_factor;
    int frame_skip_exp;
    int frame_skip_cmp;
    int trellis;
    int min_prediction_order;
    int max_prediction_order;
    int64_t timecode_frame_start;
    int rtp_payload_size;   /* The size of the RTP payload: the coder will  */
    int mv_bits;
    int header_bits;
    int i_tex_bits;
    int p_tex_bits;
    int i_count;
    int p_count;
    int skip_count;
    int misc_bits;
    int frame_bits;
    char *stats_out;
    char *stats_in;
    int workaround_bugs;
    int strict_std_compliance;
    int error_concealment;
    int debug;
    int debug_mv;
    int err_recognition;
    int64_t reordered_opaque;
    void *hwaccel;
    void *hwaccel_context;
    uint64_t error[AV_NUM_DATA_POINTERS];
    int dct_algo;
    int idct_algo;
    int bits_per_coded_sample;
    int bits_per_raw_sample;
    AVFrame *coded_frame;
    int thread_count;
    int thread_type;
    int active_thread_type;
    int thread_safe_callbacks;
    void *thread_opaque;
    int nsse_weight;
    int profile;
    int level;
    enum AVDiscard skip_loop_filter;
    enum AVDiscard skip_idct;
    enum AVDiscard skip_frame;
    uint8_t *subtitle_header;
    int subtitle_header_size;
    int error_rate;
    AVPacket *pkt;
    uint64_t vbv_delay;
    AVRational pkt_timebase;
    const AVCodecDescriptor *codec_descriptor;
    int lowres;
    int64_t pts_correction_num_faulty_pts; /// Number of incorrect PTS values so far
    int64_t pts_correction_num_faulty_dts; /// Number of incorrect DTS values so far
    int64_t pts_correction_last_pts;       /// PTS of the last frame
    int64_t pts_correction_last_dts;       /// DTS of the last frame
    char *sub_charenc;
    int sub_charenc_mode;
    int skip_alpha;
    int seek_preroll;
} AVCodecContext;

typedef struct AVCodec {
    const char *name;
    const char *long_name;
    enum AVMediaType type;
    enum AVCodecID id;
    int capabilities;
    const AVRational *supported_framerates; ///< array of supported framerates, or NULL if any, array is terminated by {0,0}
    const enum AVPixelFormat *pix_fmts;     ///< array of supported pixel formats, or NULL if unknown, array is terminated by -1
    const int *supported_samplerates;       ///< array of supported audio samplerates, or NULL if unknown, array is terminated by 0
    const enum AVSampleFormat *sample_fmts; ///< array of supported sample formats, or NULL if unknown, array is terminated by -1
    const uint64_t *channel_layouts;         ///< array of support channel layouts, or NULL if unknown. array is terminated by 0
    const AVClass *priv_class;              ///< AVClass for the private context
    const AVProfile *profiles;              ///< array of recognized profiles, or NULL if unknown, array is terminated by {FF_PROFILE_UNKNOWN}
    int priv_data_size;
    struct AVCodec *next;
    int (*init_thread_copy)(AVCodecContext *);
    int (*update_thread_context)(AVCodecContext *dst, const AVCodecContext *src);
    void *defaults;
    void (*init_static_data)(struct AVCodec *codec);
    int (*init)(AVCodecContext *);
    int (*encode_sub)(AVCodecContext *, uint8_t *buf, int buf_size,
                      const struct AVSubtitle *sub);
    int (*encode2)(AVCodecContext *avctx, AVPacket *avpkt, const AVFrame *frame,
                   int *got_packet_ptr);
    int (*decode)(AVCodecContext *, void *outdata, int *outdata_size, AVPacket *avpkt);
    int (*close)(AVCodecContext *);
    void (*flush)(AVCodecContext *);
} AVCodec;

typedef struct AVPicture {
    uint8_t *data[AV_NUM_DATA_POINTERS];    ///< pointers to the image data planes
    int linesize[AV_NUM_DATA_POINTERS];     ///< number of bytes per line
} AVPicture;

unsigned avcodec_version(void);
AVCodecContext *avcodec_alloc_context3(const AVCodec *codec);
int avcodec_get_context_defaults3(AVCodecContext *s, const AVCodec *codec);
AVFrame *avcodec_alloc_frame(void);
int avcodec_open2(AVCodecContext *avctx, const AVCodec *codec, AVDictionary **options);
int avcodec_close(AVCodecContext *avctx);
void av_init_packet(AVPacket *pkt);
void av_free_packet(AVPacket *pkt);
int avcodec_decode_video2(AVCodecContext *avctx, AVFrame *picture,
                         int *got_picture_ptr,
                         const AVPacket *avpkt);
int avcodec_decode_audio4(AVCodecContext *avctx, AVFrame *frame,
                          int *got_frame_ptr, const AVPacket *avpkt);

enum AVPictureStructure {
    AV_PICTURE_STRUCTURE_UNKNOWN,      //< unknown
    AV_PICTURE_STRUCTURE_TOP_FIELD,    //< coded as top field
    AV_PICTURE_STRUCTURE_BOTTOM_FIELD, //< coded as bottom field
    AV_PICTURE_STRUCTURE_FRAME,        //< coded as frame
};

typedef struct AVCodecParserContext {
    void *priv_data;
    struct AVCodecParser *parser;
    int64_t frame_offset; /* offset of the current frame */
    int64_t cur_offset; /* current offset
                           (incremented by each av_parser_parse()) */
    int64_t next_frame_offset; /* offset of the next frame */
    int pict_type; /* XXX: Put it back in AVCodecContext. */
    int repeat_pict; /* XXX: Put it back in AVCodecContext. */
    int64_t pts;     /* pts of the current frame */
    int64_t dts;     /* dts of the current frame */

    /* private data */
    int64_t last_pts;
    int64_t last_dts;
    int fetch_timestamp;

#define AV_PARSER_PTS_NB 4
    int cur_frame_start_index;
    int64_t cur_frame_offset[AV_PARSER_PTS_NB];
    int64_t cur_frame_pts[AV_PARSER_PTS_NB];
    int64_t cur_frame_dts[AV_PARSER_PTS_NB];

    int flags;
#define PARSER_FLAG_COMPLETE_FRAMES           0x0001
#define PARSER_FLAG_ONCE                      0x0002
/// Set if the parser has a valid file offset
#define PARSER_FLAG_FETCHED_OFFSET            0x0004
#define PARSER_FLAG_USE_CODEC_TS              0x1000

    int64_t offset;      ///< byte offset from starting packet start
    int64_t cur_frame_end[AV_PARSER_PTS_NB];

    int key_frame;
    int64_t convergence_duration;
    int dts_sync_point;
    int dts_ref_dts_delta;
    int pts_dts_delta;
    int64_t cur_frame_pos[AV_PARSER_PTS_NB];
    int64_t pos;
    int64_t last_pos;
    int duration;
    enum AVFieldOrder field_order;
    enum AVPictureStructure picture_structure;
    int output_picture_number;
} AVCodecParserContext;

typedef struct AVCodecParser {
    int codec_ids[5]; /* several codec IDs are permitted */
    int priv_data_size;
    int (*parser_init)(AVCodecParserContext *s);
    int (*parser_parse)(AVCodecParserContext *s,
                        AVCodecContext *avctx,
                        const uint8_t **poutbuf, int *poutbuf_size,
                        const uint8_t *buf, int buf_size);
    void (*parser_close)(AVCodecParserContext *s);
    int (*split)(AVCodecContext *avctx, const uint8_t *buf, int buf_size);
    struct AVCodecParser *next;
} AVCodecParser;


AVCodec *avcodec_find_decoder(enum AVCodecID id);
AVCodec *avcodec_find_encoder(enum AVCodecID id);
int avcodec_encode_video2(AVCodecContext *avctx, AVPacket *avpkt,
                          const AVFrame *frame, int *got_packet_ptr);
int avpicture_fill(AVPicture *picture, const uint8_t *ptr,
                   enum AVPixelFormat pix_fmt, int width, int height);
int avpicture_get_size(enum AVPixelFormat pix_fmt, int width, int height);
int av_image_alloc(uint8_t *pointers[4], int linesizes[4],
                   int w, int h, enum AVPixelFormat pix_fmt, int align);

#endif
