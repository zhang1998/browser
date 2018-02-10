package com.ucpro.feature.z.b;

import com.ucpro.feature.z.g.b.b;
import com.ucpro.feature.z.g.b.c;
import com.ucpro.feature.z.g.b.h;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.n.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
final class d implements Runnable {
    final /* synthetic */ byte[] a;
    final /* synthetic */ g b;

    d(g gVar, byte[] bArr) {
        this.b = gVar;
        this.a = bArr;
    }

    public final void run() {
        try {
            b bVar = new b();
            if (bVar.a(this.a)) {
                c cVar;
                String str;
                String str2 = "web";
                ArrayList arrayList = bVar.b;
                if (arrayList == null) {
                    cVar = null;
                } else {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        cVar = (c) it.next();
                        if (cVar.b == null) {
                            str = null;
                        } else {
                            str = cVar.b.toString();
                        }
                        if (a.c(str, str2)) {
                            break;
                        }
                    }
                    cVar = null;
                }
                if (cVar != null) {
                    List list = cVar.a;
                    List list2 = bVar.a;
                    if (list != null && list.size() <= 5 && list.size() >= 2 && list2 != null && list2.size() > 0) {
                        a.a(list);
                        a.a(list2);
                        if (this.b.p == null) {
                            this.b.p = new ArrayList();
                        } else {
                            this.b.p.clear();
                        }
                        Iterator it2 = list.iterator();
                        while (it2.hasNext()) {
                            com.ucpro.feature.z.g.b.d dVar = (com.ucpro.feature.z.g.b.d) it2.next();
                            if (dVar.b == null) {
                                str = null;
                            } else {
                                str = dVar.b.toString();
                            }
                            int i = dVar.a;
                            Iterator it3 = list2.iterator();
                            while (it3.hasNext()) {
                                h hVar = (h) it3.next();
                                if (a.c(hVar.e(), str)) {
                                    com.ucpro.feature.z.g.b.a a = this.b.a(hVar);
                                    a.f = i;
                                    this.b.p.add(a);
                                }
                            }
                        }
                        m.a(2, new k(this));
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}
