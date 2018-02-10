package com.c.a.b.a;

import com.c.a.ac;

/* compiled from: ProGuard */
final class g implements Runnable {
    final /* synthetic */ d a;

    g(d dVar) {
        this.a = dVar;
    }

    public final void run() {
        if (this.a.e) {
            synchronized (this.a.g) {
                for (ac a : this.a.a()) {
                    a.a(this.a.d);
                }
            }
        }
    }
}
