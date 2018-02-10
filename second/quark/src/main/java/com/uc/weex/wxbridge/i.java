package com.uc.weex.wxbridge;

import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class i implements ValueCallback<String> {
    final /* synthetic */ j a;

    i(j jVar) {
        this.a = jVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        this.a.b.initFrameworkFinish();
    }
}
