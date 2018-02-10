package com.ucpro.feature.video.player.c;

import com.ucpro.model.a;
import com.ucweb.common.util.i.c;

/* compiled from: ProGuard */
final class f implements Runnable {
    final /* synthetic */ i a;

    f(i iVar) {
        this.a = iVar;
    }

    public final void run() {
        int e = a.e("377835DDA6DA37322A5D7E55703E9A23");
        if (this.a.h && !this.a.g() && c.b() && e < 3) {
            this.a.a(true);
            a.b("377835DDA6DA37322A5D7E55703E9A23", e + 1);
            this.a.a = false;
        }
    }
}
