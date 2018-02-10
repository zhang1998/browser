package com.tencent.tinker.c.a;

import com.tencent.tinker.c.a.b.c;

/* compiled from: ProGuard */
public final class f implements Comparable<f> {
    public int a;
    public int b;
    public int c;

    public final /* synthetic */ int compareTo(Object obj) {
        f fVar = (f) obj;
        int a = c.a(this.a, fVar.a);
        if (a != 0) {
            return a;
        }
        a = c.b(this.b, fVar.b);
        if (a == 0) {
            return c.b(this.c, fVar.c);
        }
        return a;
    }

    public f(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }
}
