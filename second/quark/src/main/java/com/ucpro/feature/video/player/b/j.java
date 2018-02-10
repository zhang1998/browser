package com.ucpro.feature.video.player.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class j<T> {
    Map<Long, T> a = new HashMap();
    v<T> b;
    ArrayList<Integer> c;
    public ArrayList<x> d = new ArrayList();
    int[] e;
    int[] f;
    boolean g = false;

    public final void a() {
        if (this.b != null) {
            for (int size = this.c.size() - 1; size >= 0; size--) {
                int intValue = ((Integer) this.c.get(size)).intValue();
                int[] iArr = new int[this.d.size()];
                for (int i = 0; i < iArr.length; i++) {
                    iArr[i] = ((x) this.d.get(i)).a;
                }
                this.b.a(intValue, this.a.get(Long.valueOf(a(intValue, iArr))));
            }
        }
    }

    public static boolean a(int i) {
        return ((i + -1) & i) == 0;
    }

    final long a(int i, int... iArr) {
        if (iArr.length != this.d.size()) {
            throw new IllegalArgumentException("function condition(...) must request " + this.d.size() + " args");
        }
        long j = 0;
        for (int length = iArr.length - 1; length >= 0; length--) {
            j |= (long) (c(iArr[length]) << (((iArr.length - length) - 1) * 6));
        }
        return ((long) (i << (iArr.length * 6))) | j;
    }

    private static int c(int i) {
        if (((i - 1) & i) != 0) {
            return -1;
        }
        int i2 = 0;
        do {
            i2++;
        } while ((i >> i2) > 0);
        return i2;
    }

    final int b(int i) {
        int i2 = 0;
        for (int i3 : ((x) this.d.get(i)).c) {
            i2 |= i3;
        }
        return i2;
    }
}
