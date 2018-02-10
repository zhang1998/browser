package com.ucpro.feature.webwindow;

import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.contextmenu.d;

/* compiled from: ProGuard */
final class o implements ValueCallback<Boolean> {
    final /* synthetic */ d a;
    final /* synthetic */ y b;

    o(y yVar, d dVar) {
        this.b = yVar;
        this.a = dVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        if (((Boolean) obj).booleanValue()) {
            this.a.a(a.d((int) R.string.context_menu_open_pic_viewer), 20005);
            this.a.notifyDataSetChanged();
        }
    }
}
