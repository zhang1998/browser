package com.ucweb.common.util.h;

import android.os.Handler;
import android.os.Looper;

/* compiled from: ProGuard */
final class h implements Runnable {
    final /* synthetic */ Runnable a = null;
    final /* synthetic */ boolean b = false;
    final /* synthetic */ Looper c;
    final /* synthetic */ Handler d;
    final /* synthetic */ Runnable e;

    h(Runnable runnable, Looper looper, Handler handler, Runnable runnable2) {
        this.c = looper;
        this.d = handler;
        this.e = runnable2;
    }

    public final void run() {
        if (this.a == null) {
            this.e.run();
        } else if (this.b || this.c == m.i.getLooper()) {
            m.i.post(new l(this));
        } else {
            new Handler(this.c).post(new j(this));
        }
    }
}
