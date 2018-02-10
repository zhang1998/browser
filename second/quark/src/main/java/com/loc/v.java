package com.loc;

import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public abstract class v {
    @ae(a = "a1", b = 6)
    String a;
    @ae(a = "b2", b = 2)
    protected int b = -1;
    @ae(a = "b1", b = 6)
    protected String c;
    @ae(a = "b3", b = 2)
    protected int d = 1;

    public static String b(String str) {
        Map hashMap = new HashMap();
        hashMap.put("b1", str);
        return n.a(hashMap);
    }

    public static String c(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("b2=").append(i);
        } catch (Throwable th) {
        }
        return stringBuilder.toString();
    }

    public final int a() {
        return this.b;
    }

    public final void a(int i) {
        this.b = i;
    }

    public final void a(String str) {
        this.c = str;
    }

    public final String b() {
        return this.c;
    }

    public final void b(int i) {
        this.d = i;
    }

    public final int c() {
        return this.d;
    }
}
