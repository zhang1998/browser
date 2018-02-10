package com.ucpro.feature.bookmarkhis.b;

import java.util.List;

/* compiled from: ProGuard */
final class m implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ d b;

    m(d dVar, List list) {
        this.b = dVar;
        this.a = list;
    }

    public final void run() {
        if (this.a != null) {
            e.a(this.b.a, this.a);
        }
    }
}
