package com.ucpro.feature.s.b.a;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.view.a.b;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.feature.s.b.a.a.a;

/* compiled from: ProGuard */
public final class e extends ViewGroup {
    public final View a;
    private final View b;
    private final int c;
    private Drawable d;
    private a e;
    private ValueAnimator f;
    private d g;
    private int h;
    private int i = -1;
    private float j;
    private boolean k = true;
    private boolean l = true;
    private boolean m;
    private boolean n;

    public e(Context context, View view, View view2) {
        super(context);
        this.a = view;
        addView(this.a);
        this.b = view2;
        addView(this.b);
        this.c = ViewConfiguration.get(getContext()).getScaledMaximumFlingVelocity() / 3;
        setClipToPadding(false);
        setOnClickListener(new g(this));
    }

    public final void setListener(d dVar) {
        this.g = dVar;
    }

    private a getScrollPanelTouchEventHandler() {
        if (this.e == null) {
            this.e = new a(this);
        }
        return this.e;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.j = motionEvent.getY();
        }
        return getScrollPanelTouchEventHandler().a.a(motionEvent);
    }

    public final boolean a(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void setExpansibleBackground(Drawable drawable) {
        this.d = drawable;
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.b != null) {
            this.b.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(0, 0));
        }
        if (this.a != null) {
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            this.a.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(measuredHeight, UCCore.VERIFY_POLICY_QUICK));
        }
    }

    protected final boolean drawChild(Canvas canvas, View view, long j) {
        int visibleTop;
        Object obj = null;
        int minVisibleTop = this.m ? getMinVisibleTop() : getDefaultVisibleTop();
        if (getVisibleTop() > minVisibleTop) {
            visibleTop = getVisibleTop() - minVisibleTop;
        } else {
            visibleTop = 0;
        }
        if (visibleTop != 0 && view == this.b) {
            canvas.save();
            canvas.translate(0.0f, (float) visibleTop);
        }
        if (view == this.a) {
            obj = 1;
        }
        if (obj != null) {
            int left = view.getLeft();
            int right = view.getRight();
            int top = view.getTop();
            minVisibleTop = this.b != null ? this.b.getBottom() : view.getBottom();
            canvas.save();
            canvas.clipRect(left, top, right, minVisibleTop);
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        if (obj != null) {
            canvas.restore();
        }
        if (visibleTop != 0 && view == this.b) {
            canvas.save();
            canvas.translate(0.0f, (float) (-visibleTop));
        }
        return drawChild;
    }

    public final void a(long j) {
        b(j);
        if (this.g != null) {
            this.g.f();
        }
    }

    public final void b(long j) {
        if (!this.n) {
            this.n = true;
            animate().cancel();
            animate().setDuration(300).setListener(new b(this)).setInterpolator(a((float) j) ? new b() : new AccelerateDecelerateInterpolator()).translationY((float) (getHeight() - getVisibleTop())).start();
            if (this.g != null) {
                this.g.c();
            }
        }
    }

    private int getDefaultVisibleTop() {
        if (this.i == -1 && getHeight() > 0) {
            this.i = Math.round(((float) getHeight()) * 0.3f);
        }
        return this.i;
    }

    public final int getVisibleTop() {
        return this.h;
    }

    public final void setVisibleTop(int i) {
        if (i != this.h) {
            this.h = i;
            this.h = Math.max(getPaddingTop(), this.h);
            this.h = Math.min(getHeight(), this.h);
            b();
            if (this.h == getMinVisibleTop() && this.l) {
                this.l = false;
                this.m = true;
                a scrollPanelTouchEventHandler = getScrollPanelTouchEventHandler();
                scrollPanelTouchEventHandler.a.a(scrollPanelTouchEventHandler);
                if (this.g != null) {
                    this.g.e();
                }
            }
            invalidate();
        }
    }

    private void b() {
        this.a.offsetTopAndBottom(this.h - this.a.getTop());
    }

    private int getMinVisibleTop() {
        return getPaddingTop();
    }

    public final void a(int i) {
        setVisibleTop(getVisibleTop() + i);
    }

    public final void c(long j) {
        if (a((float) j)) {
            getScrollAnimation().setInterpolator(new BounceInterpolator());
            getScrollAnimation().setDuration(500);
        } else {
            getScrollAnimation().setInterpolator(new DecelerateInterpolator());
            getScrollAnimation().setDuration(300);
        }
        getScrollAnimation().setIntValues(new int[]{getVisibleTop(), getMinVisibleTop()});
        getScrollAnimation().start();
    }

    private ValueAnimator getScrollAnimation() {
        if (this.f == null) {
            this.f = ValueAnimator.ofInt(new int[]{0, 0});
            this.f.setDuration(300);
            this.f.addUpdateListener(new f(this));
            this.f.addListener(new a(this));
        }
        return this.f;
    }

    public final void a() {
        if (this.f != null && this.f.isRunning()) {
            this.f.cancel();
        }
    }

    private boolean a(float f) {
        return Math.abs(f) >= ((float) this.c);
    }

    protected final void dispatchDraw(Canvas canvas) {
        if (this.d != null) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int visibleTop = getVisibleTop();
            int height = getHeight() - getPaddingBottom();
            if (this.m) {
                if (getVisibleTop() > getMinVisibleTop()) {
                    height += getVisibleTop() - getMinVisibleTop();
                }
            } else if (getVisibleTop() > getDefaultVisibleTop()) {
                height += getVisibleTop() - getDefaultVisibleTop();
            }
            this.d.setBounds(paddingLeft, visibleTop, width, height);
            this.d.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.b != null) {
            int height = getHeight() - getPaddingBottom();
            int measuredHeight = height - this.b.getMeasuredHeight();
            this.b.layout(getPaddingLeft(), measuredHeight, getWidth() - getPaddingRight(), height);
        }
        if (this.a != null) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            height = getPaddingTop();
            this.a.layout(paddingLeft, height, width, this.a.getMeasuredHeight() + height);
        }
        if (this.k) {
            this.k = false;
            setVisibleTop(getDefaultVisibleTop());
            setTranslationY((float) (getHeight() - getVisibleTop()));
            animate().setDuration(300).setInterpolator(new b()).translationY(0.0f).start();
            if (this.g != null) {
                this.g.a();
                return;
            }
            return;
        }
        b();
    }

    static /* synthetic */ void c(e eVar) {
        if (eVar.h == eVar.getHeight() && eVar.g != null) {
            eVar.g.b();
        }
    }
}
