package com.bumptech.glide.b.b;

import com.bumptech.glide.b.i;
import com.bumptech.glide.b.m;
import com.bumptech.glide.b.p;
import com.bumptech.glide.util.g;
import com.bumptech.glide.util.l;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: ProGuard */
final class aw implements i {
    private static final g<Class<?>, byte[]> b = new g(50);
    private final i c;
    private final i d;
    private final int e;
    private final int f;
    private final Class<?> g;
    private final m h;
    private final p<?> i;

    public aw(i iVar, i iVar2, int i, int i2, p<?> pVar, Class<?> cls, m mVar) {
        this.c = iVar;
        this.d = iVar2;
        this.e = i;
        this.f = i2;
        this.i = pVar;
        this.g = cls;
        this.h = mVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof aw)) {
            return false;
        }
        aw awVar = (aw) obj;
        if (this.f == awVar.f && this.e == awVar.e && l.a(this.i, awVar.i) && this.g.equals(awVar.g) && this.c.equals(awVar.c) && this.d.equals(awVar.d) && this.h.equals(awVar.h)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (((((this.c.hashCode() * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f;
        if (this.i != null) {
            hashCode = (hashCode * 31) + this.i.hashCode();
        }
        return (((hashCode * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public final void a(MessageDigest messageDigest) {
        byte[] array = ByteBuffer.allocate(8).putInt(this.e).putInt(this.f).array();
        this.d.a(messageDigest);
        this.c.a(messageDigest);
        messageDigest.update(array);
        if (this.i != null) {
            this.i.a(messageDigest);
        }
        this.h.a(messageDigest);
        array = (byte[]) b.b(this.g);
        if (array == null) {
            array = this.g.getName().getBytes(a);
            b.b(this.g, array);
        }
        messageDigest.update(array);
    }

    public final String toString() {
        return "ResourceCacheKey{sourceKey=" + this.c + ", signature=" + this.d + ", width=" + this.e + ", height=" + this.f + ", decodedResourceClass=" + this.g + ", transformation='" + this.i + '\'' + ", options=" + this.h + '}';
    }
}
