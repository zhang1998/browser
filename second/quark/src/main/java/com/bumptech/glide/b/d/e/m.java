package com.bumptech.glide.b.d.e;

import com.bumptech.glide.b.i;
import java.security.MessageDigest;
import java.util.UUID;

/* compiled from: ProGuard */
final class m implements i {
    private final UUID b;

    public m() {
        this(UUID.randomUUID());
    }

    private m(UUID uuid) {
        this.b = uuid;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m) {
            return ((m) obj).b.equals(this.b);
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final void a(MessageDigest messageDigest) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
