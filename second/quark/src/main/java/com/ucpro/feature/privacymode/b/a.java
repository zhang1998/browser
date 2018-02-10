package com.ucpro.feature.privacymode.b;

import com.uc.quark.h;
import com.uc.quark.s;
import com.uc.quark.x;

/* compiled from: ProGuard */
final class a implements h {
    final /* synthetic */ b a;

    a(b bVar) {
        this.a = bVar;
    }

    public final void a(s sVar, int i, long j, long j2) {
        if (sVar.b instanceof b) {
            if (j2 > 0) {
                this.a.a((int) ((100 * j) / j2), j, j2);
            }
            if (i != -1 && i != -3) {
                return;
            }
            if (i == -3) {
                this.a.a(sVar.h());
                x.a().a(sVar.a(), sVar.h(), sVar.b(), false);
                return;
            }
            x.a().a(sVar.a(), sVar.h(), sVar.b(), false);
            this.a.a();
        }
    }
}
