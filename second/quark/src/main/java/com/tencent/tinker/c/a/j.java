package com.tencent.tinker.c.a;

import com.tencent.tinker.c.a.b.c;

/* compiled from: ProGuard */
public final class j implements Comparable<j> {
    public int a;
    public int b;
    public int c;

    public final /* synthetic */ int compareTo(Object obj) {
        j jVar = (j) obj;
        int b = c.b(this.a, jVar.a);
        if (b != 0) {
            return b;
        }
        b = c.b(this.b, jVar.b);
        if (b == 0) {
            return c.b(this.c, jVar.c);
        }
        return b;
    }

    public j(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }
}
