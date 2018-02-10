package com.ucpro.ui.g;

import android.view.inputmethod.InputMethodManager;

/* compiled from: ProGuard */
final class e implements Runnable {
    final /* synthetic */ o a;

    e(o oVar) {
        this.a = oVar;
    }

    public final void run() {
        ((InputMethodManager) this.a.h.getSystemService("input_method")).toggleSoftInput(0, 2);
    }
}
