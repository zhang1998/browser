package com.taobao.weex.ui.view.refresh.core;

import android.animation.ValueAnimator;
import android.content.Context;
import android.mini.support.v4.view.NestedScrollingParent;
import android.mini.support.v4.view.ViewCompat;
import android.mini.support.v4.view.am;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public class WXSwipeLayout extends FrameLayout implements NestedScrollingParent {
    public boolean a;
    public WXRefreshView b;
    public volatile boolean c = false;
    public int d = -1;
    public boolean e = false;
    private am f;
    private m g;
    private l h;
    private WXRefreshView i;
    private View j;
    private boolean k = false;
    private boolean l = false;
    private volatile float m = 0.0f;
    private volatile float n = 0.0f;
    private volatile float o = 0.0f;
    private volatile float p = 0.0f;
    private int q;
    private int r;
    private int s;

    public WXSwipeLayout(Context context) {
        super(context);
        a(null);
    }

    public WXSwipeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public WXSwipeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        if (getChildCount() > 1) {
            throw new RuntimeException("WXSwipeLayout should not have more than one child");
        }
        this.f = new am(this);
        if (!isInEditMode() || attributeSet != null) {
            this.q = 0;
            this.r = 0;
            this.s = -65536;
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.j = getChildAt(0);
        if (this.b == null) {
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 0);
            this.b = new WXRefreshView(getContext());
            this.b.a(0.0f, 0.75f);
            this.b.setBackgroundColor(this.q);
            this.b.setProgressBgColor(this.r);
            this.b.setProgressColor(this.s);
            this.b.setContentGravity(80);
            addView(this.b, layoutParams);
        }
        if (this.i == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, 0);
            layoutParams.gravity = 80;
            this.i = new WXRefreshView(getContext());
            this.i.a(0.5f, 1.25f);
            this.i.setBackgroundColor(this.q);
            this.i.setProgressBgColor(this.r);
            this.i.setProgressColor(this.s);
            this.i.setContentGravity(48);
            addView(this.i, layoutParams);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.k || this.l) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return true;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f.a = i;
    }

    public void onStopNestedScroll(View view) {
        this.f.a = 0;
        if (!this.a) {
            c();
        }
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        double d = 0.01d;
        if ((this.k || this.l) && !this.a) {
            int measuredHeight = view.getMeasuredHeight();
            double abs = ((((double) (((float) measuredHeight) - Math.abs(view.getY()))) / 1.0d) / ((double) measuredHeight)) * 0.4000000059604645d;
            if (abs > 0.01d) {
                d = abs;
            }
            int i3 = (int) (d * ((double) i2));
            if (!this.e) {
                if (i3 < 0 && !f()) {
                    this.d = 0;
                    this.e = true;
                } else if (i3 > 0 && !g()) {
                    this.d = 1;
                    this.e = true;
                }
            }
            i3 = a(-i3, i2);
            if (i3 > 0) {
                iArr[1] = i3 + iArr[1];
            }
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
    }

    public int getNestedScrollAxes() {
        return this.f.a;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(int r7, int r8) {
        /*
        r6 = this;
        r3 = 1;
        r5 = -1;
        r2 = 0;
        r0 = r6.c;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r2;
    L_0x0008:
        r1 = r6.f();
        r0 = r6.b;
        r0 = r0.getLayoutParams();
        r0 = (android.widget.FrameLayout.LayoutParams) r0;
        if (r1 == 0) goto L_0x00b3;
    L_0x0016:
        r4 = r6.a;
        if (r4 != 0) goto L_0x00b3;
    L_0x001a:
        if (r1 == 0) goto L_0x0062;
    L_0x001c:
        r1 = r0.height;
        if (r1 <= 0) goto L_0x0062;
    L_0x0020:
        r1 = r3;
    L_0x0021:
        if (r1 == 0) goto L_0x0066;
    L_0x0023:
        r4 = r6.k;
        if (r4 == 0) goto L_0x0066;
    L_0x0027:
        r4 = r6.d;
        if (r4 != 0) goto L_0x0066;
    L_0x002b:
        r3 = r0.height;
        r3 = r3 + r7;
        r0.height = r3;
        r3 = r0.height;
        if (r3 >= 0) goto L_0x0036;
    L_0x0034:
        r0.height = r2;
    L_0x0036:
        r3 = r0.height;
        if (r3 != 0) goto L_0x003e;
    L_0x003a:
        r6.e = r2;
        r6.d = r5;
    L_0x003e:
        r2 = r6.b;
        r2.setLayoutParams(r0);
        r2 = r6.g;
        r3 = (float) r7;
        r4 = r0.height;
        r5 = r6.o;
        r2.a(r3, r4, r5);
        r2 = r6.b;
        r3 = r0.height;
        r3 = (float) r3;
        r4 = r6.o;
        r3 = r3 / r4;
        r2.setProgressRotation(r3);
        r0 = r0.height;
        r0 = (float) r0;
        r6.a(r0);
        if (r1 == 0) goto L_0x0064;
    L_0x0060:
        r2 = r8;
        goto L_0x0007;
    L_0x0062:
        r1 = r2;
        goto L_0x0021;
    L_0x0064:
        r2 = -r7;
        goto L_0x0007;
    L_0x0066:
        r0 = r6.g();
        if (r0 != 0) goto L_0x0007;
    L_0x006c:
        r0 = r6.l;
        if (r0 == 0) goto L_0x0007;
    L_0x0070:
        r0 = r6.d;
        if (r0 != r3) goto L_0x0007;
    L_0x0074:
        r0 = r6.i;
        r0 = r0.getLayoutParams();
        r0 = (android.widget.FrameLayout.LayoutParams) r0;
        r1 = r0.height;
        r1 = r1 - r7;
        r0.height = r1;
        r1 = r0.height;
        if (r1 >= 0) goto L_0x0087;
    L_0x0085:
        r0.height = r2;
    L_0x0087:
        r1 = r0.height;
        if (r1 != 0) goto L_0x008f;
    L_0x008b:
        r6.e = r2;
        r6.d = r5;
    L_0x008f:
        r1 = r6.i;
        r1.setLayoutParams(r0);
        r1 = r6.h;
        r2 = (float) r7;
        r3 = r0.height;
        r4 = r6.p;
        r1.a(r2, r3, r4);
        r1 = r6.i;
        r2 = r0.height;
        r2 = (float) r2;
        r3 = r6.p;
        r2 = r2 / r3;
        r1.setProgressRotation(r2);
        r0 = r0.height;
        r0 = -r0;
        r0 = (float) r0;
        r6.a(r0);
        r2 = -r7;
        goto L_0x0007;
    L_0x00b3:
        r1 = r2;
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.ui.view.refresh.core.WXSwipeLayout.a(int, int):int");
    }

    private void a(float f) {
        this.j.setTranslationY(f);
    }

    private void c() {
        if (!this.c) {
            FrameLayout.LayoutParams layoutParams;
            int i;
            ValueAnimator ofFloat;
            this.e = false;
            if (this.k && this.d == 0) {
                layoutParams = (FrameLayout.LayoutParams) this.b.getLayoutParams();
                if (((float) layoutParams.height) >= this.m) {
                    i = layoutParams.height;
                    this.c = true;
                    if (this.g != null) {
                        this.g.d();
                    }
                    ofFloat = ValueAnimator.ofFloat(new float[]{(float) i, this.m});
                    ofFloat.addUpdateListener(new b(this));
                    ofFloat.addListener(new d(this));
                    ofFloat.setDuration(300);
                    ofFloat.start();
                } else if (layoutParams.height > 0) {
                    a(layoutParams.height);
                } else {
                    d();
                }
            }
            if (this.l && this.d == 1) {
                layoutParams = (FrameLayout.LayoutParams) this.i.getLayoutParams();
                if (((float) layoutParams.height) >= this.n) {
                    i = layoutParams.height;
                    this.c = true;
                    ofFloat = ValueAnimator.ofFloat(new float[]{(float) i, this.n});
                    ofFloat.addUpdateListener(new g(this));
                    ofFloat.addListener(new h(this));
                    ofFloat.setDuration(300);
                    ofFloat.start();
                } else if (layoutParams.height > 0) {
                    b(layoutParams.height);
                } else {
                    e();
                }
            }
        }
    }

    private void a(int i) {
        this.b.b();
        this.b.a(0.0f, 0.75f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) i, 0.0f});
        ofFloat.addUpdateListener(new e(this));
        ofFloat.addListener(new f(this));
        ofFloat.setDuration(300);
        ofFloat.start();
    }

    private void d() {
        this.c = false;
        this.e = false;
        this.d = -1;
    }

    private void b(int i) {
        this.i.b();
        this.i.a(0.5f, 1.25f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) i, 0.0f});
        ofFloat.addUpdateListener(new i(this));
        ofFloat.addListener(new j(this));
        ofFloat.setDuration(300);
        ofFloat.start();
    }

    private void e() {
        this.c = false;
        this.e = false;
        this.d = -1;
    }

    private boolean f() {
        if (this.j == null) {
            return false;
        }
        if (VERSION.SDK_INT >= 14) {
            return ViewCompat.b(this.j, -1);
        }
        if (!(this.j instanceof AbsListView)) {
            return ViewCompat.b(this.j, -1) || this.j.getScrollY() > 0;
        } else {
            AbsListView absListView = (AbsListView) this.j;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        }
    }

    private boolean g() {
        if (this.j == null) {
            return false;
        }
        if (VERSION.SDK_INT >= 14) {
            return ViewCompat.b(this.j, 1);
        }
        if (!(this.j instanceof AbsListView)) {
            return ViewCompat.b(this.j, 1) || this.j.getScrollY() > 0;
        } else {
            AbsListView absListView = (AbsListView) this.j;
            if (absListView.getChildCount() <= 0) {
                return false;
            }
            return absListView.getLastVisiblePosition() == ((ListAdapter) absListView.getAdapter()).getCount() + -1 && absListView.getChildAt(absListView.getChildCount() - 1).getBottom() <= absListView.getMeasuredHeight();
        }
    }

    public void setOnLoadingListener(l lVar) {
        this.h = lVar;
    }

    public void setOnRefreshListener(m mVar) {
        this.g = mVar;
    }

    public final void a() {
        if (this.d == 0) {
            a(this.b == null ? 0 : this.b.getMeasuredHeight());
        }
    }

    public final void b() {
        if (this.d == 1) {
            b(this.i == null ? 0 : this.i.getMeasuredHeight());
        }
    }

    public WXRefreshView getHeaderView() {
        return this.b;
    }

    public WXRefreshView getFooterView() {
        return this.i;
    }

    public void setPullLoadEnable(boolean z) {
        this.l = z;
    }

    public void setPullRefreshEnable(boolean z) {
        this.k = z;
    }

    public void setRefreshHeight(int i) {
        this.m = (float) i;
        this.o = this.m * IPictureView.DEFAULT_MIN_SCALE;
    }

    public void setLoadingHeight(int i) {
        this.n = (float) i;
        this.p = this.n * IPictureView.DEFAULT_MIN_SCALE;
    }

    public void setRefreshBgColor(int i) {
        this.b.setBackgroundColor(i);
    }

    public void setLoadingBgColor(int i) {
        this.i.setBackgroundColor(i);
    }
}
