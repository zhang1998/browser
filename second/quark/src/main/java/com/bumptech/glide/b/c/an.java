package com.bumptech.glide.b.c;

import com.bumptech.glide.util.l;
import java.util.Queue;

/* compiled from: ProGuard */
public final class an<A> {
    private static final Queue<an<?>> a = l.a(0);
    private int b;
    private int c;
    private A d;

    public static <A> an<A> a(A a) {
        an<A> anVar;
        synchronized (a) {
            anVar = (an) a.poll();
        }
        if (anVar == null) {
            anVar = new an();
        }
        anVar.d = a;
        anVar.c = 0;
        anVar.b = 0;
        return anVar;
    }

    private an() {
    }

    public final void a() {
        synchronized (a) {
            a.offer(this);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof an)) {
            return false;
        }
        an anVar = (an) obj;
        if (this.c == anVar.c && this.b == anVar.b && this.d.equals(anVar.d)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((this.b * 31) + this.c) * 31) + this.d.hashCode();
    }
}
