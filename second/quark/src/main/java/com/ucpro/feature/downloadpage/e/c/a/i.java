package com.ucpro.feature.downloadpage.e.c.a;

import com.ucpro.c.b;
import com.ucweb.common.util.k.a;
import com.ucweb.common.util.k.c;
import java.io.File;

/* compiled from: ProGuard */
final class i implements Runnable {
    final /* synthetic */ e a;

    i(e eVar) {
        this.a = eVar;
    }

    public final void run() {
        c i = a.i(new File(com.ucpro.model.a.a.a.a("setting_download_store_path", com.ucpro.c.c.c().getPath())).getPath());
        if (b.b()) {
            new StringBuilder("disk info ").append(i.b).append(" / ").append(i.a);
        }
        this.a.f = i.b;
        this.a.g = i.a;
    }
}
