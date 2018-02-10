package com.bumptech.glide.b.a;

import com.bumptech.glide.util.j;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class h {
    private static final d<?> b = new f();
    private final Map<Class<?>, d<?>> a = new HashMap();

    public final synchronized void a(d<?> dVar) {
        this.a.put(dVar.a(), dVar);
    }

    public final synchronized <T> e<T> a(T t) {
        d dVar;
        j.a((Object) t, "Argument must not be null");
        dVar = (d) this.a.get(t.getClass());
        if (dVar == null) {
            for (d dVar2 : this.a.values()) {
                if (dVar2.a().isAssignableFrom(t.getClass())) {
                    dVar = dVar2;
                    break;
                }
            }
        }
        if (dVar == null) {
            dVar = b;
        }
        return dVar.a(t);
    }
}
