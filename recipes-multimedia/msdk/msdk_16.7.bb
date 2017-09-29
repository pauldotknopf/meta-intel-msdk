SUMMARY = "Intel Media SDK samples and binaries"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://opt/intel/mediasdk/include/mfxcommon.h;beginline=3;endline=25;md5=bfb4a41e79398c99c4af85128bb4eb77"

SRC_URI = "file://${RPM_PATH}/intel-linux-mediasdk-${PV}-*.rpm;subdir=${BP};name=msdk-rpm \
           file://${RPM_PATH}/intel-linux-mediasdk-devel-${PV}-*.rpm;subdir=${BP};name=msdk-rpm"

DEPENDS += "libva"
RDEPENDS_${PN} += " wayland perl"
RDEPENDS_${PN}-samples += " perl"

INSANE_SKIP_${PN} = " already-stripped dev-so staticdev"
INSANE_SKIP_${PN}-plugins = " ldflags"

inherit bin_package

PACKAGE_BEFORE_PN = "${PN}-samples ${PN}-plugins"

SYSROOT_PREPROCESS_FUNCS += "msdk_populate_sysroot"
msdk_populate_sysroot() {
        sysroot_stage_dir ${D}/opt ${SYSROOT_DESTDIR}/opt
}

FILES_${PN}-doc = "/opt/intel/mediasdk/doc"

FILES_${PN}-samples = "/opt/intel/mediasdk/samples/"

FILES_${PN}-dev = "/opt/intel/mediasdk/include \
                   /opt/intel/mediasdk/opensource \
                   /opt/intel/mediasdk/builder \
                   "

FILES_${PN}-plugins = "/opt/intel/mediasdk/plugins"
