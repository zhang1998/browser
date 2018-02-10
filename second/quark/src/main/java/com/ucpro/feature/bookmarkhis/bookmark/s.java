package com.ucpro.feature.bookmarkhis.bookmark;

import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class s implements ValueCallback<Boolean> {
    final /* synthetic */ ai a;

    s(ai aiVar) {
        this.a = aiVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        Boolean bool = (Boolean) obj;
        if (bool.booleanValue()) {
            this.a.j();
        }
        ai.d(bool.booleanValue());
    }
}
