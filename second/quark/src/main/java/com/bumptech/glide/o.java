package com.bumptech.glide;

import android.widget.ImageView.ScaleType;

/* compiled from: ProGuard */
final /* synthetic */ class o {
    static final /* synthetic */ int[] a = new int[ScaleType.values().length];
    static final /* synthetic */ int[] b = new int[g.values().length];

    static {
        try {
            b[g.LOW.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            b[g.NORMAL.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            b[g.HIGH.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            b[g.IMMEDIATE.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            a[ScaleType.CENTER_CROP.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            a[ScaleType.CENTER_INSIDE.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
        try {
            a[ScaleType.FIT_CENTER.ordinal()] = 3;
        } catch (NoSuchFieldError e7) {
        }
        try {
            a[ScaleType.FIT_START.ordinal()] = 4;
        } catch (NoSuchFieldError e8) {
        }
        try {
            a[ScaleType.FIT_END.ordinal()] = 5;
        } catch (NoSuchFieldError e9) {
        }
        try {
            a[ScaleType.FIT_XY.ordinal()] = 6;
        } catch (NoSuchFieldError e10) {
        }
        try {
            a[ScaleType.CENTER.ordinal()] = 7;
        } catch (NoSuchFieldError e11) {
        }
        try {
            a[ScaleType.MATRIX.ordinal()] = 8;
        } catch (NoSuchFieldError e12) {
        }
    }
}
