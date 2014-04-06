
#ifndef AVCODEC_AVCODEC_H
#define AVCODEC_AVCODEC_H

#include "libavutil/samplefmt.h"
#include "libavutil/avutil.h"
#include "libavutil/buffer.h"
#include "libavutil/dict.h"
#include "libavutil/frame.h"
#include "libavutil/log.h"
#include "libavutil/pixfmt.h"
#include "libavutil/rational.h"

#include "version.h"
#include "avcodecid.h"

typedef struct AVCodecDescriptor;

enum AVDiscard{
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
    AVCOL_PRI_BT2020      = 9, ///< ITU-R BT2020
    AVCOL_PRI_NB             , ///< Not part of ABI
};

enum AVColorTransferCharacteristic{
    AVCOL_TRC_BT709        =  1, ///< also ITU-R BT1361
    AVCOL_TRC_UNSPECIFIED  =  2,
    AVCOL_TRC_GAMMA22      =  4, ///< also ITU-R BT470M / ITU-R BT1700 625 PAL & SECAM
    AVCOL_TRC_GAMMA28      =  5, ///< also ITU-R BT470BG
    AVCOL_TRC_SMPTE170M    =  6, ///< also ITU-R BT601-6 525 or 625 / ITU-R BT1358 525 or 625 / ITU-R BT1700 NTSC
    AVCOL_TRC_SMPTE240M    =  7,
    AVCOL_TRC_LINEAR       =  8, ///< "Linear transfer characteristics"
    AVCOL_TRC_LOG          =  9, ///< "Logarithmic transfer characteristic (100:1 range)"
    AVCOL_TRC_LOG_SQRT     = 10, ///< "Logarithmic transfer characteristic (100 * Sqrt( 10 ) : 1 range)"
    AVCOL_TRC_IEC61966_2_4 = 11, ///< IEC 61966-2-4
    AVCOL_TRC_BT1361_ECG   = 12, ///< ITU-R BT1361 Extended Colour Gamut
    AVCOL_TRC_IEC61966_2_1 = 13, ///< IEC 61966-2-1 (sRGB or sYCC)
    AVCOL_TRC_BT2020_10    = 14, ///< ITU-R BT2020 for 10 bit system
    AVCOL_TRC_BT2020_12    = 15, ///< ITU-R BT2020 for 12 bit system
    AVCOL_TRC_NB               , ///< Not part of ABI
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

typedef struct RcOverride;

#define CODEC_FLAG_UNALIGNED 0x0001
#define CODEC_FLAG_QSCALE 0x0002  ///< Use fixed qscale.
#define CODEC_FLAG_4MV    0x0004  ///< 4 MV per MB allowed / advanced prediction for H.263.
#define CODEC_FLAG_OUTPUT_CORRUPT 0x0008 ///< Output even those frames that might be corrupted
#define CODEC_FLAG_QPEL   0x0010  ///< Use qpel MC.
#define CODEC_FLAG_GMC    0x0020  ///< Use GMC.
#define CODEC_FLAG_MV0    0x0040  ///< Always try a MB with MV=<0,0>.
#define CODEC_FLAG_INPUT_PRESERVED 0x0100
#define CODEC_FLAG_PASS1           0x0200   ///< Use internal 2pass ratecontrol in first pass mode.
#define CODEC_FLAG_PASS2           0x0400   ///< Use internal 2pass ratecontrol in second pass mode.
#define CODEC_FLAG_GRAY            0x2000   ///< Only decode/encode grayscale.
#if FF_API_EMU_EDGE
#define CODEC_FLAG_EMU_EDGE        0x4000
#endif
#define CODEC_FLAG_PSNR            0x8000   ///< error[?] variables will be set during encoding.
#define CODEC_FLAG_TRUNCATED       0x00010000 /** Input bitstream might be truncated at a random
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
#if FF_API_XVMC
#define CODEC_CAP_HWACCEL         0x0010
#endif
#define CODEC_CAP_DELAY           0x0020
#define CODEC_CAP_SMALL_LAST_FRAME 0x0040
#if FF_API_CAP_VDPAU
#define CODEC_CAP_HWACCEL_VDPAU    0x0080
#endif
#define CODEC_CAP_SUBFRAMES        0x0100
#define CODEC_CAP_EXPERIMENTAL     0x0200
#define CODEC_CAP_CHANNEL_CONF     0x0400
#if FF_API_NEG_LINESIZES
#define CODEC_CAP_NEG_LINESIZES    0x0800
#endif
#define CODEC_CAP_FRAME_THREADS    0x1000
#define CODEC_CAP_SLICE_THREADS    0x2000
#define CODEC_CAP_PARAM_CHANGE     0x4000
#define CODEC_CAP_AUTO_THREADS     0x8000
#define CODEC_CAP_VARIABLE_FRAME_SIZE 0x10000
#define CODEC_CAP_INTRA_ONLY       0x40000000
#define CODEC_CAP_LOSSLESS         0x80000000
#if FF_API_MB_TYPE
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
#endif

typedef struct AVPanScan{
    int dummy;
}AVPanScan;

#if FF_API_QSCALE_TYPE
#define FF_QSCALE_TYPE_MPEG1 0
#define FF_QSCALE_TYPE_MPEG2 1
#define FF_QSCALE_TYPE_H264  2
#define FF_QSCALE_TYPE_VP56  3
#endif
#if FF_API_GET_BUFFER
#define FF_BUFFER_TYPE_INTERNAL 1
#define FF_BUFFER_TYPE_USER     2 ///< direct rendering buffers (image is (de)allocated by user)
#define FF_BUFFER_TYPE_SHARED   4 ///< Buffer from somewhere else; don't deallocate image (data/base), all other tables are not shared.
#define FF_BUFFER_TYPE_COPY     8 ///< Just a (modified) copy of some other buffer, don't deallocate anything.

#define FF_BUFFER_HINTS_VALID    0x01 // Buffer hints value is meaningful (if 0 ignore).
#define FF_BUFFER_HINTS_READABLE 0x02 // Codec will read from buffer.
#define FF_BUFFER_HINTS_PRESERVE 0x04 // User must not alter buffer content.
#define FF_BUFFER_HINTS_REUSABLE 0x08 // Codec will reuse the buffer (update).
#endif
#define AV_GET_BUFFER_FLAG_REF (1 << 0)

enum AVPacketSideDataType {
    AV_PKT_DATA_PALETTE,
    AV_PKT_DATA_NEW_EXTRADATA,
    AV_PKT_DATA_PARAM_CHANGE,
    AV_PKT_DATA_H263_MB_INFO,
    AV_PKT_DATA_SKIP_SAMPLES=70,
    AV_PKT_DATA_JP_DUALMONO,
    AV_PKT_DATA_STRINGS_METADATA,
    AV_PKT_DATA_SUBTITLE_POSITION,
    AV_PKT_DATA_MATROSKA_BLOCKADDITIONAL,
    AV_PKT_DATA_WEBVTT_IDENTIFIER,
    AV_PKT_DATA_WEBVTT_SETTINGS,
    AV_PKT_DATA_METADATA_UPDATE,
};

typedef struct AVPacket {
    AVBufferRef *buf;
    int64_t pts;
    int64_t dts;
    uint8_t *data;
    int   size;
    int   stream_index;
    int   flags;
    struct {
        uint8_t *data;
        int      size;
        enum AVPacketSideDataType type;
    } *side_data;
    int side_data_elems;
    int   duration;
#if FF_API_DESTRUCT_PACKET
    void  (*destruct)(struct AVPacket *);
    void  *priv;
#endif
    int64_t pos;                            ///< byte position in stream, -1 if unknown
    int64_t convergence_duration;
} AVPacket;

#define AV_PKT_FLAG_KEY     0x0001 ///< The packet contains a keyframe
#define AV_PKT_FLAG_CORRUPT 0x0002 ///< The packet content is corrupted

typedef struct AVCodecInternal;

enum AVFieldOrder {
    AV_FIELD_UNKNOWN,
    AV_FIELD_PROGRESSIVE,
    AV_FIELD_TT,          //< Top coded_first, top displayed first
    AV_FIELD_BB,          //< Bottom coded first, bottom displayed first
    AV_FIELD_TB,          //< Top coded first, bottom displayed first
    AV_FIELD_BT,          //< Bottom coded first, top displayed first
};

typedef struct AVCodecContext {
    int dummy;
} AVCodecContext;

typedef struct AVProfile;

struct AVCodecDefault;

struct AVSubtitle;

typedef struct AVCodec {
    int dummy;
} AVCodec;

typedef struct AVPicture;

unsigned avcodec_version(void);
AVCodecContext *avcodec_alloc_context3(const AVCodec *codec);
int avcodec_get_context_defaults3(AVCodecContext *s, const AVCodec *codec);
#if FF_API_AVFRAME_LAVC
AVFrame *avcodec_alloc_frame(void);
#endif
int avcodec_open2(AVCodecContext *avctx, const AVCodec *codec, AVDictionary **options);
int avcodec_close(AVCodecContext *avctx);
void av_init_packet(AVPacket *pkt);
void av_free_packet(AVPacket *pkt);
AVCodec *avcodec_find_decoder(enum AVCodecID id);
int avcodec_decode_audio4(AVCodecContext *avctx, AVFrame *frame,
                          int *got_frame_ptr, const AVPacket *avpkt);
int avcodec_decode_video2(AVCodecContext *avctx, AVFrame *picture,
                         int *got_picture_ptr,
                         const AVPacket *avpkt);
enum AVPictureStructure {
    AV_PICTURE_STRUCTURE_UNKNOWN,      //< unknown
    AV_PICTURE_STRUCTURE_TOP_FIELD,    //< coded as top field
    AV_PICTURE_STRUCTURE_BOTTOM_FIELD, //< coded as bottom field
    AV_PICTURE_STRUCTURE_FRAME,        //< coded as frame
};

typedef struct AVCodecParserContext {
    int dummy;
} AVCodecParserContext;

typedef struct AVCodecParser;

AVCodec *avcodec_find_encoder(enum AVCodecID id);
int avcodec_encode_video2(AVCodecContext *avctx, AVPacket *avpkt,
                          const AVFrame *frame, int *got_packet_ptr);
int avpicture_fill(AVPicture *picture, const uint8_t *ptr,
                   enum AVPixelFormat pix_fmt, int width, int height);
int avpicture_get_size(enum AVPixelFormat pix_fmt, int width, int height);

#endif /* AVCODEC_AVCODEC_H */
