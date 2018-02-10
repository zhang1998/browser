package com.ucpro.feature.setting.view.d;

import android.text.TextUtils;
import android.webkit.ValueCallback;

/* compiled from: ProGuard */
final class v implements ValueCallback<String> {
    final /* synthetic */ f a;

    v(f fVar) {
        this.a = fVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        String str = (String) obj;
        if (!TextUtils.isEmpty(str)) {
            this.a.a.g = str;
            this.a.a.a(str);
        }
    }
}
