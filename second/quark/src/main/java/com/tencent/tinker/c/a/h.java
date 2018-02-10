package com.tencent.tinker.c.a;

import com.tencent.tinker.c.a.b.c;

/* compiled from: ProGuard */
public final class h extends ag<h> {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;

    public final /* synthetic */ int compareTo(Object obj) {
        h hVar = (h) obj;
        int a = c.a(this.a, hVar.a);
        if (a != 0) {
            return a;
        }
        a = c.b(this.b, hVar.b);
        if (a != 0) {
            return a;
        }
        a = c.a(this.c, hVar.c);
        if (a != 0) {
            return a;
        }
        a = c.b(this.d, hVar.d);
        if (a != 0) {
            return a;
        }
        a = c.a(this.e, hVar.e);
        if (a != 0) {
            return a;
        }
        a = c.b(this.f, hVar.f);
        if (a != 0) {
            return a;
        }
        a = c.b(this.g, hVar.g);
        if (a == 0) {
            return c.b(this.h, hVar.h);
        }
        return a;
    }

    public h(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        super(i);
        this.a = i2;
        this.b = i3;
        this.c = i4;
        this.d = i5;
        this.e = i6;
        this.f = i7;
        this.g = i8;
        this.h = i9;
    }
}
