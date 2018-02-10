package com.ucpro.feature.downloadpage.e;

import com.quark.browser.R;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class v implements Runnable {
    final /* synthetic */ o a;

    v(o oVar) {
        this.a = oVar;
    }

    public final void run() {
        this.a.n.setText(String.format(a.d((int) R.string.download_store_status), new Object[]{this.a.g}));
    }
}
