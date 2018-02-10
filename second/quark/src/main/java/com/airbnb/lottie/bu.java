package com.airbnb.lottie;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class bu implements bq, de {
    final int a;
    final bl<?, Float> b;
    final bl<?, Float> c;
    final bl<?, Float> d;
    private final List<bq> e = new ArrayList();

    bu(cz czVar, dm dmVar) {
        this.a = dmVar.a;
        this.b = dmVar.b.b();
        this.c = dmVar.c.b();
        this.d = dmVar.d.b();
        czVar.a(this.b);
        czVar.a(this.c);
        czVar.a(this.d);
        this.b.a((bq) this);
        this.c.a((bq) this);
        this.d.a((bq) this);
    }

    public final void a() {
        for (int i = 0; i < this.e.size(); i++) {
            ((bq) this.e.get(i)).a();
        }
    }

    public final void a(List<de> list, List<de> list2) {
    }

    final void a(bq bqVar) {
        this.e.add(bqVar);
    }
}
