package com.uc.qrcode.a;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.os.Handler;

/* compiled from: ProGuard */
public final class a implements AutoFocusCallback {
    private static final String a = a.class.getSimpleName();
    private Handler b;
    private int c;

    public final void a(Handler handler, int i) {
        this.b = handler;
        this.c = i;
    }

    public final void onAutoFocus(boolean z, Camera camera) {
        if (this.b != null) {
            this.b.sendMessageDelayed(this.b.obtainMessage(this.c, Boolean.valueOf(z)), 1500);
            this.b = null;
        }
    }
}
