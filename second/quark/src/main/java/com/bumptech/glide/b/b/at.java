package com.bumptech.glide.b.b;

import android.support.v4.d.q;
import com.bumptech.glide.util.a.f;
import com.bumptech.glide.util.a.h;
import com.bumptech.glide.util.a.i;
import com.bumptech.glide.util.a.j;

/* compiled from: ProGuard */
final class at<Z> implements au<Z>, f {
    private static final q<at<?>> a = h.a(20, new as());
    private final j b = new i();
    private au<Z> c;
    private boolean d;
    private boolean e;

    static <Z> at<Z> a(au<Z> auVar) {
        at<Z> atVar = (at) a.a();
        atVar.e = false;
        atVar.d = true;
        atVar.c = auVar;
        return atVar;
    }

    at() {
    }

    public final synchronized void e() {
        this.b.a();
        if (this.d) {
            this.d = false;
            if (this.e) {
                d();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    public final Class<Z> a() {
        return this.c.a();
    }

    public final Z b() {
        return this.c.b();
    }

    public final int c() {
        return this.c.c();
    }

    public final synchronized void d() {
        this.b.a();
        this.e = true;
        if (!this.d) {
            this.c.d();
            this.c = null;
            a.a(this);
        }
    }

    public final j m_() {
        return this.b;
    }
}
