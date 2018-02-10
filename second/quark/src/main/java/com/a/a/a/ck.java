package com.a.a.a;

import android.os.Looper;

/* compiled from: ProGuard */
final class ck implements Runnable {
    final /* synthetic */ bx a;

    ck(bx bxVar) {
        this.a = bxVar;
    }

    public final void run() {
        Looper.prepare();
        if (this.a.e == null) {
            this.a.e = new cf(this.a);
        }
        bx bxVar = this.a;
        long currentTimeMillis = System.currentTimeMillis();
        bxVar.e.sendEmptyMessageDelayed(48, ce.a(currentTimeMillis, 1001));
        bxVar.e.sendEmptyMessageDelayed(49, ce.a(currentTimeMillis, 1002));
    }
}
