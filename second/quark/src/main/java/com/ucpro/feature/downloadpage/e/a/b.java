package com.ucpro.feature.downloadpage.e.a;

import android.content.Context;
import android.view.View;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.g.o;
import com.ucpro.ui.widget.auto.theme.ATTextView;
import com.ucweb.materialedittext.MaterialEditText;

/* compiled from: ProGuard */
public final class b extends o {
    public ATTextView a;
    public ATTextView b;
    public MaterialEditText v;

    public b(Context context) {
        super(context);
        View inflate = getLayoutInflater().inflate(R.layout.rename_edit_dialog, null);
        this.a = (ATTextView) inflate.findViewById(R.id.tv_rename_title);
        this.b = (ATTextView) inflate.findViewById(R.id.tv_warn_title);
        this.v = (MaterialEditText) inflate.findViewById(R.id.et_rename);
        h().a(inflate);
        h().b();
        a();
    }

    public final void a() {
        super.a();
        this.v.setHint("文件名");
        this.v.setFloatingLabelText("文件名");
        this.v.setShowClearButton(false);
        this.v.setMetTextColor(a.c("default_maintext_gray"));
        this.v.setMetHintTextColor(a.c("bookmark_edittext_text_hint_color"));
        this.v.setPrimaryColor(a.c("bookmark_edittext_primary_color"));
        this.v.setBaseColor(a.c("bookmark_edittext_base_color"));
        this.a.setTextColor(a.c("default_maintext_gray"));
        this.b.setTextColor(a.c("dialog_yes_button_warning_color"));
    }

    protected final boolean f() {
        return false;
    }

    protected final boolean g() {
        return false;
    }

    public final String k() {
        return this.v.getText().toString();
    }
}
