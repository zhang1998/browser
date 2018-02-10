package com.ucweb.common.util.h;

import android.util.Log;

/* compiled from: ProGuard */
final class g implements Runnable {
    final /* synthetic */ Throwable a;
    final /* synthetic */ b b;

    g(b bVar, Throwable th) {
        this.b = bVar;
        this.a = th;
    }

    public final void run() {
        throw new RuntimeException(Log.getStackTraceString(this.a), this.a);
    }
}
