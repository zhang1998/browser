package com.uc.weex.a;

import com.uc.weex.component.i.b;
import com.uc.weex.h.k;

/* compiled from: ProGuard */
final class x implements Runnable {
    final /* synthetic */ k a;
    final /* synthetic */ e b;
    final /* synthetic */ y c;

    x(y yVar, k kVar, e eVar) {
        this.c = yVar;
        this.a = kVar;
        this.b = eVar;
    }

    public final void run() {
        boolean z;
        String str = this.a.b;
        String str2 = this.a.c;
        boolean z2 = this.a.a;
        if (b.a(str) || b.a(str2)) {
            z = false;
        } else {
            z = true;
        }
        boolean z3 = this.a.i;
        l lVar;
        if (z3 || z2) {
            n nVar = (n) this.c.d.get(str);
            if (nVar == null) {
                lVar = new l();
                lVar.d = str;
                lVar.b = str2;
                if (!z3) {
                    lVar.g = z;
                }
                this.c.e.a(lVar, this.b);
                return;
            }
            this.c.a(this.b, nVar, y.a(nVar), ab.d);
            if (z && !z3) {
                lVar = new l();
                lVar.d = str;
                lVar.b = str2;
                lVar.g = true;
                this.c.e.a(lVar, null);
                return;
            }
            return;
        }
        lVar = new l();
        lVar.d = str;
        lVar.b = str2;
        lVar.g = z;
        this.c.e.a(lVar, new w(this));
    }
}
