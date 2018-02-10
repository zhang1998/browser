package com.tencent.tinker.b.a.a.a;

import com.tencent.tinker.b.a.b.a;
import com.tencent.tinker.b.a.c.f;
import com.tencent.tinker.c.a.a.b;
import com.tencent.tinker.c.a.ab;
import com.tencent.tinker.c.a.ag;
import com.tencent.tinker.c.a.ah;
import com.tencent.tinker.c.a.u;
import java.util.Arrays;

/* compiled from: ProGuard */
public abstract class i<T extends Comparable<T>> {
    protected final a a;
    protected final u b;
    private final com.tencent.tinker.b.a.c.i c;

    protected abstract int a(T t);

    protected abstract ah a(u uVar);

    protected abstract T a(b bVar);

    public i(a aVar, u uVar, com.tencent.tinker.b.a.c.i iVar) {
        this.a = aVar;
        this.b = uVar;
        this.c = iVar;
    }

    protected T a(f fVar, T t) {
        return t;
    }

    protected void a(com.tencent.tinker.b.a.c.i iVar, int i, int i2, int i3, int i4) {
    }

    protected void a(com.tencent.tinker.b.a.c.i iVar, int i, int i2) {
    }

    private int[] a(int i) {
        int i2 = 0;
        int[] iArr = new int[i];
        int i3 = 0;
        while (i2 < i) {
            i3 += ab.a(this.a.b);
            iArr[i2] = i3;
            i2++;
        }
        return iArr;
    }

    private static int a(int i, T t) {
        if (t instanceof ag) {
            return ((ag) t).i;
        }
        return i;
    }

    public final void a() {
        int i;
        b bVar;
        int[] a = a(ab.b(this.a.b));
        int[] a2 = a(ab.b(this.a.b));
        int[] a3 = a(ab.b(this.a.b));
        ah a4 = a(this.b);
        if (a4.a()) {
            b a5 = this.b.a(a4);
            i = a4.c;
            bVar = a5;
        } else {
            i = 0;
            bVar = null;
        }
        int length = a.length;
        int length2 = a2.length;
        int length3 = a3.length;
        int i2 = (i + length2) - length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i3 >= i && i4 >= i2) {
                break;
            } else if (i6 < length2 && a2[i6] == i4) {
                a(a(this.a.b));
                i4++;
                i6++;
            } else if (i5 < length3 && a3[i5] == i4) {
                a(a(this.a.b));
                i4++;
                i5++;
            } else if (Arrays.binarySearch(a, i3) >= 0) {
                a(this.c, i3, a(i3, a(bVar)));
                i3++;
                i7++;
            } else if (Arrays.binarySearch(a3, i3) >= 0) {
                a(this.c, i3, a(i3, a(bVar)));
                i3++;
            } else if (i3 < i) {
                Comparable a6 = a(this.c, a(bVar));
                int a7 = a(a6);
                a(this.c, i3, a(i3, a6), i4, a7);
                i3++;
                i4++;
            }
        }
        if (i6 != length2 || i7 != length || i5 != length3) {
            throw new IllegalStateException(String.format("bad patch operation sequence. addCounter: %d, addCount: %d, delCounter: %d, delCount: %d, replaceCounter: %d, replaceCount:%d", new Object[]{Integer.valueOf(i6), Integer.valueOf(length2), Integer.valueOf(i7), Integer.valueOf(length), Integer.valueOf(i5), Integer.valueOf(length3)}));
        }
    }
}
