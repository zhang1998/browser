package com.ucpro.feature.l.a;

import android.view.View;
import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.ucpro.base.a.g;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class e implements ValueCallback<Boolean> {
    final /* synthetic */ View a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ j d;

    e(j jVar, View view, String str, String str2) {
        this.d = jVar;
        this.a = view;
        this.b = str;
        this.c = str2;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        if (!((Boolean) obj).booleanValue()) {
            this.a.setTag(Boolean.valueOf(true));
            this.a.animate().rotation(135.0f).alpha(0.5f);
            g.a().b(com.ucpro.base.a.e.b, new Object[]{this.b, this.c, null, null});
            com.ucpro.ui.b.e.a().a(a.d((int) R.string.discover_bookmark_nav_add_success), 1);
        }
    }
}
