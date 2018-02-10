package com.bumptech.glide.b.b.c;

import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy.Builder;

/* compiled from: ProGuard */
final class b extends Thread {
    final /* synthetic */ c a;

    b(c cVar, Runnable runnable, String str) {
        this.a = cVar;
        super(runnable, str);
    }

    public final void run() {
        Process.setThreadPriority(9);
        if (this.a.b) {
            StrictMode.setThreadPolicy(new Builder().detectNetwork().penaltyDeath().build());
        }
        try {
            super.run();
        } catch (Throwable th) {
            this.a.a.a(th);
        }
    }
}
