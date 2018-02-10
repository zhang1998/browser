package com.ucpro.feature.video.cache.e.a;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.ucweb.common.util.c;
import com.ucweb.common.util.e;

/* compiled from: ProGuard */
public final class i implements a {
    a a;
    private e b = new e("M3U8TsBatchDownloadCbNotifer", Looper.getMainLooper());

    public i(@NonNull a aVar) {
        c.a((Object) aVar);
        this.a = aVar;
    }

    public final void a(int i, String str) {
        this.b.post(new b(this, i, str));
    }
}
