package com.bumptech.glide.b.c;

/* compiled from: ProGuard */
final class ah implements af {
    private final String a;

    ah(String str) {
        this.a = str;
    }

    public final String a() {
        return this.a;
    }

    public final String toString() {
        return "StringHeaderFactory{value='" + this.a + '\'' + '}';
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ah)) {
            return false;
        }
        return this.a.equals(((ah) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
