package com.taobao.weex.common;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;

/* compiled from: ProGuard */
public final class w extends HandlerThread {
    public Handler a;

    public static Runnable a(Runnable runnable) {
        if (runnable == null || (runnable instanceof v)) {
            return runnable;
        }
        String canonicalName = runnable.getClass().getCanonicalName();
        return (canonicalName == null || !canonicalName.startsWith("android.view.")) ? new v(runnable) : runnable;
    }

    public static Callback a(Callback callback) {
        return (callback == null || (callback instanceof u)) ? callback : new u(callback);
    }

    public w(String str) {
        super(str);
        start();
        this.a = new Handler(getLooper());
    }

    public w(String str, Callback callback) {
        super(str);
        start();
        this.a = new Handler(getLooper(), a(callback));
    }

    public final boolean a() {
        return (this.a == null || getLooper() == null || !isAlive()) ? false : true;
    }

    public final boolean quit() {
        if (this.a != null) {
            this.a.removeCallbacksAndMessages(null);
        }
        return super.quit();
    }
}
