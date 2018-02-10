package com.ucpro.feature.s.b.a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ProGuard */
final class g implements OnClickListener {
    final /* synthetic */ e a;

    g(e eVar) {
        this.a = eVar;
    }

    public final void onClick(View view) {
        if (this.a.j < ((float) this.a.getVisibleTop()) && this.a.g != null) {
            this.a.g.d();
        }
    }
}
