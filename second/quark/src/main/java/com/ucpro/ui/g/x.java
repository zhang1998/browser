package com.ucpro.ui.g;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.quark.browser.R;
import com.ucpro.ui.widget.auto.theme.ATTextView;
import com.ucweb.common.util.a.a;

/* compiled from: ProGuard */
public final class x extends o {
    public static final int a = a.a();
    public ATTextView b = null;
    public ATTextView v = null;

    public x(Context context) {
        super(context);
        View inflate = getLayoutInflater().inflate(R.layout.common_two_text_dialog, null);
        this.b = (ATTextView) inflate.findViewById(R.id.bm_tv_title);
        this.v = (ATTextView) inflate.findViewById(R.id.bm_tv_content);
        h().a(inflate);
        h().a((CharSequence) "", a, new LayoutParams(-1, -2));
        a();
    }

    public final void a() {
        super.a();
        this.b.setTextColor(com.ucpro.ui.c.a.c("default_maintext_gray"));
        this.v.setTextColor(com.ucpro.ui.c.a.c("dialog_content_color"));
    }
}
