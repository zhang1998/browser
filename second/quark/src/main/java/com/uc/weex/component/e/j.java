package com.uc.weex.component.e;

import android.content.Context;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import com.uc.imagecodec.export.IPictureView;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class j extends c {
    private Runnable l = new d(this);

    public j(Context context, l lVar) {
        super(context, lVar);
    }

    final void a(q qVar, q qVar2, a aVar) {
        qVar.setActAsAndroidWindow(false);
        if (qVar.getParent() == null) {
            f();
            this.c = qVar;
            this.d = (q) this.e.peek();
            if (!this.c.c) {
                this.c.setEnableBackground(true);
            }
            if (this.c.getVisibility() != 0) {
                this.c.setVisibility(0);
            }
            addView(qVar);
            this.c.a((byte) 0, false);
            this.d.a((byte) 3, false);
            this.e.push(this.c);
            this.c.a((byte) 12, false);
            l.d();
            q qVar3 = this.c;
            int i = this.b.b;
            ViewPropertyAnimator animate = qVar3.animate();
            animate.cancel();
            if (i == 1) {
                qVar3.setTranslationY(((float) getHeight()) * 0.2f);
                qVar3.setAlpha(0.0f);
                animate.translationY(0.0f);
                animate.alpha(IPictureView.DEFAULT_MIN_SCALE);
                animate.setDuration(300);
                animate.setInterpolator(new DecelerateInterpolator(IPictureView.DEFAULT_MAX_SCALE));
            } else {
                qVar3.setTranslationX(((float) getWidth()) * 0.8f);
                animate.translationX(0.0f);
                animate.setDuration(300);
                animate.setInterpolator(new DecelerateInterpolator());
            }
            animate.setListener(new f(this, qVar2, aVar));
            this.g = true;
            x.a(this.c, this.c.getPushAndPopLayerType());
            x.a(this.c);
            animate.start();
        }
    }

    final void a(boolean z) {
        if (this.e.size() > 1) {
            f();
            this.c = (q) this.e.pop();
            this.d = (q) this.e.peek();
            if (this.c != null) {
                if (!this.c.c && z) {
                    this.c.setEnableBackground(true);
                    this.c.invalidate();
                }
                if (this.d.getVisibility() != 0) {
                    this.d.setVisibility(0);
                }
                if (z) {
                    this.c.a((byte) 3, false);
                    this.d.a((byte) 0, false);
                    l.e();
                    q qVar = this.c;
                    int i = this.b.b;
                    ViewPropertyAnimator animate = qVar.animate();
                    animate.cancel();
                    if (i == 1) {
                        animate.translationY(((float) getHeight()) * 0.2f);
                        animate.alpha(0.0f);
                        animate.setDuration(300);
                        animate.setInterpolator(new i());
                    } else {
                        qVar.setTranslationX(0.0f);
                        animate.translationX((float) getWidth());
                        animate.setDuration(300);
                        animate.setInterpolator(new DecelerateInterpolator());
                    }
                    animate.setListener(new h(this));
                    this.h = true;
                    x.a(this.c, this.c.getPushAndPopLayerType());
                    x.a(this.c);
                    animate.start();
                    return;
                }
                this.c.a((byte) 5, false);
                this.d.a((byte) 2, false);
                removeView(this.c);
                this.c.a((byte) 13, true);
                this.c = null;
                this.d = null;
            }
        }
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
        removeCallbacks(this.l);
    }

    private void d(q qVar) {
        d();
        if (!(this.c == null || this.d == null)) {
            if (qVar == null || qVar != this.d) {
                if (!this.c.c) {
                    this.d.setVisibility(4);
                }
                this.d.a((byte) 4, false);
            }
            if (qVar != null) {
                this.e.remove(qVar);
                removeView(qVar);
                qVar.a((byte) 13, false);
            }
            this.c.a((byte) 1, true);
        }
        this.g = false;
        this.c = null;
        this.d = null;
    }

    private void e() {
        d();
        if (!(this.c == null || this.d == null)) {
            this.d.a((byte) 1, false);
            this.c.a((byte) 4, true);
            removeView(this.c);
            this.c.a((byte) 13, false);
        }
        this.h = false;
        this.c = null;
        this.d = null;
    }

    private void f() {
        if (this.f.size() > 0) {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                removeCallbacks((Runnable) it.next());
            }
            this.f.clear();
        }
        if (!(this.g || this.h)) {
            d();
        }
        if (this.g) {
            d(null);
        }
        if (this.h) {
            e();
        }
    }
}
