package com.tencent.a.b;

/* compiled from: ProGuard */
public final class c implements Cloneable {
    long a = 101010256;

    public final boolean equals(Object obj) {
        return obj != null && (obj instanceof c) && this.a == ((c) obj).a;
    }

    public final int hashCode() {
        return (int) this.a;
    }
}
