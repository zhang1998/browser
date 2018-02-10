package com.ucpro.ui.widget.ripple;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.TypedValue;

/* compiled from: ProGuard */
class c extends ConstantState {
    int a;
    i[] b;
    TypedValue[] c;
    int d;
    int e;
    boolean f;
    int g;
    boolean h;
    boolean i;
    private boolean j = false;
    private int k = 0;

    c(c cVar, d dVar, Resources resources) {
        int i = 0;
        if (cVar != null) {
            i[] iVarArr = cVar.b;
            int i2 = cVar.a;
            this.a = i2;
            this.b = new i[i2];
            this.d = cVar.d;
            this.e = cVar.e;
            while (i < i2) {
                this.b[i] = new i(iVarArr[i], dVar, resources);
                i++;
            }
            this.f = cVar.f;
            this.g = cVar.g;
            this.h = cVar.h;
            this.i = cVar.i;
            this.j = cVar.j;
            this.k = cVar.k;
            this.c = cVar.c;
            return;
        }
        this.a = 0;
        this.b = null;
    }

    public Drawable newDrawable() {
        return new d(this, null);
    }

    public Drawable newDrawable(Resources resources) {
        return new d(this, resources);
    }

    public int getChangingConfigurations() {
        return this.d;
    }
}
