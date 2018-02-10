package com.a.a.a;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public class du implements c<du, dj>, Serializable, Cloneable {
    public static final Map<dj, ad> f;
    private static final n g = new n("IdJournal");
    private static final l h = new l("domain", (byte) 11, (short) 1);
    private static final l i = new l("old_id", (byte) 11, (short) 2);
    private static final l j = new l("new_id", (byte) 11, (short) 3);
    private static final l k = new l("ts", (byte) 10, (short) 4);
    private static final Map<Class<? extends aa>, z> l;
    public String a;
    public String b;
    public String c;
    public long d;
    byte e = (byte) 0;
    private dj[] m = new dj[]{dj.OLD_ID};

    static {
        Map hashMap = new HashMap();
        l = hashMap;
        hashMap.put(ab.class, new de());
        l.put(ac.class, new dp());
        hashMap = new EnumMap(dj.class);
        hashMap.put(dj.DOMAIN, new ad("domain", (byte) 1, new ah((byte) 11)));
        hashMap.put(dj.OLD_ID, new ad("old_id", (byte) 2, new ah((byte) 11)));
        hashMap.put(dj.NEW_ID, new ad("new_id", (byte) 1, new ah((byte) 11)));
        hashMap.put(dj.TS, new ad("ts", (byte) 1, new ah((byte) 10)));
        f = Collections.unmodifiableMap(hashMap);
        ad.a(du.class, f);
    }

    public final boolean a() {
        return this.b != null;
    }

    public final void b() {
        this.e = (byte) (this.e | 1);
    }

    public final void a(t tVar) throws g {
        ((z) l.get(tVar.a())).a().a(tVar, this);
    }

    public final void b(t tVar) throws g {
        ((z) l.get(tVar.a())).a().b(tVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IdJournal(");
        stringBuilder.append("domain:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        if (a()) {
            stringBuilder.append(", ");
            stringBuilder.append("old_id:");
            if (this.b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.b);
            }
        }
        stringBuilder.append(", ");
        stringBuilder.append("new_id:");
        if (this.c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("ts:");
        stringBuilder.append(this.d);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final void c() throws g {
        if (this.a == null) {
            throw new q("Required field 'domain' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new q("Required field 'new_id' was not present! Struct: " + toString());
        }
    }
}
