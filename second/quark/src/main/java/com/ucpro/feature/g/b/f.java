package com.ucpro.feature.g.b;

import android.webkit.ValueCallback;
import com.uc.base.a.a.a.h.a;
import com.ucpro.feature.f.e;

/* compiled from: ProGuard */
final class f implements ValueCallback<a> {
    final /* synthetic */ b a;

    f(b bVar) {
        this.a = bVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        this.a.a.a.b(e.a((a) obj));
    }
}
