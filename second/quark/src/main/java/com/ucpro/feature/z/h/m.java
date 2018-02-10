package com.ucpro.feature.z.h;

import com.ucpro.base.a.e;
import com.ucpro.feature.z.a.i;
import com.ucpro.feature.z.h.a.g;

/* compiled from: ProGuard */
final class m extends g {
    final /* synthetic */ String a;
    final /* synthetic */ i b;

    m(i iVar, String str) {
        this.b = iVar;
        this.a = str;
    }

    public final void a() {
        com.ucpro.base.a.g.a().b(e.Q);
        this.b.o = false;
        this.b.q.removeCallbacks(this.b.t);
    }

    public final void b() {
        this.b.f.b(this.a);
        i j = this.b.f;
        j.a.getUrlEditText().a(0, j.a.getUrlEditText().getText().length());
        new StringBuilder("selectAllText text.length() : ").append(j.a.getUrlEditText().getText().length());
    }
}
