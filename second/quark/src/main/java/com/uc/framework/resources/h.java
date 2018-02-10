package com.uc.framework.resources;

import java.lang.ref.PhantomReference;

/* compiled from: ProGuard */
final class h extends PhantomReference<Object> {
    public String a;
    public long b;
    public h c;
    public h d;

    public h(String str, Object obj, long j) {
        super(obj, j.f);
        this.a = str;
        this.b = j;
    }
}
