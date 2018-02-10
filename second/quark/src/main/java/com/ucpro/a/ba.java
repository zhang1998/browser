package com.ucpro.a;

import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class ba implements Runnable {
    final /* synthetic */ byte[] a;
    final /* synthetic */ t b;

    ba(t tVar, byte[] bArr) {
        this.b = tVar;
        this.a = bArr;
    }

    public final void run() {
        m.a(0, new af(this.b.c, this.b.b, this.a));
    }
}
