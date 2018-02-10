package com.bumptech.glide.b.d.a;

import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class s extends z {
    s() {
    }

    public final float a(int i, int i2, int i3, int i4) {
        int min = Math.min(i2 / i4, i / i3);
        if (min == 0) {
            return IPictureView.DEFAULT_MIN_SCALE;
        }
        return IPictureView.DEFAULT_MIN_SCALE / ((float) Integer.highestOneBit(min));
    }

    public final int a() {
        return y.b;
    }
}
