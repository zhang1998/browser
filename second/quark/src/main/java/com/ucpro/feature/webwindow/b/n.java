package com.ucpro.feature.webwindow.b;

import java.io.File;

/* compiled from: ProGuard */
final class n implements Runnable {
    final /* synthetic */ File a;
    final /* synthetic */ s b;

    n(s sVar, File file) {
        this.b = sVar;
        this.a = file;
    }

    public final void run() {
        this.b.d.a(w.b(this.a));
    }
}
