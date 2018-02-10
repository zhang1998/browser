package com.taobao.weex.utils;

/* compiled from: ProGuard */
public final class j {
    public static String a(String str) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder(str.length());
        int i2 = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt == '\"') {
                stringBuilder.append("\\\"");
            } else if (charAt == '\'') {
                stringBuilder.append("\\'");
            } else if (charAt == '\\') {
                stringBuilder.append("\\\\");
            } else if (charAt == '/') {
                stringBuilder.append("\\/");
            } else if (charAt == '\t') {
                stringBuilder.append("\\t");
            } else if (charAt == '\n') {
                if (i2 != 13) {
                    stringBuilder.append("\\n");
                }
            } else if (charAt == '\r') {
                stringBuilder.append("\\n");
            } else if (charAt == '\f') {
                stringBuilder.append("\\f");
            } else if (charAt == '\b') {
                stringBuilder.append("\\b");
            } else if (charAt == '\u000b') {
                stringBuilder.append("\\v");
            } else if (charAt == '<') {
                stringBuilder.append("\\u003C");
            } else if (charAt == '>') {
                stringBuilder.append("\\u003E");
            } else if (charAt == ' ') {
                stringBuilder.append("\\u2028");
            } else if (charAt == ' ') {
                stringBuilder.append("\\u2029");
            } else {
                stringBuilder.append(charAt);
            }
            i++;
            char c = charAt;
        }
        return stringBuilder.toString();
    }
}
