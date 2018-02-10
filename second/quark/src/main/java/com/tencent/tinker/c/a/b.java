package com.tencent.tinker.c.a;

import com.tencent.tinker.c.a.b.c;

/* compiled from: ProGuard */
public final class b extends ag<b> {
    public int[] a;

    public final /* synthetic */ int compareTo(Object obj) {
        b bVar = (b) obj;
        int length = this.a.length;
        int length2 = bVar.a.length;
        if (length != length2) {
            return c.a(length, length2);
        }
        for (length2 = 0; length2 < length; length2++) {
            if (this.a[length2] != bVar.a[length2]) {
                return c.a(this.a[length2], bVar.a[length2]);
            }
        }
        return 0;
    }

    public b(int i, int[] iArr) {
        super(i);
        this.a = iArr;
    }
}
