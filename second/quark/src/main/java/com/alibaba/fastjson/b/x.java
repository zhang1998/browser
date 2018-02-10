package com.alibaba.fastjson.b;

/* compiled from: ProGuard */
public final class x {
    public final x a;
    public final Object b;
    public final Object c;
    public final int d;

    public x(x xVar, Object obj, Object obj2, int i) {
        this.a = xVar;
        this.b = obj;
        this.c = obj2;
        this.d = i;
    }

    public final String toString() {
        if (this.a == null) {
            return "$";
        }
        if (this.c instanceof Integer) {
            return this.a.toString() + "[" + this.c + "]";
        }
        return this.a.toString() + "." + this.c;
    }
}
