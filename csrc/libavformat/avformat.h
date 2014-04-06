
#ifndef AVFORMAT_AVFORMAT_H
#define AVFORMAT_AVFORMAT_H


#include <time.h>
#include <stdio.h>  /* FILE */
#include "libavcodec/avcodec.h"
#include "libavutil/dict.h"
#include "libavutil/log.h"

#include "avio.h"
#include "libavformat/version.h"

struct AVFormatContext;

struct AVDeviceInfoList;

typedef struct AVFrac {
    int64_t val, num, den;
} AVFrac;

struct AVCodecTag;

typedef struct AVProbeData {
    int dummy;
} AVProbeData;

#define AVPROBE_SCORE_RETRY (AVPROBE_SCORE_MAX/4)
#define AVPROBE_SCORE_STREAM_RETRY (AVPROBE_SCORE_MAX/4-1)

#define AVPROBE_SCORE_EXTENSION  50 ///< score for file extension
#define AVPROBE_SCORE_MAX       100 ///< maximum score

#define AVPROBE_PADDING_SIZE 32             ///< extra allocated bytes at the end of the probe buffer

/// Demuxer will use avio_open, no opened file should be provided by the caller.
#define AVFMT_NOFILE        0x0001
#define AVFMT_NEEDNUMBER    0x0002 /**< Needs '%d' in filename. */
#define AVFMT_SHOW_IDS      0x0008 /**< Show format stream IDs numbers. */
#define AVFMT_RAWPICTURE    0x0020 /**< Format wants AVPicture structure for
                                      raw picture data. */
#define AVFMT_GLOBALHEADER  0x0040 /**< Format wants global header. */
#define AVFMT_NOTIMESTAMPS  0x0080 /**< Format does not need / have any timestamps. */
#define AVFMT_GENERIC_INDEX 0x0100 /**< Use generic index building code. */
#define AVFMT_TS_DISCONT    0x0200 /**< Format allows timestamp discontinuities. Note, muxers always require valid (monotone) timestamps */
#define AVFMT_VARIABLE_FPS  0x0400 /**< Format allows variable fps. */
#define AVFMT_NODIMENSIONS  0x0800 /**< Format does not need width/height */
#define AVFMT_NOSTREAMS     0x1000 /**< Format does not require any streams */
#define AVFMT_NOBINSEARCH   0x2000 /**< Format does not allow to fall back on binary search via read_timestamp */
#define AVFMT_NOGENSEARCH   0x4000 /**< Format does not allow to fall back on generic search */
#define AVFMT_NO_BYTE_SEEK  0x8000 /**< Format does not allow seeking by bytes */
#define AVFMT_ALLOW_FLUSH  0x10000 /**< Format allows flushing. If not set, the muxer will not receive a NULL packet in the write_packet function. */
#if LIBAVFORMAT_VERSION_MAJOR <= 54
#define AVFMT_TS_NONSTRICT 0x8020000 //we try to be compatible to the ABIs of ffmpeg and major forks
#else
#define AVFMT_TS_NONSTRICT 0x20000
#endif
                                   /**< Format does not require strictly
                                        increasing timestamps, but they must
                                        still be monotonic */
#define AVFMT_TS_NEGATIVE  0x40000 /**< Format allows muxing negative
                                        timestamps. If not set the timestamp
                                        will be shifted in av_write_frame and
                                        av_interleaved_write_frame so they
                                        start from 0.
                                        The user or muxer can override this through
                                        AVFormatContext.avoid_negative_ts
                                        */

#define AVFMT_SEEK_TO_PTS   0x4000000 /**< Seeking is based on PTS */

typedef struct AVOutputFormat {
    int dummy;
} AVOutputFormat;

typedef struct AVInputFormat {
    int dummy;
} AVInputFormat;

enum AVStreamParseType {
    AVSTREAM_PARSE_NONE,
    AVSTREAM_PARSE_FULL,       /**< full parsing and repack */
    AVSTREAM_PARSE_HEADERS,    /**< Only parse headers, do not repack. */
    AVSTREAM_PARSE_TIMESTAMPS, /**< full parsing and interpolation of timestamps for frames not starting on a packet boundary */
    AVSTREAM_PARSE_FULL_ONCE,  /**< full parsing and repack of the first frame only, only implemented for H.264 currently */
    AVSTREAM_PARSE_FULL_RAW=MKTAG(0,'R','A','W'),       /**< full parsing and repack with timestamp and position generation by parser for raw
                                                             this assumes that each packet in the file contains no demuxer level headers and
                                                             just codec level data, otherwise position generation would fail */
};

typedef struct AVIndexEntry {
    int dummy;
} AVIndexEntry;


typedef struct AVStream {
    int index;    /**< stream index in AVFormatContext */
    int id;
    AVCodecContext *codec;
    void *priv_data;
    struct AVFrac pts;
    AVRational time_base;
    int64_t start_time;
    int64_t duration;
    int64_t nb_frames;                 ///< number of frames in this stream if known or 0
    int disposition; /**< AV_DISPOSITION_* bit field */
    enum AVDiscard discard; ///< Selects which packets can be discarded at will and do not need to be demuxed.
    AVRational sample_aspect_ratio;
    AVDictionary *metadata;
    AVRational avg_frame_rate;
    AVPacket attached_pic;
#define MAX_STD_TIMEBASES (60*12+6)
    struct {
        int64_t last_dts;
        int64_t duration_gcd;
        int duration_count;
        int64_t rfps_duration_sum;
        double (*duration_error)[2][MAX_STD_TIMEBASES];
        int64_t codec_info_duration;
        int64_t codec_info_duration_fields;
        int found_decoder;

        int64_t last_duration;

        /**
         * Those are used for average framerate estimation.
         */
        int64_t fps_first_dts;
        int     fps_first_dts_idx;
        int64_t fps_last_dts;
        int     fps_last_dts_idx;

    } *info;
    int pts_wrap_bits; /**< number of bits in pts (used for wrapping control) */
#if FF_API_REFERENCE_DTS
    int64_t do_not_use;
#endif
    int64_t first_dts;
    int64_t cur_dts;
    int64_t last_IP_pts;
    int last_IP_duration;
#define MAX_PROBE_PACKETS 2500
    int probe_packets;
    int codec_info_nb_frames;
    enum AVStreamParseType need_parsing;
    struct AVCodecParserContext *parser;
    struct AVPacketList *last_in_packet_buffer;
    AVProbeData probe_data;
#define MAX_REORDER_DELAY 16
    int64_t pts_buffer[MAX_REORDER_DELAY+1];
    AVIndexEntry *index_entries; /**< Only used if the format does not
                                    support seeking natively. */
    int nb_index_entries;
    unsigned int index_entries_allocated_size;
    AVRational r_frame_rate;
    int stream_identifier;
    int64_t interleaver_chunk_size;
    int64_t interleaver_chunk_duration;
    int request_probe;
    int skip_to_keyframe;
    int skip_samples;
    int nb_decoded_frames;
    int64_t mux_ts_offset;
    int64_t pts_wrap_reference;
    int pts_wrap_behavior;
    int update_initial_durations_done;
    int64_t pts_reorder_error[MAX_REORDER_DELAY+1];
    uint8_t pts_reorder_error_count[MAX_REORDER_DELAY+1];
    int64_t last_dts_for_order_check;
    uint8_t dts_ordered;
    uint8_t dts_misordered;
} AVStream;

#define AV_PROGRAM_RUNNING 1

typedef struct AVProgram {
    int dummy;
} AVProgram;

typedef struct AVChapter {
    int dummy;
} AVChapter;

typedef int (*av_format_control_message)(struct AVFormatContext *s, int type,
                                         void *data, size_t data_size);

enum AVDurationEstimationMethod {
    AVFMT_DURATION_FROM_PTS,    ///< Duration accurately estimated from PTSes
    AVFMT_DURATION_FROM_STREAM, ///< Duration estimated from a stream with a known duration
    AVFMT_DURATION_FROM_BITRATE ///< Duration estimated from bitrate (less accurate)
};

typedef struct AVFormatInternal {
    int dummy;
} AVFormatInternal;

typedef struct AVFormatContext {
    const AVClass *av_class;
    struct AVInputFormat *iformat;
    struct AVOutputFormat *oformat;
    void *priv_data;
    AVIOContext *pb;
    int ctx_flags; /**< Format-specific flags, see AVFMTCTX_xx */
    unsigned int nb_streams;
    AVStream **streams;
    char filename[1024];
    int64_t start_time;
    int64_t duration;
    int bit_rate;

    unsigned int packet_size;
    int max_delay;

    int flags;
#define AVFMT_FLAG_GENPTS       0x0001 ///< Generate missing pts even if it requires parsing future frames.
#define AVFMT_FLAG_IGNIDX       0x0002 ///< Ignore index.
#define AVFMT_FLAG_NONBLOCK     0x0004 ///< Do not block when reading packets from input.
#define AVFMT_FLAG_IGNDTS       0x0008 ///< Ignore DTS on frames that contain both DTS & PTS
#define AVFMT_FLAG_NOFILLIN     0x0010 ///< Do not infer any values from other values, just return what is stored in the container
#define AVFMT_FLAG_NOPARSE      0x0020 ///< Do not use AVParsers, you also must set AVFMT_FLAG_NOFILLIN as the fillin code works on frames and no parsing -> no frames. Also seeking to frames can not work if parsing to find frame boundaries has been disabled
#define AVFMT_FLAG_NOBUFFER     0x0040 ///< Do not buffer frames when possible
#define AVFMT_FLAG_CUSTOM_IO    0x0080 ///< The caller has supplied a custom AVIOContext, don't avio_close() it.
#define AVFMT_FLAG_DISCARD_CORRUPT  0x0100 ///< Discard frames marked corrupted
#define AVFMT_FLAG_FLUSH_PACKETS    0x0200 ///< Flush the AVIOContext every packet.
#define AVFMT_FLAG_MP4A_LATM    0x8000 ///< Enable RTP MP4A-LATM payload
#define AVFMT_FLAG_SORT_DTS    0x10000 ///< try to interleave outputted packets by dts (using this flag can slow demuxing down)
#define AVFMT_FLAG_PRIV_OPT    0x20000 ///< Enable use of private options by delaying codec open (this could be made default once all code is converted)
#define AVFMT_FLAG_KEEP_SIDE_DATA 0x40000 ///< Don't merge side data but keep it separate.
    unsigned int probesize;
    int max_analyze_duration;

    const uint8_t *key;
    int keylen;

    unsigned int nb_programs;
    AVProgram **programs;
    enum AVCodecID video_codec_id;
    enum AVCodecID audio_codec_id;
    enum AVCodecID subtitle_codec_id;
    unsigned int max_index_size;
    unsigned int max_picture_buffer;
    unsigned int nb_chapters;
    AVChapter **chapters;
    AVDictionary *metadata;
    int64_t start_time_realtime;
    int fps_probe_size;
    int error_recognition;
    AVIOInterruptCB interrupt_callback;
    int debug;
#define FF_FDEBUG_TS        0x0001
    int64_t max_interleave_delta;
    int ts_id;
    int audio_preload;
    int max_chunk_duration;
    int max_chunk_size;
    int use_wallclock_as_timestamps;
    int avoid_negative_ts;
    int avio_flags;
    enum AVDurationEstimationMethod duration_estimation_method;
    unsigned int skip_initial_bytes;
    unsigned int correct_ts_overflow;
    int seek2any;
    int flush_packets;
    int probe_score;
    struct AVPacketList *packet_buffer;
    struct AVPacketList *packet_buffer_end;
    int64_t data_offset; /**< offset of the first packet */
    struct AVPacketList *raw_packet_buffer;
    struct AVPacketList *raw_packet_buffer_end;
    struct AVPacketList *parse_queue;
    struct AVPacketList *parse_queue_end;
#define RAW_PACKET_BUFFER_SIZE 2500000
    int raw_packet_buffer_remaining_size;
    int64_t offset;
    AVRational offset_timebase;
    AVFormatInternal *internal;
    int io_repositioned;
    AVCodec *video_codec;
    AVCodec *audio_codec;
    AVCodec *subtitle_codec;
    int metadata_header_padding;
    void *opaque;
    av_format_control_message control_message_cb;
    int64_t output_ts_offset;
} AVFormatContext;

typedef struct AVPacketList {
    int dummy;
} AVPacketList;

unsigned avformat_version(void);
void av_register_all(void);
AVFormatContext *avformat_alloc_context(void);
void avformat_free_context(AVFormatContext *s);
AVStream *avformat_new_stream(AVFormatContext *s, const AVCodec *c);
int avformat_alloc_output_context2(AVFormatContext **ctx, AVOutputFormat *oformat,
                                   const char *format_name, const char *filename);
int avformat_open_input(AVFormatContext **ps, const char *filename, AVInputFormat *fmt, AVDictionary **options);
int avformat_find_stream_info(AVFormatContext *ic, AVDictionary **options);
int av_find_best_stream(AVFormatContext *ic,
                        enum AVMediaType type,
                        int wanted_stream_nb,
                        int related_stream,
                        AVCodec **decoder_ret,
                        int flags);
int av_read_frame(AVFormatContext *s, AVPacket *pkt);
int av_seek_frame(AVFormatContext *s, int stream_index, int64_t timestamp,
                  int flags);
int avformat_seek_file(AVFormatContext *s, int stream_index, int64_t min_ts, int64_t ts, int64_t max_ts, int flags);
void avformat_close_input(AVFormatContext **s);

#define AVSEEK_FLAG_BACKWARD 1 ///< seek backward
#define AVSEEK_FLAG_BYTE     2 ///< seeking based on position in bytes
#define AVSEEK_FLAG_ANY      4 ///< seek to any frame, even non-keyframes
#define AVSEEK_FLAG_FRAME    8 ///< seeking based on frame number

int avformat_write_header(AVFormatContext *s, AVDictionary **options);
int av_write_frame(AVFormatContext *s, AVPacket *pkt);
int av_interleaved_write_frame(AVFormatContext *s, AVPacket *pkt);
int av_write_trailer(AVFormatContext *s);
AVOutputFormat *av_guess_format(const char *short_name,
                                const char *filename,
                                const char *mime_type);
enum AVCodecID av_guess_codec(AVOutputFormat *fmt, const char *short_name,
                            const char *filename, const char *mime_type,
                            enum AVMediaType type);
void av_dump_format(AVFormatContext *ic,
                    int index,
                    const char *url,
                    int is_output);

#endif /* AVFORMAT_AVFORMAT_H */
