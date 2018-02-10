package com.tencent.tinker.c.a;

import com.tencent.tinker.c.a.b.c;

/* compiled from: ProGuard */
public final class i implements Comparable<i> {
    public int[] a;
    public int[] b;
    public int c;
    public int d;

    public final /* synthetic */ int compareTo(Object obj) {
        i iVar = (i) obj;
        int a = c.a(this.a, iVar.a);
        if (a != 0) {
            return a;
        }
        a = c.a(this.b, iVar.b);
        if (a == 0) {
            return c.b(this.c, iVar.c);
        }
        return a;
    }

    public i(int[] iArr, int[] iArr2, int i, int i2) {
        this.a = iArr;
        this.b = iArr2;
        this.c = i;
        this.d = i2;
    }
}
