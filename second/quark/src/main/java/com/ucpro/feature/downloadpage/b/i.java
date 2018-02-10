package com.ucpro.feature.downloadpage.b;

import com.quark.browser.R;
import com.ucpro.base.system.b;
import com.ucpro.c.d;
import com.ucpro.ui.c.a;
import com.ucpro.ui.e.a.e;

/* compiled from: ProGuard */
final class i implements Runnable {
    final /* synthetic */ e a;
    final /* synthetic */ n b;

    i(n nVar, e eVar) {
        this.b = nVar;
        this.a = eVar;
    }

    public final void run() {
        if (!d.a()) {
            this.a.m.setText(String.format(a.d((int) R.string.download_setting_store_format), new Object[]{b.a.a(this.b.f), b.a.a(this.b.g)}));
        }
    }
}
