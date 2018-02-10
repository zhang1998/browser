package com.ucpro.feature.navigation.view;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Rect;
import com.taobao.weex.ui.animation.WXAnimationBean.Style;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.feature.navigation.view.a.a;
import com.ucpro.ui.animation.a.c;

/* compiled from: ProGuard */
public final class k implements w {
    protected aq a;
    m b;
    protected af c = new af(this);
    int d = -1;
    private h e = new h();
    private a f = new a(this);

    public final void a(aq aqVar) {
        this.a = aqVar;
    }

    public final void a(l lVar, Runnable runnable) {
        if (lVar != null) {
            if (!this.a.getLauncherGridView().b()) {
                this.f.a = lVar;
                this.f.a();
            }
            Rect rect = new Rect();
            if (lVar.d != null && this.a.getLauncherGridView().indexOfChild(lVar.d) >= 0) {
                lVar.j.a(lVar.d, rect);
            } else if (lVar.c == null || this.a.getLauncherGridView().indexOfChild(lVar.c) < 0) {
                if (this.a.getLauncherGridView().getLastVisiblePosition() == d().getCount() - 1) {
                    rect = t.a(this.a.getLauncherGridView().getChildAt(this.a.getLauncherGridView().getChildCount() - 1));
                } else {
                    rect = this.a.getLauncherGridView().getRectAfterLastChild();
                }
                Rect rect2 = new Rect();
                t.a(this.a.getLauncherGridView(), lVar.j, rect2);
                rect.offset(rect2.left, rect2.top);
                lVar.k = this.a.getWidgetCount();
            } else {
                lVar.j.a(lVar.c, rect);
            }
            Runnable auVar = new au(this, lVar, runnable);
            if (lVar.l != null && lVar.l.isRunning()) {
                lVar.l.cancel();
            }
            lVar.n = 0;
            lVar.m = ObjectAnimator.ofFloat(lVar.o, "scale", new float[]{lVar.o.a, IPictureView.DEFAULT_MIN_SCALE});
            lVar.m.setDuration(130);
            lVar.m.addUpdateListener(new z(lVar));
            lVar.m.addListener(new y(lVar));
            lVar.m.setInterpolator(new c((byte) 0));
            lVar.m.start();
            lVar.p.add(lVar.m);
            if (lVar.q != null && lVar.q.isRunning()) {
                lVar.q.cancel();
            }
            lVar.r = ObjectAnimator.ofInt(lVar.o, "alpha", new int[]{lVar.o.b, 255});
            lVar.r.setDuration(200);
            lVar.r.setInterpolator(lVar.s);
            lVar.r.addUpdateListener(new g(lVar));
            lVar.r.addListener(new q(lVar));
            lVar.r.start();
            lVar.p.add(lVar.r);
            int i = rect.left;
            int i2 = rect.top;
            if (!(lVar.g == null || lVar.j == null)) {
                aj ajVar = lVar.j;
                ajVar.b = true;
                PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt(Style.LEFT, new int[]{lVar.g.left, i});
                PropertyValuesHolder ofInt2 = PropertyValuesHolder.ofInt(Style.TOP, new int[]{lVar.g.top, i2});
                ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(new RectWrapper(lVar.g), new PropertyValuesHolder[]{ofInt, ofInt2});
                i = Math.abs(lVar.g.left - i);
                i2 = Math.abs(lVar.g.top - i2);
                ofPropertyValuesHolder.setDuration(Math.max((long) (((float) ((int) Math.sqrt((double) ((i2 * i2) + (i * i))))) / l.a), 330));
                ofPropertyValuesHolder.setInterpolator(new c((byte) 0));
                ofPropertyValuesHolder.addUpdateListener(new ap(lVar));
                ofPropertyValuesHolder.addListener(new o(lVar, auVar, ajVar));
                ofPropertyValuesHolder.start();
                lVar.p.add(ofPropertyValuesHolder);
            }
            lVar.d = null;
        }
    }

    public final void a(l lVar) {
        d().a(lVar.i);
        lVar.d = lVar.c;
    }

    final void a(l lVar, int i, int i2) {
        if (i != i2 && i2 != this.d) {
            this.d = i2;
            if (i >= 0 && i2 >= 0) {
                lVar.k = this.a.getLauncherGridView().getFirstVisiblePosition() + i2;
                this.c.a(this.a.getLauncherGridView().getFirstVisiblePosition() + i, this.a.getLauncherGridView().getFirstVisiblePosition() + i2);
                this.a.getLauncherGridView().a(i, i2, d().a(), this.c);
            } else if (i < 0) {
                int i3;
                lVar.k = this.a.getLauncherGridView().getFirstVisiblePosition() + i2;
                as d = d();
                ax axVar = lVar.i;
                if (d.a == null) {
                    i3 = -1;
                } else {
                    i3 = d.a.indexOf(axVar);
                }
                int firstVisiblePosition = this.a.getLauncherGridView().getFirstVisiblePosition() + i2;
                this.c.a(i3, firstVisiblePosition);
                if (i3 < 0) {
                    this.c.a = lVar;
                } else if (firstVisiblePosition > i3) {
                    this.a.getLauncherGridView().a(0, i2, d().a(), this.c);
                    return;
                }
                this.a.getLauncherGridView().a(d().a(), i2, d().a(), this.c);
            }
        }
    }

    public final boolean b() {
        return a.a().b;
    }

    public final void a(Rect rect) {
        rect.set(0, 0, this.a.getLauncherGridView().getWidth(), this.a.getLauncherGridView().getHeight());
    }

    public final s e() {
        return this.a.getLauncherGridView();
    }

    public final void b(l lVar) {
        if (!this.a.getLauncherGridView().b() && !this.e.d) {
            this.f.a = lVar;
            this.e.c = this.f;
            Runnable runnable = this.e;
            runnable.a();
            long currentTimeMillis = System.currentTimeMillis();
            runnable.d = true;
            runnable.a = 80 + currentTimeMillis;
            runnable.b.postDelayed(runnable, runnable.a - currentTimeMillis);
        }
    }

    public final void a() {
        this.a.getLauncherGridView().c();
        this.d = -1;
        this.e.a();
    }

    protected final void c() {
        this.a.getLauncherGridView().a();
    }

    public final as d() {
        return (as) this.a.getLauncherGridView().getAdapter();
    }
}
