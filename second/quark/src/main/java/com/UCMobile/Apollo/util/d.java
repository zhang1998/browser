package com.UCMobile.Apollo.util;

/* compiled from: ProGuard */
public final class d {
    public static int a(String str) throws NumberFormatException {
        int i = 0;
        while (i < str.length() && !Character.isDigit(str.charAt(i))) {
            i++;
        }
        int length = str.length();
        while (length > 0 && !Character.isDigit(str.charAt(length - 1))) {
            length--;
        }
        if (length > i) {
            try {
                return Integer.parseInt(str.substring(i, length));
            } catch (NumberFormatException e) {
                throw new NumberFormatException();
            }
        }
        throw new NumberFormatException();
    }
}
