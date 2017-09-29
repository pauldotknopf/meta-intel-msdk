SUMMARY = "Intel Media Driver for Media SDK"
DESCRIPTION = "Intel iHD Media Driver for Media SDK"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

SRC_URI = "file://${RPM_PATH}/intel-linux-media-${PV}*.rpm;subdir=${BP};name=msdk-rpm"

DEPENDS = "libdrm virtual/mesa virtual/libgles1 virtual/libgles2 virtual/egl libva"
RDEPENDS_${PN} += " libdrm"

INSANE_SKIP_${PN} += " already-stripped dev-so useless-rpaths"

do_install() {
        mkdir -p ${D}${libdir}
        cp -r ${S}/etc ${D}
        cp -r ${S}/usr/lib*/* ${D}${libdir}
}

FILES_${PN} += "${libdir}/*.so"
