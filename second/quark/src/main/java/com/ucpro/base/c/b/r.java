package com.ucpro.base.c.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;

/* compiled from: ProGuard */
public final class r extends m implements ac, h {
    private ag a;

    public r(Context context) {
        super(context);
        this.a = new ag(context);
        this.a.setFocusable(true);
    }

    public final void a(Activity activity) {
        activity.setContentView(this.a);
    }

    public final void a(Drawable drawable) {
        this.a.a.setBackgroundDrawable(drawable);
    }

    public final void a(g gVar, boolean z) {
        boolean z2 = true;
        if (this.a.d != null) {
            boolean z3;
            t tVar;
            t tVar2 = this.a.d;
            if (!(gVar == null || gVar.getParent() == null)) {
                int childCount;
                int i;
                if (!(tVar2 == null || gVar == null)) {
                    childCount = tVar2.getChildCount();
                    for (i = 0; i < childCount; i++) {
                        if (((g) tVar2.getChildAt(i)) == gVar) {
                            z3 = true;
                            break;
                        }
                    }
                }
                z3 = false;
                if (z3) {
                    tVar2.a(gVar);
                    z3 = true;
                } else {
                    int childCount2 = this.a.b.getChildCount();
                    loop1:
                    for (childCount = 0; childCount < childCount2; childCount++) {
                        t c = this.a.c(childCount);
                        if (c != tVar2) {
                            int childCount3 = c.getChildCount();
                            for (i = 0; i < childCount3; i++) {
                                if (gVar == ((g) c.getChildAt(i))) {
                                    c.a(gVar);
                                    z3 = true;
                                    break loop1;
                                }
                            }
                            continue;
                        }
                    }
                }
                tVar = this.a.d;
                if (z3) {
                    z2 = false;
                }
                tVar.a(gVar, z, z2);
            }
            z3 = false;
            tVar = this.a.d;
            if (z3) {
                z2 = false;
            }
            tVar.a(gVar, z, z2);
        }
    }

    public final void a(boolean z) {
        if (this.a.d != null) {
            this.a.d.a(z);
        }
    }

    public final void a(g gVar) {
        if (this.a.d != null) {
            this.a.d.b(gVar);
        }
    }

    public final void b(boolean z) {
        if (this.a.d != null) {
            this.a.d.b(z);
        }
    }

    public final g a() {
        if (this.a.d == null) {
            return null;
        }
        return this.a.d.getStackTopWindow();
    }

    private static g a(t tVar, g gVar) {
        for (int windowCount = tVar.getWindowCount() - 1; windowCount > 0; windowCount--) {
            if (tVar.a(windowCount) == gVar) {
                return tVar.a(windowCount - 1);
            }
        }
        return null;
    }

    public final g b(g gVar) {
        if (this.a.d == null) {
            return null;
        }
        return a(this.a.d, gVar);
    }

    public final g b() {
        if (this.a.d == null) {
            return null;
        }
        return this.a.d.getRootWindow();
    }

    public final int c() {
        return this.a.b.getChildCount();
    }

    public final int d() {
        ag agVar = this.a;
        return agVar.a(agVar.d);
    }

    protected final boolean a(g gVar, int i) {
        t tVar = new t(this.b, gVar);
        tVar.setSwithcListener(this);
        if (this.a.d == null) {
            this.a.a(tVar, i, true);
        } else {
            this.a.a(tVar, i, false);
        }
        return true;
    }

    protected final boolean d(g gVar) {
        t tVar = new t(this.b, gVar);
        tVar.setSwithcListener(this);
        this.a.a(tVar, c(), true);
        return true;
    }

    protected final void a(int i) {
        this.a.b(i);
    }

    protected final boolean b(int i) {
        ag agVar = this.a;
        if (!agVar.a(i)) {
            return false;
        }
        agVar.c(i).b(false);
        if (agVar.b.getChildCount() == 1) {
            return false;
        }
        agVar.c(i).getRootWindow().a((byte) 15);
        if (agVar.d == agVar.c(i)) {
            int i2 = i > 0 ? i - 1 : i;
            agVar.b.removeViewAt(i);
            agVar.b(i2);
        } else {
            agVar.b.removeViewAt(i);
        }
        return true;
    }

    public final g c(int i) {
        if (this.a.c(i) == null) {
            return null;
        }
        return this.a.c(i).getRootWindow();
    }

    public final g d(int i) {
        if (this.a.c(i) == null) {
            return null;
        }
        return this.a.c(i).getStackTopWindow();
    }

    public final void a(View view) {
        ag agVar = this.a;
        agVar.c.addView(view, -1, new LayoutParams(-1, -1));
    }

    public final void b(View view) {
        this.a.c.removeView(view);
    }

    public final View e() {
        ag agVar = this.a;
        for (int childCount = agVar.c.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = agVar.c.getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                return childAt;
            }
        }
        return null;
    }

    public final View f() {
        return this.a.a;
    }

    public final void a(g gVar, g gVar2) {
        for (int i = 0; i < this.c.size(); i++) {
            o oVar = (o) this.c.get(i);
            if (gVar != null) {
                oVar.b(gVar);
            }
            if (gVar2 != null) {
                oVar.a(gVar2);
            }
        }
    }

    public final g a(int i, g gVar) {
        t c = this.a.c(i);
        if (c == null) {
            return null;
        }
        return a(c, gVar);
    }

    public final int c(g gVar) {
        int childCount = this.a.b.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (c(i) == gVar) {
                return i;
            }
        }
        return -1;
    }
}
