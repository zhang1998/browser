package com.tencent.wxop.stat;

import android.content.Context;

final class w implements Runnable {
    final /* synthetic */ Context a;

    w(Context context) {
        this.a = context;
    }

    public final void run() {
        try {
            new Thread(new ac(this.a), "NetworkMonitorTask").start();
        } catch (Throwable th) {
            ah.q.b(th);
            ah.a(this.a, th);
        }
    }
}
