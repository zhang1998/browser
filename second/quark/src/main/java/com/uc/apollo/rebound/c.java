package com.uc.apollo.rebound;

import android.os.SystemClock;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        if (this.a.d && this.a.a != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.a.a.a((double) (uptimeMillis - this.a.e));
            this.a.e = uptimeMillis;
            this.a.b.post(this.a.c);
        }
    }
}
