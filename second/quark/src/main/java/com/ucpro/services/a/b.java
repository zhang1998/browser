package com.ucpro.services.a;

import java.util.HashMap;

/* compiled from: ProGuard */
public final class b {
    public static final String a = com.ucweb.common.util.p.b.A;
    public static final String b = com.ucweb.common.util.p.b.j;
    public static final String c = com.ucweb.common.util.p.b.k;
    public static final String d = com.ucweb.common.util.p.b.t;
    public static final String e = com.ucweb.common.util.p.b.n;
    public static final String f = com.ucweb.common.util.p.b.i;
    public static final String g = com.ucweb.common.util.p.b.s;
    public static final String h = com.ucweb.common.util.p.b.o;
    public static final String i = com.ucweb.common.util.p.b.v;
    public static final String j = com.ucweb.common.util.p.b.r;
    private static HashMap<String, String[]> k;

    static {
        HashMap hashMap = new HashMap();
        k = hashMap;
        hashMap.put("56DB53DAD2D33272456868E88138FD31", new String[]{"56DB53DAD2D33272456868E88138FD31", d});
        k.put("ECC3F137B865BDEDBB09172B0652773C", new String[]{"ECC3F137B865BDEDBB09172B0652773C"});
        k.put("F2C1B9D490D098C810590705D2149EAA", new String[]{"F2C1B9D490D098C810590705D2149EAA"});
        k.put("D151BC40C4C713DF534AD9EA65BD62BF", new String[]{a, d});
    }

    public static String[] a(String str) {
        if (k.containsKey(str)) {
            return (String[]) k.get(str);
        }
        return new String[0];
    }
}
