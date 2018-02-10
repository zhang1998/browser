package com.uc.weex.component.c.a;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: ProGuard */
public final class s extends n {
    protected s() {
    }

    public final boolean a(View view, MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent.getHistorySize() == 0) {
            return false;
        }
        float y = motionEvent.getY(0) - motionEvent.getHistoricalY(0, 0);
        if (Math.abs(motionEvent.getX(0) - motionEvent.getHistoricalX(0, 0)) > Math.abs(y)) {
            return false;
        }
        this.a = view.getTranslationY();
        this.b = y;
        if (this.b > 0.0f) {
            z = true;
        }
        this.c = z;
        return true;
    }
}
