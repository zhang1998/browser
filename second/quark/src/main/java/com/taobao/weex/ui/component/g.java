package com.taobao.weex.ui.component;

import android.text.Editable;
import android.text.TextWatcher;
import com.taobao.weex.c.o;

/* compiled from: ProGuard */
final class g implements TextWatcher {
    final /* synthetic */ l a;

    g(l lVar) {
        this.a = lVar;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        o domObject = this.a.getDomObject();
        if (!this.a.b.equals(charSequence.toString()) && domObject != null) {
            this.a.b = charSequence.toString();
            if (this.a.m) {
                this.a.m = false;
            } else {
                this.a.a(domObject.c_().contains("input") ? "input" : null, charSequence.toString());
            }
        }
    }

    public final void afterTextChanged(Editable editable) {
    }
}
