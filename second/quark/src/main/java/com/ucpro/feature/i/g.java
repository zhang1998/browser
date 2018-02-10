package com.ucpro.feature.i;

import android.app.Activity;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
final class g implements Runnable {
    WeakReference<Activity> a;
    final /* synthetic */ d b;

    private g(d dVar) {
        this.b = dVar;
    }

    public final void run() {
        if (this.a.get() != null) {
            this.b.c((Activity) this.a.get());
        }
    }
}
