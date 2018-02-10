package com.uc.qrcode.a;

import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;

/* compiled from: ProGuard */
public final class d implements PreviewCallback {
    private static final String a = d.class.getSimpleName();
    private final b b;
    private final boolean c;
    private Handler d;
    private int e;

    d(b bVar, boolean z) {
        this.b = bVar;
        this.c = z;
    }

    public final void a(Handler handler, int i) {
        this.d = handler;
        this.e = i;
    }

    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        Point point = this.b.e;
        if (!this.c) {
            camera.setPreviewCallback(null);
        }
        if (this.d != null && point != null) {
            this.d.obtainMessage(this.e, point.x, point.y, bArr).sendToTarget();
            this.d = null;
        }
    }
}
