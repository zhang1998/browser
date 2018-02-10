package com.ucpro.feature.webwindow;

import com.quark.browser.R;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ bb a;

    c(bb bbVar) {
        this.a = bbVar;
    }

    public final void run() {
        this.a.a(a.d((int) R.string.empty_error_anim_page_404_title), this.a.getUrl(), this.a.getUrl());
    }
}
