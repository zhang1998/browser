package com.c.a.b;

/* compiled from: ProGuard */
final class a implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ c b;

    a(c cVar, int i) {
        this.b = cVar;
        this.a = i;
    }

    public final void run() {
        if (this.b.f != null) {
            this.b.f.onNotSupport(this.a);
        }
    }
}
