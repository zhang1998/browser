package com.raizlabs.android.dbflow.structure.database.transaction;

/* compiled from: ProGuard */
final class n implements Runnable {
    final /* synthetic */ Object a;
    final /* synthetic */ p b;

    n(p pVar, Object obj) {
        this.b = pVar;
        this.a = obj;
    }

    public final void run() {
        this.b.d.a(this.a);
    }
}
