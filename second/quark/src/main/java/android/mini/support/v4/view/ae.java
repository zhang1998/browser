package android.mini.support.v4.view;

import android.view.MotionEvent;

/* compiled from: ProGuard */
class ae extends ad {
    ae() {
    }

    public final int a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    public final int b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    public final float c(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    public final float d(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }
}
