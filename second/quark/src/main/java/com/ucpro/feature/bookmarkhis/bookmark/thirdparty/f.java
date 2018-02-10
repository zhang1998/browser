package com.ucpro.feature.bookmarkhis.bookmark.thirdparty;

import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.ucpro.ui.b.e;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class f implements ValueCallback<Boolean> {
    final /* synthetic */ j a;

    f(j jVar) {
        this.a = jVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            e.a().a(a.d((int) R.string.edit_success), 0);
        }
    }
}
