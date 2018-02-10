package com.taobao.weex.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.mini.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.taobao.weex.ui.component.ae;
import com.taobao.weex.ui.view.a.b;
import com.taobao.weex.ui.view.a.c;
import com.taobao.weex.utils.WXViewUtils;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public class l extends FrameLayout implements a<ae>, c {
    public WeakReference<ae> a;
    private b b;

    public l(Context context) {
        super(context);
    }

    public final void a(b bVar) {
        this.b = bVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.b != null) {
            return onTouchEvent | this.b.onTouch(this, motionEvent);
        }
        return onTouchEvent;
    }

    public void onDraw(Canvas canvas) {
        WXViewUtils.a((View) this, canvas);
        super.onDraw(canvas);
    }

    @Nullable
    public ae getComponent() {
        return this.a != null ? (ae) this.a.get() : null;
    }
}
