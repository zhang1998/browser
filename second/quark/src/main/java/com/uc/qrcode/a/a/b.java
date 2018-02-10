package com.uc.qrcode.a.a;

import android.hardware.Camera;

/* compiled from: ProGuard */
public final class b {
    public final Camera a;
    public final a b;
    public final int c;
    private final int d;

    public b(int i, Camera camera, a aVar, int i2) {
        this.d = i;
        this.a = camera;
        this.b = aVar;
        this.c = i2;
    }

    public final String toString() {
        return "Camera #" + this.d + " : " + this.b + ',' + this.c;
    }
}
