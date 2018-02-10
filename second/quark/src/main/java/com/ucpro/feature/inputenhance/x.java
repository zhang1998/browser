package com.ucpro.feature.inputenhance;

import android.os.SystemClock;
import android.view.MotionEvent;
import com.ucweb.common.util.h.a;

/* compiled from: ProGuard */
final class x extends a {
    final /* synthetic */ int a;
    final /* synthetic */ float b;
    final /* synthetic */ g c;

    x(g gVar, int i, float f) {
        this.c = gVar;
        this.a = i;
        this.b = f;
    }

    public final void run() {
        if (this.a % 2 == 0) {
            this.c.g.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, this.b, (float) (this.c.g.getHeight() / 2), 0));
        } else {
            this.c.g.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, this.b, (float) (this.c.g.getHeight() / 2), 0));
        }
        if (this.a == 3 && this.c.d != null) {
            this.c.d.l();
        }
    }
}
