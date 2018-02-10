package com.uc.apollo.rebound;

import android.os.SystemClock;
import android.view.Choreographer.FrameCallback;

/* compiled from: ProGuard */
final class b implements FrameCallback {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void doFrame(long j) {
        if (this.a.d && this.a.a != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.a.a.a((double) (uptimeMillis - this.a.e));
            this.a.e = uptimeMillis;
            this.a.b.postFrameCallback(this.a.c);
        }
    }
}
