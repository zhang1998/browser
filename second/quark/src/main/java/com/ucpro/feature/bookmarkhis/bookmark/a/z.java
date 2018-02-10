package com.ucpro.feature.bookmarkhis.bookmark.a;

/* compiled from: ProGuard */
final class z implements Runnable {
    final /* synthetic */ p a;

    z(p pVar) {
        this.a = pVar;
    }

    public final void run() {
        if (!this.a.a) {
            this.a.a = true;
            this.a.c.onReceiveValue(this.a.d);
        }
    }
}
