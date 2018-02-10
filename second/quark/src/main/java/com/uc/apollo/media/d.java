package com.uc.apollo.media;

/* compiled from: ProGuard */
public final class d {
    public static int a(int i) {
        if (i <= 0 || i >= 6) {
            return 1;
        }
        return i;
    }

    public static String b(int i) {
        switch (i) {
            case 1:
                return "DEFAULT";
            case 2:
                return "SYSTEM";
            case 3:
                return "EMULATOR";
            case 4:
                return "BP";
            case 5:
                return "APOLLO";
            default:
                return "UNKNOWN";
        }
    }
}
