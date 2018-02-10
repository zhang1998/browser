package com.taobao.weex.c.b;

import com.uc.crashsdk.export.LogType;
import java.util.Arrays;

/* compiled from: ProGuard */
public final class r {
    private static final int[] a = new int[]{1, 2, 4, 8, 16, 32, 64, 128, LogType.UNEXP};
    private final float[] b = new float[]{Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN, Float.NaN};
    private float[] c = null;
    private int d = 0;
    private boolean e;

    public final boolean a(int i, float f) {
        boolean z = false;
        if (o.a(this.b[i], f)) {
            return false;
        }
        this.b[i] = f;
        if (c.a(f)) {
            this.d &= a[i] ^ -1;
        } else {
            this.d |= a[i];
        }
        if (!((this.d & a[8]) == 0 && (this.d & a[4]) == 0 && (this.d & a[5]) == 0)) {
            z = true;
        }
        this.e = z;
        return true;
    }

    final void a() {
        Arrays.fill(this.b, Float.NaN);
        this.c = null;
        this.e = false;
        this.d = 0;
    }

    final float a(int i, int i2) {
        if ((this.d & a[i]) != 0) {
            return this.b[i];
        }
        return a(i2);
    }

    public final float a(int i) {
        float f = this.c != null ? this.c[i] : (i == 6 || i == 7) ? Float.NaN : 0.0f;
        if (this.d == 0) {
            return f;
        }
        if ((this.d & a[i]) != 0) {
            return this.b[i];
        }
        if (!this.e) {
            return f;
        }
        int i2 = (i == 1 || i == 3) ? 4 : 5;
        if ((this.d & a[i2]) != 0) {
            return this.b[i2];
        }
        if ((this.d & a[8]) != 0) {
            return this.b[8];
        }
        return f;
    }
}
