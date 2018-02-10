package com.e.b;

import com.alibaba.analytics.c;
import java.util.Map;

/* compiled from: ProGuard */
final class a implements Runnable {
    final /* synthetic */ Map a;
    final /* synthetic */ b b;

    a(b bVar, Map map) {
        this.b = bVar;
        this.a = map;
    }

    public final void run() {
        try {
            c.a.c(this.a);
        } catch (Throwable th) {
        }
    }
}
