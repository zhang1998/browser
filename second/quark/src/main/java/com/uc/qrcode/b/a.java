package com.uc.qrcode.b;

/* compiled from: ProGuard */
public enum a {
    KEY_DECODE_1D_PRODUCT(true),
    KEY_DECODE_1D_INDUSTRIAL(true),
    KEY_DECODE_QR(true),
    KEY_DECODE_DATA_MATRIX(true),
    KEY_DECODE_AZTEC(true),
    KEY_DECODE_PDF417(false),
    KEY_PLAY_BEEP(false),
    KEY_VIBRATE(true),
    KEY_FRONT_LIGHT_MODE(false),
    KEY_BULK_MODE(false),
    KEY_AUTO_FOCUS(true),
    KEY_INVERT_SCAN(true),
    KEY_DISABLE_EXPOSURE(false),
    KEY_DISABLE_CONTINUOUS_FOCUS(false),
    KEY_DISABLE_METERING(false),
    KEY_DISABLE_BARCODE_SCENE_MODE(false),
    KEY_DISABLE_AUTO_ORIENTATION(true);
    
    public boolean r;

    private a(boolean z) {
        this.r = z;
    }
}
