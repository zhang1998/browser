package com.uc.weex.e;

import com.uc.weex.a.ah;
import com.uc.weex.f.d;
import com.uc.weex.h.r;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class b {
    public static b a;
    private HashMap<Class, Object> b = new HashMap();

    private synchronized Object a(Class cls) {
        Object obj;
        obj = this.b.get(cls);
        if (obj == null) {
            try {
                obj = cls.newInstance();
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e2) {
            }
            if (obj != null) {
                this.b.put(cls, obj);
            }
        }
        return obj;
    }

    public static r a() {
        return (r) a.a(r.class);
    }

    public static ah b() {
        return (ah) a.a(ah.class);
    }

    public static d c() {
        return (d) a.a(d.class);
    }
}
