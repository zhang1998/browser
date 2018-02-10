package com.bumptech.glide.b.b;

import com.bumptech.glide.b.i;
import com.bumptech.glide.b.m;
import com.bumptech.glide.b.p;
import com.bumptech.glide.util.j;
import java.security.MessageDigest;
import java.util.Map;

/* compiled from: ProGuard */
public final class ak implements i {
    private final Object b;
    private final int c;
    private final int d;
    private final Class<?> e;
    private final Class<?> f;
    private final i g;
    private final Map<Class<?>, p<?>> h;
    private final m i;
    private int j;

    public ak(Object obj, i iVar, int i, int i2, Map<Class<?>, p<?>> map, Class<?> cls, Class<?> cls2, m mVar) {
        this.b = j.a(obj, "Argument must not be null");
        this.g = (i) j.a((Object) iVar, "Signature must not be null");
        this.c = i;
        this.d = i2;
        this.h = (Map) j.a((Object) map, "Argument must not be null");
        this.e = (Class) j.a((Object) cls, "Resource class must not be null");
        this.f = (Class) j.a((Object) cls2, "Transcode class must not be null");
        this.i = (m) j.a((Object) mVar, "Argument must not be null");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ak)) {
            return false;
        }
        ak akVar = (ak) obj;
        if (this.b.equals(akVar.b) && this.g.equals(akVar.g) && this.d == akVar.d && this.c == akVar.c && this.h.equals(akVar.h) && this.e.equals(akVar.e) && this.f.equals(akVar.f) && this.i.equals(akVar.i)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (this.j == 0) {
            this.j = this.b.hashCode();
            this.j = (this.j * 31) + this.g.hashCode();
            this.j = (this.j * 31) + this.c;
            this.j = (this.j * 31) + this.d;
            this.j = (this.j * 31) + this.h.hashCode();
            this.j = (this.j * 31) + this.e.hashCode();
            this.j = (this.j * 31) + this.f.hashCode();
            this.j = (this.j * 31) + this.i.hashCode();
        }
        return this.j;
    }

    public final String toString() {
        return "EngineKey{model=" + this.b + ", width=" + this.c + ", height=" + this.d + ", resourceClass=" + this.e + ", transcodeClass=" + this.f + ", signature=" + this.g + ", hashCode=" + this.j + ", transformations=" + this.h + ", options=" + this.i + '}';
    }

    public final void a(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
