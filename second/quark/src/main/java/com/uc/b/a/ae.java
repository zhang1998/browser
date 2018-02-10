package com.uc.b.a;

import android.graphics.Matrix;

/* compiled from: ProGuard */
final class ae {
    private static /* synthetic */ int[] g;
    float a;
    float b;
    float c;
    float d;
    Matrix e;
    m f;

    static /* synthetic */ int[] a() {
        int[] iArr = g;
        if (iArr == null) {
            iArr = new int[k.values().length];
            try {
                iArr[k.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[k.X_MAX_Y_MAX.ordinal()] = 10;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[k.X_MAX_Y_MID.ordinal()] = 7;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[k.X_MAX_Y_MIN.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[k.X_MID_Y_MAX.ordinal()] = 9;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[k.X_MID_Y_MID.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[k.X_MID_Y_MIN.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[k.X_MIN_Y_MAX.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[k.X_MIN_Y_MID.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[k.X_MIN_Y_MIN.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            g = iArr;
        }
        return iArr;
    }

    ae(float f, float f2, float f3, float f4) {
        this.f = m.c;
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
    }

    private ae(float f, float f2, float f3, float f4, m mVar) {
        this(f, f2, f3, f4);
        this.f = mVar;
    }

    ae(float f, float f2, float f3, float f4, k kVar, l lVar) {
        this(f, f2, f3, f4, new m(kVar, lVar));
    }
}
