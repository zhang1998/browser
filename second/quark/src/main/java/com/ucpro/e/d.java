package com.ucpro.e;

import android.os.Process;

/* compiled from: ProGuard */
public final class d implements Runnable {
    final /* synthetic */ k a;

    public d(k kVar) {
        this.a = kVar;
    }

    public final void run() {
        Process.killProcess(Process.myPid());
    }
}
