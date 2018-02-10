package com.taobao.weex.c;

import com.taobao.weex.c.b.i;

/* compiled from: ProGuard */
final class k implements ad {
    final /* synthetic */ m a;

    private k(m mVar) {
        this.a = mVar;
    }

    public final void a(ae aeVar) {
        if (aeVar.t()) {
            if (aeVar.f_()) {
                if (aeVar.f_()) {
                    aeVar.j = i.c;
                } else {
                    throw new IllegalStateException("Expected node to have a new csslayout to be seen!");
                }
            }
            if (!aeVar.x) {
                ae v = aeVar.v();
                if (v != null) {
                    this.a.e.add(new j(this, v));
                }
            }
        }
    }
}
