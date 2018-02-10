package com.uc.quark.a;

import android.text.TextUtils;

/* compiled from: ProGuard */
public final class c {
    public static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            m.a(0, new q(str));
        }
    }

    private static String b(String str) {
        int indexOf = str.indexOf(".");
        int indexOf2 = str.indexOf("B");
        if (indexOf == -1 || indexOf2 - indexOf <= 4) {
            return str;
        }
        return a(str.substring(0, indexOf + 3), str.substring(str.length() - 2));
    }

    private static String c(String str) {
        if (str.indexOf(".") == -1) {
            return str;
        }
        return a(str.substring(0, str.indexOf(".")), str.substring(str.length() - 2));
    }

    private static String a(CharSequence... charSequenceArr) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < 2) {
            if (!(charSequenceArr[i] == null || charSequenceArr[i].length() <= 0 || charSequenceArr[i].toString().equals("null"))) {
                stringBuilder.append(charSequenceArr[i]);
            }
            i++;
        }
        return stringBuilder.toString();
    }

    public static String a(long j) {
        String str = "0KB";
        if (j - 1 <= 0) {
            return str;
        }
        double d = ((double) j) / 1024.0d;
        if (d < 1024.0d) {
            return c(String.valueOf(d) + "KB");
        }
        d /= 1024.0d;
        if (d < 1024.0d) {
            return b(String.valueOf(d) + "MB");
        }
        d /= 1024.0d;
        if (d < 1024.0d) {
            return b(String.valueOf(d) + "GB");
        }
        d /= 1024.0d;
        if (d < 1024.0d) {
            return b(String.valueOf(d) + "GB");
        }
        if (str.length() > 0) {
            return str.substring(0, str.length() - 1);
        }
        return str;
    }
}
