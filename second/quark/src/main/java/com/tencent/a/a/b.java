package com.tencent.a.a;

/* compiled from: ProGuard */
public final class b {
    protected static b a;

    protected b() {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b();
            }
            bVar = a;
        }
        return bVar;
    }
}
