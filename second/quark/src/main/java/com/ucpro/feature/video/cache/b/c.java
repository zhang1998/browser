package com.ucpro.feature.video.cache.b;

import com.uc.quark.x;
import com.ucpro.feature.video.cache.db.bean.b;
import com.ucweb.common.util.h.a;
import java.io.File;

/* compiled from: ProGuard */
final class c extends a {
    final /* synthetic */ d a;

    private c(d dVar) {
        this.a = dVar;
    }

    public final void run() {
        com.ucpro.feature.video.d.a.b();
        for (b bVar : com.ucpro.feature.video.cache.db.b.b().c()) {
            if ("ts_downloading".equals(bVar.f)) {
                com.ucpro.feature.video.d.a.b();
                for (com.ucpro.feature.video.cache.db.bean.a aVar : com.ucpro.feature.video.cache.db.b.b().c(bVar.a.longValue())) {
                    if (!new File(aVar.d).exists()) {
                        x.a().a(aVar.a.intValue(), false);
                        new StringBuilder("长期无响应保活 startTask id=").append(aVar.a.intValue());
                        com.ucpro.feature.video.d.a.b();
                    }
                }
            } else {
                com.ucpro.feature.video.d.a.b();
            }
        }
    }
}
