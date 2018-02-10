package com.c.a;

/* compiled from: ProGuard */
final class af implements Runnable {
    float a;
    final /* synthetic */ f b;

    private af(f fVar) {
        this.b = fVar;
    }

    public final void run() {
        for (ac acVar : this.b.c.b) {
            acVar.e = this.a;
            acVar.a();
        }
    }
}
