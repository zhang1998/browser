package com.a.a.a;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public class dr implements c<dr, dq>, Serializable, Cloneable {
    public static final Map<dq, ad> e;
    private static final n f = new n("ImprintValue");
    private static final l g = new l("value", (byte) 11, (short) 1);
    private static final l h = new l("ts", (byte) 10, (short) 2);
    private static final l i = new l("guid", (byte) 11, (short) 3);
    private static final Map<Class<? extends aa>, z> j;
    public String a;
    public long b;
    public String c;
    byte d = (byte) 0;
    private dq[] k = new dq[]{dq.VALUE};

    static {
        Map hashMap = new HashMap();
        j = hashMap;
        hashMap.put(ab.class, new dc());
        j.put(ac.class, new db());
        hashMap = new EnumMap(dq.class);
        hashMap.put(dq.VALUE, new ad("value", (byte) 2, new ah((byte) 11)));
        hashMap.put(dq.TS, new ad("ts", (byte) 1, new ah((byte) 10)));
        hashMap.put(dq.GUID, new ad("guid", (byte) 1, new ah((byte) 11)));
        e = Collections.unmodifiableMap(hashMap);
        ad.a(dr.class, e);
    }

    public final boolean a() {
        return this.a != null;
    }

    public final void b() {
        this.d = (byte) (this.d | 1);
    }

    public final void a(t tVar) throws g {
        ((z) j.get(tVar.a())).a().a(tVar, this);
    }

    public final void b(t tVar) throws g {
        ((z) j.get(tVar.a())).a().b(tVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ImprintValue(");
        Object obj = 1;
        if (a()) {
            stringBuilder.append("value:");
            if (this.a == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.a);
            }
            obj = null;
        }
        if (obj == null) {
            stringBuilder.append(", ");
        }
        stringBuilder.append("ts:");
        stringBuilder.append(this.b);
        stringBuilder.append(", ");
        stringBuilder.append("guid:");
        if (this.c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.c);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final void c() throws g {
        if (this.c == null) {
            throw new q("Required field 'guid' was not present! Struct: " + toString());
        }
    }
}
