package com.ucpro.feature.video.cache.b;

import com.ucpro.feature.video.cache.db.bean.b;

/* compiled from: ProGuard */
final class a extends com.ucweb.common.util.h.a {
    final /* synthetic */ d a;

    private a(d dVar) {
        this.a = dVar;
    }

    public final void run() {
        com.ucpro.feature.video.d.a.b();
        for (b bVar : com.ucpro.feature.video.cache.db.b.b().c()) {
            if ("ts_downloading".equals(bVar.f)) {
                com.ucpro.feature.video.d.a.b();
                bVar.f = "ts_paused";
                com.ucpro.feature.video.cache.db.b.b().b(bVar);
            }
        }
    }
}
