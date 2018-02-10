package com.taobao.weex.ui.view;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.ToggleButton;
import com.taobao.weex.ui.view.a.b;
import com.taobao.weex.ui.view.a.c;

/* compiled from: ProGuard */
public final class s extends ToggleButton implements c {
    private b a;

    public s(Context context) {
        super(context);
        setGravity(16);
    }

    public final void a(b bVar) {
        this.a = bVar;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.a != null) {
            return onTouchEvent | this.a.onTouch(this, motionEvent);
        }
        return onTouchEvent;
    }
}
