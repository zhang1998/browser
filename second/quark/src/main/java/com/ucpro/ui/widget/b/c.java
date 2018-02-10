package com.ucpro.ui.widget.b;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ e a;

    c(e eVar) {
        this.a = eVar;
    }

    public final void run() {
        this.a.invalidate();
    }
}
