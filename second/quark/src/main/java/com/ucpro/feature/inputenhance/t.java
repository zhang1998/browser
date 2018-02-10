package com.ucpro.feature.inputenhance;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class t implements OnTouchListener {
    final /* synthetic */ s a;

    t(s sVar) {
        this.a = sVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0 || action == 2) {
            view.setBackgroundColor(a.c("input_enhance_keyword_click_color"));
        } else {
            view.setBackgroundColor(0);
        }
        return false;
    }
}
