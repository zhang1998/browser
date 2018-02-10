package com.uc.weex.component.f;

import android.animation.ValueAnimator;
import android.content.Context;
import android.mini.support.v4.view.NestedScrollingParent;
import android.mini.support.v4.view.am;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import com.alibaba.wireless.security.SecExceptionCode;
import com.taobao.weex.ui.view.l;
import com.uc.weex.component.c.f;
import java.util.HashSet;
import java.util.Set;

/* compiled from: ProGuard */
public final class k extends l implements NestedScrollingParent {
    private final am b = new am(this);
    private c c;
    private Runnable d;
    private boolean e;
    private Set<Integer> f = new HashSet();
    private int g = -1;
    private boolean h = false;
    private boolean i;
    private boolean j;
    private int k = -1;
    private ValueAnimator l;

    public k(Context context) {
        super(context);
    }

    public final void setHeaderView(c cVar) {
        this.c = cVar;
    }

    public final void onNestedScrollAccepted(View view, View view2, int i) {
        this.b.a = i;
    }

    public final int getNestedScrollAxes() {
        return this.b.a;
    }

    public final boolean onStartNestedScroll(View view, View view2, int i) {
        boolean z = (i & 2) != 0;
        this.g = -1;
        this.d = null;
        this.j = false;
        this.e = false;
        this.i = false;
        this.k = -1;
        this.h = false;
        if (z) {
            if (this.l != null && this.l.isRunning()) {
                this.l.cancel();
            }
            if (view2 instanceof f) {
                f fVar = (f) view2;
                int hashCode = fVar.hashCode();
                if (!this.f.contains(Integer.valueOf(hashCode))) {
                    fVar.a(new j());
                    this.f.add(Integer.valueOf(hashCode));
                }
            }
        }
        return z;
    }

    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 != 0 && !this.j) {
            int minScrollHeight;
            int minScrollHeight2;
            if (i2 < 0) {
                this.h = getCurrentHeight() >= getInitHeight();
                this.k = 2;
                minScrollHeight = getMinScrollHeight();
                minScrollHeight2 = getMinScrollHeight();
            } else {
                this.k = 1;
                minScrollHeight = getMinScrollHeight();
                minScrollHeight2 = getMaxScrollHeight();
            }
            iArr[1] = a(i2, minScrollHeight, minScrollHeight2);
        }
    }

    public final void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        if (i4 < 0) {
            a(i4, getMinScrollHeight(), getMaxScrollHeight());
            this.j = true;
        } else {
            this.j = false;
        }
        if (i4 <= 0) {
            this.i = false;
        } else if (!(view instanceof f)) {
            a();
        }
    }

    public final void onStopNestedScroll(View view) {
        this.b.a = 0;
        if (!this.e) {
            int i;
            if (this.j && this.h) {
                i = 1;
            } else {
                i = 0;
            }
            if (getCurrentHeight() != getMinScrollHeight() && getCurrentHeight() != getInitHeight()) {
                boolean z = i != 0 && getCurrentHeight() - this.c.getHeaderHeight() >= this.c.getMinForRefresh();
                if (this.l != null && this.l.isRunning()) {
                    this.l.cancel();
                }
                int initHeight = getCurrentHeight() > (getInitHeight() * 3) / 4 ? getInitHeight() : getMinScrollHeight();
                this.l = ValueAnimator.ofInt(new int[]{getCurrentHeight(), initHeight});
                this.l.setInterpolator(new DecelerateInterpolator());
                this.l.addUpdateListener(new g(this));
                this.l.addListener(new h(this, z));
                this.l.setDuration(300);
                this.l.start();
            }
        }
    }

    public final boolean onNestedPreFling(View view, float f, float f2) {
        if (this.k != -1) {
            if (f2 < 0.0f && this.k != 2) {
                return true;
            }
            if (f2 > 0.0f && this.k != 1) {
                return true;
            }
        }
        return false;
    }

    public final boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!z) {
            return false;
        }
        if (f2 < 0.0f) {
            boolean z2 = this.h && this.j;
            if (this.g == 0) {
                a(getCurrentHeight(), getMaxScrollHeight(), getInitHeight(), z2);
                return true;
            }
            this.e = true;
            if (getCurrentHeight() == getMaxScrollHeight()) {
                this.d = new i(this, getInitHeight(), -1, z2);
                return false;
            }
            this.d = new i(this, getMaxScrollHeight(), getInitHeight(), z2);
            return false;
        } else if (getCurrentHeight() <= getMinScrollHeight()) {
            return false;
        } else {
            a(getCurrentHeight(), getMinScrollHeight(), false);
            return true;
        }
    }

    private void a(int i, int i2, boolean z) {
        a(i, i2, -1, z);
    }

    private void a(int i, int i2, int i3, boolean z) {
        int i4;
        this.e = true;
        if (this.l != null && this.l.isRunning()) {
            this.l.cancel();
        }
        if (i3 > 0) {
            this.l = ValueAnimator.ofInt(new int[]{i, i2, i3});
            i4 = SecExceptionCode.SEC_ERROR_SIGNATRUE;
        } else {
            this.l = ValueAnimator.ofInt(new int[]{i, i2});
            i4 = SecExceptionCode.SEC_ERROR_STA_ENC;
        }
        this.l.setInterpolator(new DecelerateInterpolator());
        this.l.addUpdateListener(new e(this));
        this.l.addListener(new f(this, z));
        this.l.setDuration((long) i4);
        this.l.start();
    }

    private int getMinScrollHeight() {
        return this.c.getMinHeight();
    }

    private int getMaxScrollHeight() {
        return this.c.getHeaderHeight() + this.c.getMaxPullDown();
    }

    private int getInitHeight() {
        return this.c.getHeaderHeight();
    }

    private int getCurrentHeight() {
        return this.c.getLayoutParams().height;
    }

    private int a(int i, int i2, int i3) {
        return b(getCurrentHeight() - i, i2, i3);
    }

    private int b(int i, int i2, int i3) {
        int i4 = 0;
        LayoutParams layoutParams = this.c.getLayoutParams();
        int i5 = layoutParams.height;
        if (i5 < i2 || i5 > i3) {
            return 0;
        }
        if (i >= i2) {
            i2 = i > i3 ? i3 : i;
        }
        if (i5 == i2) {
            return 0;
        }
        layoutParams.height = i2;
        this.c.setLayoutParams(layoutParams);
        float headerHeight = (float) (i2 - this.c.getHeaderHeight());
        int childCount = getChildCount();
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (childAt != this.c) {
                childAt.setTranslationY(headerHeight);
            }
            i4++;
        }
        if (this.c.getHeaderListener() != null) {
            this.c.getHeaderListener().a(layoutParams.height);
        }
        return i5 - i2;
    }

    private void a() {
        if (!this.i) {
            if (this.c.getHeaderListener() != null) {
                this.c.getHeaderListener().d();
            }
            this.i = true;
        }
    }

    static /* synthetic */ void a(k kVar, boolean z) {
        if (z && kVar.c.getHeaderListener() != null) {
            kVar.c.getHeaderListener().b();
        }
    }
}
