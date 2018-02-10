package com.uc.weex.component.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.taobao.weex.ui.view.listview.WXRecyclerView;

/* compiled from: ProGuard */
public final class a extends com.taobao.weex.ui.view.refresh.wrapper.a {
    private b b;

    public final /* synthetic */ View a(Context context) {
        return b(context);
    }

    public a(Context context, int i, int i2, int i3, b bVar, boolean z) {
        super(context, i, i2, (float) i3, i3, z);
        this.b = bVar;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 0:
            case 5:
                if (!this.b.getDomObject().c_().contains("touchStart")) {
                    if (this.b.getDomObject().c_().contains("touchstart")) {
                        this.b.getInstance().a(this.b.getDomObject().b_(), "touchstart", null);
                        break;
                    }
                }
                this.b.getInstance().a(this.b.getDomObject().b_(), "touchStart", null);
                break;
                break;
        }
        return onInterceptTouchEvent;
    }

    public final WXRecyclerView b(Context context) {
        WXRecyclerView fVar = new f(context);
        fVar.a(1, 1, getOrientation());
        return fVar;
    }
}
