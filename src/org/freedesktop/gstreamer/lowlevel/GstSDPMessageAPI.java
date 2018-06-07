package org.freedesktop.gstreamer.lowlevel;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

import java.util.Arrays;
import java.util.List;

public interface GstSDPMessageAPI extends com.sun.jna.Library {
    GstSDPMessageAPI GSTSDPMESSAGE_API =
            GstNative.load("gstsdp", GstSDPMessageAPI.class);
    public static final class GstSDPMessage extends com.sun.jna.Structure {

        public GstSDPMessage(Pointer ptr) {
            System.out.println("GstSDPMessage ptr: " + ptr);
            useMemory(ptr);
            read();
        }

        public String version;
        public GstSDPOrigin      origin;
        public String            session_name;
        public String            information;
        public String            uri;
        public GlibAPI.GArray    emails;
        public GlibAPI.GArray    phones;
        GstSDPConnection  connection;
        public GlibAPI.GArray    bandwidths;
        public GlibAPI.GArray    times;
        public GlibAPI.GArray    zones;
        GstSDPType         key;
        public GlibAPI.GArray    attributes;
        public GlibAPI.GArray    medias;

        @Override
        protected List<String> getFieldOrder() {
            return null;
        }
    }

    public static final class GstSDPMedia extends com.sun.jna.Structure {
        public GstSDPMedia(Pointer ptr) {
            useMemory(ptr);
            read();
        }
        public String            media;
        public int             port;
        public int             num_ports;
        public String          proto;
        public GlibAPI.GArray  fmts;
        public String          information;
        public GlibAPI.GArray  connections;
        public GlibAPI.GArray  bandwidths;
        GstSDPType         key;
        public GlibAPI.GArray  attributes;

        @Override
        protected List<String> getFieldOrder() {
            return null;
        }
    }

    public static final class GstSDPOrigin extends  com.sun.jna.Structure {
        public GstSDPOrigin(Pointer ptr) {
            useMemory(ptr);
            read();
        }
        public String username;
        public String sess_id;
        public String sess_version;
        public String nettype;
        public String addrtype;
        public String addr;

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList(new String[] { "username", "sess_id", "sess_version", "nettype", "addrtype", "addr" });
        }
    }

    public static final class GstSDPType extends  com.sun.jna.Structure {
        public GstSDPType(Pointer ptr) {
            useMemory(ptr);
            read();
        }
        public String type;
        public String data;

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList(new String[] { "type", "data" });
        }
    }

    public static final class GstSDPConnection extends  com.sun.jna.Structure {
        public GstSDPConnection(Pointer ptr) {
            useMemory(ptr);
            read();
        }
        public String nettype;
        public String addrtype;
        public String address;
        public int  ttl;
        public int  addr_number;

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList(new String[] { "nettype", "addrtype", "address", "ttl", "addr_number" });
        }
    }


    String gst_sdp_message_as_text(Pointer sdpPtr);
    int    gst_sdp_message_new(PointerByReference msgPtrByReference);
}
