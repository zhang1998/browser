package com.ucpro.feature.video.player.c;

import com.uc.a.d.l;

/* compiled from: ProGuard */
final class a implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ byte[] b;
    final /* synthetic */ i c;

    a(i iVar, String str, byte[] bArr) {
        this.c = iVar;
        this.a = str;
        this.b = bArr;
    }

    public final void run() {
        l.a(this.a, this.b);
        this.c.k = new m();
    }
}
