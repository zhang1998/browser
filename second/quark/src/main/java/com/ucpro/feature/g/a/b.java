package com.ucpro.feature.g.a;

import android.os.SystemClock;
import com.ucweb.common.util.e;

/* compiled from: ProGuard */
public abstract class b {
    volatile Object a = new Object();
    final long b;
    long c;
    private final long d;
    private e e = new a(this, "CountDownTimer");

    public abstract void a(long j);

    public abstract void c();

    public b(long j) {
        this.d = j;
        this.b = 1000;
    }

    public final void a() {
        this.e.removeMessages(1);
    }

    public final synchronized b b() {
        b bVar;
        if (this.d <= 0) {
            c();
            bVar = this;
        } else {
            this.c = SystemClock.elapsedRealtime() + this.d;
            this.e.sendMessage(this.e.obtainMessage(1));
            bVar = this;
        }
        return bVar;
    }
}
