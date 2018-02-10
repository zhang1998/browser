package android.mini.support.v4.app;

import android.mini.support.v4.view.ViewCompat;

/* compiled from: ProGuard */
final class y implements Runnable {
    final /* synthetic */ z a;

    y(z zVar) {
        this.a = zVar;
    }

    public final void run() {
        ViewCompat.a(this.a.c, 0, null);
    }
}
