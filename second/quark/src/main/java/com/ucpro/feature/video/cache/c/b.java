package com.ucpro.feature.video.cache.c;

import com.uc.a.d.l;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ byte[] b;
    final /* synthetic */ a c;

    b(a aVar, String str, byte[] bArr) {
        this.c = aVar;
        this.a = str;
        this.b = bArr;
    }

    public final void run() {
        l.a(this.a, this.b);
    }
}
