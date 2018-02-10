package com.uc.base.a.a.a;

import com.uc.base.a.a.a.a.b;
import com.uc.base.a.a.a.a.c;
import com.uc.base.a.a.a.c.a;
import com.uc.base.a.a.a.e.d;
import com.uc.base.a.a.a.e.j;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class h implements l {
    private Map<Class<?>, d> a = new HashMap(20);

    public h() {
        this.a.put(d.class, new j());
        this.a.put(c.class, new b());
        this.a.put(com.uc.base.a.a.a.c.b.class, new a());
        this.a.put(com.uc.base.a.a.a.h.d.class, new com.uc.base.a.a.a.h.b());
    }

    public final d a(Class<?> cls) {
        return (d) this.a.get(cls);
    }
}
