package com.uc.apollo.media.base;

/* compiled from: ProGuard */
public class h {
    public static final int TYPE_APOLLO = 4;
    public static final int TYPE_DEFAULT = 1;
    public static final int TYPE_LITTLE_WIN_ACTION = 3;
    public static final int TYPE_LITTLE_WIN_STATE = 2;
    public static final int TYPE_UNKNOWN = 0;

    public static String typeDesc(int i) {
        switch (i) {
            case 1:
                return "default";
            case 2:
                return "little win state";
            case 3:
                return "little win action";
            case 4:
                return "apollo";
            default:
                return "unknown";
        }
    }
}
