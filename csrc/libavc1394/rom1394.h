/*
 * librom1394 - GNU/Linux IEEE 1394 CSR Config ROM Library
 *
 * Originally written by Andreas Micklei <andreas.micklei@ivistar.de>
 * Better directory and textual leaf processing provided by Stefan Lucke
 * Libtoolize-d and modifications by Dan Dennedy <dan@dennedy.org>
 * ROM manipulation routines by Dan Dennedy
 * Currently maintained by Dan Dennedy
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

#ifndef ROM1394_H
#define ROM1394_H
#include <libraw1394/raw1394.h>

// #define ROM1394_DEBUG 1

/* define standard offsets into config rom address space */
#define ROM1394_HEADER 0x00
#define ROM1394_BUS_ID 0x04
#define ROM1394_BUS_OPTIONS 0x08
#define ROM1394_GUID_HI 0x0C
#define ROM1394_GUID_LO 0x10
#define ROM1394_ROOT_DIRECTORY 0x14

#ifdef __cplusplus
extern "C" {
#endif

typedef enum rom1394_node_types_enum {
    ROM1394_NODE_TYPE_UNKNOWN,
    ROM1394_NODE_TYPE_DC,
    ROM1394_NODE_TYPE_AVC,
    ROM1394_NODE_TYPE_SBP2,
    ROM1394_NODE_TYPE_CPU
} rom1394_node_types;

typedef struct rom1394_bus_options_struct {
	char		irmc;
	char		cmc;
	char		isc;
	char		bmc;
	unsigned char	cyc_clk_acc;
	int		max_rec;
} rom1394_bus_options;

typedef struct rom1394_directory_struct {
	quadlet_t	node_capabilities;
	quadlet_t	vendor_id;
	quadlet_t	unit_spec_id;
	quadlet_t	unit_sw_version;
	quadlet_t	model_id;
	int         nr_textual_leafs;
	int         max_textual_leafs;
	char      **textual_leafs;
	char       *label;	/* aggregated from textual leaves */
} rom1394_directory;

int
rom1394_get_bus_info_block_length(raw1394handle_t handle, nodeid_t node);

quadlet_t
rom1394_get_bus_id(raw1394handle_t handle, nodeid_t node);

int
rom1394_get_bus_options(raw1394handle_t handle, nodeid_t node, rom1394_bus_options* bus_options);

octlet_t
rom1394_get_guid(raw1394handle_t handle, nodeid_t node);

int
rom1394_get_directory(raw1394handle_t handle, nodeid_t node, rom1394_directory *dir);

rom1394_node_types
rom1394_get_node_type(rom1394_directory *dir);

void
rom1394_free_directory(rom1394_directory *dir);


/* supply null value to skip update of a particular field */

int
rom1394_get_size(quadlet_t *buffer);

int
rom1394_set_directory(quadlet_t *buffer, rom1394_directory *dir);

int
rom1394_add_unit(quadlet_t *buffer, rom1394_directory *dir);

#ifdef __cplusplus
}
#endif
#endif

