package com.ucpro.feature.bookmarkhis.bookmark.thirdparty;

import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.ucpro.ui.b.e;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class g implements ValueCallback<Boolean> {
    final /* synthetic */ j a;

    g(j jVar) {
        this.a = jVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            this.a.a();
            this.a.e = 0;
            this.a.d.c = 0;
            return;
        }
        e.a().a(a.d((int) R.string.bookmark_add_folder_fail), 0);
    }
}
