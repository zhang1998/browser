package com.ucpro.feature.privacymode.view;

import android.text.Editable;
import android.text.TextWatcher;
import com.quark.browser.R;
import com.ucweb.common.util.f;
import com.ucweb.common.util.n.a;

/* compiled from: ProGuard */
final class m implements TextWatcher {
    final /* synthetic */ b a;

    m(b bVar) {
        this.a = bVar;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (!editable.toString().equals("")) {
            if (this.a.a.length() > 3) {
                this.a.m.setText("");
                return;
            }
            this.a.a.append(editable);
            this.a.m.setText("");
            new StringBuilder("afterTextChanged: stringBuffer is ").append(this.a.a);
            this.a.b = this.a.a.length();
            for (int i = 0; i < this.a.a.length(); i++) {
                this.a.e[i].setImageDrawable(this.a.r);
            }
            if (this.a.a.length() != 4) {
                return;
            }
            if (this.a.s == p.a) {
                if (a.a(this.a.c)) {
                    this.a.c = this.a.a.toString();
                    this.a.f.setText(com.ucpro.ui.c.a.d((int) R.string.privacymode_confirm_password));
                    b.h(this.a);
                } else if (a.a(this.a.d)) {
                    this.a.d = this.a.a.toString();
                    if (a.d(this.a.c, this.a.d)) {
                        f.a(this.a.getContext(), this.a.m);
                        this.a.a(this.a.d);
                        return;
                    }
                    this.a.f.setText(com.ucpro.ui.c.a.d((int) R.string.privacymode_confirm_password_retry));
                    this.a.f.setTextColor(com.ucpro.ui.c.a.c("privacymode_password_warn_color"));
                    b.j(this.a);
                }
            } else if (this.a.s != p.b && this.a.s != p.c) {
            } else {
                if (this.a.b(this.a.a.toString())) {
                    f.a(this.a.getContext(), this.a.m);
                    this.a.a(this.a.a.toString());
                    return;
                }
                this.a.f.setText(com.ucpro.ui.c.a.d((int) R.string.privacymode_unlock_password_error));
                this.a.f.setTextColor(com.ucpro.ui.c.a.c("privacymode_password_warn_color"));
                b.j(this.a);
            }
        }
    }
}
