package com.bumptech.glide.f;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.bumptech.glide.f.a.g;
import com.bumptech.glide.util.l;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: ProGuard */
public final class e<R> implements a<R>, Runnable {
    private static final d a = new d();
    private final Handler b;
    private final int c;
    private final int d;
    private final boolean e;
    private final d f;
    @Nullable
    private R g;
    @Nullable
    private b h;
    private boolean i;
    private boolean j;
    private boolean k;

    public e(Handler handler, int i, int i2) {
        this(handler, i, i2, a);
    }

    private e(Handler handler, int i, int i2, d dVar) {
        this.b = handler;
        this.c = i;
        this.d = i2;
        this.e = true;
        this.f = dVar;
    }

    public final synchronized boolean cancel(boolean z) {
        boolean z2 = true;
        synchronized (this) {
            if (isDone()) {
                z2 = false;
            } else {
                this.i = true;
                notifyAll();
                if (z) {
                    this.b.post(this);
                }
            }
        }
        return z2;
    }

    public final synchronized boolean isCancelled() {
        return this.i;
    }

    public final synchronized boolean isDone() {
        boolean z;
        z = this.i || this.j;
        return z;
    }

    public final R get() throws InterruptedException, ExecutionException {
        try {
            return a(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    public final R get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return a(Long.valueOf(timeUnit.toMillis(j)));
    }

    public final void a(g gVar) {
        gVar.a(this.c, this.d);
    }

    public final void b(g gVar) {
    }

    public final void a(@Nullable b bVar) {
        this.h = bVar;
    }

    @Nullable
    public final b d() {
        return this.h;
    }

    public final void a(Drawable drawable) {
    }

    public final void b(Drawable drawable) {
    }

    public final synchronized void c(Drawable drawable) {
        this.k = true;
        notifyAll();
    }

    public final synchronized void a(R r) {
        this.j = true;
        this.g = r;
        notifyAll();
    }

    private synchronized R a(Long l) throws ExecutionException, InterruptedException, TimeoutException {
        R r;
        if (this.e && !isDone()) {
            l.b();
        }
        if (this.i) {
            throw new CancellationException();
        } else if (this.k) {
            throw new ExecutionException(new IllegalStateException("Load failed"));
        } else if (this.j) {
            r = this.g;
        } else {
            if (l == null) {
                wait(0);
            } else if (l.longValue() > 0) {
                wait(l.longValue());
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            } else if (this.k) {
                throw new ExecutionException(new IllegalStateException("Load failed"));
            } else if (this.i) {
                throw new CancellationException();
            } else if (this.j) {
                r = this.g;
            } else {
                throw new TimeoutException();
            }
        }
        return r;
    }

    public final void run() {
        if (this.h != null) {
            this.h.d();
            this.h = null;
        }
    }

    public final void a() {
    }

    public final void b() {
    }

    public final void c() {
    }
}
