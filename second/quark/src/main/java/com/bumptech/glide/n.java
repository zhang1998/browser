package com.bumptech.glide;

import com.bumptech.glide.f.e;

/* compiled from: ProGuard */
public final class n implements Runnable {
    final /* synthetic */ e a;
    final /* synthetic */ p b;

    public n(p pVar, e eVar) {
        this.b = pVar;
        this.a = eVar;
    }

    public final void run() {
        if (!this.a.isCancelled()) {
            this.b.a(this.a);
        }
    }
}
