package com.ucpro.services.download.b;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ d a;

    b(d dVar) {
        this.a = dVar;
    }

    public final void run() {
        this.a.c().cancel(4627);
        this.a.c().cancel(4628);
    }
}
