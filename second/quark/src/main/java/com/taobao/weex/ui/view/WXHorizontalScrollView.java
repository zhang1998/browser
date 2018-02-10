package com.taobao.weex.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import com.taobao.weex.common.w;
import com.taobao.weex.ui.view.a.b;
import com.taobao.weex.ui.view.a.c;

/* compiled from: ProGuard */
public class WXHorizontalScrollView extends HorizontalScrollView implements c, e {
    private b a;
    private m b;
    private boolean c = true;

    public boolean postDelayed(Runnable runnable, long j) {
        return super.postDelayed(w.a(runnable), j);
    }

    public WXHorizontalScrollView(Context context) {
        super(context);
        b();
    }

    private void b() {
        setWillNotDraw(false);
        setOverScrollMode(2);
    }

    public WXHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.b != null) {
            this.b.a(i, i2, i3, i4);
        }
    }

    public void setScrollViewListener(m mVar) {
        this.b = mVar;
    }

    public final void a() {
    }

    public final void a(b bVar) {
        this.a = bVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.c) {
            return true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.a != null) {
            return onTouchEvent | this.a.onTouch(this, motionEvent);
        }
        return onTouchEvent;
    }

    public void setScrollable(boolean z) {
        this.c = z;
    }
}
