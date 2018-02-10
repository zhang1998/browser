package com.ucpro.feature.downloadpage.d;

import android.os.Looper;
import com.uc.quark.x;
import com.ucpro.feature.video.cache.db.bean.b;
import com.ucpro.feature.video.cache.e.d;
import com.ucpro.feature.video.d.a;
import com.ucweb.common.util.c;
import java.util.List;

/* compiled from: ProGuard */
final class o implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ v b;

    o(v vVar, b bVar) {
        this.b = vVar;
        this.a = bVar;
    }

    public final void run() {
        boolean z = true;
        if (this.a.e == 1) {
            d a = d.a();
            long longValue = this.a.a.longValue();
            if (Looper.getMainLooper() == Looper.myLooper()) {
                z = false;
            }
            c.b(z);
            a.b();
            b a2 = com.ucpro.feature.video.cache.db.b.b().a(longValue);
            if (a2 == null) {
                a.b();
                return;
            }
            a.b();
            List c = com.ucpro.feature.video.cache.db.b.b().c(a2.a.longValue());
            if (c.size() == 0) {
                b a3 = com.ucpro.feature.video.cache.db.a.a.a(a2.b, a2.c, a2.h, a2.d, a2.a.longValue());
                com.ucpro.feature.video.cache.db.b.b().b(a3);
                a.a(a3);
                return;
            }
            d.a(a2, c);
            return;
        }
        x.a().a(this.a.a.intValue(), false);
    }
}
