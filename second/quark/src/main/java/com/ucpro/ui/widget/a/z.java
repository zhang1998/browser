package com.ucpro.ui.widget.a;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public class z implements y {
    static final String a = z.class.getSimpleName();
    static final /* synthetic */ boolean k = (!z.class.desiredAssertionStatus());
    j b;
    l c;
    ListAdapter d;
    ac e;
    long f;
    f g;
    Drawable h;
    Drawable i;
    Drawable j;
    private i l;
    private w m;
    private int n;
    private View o;
    private float p;
    private int q;
    private float r;
    private float s;
    private boolean t;
    private u u;
    private g v;

    private void a(int i) {
        if (this.f == -1) {
            if (this.p < 0.0f) {
                throw new IllegalStateException("User must be touching the DynamicListView!");
            } else if (this.d == null) {
                throw new IllegalStateException("This DynamicListView has no adapter set!");
            } else if (i >= 0 && i < this.d.getCount()) {
                this.o = this.l.b();
                if (this.o != null) {
                    this.q = i;
                    this.f = this.d.getItemId(i);
                    Drawable background = this.o.getBackground();
                    if (this.h != null) {
                        this.o.setBackgroundDrawable(this.h);
                    }
                    this.e = new ac(this.o, this.p);
                    this.e.setAlpha(222);
                    this.o.setBackgroundDrawable(background);
                    this.o.setVisibility(4);
                    ((v) this.d).b(i);
                    ((n) this.d).a(this.o);
                    return;
                }
                x.a(a, "start drag fail---------->mobile view is null");
            }
        }
    }

    public final boolean a(MotionEvent motionEvent) {
        Exception e;
        long j = -1;
        int i = -1;
        boolean b;
        try {
            if (!this.t) {
                i iVar;
                int g;
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        this.p = motionEvent.getY();
                        this.r = motionEvent.getRawX();
                        this.s = motionEvent.getRawY();
                        iVar = this.l;
                        motionEvent.getX();
                        motionEvent.getY();
                        g = iVar.g();
                        if (g == -1) {
                            return true;
                        }
                        ViewGroup viewGroup = (ViewGroup) this.l.b();
                        if (viewGroup == null || !this.b.a(viewGroup, motionEvent.getX(), motionEvent.getY())) {
                            return true;
                        }
                        a(g);
                        return true;
                    case 1:
                        b = b();
                        try {
                            this.p = -1.0f;
                            return b;
                        } catch (Exception e2) {
                            e = e2;
                            c.a(e.toString());
                            return b;
                        }
                    case 2:
                        boolean z;
                        this.p = motionEvent.getY();
                        float rawX = motionEvent.getRawX() - this.r;
                        float rawY = motionEvent.getRawY() - this.s;
                        View b2;
                        if (this.e != null || Math.abs(rawY) <= ((float) this.n) || Math.abs(rawY) <= Math.abs(rawX)) {
                            if (this.e != null) {
                                ac acVar = this.e;
                                acVar.a((int) (((acVar.a - acVar.b) + motionEvent.getY()) + acVar.c));
                                if (!(this.e == null || this.d == null)) {
                                    g = a(this.f);
                                    long itemId = (g + -1) - this.l.e() >= 0 ? this.d.getItemId((g - 1) - this.l.e()) : -1;
                                    if ((g + 1) - this.l.e() < this.d.getCount()) {
                                        j = this.d.getItemId((g + 1) - this.l.e());
                                    }
                                    if (!this.e.a()) {
                                        itemId = j;
                                    }
                                    View b3 = b(itemId);
                                    ac acVar2 = this.e;
                                    int i2 = (int) (((float) acVar2.getBounds().top) - acVar2.a);
                                    if (b3 != null && Math.abs(i2) > this.e.getIntrinsicHeight()) {
                                        if (Math.abs(i2) < this.e.getIntrinsicHeight() * 2) {
                                            int intrinsicHeight = this.e.getIntrinsicHeight();
                                            if (i2 >= 0) {
                                                i = 1;
                                            }
                                            a(b3, itemId, (float) (i * intrinsicHeight));
                                        } else {
                                            int abs = Math.abs(i2) / this.e.getIntrinsicHeight();
                                            x.a(a, "switchIfNeccessary-------->handle group view switch switch item count is " + abs);
                                            boolean a = this.e.a();
                                            g = this.e.getIntrinsicHeight();
                                            if (i2 >= 0) {
                                                i = 1;
                                            }
                                            float f = (float) (i * g);
                                            if (!(this.e == null || this.d == null || this.o == null)) {
                                                this.m.a(this.f, a, abs, f);
                                                b2 = b(this.f);
                                                if (b2 != null) {
                                                    i = b2.getHeight();
                                                } else {
                                                    i = 0;
                                                }
                                                this.e.b(i * abs);
                                            }
                                        }
                                    }
                                    this.c.a();
                                }
                                this.l.a().invalidate();
                                z = true;
                            }
                            z = false;
                        } else {
                            iVar = this.l;
                            motionEvent.getX();
                            motionEvent.getY();
                            g = iVar.g();
                            if (g != -1) {
                                b2 = this.l.b();
                                if (!k && b2 == null) {
                                    throw new AssertionError();
                                } else if (this.b.a(b2, motionEvent.getX() - ((float) b2.getLeft()), motionEvent.getY() - ((float) b2.getTop()))) {
                                    a(g - this.l.e());
                                    z = true;
                                }
                            }
                            z = false;
                        }
                        return z;
                    case 3:
                        b = b();
                        this.p = -1.0f;
                        return b;
                }
            }
            return false;
        } catch (Exception e3) {
            e = e3;
            b = false;
            c.a(e.toString());
            return b;
        }
    }

    private boolean b() {
        if (this.o == null) {
            return false;
        }
        if (k || this.e != null) {
            ((v) this.d).b(-1);
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.e.getBounds().top, this.o.getTop()});
            Object mVar = new m(this, this.e, this.o);
            ofInt.addUpdateListener(mVar);
            ofInt.addListener(mVar);
            ofInt.start();
            return true;
        }
        throw new AssertionError();
    }

    private void a(View view, long j, float f) {
        if (this.e != null && view != null) {
            w wVar = this.m;
            long j2 = this.f;
            View b = wVar.a.b(j2);
            int a = wVar.a.a(j2);
            View b2 = wVar.a.b(j);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(b2, "translationY", new float[]{0.0f, -f});
            ofFloat.addListener(new o(wVar, a, b, b2));
            ofFloat.start();
            wVar.a.f = j;
            wVar.a.o = wVar.a.b(wVar.a.f);
            this.e.b(view.getHeight());
        }
    }

    private int a(long j) {
        if (b(j) == null) {
            return -1;
        }
        return this.l.f();
    }

    private View b(long j) {
        View view = null;
        ListAdapter listAdapter = this.d;
        if (!(j == -1 || listAdapter == null)) {
            int c = this.l.c();
            int d = this.l.d();
            for (int i = 0; i < d && r0 == null; i++) {
                int i2 = c + i;
                if (i2 - this.l.e() >= 0 && listAdapter.getItemId(i2 - this.l.e()) == j) {
                    view = this.l.b();
                }
            }
        }
        return view;
    }
}
