package com.alibaba.appmonitor.e;

import com.alibaba.analytics.core.c.a.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class b {
    private static b b = new b();
    private Map<Class<? extends a>, d<? extends a>> a = new HashMap();

    public static b a() {
        return b;
    }

    private b() {
    }

    public final <T extends a> T a(Class<T> cls, Object... objArr) {
        d a = a((Class) cls);
        d.c.getAndIncrement();
        a.a.getAndIncrement();
        T t = (a) a.e.poll();
        if (t != null) {
            a.f.remove(Integer.valueOf(System.identityHashCode(t)));
            a.b.getAndIncrement();
            d.d.getAndIncrement();
        }
        if (t == null) {
            try {
                t = (a) cls.newInstance();
            } catch (Throwable e) {
                c.a(com.alibaba.analytics.core.c.a.b.b, e);
            }
        }
        if (t != null) {
            t.a(objArr);
        }
        return t;
    }

    public final <T extends a> void a(T t) {
        if (t != null) {
            d a = a(t.getClass());
            t.a();
            if (a.e.size() < 20) {
                synchronized (a.f) {
                    int identityHashCode = System.identityHashCode(t);
                    if (!a.f.contains(Integer.valueOf(identityHashCode))) {
                        a.f.add(Integer.valueOf(identityHashCode));
                        a.e.offer(t);
                    }
                }
            }
        }
    }

    private synchronized <T extends a> d<T> a(Class<T> cls) {
        d<T> dVar;
        dVar = (d) this.a.get(cls);
        if (dVar == null) {
            dVar = new d();
            this.a.put(cls, dVar);
        }
        return dVar;
    }
}
