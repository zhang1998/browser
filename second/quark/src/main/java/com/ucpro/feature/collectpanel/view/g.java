package com.ucpro.feature.collectpanel.view;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

/* compiled from: ProGuard */
final class g implements TextWatcher {
    final /* synthetic */ InputTextBox a;

    g(InputTextBox inputTextBox) {
        this.a = inputTextBox;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (this.a.a == null || editable == null || !this.a.a.equals(editable.toString())) {
            this.a.setTextColor(this.a.g);
            InputTextBox.d(this.a);
        } else {
            this.a.setTextColor(this.a.f);
        }
        if (editable == null || TextUtils.isEmpty(editable.toString())) {
            InputTextBox.f(this.a);
        } else {
            InputTextBox.e(this.a);
        }
    }
}
