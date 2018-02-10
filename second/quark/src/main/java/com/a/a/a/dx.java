package com.a.a.a;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public class dx implements c<dx, dw>, Serializable, Cloneable {
    public static final Map<dw, ad> e;
    private static final n f = new n("Imprint");
    private static final l g = new l("property", (byte) 13, (short) 1);
    private static final l h = new l("version", (byte) 8, (short) 2);
    private static final l i = new l("checksum", (byte) 11, (short) 3);
    private static final Map<Class<? extends aa>, z> j;
    public Map<String, dr> a;
    public int b;
    public String c;
    byte d = (byte) 0;

    static {
        Map hashMap = new HashMap();
        j = hashMap;
        hashMap.put(ab.class, new ct());
        j.put(ac.class, new cu());
        hashMap = new EnumMap(dw.class);
        hashMap.put(dw.PROPERTY, new ad("property", (byte) 1, new af(new ah((byte) 11), new ae(dr.class))));
        hashMap.put(dw.VERSION, new ad("version", (byte) 1, new ah((byte) 8)));
        hashMap.put(dw.CHECKSUM, new ad("checksum", (byte) 1, new ah((byte) 11)));
        e = Collections.unmodifiableMap(hashMap);
        ad.a(dx.class, e);
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
        StringBuilder stringBuilder = new StringBuilder("Imprint(");
        stringBuilder.append("property:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("version:");
        stringBuilder.append(this.b);
        stringBuilder.append(", ");
        stringBuilder.append("checksum:");
        if (this.c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.c);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final void c() throws g {
        if (this.a == null) {
            throw new q("Required field 'property' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new q("Required field 'checksum' was not present! Struct: " + toString());
        }
    }
}
