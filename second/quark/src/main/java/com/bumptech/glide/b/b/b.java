package com.bumptech.glide.b.b;

import com.bumptech.glide.b.i;
import java.security.MessageDigest;

/* compiled from: ProGuard */
final class b implements i {
    private final i b;
    private final i c;

    public b(i iVar, i iVar2) {
        this.b = iVar;
        this.c = iVar2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.b.equals(bVar.b) && this.c.equals(bVar.c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.b.hashCode() * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "DataCacheKey{sourceKey=" + this.b + ", signature=" + this.c + '}';
    }

    public final void a(MessageDigest messageDigest) {
        this.b.a(messageDigest);
        this.c.a(messageDigest);
    }
}
