package com.ucpro.feature.webwindow;

import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.ucweb.common.util.n.a;

/* compiled from: ProGuard */
final class as implements ValueCallback<String> {
    final /* synthetic */ bj a;

    as(bj bjVar) {
        this.a = bjVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        String str = (String) obj;
        if (a.b(str)) {
            this.a.d.b = str;
            if (this.a.c.getCount() >= 2) {
                this.a.c.a(com.ucpro.ui.c.a.d((int) R.string.qrcode_from_image));
            } else {
                this.a.c.a(com.ucpro.ui.c.a.d((int) R.string.qrcode_from_image), 20100);
            }
            this.a.c.notifyDataSetChanged();
        }
    }
}
