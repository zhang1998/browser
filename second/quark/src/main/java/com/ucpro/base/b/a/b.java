package com.ucpro.base.b.a;

import com.bumptech.glide.b.c.ac;
import com.bumptech.glide.b.c.ap;
import com.bumptech.glide.b.c.aq;
import com.bumptech.glide.b.m;
import java.io.InputStream;
import okhttp3.Call.Factory;

/* compiled from: ProGuard */
public final class b implements aq<ac, InputStream> {
    private final Factory a;

    public final /* synthetic */ ap a(Object obj, int i, int i2, m mVar) {
        ac acVar = (ac) obj;
        return new ap(acVar, new c(this.a, acVar));
    }

    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        return true;
    }

    public b(Factory factory) {
        this.a = factory;
    }
}
