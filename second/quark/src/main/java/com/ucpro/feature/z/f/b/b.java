package com.ucpro.feature.z.f.b;

import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class b implements ValueCallback<o> {
    final /* synthetic */ k a;

    b(k kVar) {
        this.a = kVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        o oVar = (o) obj;
        k.a(this.a, oVar.a, oVar.b, oVar.c, oVar.d);
    }
}
