package com.ucpro.base.c.b;

import android.content.Context;
import android.view.MotionEvent;

/* compiled from: ProGuard */
public class ab extends g {
    private boolean e = true;

    public ab(Context context) {
        super(context);
    }

    public void setEnableGestureLimited(boolean z) {
        this.e = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.e && motionEvent.getAction() == 0 && !i() && getScrollX() == 0) {
            boolean z;
            if (motionEvent.getX() < ((float) (getWidth() / 6))) {
                z = true;
            } else {
                z = false;
            }
            setEnableSwipeGesture(z);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
