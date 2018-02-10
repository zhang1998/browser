package com.uc.base.wa.f;

import android.os.Handler;
import android.os.HandlerThread;

/* compiled from: ProGuard */
final class b extends Handler {
    private static HandlerThread a;
    private static d b;

    static {
        a = null;
        b = null;
        HandlerThread handlerThread = new HandlerThread("WaBackgroundHandlerThread", 10);
        a = handlerThread;
        handlerThread.start();
        b = new d(a.getLooper());
    }

    public static Handler a() {
        return b;
    }

    public final String toString() {
        return "HandlerEx (WaBackgroundHandlerThread) {}";
    }
}
