package com.uc.weex.component.c.a;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: ProGuard */
public final class b extends n {
    protected b() {
    }

    public final boolean a(View view, MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent.getHistorySize() == 0) {
            return false;
        }
        float x = motionEvent.getX(0) - motionEvent.getHistoricalX(0, 0);
        if (Math.abs(x) < Math.abs(motionEvent.getY(0) - motionEvent.getHistoricalY(0, 0))) {
            return false;
        }
        this.a = view.getTranslationX();
        this.b = x;
        if (this.b > 0.0f) {
            z = true;
        }
        this.c = z;
        return true;
    }
}
