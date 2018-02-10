package com.bumptech.glide.g;

import com.bumptech.glide.b.i;
import com.bumptech.glide.util.j;
import java.security.MessageDigest;

/* compiled from: ProGuard */
public final class b implements i {
    private final Object b;

    public b(Object obj) {
        this.b = j.a(obj, "Argument must not be null");
    }

    public final String toString() {
        return "ObjectKey{object=" + this.b + '}';
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        return this.b.equals(((b) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final void a(MessageDigest messageDigest) {
        messageDigest.update(this.b.toString().getBytes(a));
    }
}
