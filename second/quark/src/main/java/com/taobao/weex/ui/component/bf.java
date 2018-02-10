package com.taobao.weex.ui.component;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: ProGuard */
final class bf implements OnTouchListener {
    final /* synthetic */ GestureDetector a;
    final /* synthetic */ bk b;

    bf(bk bkVar, GestureDetector gestureDetector) {
        this.b = bkVar;
        this.a = gestureDetector;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.a.onTouchEvent(motionEvent);
    }
}
