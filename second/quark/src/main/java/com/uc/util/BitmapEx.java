package com.uc.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;

/* compiled from: ProGuard */
class BitmapEx {
    private static native Bitmap nativeCreateBitmap(int i, int i2, Config config, boolean z);

    static native byte[] nativeScaleNinePatch(byte[] bArr, float f, Rect rect);

    BitmapEx() {
    }

    static Bitmap a(int i, int i2, Config config, boolean z) throws OutOfMemoryError {
        Bitmap nativeCreateBitmap = nativeCreateBitmap(i, i2, config, z);
        if (nativeCreateBitmap == null) {
            try {
                nativeCreateBitmap = Bitmap.createBitmap(i, i2, config);
            } catch (Throwable th) {
                OutOfMemoryError outOfMemoryError = new OutOfMemoryError();
            }
        }
        if (nativeCreateBitmap != null) {
            nativeCreateBitmap.eraseColor(0);
        }
        return nativeCreateBitmap;
    }
}
