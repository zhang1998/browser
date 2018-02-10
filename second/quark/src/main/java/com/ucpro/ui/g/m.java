package com.ucpro.ui.g;

import android.content.Context;
import android.view.View;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class m extends o {
    private ATTextView a;

    public m(Context context) {
        this(context, false);
    }

    public m(Context context, boolean z) {
        super(context);
        this.a = null;
        View inflate = getLayoutInflater().inflate(R.layout.common_dialog, null);
        this.a = (ATTextView) inflate.findViewById(R.id.bm_tv_tips);
        h().a(inflate);
        if (z) {
            h().c();
        } else {
            h().b();
        }
        a();
    }

    public final void a(CharSequence charSequence) {
        this.a.setText(charSequence);
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
        this.a.setTextColor(a.c("default_maintext_gray"));
    }
}
