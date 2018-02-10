package com.e.b.c;

import java.util.Hashtable;
import java.util.Map;

/* compiled from: ProGuard */
public final class b {
    private static b b;
    public Map<String, String> a = new Hashtable();

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (b == null) {
                b = new b();
            }
            bVar = b;
        }
        return bVar;
    }

    public final void b() {
        if (this.a.size() > 0) {
            com.e.b.b.a().d().a(new d("PageMapping", 67701, null, null, null, this.a).a());
            this.a.clear();
        }
    }
}
