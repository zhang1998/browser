package com.taobao.weex.d;

import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class a {
    String a;
    String b;
    byte[] c;
    b d;
    int e;
    private Map<String, String> f = new HashMap();

    public final a a(String str, String str2) {
        this.f.put(str, str2);
        return this;
    }

    public final c a() {
        return new c(this.a, this.b, this.f, this.c, this.d, this.e);
    }
}
