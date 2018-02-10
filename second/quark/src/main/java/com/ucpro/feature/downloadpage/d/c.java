package com.ucpro.feature.downloadpage.d;

import com.ucpro.feature.video.cache.db.bean.b;
import com.ucpro.ui.g.m;
import com.ucweb.common.util.h.a;

/* compiled from: ProGuard */
final class c extends a {
    final /* synthetic */ b a;
    final /* synthetic */ t b;

    c(t tVar, b bVar) {
        this.b = tVar;
        this.a = bVar;
    }

    public final void run() {
        this.b.f = new m(this.b.c);
        this.b.f.a("非wifi网络, 请确认是否继续");
        this.b.f.a(1);
        this.b.f.a("继续", "取消");
        this.b.f.a(new g(this));
        this.b.f.show();
    }
}
