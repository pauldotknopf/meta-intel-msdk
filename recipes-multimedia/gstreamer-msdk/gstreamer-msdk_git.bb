SUMMARY = "Intel Media SDK gstreamer plugin"
LICENSE = "LGPLv2.1+"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://github.com/01org/gstreamer-media-SDK.git;protocol=https;branch=release/mr3"

SRCREV = "739cfabbee4f0123ff945676a48933f9d5b25f6c"

inherit cmake

S = "${WORKDIR}/git"

DEPENDS += "wayland virtual/mesa libxrandr libxkbcommon msdk gstreamer1.0 gstreamer1.0-plugins-base libva libdrm gstreamer1.0-plugins-bad"

export MFX_HOME = "${STAGING_DIR_HOST}/opt/intel/mediasdk"

CFLAGS += "-I${STAGING_DIR_HOST}/opt/intel/mediasdk/include"
EXTRA_OECMAKE = "-DCMAKE_INSTALL_PREFIX=${libdir}/gstreamer-1.0 -DUSE_VP9_DECODER=ON -DUSE_DRI3_RENDERER=OFF -DUSE_WAYLAND_RENDERER=OFF"

# MFX_DECODER:BOOL=ON
# MFX_ENCODER:BOOL=ON
# MFX_H264_ENCODER:BOOL=ON
# MFX_H265_ENCODER:BOOL=ON
# MFX_JPEG_ENCODER:BOOL=ON
# MFX_MPEG2_ENCODER:BOOL=ON
# MFX_SINK:BOOL=ON
# MFX_SINK_BIN:BOOL=ON
# MFX_VC1_PARSER:BOOL=ON
# MFX_VPP:BOOL=ON
# USE_DRI3_RENDERER:BOOL=ON
# USE_EGL_RENDERER:BOOL=ON
# USE_HEVC_DECODER:BOOL=ON
# USE_VP8_DECODER:BOOL=ON
# USE_VP9_DECODER:BOOL=OFF
# USE_WAYLAND_RENDERER:BOOL=ON
# WITH_MSS_2016:BOOL=OFF
# WITH_WAYLAND:BOOL=ON
# WITH_X11:BOOL=ON


FILES_${PN} += "${libdir}/gstreamer-1.0"
FILES_${PN}-dbg += "${libdir}/gstreamer-1.0/.debug"
