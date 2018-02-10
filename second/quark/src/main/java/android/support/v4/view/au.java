package android.support.v4.view;

import android.view.MotionEvent;

/* compiled from: ProGuard */
class au implements bv {
    au() {
    }

    public int b(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return 0;
        }
        return -1;
    }

    public int c(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return 0;
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float d(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getX();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public float e(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getY();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public int a(MotionEvent motionEvent) {
        return 1;
    }

    public int b(MotionEvent motionEvent) {
        return 0;
    }

    public float a(MotionEvent motionEvent, int i) {
        return 0.0f;
    }
}
