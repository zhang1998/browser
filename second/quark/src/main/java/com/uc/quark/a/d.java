package com.uc.quark.a;

import android.os.Handler;
import android.os.Looper;

/* compiled from: ProGuard */
final class d implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ Runnable b = null;
    final /* synthetic */ boolean c = false;
    final /* synthetic */ Looper d;

    d(Runnable runnable, Looper looper) {
        this.a = runnable;
        this.d = looper;
    }

    public final void run() {
        Runnable runnable = null;
        if (m.k != null) {
            runnable = new a(this);
        }
        if (m.k != null) {
            m.k.postDelayed(runnable, 30000);
        }
        synchronized (m.class) {
            m.l.remove(this.a);
        }
        this.a.run();
        if (m.k != null) {
            m.k.removeCallbacks(runnable);
        }
        if (this.b == null) {
            return;
        }
        if (this.c || this.d == m.h.getLooper()) {
            m.h.post(this.b);
        } else {
            new Handler(this.d).post(this.b);
        }
    }
}
