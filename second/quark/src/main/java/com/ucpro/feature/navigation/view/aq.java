package com.ucpro.feature.navigation.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.quark.browser.R;
import com.ucpro.base.d.b;
import com.ucpro.feature.navigation.k;
import com.ucpro.feature.navigation.m;
import com.ucpro.feature.navigation.view.a.c;
import com.ucpro.feature.navigation.view.a.f;
import com.ucpro.ui.c.a;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class aq extends FrameLayout implements m {
    public s a;
    as b;
    public aj c;
    public k d;
    int[] e = new int[2];
    public boolean f = true;
    public Runnable g = new am(this);
    private k h;
    private ao i;
    private f j;
    private ArrayList<w> k = new ArrayList();
    private l l;
    private Rect m = new Rect();
    private boolean n;
    private m o = new c(this);
    private al p = new av(this);

    public aq(Context context) {
        super(context);
        setClipChildren(false);
        this.h = new k();
        this.h.a(this);
        this.h.b = this.o;
        this.k.add(this.h);
        s sVar = new s(getContext());
        int c = a.c((int) R.dimen.launcher_horizontal_padding);
        sVar.setPadding(c, a.c((int) R.dimen.launcher_vertical_padding), c, 0);
        sVar.setVerticalSpacings(a.c((int) R.dimen.launcher_grid_spacing_portrait));
        sVar.setPortraitColumnNum(5);
        this.a = sVar;
        addView(this.a, -1, -1);
        this.b = new as();
        this.i = new ao(getContext(), this.p);
        this.b.c = this.i;
        this.a.setAdapter(this.b);
        setCurrentState(c.a());
    }

    public final void d() {
        as.c(this.a);
    }

    public final void e() {
        this.b.f = true;
    }

    public final void f() {
        this.b.notifyDataSetChanged();
    }

    public final boolean g() {
        for (int i = 0; i < this.a.getChildCount(); i++) {
            View childAt = this.a.getChildAt(i);
            if (childAt instanceof j) {
                if (((j) childAt).getWidgetInfo().b == 0) {
                    return false;
                }
                return true;
            }
        }
        return true;
    }

    public final void setEnableDragAndDrop(boolean z) {
        this.f = z;
        if (z) {
            removeCallbacks(this.g);
        }
    }

    public final aj getDragLayer() {
        if (this.c == null) {
            this.c = new aj(getContext(), new r(this));
            addView(this.c, new LayoutParams(-1, -1));
        }
        return this.c;
    }

    public final s getLauncherGridView() {
        return this.a;
    }

    public final int getWidgetCount() {
        return this.b.getCount();
    }

    public final void setCurrentState(f fVar) {
        if (fVar != null && fVar != this.j) {
            if (this.j != null) {
                this.j.a(this);
            }
            this.j = fVar;
            this.j.b(this);
        }
    }

    public final boolean a(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.j.a(this, keyEvent);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.j.a(this, motionEvent);
    }

    public final void h() {
        if (getDragObject() != null) {
            getDragObject().c.setVisibility(0);
            getDragLayer().a();
            this.d.a();
            setDragObject(null);
        }
    }

    public final l getDragObject() {
        return this.l;
    }

    public final void setDragObject(l lVar) {
        this.l = lVar;
    }

    public final w a(l lVar) {
        if (lVar == null) {
            return null;
        }
        for (int size = this.k.size() - 1; size >= 0; size--) {
            w wVar = (w) this.k.get(size);
            if (wVar != null) {
                wVar.a(this.m);
                if (this.m.intersect(lVar.g)) {
                    return wVar;
                }
            }
        }
        return null;
    }

    public final boolean a(j jVar, Point point) {
        jVar.dispatchTouchEvent(MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0));
        jVar.a(true);
        l lVar = new l();
        i iVar = new i(getContext());
        iVar.setSourceView(jVar);
        lVar.b = iVar;
        lVar.c = jVar;
        lVar.e.x = point.x;
        lVar.e.y = point.y;
        lVar.i = jVar.getWidgetInfo();
        getDragLayer().a(jVar, lVar.f);
        lVar.a(point.x, point.y);
        lVar.j = getDragLayer();
        if (lVar.j != null) {
            lVar.b.setLayoutParams(new ab());
            aj ajVar = lVar.j;
            ajVar.a.add(lVar.b);
        }
        if (lVar.m != null && lVar.m.isRunning()) {
            lVar.m.cancel();
        }
        lVar.l = ObjectAnimator.ofFloat(lVar.o, "scale", new float[]{lVar.o.a, 1.1f});
        lVar.l.setDuration(130);
        lVar.l.addUpdateListener(new ak(lVar));
        lVar.l.addListener(new ay(lVar));
        lVar.l.start();
        lVar.p.add(lVar.l);
        if (lVar.r != null && lVar.r.isRunning()) {
            lVar.r.cancel();
        }
        lVar.q = ObjectAnimator.ofInt(lVar.o, "alpha", new int[]{lVar.o.b, 226});
        lVar.q.setDuration(200);
        lVar.q.setInterpolator(lVar.s);
        lVar.q.addUpdateListener(new at(lVar));
        lVar.q.addListener(new x(lVar));
        lVar.q.start();
        lVar.p.add(lVar.q);
        setDragObject(lVar);
        getLauncherGridAdapter().a(jVar.getWidgetInfo());
        return true;
    }

    public final void i() {
        if (!this.n) {
            this.n = true;
            as asVar = this.b;
            ViewGroup viewGroup = this.a;
            asVar.d = true;
            as.b(viewGroup);
        }
    }

    public final void j() {
        if (this.n) {
            this.n = false;
            getDragLayer().a();
            as asVar = this.b;
            ViewGroup viewGroup = this.a;
            asVar.d = false;
            as.a(viewGroup);
        }
    }

    public final void setPresenter(b bVar) {
        this.d = (k) bVar;
    }

    public final as getLauncherGridAdapter() {
        return this.b;
    }

    public final void setData(ArrayList<ax> arrayList) {
        as asVar = this.b;
        asVar.a = arrayList;
        asVar.notifyDataSetChanged();
    }

    public final void a() {
        j();
        setCurrentState(c.a());
        setEnableDragAndDrop(false);
        this.b.e = false;
    }

    public final void a(View view) {
        this.b.e = true;
        Point point = new Point();
        point.x = view.getLeft() + (view.getWidth() / 2);
        point.y = view.getTop() + (view.getHeight() / 2);
        a((j) view, point);
        setCurrentState(com.ucpro.feature.navigation.view.a.a.a());
    }

    public final boolean c() {
        return this.j.c(this);
    }

    public final void setHighlightWidget(ax axVar) {
        as asVar = this.b;
        asVar.b = axVar;
        asVar.notifyDataSetChanged();
    }

    public final void b() {
        this.b.notifyDataSetChanged();
    }
}
