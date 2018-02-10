package com.bumptech.glide.util;

/* compiled from: ProGuard */
public final class i {
    private Class<?> a;
    private Class<?> b;
    private Class<?> c;

    public i(Class<?> cls, Class<?> cls2) {
        a(cls, cls2, null);
    }

    public i(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        a(cls, cls2, cls3);
    }

    public final void a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.a = cls;
        this.b = cls2;
        this.c = cls3;
    }

    public final String toString() {
        return "MultiClassKey{first=" + this.a + ", second=" + this.b + '}';
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (!this.a.equals(iVar.a)) {
            return false;
        }
        if (!this.b.equals(iVar.b)) {
            return false;
        }
        if (l.a(this.c, iVar.c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.c != null ? this.c.hashCode() : 0) + (((this.a.hashCode() * 31) + this.b.hashCode()) * 31);
    }
}
