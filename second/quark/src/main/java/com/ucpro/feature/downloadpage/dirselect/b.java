package com.ucpro.feature.downloadpage.dirselect;

import android.content.Context;
import android.widget.LinearLayout.LayoutParams;
import com.quark.browser.R;
import com.ucpro.feature.b.a;
import com.ucweb.materialedittext.MaterialEditText;

/* compiled from: ProGuard */
public final class b extends a {
    private MaterialEditText b = new MaterialEditText(getContext());

    public b(Context context) {
        super(context);
        this.b.setTextSize(0, com.ucpro.ui.c.a.a((int) R.dimen.bookmark_edittext_text_size));
        this.b.setFloatingLabel(2);
        this.b.setMaxLines(1);
        this.b.setHint(com.ucpro.ui.c.a.d((int) R.string.download_setting_input_folder_name));
        this.b.setFloatingLabelText(com.ucpro.ui.c.a.d((int) R.string.download_setting_folder_name));
        this.b.setShowClearButton(false);
        this.b.requestFocus();
        this.b.setFloatingLabelAlwaysShown(true);
        this.a.addView(this.b, new LayoutParams(-1, -2));
        h().b();
        this.b.setMetTextColor(com.ucpro.ui.c.a.c("default_maintext_gray"));
        this.b.setMetHintTextColor(com.ucpro.ui.c.a.c("default_commentstext_gray"));
        this.b.setPrimaryColor(com.ucpro.ui.c.a.c("default_purpleblue"));
        this.b.setBaseColor(com.ucpro.ui.c.a.c("bookmark_edittext_base_color"));
        this.b.setFloatingLabelTextColor(com.ucpro.ui.c.a.c("default_assisttext_gray"));
    }

    public final String k() {
        return this.b.getText().toString();
    }
}
