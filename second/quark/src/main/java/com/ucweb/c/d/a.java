package com.ucweb.c.d;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* compiled from: ProGuard */
public final class a {
    public static Bitmap a(Bitmap bitmap, int i, int i2, Matrix matrix) {
        if (bitmap == null) {
            return null;
        }
        Bitmap createBitmap;
        if (i > 0 && i2 > 0) {
            try {
                createBitmap = Bitmap.createBitmap(bitmap, 0, 0, i, i2, matrix, true);
            } catch (Throwable th) {
            }
            return createBitmap;
        }
        createBitmap = null;
        return createBitmap;
    }
}
