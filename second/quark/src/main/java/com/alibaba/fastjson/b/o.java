package com.alibaba.fastjson.b;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.d;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: ProGuard */
public final class o {
    public final y a;
    public final aa b;
    protected List<d> c;
    protected List<a> d;
    protected List<v> e;
    protected List<ac> f;
    protected List<s> g;
    protected List<w> h;
    protected IdentityHashMap<Object, x> i;
    protected x j;
    public TimeZone k;
    public Locale l;
    private int m;
    private String n;
    private DateFormat o;

    public o() {
        this(new aa(a.e, z.y), y.a);
    }

    public o(aa aaVar, y yVar) {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.m = 0;
        this.i = null;
        this.k = a.a;
        this.l = a.b;
        this.b = aaVar;
        this.a = yVar;
        this.k = a.a;
    }

    public final DateFormat a() {
        if (this.o == null && this.n != null) {
            this.o = new SimpleDateFormat(this.n, this.l);
            this.o.setTimeZone(this.k);
        }
        return this.o;
    }

    public final void a(x xVar, Object obj, Object obj2) {
        if ((this.b.c & z.DisableCircularReferenceDetect.x) == 0) {
            this.j = new x(xVar, obj, obj2, 0);
            if (this.i == null) {
                this.i = new IdentityHashMap();
            }
            this.i.put(obj, this.j);
        }
    }

    public final void a(Object obj) {
        x xVar = this.j;
        if (obj == xVar.b) {
            this.b.write("{\"$ref\":\"@\"}");
            return;
        }
        x xVar2 = xVar.a;
        if (xVar2 == null || obj != xVar2.b) {
            while (xVar.a != null) {
                xVar = xVar.a;
            }
            if (obj == xVar.b) {
                this.b.write("{\"$ref\":\"$\"}");
                return;
            }
            String xVar3 = ((x) this.i.get(obj)).toString();
            this.b.write("{\"$ref\":\"");
            this.b.write(xVar3);
            this.b.write("\"}");
            return;
        }
        this.b.write("{\"$ref\":\"..\"}");
    }

    public final void b() {
        this.m++;
    }

    public final void c() {
        this.m--;
    }

    public final void d() {
        this.b.write(10);
        for (int i = 0; i < this.m; i++) {
            this.b.write(9);
        }
    }

    public final String toString() {
        return this.b.toString();
    }

    public final void b(Object obj) {
        if (obj == null) {
            this.b.write("null");
            return;
        }
        try {
            this.a.a(obj.getClass()).a(this, obj, null, null);
        } catch (Throwable e) {
            throw new d(e.getMessage(), e);
        }
    }

    public final void a(String str) {
        if (str == null) {
            if ((this.b.c & z.WriteNullStringAsEmpty.x) != 0) {
                this.b.a("");
            } else {
                this.b.write("null");
            }
        } else if ((this.b.c & z.UseSingleQuotes.x) != 0) {
            this.b.b(str);
        } else {
            this.b.a(str, '\u0000', true);
        }
    }

    public static Object a(o oVar, Object obj, Object obj2) {
        List<ac> list = oVar.f;
        if (list != null) {
            if (!(obj == null || (obj instanceof String))) {
                a.a(obj);
            }
            for (ac a : list) {
                obj2 = a.a();
            }
        }
        return obj2;
    }

    public final Object c(Object obj) {
        List<s> list = this.g;
        if (list != null) {
            if (!(obj == null || (obj instanceof String))) {
                obj = a.a(obj);
            }
            for (s a : list) {
                obj = a.a();
            }
        }
        return obj;
    }

    public final boolean d(Object obj) {
        List<w> list = this.h;
        if (list == null) {
            return true;
        }
        for (w wVar : list) {
            if (!(obj == null || (obj instanceof String))) {
                obj = a.a(obj);
            }
            if (!wVar.a()) {
                return false;
            }
        }
        return true;
    }

    public final boolean e(Object obj) {
        List<v> list = this.e;
        if (list == null) {
            return true;
        }
        if (!(obj == null || (obj instanceof String))) {
            a.a(obj);
        }
        for (v a : list) {
            if (!a.a()) {
                return false;
            }
        }
        return true;
    }
}
