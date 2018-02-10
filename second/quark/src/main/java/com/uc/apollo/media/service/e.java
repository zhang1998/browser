package com.uc.apollo.media.service;

import android.os.IBinder;

/* compiled from: ProGuard */
final class e implements Runnable {
    final /* synthetic */ IBinder a;
    final /* synthetic */ c b;

    e(c cVar, IBinder iBinder) {
        this.b = cVar;
        this.a = iBinder;
    }

    public final void run() {
        c.b(this.a);
    }
}
