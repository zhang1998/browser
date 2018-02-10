package com.alibaba.appmonitor.f;

import com.alibaba.fastjson.e;

/* compiled from: ProGuard */
public class i extends e {
    public int a;
    public double b;

    public final synchronized void a(double d, Long l) {
        this.b += d;
        this.a++;
        super.c(l);
    }

    public final synchronized e b() {
        e b;
        b = super.b();
        b.a("count", Integer.valueOf(this.a));
        b.a("value", Double.valueOf(this.b));
        return b;
    }

    public final synchronized void a(Object... objArr) {
        super.a(objArr);
        this.b = 0.0d;
        this.a = 0;
    }
}
