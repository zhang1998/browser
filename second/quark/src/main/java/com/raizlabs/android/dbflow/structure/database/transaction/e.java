package com.raizlabs.android.dbflow.structure.database.transaction;

/* compiled from: ProGuard */
final class e implements Runnable {
    final /* synthetic */ Throwable a;
    final /* synthetic */ g b;

    e(g gVar, Throwable th) {
        this.b = gVar;
        this.a = th;
    }

    public final void run() {
        this.b.a.a(this.b, this.a);
    }
}
