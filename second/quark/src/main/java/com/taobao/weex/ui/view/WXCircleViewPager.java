package com.taobao.weex.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.mini.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Interpolator;
import com.taobao.weex.ui.view.a.b;
import com.taobao.weex.ui.view.a.c;
import com.taobao.weex.utils.WXLogUtils;
import java.lang.reflect.Field;

@SuppressLint({"HandlerLeak"})
/* compiled from: ProGuard */
public class WXCircleViewPager extends ViewPager implements c {
    public boolean o;
    public Runnable p = new j();
    private b q;
    private long r = 3000;
    private r s;
    private boolean t = true;
    private boolean u = true;
    private int v = 0;

    static /* synthetic */ void c(WXCircleViewPager wXCircleViewPager) {
        if (!wXCircleViewPager.t && super.getCurrentItem() == wXCircleViewPager.getRealCount() - 1) {
            return;
        }
        if (wXCircleViewPager.getRealCount() == 2 && super.getCurrentItem() == 1) {
            wXCircleViewPager.b(0, true);
        } else {
            wXCircleViewPager.b(super.getCurrentItem() + 1, true);
        }
    }

    @SuppressLint({"NewApi"})
    public WXCircleViewPager(Context context) {
        super(context);
        i();
    }

    private void i() {
        setOverScrollMode(2);
        a(new i(this));
        if (!isInEditMode()) {
            try {
                Field declaredField = ViewPager.class.getDeclaredField("d");
                declaredField.setAccessible(true);
                Field declaredField2 = ViewPager.class.getDeclaredField("a");
                declaredField2.setAccessible(true);
                this.s = new r(getContext(), (Interpolator) declaredField2.get(null));
                declaredField.set(this, this.s);
            } catch (Throwable e) {
                WXLogUtils.e("[CircleViewPager] postInitViewPager: ", e);
            }
        }
    }

    @SuppressLint({"NewApi"})
    public WXCircleViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i();
    }

    public int getCurrentItem() {
        return getRealCurrentItem();
    }

    public final int e() {
        return super.getCurrentItem();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.u) {
            return true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.q != null) {
            return onTouchEvent | this.q.onTouch(this, motionEvent);
        }
        return onTouchEvent;
    }

    public void scrollTo(int i, int i2) {
        if (this.u || this.v != 1) {
            super.scrollTo(i, i2);
        }
    }

    public final void f() {
        this.o = true;
        removeCallbacks(this.p);
        postDelayed(this.p, this.r);
    }

    public final void g() {
        this.o = false;
        removeCallbacks(this.p);
    }

    public void setCurrentItem(int i) {
        setRealCurrentItem(i);
    }

    public h getCirclePageAdapter() {
        return (h) getAdapter();
    }

    public void setCirclePageAdapter(h hVar) {
        setAdapter(hVar);
    }

    public long getIntervalTime() {
        return this.r;
    }

    public void setIntervalTime(long j) {
        this.r = j;
    }

    public void setCircle(boolean z) {
        this.t = z;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 2:
                removeCallbacks(this.p);
                break;
            case 1:
            case 3:
                if (this.o) {
                    postDelayed(this.p, this.r);
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public static void h() {
    }

    public final void a(b bVar) {
        this.q = bVar;
    }

    public int getRealCurrentItem() {
        return ((h) getAdapter()).a(super.getCurrentItem());
    }

    private void setRealCurrentItem(int i) {
        b(((h) getAdapter()).e() + i, false);
    }

    private void b(int i, boolean z) {
        try {
            super.a(i, z);
        } catch (IllegalStateException e) {
            WXLogUtils.e(e.toString());
            if (getAdapter() != null) {
                getAdapter().b();
                super.a(i, z);
            }
        }
    }

    public int getRealCount() {
        return ((h) getAdapter()).c();
    }

    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (IllegalStateException e) {
            WXLogUtils.e(e.toString());
            if (getAdapter() != null) {
                getAdapter().b();
                super.onMeasure(i, i2);
            }
        }
    }

    public void setScrollable(boolean z) {
        this.u = z;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.p);
    }
}
