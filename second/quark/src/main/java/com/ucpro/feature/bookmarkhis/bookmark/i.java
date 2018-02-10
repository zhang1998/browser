package com.ucpro.feature.bookmarkhis.bookmark;

import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.ucpro.ui.b.e;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class i implements ValueCallback<Boolean> {
    final /* synthetic */ ai a;

    i(ai aiVar) {
        this.a = aiVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            this.a.j();
            return;
        }
        e.a().a(a.d((int) R.string.bookmark_add_folder_fail), 1);
    }
}
