package com.bumptech.glide.b.b.a;

import com.bumptech.glide.util.l;
import java.util.Queue;

/* compiled from: ProGuard */
abstract class f<T extends s> {
    private final Queue<T> a = l.a(20);

    protected abstract T a();

    f() {
    }

    protected final T b() {
        s sVar = (s) this.a.poll();
        if (sVar == null) {
            return a();
        }
        return sVar;
    }

    public final void a(T t) {
        if (this.a.size() < 20) {
            this.a.offer(t);
        }
    }
}
