package com.ucpro.feature.bookmarkhis.bookmark;

import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class j implements ValueCallback<Boolean> {
    final /* synthetic */ ai a;

    j(ai aiVar) {
        this.a = aiVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            this.a.j();
        }
    }
}
