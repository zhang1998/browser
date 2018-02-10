package com.bumptech.glide.b.b.a;

/* compiled from: ProGuard */
final class l implements s {
    int a;
    Class<?> b;
    private final m c;

    l(m mVar) {
        this.c = mVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (this.a == lVar.a && this.b == lVar.b) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return "Key{size=" + this.a + "array=" + this.b + '}';
    }

    public final void a() {
        this.c.a(this);
    }

    public final int hashCode() {
        return (this.b != null ? this.b.hashCode() : 0) + (this.a * 31);
    }
}
