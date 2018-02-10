package com.ucpro.feature.downloadpage.e;

import com.quark.browser.R;
import com.ucpro.ui.b.e;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class r implements Runnable {
    final /* synthetic */ g a;

    r(g gVar) {
        this.a = gVar;
    }

    public final void run() {
        e.a().a(a.d((int) R.string.download_request_fail), 1);
    }
}
