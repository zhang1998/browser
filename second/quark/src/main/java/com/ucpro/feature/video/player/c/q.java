package com.ucpro.feature.video.player.c;

import com.uc.quark.s;
import com.ucweb.common.util.n.a;
import java.io.File;

/* compiled from: ProGuard */
final class q implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ File b;
    final /* synthetic */ s c;
    final /* synthetic */ k d;

    q(k kVar, String str, File file, s sVar) {
        this.d = kVar;
        this.a = str;
        this.b = file;
        this.c = sVar;
    }

    public final void run() {
        try {
            if (a.a(this.a) || com.ucweb.common.util.k.a.a(this.b, this.a, 5000)) {
                this.d.a.c();
                return;
            }
            com.ucweb.common.util.k.a.b(this.b);
            this.d.b.post(new b(this));
        } catch (Exception e) {
        }
    }
}
