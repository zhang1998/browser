package com.tencent.tinker.b.c;

/* compiled from: ProGuard */
public final class a {
    public static void a(int i, int i2, int i3) {
        if ((i2 | i3) < 0 || i2 > i || i - i2 < i3) {
            throw new ArrayIndexOutOfBoundsException(i2);
        }
    }
}
