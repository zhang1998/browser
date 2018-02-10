package com.uc.b.a;

import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class s {
    private static /* synthetic */ int[] i;
    int a = 255;
    q b = new q();
    r c;
    int d;
    s e;
    float f = IPictureView.DEFAULT_MIN_SCALE;
    float g;
    float h;

    static /* synthetic */ int[] a() {
        int[] iArr = i;
        if (iArr == null) {
            iArr = new int[p.values().length];
            try {
                iArr[p.FILL.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[p.FILL_FILTER.ordinal()] = 5;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[p.FILL_OPACITY.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[p.FILL_RULE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[p.OPACITY.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[p.STROKE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[p.STROKE_DASH_ARRAY.ordinal()] = 12;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[p.STROKE_DASH_OFFSET.ordinal()] = 13;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[p.STROKE_LINE_CAP.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[p.STROKE_LINE_JOIN.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[p.STROKE_MITER_LIMIT.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[p.STROKE_OPACITY.ordinal()] = 7;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[p.STROKE_WIDTH.ordinal()] = 8;
            } catch (NoSuchFieldError e13) {
            }
            i = iArr;
        }
        return iArr;
    }

    public s(s sVar) {
        this.a = sVar.a;
        this.b = sVar.b;
        this.c = sVar.c;
        this.d = sVar.d;
        this.e = sVar.e;
        this.g = sVar.g;
        this.h = sVar.h;
    }
}
