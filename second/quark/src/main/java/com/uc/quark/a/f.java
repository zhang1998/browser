package com.uc.quark.a;

import android.os.Handler;
import android.os.Looper;

/* compiled from: ProGuard */
final class f implements Runnable {
    final /* synthetic */ Runnable a = null;
    final /* synthetic */ boolean b = false;
    final /* synthetic */ Looper c;
    final /* synthetic */ Handler d;
    final /* synthetic */ Runnable e;

    f(Looper looper, Handler handler, Runnable runnable) {
        this.c = looper;
        this.d = handler;
        this.e = runnable;
    }

    public final void run() {
        if (this.a == null) {
            this.e.run();
        } else if (this.b || this.c == m.h.getLooper()) {
            m.h.post(new l(this));
        } else {
            new Handler(this.c).post(new o(this));
        }
    }
}
