package com.ucpro.feature.l.b;

import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.ucpro.ui.b.e;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class f implements ValueCallback<Boolean> {
    final /* synthetic */ d a;
    final /* synthetic */ m b;
    final /* synthetic */ j c;

    f(j jVar, d dVar, m mVar) {
        this.c = jVar;
        this.a = dVar;
        this.b = mVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            this.a.a(1);
            this.b.f = true;
            e.a().a(a.d((int) R.string.discover_bookmark_nav_add_success), 0);
            return;
        }
        e.a().a(a.d((int) R.string.navigation_max_num_tip), 0);
    }
}
