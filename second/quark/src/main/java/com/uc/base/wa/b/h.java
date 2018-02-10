package com.uc.base.wa.b;

import com.uc.base.wa.config.b;
import com.uc.base.wa.config.c;
import java.util.Collection;
import java.util.HashSet;

/* compiled from: ProGuard */
public final class h implements Cloneable {
    c a;
    c b;
    c c;
    private String d;

    protected final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    public h(String str) {
        this.d = str;
    }

    public static h a(h hVar, b bVar, boolean z, c cVar, String... strArr) {
        if (bVar == null) {
            return null;
        }
        int i;
        String[] e;
        int i2;
        if (strArr == null) {
            strArr = new String[0];
        }
        HashSet hashSet = new HashSet(strArr.length);
        for (Object add : strArr) {
            hashSet.add(add);
        }
        Collection collection = bVar.m;
        if (collection != null) {
            hashSet.addAll(collection);
        }
        int i3 = 0;
        String[] b = c.b();
        if (b != null) {
            for (Object add2 : b) {
                hashSet.add(add2);
            }
            i3 = b.length + 0;
        }
        if (z || (cVar != null && cVar.e)) {
            e = c.e();
            if (e != null) {
                for (Object add3 : e) {
                    hashSet.add(add3);
                }
                i3 += e.length;
            }
        }
        if (z || cVar == null || !cVar.e) {
            e = c.c();
            if (e != null) {
                for (Object add32 : e) {
                    hashSet.add(add32);
                }
                i3 += e.length;
            }
        }
        if (cVar != null) {
            hashSet.removeAll(cVar.a().keySet());
        }
        if (hashSet.size() <= i3 && cVar != null && !cVar.c() && !cVar.d()) {
            return null;
        }
        c[] cVarArr = new c[]{hVar.a().a, hVar.a().b, hVar.a().c};
        for (i2 = 0; i2 < 3; i2++) {
            c cVar2 = cVarArr[i2];
            if (cVar2 != null) {
                i = 1;
                String[][] strArr2 = new String[][]{cVar2.a, cVar2.b, cVar2.c, cVar2.d};
                for (int i4 = 0; i4 < 4; i4++) {
                    String[] strArr3 = strArr2[i4];
                    if (strArr3 != null) {
                        for (i3 = 0; i3 < strArr3.length; i3++) {
                            if (hashSet.contains(strArr3[i3])) {
                                i &= 0;
                            } else {
                                strArr3[i3] = null;
                            }
                        }
                    }
                }
                if (i != 0) {
                    cVar2.e = true;
                }
            }
        }
        return r2;
    }

    private h a() {
        h hVar = new h(this.d);
        if (this.a != null) {
            hVar.a = this.a.f();
        }
        if (this.b != null) {
            hVar.b = this.b.f();
        }
        if (this.c != null) {
            hVar.c = this.c.f();
        }
        return hVar;
    }
}
