package com.ucpro.ui.g;

import android.content.Context;
import android.view.View;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;
import com.ucweb.common.util.p.b;

/* compiled from: ProGuard */
public final class k extends o {
    private ATTextView a = null;
    private ATTextView b = null;

    public k(Context context) {
        super(context);
        View inflate = getLayoutInflater().inflate(R.layout.common_two_text_dialog, null);
        this.a = (ATTextView) inflate.findViewById(R.id.bm_tv_title);
        this.b = (ATTextView) inflate.findViewById(R.id.bm_tv_content);
        h().a(inflate);
        h().b();
        a();
    }

    public final void a(CharSequence charSequence) {
        this.a.setText(charSequence);
    }

    public final void b(CharSequence charSequence) {
        this.b.setText(charSequence);
    }

    public final void a(String str, String str2) {
        i i = i();
        if (i != null) {
            i.setText(str);
            i.setTag(R.id.ui_auto, b.a);
        }
        i = j();
        if (i != null) {
            i.setText(str2);
            i.setTag(R.id.ui_auto, b.c);
        }
    }

    public final void a() {
        super.a();
        this.a.setTextColor(a.c("default_maintext_gray"));
        this.b.setTextColor(a.c("dialog_content_color"));
    }
}
