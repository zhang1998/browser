package com.uc.base.b.c;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class l extends m {
    private e i;

    protected final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return n();
    }

    l(int i, String str, e eVar) {
        super(i, str, 3);
        this.i = eVar;
    }

    public final e p() {
        e n = this.i.n();
        a(n);
        return n;
    }

    public final void a(e eVar) {
        this.f.add(eVar);
    }

    protected final e n() {
        e lVar = new l(this.a, a(), this.i);
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar != null) {
                arrayList.add(eVar.n());
            } else {
                arrayList.add(null);
            }
        }
        lVar.f = arrayList;
        return lVar;
    }

    final void a(int i, Object obj) {
        if (obj != null) {
            if (this.i instanceof m) {
                ((m) obj).a = i;
                a((m) obj);
                return;
            }
            e n = this.i.n();
            n.a = i;
            n.d = obj;
            a(n);
        }
    }
}
