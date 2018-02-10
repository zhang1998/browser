package com.uc.base.wa.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* compiled from: ProGuard */
final class d extends Handler {
    private static HandlerThread a;
    private static d b;

    static {
        a = null;
        b = null;
        HandlerThread handlerThread = new HandlerThread("WaHandlerThread", 11);
        a = handlerThread;
        handlerThread.start();
        b = new d(a.getLooper());
    }

    public d(Looper looper) {
        super(looper);
    }

    public static Handler a() {
        return b;
    }

    public final String toString() {
        return "HandlerEx (WaHandlerThread) {}";
    }
}
