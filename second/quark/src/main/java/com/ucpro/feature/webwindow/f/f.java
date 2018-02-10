package com.ucpro.feature.webwindow.f;

import com.uc.a.d.l;

/* compiled from: ProGuard */
final class f implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ byte[] b;
    final /* synthetic */ c c;

    f(c cVar, String str, byte[] bArr) {
        this.c = cVar;
        this.a = str;
        this.b = bArr;
    }

    public final void run() {
        l.a(this.a, this.b);
    }
}
