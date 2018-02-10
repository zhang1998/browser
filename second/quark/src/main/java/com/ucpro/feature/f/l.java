package com.ucpro.feature.f;

import android.webkit.ValueCallback;
import com.uc.base.a.a.a.d.b;
import com.ucpro.base.a.f;
import com.ucpro.base.a.j;

/* compiled from: ProGuard */
final class l implements ValueCallback<String> {
    final /* synthetic */ b a;
    final /* synthetic */ c b;

    l(c cVar, b bVar) {
        this.b = cVar;
        this.a = bVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        if (20000 == this.a.a()) {
            e.a(this.b.a, false);
        } else if (20003 == this.a.a()) {
            e.a(this.b.a, true);
        }
        f.a().a(j.v, 0, null);
    }
}
