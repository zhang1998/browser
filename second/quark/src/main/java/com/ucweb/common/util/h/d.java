package com.ucweb.common.util.h;

import android.os.Handler;
import android.os.Looper;

/* compiled from: ProGuard */
final class d implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ boolean c = false;
    final /* synthetic */ Looper d;

    d(Runnable runnable, Runnable runnable2, Looper looper) {
        this.a = runnable;
        this.b = runnable2;
        this.d = looper;
    }

    public final void run() {
        Runnable runnable = null;
        if (m.l != null) {
            runnable = new i(this);
        }
        if (m.l != null) {
            m.l.postDelayed(runnable, 30000);
        }
        synchronized (m.class) {
            m.m.remove(this.a);
        }
        this.a.run();
        if (m.l != null) {
            m.l.removeCallbacks(runnable);
        }
        if (this.b == null) {
            return;
        }
        if (this.c || this.d == m.i.getLooper()) {
            m.i.post(this.b);
        } else {
            new Handler(this.d).post(this.b);
        }
    }
}
