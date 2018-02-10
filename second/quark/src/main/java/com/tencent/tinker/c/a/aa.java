package com.tencent.tinker.c.a;

import com.tencent.tinker.c.a.b.c;

/* compiled from: ProGuard */
public final class aa extends ag<aa> {
    public int a;
    public int b;
    public int c;

    public final /* synthetic */ int compareTo(Object obj) {
        aa aaVar = (aa) obj;
        if (this.a != aaVar.a) {
            return c.a(this.a, aaVar.a);
        }
        if (this.c != aaVar.c) {
            return c.a(this.c, aaVar.c);
        }
        return c.a(this.b, aaVar.b);
    }

    public aa(int i, int i2, int i3, int i4) {
        super(i);
        this.a = i2;
        this.b = i3;
        this.c = i4;
    }
}
