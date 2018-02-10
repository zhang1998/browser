package com.ucpro.feature.downloadpage.e.c.a;

import android.os.Handler;
import android.os.Looper;
import com.ucweb.common.util.h.m;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class e implements Runnable {
    private static String d = "FileStorageUsage";
    private static e e = null;
    public List<a> a;
    public Handler b;
    public boolean c;
    private long f;
    private long g;

    private e() {
        this.a = new ArrayList();
        this.b = null;
        this.c = false;
        this.f = 0;
        this.g = 0;
        this.b = new com.ucweb.common.util.e(getClass().getName() + 58, Looper.getMainLooper());
    }

    public static e a() {
        if (e == null) {
            e = new e();
        }
        return e;
    }

    public final void run() {
        if (this.c) {
            m.a(0, new i(this), new c(this));
        }
    }
}
