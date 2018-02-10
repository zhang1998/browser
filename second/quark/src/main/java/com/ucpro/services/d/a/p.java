package com.ucpro.services.d.a;

import com.uc.a.d.l;

/* compiled from: ProGuard */
final class p implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ byte[] b;
    final /* synthetic */ c c;

    p(c cVar, String str, byte[] bArr) {
        this.c = cVar;
        this.a = str;
        this.b = bArr;
    }

    public final void run() {
        l.a(this.a, this.b);
    }
}
