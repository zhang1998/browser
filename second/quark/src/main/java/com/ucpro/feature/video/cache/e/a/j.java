package com.ucpro.feature.video.cache.e.a;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.ucweb.common.util.c;
import com.ucweb.common.util.e;

/* compiled from: ProGuard */
public final class j implements g {
    g a;
    private e b = new e("M3U8MetaDataDownloadCbNotifer", Looper.getMainLooper());

    public j(@NonNull g gVar) {
        c.a((Object) gVar);
        this.a = gVar;
    }

    public final void a(String str) {
        this.b.post(new e(this, str));
    }

    public final void b(String str) {
        this.b.post(new d(this, str));
    }
}
