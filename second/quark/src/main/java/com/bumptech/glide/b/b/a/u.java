package com.bumptech.glide.b.b.a;

import android.graphics.Bitmap.Config;
import com.bumptech.glide.util.l;

/* compiled from: ProGuard */
final class u implements s {
    int a;
    Config b;
    private final v c;

    public u(v vVar) {
        this.c = vVar;
    }

    public final void a() {
        this.c.a(this);
    }

    public final String toString() {
        return w.a(this.a, this.b);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        if (this.a == uVar.a && l.a(this.b, uVar.b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.b != null ? this.b.hashCode() : 0) + (this.a * 31);
    }
}
