package android.support.v4.app;

import android.support.v4.view.ViewCompat;

/* compiled from: ProGuard */
final class ca implements Runnable {
    final /* synthetic */ bz a;

    ca(bz bzVar) {
        this.a = bzVar;
    }

    public final void run() {
        ViewCompat.a(this.a.c, 2, null);
    }
}
