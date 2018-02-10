package com.ucpro.feature.webwindow.f.a.a;

import android.webkit.ValueCallback;
import com.uc.base.jssdk.i;
import com.uc.base.jssdk.q;
import com.uc.base.jssdk.t;

/* compiled from: ProGuard */
final class d implements ValueCallback<Boolean> {
    final /* synthetic */ t a;
    final /* synthetic */ g b;

    d(g gVar, t tVar) {
        this.b = gVar;
        this.a = tVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            if (this.a != null) {
                this.a.a(new q(i.a, "{result:'success'}"));
            }
        } else if (this.a != null) {
            this.a.a(new q(i.a, "{result:'fail'}"));
        }
    }
}
