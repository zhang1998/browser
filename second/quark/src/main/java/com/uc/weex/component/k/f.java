package com.uc.weex.component.k;

import android.content.Context;
import android.mini.support.v4.view.ViewPager;
import android.mini.support.v4.view.ao;
import android.view.MotionEvent;

/* compiled from: ProGuard */
final class f extends ViewPager {
    boolean o = true;

    public f(Context context) {
        super(context);
        setAdapter(new e(this));
    }

    public final e e() {
        return (e) super.getAdapter();
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.o && super.onInterceptTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.o) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public final /* bridge */ /* synthetic */ ao getAdapter() {
        return (e) super.getAdapter();
    }
}
