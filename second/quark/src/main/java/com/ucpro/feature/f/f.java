package com.ucpro.feature.f;

import android.webkit.ValueCallback;
import com.uc.base.a.a.a.d.b;
import com.ucpro.base.a.j;

/* compiled from: ProGuard */
final class f implements ValueCallback<String> {
    final /* synthetic */ b a;
    final /* synthetic */ j b;

    f(j jVar, b bVar) {
        this.b = jVar;
        this.a = bVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        if (20000 == this.a.a()) {
            e.a(this.b.a, false);
        } else if (20003 == this.a.a()) {
            e.a(this.b.a, true);
        }
        com.ucpro.base.a.f.a().a(j.v, 0, null);
    }
}
