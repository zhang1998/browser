package com.ucpro.ui.widget.ripple;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

/* compiled from: ProGuard */
final class i {
    public Drawable a;
    public TypedValue[] b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g = -1;

    i() {
    }

    i(i iVar, d dVar, Resources resources) {
        if (resources != null) {
            this.a = iVar.a.getConstantState().newDrawable(resources);
        } else {
            this.a = iVar.a.getConstantState().newDrawable();
        }
        this.a.setCallback(dVar);
        this.a.setBounds(iVar.a.getBounds());
        this.a.setLevel(iVar.a.getLevel());
        this.b = iVar.b;
        this.c = iVar.c;
        this.d = iVar.d;
        this.e = iVar.e;
        this.f = iVar.f;
        this.g = iVar.g;
    }
}
