package com.ucpro.feature.video.cache.e;

import com.ucpro.feature.video.cache.a.a;
import com.ucpro.feature.video.cache.db.bean.b;
import com.ucpro.feature.video.cache.e.a.j;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public final class i {
    b a;
    j b;

    public i(b bVar) {
        this.a = bVar;
        c.a(this.a);
        c.a(this.a.h);
        a.b(this.a.h);
    }

    final void a(boolean z) {
        new Thread(new a(this, z)).start();
    }
}
