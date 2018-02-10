package com.ucpro.feature.webwindow.c;

import android.content.Context;
import com.quark.browser.R;
import com.uc.webview.export.JsResult;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class k {
    public com.ucpro.ui.g.k a = new com.ucpro.ui.g.k(this.c);
    JsResult b;
    private Context c;
    private String d;

    public k(Context context, String str, JsResult jsResult) {
        this.c = context;
        this.d = str;
        this.b = jsResult;
        this.a.a(3);
        this.a.a(a.d((int) R.string.js_dialog_title));
        this.a.b(this.d);
        this.a.a(a.d((int) R.string.js_dialog_confirm_yes_button), a.d((int) R.string.js_dialog_confirm_no_button));
        this.a.a(new j(this));
        this.a.a(new e(this));
    }
}
