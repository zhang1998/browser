package com.ucpro.services.download;

import com.uc.quark.filedownloader.e.j;
import com.uc.quark.x;
import com.ucpro.c.b;
import com.ucpro.services.download.b.d;

/* compiled from: ProGuard */
public final class i implements Runnable {
    final /* synthetic */ Runnable a;

    public i(Runnable runnable) {
        this.a = runnable;
    }

    public final void run() {
        this.a.run();
        x.a(new k());
        x.a(new f());
        x.a(new d());
        if (b.b()) {
            j.a = true;
        }
    }
}
