package com.ucweb.a;

import com.d.a.b.a;
import com.d.a.b.e;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
class h {
    private static final String d = h.class.getSimpleName();
    private static h e;
    ArrayList<g> a = new ArrayList();
    ArrayList<g> b = new ArrayList();
    ArrayList<g> c = new ArrayList();

    private h() {
    }

    public static h a() {
        if (e == null) {
            e = new h();
        }
        return e;
    }

    public final void a(ArrayList<e> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str;
            String str2;
            e eVar = (e) it.next();
            ArrayList arrayList2 = this.a;
            if (eVar.a == null) {
                str = null;
            } else {
                str = eVar.a.toString();
            }
            if (eVar.c == null) {
                str2 = null;
            } else {
                str2 = eVar.c.toString();
            }
            arrayList2.add(new g(this, str, str2));
        }
    }

    public final void b(ArrayList<a> arrayList) {
        this.b.clear();
        this.c.clear();
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str;
                a aVar = (a) it.next();
                ArrayList arrayList2 = this.b;
                String b = aVar.b();
                if (aVar.a == null) {
                    str = null;
                } else {
                    str = aVar.a.toString();
                }
                arrayList2.add(new g(this, b, str));
            }
        }
        this.c.addAll(this.a);
        this.c.removeAll(this.b);
    }
}
