package com.uc.apollo.media.service;

import android.os.Process;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ BnMediaPlayerService b;

    b(BnMediaPlayerService bnMediaPlayerService, int i) {
        this.b = bnMediaPlayerService;
        this.a = i;
    }

    public final void run() {
        this.b.c;
        new StringBuilder("suicide, max wait time ").append(this.a).append(" ...");
        if (this.b.j.booleanValue()) {
            synchronized (BnMediaPlayerService.class) {
                if (this.b.j.booleanValue()) {
                    try {
                        BnMediaPlayerService.class.wait((long) this.a);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
        this.b.c;
        Process.killProcess(Process.myPid());
    }
}
