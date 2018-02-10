package com.ucpro.feature.inputenhance;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: ProGuard */
final class ae implements TextWatcher {
    final /* synthetic */ g a;

    private ae(g gVar) {
        this.a = gVar;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() <= 0) {
            this.a.e.a(this.a.e.a, 0);
        } else {
            this.a.e.a(this.a.e.a, 1);
        }
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.a.e.getCurrentState() == this.a.e.a) {
            if (charSequence.length() <= 0) {
                this.a.e.a(this.a.e.a, 0);
                return;
            }
            this.a.e.a(this.a.e.a, 1);
            if (this.a.d != null && !this.a.c && this.a.isShowing()) {
                this.a.d.m();
                this.a.c = true;
            }
        }
    }

    public final void afterTextChanged(Editable editable) {
    }
}
