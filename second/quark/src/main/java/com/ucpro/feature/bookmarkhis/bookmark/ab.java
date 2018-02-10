package com.ucpro.feature.bookmarkhis.bookmark;

import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.ucpro.base.a.g;
import com.ucpro.ui.b.e;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class ab implements ValueCallback<Boolean> {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ n c;

    ab(n nVar, String str, String str2) {
        this.c = nVar;
        this.a = str;
        this.b = str2;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            e.a().a(a.d((int) R.string.discover_bookmark_nav_full_tips), 1);
            return;
        }
        g.a().b(com.ucpro.base.a.e.b, new Object[]{this.a, this.b, null, null});
        e.a().a(a.d((int) R.string.discover_bookmark_nav_add_success), 1);
    }
}
