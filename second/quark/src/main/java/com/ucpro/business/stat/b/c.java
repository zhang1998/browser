package com.ucpro.business.stat.b;

import java.util.HashMap;

/* compiled from: ProGuard */
public final class c {
    private static c b;
    public HashMap<String, Long> a = new HashMap();

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (b == null) {
                b = new c();
            }
            cVar = b;
        }
        return cVar;
    }

    private c() {
    }
}
