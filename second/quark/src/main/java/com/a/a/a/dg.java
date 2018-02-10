package com.a.a.a;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public class dg implements c<dg, dd>, Serializable, Cloneable {
    public static final Map<dd, ad> e;
    private static final n f = new n("Response");
    private static final l g = new l("resp_code", (byte) 8, (short) 1);
    private static final l h = new l("msg", (byte) 11, (short) 2);
    private static final l i = new l("imprint", (byte) 12, (short) 3);
    private static final Map<Class<? extends aa>, z> j;
    public int a;
    public String b;
    public dx c;
    byte d = (byte) 0;
    private dd[] k = new dd[]{dd.MSG, dd.IMPRINT};

    static {
        Map hashMap = new HashMap();
        j = hashMap;
        hashMap.put(ab.class, new df());
        j.put(ac.class, new cs());
        hashMap = new EnumMap(dd.class);
        hashMap.put(dd.RESP_CODE, new ad("resp_code", (byte) 1, new ah((byte) 8)));
        hashMap.put(dd.MSG, new ad("msg", (byte) 2, new ah((byte) 11)));
        hashMap.put(dd.IMPRINT, new ad("imprint", (byte) 2, new ae(dx.class)));
        e = Collections.unmodifiableMap(hashMap);
        ad.a(dg.class, e);
    }

    public final void a() {
        this.d = (byte) (this.d | 1);
    }

    public final boolean b() {
        return this.b != null;
    }

    public final boolean c() {
        return this.c != null;
    }

    public final void a(t tVar) throws g {
        ((z) j.get(tVar.a())).a().a(tVar, this);
    }

    public final void b(t tVar) throws g {
        ((z) j.get(tVar.a())).a().b(tVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Response(");
        stringBuilder.append("resp_code:");
        stringBuilder.append(this.a);
        if (b()) {
            stringBuilder.append(", ");
            stringBuilder.append("msg:");
            if (this.b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.b);
            }
        }
        if (c()) {
            stringBuilder.append(", ");
            stringBuilder.append("imprint:");
            if (this.c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.c);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final void d() throws g {
        if (this.c != null) {
            this.c.c();
        }
    }
}
