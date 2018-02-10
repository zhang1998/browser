package com.ucpro.feature.video.cache.e;

import android.util.Log;
import com.quark.browser.R;
import com.ucpro.feature.video.cache.db.b;
import com.ucpro.ui.b.e;
import com.ucweb.common.util.h.a;

/* compiled from: ProGuard */
final class h extends a {
    final /* synthetic */ String a;
    final /* synthetic */ g b;

    h(g gVar, String str) {
        this.b = gVar;
        this.a = str;
    }

    public final void run() {
        Log.e("hjw-m3u8", "onFail:" + this.a);
        com.ucpro.feature.video.d.a.b();
        this.b.a.f = "meata_data_failed";
        this.b.a.g = this.a;
        b.b().b(this.b.a);
        e.a().a(com.ucpro.ui.c.a.d((int) R.string.video_download_unable_create_task), 0);
    }
}
