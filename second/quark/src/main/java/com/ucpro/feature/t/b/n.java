package com.ucpro.feature.t.b;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.base.d.b;
import com.ucpro.ui.animation.g;
import com.ucpro.ui.c.a;
import com.ucweb.common.util.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class n extends s implements OnClickListener, h {
    public List<View> a = new ArrayList();
    public int b = 0;
    private j c = null;
    private List<View> d = new ArrayList();
    private boolean e = true;
    private u f = null;
    private boolean g;
    private ValueAnimator h = null;
    private ValueAnimator i = null;
    private long j = 300;
    private boolean k = false;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private int q = 0;
    private int r = 0;
    private c s = null;

    static /* synthetic */ boolean a(n nVar, g gVar) {
        if (nVar.l == nVar.c()) {
            return false;
        }
        if (nVar.i != null && nVar.i.isRunning()) {
            nVar.i.cancel();
        }
        nVar.i = ValueAnimator.ofInt(new int[]{r2, r3});
        nVar.i.addUpdateListener(new r(nVar));
        nVar.i.addListener(new e(nVar, gVar));
        nVar.i.setDuration(nVar.j).start();
        return true;
    }

    public n(Context context) {
        super(context);
        this.f = new u(context, this, this);
        this.n = a.c((int) R.dimen.multi_window_cardview2_first_margin_left);
        this.o = a.c((int) R.dimen.multi_window_cardview2_horizontal_space);
        this.p = a.c((int) R.dimen.multi_window_cardview2_vertical_space);
        this.b = a.c((int) R.dimen.multi_window_cardview2_icon_width);
    }

    public final int getInitVisibileChildCount() {
        return 0;
    }

    public final int getFirstCardCurrentProcess() {
        return 0;
    }

    public final int getScrollMaxProcess() {
        return 0;
    }

    public final int getScrollMinProcess() {
        return 0;
    }

    public final View a(int i) {
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = childCount - 1; i2 >= 0; i2--) {
                View childAt = getChildAt(i2);
                c.b(childAt instanceof k);
                if (((k) childAt).getIndex() == i) {
                    return childAt;
                }
            }
        }
        return null;
    }

    public final void setPresenter(b bVar) {
        c.b(bVar instanceof j);
        this.c = (j) bVar;
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.q == 0) {
            this.q = com.ucpro.feature.t.a.a(com.ucpro.base.system.b.a.f(), getMeasuredHeight(), false)[0];
        }
        measureChildren(i, i2);
        setMeasuredDimension(this.l == 0 ? c() : this.l, getMeasuredHeight());
    }

    private int c() {
        int childCount = getChildCount();
        int i = childCount % 4;
        int i2 = childCount / 4;
        childCount = 0;
        if (i == 1) {
            childCount = this.q;
        } else if (i > 1) {
            childCount = (this.q * 2) + this.o;
        } else if (i == 0) {
            childCount = -this.o;
        }
        return Math.max(childCount + (this.n + ((i2 * 2) * (this.q + this.o))), (this.n + (this.q * 2)) + this.o);
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.r == 0 && getChildCount() > 0) {
            this.r = getChildAt(0).getMeasuredHeight();
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.e) {
            int i5;
            if (!this.k) {
                int childCount = getChildCount();
                for (i5 = 0; i5 < childCount; i5++) {
                    View childAt = getChildAt(i5);
                    c.b(childAt instanceof k);
                    int[] b = b(((k) childAt).getIndex());
                    childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
                    childAt.setTranslationX((float) b[0]);
                    childAt.setTranslationY((float) b[1]);
                }
            }
            i5 = getChildCount();
            for (int i6 = 0; i6 < i5; i6++) {
                k kVar = (k) getChildAt(i6);
                kVar.setOnClickListener(this);
                kVar.getDeleteBtn().setOnClickListener(this);
            }
            a();
            this.e = false;
        }
    }

    private int[] b(int i) {
        int i2;
        int i3 = i % 4;
        int i4 = i / 4;
        if (i3 == 0 || i3 == 2) {
            i2 = this.n;
        } else if (i3 == 1 || i3 == 3) {
            i2 = (this.n + this.q) + this.o;
        } else {
            i2 = 0;
        }
        i4 = ((i4 * 2) * (this.q + this.o)) + i2;
        i2 = (i3 == 2 || i3 == 3) ? this.p : (i3 == 0 || i3 == 1) ? (this.p * 2) + this.r : 0;
        i3 = this.q + i4;
        int i5 = this.r + i2;
        return new int[]{i4, i2, i3, i5};
    }

    public final void a() {
        int i = 0;
        if (this.c != null) {
            for (int i2 = 0; i2 < this.d.size(); i2++) {
                this.c.a((View) this.d.get(i2), false);
            }
            this.d.clear();
            while (i < this.a.size()) {
                this.c.a((View) this.a.get(i), true);
                i++;
            }
            this.a.clear();
        }
    }

    public final k getFirstCard() {
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = childCount - 1; i >= 0; i--) {
                View childAt = getChildAt(i);
                c.b(childAt instanceof k);
                if (((k) childAt).getIndex() == 0) {
                    return (k) childAt;
                }
            }
        }
        return null;
    }

    public final void onClick(View view) {
        if (view instanceof k) {
            if (this.c != null) {
                this.c.a(view);
            }
        } else if (view instanceof ImageView) {
            for (int i = 0; i < getChildCount(); i++) {
                View view2 = (k) getChildAt(i);
                if (view2.getDeleteBtn() == view) {
                    u uVar = this.f;
                    int i2 = uVar.i * 2;
                    ValueAnimator a = uVar.a(view2, u.a(view2) + uVar.f);
                    a.setInterpolator(uVar.k);
                    a.setDuration((long) i2);
                    a.addListener(new p(uVar, view2));
                    a.addUpdateListener(new m(uVar, view2));
                    a.start();
                    invalidate();
                    return;
                }
            }
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && this.s != null) {
            this.s.a();
        }
        if (!b()) {
            this.g = this.f.a(motionEvent);
            if (this.g) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final boolean b() {
        boolean z;
        int childCount = getChildCount();
        if (this.i == null || !this.i.isRunning()) {
            z = false;
        } else {
            z = true;
        }
        childCount %= 4;
        if (z || ((childCount == 0 || childCount == 1) && this.h != null && this.h.isRunning())) {
            return true;
        }
        return false;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.g) {
            boolean z;
            u uVar = this.f;
            if (uVar.a || uVar.a(motionEvent)) {
                uVar.b.addMovement(motionEvent);
                float xVelocity;
                switch (motionEvent.getAction()) {
                    case 1:
                    case 3:
                        if (uVar.c != null) {
                            Object obj;
                            Object obj2;
                            View view;
                            int i;
                            ValueAnimator a;
                            View view2;
                            ValueAnimator a2;
                            VelocityTracker velocityTracker = uVar.b;
                            velocityTracker.computeCurrentVelocity(1000);
                            xVelocity = velocityTracker.getXVelocity();
                            float yVelocity = velocityTracker.getYVelocity();
                            if (uVar.h == 1) {
                                xVelocity = velocityTracker.getYVelocity();
                                yVelocity = velocityTracker.getXVelocity();
                            }
                            float f = uVar.g * 100.0f;
                            float translationX = (uVar.h == 0 ? uVar.c.getTranslationX() : uVar.c.getTranslationY()) - uVar.f;
                            Object obj3 = ((double) Math.abs(translationX)) > 0.3d * ((double) u.a(uVar.c)) ? 1 : null;
                            if (Math.abs(xVelocity) > f && Math.abs(xVelocity) > Math.abs(r1)) {
                                if ((xVelocity > 0.0f ? 1 : null) == (translationX > 0.0f ? 1 : null)) {
                                    obj = 1;
                                    obj2 = (obj == null || obj3 != null) ? 1 : null;
                                    if (obj2 == null) {
                                        view = uVar.c;
                                        if (obj == null) {
                                            xVelocity = 0.0f;
                                        }
                                        if (xVelocity >= 0.0f || (xVelocity == 0.0f && uVar.c(view) < uVar.f)) {
                                            xVelocity = (-u.a(view)) + uVar.f;
                                        } else {
                                            xVelocity = u.a(view) + uVar.f;
                                        }
                                        i = uVar.i;
                                        a = uVar.a(view, xVelocity);
                                        a.setInterpolator(uVar.k);
                                        a.setDuration((long) i);
                                        a.addListener(new d(uVar, view));
                                        a.addUpdateListener(new a(uVar, view));
                                        a.start();
                                    } else {
                                        view2 = uVar.c;
                                        a2 = uVar.a(view2, uVar.f);
                                        a2.setDuration(250);
                                        a2.setInterpolator(new AccelerateDecelerateInterpolator());
                                        a2.addUpdateListener(new v(uVar, view2));
                                        a2.addListener(new t(uVar, view2));
                                        a2.start();
                                    }
                                }
                            }
                            obj = null;
                            if (obj == null) {
                            }
                            if (obj2 == null) {
                                view2 = uVar.c;
                                a2 = uVar.a(view2, uVar.f);
                                a2.setDuration(250);
                                a2.setInterpolator(new AccelerateDecelerateInterpolator());
                                a2.addUpdateListener(new v(uVar, view2));
                                a2.addListener(new t(uVar, view2));
                                a2.start();
                            } else {
                                view = uVar.c;
                                if (obj == null) {
                                    xVelocity = 0.0f;
                                }
                                if (xVelocity >= 0.0f) {
                                    break;
                                }
                                xVelocity = (-u.a(view)) + uVar.f;
                                i = uVar.i;
                                a = uVar.a(view, xVelocity);
                                a.setInterpolator(uVar.k);
                                a.setDuration((long) i);
                                a.addListener(new d(uVar, view));
                                a.addUpdateListener(new a(uVar, view));
                                a.start();
                            }
                        }
                        uVar.l.requestDisallowInterceptTouchEvent(false);
                        break;
                    case 2:
                    case 4:
                        if (uVar.c != null) {
                            if (uVar.h == 0) {
                                xVelocity = motionEvent.getX();
                            } else {
                                xVelocity = motionEvent.getY() - uVar.e;
                            }
                            if (uVar.h == 0) {
                                uVar.c.setTranslationX(uVar.f + xVelocity);
                            } else {
                                uVar.c.setTranslationY(uVar.f + xVelocity);
                            }
                            uVar.c.setAlpha(uVar.b(uVar.c));
                            uVar.d.a(uVar.c, xVelocity);
                            break;
                        }
                        break;
                }
                z = true;
            } else {
                z = uVar.j;
            }
            if (z) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public final View a(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                int[] iArr = new int[2];
                childAt.getLocationOnScreen(iArr);
                if (new RectF((float) iArr[0], (float) iArr[1], (float) (iArr[0] + childAt.getWidth()), (float) (iArr[1] + childAt.getHeight())).contains((float) rawX, (float) rawY)) {
                    return childAt;
                }
            }
        }
        return null;
    }

    public final void a(View view, float f) {
        if (view == a(0) && this.s != null) {
            this.s.a(f);
        }
    }

    public final void a(View view, int i) {
        c.b(view instanceof k);
        int hashCode = view.hashCode();
        if (this.m != hashCode) {
            this.m = hashCode;
            k kVar = (k) view;
            int index = kVar.getIndex();
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                k kVar2 = (k) getChildAt(i2);
                if (kVar2.getIndex() > index) {
                    kVar2.setIndex(kVar2.getIndex() - 1);
                }
                kVar2.setAnimStartX(kVar2.getTranslationX());
                kVar2.setAnimStartY(kVar2.getTranslationY());
            }
            removeView(kVar);
            if (this.h != null && this.h.isRunning()) {
                this.h.cancel();
            }
            this.h = ValueAnimator.ofFloat(new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE});
            this.h.addUpdateListener(new o(this));
            this.h.addListener(new g(this));
            this.h.setDuration(this.j);
            this.h.start();
            if (this.c != null) {
                this.c.a(view, i);
            }
            if (this.s != null) {
                this.s.b();
            }
        }
    }

    public final void setWheelViewCallback(c cVar) {
        this.s = cVar;
    }
}
