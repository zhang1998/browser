package com.tencent.tinker.c.a;

import com.tencent.tinker.c.a.b.c;

/* compiled from: ProGuard */
public final class ac extends ag<ac> {
    public int a;
    public int b;
    public int c;

    public final /* synthetic */ int compareTo(Object obj) {
        ac acVar = (ac) obj;
        if (this.a != acVar.a) {
            return c.a(this.a, acVar.a);
        }
        if (this.c != acVar.c) {
            return c.a(this.c, acVar.c);
        }
        return c.a(this.b, acVar.b);
    }

    public ac(int i, int i2, int i3, int i4) {
        super(i);
        this.a = i2;
        this.b = i3;
        this.c = i4;
    }
}
