package com.uc.weex.component.e;

import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Handler;
import android.os.Looper;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.uc.weex.component.b;

/* compiled from: ProGuard */
public final class w {
    private static final Interpolator v = new s();
    private int A;
    private boolean B = false;
    private boolean C = false;
    private boolean D = false;
    private int[] E = new int[]{856756497, 0};
    View a;
    View b;
    View c;
    Scroller d;
    VelocityTracker e;
    int f = 0;
    int g;
    int h;
    int i;
    float j;
    float k;
    float l;
    boolean m = false;
    boolean n = false;
    int o;
    float p;
    int q;
    GradientDrawable r;
    Drawable s;
    float t;
    Drawable u;
    private r w;
    private Handler x;
    private int y;
    private int z;

    public w(View view, r rVar) {
        this.a = view;
        this.w = rVar;
        this.x = new Handler(Looper.getMainLooper());
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        float f = view.getContext().getResources().getDisplayMetrics().density;
        this.g = viewConfiguration.getScaledTouchSlop();
        this.z = (int) (400.0f * f);
        this.h = viewConfiguration.getScaledMaximumFlingVelocity();
        this.A = (int) (25.0f * f);
        this.i = (int) (2.0f * f);
        this.d = new Scroller(view.getContext(), v);
        b.a();
        this.o = v.a;
        this.q = (int) (25.0f * f);
        this.r = new GradientDrawable(Orientation.RIGHT_LEFT, this.E);
        this.r.setGradientType(0);
        this.s = new ColorDrawable(335544320);
    }

    final void a(int i, int i2) {
        if (this.b != null && this.b.getVisibility() == 8) {
            if (i != this.b.getMeasuredWidth() || i2 != this.b.getMeasuredHeight()) {
                this.b.measure(MeasureSpec.makeMeasureSpec(i, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(i2, UCCore.VERIFY_POLICY_QUICK));
                this.b.layout(0, 0, i, i2);
                this.b.invalidate();
            }
        }
    }

    final boolean a(View view, boolean z, int i, int i2) {
        if (this.y != 0) {
            this.y = 0;
        }
        if (z) {
            this.c = view;
            if (view instanceof u) {
                this.B = true;
                this.C = ((u) view).a();
                return this.C;
            }
            this.B = false;
            this.y += view.getScrollX();
            if (this.y > 0) {
                return false;
            }
        }
        if (!(view instanceof ViewGroup)) {
            return z && this.y <= 0;
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
                    if (this.B && !this.C) {
                        return false;
                    }
                    if (this.y > 0) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    final void a() {
        this.D = false;
        if (this.o == v.a) {
            this.b = this.w.a(this.a);
            if (this.b == this.a) {
                this.b = null;
                return;
            } else {
                a(this.a.getMeasuredWidth(), this.a.getMeasuredHeight());
                return;
            }
        }
        this.t = 0.0f;
    }

    final void a(float f, int i, boolean z) {
        boolean z2 = true;
        this.c = null;
        this.m = false;
        this.n = false;
        int scrollX;
        int i2;
        int i3;
        int a;
        if (this.o == v.a) {
            boolean z3;
            if (!z) {
                if (Math.abs(f) > ((float) this.A) && Math.abs(i) > this.z) {
                    z3 = i < 0;
                    if (z3) {
                        z2 = false;
                    }
                    this.D = z2;
                    scrollX = this.a.getScrollX();
                    if (z3) {
                        i2 = -this.a.getMeasuredWidth();
                    } else {
                        i2 = 0;
                    }
                    if (!this.d.isFinished()) {
                        i3 = i2 - scrollX;
                        a = a(i3);
                        this.f = 2;
                        this.d.startScroll(scrollX, 0, i3, 0, a);
                        this.a.invalidate();
                        return;
                    }
                    return;
                } else if (Math.abs(this.a.getScrollX()) > this.a.getMeasuredWidth() / 2) {
                    z3 = false;
                    if (z3) {
                        z2 = false;
                    }
                    this.D = z2;
                    scrollX = this.a.getScrollX();
                    if (z3) {
                        i2 = 0;
                    } else {
                        i2 = -this.a.getMeasuredWidth();
                    }
                    if (!this.d.isFinished()) {
                        i3 = i2 - scrollX;
                        a = a(i3);
                        this.f = 2;
                        this.d.startScroll(scrollX, 0, i3, 0, a);
                        this.a.invalidate();
                        return;
                    }
                    return;
                }
            }
            z3 = true;
            if (z3) {
                z2 = false;
            }
            this.D = z2;
            scrollX = this.a.getScrollX();
            if (z3) {
                i2 = 0;
            } else {
                i2 = -this.a.getMeasuredWidth();
            }
            if (!this.d.isFinished()) {
                i3 = i2 - scrollX;
                a = a(i3);
                this.f = 2;
                this.d.startScroll(scrollX, 0, i3, 0, a);
                this.a.invalidate();
                return;
            }
            return;
        }
        boolean z4;
        if (!z) {
            if (Math.abs(f) > ((float) this.A) && Math.abs(i) > this.z) {
                z4 = i < 0;
                if (z4) {
                    z2 = false;
                }
                this.D = z2;
                i2 = this.u.getIntrinsicWidth();
                scrollX = (int) ((-(IPictureView.DEFAULT_MIN_SCALE - (this.t * 2.0f))) * ((float) i2));
                if (z4) {
                    i2 = 0;
                } else {
                    i2 = -i2;
                }
                if (!this.d.isFinished()) {
                    i3 = i2 - scrollX;
                    if (z4) {
                    }
                    this.f = 2;
                    this.d.startScroll(scrollX, 0, i3, 0, a);
                    this.a.invalidate();
                }
            } else if (this.t > 0.5f) {
                z4 = false;
                if (z4) {
                    z2 = false;
                }
                this.D = z2;
                i2 = this.u.getIntrinsicWidth();
                scrollX = (int) ((-(IPictureView.DEFAULT_MIN_SCALE - (this.t * 2.0f))) * ((float) i2));
                if (z4) {
                    i2 = -i2;
                } else {
                    i2 = 0;
                }
                if (!this.d.isFinished()) {
                    i3 = i2 - scrollX;
                    a = z4 ? a(i3) : 50;
                    this.f = 2;
                    this.d.startScroll(scrollX, 0, i3, 0, a);
                    this.a.invalidate();
                }
            }
        }
        z4 = true;
        if (z4) {
            z2 = false;
        }
        this.D = z2;
        i2 = this.u.getIntrinsicWidth();
        scrollX = (int) ((-(IPictureView.DEFAULT_MIN_SCALE - (this.t * 2.0f))) * ((float) i2));
        if (z4) {
            i2 = -i2;
        } else {
            i2 = 0;
        }
        if (!this.d.isFinished()) {
            i3 = i2 - scrollX;
            if (z4) {
            }
            this.f = 2;
            this.d.startScroll(scrollX, 0, i3, 0, a);
            this.a.invalidate();
        }
    }

    final void b() {
        this.f = 0;
        if (!this.d.isFinished()) {
            this.d.abortAnimation();
        }
        if (this.D) {
            this.x.post(new t(this));
        }
    }

    private int a(int i) {
        float f = 450.0f;
        float measuredWidth = (float) this.a.getMeasuredWidth();
        if (measuredWidth > 0.0f) {
            f = Math.min((450.0f * ((((float) Math.abs(i)) / measuredWidth) + IPictureView.DEFAULT_MIN_SCALE)) / 2.0f, 600.0f);
        }
        return (int) f;
    }
}
