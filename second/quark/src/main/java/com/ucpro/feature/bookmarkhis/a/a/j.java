package com.ucpro.feature.bookmarkhis.a.a;

/* compiled from: ProGuard */
final class j implements Runnable {
    final /* synthetic */ d a;

    j(d dVar) {
        this.a = dVar;
    }

    public final void run() {
        this.a.f = true;
        if (this.a.e != null) {
            for (f a : this.a.e) {
                this.a.a(a);
            }
            this.a.e.clear();
        }
    }
}
