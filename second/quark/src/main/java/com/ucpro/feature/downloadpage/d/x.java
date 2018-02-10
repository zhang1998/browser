package com.ucpro.feature.downloadpage.d;

import android.text.TextUtils;
import android.util.Log;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.feature.video.cache.a.a;
import com.ucpro.feature.video.cache.d.u;
import com.ucpro.feature.video.cache.db.bean.b;

/* compiled from: ProGuard */
final class x implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ v b;

    x(v vVar, b bVar) {
        this.b = vVar;
        this.a = bVar;
    }

    public final void run() {
        Object a = com.ucpro.feature.video.player.a.b.a();
        a.a(19, this.a.c);
        a.a(20, "");
        if (this.a.e == 1) {
            u.a();
            Object b = a.b(u.b(), this.a.b);
            if (!TextUtils.isEmpty(b)) {
                String a2 = a.a(u.b(), "m3u8", b);
                if (com.ucpro.c.b.b()) {
                    Log.e("hjw-m3u8", "播放:url=" + a2);
                }
                a.a(18, a2);
                com.ucpro.feature.video.cache.g.a.c(com.ucpro.feature.video.cache.g.a.a);
                g.a().a(e.bp, a);
                return;
            }
            return;
        }
        a.a(18, this.a.h);
        com.ucpro.feature.video.cache.g.a.c(com.ucpro.feature.video.cache.g.a.b);
        g.a().a(e.bp, a);
    }
}
