package com.uc.weex.component.c;

import com.uc.weex.component.c.a.e;

/* compiled from: ProGuard */
final class d implements e {
    final /* synthetic */ b a;
    final /* synthetic */ f b;

    d(f fVar, b bVar) {
        this.b = fVar;
        this.a = bVar;
    }

    public final void a(int i, int i2, float f) {
        if (this.a != null && i != i2 && i2 == 3 && f >= this.a.e) {
            this.a.getInstance().a(this.a.getRef(), "refresh", null);
        }
    }
}
