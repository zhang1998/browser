package com.ucpro.feature.bookmarkhis.bookmark;

import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.ucpro.ui.b.e;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class ag implements ValueCallback<Boolean> {
    final /* synthetic */ o a;

    ag(o oVar) {
        this.a = oVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            this.a.a();
            this.a.f = 0;
            return;
        }
        e.a().a(a.d((int) R.string.bookmark_add_folder_fail), 0);
    }
}
