package com.uc.quark.a;

import com.uc.quark.filedownloader.message.LargeMessageSnapshot;
import com.uc.quark.filedownloader.message.MessageSnapshot;
import com.uc.quark.k;

/* compiled from: ProGuard */
final class n implements Runnable {
    final /* synthetic */ b a;

    n(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        MessageSnapshot largeMessageSnapshot = new LargeMessageSnapshot(this.a.c.a(), (byte) -3, false);
        largeMessageSnapshot.f = new g(this.a.c);
        k.b().c().a(largeMessageSnapshot);
    }
}
