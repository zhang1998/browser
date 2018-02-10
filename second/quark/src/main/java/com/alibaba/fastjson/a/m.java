package com.alibaba.fastjson.a;

import java.lang.reflect.Type;

/* compiled from: ProGuard */
public final class m {
    public Object a;
    public final m b;
    public final Object c;
    public Type d;

    public m(m mVar, Object obj, Object obj2) {
        this.b = mVar;
        this.a = obj;
        this.c = obj2;
    }

    public final String toString() {
        if (this.b == null) {
            return "$";
        }
        if (this.c instanceof Integer) {
            return this.b.toString() + "[" + this.c + "]";
        }
        return this.b.toString() + "." + this.c;
    }
}
