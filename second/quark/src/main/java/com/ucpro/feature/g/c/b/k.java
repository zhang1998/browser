package com.ucpro.feature.g.c.b;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.quark.browser.R;
import com.ucpro.feature.g.a.b;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;
import com.ucweb.common.util.f;
import com.ucweb.materialedittext.MaterialEditText;

/* compiled from: ProGuard */
public final class k implements TextWatcher, OnClickListener, OnEditorActionListener {
    public View a;
    n b;
    private MaterialEditText c = ((MaterialEditText) this.a.findViewById(R.id.cloud_sycn_et_phone));
    private MaterialEditText d = ((MaterialEditText) this.a.findViewById(R.id.cloud_sycn_et_verif_code));
    private ATTextView e = ((ATTextView) this.a.findViewById(R.id.cloud_sycn_tv_auto_code));
    private b f;
    private String g;

    public k(Context context) {
        this.a = LayoutInflater.from(context).inflate(R.layout.cloud_sync_phone_number, null);
        this.e.setClickable(true);
        this.e.setOnClickListener(this);
        this.e.setTextColor(a.c("default_maintext_gray"));
        this.e.setText(a.d((int) R.string.cloud_sync_get_verif_code));
        this.g = a.d((int) R.string.cloud_sync_again_verif_code);
        this.c.setHint(a.d((int) R.string.cloud_sync_phone_number));
        this.c.setFloatingLabelText(a.d((int) R.string.cloud_sync_phone_number));
        this.c.setShowClearButton(false);
        this.c.setUnderlineColor(a.c("default_iconcolor"));
        this.c.setUnderLineHight(a.c((int) R.dimen.clound_sync_edit_under_line_height));
        this.c.setUnderLineSelectHight(a.c((int) R.dimen.clound_sync_edit_under_line_select_height));
        this.d.setHint(a.d((int) R.string.cloud_sync_verif_code));
        this.d.setFloatingLabelText(a.d((int) R.string.cloud_sync_verif_code));
        this.d.setShowClearButton(false);
        this.d.setUnderlineColor(a.c("default_iconcolor"));
        this.d.setOnEditorActionListener(this);
        this.d.addTextChangedListener(this);
        this.d.setUnderLineHight(a.c((int) R.dimen.clound_sync_edit_under_line_height));
        this.d.setUnderLineSelectHight(a.c((int) R.dimen.clound_sync_edit_under_line_select_height));
        this.c.setMetTextColor(a.c("default_maintext_gray"));
        this.c.setMetHintTextColor(a.c("bookmark_edittext_text_hint_color"));
        this.c.setPrimaryColor(a.c("bookmark_edittext_primary_color"));
        this.c.setBaseColor(a.c("bookmark_edittext_base_color"));
        this.d.setMetTextColor(a.c("default_maintext_gray"));
        this.d.setMetHintTextColor(a.c("bookmark_edittext_text_hint_color"));
        this.d.setPrimaryColor(a.c("bookmark_edittext_primary_color"));
        this.d.setBaseColor(a.c("bookmark_edittext_base_color"));
        this.f = new d(this);
    }

    private String a() {
        Editable text = this.c.getText();
        return text != null ? text.toString() : "";
    }

    private String b() {
        Editable text = this.d.getText();
        return text != null ? text.toString() : "";
    }

    public final void onClick(View view) {
        if (com.ucpro.base.system.b.a.f(a()) && a().length() == 11) {
            view.setEnabled(false);
            this.e.setTextColor(a.c("cloud_verfi_code_unclick_text_color"));
            this.f.b();
        }
        if (this.b != null) {
            this.b.a(a());
        }
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if ((i == 0 || i == 6) && this.b != null) {
            f.a(textView.getContext(), (View) textView);
            this.b.a(a(), b());
        }
        return true;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (editable != null && editable.length() == 4 && com.ucweb.common.util.n.a.b(a())) {
            this.e.removeTextChangedListener(this);
            f.a(this.e.getContext(), this.e);
            this.b.a(a(), b());
        }
    }
}
