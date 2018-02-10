package com.uc.framework.xml;

/* compiled from: ProGuard */
public final class c {
    public static final int a(String str) {
        int i = 16;
        if (str == null) {
            return -1;
        }
        int i2;
        String charSequence = str.toString();
        int length = charSequence.length();
        if ('0' == charSequence.charAt(0)) {
            if (length - 1 == 0) {
                return 0;
            }
            char charAt = charSequence.charAt(1);
            if ('x' == charAt || 'X' == charAt) {
                i2 = 2;
            } else {
                i = 8;
                i2 = 1;
            }
        } else if ('#' == charSequence.charAt(0)) {
            i2 = 1;
        } else {
            i = 10;
            i2 = 0;
        }
        return (int) Long.parseLong(charSequence.substring(i2), i);
    }
}
