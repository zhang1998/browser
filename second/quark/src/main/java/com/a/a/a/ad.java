package com.a.a.a;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class ad implements Serializable {
    private static Map<Class<? extends c>, Map<? extends Object, ad>> d = new HashMap();
    public final String a;
    public final byte b;
    public final ah c;

    public ad(String str, byte b, ah ahVar) {
        this.a = str;
        this.b = b;
        this.c = ahVar;
    }

    public static void a(Class<? extends c> cls, Map<? extends Object, ad> map) {
        d.put(cls, map);
    }
}
