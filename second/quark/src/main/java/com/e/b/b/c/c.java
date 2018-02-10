package com.e.b.b.c;

import android.app.Activity;
import android.os.SystemClock;
import com.e.b.b;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class c implements d {
    private static c b = null;
    private long a = 0;

    private c() {
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (b == null) {
                b = new c();
            }
            cVar = b;
        }
        return cVar;
    }

    public final void c() {
        this.a = SystemClock.elapsedRealtime();
    }

    public final void d() {
        if (0 != this.a && SystemClock.elapsedRealtime() - this.a > 600000) {
            b.a();
            b.b();
            com.alibaba.analytics.c.b(new HashMap());
        }
        this.a = 0;
    }

    public final void a(Activity activity) {
    }

    public final void b(Activity activity) {
    }

    public final void c(Activity activity) {
    }

    public final void d(Activity activity) {
    }
}
