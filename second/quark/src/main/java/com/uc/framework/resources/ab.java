package com.uc.framework.resources;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

/* compiled from: ProGuard */
abstract class ab extends ConstantState {
    final ac b;
    int c;
    int d;
    Drawable[] e;
    int f;
    boolean g = false;
    Rect h = null;
    boolean i = false;
    boolean j = false;
    int k;
    int l;
    int m;
    int n;
    boolean o = false;
    int p;
    boolean q = false;
    boolean r;
    boolean s;
    boolean t;

    ab(ab abVar, ac acVar) {
        int i = 0;
        this.b = acVar;
        if (abVar != null) {
            this.c = abVar.c;
            this.d = abVar.d;
            Drawable[] drawableArr = abVar.e;
            this.e = new Drawable[drawableArr.length];
            this.f = abVar.f;
            int i2 = this.f;
            while (i < i2) {
                this.e[i] = drawableArr[i].getConstantState().newDrawable().mutate();
                this.e[i].setCallback(acVar);
                i++;
            }
            this.t = true;
            this.s = true;
            this.g = abVar.g;
            if (abVar.h != null) {
                this.h = new Rect(abVar.h);
            }
            this.i = abVar.i;
            this.j = abVar.j;
            this.k = abVar.k;
            this.l = abVar.l;
            this.o = abVar.o;
            this.p = abVar.p;
            this.q = abVar.q;
            this.r = abVar.r;
            return;
        }
        this.e = new Drawable[10];
        this.f = 0;
        this.t = false;
        this.s = false;
    }

    public int getChangingConfigurations() {
        return this.c;
    }

    final void a() {
        int i = 0;
        this.j = true;
        int i2 = this.f;
        this.l = 0;
        this.k = 0;
        this.n = 0;
        this.m = 0;
        while (i < i2) {
            Drawable drawable = this.e[i];
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (intrinsicWidth > this.k) {
                this.k = intrinsicWidth;
            }
            intrinsicWidth = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.l) {
                this.l = intrinsicWidth;
            }
            intrinsicWidth = drawable.getMinimumWidth();
            if (intrinsicWidth > this.m) {
                this.m = intrinsicWidth;
            }
            int minimumHeight = drawable.getMinimumHeight();
            if (minimumHeight > this.n) {
                this.n = minimumHeight;
            }
            i++;
        }
    }

    void a(int i, int i2) {
        Object obj = new Drawable[i2];
        System.arraycopy(this.e, 0, obj, 0, i);
        this.e = obj;
    }

    final synchronized boolean b() {
        boolean z;
        synchronized (this) {
            if (!this.s) {
                this.t = true;
                int i = this.f;
                for (int i2 = 0; i2 < i; i2++) {
                    if (this.e[i2].getConstantState() == null) {
                        this.t = false;
                        break;
                    }
                }
                this.s = true;
            }
            z = this.t;
        }
        return z;
    }
}
