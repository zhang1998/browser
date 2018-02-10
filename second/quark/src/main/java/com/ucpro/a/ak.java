package com.ucpro.a;

import com.bumptech.glide.util.l;
import com.ucpro.c.c;
import com.ucweb.common.util.k.a;
import java.io.File;

/* compiled from: ProGuard */
final class ak implements Runnable {
    final /* synthetic */ am a;

    ak(am amVar) {
        this.a = amVar;
    }

    public final void run() {
        try {
            a.i(new File(c.f()));
        } catch (Exception e) {
        }
        com.bumptech.glide.c a = com.bumptech.glide.c.a(this.a.b);
        l.b();
        a.a.e.a().a();
    }
}
