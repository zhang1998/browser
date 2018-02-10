package com.ucpro.feature.video.cache.e;

import android.util.Log;
import com.ucpro.feature.video.cache.db.b;
import com.ucweb.common.util.h.a;

/* compiled from: ProGuard */
final class f extends a {
    final /* synthetic */ String a;
    final /* synthetic */ g b;

    f(g gVar, String str) {
        this.b = gVar;
        this.a = str;
    }

    public final void run() {
        Log.e("hjw-m3u8", "index.m3u8下载:onSuccess:" + this.a);
        com.ucpro.feature.video.d.a.b();
        b.b().b(this.b.a);
        d.a(this.b.b, this.b.a);
    }
}
