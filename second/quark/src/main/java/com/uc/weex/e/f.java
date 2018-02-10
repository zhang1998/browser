package com.uc.weex.e;

import android.os.Handler;
import android.os.Looper;

/* compiled from: ProGuard */
public final class f {
    private static Handler a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        a.post(runnable);
    }
}
