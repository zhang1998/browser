package com.ucpro.feature.webwindow;

import android.webkit.ValueCallback;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;

/* compiled from: ProGuard */
final class u implements ValueCallback<String> {
    final /* synthetic */ y a;

    u(y yVar) {
        this.a = yVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        g.a().a(e.cZ, new String[]{(String) obj, this.a.a.getUrl()});
    }
}
