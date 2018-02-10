package com.uc.weex.component.h;

import android.content.Context;
import android.graphics.Canvas;
import com.taobao.weex.ui.view.l;

/* compiled from: ProGuard */
public final class t extends l {
    private u b;

    public t(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public final void setSVGDrawable(u uVar) {
        this.b = uVar;
    }

    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.b != null) {
            this.b.a(canvas);
        }
    }
}
