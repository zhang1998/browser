package com.bumptech.glide.b.b.a;

import android.graphics.Bitmap.Config;

/* compiled from: ProGuard */
final class c implements s {
    int a;
    int b;
    Config c;
    private final d d;

    public c(d dVar) {
        this.d = dVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.a == cVar.a && this.b == cVar.b && this.c == cVar.c) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.c != null ? this.c.hashCode() : 0) + (((this.a * 31) + this.b) * 31);
    }

    public final String toString() {
        return e.c(this.a, this.b, this.c);
    }

    public final void a() {
        this.d.a(this);
    }
}
