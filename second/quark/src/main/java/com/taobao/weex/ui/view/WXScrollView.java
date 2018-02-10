package com.taobao.weex.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.mini.support.v4.view.ak;
import android.mini.support.v4.view.al;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ScrollView;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.be;
import com.taobao.weex.ui.view.a.b;
import com.taobao.weex.ui.view.a.c;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.w;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public class WXScrollView extends ScrollView implements ak, Callback, c, e {
    int a;
    int b;
    public List<q> c;
    private al d;
    private float e;
    private float f;
    private int[] g;
    private int[] h;
    private b i;
    private be j;
    private View k;
    private boolean l;
    private int m;
    private boolean n;
    @SuppressLint({"HandlerLeak"})
    private Handler o;
    private int p;
    private int q;
    private int[] r;
    private Rect s;
    private int[] t;
    private int[] u;
    private boolean v;
    private int w;
    private int x;
    private boolean y;

    public WXScrollView(Context context) {
        super(context);
        this.g = new int[2];
        this.h = new int[2];
        this.n = true;
        this.q = 100;
        this.r = new int[2];
        this.t = new int[2];
        this.u = new int[2];
        this.v = true;
        this.y = false;
        this.c = new ArrayList();
        b();
        try {
            w.a(this, "mMinimumVelocity", Integer.valueOf(5));
        } catch (Throwable e) {
            WXLogUtils.e("[WXScrollView] WXScrollView: ", e);
        }
    }

    private void b() {
        setWillNotDraw(false);
        c();
        setOverScrollMode(2);
        this.d = new al(this);
        this.d.a(true);
        this.x = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private void c() {
        if (this.o == null) {
            this.o = new Handler(com.taobao.weex.common.w.a((Callback) this));
        }
        this.p = getScrollY();
        this.o.sendEmptyMessageDelayed(0, (long) this.q);
    }

    public WXScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new int[2];
        this.h = new int[2];
        this.n = true;
        this.q = 100;
        this.r = new int[2];
        this.t = new int[2];
        this.u = new int[2];
        this.v = true;
        this.y = false;
        b();
    }

    public WXScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = new int[2];
        this.h = new int[2];
        this.n = true;
        this.q = 100;
        this.r = new int[2];
        this.t = new int[2];
        this.u = new int[2];
        this.v = true;
        this.y = false;
        setOverScrollMode(2);
    }

    public final void a(q qVar) {
        if (!this.c.contains(qVar)) {
            this.c.add(qVar);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent.getAction() == 0) {
            this.l = true;
        }
        if (this.l) {
            this.l = this.k != null;
            if (this.l) {
                if (motionEvent.getY() <= ((float) this.k.getHeight()) && motionEvent.getX() >= ((float) this.k.getLeft()) && motionEvent.getX() <= ((float) this.k.getRight())) {
                    z = true;
                }
                this.l = z;
            }
        }
        if (this.l) {
            if (this.s == null) {
                this.s = new Rect();
                getGlobalVisibleRect(this.s);
            }
            this.k.getLocationOnScreen(this.u);
            motionEvent.offsetLocation(0.0f, (float) (this.u[1] - this.s.top));
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.k != null) {
            canvas.save();
            this.k.getLocationOnScreen(this.r);
            int i = this.m <= 0 ? this.m : 0;
            canvas.translate((float) this.r[0], (float) (getScrollY() + i));
            canvas.clipRect(0, i, this.k.getWidth(), this.k.getHeight());
            this.k.draw(canvas);
            canvas.restore();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.v) {
            return true;
        }
        if (this.l) {
            if (this.s == null) {
                this.s = new Rect();
                getGlobalVisibleRect(this.s);
            }
            this.k.getLocationOnScreen(this.u);
            motionEvent.offsetLocation(0.0f, (float) (-(this.u[1] - this.s.top)));
        }
        if (motionEvent.getAction() == 0) {
            this.n = false;
        }
        if (this.n) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(0);
            this.n = false;
            obtain.recycle();
        }
        if (motionEvent.getAction() == 0) {
            this.e = motionEvent.getX();
            this.f = motionEvent.getY();
            startNestedScroll(3);
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.n = true;
            stopNestedScroll();
        }
        if (motionEvent.getAction() == 2) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (dispatchNestedPreScroll((int) (this.e - x), (int) (this.f - y), this.g, this.h)) {
                motionEvent.setLocation(x + ((float) this.g[0]), y + ((float) this.g[1]));
            }
            this.e = motionEvent.getX();
            this.f = motionEvent.getY();
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.w = (int) motionEvent.getY();
                break;
            case 1:
            case 3:
                if (this.y) {
                    a(false);
                    break;
                }
                break;
            case 2:
                int y2 = (int) motionEvent.getY();
                if (Math.abs(y2 - this.w) > this.x) {
                    if (!this.y) {
                        a(true);
                    }
                    this.y = true;
                    this.w = y2;
                    break;
                }
                break;
        }
        this.y = false;
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.i != null) {
            return onTouchEvent | this.i.onTouch(this, motionEvent);
        }
        return onTouchEvent;
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.d.a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.d.a;
    }

    public boolean startNestedScroll(int i) {
        return this.d.a(i);
    }

    public void stopNestedScroll() {
        this.d.b();
    }

    public boolean hasNestedScrollingParent() {
        return this.d.a();
    }

    public void setScrollable(boolean z) {
        this.v = z;
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.d.a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.d.a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.d.a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.d.a(f, f2);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    public void fling(int i) {
        super.fling(i);
        if (this.o != null) {
            this.o.removeMessages(0);
        }
        c();
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        this.a = getScrollX();
        this.b = getScrollY();
        a(this.a, this.b);
        View childAt = getChildAt(getChildCount() - 1);
        if (childAt != null) {
            int i5;
            int i6;
            if (childAt.getBottom() - (getHeight() + this.b) == 0) {
                int i7;
                if (this.c == null) {
                    i7 = 0;
                } else {
                    i7 = this.c.size();
                }
                for (i5 = 0; i5 < i7; i5++) {
                    this.c.get(i5);
                }
            }
            if (this.c == null) {
                i6 = 0;
            } else {
                i6 = this.c.size();
            }
            for (int i8 = 0; i8 < i6; i8++) {
                ((q) this.c.get(i8)).a(this, i, i2, i3, i4);
            }
            if (this.j != null) {
                Map map = this.j.b;
                if (map != null) {
                    map = (Map) map.get(this.j.getRef());
                    if (map != null) {
                        for (Entry value : map.entrySet()) {
                            ab abVar = (ab) value.getValue();
                            getLocationOnScreen(this.t);
                            abVar.getHostView().getLocationOnScreen(this.u);
                            if (abVar.getParent() == null || abVar.getParent().g_() == null) {
                                i5 = 0;
                            } else {
                                i5 = abVar.getParent().g_().getHeight();
                            }
                            int height = abVar.getHostView().getHeight();
                            i5 = ((-i5) + this.t[1]) + height;
                            if (this.u[1] <= this.t[1] && this.u[1] >= i5 - height) {
                                this.m = this.u[1] - i5;
                                abVar.setStickyOffset(this.u[1] - this.t[1]);
                                childAt = abVar.getHostView();
                                break;
                            }
                            abVar.setStickyOffset(0);
                        }
                    }
                }
                childAt = null;
                if (childAt != null) {
                    this.k = childAt;
                } else {
                    this.k = null;
                }
            }
        }
    }

    private void a(int i, int i2) {
        int size = this.c == null ? 0 : this.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((q) this.c.get(i3)).a(this, i, i2);
        }
    }

    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                if (this.o != null) {
                    this.o.removeMessages(0);
                }
                if (this.p - getScrollY() != 0) {
                    a(getScrollX(), getScrollY());
                    this.p = getScrollY();
                    if (this.o != null) {
                        this.o.sendEmptyMessageDelayed(0, (long) this.q);
                        break;
                    }
                }
                int i;
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (this.c == null) {
                    i = 0;
                } else {
                    i = this.c.size();
                }
                for (int i2 = 0; i2 < i; i2++) {
                    ((q) this.c.get(i2)).b(this, scrollX, scrollY);
                }
                break;
                break;
        }
        return true;
    }

    public final void a() {
        if (this.o != null) {
            this.o.removeCallbacksAndMessages(null);
        }
    }

    public final void a(b bVar) {
        this.i = bVar;
    }

    public Rect getContentFrame() {
        return new Rect(0, 0, computeHorizontalScrollRange(), computeVerticalScrollRange());
    }

    public void setWAScroller(be beVar) {
        this.j = beVar;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int size = this.c == null ? 0 : this.c.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((q) this.c.get(i5)).a(i, i2, i3, i4);
        }
    }

    private void a(boolean z) {
        int size = this.c == null ? 0 : this.c.size();
        for (int i = 0; i < size; i++) {
            ((q) this.c.get(i)).a(z);
        }
    }
}
