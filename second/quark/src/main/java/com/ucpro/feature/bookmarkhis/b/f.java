package com.ucpro.feature.bookmarkhis.b;

import android.webkit.ValueCallback;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;

/* compiled from: ProGuard */
final class f implements ValueCallback<m> {
    final /* synthetic */ g a;

    f(g gVar) {
        this.a = gVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        m mVar = (m) obj;
        if (mVar != null) {
            this.a.f.a(mVar.e);
        }
    }
}
