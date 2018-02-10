package com.ucpro.base.c.b;

import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Looper;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import com.alibaba.wireless.security.SecExceptionCode;
import com.uc.webview.export.extension.UCCore;
import com.ucweb.common.util.e;

/* compiled from: ProGuard */
public final class q {
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;
    private int[] D = new int[]{856756497, 0};
    View a;
    c b;
    View c;
    View d;
    Scroller e;
    VelocityTracker f;
    int g = 0;
    int h;
    int i;
    int j;
    float k;
    float l;
    float m;
    boolean n = false;
    boolean o = false;
    int p;
    float q;
    int r;
    GradientDrawable s;
    Drawable t;
    float u;
    private e v;
    private int w = SecExceptionCode.SEC_ERROR_STA_KEY_ENC;
    private int x;
    private int y;
    private int z;

    public q(View view) {
        this.a = view;
        this.v = new e(getClass().getName(), Looper.getMainLooper());
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        float f = view.getContext().getResources().getDisplayMetrics().density;
        this.h = viewConfiguration.getScaledTouchSlop();
        this.y = (int) (400.0f * f);
        this.i = viewConfiguration.getScaledMaximumFlingVelocity();
        this.z = (int) (25.0f * f);
        this.j = (int) (2.0f * f);
        this.e = new Scroller(view.getContext());
        this.e.setFriction(ViewConfiguration.getScrollFriction() * 0.6f);
        this.p = p.a;
        this.r = (int) (25.0f * f);
        this.s = new GradientDrawable(Orientation.RIGHT_LEFT, this.D);
        this.s.setGradientType(0);
        this.t = new ColorDrawable(335544320);
    }

    final void a(int i, int i2) {
        if (!(this.c == null || this.c.getVisibility() != 8 || (i == this.c.getMeasuredWidth() && i2 == this.c.getMeasuredHeight() && !this.c.isLayoutRequested()))) {
            this.c.measure(MeasureSpec.makeMeasureSpec(i, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(i2, UCCore.VERIFY_POLICY_QUICK));
            this.c.layout(0, 0, i, i2);
            this.c.invalidate();
        }
        if (this.c != null) {
            this.c.buildDrawingCache();
        }
    }

    final boolean a(View view, boolean z, int i, int i2) {
        if (this.x != 0) {
            this.x = 0;
        }
        if (z) {
            this.d = view;
            if (view instanceof ae) {
                this.A = true;
                this.B = ((ae) view).a();
                return this.B;
            }
            this.A = false;
            this.x += view.getScrollX();
            if (this.x > 0) {
                return false;
            }
        }
        if (!(view instanceof ViewGroup)) {
            return z && this.x <= 0;
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = i + view.getScrollX();
            int scrollY = view.getScrollY() + i2;
            int childCount = viewGroup.getChildCount();
            Rect rect = new Rect();
            for (childCount--; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                childAt.getHitRect(rect);
                if (rect.contains(scrollX, scrollY)) {
                    a(childAt, true, scrollX - childAt.getLeft(), scrollY - childAt.getTop());
                    if (this.A && !this.B) {
                        return false;
                    }
                    if (this.x > 0) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    final void a() {
        this.C = false;
        if (this.p == p.a) {
            this.c = this.b.a(this.a);
            if (this.c == this.a) {
                this.c = null;
                return;
            } else {
                a(this.a.getMeasuredWidth(), this.a.getMeasuredHeight());
                return;
            }
        }
        this.u = 0.0f;
    }

    final void a(float f, int i, boolean z) {
        boolean z2 = true;
        this.d = null;
        this.n = false;
        this.o = false;
        if (this.p == p.a) {
            boolean z3;
            int scrollX;
            int i2;
            int i3;
            int i4;
            if (!z) {
                if (Math.abs(f) > ((float) this.z) && Math.abs(i) > this.y) {
                    z3 = i < 0;
                    if (z3) {
                        z2 = false;
                    }
                    this.C = z2;
                    scrollX = this.a.getScrollX();
                    if (z3) {
                    }
                    if (!this.e.isFinished()) {
                        i3 = i2 - scrollX;
                        i4 = this.w;
                        this.g = 2;
                        this.e.startScroll(scrollX, 0, i3, 0, i4);
                        this.a.invalidate();
                    }
                } else if (Math.abs(this.a.getScrollX()) > this.a.getMeasuredWidth() / 2) {
                    z3 = false;
                    if (z3) {
                        z2 = false;
                    }
                    this.C = z2;
                    scrollX = this.a.getScrollX();
                    i2 = z3 ? 0 : -this.a.getMeasuredWidth();
                    if (!this.e.isFinished()) {
                        i3 = i2 - scrollX;
                        i4 = this.w;
                        this.g = 2;
                        this.e.startScroll(scrollX, 0, i3, 0, i4);
                        this.a.invalidate();
                    }
                }
            }
            z3 = true;
            if (z3) {
                z2 = false;
            }
            this.C = z2;
            scrollX = this.a.getScrollX();
            if (z3) {
            }
            if (!this.e.isFinished()) {
                i3 = i2 - scrollX;
                i4 = this.w;
                this.g = 2;
                this.e.startScroll(scrollX, 0, i3, 0, i4);
                this.a.invalidate();
            }
        }
    }

    final void b() {
        this.g = 0;
        if (!this.e.isFinished()) {
            this.e.abortAnimation();
        }
        if (this.C) {
            this.v.post(new i(this));
        }
    }
}
