package com.c.a;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

/* compiled from: ProGuard */
final class e extends SimpleOnGestureListener {
    final /* synthetic */ q a;

    e(q qVar) {
        this.a = qVar;
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (this.a.d == 1) {
            return false;
        }
        for (x a : this.a.b) {
            a.a(motionEvent);
        }
        return true;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.a.d == 1) {
            return false;
        }
        if (this.a.a == null) {
            return true;
        }
        this.a.a.a(f / this.a.k, f2 / this.a.k);
        return true;
    }
}
