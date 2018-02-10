package com.ucpro.business.e.d;

import com.ucpro.business.d.a;
import com.ucpro.business.d.g;
import com.ucpro.c.b;
import java.util.Iterator;

/* compiled from: ProGuard */
final class h implements Runnable {
    final /* synthetic */ boolean[] a;
    final /* synthetic */ a b;
    final /* synthetic */ g c;

    h(g gVar, boolean[] zArr, a aVar) {
        this.c = gVar;
        this.a = zArr;
        this.b = aVar;
    }

    public final void run() {
        if (this.a[0]) {
            this.c.a.clear();
            g.b(this.c);
            Iterator it = this.b.a.iterator();
            while (it.hasNext()) {
                String str;
                String str2;
                g gVar = (g) it.next();
                if (gVar.a == null) {
                    str = null;
                } else {
                    str = gVar.a.toString();
                }
                if (gVar.b == null) {
                    str2 = null;
                } else {
                    str2 = gVar.b.toString();
                }
                if (b.b()) {
                    new StringBuilder("UcProParam: name = ").append(str).append(", value = ").append(str2);
                }
                e a = this.c.a(str);
                if (a != null) {
                    a.a(j.UPDATE, str, str2);
                }
                this.c.a.put(str, str2);
            }
            g.c(this.c);
        }
    }
}
