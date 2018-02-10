package com.uc.apollo.app;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ PlayerActivity a;

    b(PlayerActivity playerActivity) {
        this.a = playerActivity;
    }

    public final void run() {
        this.a.finish();
    }
}
