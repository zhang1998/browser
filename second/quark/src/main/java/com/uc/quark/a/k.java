package com.uc.quark.a;

import android.util.Log;

/* compiled from: ProGuard */
final class k implements Runnable {
    final /* synthetic */ Throwable a;
    final /* synthetic */ h b;

    k(h hVar, Throwable th) {
        this.b = hVar;
        this.a = th;
    }

    public final void run() {
        throw new RuntimeException(Log.getStackTraceString(this.a), this.a);
    }
}
