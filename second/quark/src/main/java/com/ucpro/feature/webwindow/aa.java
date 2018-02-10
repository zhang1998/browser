package com.ucpro.feature.webwindow;

import android.text.TextUtils;
import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class aa implements ValueCallback<String> {
    final /* synthetic */ aj a;
    final /* synthetic */ ax b;

    aa(ax axVar, aj ajVar) {
        this.b = axVar;
        this.a = ajVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        String str = (String) obj;
        if (!TextUtils.isEmpty(str)) {
            this.a.o = str;
        }
    }
}
