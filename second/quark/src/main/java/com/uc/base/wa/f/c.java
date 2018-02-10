package com.uc.base.wa.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* compiled from: ProGuard */
final class c extends Handler {
    private static HandlerThread a;
    private static c b;

    static {
        a = null;
        b = null;
        HandlerThread handlerThread = new HandlerThread("WaDatabaseHandlerEx", 0);
        a = handlerThread;
        handlerThread.start();
        b = new c(a.getLooper());
    }

    private c(Looper looper) {
        super(looper);
    }

    public static Handler a() {
        return b;
    }

    public final String toString() {
        return "HandlerEx (WaDatabaseHandlerEx) {}";
    }
}
