package com.ucpro.ui.widget;

import android.view.inputmethod.InputMethodManager;

/* compiled from: ProGuard */
final class m implements Runnable {
    final /* synthetic */ EditText a;

    m(EditText editText) {
        this.a = editText;
    }

    public final void run() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.a.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.showInputMethodPicker();
        }
    }
}
