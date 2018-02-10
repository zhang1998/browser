package com.ucpro.feature.g.c.b;

import com.ucpro.feature.g.a.b;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class d extends b {
    final /* synthetic */ k d;

    d(k kVar) {
        this.d = kVar;
        super(60000);
    }

    public final void a(long j) {
        this.d.e.setText(this.d.g + "/" + (j / 1000) + "s");
    }

    public final void c() {
        this.d.e.setTextColor(a.c("default_maintext_gray"));
        this.d.e.setText(this.d.g);
        this.d.e.setEnabled(true);
        a();
    }
}
