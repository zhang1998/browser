package com.ucpro.feature.bookmarkhis.bookmark;

import android.webkit.ValueCallback;
import com.uc.base.a.a.a.h.a;
import com.ucpro.feature.f.e;

/* compiled from: ProGuard */
final class ae implements ValueCallback<a> {
    final /* synthetic */ n a;

    ae(n nVar) {
        this.a = nVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        a aVar = (a) obj;
        if (aVar != null) {
            this.a.a.setLoginName(e.a(aVar));
        }
    }
}
