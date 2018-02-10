package com.uc.weex.component.richtext;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import com.taobao.weex.ui.view.a.b;
import com.taobao.weex.ui.view.a.c;

/* compiled from: ProGuard */
final class ac extends View implements c {
    Layout a;
    private b b;

    public ac(Context context) {
        super(context);
    }

    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        if (this.a != null) {
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            try {
                this.a.draw(canvas);
            } catch (Exception e) {
            }
        }
        canvas.restore();
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.b != null) {
            return onTouchEvent | this.b.onTouch(this, motionEvent);
        }
        return onTouchEvent;
    }

    public final void a(b bVar) {
        this.b = bVar;
    }
}
