package com.uc.apollo.media.b;

/* compiled from: ProGuard */
public final class b {
    public i[] a;
    public String b;
    public int c;
    public i d;
    public int e;
    public j f;
    public boolean g;
    public int h;
    public long i = 0;

    public final int a() {
        return (c() || this.d == null) ? -1 : this.d.i;
    }

    final void b() {
        this.i = 0;
        this.h = 0;
        this.e = 0;
        this.f = null;
        this.c = 0;
        this.g = false;
        if (this.d == null && this.a != null && this.a.length > 0) {
            this.c = this.a.length - 1;
            while (this.c > 0 && this.a[this.c].d > 1200000) {
                this.c--;
            }
            this.d = this.a[this.c];
        }
        if (this.d != null && this.d.h != null && this.d.h.length > 0) {
            c(0);
        }
    }

    private boolean c(int i) {
        if (this.d.h == null || this.d.h.length == 0 || i >= this.d.h.length) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f != null && currentTimeMillis - this.i < ((long) (this.f.c / 2))) {
            return false;
        }
        this.i = currentTimeMillis;
        this.e = i;
        this.f = this.d.h[this.e];
        this.h = 0;
        return true;
    }

    public final boolean c() {
        return this.d != null ? this.d.a() : false;
    }

    public final int a(int i) {
        if (!(c() || this.f == null)) {
            if (i < this.h) {
                c(this.e + 1);
            }
            this.h = i;
            if (i < this.f.b) {
                i += this.f.a;
            }
            j jVar = this.f;
            if (i > jVar.c + jVar.b) {
                c(this.e + 1);
            }
        }
        return i;
    }

    public final int b(int i) {
        if (this.f == null) {
            return i;
        }
        this.h = 0;
        this.i = 0;
        j jVar = this.f;
        int i2 = this.e;
        if (jVar == null) {
            jVar = this.d.h[0];
            i2 = 0;
        }
        if (!jVar.a(i)) {
            if (jVar.b < i) {
                i2++;
                int length = this.d.h.length;
                while (i2 < length) {
                    if (this.d.h[i2].a(i)) {
                        break;
                    }
                    i2++;
                }
                i2 = this.d.h.length - 1;
            } else {
                i2--;
                while (i2 >= 0) {
                    if (this.d.h[i2].a(i)) {
                        break;
                    }
                    i2--;
                }
                i2 = 0;
            }
        }
        c(i2);
        return this.f.b;
    }

    public final String toString() {
        return a(false);
    }

    public final String a(boolean z) {
        int i = 0;
        if (this.a.length == 1) {
            return this.a[0].a(z);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (i < this.a.length) {
            stringBuilder.append("playlist ").append(i + 1).append("\n").append(this.a[i].a(z)).append('\n');
            i++;
        }
        return stringBuilder.toString();
    }
}
