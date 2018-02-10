package com.ucpro.feature.downloadpage.d;

import android.os.Handler;
import android.os.Looper;
import com.ucpro.feature.video.cache.db.b;
import com.ucpro.feature.video.d.a;

/* compiled from: ProGuard */
final class j implements Runnable {
    final /* synthetic */ v a;

    j(v vVar) {
        this.a = vVar;
    }

    public final void run() {
        this.a.a = b.b().c();
        a.c();
        if (this.a.d) {
            for (com.ucpro.feature.video.cache.db.bean.b bVar : this.a.a) {
                if ("ts_downloading".equals(bVar.f)) {
                    bVar.f = "ts_paused";
                }
            }
        }
        new Handler(Looper.getMainLooper()).post(this.a.b);
    }
}
