package com.ucpro.a;

import com.uc.a.d.l;

/* compiled from: ProGuard */
final class af implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ byte[] b;
    final /* synthetic */ am c;

    af(am amVar, String str, byte[] bArr) {
        this.c = amVar;
        this.a = str;
        this.b = bArr;
    }

    public final void run() {
        l.a(this.a, this.b);
    }
}
