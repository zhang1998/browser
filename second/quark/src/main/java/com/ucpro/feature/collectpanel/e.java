package com.ucpro.feature.collectpanel;

import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class e implements ValueCallback<Boolean> {
    final /* synthetic */ i a;

    e(i iVar) {
        this.a = iVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            this.a.a();
            this.a.h = 0;
            this.a.g.c = 0;
            return;
        }
        com.ucpro.ui.b.e.a().a(a.d((int) R.string.bookmark_add_folder_fail), 0);
    }
}
