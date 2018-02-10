package com.ucpro.base.c.b;

import android.content.Context;
import android.graphics.Canvas;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.ucweb.common.util.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/* compiled from: ProGuard */
public class t extends FrameLayout {
    static final /* synthetic */ boolean a = (!t.class.desiredAssertionStatus());
    private g b;
    private g c;
    private g d;
    private Stack<g> e = new Stack();
    private boolean f;
    private boolean g;
    private OnHierarchyChangeListener h;
    private ArrayList<Runnable> i = new ArrayList();
    private boolean j = false;
    private Runnable k = new s(this);
    private h l;
    private boolean m = false;

    public t(Context context, g gVar) {
        super(context);
        if (a || gVar != null) {
            this.b = gVar;
            this.c = this.b;
            addView(gVar);
            this.e.push(this.c);
            this.h = new b(this);
            setOnHierarchyChangeListener(this.h);
            return;
        }
        throw new AssertionError();
    }

    g getRootWindow() {
        return this.b;
    }

    g getStackTopWindow() {
        return (g) this.e.peek();
    }

    public final boolean a(g gVar) {
        if (!this.e.remove(gVar)) {
            return false;
        }
        removeView(gVar);
        return true;
    }

    public final g a(int i) {
        return (g) this.e.elementAt(i);
    }

    public int getWindowCount() {
        return this.e.size();
    }

    final void a(g gVar, boolean z, boolean z2) {
        if (gVar.getParent() == null) {
            c();
            this.c = gVar;
            this.d = (g) this.e.peek();
            if (!this.c.g() && z) {
                this.c.setEnableBackground(true);
            }
            if (this.c.getVisibility() != 0) {
                this.c.setVisibility(0);
            }
            addView(gVar);
            if (z) {
                if (z2) {
                    this.c.a((byte) 0);
                }
                this.d.a((byte) 3);
                this.e.push(this.c);
                if (z2) {
                    this.c.a((byte) 12);
                }
                Animation pushAnimation = this.c.getPushAnimation();
                if (pushAnimation != null) {
                    pushAnimation.setAnimationListener(new aa(this));
                    this.f = true;
                    this.c.startAnimation(pushAnimation);
                } else {
                    ViewPropertyAnimator animate = this.c.animate();
                    animate.cancel();
                    this.c.setTranslationX(((float) getWidth()) * 0.8f);
                    animate.translationX(0.0f);
                    animate.setDuration(300);
                    animate.setInterpolator(new DecelerateInterpolator());
                    animate.setListener(new u(this));
                    this.f = true;
                    try {
                        this.c.setLayerType(2, null);
                        this.c.buildLayer();
                    } catch (IllegalStateException e) {
                        this.c.setLayerType(0, null);
                    }
                    animate.start();
                }
                this.d.getWindowClassId();
                this.c.getWindowClassId();
                return;
            }
            if (z2) {
                this.c.a((byte) 2);
            }
            this.d.a((byte) 5);
            if (!this.c.g()) {
                this.d.setVisibility(4);
            }
            if (this.c.h()) {
                this.d.setVisibility(8);
            }
            this.e.push(this.c);
            if (z2) {
                this.c.a((byte) 12);
            }
            this.d.getWindowClassId();
            this.c.getWindowClassId();
            if (this.l != null) {
                this.l.a(this.d, this.c);
            }
            this.c = null;
            this.d = null;
        }
    }

    final void a(boolean z) {
        if (this.e.size() > 1) {
            c();
            this.c = (g) this.e.pop();
            this.d = (g) this.e.peek();
            if (this.c != this.b && this.c != null) {
                if (!this.c.g() && z) {
                    this.c.setEnableBackground(true);
                    this.c.invalidate();
                }
                if (this.d.getVisibility() != 0) {
                    this.d.setVisibility(0);
                }
                if (z) {
                    this.c.a((byte) 3);
                    this.d.a((byte) 0);
                    Animation popAnimation = this.c.getPopAnimation();
                    if (popAnimation != null) {
                        popAnimation.setAnimationListener(new e(this));
                        this.g = true;
                        this.c.startAnimation(popAnimation);
                    } else {
                        ViewPropertyAnimator animate = this.c.animate();
                        animate.cancel();
                        this.c.setTranslationX(0.0f);
                        animate.translationX((float) getWidth());
                        animate.setDuration(300);
                        animate.setInterpolator(new DecelerateInterpolator());
                        animate.setListener(new d(this));
                        this.g = true;
                        this.c.setLayerType(2, null);
                        this.c.buildLayer();
                        animate.start();
                    }
                    this.c.getWindowClassId();
                    this.d.getWindowClassId();
                    return;
                }
                this.c.a((byte) 5);
                this.d.a((byte) 2);
                removeView(this.c);
                this.c.a((byte) 13);
                this.c.getWindowClassId();
                this.d.getWindowClassId();
                if (this.l != null) {
                    this.l.a(this.c, this.d);
                }
                f.a(100);
                this.c = null;
                this.d = null;
            }
        }
    }

    final void b(boolean z) {
        int size = this.e.size();
        if (size != 1) {
            for (int i = size - 2; i > 0; i--) {
                g gVar = (g) this.e.remove(i);
                if (gVar != null) {
                    removeView(gVar);
                    gVar.a((byte) 13);
                }
            }
            a(z);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.m && getVisibility() == 4) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
        } else {
            super.onMeasure(i, i2);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (!this.m || getVisibility() != 4) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.m = true;
    }

    protected void dispatchDraw(Canvas canvas) {
        this.j = true;
        super.dispatchDraw(canvas);
        this.m = true;
        this.j = false;
    }

    private void a() {
        d();
        if (!(this.c == null || this.d == null)) {
            if (!this.c.g()) {
                this.d.setVisibility(4);
            }
            this.d.a((byte) 4);
            this.c.a((byte) 1);
            if (this.c.h()) {
                this.d.setVisibility(8);
            }
            this.d.getWindowClassId();
            this.c.getWindowClassId();
            if (this.l != null) {
                this.l.a(this.d, this.c);
            }
        }
        this.f = false;
        this.c = null;
        this.d = null;
    }

    private void b() {
        d();
        if (!(this.c == null || this.d == null)) {
            this.d.a((byte) 1);
            this.c.a((byte) 4);
            this.c.getWindowClassId();
            this.d.getWindowClassId();
            if (this.l != null) {
                this.l.a(this.c, this.d);
            }
            removeView(this.c);
            this.c.a((byte) 13);
        }
        this.g = false;
        f.a(100);
        this.c = null;
        this.d = null;
    }

    private void c() {
        if (this.i.size() > 0) {
            Iterator it = this.i.iterator();
            while (it.hasNext()) {
                removeCallbacks((Runnable) it.next());
            }
            this.i.clear();
        }
        if (!(this.f || this.g)) {
            d();
        }
        if (this.f) {
            a();
        }
        if (this.g) {
            b();
        }
        f.a();
    }

    private void d() {
        if (this.c != null) {
            this.c.setAnimation(null);
            this.c.animate().cancel();
            this.c.setTranslationX(0.0f);
            this.c.setTranslationY(0.0f);
        }
        if (this.d != null) {
            this.d.setAnimation(null);
            this.d.animate().cancel();
            this.d.setTranslationX(0.0f);
            this.d.setTranslationY(0.0f);
        }
        removeCallbacks(this.k);
    }

    public final void b(g gVar) {
        if (this.e.size() > 1) {
            this.e.remove(gVar);
            removeView(gVar);
            gVar.a((byte) 12);
        }
    }

    public void setSwithcListener(h hVar) {
        this.l = hVar;
    }
}
