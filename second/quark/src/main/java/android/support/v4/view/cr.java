package android.support.v4.view;

import android.view.MotionEvent;

/* compiled from: ProGuard */
class cr extends au {
    cr() {
    }

    public final int b(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    public final int c(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    public final float d(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    public final float e(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }

    public final int a(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }
}
