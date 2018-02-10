package com.ucpro.feature.bookmarkhis.c;

import android.view.View;
import com.ucpro.business.stat.a.d;
import com.ucpro.business.stat.m;
import com.ucpro.feature.bookmarkhis.c.a.c;
import com.ucpro.ui.widget.viewpager.n;

/* compiled from: ProGuard */
final class b implements n {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void a(int i, float f) {
    }

    public final void a(int i) {
        View view = ((c) this.a.g.get(0)).b;
        View view2 = ((c) this.a.g.get(1)).b;
        if (i == 0) {
            m.a((d) view);
        } else {
            m.a((d) view2);
        }
    }

    public final void b(int i) {
    }
}
