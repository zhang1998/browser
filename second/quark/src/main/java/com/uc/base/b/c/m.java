package com.uc.base.b.c;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public class m extends e {
    private static int i = 16;
    private static c j;
    protected ArrayList<e> f;
    public m g;
    boolean h;

    protected /* synthetic */ Object clone() throws CloneNotSupportedException {
        return n();
    }

    static {
        try {
            j = c.b("".getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
        }
    }

    public m(int i, Object obj, int i2) {
        this(i, obj, i2, 50);
    }

    public m(Object obj, int i) {
        this(0, obj, 1, i);
    }

    public m(int i, Object obj, int i2, int i3) {
        this(i, obj, i2, i3, 10);
    }

    public m(int i, Object obj, int i2, int i3, int i4) {
        super(i, obj, i2, i3);
        this.f = null;
        this.g = null;
        this.h = false;
        this.f = new ArrayList(i4);
    }

    public final void a(int i, c cVar) {
        b(i, (Object) cVar);
    }

    public final void a(int i, String str, String str2) {
        a(i, str, 1, 12, str2);
    }

    public final void a(int i, long j) {
        b(i, Long.valueOf(j));
    }

    public final void a(int i, String str, long j) {
        a(i, str, 1, 9, Long.valueOf(j));
    }

    public final void a(int i, int i2) {
        b(i, Integer.valueOf(i2));
    }

    public final void a(int i, String str, int i2) {
        a(i, str, 1, 4, Integer.valueOf(i2));
    }

    public final void a(int i, boolean z) {
        b(i, Boolean.valueOf(z));
    }

    public final void a(String str, boolean z) {
        a(2, str, 1, 11, Boolean.valueOf(z));
    }

    public final void a(int i, byte[] bArr) {
        b(i, c.a(bArr));
    }

    public final void a(int i, String str, i iVar) {
        if (iVar != null) {
            e a = iVar.a();
            iVar.a((m) a);
            a.a = i;
            a.e = str;
            a(a);
        }
    }

    public final i a(int i, int i2, i iVar) {
        if (iVar == null) {
            return null;
        }
        if (this != null) {
            m mVar = (m) d(i, i2);
            if (mVar != null && mVar.o()) {
                i a = iVar.a(mVar.b);
                if (a != null) {
                    a.b(mVar);
                }
                return a;
            }
        }
        return null;
    }

    public final String b(int i) {
        e i2 = i(i);
        if (i2 == null) {
            return null;
        }
        try {
            return (String) i2.l();
        } catch (Exception e) {
            return null;
        }
    }

    public final int c(int i) {
        return b(i, 0);
    }

    public final int b(int i, int i2) {
        e i3 = i(i);
        if (i3 != null) {
            return i3.d();
        }
        return i2;
    }

    public final byte[] f(int i) {
        return g(i);
    }

    public final byte[] g(int i) {
        e i2 = i(i);
        if (i2 != null) {
            return i2.m();
        }
        return null;
    }

    public final void a(int i, String str, int i2, i iVar) {
        if (i2 == 3) {
            e a = iVar.a();
            if (((l) i(i)) == null) {
                a(new l(i, str, a));
                return;
            }
            return;
        }
        e a2 = iVar.a();
        a2.a = i;
        a2.e = str;
        a(a2);
    }

    public final void a(int i, String str, int i2, int i3) {
        if (i2 == 3) {
            e eVar = new e(i, str, 1, i3);
            if (((l) i(i)) == null) {
                a(new l(i, str, eVar));
                return;
            }
            return;
        }
        a(i, str, i2, i3, null);
    }

    public final void b(int i, Object obj) {
        e i2 = i(i);
        if (i2 != null) {
            i2.d = obj;
        }
    }

    public final void a(int i, String str, int i2, int i3, Object obj) {
        e i4 = i(i);
        if (i4 == null) {
            a(new e(i, str, i2, i3, obj));
            return;
        }
        i4.b = i3;
        i4.c = i2;
        i4.a = i;
        i4.e = str;
        i4.d = obj;
    }

    public final void b(int i, String str, String str2) {
        Object obj;
        if (str2 == null) {
            obj = null;
        } else {
            String str3 = str2;
        }
        a(i, str, new e(0, str, 1, 12, obj));
    }

    public final void b(int i, String str, i iVar) {
        if (iVar == null) {
            a(i, str, new m("null", 0));
            return;
        }
        e a = iVar.a();
        iVar.a((m) a);
        a(i, str, a);
    }

    private void a(int i, String str, e eVar) {
        if (eVar != null) {
            m mVar = (m) i(i);
            if (mVar == null) {
                mVar = new m(i, str, 3, 51, i);
                a((e) mVar);
            }
            mVar.a(eVar);
        }
    }

    public final void a(byte[] bArr) {
        a(6, c.a(bArr));
    }

    public final void b(int i, c cVar) {
        a(i, (Object) cVar);
    }

    public final void a(int i, i iVar) {
        Object obj = null;
        if (iVar != null) {
            obj = iVar.a();
            iVar.a((m) obj);
        }
        a(i, obj);
    }

    private void a(int i, Object obj) {
        ((l) ((m) i(i))).a(i, obj);
    }

    public final boolean o() {
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar != null && eVar.o()) {
                return true;
            }
        }
        return false;
    }

    protected e n() {
        e mVar = new m(this.a, a(), this.c);
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
        mVar.f = arrayList;
        return mVar;
    }

    public final void a(m mVar) {
        this.f = mVar.f;
        this.g = mVar.g;
    }

    private e d(int i, int i2) {
        m mVar = (m) i(i);
        if (mVar != null) {
            return mVar.h(i2);
        }
        return null;
    }

    public final Object c(int i, int i2) {
        e d = d(i, i2);
        if (d != null) {
            return d.c();
        }
        return null;
    }

    public final e h(int i) {
        if (i < this.f.size()) {
            return (e) this.f.get(i);
        }
        return null;
    }

    public final e i(int i) {
        if (i < this.f.size()) {
            return (e) this.f.get(i);
        }
        return null;
    }

    public final int q() {
        return this.f.size();
    }

    public final int j(int i) {
        e i2 = i(i);
        return (i2 == null || !(i2 instanceof m)) ? 0 : ((m) i2).f.size();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        n.a(this, stringBuffer, "", false);
        return stringBuffer.toString();
    }

    public final c a(int i) {
        byte[] g = g(i);
        if (g == null) {
            return null;
        }
        return c.b(g);
    }

    public final long d(int i) {
        e i2 = i(i);
        if (i2 != null) {
            return i2.e();
        }
        return 0;
    }

    public final boolean e(int i) {
        e i2 = i(i);
        if (i2 != null) {
            return i2.j();
        }
        return false;
    }

    void a(e eVar) {
        int i = eVar.a;
        for (int size = this.f.size(); size < i; size++) {
            this.f.add(null);
        }
        if (i <= 0 || i >= this.f.size()) {
            this.f.add(eVar);
        } else {
            this.f.set(i, eVar);
        }
    }
}
