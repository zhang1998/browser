package com.tencent.tinker.c.a;

import com.tencent.tinker.c.a.b.c;

/* compiled from: ProGuard */
public final class e implements Comparable<e> {
    public int a;
    public int b;

    public final /* synthetic */ int compareTo(Object obj) {
        e eVar = (e) obj;
        int a = c.a(this.a, eVar.a);
        if (a != 0) {
            return a;
        }
        return c.b(this.b, eVar.b);
    }

    public e(int i, int i2) {
        this.a = i;
        this.b = i2;
    }
}
