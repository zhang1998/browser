package android.support.v4.widget;

import android.support.v4.widget.SlidingPaneLayout.LayoutParams;
import android.view.View;

/* compiled from: ProGuard */
final class bs extends at {
    final /* synthetic */ SlidingPaneLayout a;

    private bs(SlidingPaneLayout slidingPaneLayout) {
        this.a = slidingPaneLayout;
    }

    public final boolean a(View view) {
        if (this.a.l) {
            return false;
        }
        return ((LayoutParams) view.getLayoutParams()).b;
    }

    public final void a(int i) {
        if (this.a.q.a != 0) {
            return;
        }
        if (this.a.i == 0.0f) {
            this.a.a(this.a.h);
            SlidingPaneLayout slidingPaneLayout = this.a;
            this.a.h;
            slidingPaneLayout.sendAccessibilityEvent(32);
            this.a.r = false;
            return;
        }
        slidingPaneLayout = this.a;
        this.a.h;
        slidingPaneLayout.sendAccessibilityEvent(32);
        this.a.r = true;
    }

    public final void b(View view) {
        this.a.a();
    }

    public final void a(View view, int i) {
        SlidingPaneLayout.a(this.a, i);
        this.a.invalidate();
    }

    public final void a(View view, float f) {
        int paddingRight;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.a.c()) {
            paddingRight = layoutParams.rightMargin + this.a.getPaddingRight();
            if (f < 0.0f || (f == 0.0f && this.a.i > 0.5f)) {
                paddingRight += this.a.k;
            }
            paddingRight = (this.a.getWidth() - paddingRight) - this.a.h.getWidth();
        } else {
            paddingRight = layoutParams.leftMargin + this.a.getPaddingLeft();
            if (f > 0.0f || (f == 0.0f && this.a.i > 0.5f)) {
                paddingRight += this.a.k;
            }
        }
        this.a.q.a(paddingRight, view.getTop());
        this.a.invalidate();
    }

    public final int c(View view) {
        return this.a.k;
    }

    public final int b(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) this.a.h.getLayoutParams();
        if (this.a.c()) {
            int width = this.a.getWidth() - ((layoutParams.rightMargin + this.a.getPaddingRight()) + this.a.h.getWidth());
            return Math.max(Math.min(i, width), width - this.a.k);
        }
        width = layoutParams.leftMargin + this.a.getPaddingLeft();
        return Math.min(Math.max(i, width), this.a.k + width);
    }

    public final int d(View view) {
        return view.getTop();
    }

    public final void a(int i, int i2) {
        this.a.q.a(this.a.h, i2);
    }
}
