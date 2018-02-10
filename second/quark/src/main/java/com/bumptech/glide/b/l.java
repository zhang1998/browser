package com.bumptech.glide.b;

import com.bumptech.glide.util.j;

/* compiled from: ProGuard */
public final class l<T> {
    private static final k<Object> e = new j();
    final T a;
    final k<T> b;
    final String c;
    volatile byte[] d;

    public static <T> l<T> a(String str) {
        return new l(str, null, e);
    }

    public static <T> l<T> a(String str, T t) {
        return new l(str, t, e);
    }

    public static <T> l<T> a(String str, T t, k<T> kVar) {
        return new l(str, t, kVar);
    }

    private l(String str, T t, k<T> kVar) {
        this.c = j.a(str);
        this.a = t;
        this.b = (k) j.a((Object) kVar, "Argument must not be null");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        return this.c.equals(((l) obj).c);
    }

    public final int hashCode() {
        return this.c.hashCode();
    }

    public final String toString() {
        return "Option{key='" + this.c + '\'' + '}';
    }
}
