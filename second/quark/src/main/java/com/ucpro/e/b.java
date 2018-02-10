package com.ucpro.e;

import android.content.IntentFilter;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ k a;

    b(k kVar) {
        this.a = kVar;
    }

    public final void run() {
        try {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            this.a.h = new n(this);
            this.a.a.getApplicationContext().registerReceiver(this.a.h, intentFilter);
        } catch (Throwable th) {
            th.getMessage();
            th.getCause();
        }
    }
}
