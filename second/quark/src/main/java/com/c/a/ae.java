package com.c.a;

import com.c.a.e.b;
import com.c.a.f.d;

/* compiled from: ProGuard */
final class ae implements Runnable {
    d a;
    long b;
    final /* synthetic */ r c;

    private ae(r rVar) {
        this.c = rVar;
    }

    public final void run() {
        b.a.removeCallbacks(this);
    }
}
