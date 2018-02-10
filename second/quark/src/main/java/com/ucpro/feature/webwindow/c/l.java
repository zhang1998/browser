package com.ucpro.feature.webwindow.c;

import android.content.Context;
import com.quark.browser.R;
import com.uc.webview.export.JsResult;
import com.ucpro.ui.c.a;
import com.ucpro.ui.g.i;
import com.ucpro.ui.g.x;

/* compiled from: ProGuard */
public final class l {
    public x a = new x(this.c);
    JsResult b;
    private Context c;
    private String d;

    public l(Context context, String str, JsResult jsResult) {
        this.c = context;
        this.d = str;
        this.b = jsResult;
        this.a.a(3);
        x xVar = this.a;
        xVar.b.setText(a.d((int) R.string.js_dialog_title));
        xVar = this.a;
        xVar.v.setText(this.d);
        xVar = this.a;
        CharSequence d = a.d((int) R.string.js_dialog_alert_button);
        i iVar = (i) xVar.findViewById(x.a);
        if (iVar != null) {
            iVar.setText(d);
        }
        this.a.a(new i(this));
        this.a.a(new d(this));
    }
}
