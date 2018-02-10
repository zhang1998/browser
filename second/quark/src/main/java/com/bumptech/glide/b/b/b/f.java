package com.bumptech.glide.b.b.b;

import java.util.ArrayDeque;
import java.util.Queue;

/* compiled from: ProGuard */
final class f {
    final Queue<e> a = new ArrayDeque();

    f() {
    }

    final e a() {
        synchronized (this.a) {
            e eVar = (e) this.a.poll();
        }
        if (eVar == null) {
            return new e();
        }
        return eVar;
    }
}
