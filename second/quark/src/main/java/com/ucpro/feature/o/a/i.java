package com.ucpro.feature.o.a;

import android.util.Log;
import com.ucpro.feature.g.a.b;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class i extends b {
    final /* synthetic */ f d;

    i(f fVar) {
        this.d = fVar;
        super(60000);
    }

    public final void a(long j) {
        Log.e("zhj", "onTick : " + j);
        this.d.p.setText(this.d.v + "(" + (j / 1000) + ")");
    }

    public final void c() {
        this.d.p.setTextColor(a.c("default_purpleblue"));
        this.d.p.setText(this.d.v);
        this.d.p.setEnabled(true);
        a();
    }
}
