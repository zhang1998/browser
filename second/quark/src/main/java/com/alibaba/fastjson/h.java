package com.alibaba.fastjson;

/* compiled from: ProGuard */
public enum h {
    CamelCase,
    PascalCase,
    SnakeCase,
    KebabCase;

    public final String a(String str) {
        int i = 0;
        StringBuilder stringBuilder;
        char charAt;
        char charAt2;
        char[] toCharArray;
        switch (g.a[ordinal()]) {
            case 1:
                stringBuilder = new StringBuilder();
                while (i < str.length()) {
                    charAt = str.charAt(i);
                    if (charAt < 'A' || charAt > 'Z') {
                        stringBuilder.append(charAt);
                    } else {
                        charAt = (char) (charAt + 32);
                        if (i > 0) {
                            stringBuilder.append('_');
                        }
                        stringBuilder.append(charAt);
                    }
                    i++;
                }
                return stringBuilder.toString();
            case 2:
                stringBuilder = new StringBuilder();
                while (i < str.length()) {
                    charAt = str.charAt(i);
                    if (charAt < 'A' || charAt > 'Z') {
                        stringBuilder.append(charAt);
                    } else {
                        charAt = (char) (charAt + 32);
                        if (i > 0) {
                            stringBuilder.append('-');
                        }
                        stringBuilder.append(charAt);
                    }
                    i++;
                }
                return stringBuilder.toString();
            case 3:
                charAt2 = str.charAt(0);
                if (charAt2 < 'a' || charAt2 > 'z') {
                    return str;
                }
                toCharArray = str.toCharArray();
                toCharArray[0] = (char) (toCharArray[0] - 32);
                return new String(toCharArray);
            case 4:
                charAt2 = str.charAt(0);
                if (charAt2 < 'A' || charAt2 > 'Z') {
                    return str;
                }
                toCharArray = str.toCharArray();
                toCharArray[0] = (char) (toCharArray[0] + 32);
                return new String(toCharArray);
            default:
                return str;
        }
    }
}
