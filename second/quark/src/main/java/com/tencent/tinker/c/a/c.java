package com.tencent.tinker.c.a;

/* compiled from: ProGuard */
public final class c extends ag<c> {
    public int[] a;

    public final /* synthetic */ int compareTo(Object obj) {
        c cVar = (c) obj;
        int length = this.a.length;
        int length2 = cVar.a.length;
        if (length != length2) {
            return com.tencent.tinker.c.a.b.c.a(length, length2);
        }
        for (length2 = 0; length2 < length; length2++) {
            if (this.a[length2] != cVar.a[length2]) {
                return com.tencent.tinker.c.a.b.c.a(this.a[length2], cVar.a[length2]);
            }
        }
        return 0;
    }

    public c(int i, int[] iArr) {
        super(i);
        this.a = iArr;
    }
}
