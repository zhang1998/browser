package com.ucpro.feature.aa.a;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: ProGuard */
final class m implements TextWatcher {
    final /* synthetic */ d a;

    m(d dVar) {
        this.a = dVar;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.a.e.a(charSequence);
    }

    public final void afterTextChanged(Editable editable) {
    }
}
