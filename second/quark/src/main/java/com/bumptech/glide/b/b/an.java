package com.bumptech.glide.b.b;

import android.os.Looper;
import com.bumptech.glide.b.i;
import com.bumptech.glide.util.j;

/* compiled from: ProGuard */
public final class an<Z> implements au<Z> {
    final boolean a;
    am b;
    i c;
    private int d;
    private boolean e;
    private final au<Z> f;

    public an(au<Z> auVar, boolean z) {
        this.f = (au) j.a((Object) auVar, "Argument must not be null");
        this.a = z;
    }

    public final Class<Z> a() {
        return this.f.a();
    }

    public final Z b() {
        return this.f.b();
    }

    public final int c() {
        return this.f.c();
    }

    public final void d() {
        if (this.d > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (this.e) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        } else {
            this.e = true;
            this.f.d();
        }
    }

    public final void e() {
        if (this.e) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            this.d++;
        } else {
            throw new IllegalThreadStateException("Must call acquire on the main thread");
        }
    }

    public final void f() {
        if (this.d <= 0) {
            throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
        } else if (Looper.getMainLooper().equals(Looper.myLooper())) {
            int i = this.d - 1;
            this.d = i;
            if (i == 0) {
                this.b.b(this.c, this);
            }
        } else {
            throw new IllegalThreadStateException("Must call release on the main thread");
        }
    }

    public final String toString() {
        return "EngineResource{isCacheable=" + this.a + ", listener=" + this.b + ", key=" + this.c + ", acquired=" + this.d + ", isRecycled=" + this.e + ", resource=" + this.f + '}';
    }
}
