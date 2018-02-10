package com.ucpro.feature.downloadpage.d;

import com.uc.quark.x;
import com.ucpro.feature.video.cache.db.bean.b;
import com.ucpro.feature.video.cache.e.d;

/* compiled from: ProGuard */
final class a implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ v b;

    a(v vVar, b bVar) {
        this.b = vVar;
        this.a = bVar;
    }

    public final void run() {
        if (this.a.e == 1) {
            d.a();
            d.a(this.a.a.intValue());
            return;
        }
        x.a().d(this.a.a.intValue());
    }
}
