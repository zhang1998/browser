package com.a.a.a;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public class cv implements c<cv, dt>, Serializable, Cloneable {
    public static final Map<dt, ad> d;
    private static final n e = new n("IdTracking");
    private static final l f = new l("snapshots", (byte) 13, (short) 1);
    private static final l g = new l("journals", (byte) 15, (short) 2);
    private static final l h = new l("checksum", (byte) 11, (short) 3);
    private static final Map<Class<? extends aa>, z> i;
    public Map<String, do> a;
    public List<du> b;
    public String c;
    private dt[] j = new dt[]{dt.JOURNALS, dt.CHECKSUM};

    static {
        Map hashMap = new HashMap();
        i = hashMap;
        hashMap.put(ab.class, new dv());
        i.put(ac.class, new cy());
        hashMap = new EnumMap(dt.class);
        hashMap.put(dt.SNAPSHOTS, new ad("snapshots", (byte) 1, new af(new ah((byte) 11), new ae(do.class))));
        hashMap.put(dt.JOURNALS, new ad("journals", (byte) 2, new ag(new ae(du.class))));
        hashMap.put(dt.CHECKSUM, new ad("checksum", (byte) 2, new ah((byte) 11)));
        d = Collections.unmodifiableMap(hashMap);
        ad.a(cv.class, d);
    }

    public final boolean a() {
        return this.b != null;
    }

    public final void a(boolean z) {
        if (!z) {
            this.b = null;
        }
    }

    public final boolean b() {
        return this.c != null;
    }

    public final void a(t tVar) throws g {
        ((z) i.get(tVar.a())).a().a(tVar, this);
    }

    public final void b(t tVar) throws g {
        ((z) i.get(tVar.a())).a().b(tVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("IdTracking(");
        stringBuilder.append("snapshots:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        if (a()) {
            stringBuilder.append(", ");
            stringBuilder.append("journals:");
            if (this.b == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.b);
            }
        }
        if (b()) {
            stringBuilder.append(", ");
            stringBuilder.append("checksum:");
            if (this.c == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(this.c);
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final void c() throws g {
        if (this.a == null) {
            throw new q("Required field 'snapshots' was not present! Struct: " + toString());
        }
    }
}
