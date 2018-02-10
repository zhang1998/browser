package com.a.a.a;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public class do implements c<do, di>, Serializable, Cloneable {
    public static final Map<di, ad> e;
    private static final n f = new n("IdSnapshot");
    private static final l g = new l("identity", (byte) 11, (short) 1);
    private static final l h = new l("ts", (byte) 10, (short) 2);
    private static final l i = new l("version", (byte) 8, (short) 3);
    private static final Map<Class<? extends aa>, z> j;
    public String a;
    public long b;
    public int c;
    byte d = (byte) 0;

    static {
        Map hashMap = new HashMap();
        j = hashMap;
        hashMap.put(ab.class, new cq());
        j.put(ac.class, new dm());
        hashMap = new EnumMap(di.class);
        hashMap.put(di.IDENTITY, new ad("identity", (byte) 1, new ah((byte) 11)));
        hashMap.put(di.TS, new ad("ts", (byte) 1, new ah((byte) 10)));
        hashMap.put(di.VERSION, new ad("version", (byte) 1, new ah((byte) 8)));
        e = Collections.unmodifiableMap(hashMap);
        ad.a(do.class, e);
    }

    public final void a() {
        this.d = (byte) (this.d | 1);
    }

    public final void b() {
        this.d = (byte) (this.d | 2);
    }

    public final void a(t tVar) throws g {
        ((z) j.get(tVar.a())).a().a(tVar, this);
    }

    public final void b(t tVar) throws g {
        ((z) j.get(tVar.a())).a().b(tVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IdSnapshot(");
        stringBuilder.append("identity:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("ts:");
        stringBuilder.append(this.b);
        stringBuilder.append(", ");
        stringBuilder.append("version:");
        stringBuilder.append(this.c);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final void c() throws g {
        if (this.a == null) {
            throw new q("Required field 'identity' was not present! Struct: " + toString());
        }
    }
}
