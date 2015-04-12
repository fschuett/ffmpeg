/*
 * libavc1394 - GNU/Linux IEEE 1394 AV/C Library
 *
 * Originally written by Andreas Micklei <andreas.micklei@ivistar.de>
 * Currently maintained by Dan Dennedy <dan@dennedy.org>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

#ifndef AVC1394_VCR_H
#define AVC1394_VCR_H 1

#include <libraw1394/raw1394.h>

#ifdef __cplusplus
extern "C" {
#endif

/* ##### Check to see if device is playing ##### */
int 
avc1394_vcr_is_playing(raw1394handle_t handle, nodeid_t node);

/* ##### Check to see if the device is recording ##### */
int
avc1394_vcr_is_recording(raw1394handle_t handle, nodeid_t node);

/* ##### Tell the device to PLAY FORWARD ##### */
/* issue twice in a row to play forward at the slowest rate */
void
avc1394_vcr_play(raw1394handle_t handle, nodeid_t node);

/* ##### Tell the device to PLAY in REVERSE ##### */
/* issue twice in a row to play in reverse at the slowest rate */
void
avc1394_vcr_reverse(raw1394handle_t handle, nodeid_t node);

/* ##### exercise the trick play modes! ##### */
/* speed is a signed percentage value from -14 to +14 */
void
avc1394_vcr_trick_play(raw1394handle_t handle, nodeid_t node, int speed);

/* ##### Tell the device to STOP ##### */
void
avc1394_vcr_stop(raw1394handle_t handle, nodeid_t node);

/* ##### Tell the device to REWIND ##### */
void
avc1394_vcr_rewind(raw1394handle_t handle, nodeid_t node);

/* ##### Tell the device to PAUSE ##### */
void
avc1394_vcr_pause(raw1394handle_t handle, nodeid_t node);

/* ##### Tell the device to FAST FORWARD ##### */
void 
avc1394_vcr_forward(raw1394handle_t handle, nodeid_t node);

/* ##### Tell the device goto NEXT frame ##### */
void
avc1394_vcr_next(raw1394handle_t handle, nodeid_t node);

/* ##### Tell the device goto NEXT index point ##### */
void
avc1394_vcr_next_index(raw1394handle_t handle, nodeid_t node);

/* ##### Tell the device goto PREVIOUS frame ##### */
void 
avc1394_vcr_previous(raw1394handle_t handle, nodeid_t node);

/* ##### Tell the device goto PREVIOUS index point ##### */
void 
avc1394_vcr_previous_index(raw1394handle_t handle, nodeid_t node);

/* ##### Tell the device to EJECT (usually not supported) ##### */
void 
avc1394_vcr_eject(raw1394handle_t handle, nodeid_t node);

/* ##### Tell the device to RECORD ##### */
void 
avc1394_vcr_record(raw1394handle_t handle, nodeid_t node);

/* ##### Ask the device for the status ##### */
quadlet_t 
avc1394_vcr_status(raw1394handle_t handle, nodeid_t node);

/* Get a textual description of the status */
char *
avc1394_vcr_decode_status(quadlet_t response);

/* Get the time code on tape in format HH:MM:SS:FF */
/* This version allocates memory for the string, and 
   the caller is required to free it. */
char *
avc1394_vcr_get_timecode(raw1394handle_t handle, nodeid_t node);
/* This version requires a pre-allocated output string of at least 12 
   characters. */
int
avc1394_vcr_get_timecode2(raw1394handle_t handle, nodeid_t node, char *output);

/* Go to the time code on tape in format HH:MM:SS:FF */
void
avc1394_vcr_seek_timecode(raw1394handle_t handle, nodeid_t node, char *timecode);

#ifdef __cplusplus
}
#endif

#endif
