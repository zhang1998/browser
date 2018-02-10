package com.uc.quark.filedownloader.services.a;

import android.os.HandlerThread;

/* compiled from: ProGuard */
public final class c {
    public e a;
    private HandlerThread b;

    private c() {
        this.b = new HandlerThread("IOThread");
        this.b.start();
        this.a = new e(this.b.getLooper());
    }
}
