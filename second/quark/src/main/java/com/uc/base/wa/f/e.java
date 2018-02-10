package com.uc.base.wa.f;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/* compiled from: ProGuard */
public final class e {
    private static long a = 0;
    private static Handler b = new Handler(Looper.getMainLooper());

    public static void a(int i, Runnable runnable) {
        if (i == 1) {
            b.post(runnable);
        } else if (i == 2) {
            b.a().post(runnable);
        } else if (i == 3) {
            d.a().post(new a(runnable));
        } else if (i == 4) {
            c.a().post(runnable);
        } else {
            Log.e("gzm_wa_WaThreadHelper", "", new Throwable());
        }
    }

    public static Looper a() {
        return d.a().getLooper();
    }

    public static long b() {
        return a == 0 ? 0 : System.currentTimeMillis() - a;
    }
}
