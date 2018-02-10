package com.uc.translate.a;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* compiled from: ProGuard */
public final class a {
    private static final TimeZone a = TimeZone.getTimeZone("GMT+8");

    public static String a(Date date) {
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(a);
        return simpleDateFormat.format(date);
    }

    public static boolean a(String... strArr) {
        boolean z = true;
        for (int i = 0; i < 2; i++) {
            Object obj;
            String str = strArr[i];
            if (str != null) {
                int length = str.length();
                if (length != 0) {
                    int i2;
                    for (i2 = 0; i2 < length; i2++) {
                        if (!Character.isWhitespace(str.charAt(i2))) {
                            obj = null;
                            break;
                        }
                    }
                    i2 = 1;
                    z &= obj != null ? 1 : 0;
                }
            }
            obj = 1;
            if (obj != null) {
            }
            z &= obj != null ? 1 : 0;
        }
        return z;
    }
}
