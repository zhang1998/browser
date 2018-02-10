package com.uc.framework.resources;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

/* compiled from: ProGuard */
final class m extends ConstantState {
    public boolean A;
    public boolean B;
    public int a;
    public int b;
    public int c;
    public n d;
    public int[] e;
    public int[] f;
    public float[] g;
    public float[] h;
    public boolean i;
    public int j;
    public int k;
    public int l;
    public float m;
    public float n;
    public float o;
    public float[] p;
    public Rect q;
    public int r;
    public int s;
    public float t;
    public float u;
    public int v;
    public int w;
    public float x;
    public float y;
    public float z;

    m() {
        this.b = 0;
        this.c = 0;
        this.k = -1;
        this.r = -1;
        this.s = -1;
        this.x = 0.5f;
        this.y = 0.5f;
        this.z = 0.5f;
        this.d = n.TOP_BOTTOM;
    }

    m(n nVar) {
        this.b = 0;
        this.c = 0;
        this.k = -1;
        this.r = -1;
        this.s = -1;
        this.x = 0.5f;
        this.y = 0.5f;
        this.z = 0.5f;
        this.d = nVar;
        this.e = null;
    }

    public m(m mVar) {
        this.b = 0;
        this.c = 0;
        this.k = -1;
        this.r = -1;
        this.s = -1;
        this.x = 0.5f;
        this.y = 0.5f;
        this.z = 0.5f;
        this.a = mVar.a;
        this.b = mVar.b;
        this.c = mVar.c;
        this.d = mVar.d;
        if (mVar.e != null) {
            this.e = (int[]) mVar.e.clone();
        }
        if (mVar.h != null) {
            this.h = (float[]) mVar.h.clone();
        }
        this.i = mVar.i;
        this.j = mVar.j;
        this.k = mVar.k;
        this.l = mVar.l;
        this.m = mVar.m;
        this.n = mVar.n;
        this.o = mVar.o;
        if (mVar.p != null) {
            this.p = (float[]) mVar.p.clone();
        }
        if (mVar.q != null) {
            this.q = new Rect(mVar.q);
        }
        this.r = mVar.r;
        this.s = mVar.s;
        this.t = mVar.t;
        this.u = mVar.u;
        this.v = mVar.v;
        this.w = mVar.w;
        this.x = mVar.x;
        this.y = mVar.y;
        this.z = mVar.z;
        this.A = mVar.A;
        this.B = mVar.B;
    }

    public final Drawable newDrawable() {
        return new o();
    }

    public final int getChangingConfigurations() {
        return this.a;
    }
}
