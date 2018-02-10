package com.ucpro.feature.f;

import android.webkit.ValueCallback;
import com.uc.base.a.a.a.d.b;
import com.ucpro.base.a.f;
import com.ucpro.base.a.j;
import com.ucpro.business.stat.m;

/* compiled from: ProGuard */
final class k implements ValueCallback<String> {
    final /* synthetic */ b a;
    final /* synthetic */ p b;

    k(p pVar, b bVar) {
        this.b = pVar;
        this.a = bVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        if (20000 == this.a.a()) {
            e.a(this.b.a, false);
        } else if (20003 == this.a.a()) {
            e.a(this.b.a, true);
        }
        m.a("account", "sms_login_success", new String[0]);
        f.a().a(j.v, 0, null);
    }
}
