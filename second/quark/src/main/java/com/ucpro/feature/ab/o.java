package com.ucpro.feature.ab;

import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.ucpro.ui.b.e;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.n.a;

/* compiled from: ProGuard */
final class o implements ValueCallback<String> {
    final /* synthetic */ e a;

    o(e eVar) {
        this.a = eVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        String str = (String) obj;
        if (a.b(str)) {
            this.a.a(true);
            m.a(2, new i(this, str), 150);
            return;
        }
        e.a().a(com.ucpro.ui.c.a.d((int) R.string.qrcode_decode_error), 1);
    }
}
