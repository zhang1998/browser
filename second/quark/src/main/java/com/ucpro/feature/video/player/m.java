package com.ucpro.feature.video.player;

/* compiled from: ProGuard */
final class m implements Runnable {
    final /* synthetic */ h a;

    m(h hVar) {
        this.a = hVar;
    }

    public final void run() {
        if (this.a.e.i || this.a.e.v || this.a.e.y) {
            this.a.h();
        } else {
            this.a.a(10008, null, null);
        }
    }
}
