package com.ucpro.feature.setting.b.f;

import android.util.Log;
import com.ucpro.base.a.g;
import com.ucpro.feature.setting.b.b.a.i;
import com.ucpro.feature.video.cache.a.a;
import com.ucpro.feature.video.cache.d.u;
import com.ucpro.feature.video.cache.db.bean.b;
import com.ucpro.ui.b.e;

/* compiled from: ProGuard */
final class ap implements i {
    ap() {
    }

    public final void a() {
        b a = com.ucpro.feature.video.cache.db.b.b().a("http://cache.m.iqiyi.com/dc/dt/mobile/20161012/e4/fc/9b659ed96bd0a3be03d21e7cda66fb53.m3u8?qypid=550346000_22&qd_src=5be6a2fdfe4f4a1a8c7b08ee46a18887&qd_tm=1476254629000&qd_ip=123.125.122.205&qd_sc=3e613381a381cd618a8c65fd52d64eb7&mbd=f0f6c3ee5709615310c0f053dc9c65f2_5.9_1");
        if (a != null) {
            u.a();
            Object a2 = a.a(u.b(), "m3u8", a.b(u.b(), a.b));
            Log.e("hjw-m3u8", "播放:mUrl=" + a2);
            e.a().a("播放:mUrl=" + a2, 0);
            g.a().a(com.ucpro.base.a.e.bd, a2);
        }
    }
}
