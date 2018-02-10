package com.taobao.weex.ui.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.EditText;
import com.taobao.weex.common.w;
import com.taobao.weex.ui.view.a.b;
import com.taobao.weex.ui.view.a.c;

/* compiled from: ProGuard */
public final class k extends EditText implements c {
    private b a;
    private int b = 1;

    public k(Context context) {
        super(context);
        if (VERSION.SDK_INT >= 16) {
            setBackground(null);
        } else {
            setBackgroundDrawable(null);
        }
    }

    public final void a(b bVar) {
        this.a = bVar;
    }

    public final void setLines(int i) {
        super.setLines(i);
        this.b = i;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.a != null) {
            onTouchEvent |= this.a.onTouch(this, motionEvent);
        }
        ViewParent parent = getParent();
        if (parent != null) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    if (this.b < getLineCount()) {
                        parent.requestDisallowInterceptTouchEvent(true);
                        break;
                    }
                    break;
                case 1:
                case 3:
                    parent.requestDisallowInterceptTouchEvent(false);
                    break;
            }
        }
        return onTouchEvent;
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i2 < getLayout().getHeight()) {
            setMovementMethod(null);
        } else {
            setMovementMethod(getDefaultMovementMethod());
        }
    }

    public final boolean postDelayed(Runnable runnable, long j) {
        return super.postDelayed(w.a(runnable), j);
    }
}
