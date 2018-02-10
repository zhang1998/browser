package com.ucweb.common.util.n;

import com.ucweb.common.util.c;
import java.util.List;

/* compiled from: ProGuard */
public final class a {
    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean b(String str) {
        return !a(str);
    }

    public static String a(CharSequence... charSequenceArr) {
        int length = charSequenceArr.length;
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < length) {
            if (!(charSequenceArr[i] == null || charSequenceArr[i].length() <= 0 || charSequenceArr[i].toString().equals("null"))) {
                stringBuilder.append(charSequenceArr[i]);
            }
            i++;
        }
        return stringBuilder.toString();
    }

    public static int a(String str, int i) {
        if (str == null || str.length() == 0) {
            return i;
        }
        boolean startsWith = str.startsWith("0x");
        if (startsWith) {
            str = str.substring(2);
        }
        if (startsWith) {
            return (int) Long.parseLong(str, 16);
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            c.a(e.toString());
            return i;
        }
    }

    public static long c(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        boolean startsWith = str.startsWith("0x");
        if (startsWith) {
            str = str.substring(2);
        }
        if (startsWith) {
            return Long.parseLong(str, 16);
        }
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            c.a(e.toString());
            return 0;
        }
    }

    public static String[] a(String str, String str2) {
        if (a(str)) {
            return new String[0];
        }
        if (str2.length() == 0) {
            return new String[]{str};
        }
        int i;
        int length = str.length();
        int indexOf = str.indexOf(str2, 0);
        int i2 = 0;
        while (indexOf != -1 && indexOf < length) {
            i = i2 + 1;
            if (indexOf >= 0) {
                i2 = str2.length();
            } else {
                i2 = 0;
            }
            indexOf = str.indexOf(str2, i2 + indexOf);
            i2 = i;
        }
        int i3 = i2 + 1;
        String[] strArr = new String[i3];
        int indexOf2 = str.indexOf(str2, 0);
        i = 0;
        i2 = 0;
        while (indexOf2 != -1 && indexOf2 < length) {
            strArr[i2] = str.substring(i, indexOf2);
            indexOf2 += indexOf2 >= 0 ? str2.length() : 0;
            int i4 = i2 + 1;
            i = indexOf2;
            indexOf2 = str.indexOf(str2, indexOf2);
            i2 = i4;
        }
        strArr[i3 - 1] = str.substring(i);
        return strArr;
    }

    public static String[] b(String str, String str2) {
        return str.replace(" ", "").split(str2);
    }

    public static boolean c(String str, String str2) {
        if (str == null) {
            return str2 == null;
        } else {
            return str.equals(str2);
        }
    }

    public static boolean d(String str, String str2) {
        return str != null && str2 != null && str.length() == str2.length() && str.toLowerCase().equalsIgnoreCase(str2);
    }

    public static String a(List<String> list, String str) {
        if (list.isEmpty()) {
            return "";
        }
        int size = list.size();
        StringBuilder stringBuilder = new StringBuilder();
        if (size > 0) {
            stringBuilder.append((String) list.get(0));
            for (int i = 1; i < size; i++) {
                stringBuilder.append(str);
                stringBuilder.append((String) list.get(i));
            }
        }
        return stringBuilder.toString();
    }

    public static String d(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static void a(List list) {
        if (list != null && list.size() > 0) {
            int i = 0;
            while (i < list.size()) {
                if (list.get(i) == null) {
                    list.remove(i);
                    i--;
                }
                i++;
            }
        }
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(String.format("%02X:", new Object[]{Byte.valueOf(bArr[i])}));
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
}
