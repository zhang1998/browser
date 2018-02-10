package com.uc.a;

/* compiled from: ProGuard */
public final class e {
    public static final int a = a();
    public static final int b = a();
    private static int c = 0;

    private static int a() {
        int i = c;
        c = i + 1;
        return i;
    }
}
