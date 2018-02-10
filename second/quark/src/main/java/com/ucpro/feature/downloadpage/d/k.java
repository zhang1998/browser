package com.ucpro.feature.downloadpage.d;

import com.ucpro.feature.video.cache.db.bean.b;
import com.ucweb.common.util.h.a;
import com.ucweb.common.util.i.c;

/* compiled from: ProGuard */
final class k extends a {
    final /* synthetic */ b a;
    final /* synthetic */ t b;

    k(t tVar, b bVar) {
        this.b = tVar;
        this.a = bVar;
    }

    public final void run() {
        t tVar = this.b;
        b bVar = this.a;
        if ("ts_successed".equals(bVar.f)) {
            com.ucpro.feature.video.d.a.a();
            tVar.e.c(bVar);
        } else if ("ts_downloading".equals(bVar.f)) {
            com.ucpro.feature.video.d.a.a();
            tVar.e.d(bVar);
        } else if ("meata_data_failed".equals(bVar.f)) {
            com.ucpro.feature.video.d.a.a();
            if (c.b()) {
                tVar.e.e(bVar);
            } else {
                tVar.a(bVar);
            }
        } else if ("ts_paused".equals(bVar.f)) {
            com.ucpro.feature.video.d.a.a();
            if (c.b()) {
                tVar.e.e(bVar);
            } else {
                tVar.a(bVar);
            }
        } else if ("ts_failed".equals(bVar.f)) {
            com.ucpro.feature.video.d.a.a();
            if (c.b()) {
                tVar.e.e(bVar);
            } else {
                tVar.a(bVar);
            }
        } else if ("init".equals(bVar.f)) {
            com.ucpro.feature.video.d.a.a();
            if (c.b()) {
                tVar.e.e(bVar);
            } else {
                tVar.a(bVar);
            }
        }
    }
}
