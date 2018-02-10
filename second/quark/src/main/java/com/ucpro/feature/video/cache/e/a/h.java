package com.ucpro.feature.video.cache.e.a;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.ucweb.common.util.c;
import com.ucweb.common.util.e;

/* compiled from: ProGuard */
public final class h implements c {
    c a;
    private e b;

    public h(@NonNull c cVar, Looper looper) {
        c.a((Object) cVar);
        this.a = cVar;
        this.b = new e("M3U8FileModelChangeNotifer", looper);
    }

    public final void w_() {
        this.b.post(new f(this));
    }
}
