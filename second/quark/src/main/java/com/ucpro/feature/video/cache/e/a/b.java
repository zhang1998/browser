package com.ucpro.feature.video.cache.e.a;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ i c;

    b(i iVar, int i, String str) {
        this.c = iVar;
        this.a = i;
        this.b = str;
    }

    public final void run() {
        this.c.a.a(this.a, this.b);
    }
}
