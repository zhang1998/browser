package com.ucpro.feature.z.f.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.ucpro.feature.z.g.a.a;
import com.ucpro.feature.z.g.a.b;
import com.ucpro.feature.z.g.a.d;
import com.ucpro.feature.z.g.a.g;
import com.ucpro.feature.z.g.a.i;
import com.ucweb.common.util.c;
import com.ucweb.common.util.h.m;
import hugo.weaving.DebugLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
public class k implements s {
    public static int a = 10;
    public static final int b = 10;
    public static int c = 5;
    private static final String d = k.class.getSimpleName();
    private d e;
    private h f;
    private String g;
    private q h;
    private d<m> i;
    private d<m> j;
    private d<b> k;
    private d<m> l;
    private a m;

    public k() {
        this(new a(), com.ucpro.b.a.a.b() ? new g() : new i());
    }

    private k(h hVar, d dVar) {
        this.m = new l(this);
        c.a((Object) hVar);
        c.a((Object) dVar);
        this.f = hVar;
        this.e = dVar;
    }

    public final void a(String str, q qVar) {
        c.a((Object) str);
        c.a((Object) qVar);
        this.g = str;
        this.h = qVar;
        if (this.i == null || !this.i.a.equalsIgnoreCase(this.g)) {
            this.f.a(this.g, new b(this));
        } else if (this.h != null) {
            this.h.a(this.g, this.i.b);
        }
        if (this.k == null || !this.k.a.equalsIgnoreCase(this.g)) {
            this.k = null;
            this.e.a(this.g, this.m);
            return;
        }
        a(this.g, this.k.b);
    }

    @DebugLog
    private void a(String str, ArrayList<b> arrayList) {
        c.a((CharSequence) str);
        if (str == null || !str.equalsIgnoreCase(this.g)) {
            new StringBuilder("ignore. cloud suggestion's keyword;").append(str).append(" not match current keyword: ").append(this.g);
        } else if (arrayList != null && !arrayList.isEmpty()) {
            this.k = new d();
            this.k.a = str;
            this.k.b = arrayList;
            if (this.j != null && this.l != null) {
                m.a(2, new j(this, str, a(this.l.b, this.j.b, (List) arrayList)));
            }
        }
    }

    @DebugLog
    private void b(String str, ArrayList<m> arrayList) {
        this.i = new d();
        this.i.a = this.g;
        this.i.b = arrayList;
        if (this.h != null) {
            this.h.a(str, arrayList);
        }
    }

    @DebugLog
    private ArrayList<m> a(@NonNull ArrayList<m> arrayList, @NonNull ArrayList<m> arrayList2, @Nullable List<b> list) {
        int min;
        int min2;
        b bVar;
        c.a((Object) arrayList);
        c.a((Object) arrayList2);
        if (list == null) {
            list = new ArrayList();
        }
        int size = (a - arrayList.size()) - arrayList2.size();
        if (size <= 0) {
            min = Math.min(1, list.size());
        } else {
            min = Math.min(size, list.size());
        }
        size = (a - arrayList2.size()) - min;
        if (size <= 0) {
            min2 = Math.min(c, arrayList.size());
        } else {
            min2 = Math.min(size, arrayList.size());
        }
        int min3 = Math.min((a - min2) - min, arrayList2.size());
        c.a(min3 >= 0, "check the value of MAX and MIN constant, they must be wrong");
        ArrayList arrayList3 = new ArrayList();
        if (min > 0 && min2 > 0) {
            Object obj = null;
            int i = 0;
            int i2 = 0;
            while (i2 < list.size()) {
                Object obj2;
                int i3;
                bVar = (b) list.get(i2);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    String str;
                    String trim = ((m) it.next()).d.trim();
                    if (bVar.c == null) {
                        str = null;
                    } else {
                        str = bVar.c.toString();
                    }
                    if (trim.equalsIgnoreCase(str)) {
                        obj2 = 1;
                        break;
                    }
                }
                obj2 = obj;
                if (obj2 == null) {
                    arrayList3.add(list.get(i2));
                    i3 = i + 1;
                } else {
                    i3 = i;
                }
                if (i3 >= min) {
                    break;
                }
                i2++;
                i = i3;
                obj = obj2;
            }
        }
        ArrayList<m> arrayList4 = new ArrayList((min2 + min3) + min);
        for (size = 0; size < min2; size++) {
            arrayList4.add(arrayList.get(size));
        }
        for (size = 0; size < min3; size++) {
            arrayList4.add(arrayList2.get(size));
        }
        for (min2 = 0; min2 < min; min2++) {
            m mVar = new m();
            bVar = (b) list.get(min2);
            mVar.a = g.SOURCE_TYPE_CLOUD;
            mVar.b = bVar.a == 1 ? f.TITLE_AND_URL : f.TITLE_ONLY;
            mVar.c = -1;
            mVar.d = bVar.c();
            c.a(mVar.d);
            if (bVar.c() != null) {
                mVar.f = bVar.c().indexOf(this.g);
            }
            mVar.g = this.g.length();
            mVar.e = bVar.e();
            if (bVar.e() != null) {
                mVar.h = bVar.e().indexOf(this.g);
                mVar.i = this.g.length();
            }
            arrayList4.add(mVar);
        }
        return arrayList4;
    }

    static /* synthetic */ void a(k kVar, String str, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
        c.a((Object) str);
        ArrayList arrayList4 = new ArrayList();
        p pVar = new p();
        int i = a;
        c.b(i > 0);
        pVar.a = i;
        pVar.a(arrayList2).a(arrayList3).a(kVar.g, (Collection) arrayList4);
        kVar.j = new d();
        kVar.j.a = kVar.g;
        kVar.j.b = arrayList4;
        kVar.l = new d();
        kVar.l.a = kVar.g;
        kVar.l.b = arrayList;
        kVar.b(kVar.g, kVar.a(arrayList, arrayList4, kVar.k != null ? kVar.k.b : null));
    }
}
