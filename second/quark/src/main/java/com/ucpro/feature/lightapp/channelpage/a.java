package com.ucpro.feature.lightapp.channelpage;

import android.webkit.ValueCallback;
import com.taobao.weex.bridge.c;
import com.ucpro.base.weex.l;

/* compiled from: ProGuard */
final class a implements ValueCallback<Boolean> {
    final /* synthetic */ c a;
    final /* synthetic */ c b;

    a(c cVar, c cVar2) {
        this.b = cVar;
        this.a = cVar2;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            l.a(this.a, null, true);
        } else {
            l.a(this.a, null, false);
        }
    }
}
