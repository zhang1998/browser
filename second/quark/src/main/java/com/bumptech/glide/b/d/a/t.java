package com.bumptech.glide.b.d.a;

import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class t extends z {
    t() {
    }

    public final float a(int i, int i2, int i3, int i4) {
        int i5 = 1;
        int ceil = (int) Math.ceil((double) Math.max(((float) i2) / ((float) i4), ((float) i) / ((float) i3)));
        int max = Math.max(1, Integer.highestOneBit(ceil));
        if (max >= ceil) {
            i5 = 0;
        }
        return IPictureView.DEFAULT_MIN_SCALE / ((float) (max << i5));
    }

    public final int a() {
        return y.a;
    }
}
