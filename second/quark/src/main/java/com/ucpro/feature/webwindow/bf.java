package com.ucpro.feature.webwindow;

import android.webkit.ValueCallback;
import com.ucpro.business.stat.m;
import java.util.HashMap;

/* compiled from: ProGuard */
final class bf implements ValueCallback<Boolean> {
    final /* synthetic */ ab a;

    bf(ab abVar) {
        this.a = abVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        Boolean bool = (Boolean) obj;
        if (bool.booleanValue()) {
            this.a.p.f();
            this.a.F = true;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("suc", String.valueOf(bool));
        m.a("webview", "webview_pull_refresh", hashMap);
    }
}
