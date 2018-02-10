package com.uc.apollo.media.b;

/* compiled from: ProGuard */
public final class l {
    public static double a(String str, int i, String str2) throws d {
        int indexOf = str.indexOf(58, str2.length()) + 1;
        if (indexOf <= 0 || str.length() <= indexOf) {
            throw new d(str, i, str2 + " must specify a value");
        }
        int indexOf2 = str.indexOf(44, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        String trim = str.substring(indexOf, indexOf2).trim();
        if (trim.length() != 0) {
            return Double.valueOf(trim).doubleValue();
        }
        throw new d(str, i, str2 + " must specify a value");
    }
}
