package com.ucpro.base.c.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public abstract class m {
    protected Context b;
    protected List<o> c = new ArrayList();

    public abstract g a();

    public abstract g a(int i, g gVar);

    protected abstract void a(int i);

    public abstract void a(Activity activity);

    public abstract void a(Drawable drawable);

    public abstract void a(View view);

    public abstract void a(g gVar);

    public abstract void a(g gVar, boolean z);

    public abstract void a(boolean z);

    protected abstract boolean a(g gVar, int i);

    public abstract g b();

    public abstract g b(g gVar);

    public abstract void b(View view);

    public abstract void b(boolean z);

    protected abstract boolean b(int i);

    protected abstract int c();

    public abstract int c(g gVar);

    public abstract g c(int i);

    protected abstract int d();

    public abstract g d(int i);

    protected abstract boolean d(g gVar);

    public abstract View e();

    public abstract View f();

    public m(Context context) {
        this.b = context;
    }

    public final Context h() {
        return this.b;
    }

    public final void a(o oVar) {
        if (oVar != null) {
            this.c.add(oVar);
        }
    }
}
