package com.ucpro.services.download.b;

import com.uc.quark.filedownloader.aa;

/* compiled from: ProGuard */
final class a implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ aa b;
    final /* synthetic */ d c;

    a(d dVar, int i, aa aaVar) {
        this.c = dVar;
        this.a = i;
        this.b = aaVar;
    }

    public final void run() {
        d.a(this.c, this.a, this.b);
    }
}
