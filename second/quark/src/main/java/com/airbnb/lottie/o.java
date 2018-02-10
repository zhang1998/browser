package com.airbnb.lottie;

/* compiled from: ProGuard */
final class o {
    public static final int a = 1;
    public static final int b = 2;
    private static final /* synthetic */ int[] c = new int[]{a, b};

    static int a(int i) {
        switch (i) {
            case 1:
                return a;
            case 2:
                return b;
            default:
                throw new IllegalArgumentException("Unknown trim path type " + i);
        }
    }
}
