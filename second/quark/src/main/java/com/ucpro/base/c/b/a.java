package com.ucpro.base.c.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

/* compiled from: ProGuard */
public final class a extends m implements h {
    public w a;

    public a(Context context) {
        super(context);
        this.a = new w(context);
        this.a.setFocusable(true);
    }

    public final void a(Activity activity) {
    }

    public final void a(Drawable drawable) {
    }

    public final void a(g gVar, boolean z) {
        boolean z2 = true;
        if (this.a.getCurrentWindowStack() == null) {
            a(gVar, -1);
            return;
        }
        boolean z3;
        t currentWindowStack;
        t currentWindowStack2 = this.a.getCurrentWindowStack();
        if (!(gVar == null || gVar.getParent() == null)) {
            int i;
            if (!(currentWindowStack2 == null || gVar == null)) {
                int childCount = currentWindowStack2.getChildCount();
                for (i = 0; i < childCount; i++) {
                    if (((g) currentWindowStack2.getChildAt(i)) == gVar) {
                        z3 = true;
                        break;
                    }
                }
            }
            z3 = false;
            if (z3) {
                currentWindowStack2.a(gVar);
                z3 = true;
            } else {
                t currentWindowStack3 = this.a.getCurrentWindowStack();
                if (currentWindowStack3 != currentWindowStack2) {
                    int childCount2 = currentWindowStack3.getChildCount();
                    for (i = 0; i < childCount2; i++) {
                        if (gVar == ((g) currentWindowStack3.getChildAt(i))) {
                            currentWindowStack3.a(gVar);
                            z3 = true;
                            break;
                        }
                    }
                }
            }
            currentWindowStack = this.a.getCurrentWindowStack();
            if (z3) {
                z2 = false;
            }
            currentWindowStack.a(gVar, z, z2);
        }
        z3 = false;
        currentWindowStack = this.a.getCurrentWindowStack();
        if (z3) {
            z2 = false;
        }
        currentWindowStack.a(gVar, z, z2);
    }

    public final void a(boolean z) {
        if (this.a.getCurrentWindowStack() != null) {
            this.a.getCurrentWindowStack().a(z);
        }
    }

    public final void a(g gVar) {
        if (this.a.getCurrentWindowStack() != null) {
            this.a.getCurrentWindowStack().b(gVar);
        }
    }

    public final void b(boolean z) {
        if (this.a.getCurrentWindowStack() != null) {
            this.a.getCurrentWindowStack().b(z);
        }
    }

    public final g a() {
        if (this.a.getCurrentWindowStack() == null) {
            return null;
        }
        return this.a.getCurrentWindowStack().getStackTopWindow();
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
        if (this.a.getCurrentWindowStack() == null) {
            return null;
        }
        return a(this.a.getCurrentWindowStack(), gVar);
    }

    public final g b() {
        if (this.a.getCurrentWindowStack() == null) {
            return null;
        }
        return this.a.getCurrentWindowStack().getRootWindow();
    }

    public final int c(g gVar) {
        for (int i = 0; i <= 0; i++) {
            if (c(0) == gVar) {
                return 0;
            }
        }
        return -1;
    }

    public final int c() {
        return 1;
    }

    public final int d() {
        return 0;
    }

    protected final boolean a(g gVar, int i) {
        if (this.a.getCurrentWindowStack() == null) {
            View tVar = new t(this.b, gVar);
            tVar.setSwithcListener(this);
            w wVar = this.a;
            wVar.g = tVar;
            tVar.getRootWindow().a((byte) 14);
            wVar.f.addView(tVar, -1);
            wVar.g.setOnHierarchyChangeListener(new x(wVar));
        }
        return true;
    }

    protected final boolean d(g gVar) {
        a(gVar, 1);
        return true;
    }

    protected final void a(int i) {
    }

    protected final boolean b(int i) {
        return this.a.a();
    }

    public final g c(int i) {
        if (this.a.getCurrentWindowStack() == null) {
            return null;
        }
        return this.a.getCurrentWindowStack().getRootWindow();
    }

    public final g d(int i) {
        if (this.a.getCurrentWindowStack() == null) {
            return null;
        }
        return this.a.getCurrentWindowStack().getStackTopWindow();
    }

    public final void a(View view) {
    }

    public final void b(View view) {
    }

    public final View e() {
        return null;
    }

    public final View f() {
        return null;
    }

    public final void g() {
        this.a.a();
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
        t currentWindowStack = this.a.getCurrentWindowStack();
        if (currentWindowStack == null) {
            return null;
        }
        return a(currentWindowStack, gVar);
    }
}
