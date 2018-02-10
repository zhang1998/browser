package com.ucpro.ui.g;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class j extends o {
    private String a;
    private String b;

    public j(Context context, String str, String str2) {
        super(context);
        if (TextUtils.isEmpty(str)) {
            str = a.d((int) R.string.js_dialog_prompt_default_message);
        }
        this.a = str;
        this.b = str2;
        int c = a.c((int) R.dimen.common_dialog_margin_left);
        int c2 = a.c((int) R.dimen.common_dialog_margin_top);
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.setMargins(c, 0, c, 0);
        View aTTextView = new ATTextView(getContext());
        aTTextView.setText(this.a);
        aTTextView.setTextSize(0, a.a((int) R.dimen.common_dialog_text_size));
        aTTextView.setTextColor(a.c("default_maintext_gray"));
        aTTextView.setPadding(0, c2, 0, 0);
        h().a(aTTextView, layoutParams);
        h().a(g, this.b);
        h().b();
    }
}
