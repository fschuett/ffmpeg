/*
 * This file is part of FFmpeg.
 *
 * FFmpeg is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * FFmpeg is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with FFmpeg; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 */

#ifndef AVUTIL_SAMPLEFMT_H
#define AVUTIL_SAMPLEFMT_H

/**
 * Audio sample formats
 *
 * - The data described by the sample format is always in native-endian order.
 *   Sample values can be expressed by native C types, hence the lack of a signed
 *   24-bit sample format even though it is a common raw audio data format.
 *
 * - The floating-point formats are based on full volume being in the range
 *   [-1.0, 1.0]. Any values outside this range are beyond full volume level.
 *
 * - The data layout as used in av_samples_fill_arrays() and elsewhere in FFmpeg
 *   (such as AVFrame in libavcodec) is as follows:
 *
 * @par
 * For planar sample formats, each audio channel is in a separate data plane,
 * and linesize is the buffer size, in bytes, for a single plane. All data
 * planes must be the same size. For packed sample formats, only the first data
 * plane is used, and samples for each channel are interleaved. In this case,
 * linesize is the buffer size, in bytes, for the 1 plane.
 *
 */
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

/**
 * Return the name of sample_fmt, or NULL if sample_fmt is not
 * recognized.
 */
const char *av_get_sample_fmt_name(enum AVSampleFormat sample_fmt);

/**
 * Get the packed alternative form of the given sample format.
 *
 * If the passed sample_fmt is already in packed format, the format returned is
 * the same as the input.
 *
 * @return  the packed alternative form of the given sample format or
            AV_SAMPLE_FMT_NONE on error.
 */
enum AVSampleFormat av_get_packed_sample_fmt(enum AVSampleFormat sample_fmt);

/**
 * Return number of bytes per sample.
 *
 * @param sample_fmt the sample format
 * @return number of bytes per sample or zero if unknown for the given
 * sample format
 */
int av_get_bytes_per_sample(enum AVSampleFormat sample_fmt);

/**
 * Check if the sample format is planar.
 *
 * @param sample_fmt the sample format to inspect
 * @return 1 if the sample format is planar, 0 if it is interleaved
 */
int av_sample_fmt_is_planar(enum AVSampleFormat sample_fmt);

#endif /* AVUTIL_SAMPLEFMT_H */
