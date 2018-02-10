package com.ucpro.feature.setting.view.d;

import android.text.TextUtils;
import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class g implements ValueCallback<String> {
    final /* synthetic */ c a;

    g(c cVar) {
        this.a = cVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        String str = (String) obj;
        if (!TextUtils.isEmpty(str)) {
            this.a.a.g = str;
            this.a.a.a(str);
        }
    }
}
