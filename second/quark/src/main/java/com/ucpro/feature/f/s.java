package com.ucpro.feature.f;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.UCMobile.Apollo.Global;
import com.quark.browser.R;
import com.uc.apollo.impl.SettingsConst;
import com.uc.base.a.a.a.b;
import com.uc.base.a.a.a.e.n;
import com.uc.base.a.a.a.g;
import com.ucpro.ui.b.e;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class s implements n {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ e b;

    s(e eVar, ValueCallback valueCallback) {
        this.b = eVar;
        this.a = valueCallback;
    }

    public final void a() {
        ValueCallback valueCallback = this.a;
        b bVar = g.a;
        valueCallback.onReceiveValue(b.c());
        d.a(SettingsConst.FALSE);
    }

    public final void a(String str) {
        this.a.onReceiveValue(str);
        d.a(SettingsConst.TRUE);
    }

    public final void b() {
        e.a().a(a.d((int) R.string.account_invalid_st), 0);
        d.a(Global.APOLLO_SERIES);
    }

    public final void b(com.uc.base.a.a.a.d.b bVar) {
        new StringBuilder("refreshServiceTicket fail\njsContent: \n").append(bVar.c).append("\nDebugInfo: \n").append(bVar.d);
        if (!TextUtils.isEmpty(bVar.b())) {
            e.a().a(bVar.b(), 0);
        }
        d.a("3");
    }
}
