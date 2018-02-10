package com.alibaba.appmonitor.f;

import com.alibaba.appmonitor.e.a;
import com.alibaba.appmonitor.e.b;

/* compiled from: ProGuard */
public abstract class e implements a {
    public String e;
    public String f;
    public String g;
    public int h;
    public long i = Long.MAX_VALUE;
    public long j = 0;

    public com.alibaba.fastjson.e b() {
        com.alibaba.fastjson.e eVar = (com.alibaba.fastjson.e) b.a().a(com.alibaba.appmonitor.e.e.class, new Object[0]);
        eVar.a("page", this.e);
        eVar.a("monitorPoint", this.f);
        eVar.a("begin", Long.valueOf(this.i));
        eVar.a("end", Long.valueOf(this.j));
        if (this.g != null) {
            eVar.a("arg", this.g);
        }
        return eVar;
    }

    public void a() {
        this.h = 0;
        this.e = null;
        this.f = null;
        this.g = null;
        this.i = Long.MAX_VALUE;
        this.j = 0;
    }

    public void a(Object... objArr) {
        this.h = ((Integer) objArr[0]).intValue();
        this.e = (String) objArr[1];
        this.f = (String) objArr[2];
        if (objArr.length > 3 && objArr[3] != null) {
            this.g = (String) objArr[3];
        }
        System.currentTimeMillis();
    }

    public final void c(Long l) {
        if (l == null) {
            l = Long.valueOf(System.currentTimeMillis() / 1000);
        }
        if (this.i > l.longValue()) {
            this.i = l.longValue();
        }
        if (this.j < l.longValue()) {
            this.j = l.longValue();
        }
    }
}
