package com.tencent.tinker.c.a;

import com.tencent.tinker.c.a.b.c;

/* compiled from: ProGuard */
public final class ae extends ag<ae> {
    public int a;
    public int b;
    public int c;

    public final /* synthetic */ int compareTo(Object obj) {
        ae aeVar = (ae) obj;
        int a = c.a(this.a, aeVar.a);
        if (a != 0) {
            return a;
        }
        a = c.a(this.b, aeVar.b);
        if (a == 0) {
            return c.b(this.c, aeVar.c);
        }
        return a;
    }

    public ae(int i, int i2, int i3, int i4) {
        super(i);
        this.a = i2;
        this.b = i3;
        this.c = i4;
    }
}
