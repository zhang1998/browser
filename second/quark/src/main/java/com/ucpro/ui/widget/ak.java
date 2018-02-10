package com.ucpro.ui.widget;

import android.view.inputmethod.InputMethodManager;

/* compiled from: ProGuard */
final class ak implements Runnable {
    final /* synthetic */ EditText a;

    ak(EditText editText) {
        this.a = editText;
    }

    public final void run() {
        ((InputMethodManager) this.a.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
    }
}
