package com.a.a.a;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public class bn implements c<bn, bj>, Serializable, Cloneable {
    public static final Map<bj, ad> l;
    private static final n m = new n("UMEnvelope");
    private static final l n = new l("version", (byte) 11, (short) 1);
    private static final l o = new l("address", (byte) 11, (short) 2);
    private static final l p = new l("signature", (byte) 11, (short) 3);
    private static final l q = new l("serial_num", (byte) 8, (short) 4);
    private static final l r = new l("ts_secs", (byte) 8, (short) 5);
    private static final l s = new l("length", (byte) 8, (short) 6);
    private static final l t = new l("entity", (byte) 11, (short) 7);
    private static final l u = new l("guid", (byte) 11, (short) 8);
    private static final l v = new l("checksum", (byte) 11, (short) 9);
    private static final l w = new l("codex", (byte) 8, (short) 10);
    private static final Map<Class<? extends aa>, z> x;
    public String a;
    public String b;
    public String c;
    public int d;
    public int e;
    public int f;
    public ByteBuffer g;
    public String h;
    public String i;
    public int j;
    byte k = (byte) 0;
    private bj[] y = new bj[]{bj.CODEX};

    static {
        Map hashMap = new HashMap();
        x = hashMap;
        hashMap.put(ab.class, new bm());
        x.put(ac.class, new bk());
        hashMap = new EnumMap(bj.class);
        hashMap.put(bj.VERSION, new ad("version", (byte) 1, new ah((byte) 11)));
        hashMap.put(bj.ADDRESS, new ad("address", (byte) 1, new ah((byte) 11)));
        hashMap.put(bj.SIGNATURE, new ad("signature", (byte) 1, new ah((byte) 11)));
        hashMap.put(bj.SERIAL_NUM, new ad("serial_num", (byte) 1, new ah((byte) 8)));
        hashMap.put(bj.TS_SECS, new ad("ts_secs", (byte) 1, new ah((byte) 8)));
        hashMap.put(bj.LENGTH, new ad("length", (byte) 1, new ah((byte) 8)));
        hashMap.put(bj.ENTITY, new ad("entity", (byte) 1, new ah((byte) 11, true)));
        hashMap.put(bj.GUID, new ad("guid", (byte) 1, new ah((byte) 11)));
        hashMap.put(bj.CHECKSUM, new ad("checksum", (byte) 1, new ah((byte) 11)));
        hashMap.put(bj.CODEX, new ad("codex", (byte) 2, new ah((byte) 8)));
        l = Collections.unmodifiableMap(hashMap);
        ad.a(bn.class, l);
    }

    public final void a() {
        this.k = (byte) (this.k | 1);
    }

    public final void b() {
        this.k = (byte) (this.k | 2);
    }

    public final void c() {
        this.k = (byte) (this.k | 4);
    }

    public final boolean d() {
        return f.a(this.k, 3);
    }

    public final void e() {
        this.k = (byte) (this.k | 8);
    }

    public final void a(t tVar) throws g {
        ((z) x.get(tVar.a())).a().a(tVar, this);
    }

    public final void b(t tVar) throws g {
        ((z) x.get(tVar.a())).a().b(tVar, this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("UMEnvelope(");
        stringBuilder.append("version:");
        if (this.a == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.a);
        }
        stringBuilder.append(", ");
        stringBuilder.append("address:");
        if (this.b == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.b);
        }
        stringBuilder.append(", ");
        stringBuilder.append("signature:");
        if (this.c == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.c);
        }
        stringBuilder.append(", ");
        stringBuilder.append("serial_num:");
        stringBuilder.append(this.d);
        stringBuilder.append(", ");
        stringBuilder.append("ts_secs:");
        stringBuilder.append(this.e);
        stringBuilder.append(", ");
        stringBuilder.append("length:");
        stringBuilder.append(this.f);
        stringBuilder.append(", ");
        stringBuilder.append("entity:");
        if (this.g == null) {
            stringBuilder.append("null");
        } else {
            d.a(this.g, stringBuilder);
        }
        stringBuilder.append(", ");
        stringBuilder.append("guid:");
        if (this.h == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.h);
        }
        stringBuilder.append(", ");
        stringBuilder.append("checksum:");
        if (this.i == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(this.i);
        }
        if (d()) {
            stringBuilder.append(", ");
            stringBuilder.append("codex:");
            stringBuilder.append(this.j);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final void f() throws g {
        if (this.a == null) {
            throw new q("Required field 'version' was not present! Struct: " + toString());
        } else if (this.b == null) {
            throw new q("Required field 'address' was not present! Struct: " + toString());
        } else if (this.c == null) {
            throw new q("Required field 'signature' was not present! Struct: " + toString());
        } else if (this.g == null) {
            throw new q("Required field 'entity' was not present! Struct: " + toString());
        } else if (this.h == null) {
            throw new q("Required field 'guid' was not present! Struct: " + toString());
        } else if (this.i == null) {
            throw new q("Required field 'checksum' was not present! Struct: " + toString());
        }
    }
}
