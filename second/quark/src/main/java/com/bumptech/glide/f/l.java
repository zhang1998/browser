package com.bumptech.glide.f;

import android.support.annotation.Nullable;

/* compiled from: ProGuard */
public final class l implements b, c {
    private b a;
    private b b;
    @Nullable
    private c c;
    private boolean d;

    public l() {
        this(null);
    }

    public l(c cVar) {
        this.c = cVar;
    }

    public final void a(b bVar, b bVar2) {
        this.a = bVar;
        this.b = bVar2;
    }

    public final boolean a(b bVar) {
        boolean z;
        if (this.c == null || this.c.a(this)) {
            z = true;
        } else {
            z = false;
        }
        return z && (bVar.equals(this.a) || !this.a.g());
    }

    public final boolean b(b bVar) {
        boolean z;
        if (this.c == null || this.c.b(this)) {
            z = true;
        } else {
            z = false;
        }
        return z && bVar.equals(this.a) && !a();
    }

    public final boolean a() {
        boolean z;
        if (this.c == null || !this.c.a()) {
            z = false;
        } else {
            z = true;
        }
        if (z || g()) {
            return true;
        }
        return false;
    }

    public final void c(b bVar) {
        if (!bVar.equals(this.b)) {
            if (this.c != null) {
                this.c.c(this);
            }
            if (!this.b.f()) {
                this.b.d();
            }
        }
    }

    public final void b() {
        this.d = true;
        if (!this.b.e()) {
            this.b.b();
        }
        if (this.d && !this.a.e()) {
            this.a.b();
        }
    }

    public final void c() {
        this.d = false;
        this.a.c();
        this.b.c();
    }

    public final void d() {
        this.d = false;
        this.b.d();
        this.a.d();
    }

    public final boolean e() {
        return this.a.e();
    }

    public final boolean f() {
        return this.a.f() || this.b.f();
    }

    public final boolean g() {
        return this.a.g() || this.b.g();
    }

    public final boolean h() {
        return this.a.h();
    }

    public final void i() {
        this.a.i();
        this.b.i();
    }
}
