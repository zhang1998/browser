package com.ucpro.feature.defaultbrowser;

import android.content.Intent;
import com.ucweb.common.util.c;
import com.ucweb.common.util.h.a;

/* compiled from: ProGuard */
final class y extends a {
    final /* synthetic */ Intent a;
    final /* synthetic */ m b;

    y(m mVar, Intent intent) {
        this.b = mVar;
        this.a = intent;
    }

    public final void run() {
        try {
            this.b.b.startActivity(this.a);
        } catch (Throwable e) {
            c.a("fail", e);
        }
    }
}
