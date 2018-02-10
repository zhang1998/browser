package com.ucpro.base.c.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

/* compiled from: ProGuard */
final class ag extends FrameLayout {
    af a;
    k b;
    FrameLayout c;
    t d;
    ac e;

    public ag(Context context) {
        super(context);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.a = new af(context);
        addView(this.a, layoutParams);
        layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.b = new k(context);
        addView(this.b, layoutParams);
        this.c = new FrameLayout(context);
        addView(this.c, new FrameLayout.LayoutParams(-1, -1));
    }

    final void a(t tVar, int i, boolean z) {
        int i2 = 0;
        tVar.getRootWindow().a((byte) 14);
        if (z) {
            this.b.addView(tVar, i);
            int childCount = this.b.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (tVar == this.b.getChildAt(i3)) {
                    if (this.d != null) {
                        this.d.getRootWindow().getWindowClassId();
                        this.d.getRootWindow().clearAnimation();
                        this.d.getRootWindow().a((byte) 11);
                        if (this.d.getStackTopWindow() != this.d.getRootWindow()) {
                            this.d.getStackTopWindow().getWindowClassId();
                            this.d.getStackTopWindow().clearAnimation();
                            this.d.getStackTopWindow().a((byte) 11);
                        }
                    }
                    this.d = tVar;
                    this.d.getRootWindow().getWindowClassId();
                    this.d.getRootWindow().a((byte) 8);
                    if (this.d.getRootWindow() != this.d.getStackTopWindow()) {
                        this.d.getStackTopWindow().getWindowClassId();
                        this.d.getStackTopWindow().a((byte) 8);
                    }
                    this.d.setVisibility(0);
                }
            }
            while (i2 < childCount) {
                View childAt = this.b.getChildAt(i2);
                if (!(childAt == null || tVar == childAt)) {
                    childAt.setVisibility(4);
                }
                i2++;
            }
            return;
        }
        tVar.setVisibility(4);
        this.b.addView(tVar, i);
    }

    final boolean a(int i) {
        if (i < 0 || i > this.b.getChildCount() - 1) {
            return false;
        }
        return true;
    }

    final void b(int i) {
        int i2 = 0;
        if (i != a(this.d) && a(i)) {
            int childCount = this.b.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                if (i3 == i) {
                    this.d.getRootWindow().getWindowClassId();
                    this.d.getRootWindow().clearAnimation();
                    this.d.getRootWindow().a((byte) 11);
                    if (this.d.getRootWindow() != this.d.getStackTopWindow()) {
                        this.d.getStackTopWindow().getWindowClassId();
                        this.d.getStackTopWindow().clearAnimation();
                        this.d.getStackTopWindow().a((byte) 11);
                    }
                    this.d = c(i);
                    this.d.getRootWindow().getWindowClassId();
                    this.d.getRootWindow().a((byte) 8);
                    if (this.d.getRootWindow() != this.d.getStackTopWindow()) {
                        this.d.getStackTopWindow().getWindowClassId();
                        this.d.getStackTopWindow().a((byte) 8);
                    }
                    this.d.setVisibility(0);
                    this.d.requestLayout();
                    View childAt = this.d.getChildAt(this.d.getChildCount() - 1);
                    if (childAt != null) {
                        childAt.setVisibility(0);
                    }
                }
            }
            while (i2 < childCount) {
                if (i2 != i) {
                    this.b.getChildAt(i2).setVisibility(4);
                }
                i2++;
            }
        }
    }

    final t c(int i) {
        if (a(i)) {
            return (t) this.b.getChildAt(i);
        }
        return null;
    }

    final int a(t tVar) {
        for (int i = 0; i < this.b.getChildCount(); i++) {
            if (tVar == c(i)) {
                return i;
            }
        }
        return -1;
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public final void requestLayout() {
        super.requestLayout();
    }
}
