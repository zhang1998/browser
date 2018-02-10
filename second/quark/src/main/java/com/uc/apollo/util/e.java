package com.uc.apollo.util;

import android.content.Context;

/* compiled from: ProGuard */
public final class e {
    public static String a(Context context, String str) {
        if (a(str)) {
            return str;
        }
        if (context != null) {
            str = str.replaceAll("\\$[pP][kK][gG][nN][aA][mM][eE]", context.getPackageName());
        }
        if (a(str)) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(str.length());
        char[] toCharArray = str.toCharArray();
        int length = toCharArray.length - 1;
        int i = 0;
        while (i < length) {
            char c = toCharArray[i];
            if (c == '%') {
                int i2;
                int i3;
                if (toCharArray[i + 1] == 'u') {
                    i2 = 4;
                    i3 = 2;
                } else {
                    i3 = 1;
                    i2 = 2;
                }
                if ((i + i3) + i2 < length + 2) {
                    int i4 = i2 + i3;
                    i2 = 0;
                    while (i3 < i4) {
                        i2 = (i2 << 4) | Character.digit(toCharArray[i + i3], 16);
                        i3++;
                    }
                    stringBuilder.append((char) i2);
                    i = i3 + i;
                }
            }
            stringBuilder.append(c);
            i++;
        }
        if (i == length) {
            stringBuilder.append(toCharArray[i]);
        }
        return stringBuilder.toString();
    }

    public static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean b(String str) {
        return (str == null || str.length() == 0) ? false : true;
    }
}
