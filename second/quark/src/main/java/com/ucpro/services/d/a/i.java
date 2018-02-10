package com.ucpro.services.d.a;

import com.ucpro.services.d.b.a;
import com.ucpro.services.d.b.b;
import com.ucpro.services.d.b.c;
import com.ucpro.services.d.b.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class i<T extends b> {
    String a;
    private f<T> b;

    public i(String str, f<T> fVar) {
        this.b = fVar;
        this.a = str;
    }

    public final boolean a(List<T> list) {
        if (list == null) {
            synchronized (u.class) {
                com.uc.browser.b.a("cms_data", this.a);
            }
            return false;
        }
        if (com.ucpro.c.b.b()) {
            new StringBuilder("save data ( size:").append(list.size()).append(" )");
        }
        com.uc.base.b.c.i cVar = new c();
        List arrayList = new ArrayList();
        for (T t : list) {
            if (t != null) {
                a aVar = new a();
                aVar.getClass();
                d dVar = new d(aVar);
                if (t != null) {
                    aVar.q = t.q;
                    aVar.p = t.p;
                    aVar.r = t.r;
                    aVar.s = t.s;
                    aVar.t = t.t;
                    aVar.u = t.u;
                    aVar.v = t.v;
                    com.uc.base.b.c.b.c a = t.a();
                    if (a != null) {
                        aVar.a = a.l_();
                    }
                }
                arrayList.add(dVar);
            }
        }
        cVar.a = arrayList;
        synchronized (u.class) {
            com.uc.browser.b.a("cms_data", this.a);
            com.uc.browser.b.a("cms_data", this.a, cVar);
        }
        return true;
    }

    public final List<T> a() {
        synchronized (u.class) {
            try {
                c cVar = (c) com.uc.browser.b.a("cms_data", this.a, c.class);
            } catch (com.uc.browser.a e) {
                cVar = null;
            }
        }
        if (cVar == null) {
            return null;
        }
        List<d> list = cVar.a;
        if (list == null) {
            return null;
        }
        List<T> arrayList = new ArrayList();
        for (d dVar : list) {
            b b = this.b.b();
            a aVar = dVar.a;
            b.q = aVar.q;
            b.p = aVar.p;
            b.r = aVar.r;
            b.s = aVar.s;
            b.t = aVar.t;
            b.u = aVar.u;
            b.v = aVar.v;
            com.uc.base.b.c.b.c a = b.a();
            if (!(a == null || aVar.a == null)) {
                a.a(aVar.a);
            }
            arrayList.add(b);
        }
        return arrayList;
    }
}
