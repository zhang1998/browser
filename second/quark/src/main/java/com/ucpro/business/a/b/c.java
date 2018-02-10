package com.ucpro.business.a.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.business.a.b.a.f;

/* compiled from: ProGuard */
final class c implements OnClickListener {
    final /* synthetic */ f a;
    final /* synthetic */ d b;

    c(d dVar, f fVar) {
        this.b = dVar;
        this.a = fVar;
    }

    public final void onClick(View view) {
        g.a().b(e.ci, this.a.b);
    }
}
