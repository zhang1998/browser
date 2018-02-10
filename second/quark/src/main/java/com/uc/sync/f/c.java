package com.uc.sync.f;

import android.util.SparseArray;
import com.uc.sync.a.a;
import com.uc.sync.b.b.b;
import com.uc.sync.b.b.d;
import com.uc.sync.b.b.e;
import com.uc.sync.b.b.f;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class c {
    SparseArray<o> a;
    b b;
    SparseArray<SparseArray<f>> c = new SparseArray();

    public c(SparseArray<o> sparseArray) {
        this.a = sparseArray;
        this.b = a((SparseArray) sparseArray);
    }

    private b a(SparseArray<o> sparseArray) {
        b bVar = new b();
        com.uc.sync.b.b.c cVar = new com.uc.sync.b.b.c();
        cVar.a = a.a(a.g);
        cVar.b = 1;
        f fVar = new f();
        fVar.a = a.a("android");
        fVar.b = a.a("phone");
        fVar.c = a.a(a.a);
        fVar.d = a.a(a.b);
        fVar.f = a.a(a.c);
        fVar.g = a.a(a.d);
        fVar.h = a.a(a.e);
        cVar.c = fVar;
        cVar.d = a.a(com.uc.sync.g.a.a());
        bVar.a = cVar;
        for (int i = 0; i < sparseArray.size(); i++) {
            SparseArray sparseArray2;
            o oVar = (o) sparseArray.get(sparseArray.keyAt(i));
            int i2 = oVar.a;
            SparseArray sparseArray3 = (SparseArray) this.c.get(i2);
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                this.c.put(i2, sparseArray3);
                sparseArray2 = sparseArray3;
            } else {
                sparseArray2 = sparseArray3;
            }
            com.uc.sync.b.b.a aVar = new com.uc.sync.b.b.a();
            d a = a(oVar);
            e eVar = new e();
            eVar.a = oVar.g;
            eVar.c = oVar.h;
            if (oVar.a()) {
                f fVar2 = oVar.l;
                if (fVar2 != null) {
                    sparseArray2.put(fVar2.b, fVar2);
                    eVar.b.add(fVar2.a());
                }
            } else {
                Iterator it = oVar.b().iterator();
                while (it.hasNext()) {
                    l lVar = (l) it.next();
                    f fVar3 = null;
                    Object a2 = com.uc.sync.e.f.a.a(oVar.a);
                    com.ucweb.common.util.c.a(a2);
                    String str = lVar.e;
                    int i3 = lVar.b;
                    if (i3 == 0) {
                        fVar3 = new f(0);
                        fVar3.c = lVar.b();
                        fVar3.f = a2.a(lVar).l_();
                    } else if (i3 == 1) {
                        if (!com.ucweb.common.util.n.a.a(str)) {
                            fVar3 = new f(3);
                            fVar3.d = str;
                        }
                    } else if (i3 == 3) {
                        fVar3 = new f(4);
                        fVar3.d = str;
                        fVar3.c = lVar.b();
                        fVar3.f = a2.a(lVar).l_();
                    } else if (i3 == 4) {
                        fVar3 = new f(2);
                        fVar3.d = str;
                        fVar3.c = lVar.b();
                        com.uc.base.b.c.b.c a3 = a2.a(lVar);
                        com.uc.base.b.c.b.c a4 = a2.a(a2.f(), lVar);
                        fVar3.f = a3.l_();
                        fVar3.e = a4.l_();
                    } else if (i3 == 2 && !com.ucweb.common.util.n.a.a(str)) {
                        fVar3 = new f(5);
                        fVar3.d = lVar.e;
                    }
                    if (fVar3 != null) {
                        fVar3.g = lVar;
                    }
                    if (fVar3 != null) {
                        sparseArray2.put(fVar3.b, fVar3);
                        eVar.b.add(fVar3.a());
                    }
                }
            }
            aVar.a = a;
            aVar.b = eVar;
            bVar.b.add(aVar);
            oVar.a(1);
        }
        return bVar;
    }

    private static d a(o oVar) {
        d dVar = new d();
        dVar.a = a.a(oVar.j);
        dVar.b = oVar.a;
        dVar.c = oVar.d;
        dVar.d = oVar.e;
        dVar.e = oVar.b;
        ArrayList arrayList = oVar.n;
        if (arrayList != null) {
            ArrayList arrayList2 = dVar.f;
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList2.add(a.a((String) arrayList.get(i)));
            }
        }
        dVar.g = oVar.m;
        dVar.h = oVar.f;
        dVar.i = oVar.i;
        dVar.j = oVar.k;
        dVar.k = 2;
        return dVar;
    }
}
