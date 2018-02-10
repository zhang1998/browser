package com.ucpro.feature.collectpanel;

import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.ucpro.base.a.g;
import com.ucpro.ui.b.e;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class h implements ValueCallback<Boolean> {
    final /* synthetic */ i a;

    h(i iVar) {
        this.a = iVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        e.a().a(a.d((int) R.string.edit_success), 0);
        g.a().a(com.ucpro.base.a.e.aR);
    }
}
