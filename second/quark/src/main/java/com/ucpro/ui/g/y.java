package com.ucpro.ui.g;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.quark.browser.R;
import com.uc.webview.export.HttpAuthHandler;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class y extends o {
    private HttpAuthHandler a;
    private String b;
    private String v;

    public y(Context context, HttpAuthHandler httpAuthHandler, String str, String str2) {
        super(context);
        this.a = httpAuthHandler;
        this.b = str;
        this.v = str2;
        int c = a.c((int) R.dimen.common_dialog_margin_top);
        int c2 = a.c((int) R.dimen.common_dialog_margin_left);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.setMargins(c2, 0, c2, 0);
        CharSequence d = a.d((int) R.string.net_http_auth_title);
        View aTTextView = new ATTextView(getContext());
        aTTextView.setText(d);
        aTTextView.getPaint().setFakeBoldText(true);
        aTTextView.setTextSize(0, a.a((int) R.dimen.common_dialog_text_size));
        aTTextView.setTextColor(a.c("default_maintext_gray"));
        aTTextView.setPadding(0, c, 0, 0);
        h().a(aTTextView, layoutParams);
        LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        layoutParams2.setMargins(c2, 0, c2, 0);
        h().a(this.b + a.d((int) R.string.auth_request_tips), layoutParams2);
        h().a(e, a.d((int) R.string.net_http_auth_user));
        layoutParams2 = new LayoutParams(-1, -2);
        layoutParams2.setMargins(a.c((int) R.dimen.common_dialog_margin_left), 0, a.c((int) R.dimen.common_dialog_margin_left), a.c((int) R.dimen.common_dialog_margin_bottom));
        layoutParams2.gravity = 16;
        h().a(f, a.d((int) R.string.net_http_auth_pswd), layoutParams2);
        h().b();
    }
}
