package com.ucpro.feature.setting.b.f;

import android.util.Log;
import com.ucpro.base.a.g;
import com.ucpro.feature.setting.b.b.a.i;
import com.ucpro.feature.video.cache.a.a;
import com.ucpro.feature.video.cache.d.u;
import com.ucpro.feature.video.cache.db.bean.b;
import com.ucpro.ui.b.e;

/* compiled from: ProGuard */
final class cd implements i {
    cd() {
    }

    public final void a() {
        b a = com.ucpro.feature.video.cache.db.b.b().a("http://hot.vrs.sohu.com/ipad3268171_4687672398251_6479492.m3u8?plat=17&ca=3&pg=1&pt=5&sver=5.0.2&cv=5.0.2&qd=282&prod=app&uid=1476351266165&vid=3268171&cateCode=101101");
        if (a != null) {
            u.a();
            Object a2 = a.a(u.b(), "m3u8", a.b(u.b(), a.b));
            Log.e("hjw-m3u8", "播放:mUrl=" + a2);
            e.a().a("播放:mUrl=" + a2, 0);
            g.a().a(com.ucpro.base.a.e.bd, a2);
        }
    }
}
