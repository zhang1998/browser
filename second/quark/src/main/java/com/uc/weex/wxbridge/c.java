package com.uc.weex.wxbridge;

import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class c implements ValueCallback<String> {
    final /* synthetic */ d a;

    c(d dVar) {
        this.a = dVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        this.a.b.initFrameworkFinish();
    }
}
