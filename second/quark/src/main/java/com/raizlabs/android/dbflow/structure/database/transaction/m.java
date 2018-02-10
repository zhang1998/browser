package com.raizlabs.android.dbflow.structure.database.transaction;

import java.util.List;

/* compiled from: ProGuard */
final class m implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ p b;

    m(p pVar, List list) {
        this.b = pVar;
        this.a = list;
    }

    public final void run() {
        this.b.c.a(this.a);
    }
}
