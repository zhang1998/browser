package com.ucpro.feature.r;

import com.ucpro.feature.r.a.b;
import com.ucweb.common.util.n.a;

/* compiled from: ProGuard */
final class f implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ h b;

    f(h hVar, String str) {
        this.b = hVar;
        this.a = str;
    }

    public final void run() {
        if (this.b.b == null || !this.b.b.isShowing()) {
            this.b.b = null;
            return;
        }
        b bVar = this.b.b;
        CharSequence charSequence = this.a;
        bVar.b.setVisibility(0);
        if (a.b(charSequence)) {
            bVar.b.setText(charSequence);
        }
        bVar.c.setVisibility(8);
        bVar.show();
    }
}
