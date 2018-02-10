package com.bumptech.glide.b.c;

import com.bumptech.glide.b.m;
import com.bumptech.glide.g.b;

/* compiled from: ProGuard */
public final class t<Data> implements aq<String, Data> {
    private final p<Data> a;

    public final /* synthetic */ ap a(Object obj, int i, int i2, m mVar) {
        String str = (String) obj;
        return new ap(new b(str), new q(str, this.a));
    }

    public final /* synthetic */ boolean a(Object obj) {
        return ((String) obj).startsWith("data:image");
    }

    public t(p<Data> pVar) {
        this.a = pVar;
    }
}
