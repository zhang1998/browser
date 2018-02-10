package com.uc.b.a;

import android.graphics.Matrix;

/* compiled from: ProGuard */
abstract class g {
    private static /* synthetic */ int[] a;
    Matrix d;

    private g() {
    }

    static /* synthetic */ int[] e() {
        int[] iArr = a;
        if (iArr == null) {
            iArr = new int[ad.values().length];
            try {
                iArr[ad.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ad.ROTATE.ordinal()] = 6;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ad.SCALE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[ad.SKEWX.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[ad.SKEWY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[ad.TRANSLATE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            a = iArr;
        }
        return iArr;
    }

    public Matrix d() {
        return this.d;
    }
}
