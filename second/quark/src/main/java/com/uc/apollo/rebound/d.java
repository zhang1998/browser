package com.uc.apollo.rebound;

import com.uc.apollo.util.ReflectUtil;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
public final class d implements e {
    private Object a;
    private Method b;
    private Method c;

    public static e a(Object obj) {
        e dVar = new d(obj);
        if (dVar.a()) {
            return dVar;
        }
        return null;
    }

    private d(Object obj) {
        this.a = obj;
    }

    private boolean a() {
        try {
            Class cls = this.a.getClass();
            this.b = ReflectUtil.getMethod2(cls, "onSpringUpdate", Long.TYPE);
            this.c = ReflectUtil.getMethod2(cls, "onSpringAtRest", new Class[0]);
            return true;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    public final void onSpringUpdate(Spring spring) {
        long round = Math.round(spring.getCurrentValue());
        ReflectUtil.call(Void.TYPE, this.a, this.b, Long.valueOf(round));
    }

    public final void onSpringAtRest(Spring spring) {
        ReflectUtil.call(Void.TYPE, this.a, this.c, new Object[0]);
    }

    public final void onSpringActivate(Spring spring) {
    }

    public final void onSpringEndStateChange(Spring spring) {
    }
}
