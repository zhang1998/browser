package com.ucpro.feature.setting.b.f;

import com.ucpro.feature.setting.b.b.a.i;
import com.ucpro.feature.video.cache.db.b;
import com.ucpro.ui.b.e;
import java.util.List;

/* compiled from: ProGuard */
final class bm implements i {
    bm() {
    }

    public final void a() {
        b.b().a.deleteAll();
        b.b().b.deleteAll();
        List c = b.b().c();
        List loadAll = b.b().b.loadAll();
        if (com.ucpro.c.b.b()) {
            new StringBuilder("getAllM3u8TsSubTask size is:").append(loadAll.size());
        }
        e.a().a("当前共有数据list size:" + c.size() + "条\nsub list size:" + loadAll.size() + "条", 0);
    }
}
