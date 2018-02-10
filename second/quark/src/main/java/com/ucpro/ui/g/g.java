package com.ucpro.ui.g;

import android.content.Context;
import android.view.View;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class g extends o {
    public View a = null;
    private ATTextView b = null;
    private ATTextView v = null;

    public g(Context context) {
        super(context);
        View inflate = getLayoutInflater().inflate(R.layout.checkbox_dialog, null);
        this.b = (ATTextView) inflate.findViewById(R.id.dialog_title);
        this.v = (ATTextView) inflate.findViewById(R.id.checkbox_text);
        this.a = inflate.findViewById(R.id.checkbox_btn);
        inflate.setOnClickListener(new t(this));
        h().a(inflate);
        h().b();
    }

    public final void a(CharSequence charSequence) {
        this.b.setText(charSequence);
    }

    public final void b(CharSequence charSequence) {
        this.v.setText(charSequence);
    }

    public final void a(String str, String str2) {
        i i = i();
        if (i != null) {
            i.setText(str);
        }
        i = j();
        if (i != null) {
            i.setText(str2);
        }
    }

    public final void a() {
        super.a();
        this.b.setTextColor(a.c("default_maintext_gray"));
        this.v.setTextColor(a.c("dialog_content_color"));
        this.a.setBackgroundDrawable(a.a("dialog_checkbox_selector.xml"));
    }
}
