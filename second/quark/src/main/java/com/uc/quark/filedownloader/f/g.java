package com.uc.quark.filedownloader.f;

import java.io.IOException;

/* compiled from: ProGuard */
final class g implements l {
    public final o a = new o();
    public final a b;
    boolean c;
    private Object d;
    private long e;

    g(a aVar) {
        if (aVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.b = aVar;
    }

    public final o a() {
        return this.a;
    }

    public final void a(o oVar, long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a(oVar, j);
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        o oVar2 = this.a;
        long j2 = oVar2.b;
        if (j2 == 0) {
            j2 = 0;
        } else {
            n nVar = oVar2.a.g;
            if (nVar.c < 2097152 && nVar.e) {
                j2 -= (long) (nVar.c - nVar.b);
            }
        }
        if (j2 > 0) {
            this.b.a(this.a, j2);
        }
    }

    public final l b() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        long j = this.a.b;
        if (j > 0) {
            this.b.a(this.a, j);
        }
        return this;
    }

    public final void a(Object obj) {
        this.d = obj;
    }

    public final Object c() {
        return this.d;
    }

    public final void a(long j) {
        this.e = j;
    }

    public final long d() {
        return this.e;
    }

    public final void flush() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.a.b > 0) {
            this.b.a(this.a, this.a.b);
        }
        this.b.flush();
    }

    public final void close() throws IOException {
        if (!this.c) {
            Throwable th = null;
            try {
                if (this.a.b > 0) {
                    this.b.a(this.a, this.a.b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.c = true;
            if (th != null) {
                e.a(th);
            }
        }
    }

    public final String toString() {
        return "buffer(" + this.b + ")";
    }
}
