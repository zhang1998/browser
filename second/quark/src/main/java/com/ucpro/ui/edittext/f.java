package com.ucpro.ui.edittext;

import android.view.inputmethod.InputMethodManager;

/* compiled from: ProGuard */
public final class f implements Runnable {
    final /* synthetic */ CustomEditText a;

    public f(CustomEditText customEditText) {
        this.a = customEditText;
    }

    public final void run() {
        ((InputMethodManager) this.a.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
    }
}
