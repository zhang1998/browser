package com.ucpro.business.stat.b;

import com.uc.base.wa.p;
import com.ucweb.common.util.i.c;

/* compiled from: ProGuard */
final class a implements p {
    final /* synthetic */ f a;

    a(f fVar) {
        this.a = fVar;
    }

    public final String a() {
        if (c.b()) {
            return "wifi";
        }
        return "mobile";
    }
}
