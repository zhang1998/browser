package com.ucpro.ui.edittext;

import com.ui.edittext.u;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ CustomEditText a;

    b(CustomEditText customEditText) {
        this.a = customEditText;
    }

    public final void run() {
        this.a.a(u.SELECTION_HANDLE_TAP);
    }
}
