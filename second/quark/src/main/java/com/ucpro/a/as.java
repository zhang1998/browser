package com.ucpro.a;

import android.os.Message;

/* compiled from: ProGuard */
final class as implements Runnable {
    final /* synthetic */ Message a;
    final /* synthetic */ am b;

    as(am amVar, Message message) {
        this.b = amVar;
        this.a = message;
    }

    public final void run() {
        am.a(this.b, (int[]) this.a.obj);
    }
}
