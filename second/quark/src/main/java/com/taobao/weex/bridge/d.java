package com.taobao.weex.bridge;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* compiled from: ProGuard */
public final class d implements a {
    final Method a;
    final boolean b;
    Type[] c = this.a.getGenericParameterTypes();

    public d(Method method, boolean z) {
        this.a = method;
        this.b = z;
    }

    public final Object a(Object obj, Object... objArr) throws InvocationTargetException, IllegalAccessException {
        return this.a.invoke(obj, objArr);
    }

    public final Type[] a() {
        if (this.c == null) {
            this.c = this.a.getGenericParameterTypes();
        }
        return this.c;
    }

    public final boolean b() {
        return this.b;
    }

    public final String toString() {
        return this.a.getName();
    }
}
