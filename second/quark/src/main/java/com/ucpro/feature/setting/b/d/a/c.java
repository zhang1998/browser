package com.ucpro.feature.setting.b.d.a;

import android.content.Context;
import android.view.View;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.edittext.CustomEditText;
import com.ucpro.ui.g.o;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class c extends o {
    private int a;
    private CustomEditText b;
    private ATTextView v;
    private a w;

    public c(Context context, int i) {
        super(context);
        this.a = i;
        View inflate = getLayoutInflater().inflate(R.layout.dev_editing_dialog, null);
        this.b = (CustomEditText) inflate.findViewById(R.id.input_edit_view);
        com.ucweb.common.util.c.a(this.b);
        this.v = (ATTextView) inflate.findViewById(R.id.edit_tip);
        com.ucweb.common.util.c.a(this.v);
        h().a(inflate);
        h().b();
        a();
    }

    public final c a(String str) {
        this.v.setText(str);
        return this;
    }

    public final c b(String str) {
        this.b.setText((CharSequence) str);
        return this;
    }

    public final c a(boolean z) {
        this.b.setEnabled(z);
        return this;
    }

    public final void a(a aVar) {
        this.w = aVar;
        com.ucweb.common.util.c.a(this.w);
        a(new f(this));
    }

    public final void a() {
        super.a();
        this.v.setTextColor(a.c("default_maintext_gray"));
        this.b.setTextColor(a.c("dialog_content_color"));
    }
}
