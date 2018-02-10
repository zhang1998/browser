package com.ucpro.feature.setting.d;

import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class s implements ValueCallback<Boolean> {
    final /* synthetic */ k a;

    s(k kVar) {
        this.a = kVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        this.a.r = ((Boolean) obj).booleanValue();
    }
}
