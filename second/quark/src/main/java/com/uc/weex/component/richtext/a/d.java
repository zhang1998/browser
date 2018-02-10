package com.uc.weex.component.richtext.a;

/* compiled from: ProGuard */
public final class d {
    String a;
    String b;
    String c;
    int d;
    int e;
    int f;
    a g = new a();
    d h;
    private k i;

    public d(String str, int i, int i2, int i3, k kVar) {
        this.a = str;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.i = kVar;
        this.b = a(str, false);
        this.c = a(str);
    }

    public final String a(String str, boolean z) {
        int indexOf = str.indexOf(58);
        if (indexOf != -1) {
            String substring = str.substring(0, indexOf);
            if (substring.equals("xml")) {
                return "http://www.w3.org/XML/1998/namespace";
            }
            return ("urn:x-prefix:" + substring).intern();
        } else if (z) {
            return "";
        } else {
            return this.i.b;
        }
    }

    public static String a(String str) {
        int indexOf = str.indexOf(58);
        return indexOf == -1 ? str : str.substring(indexOf + 1).intern();
    }

    public static String b(String str) {
        if (str == null) {
            return str;
        }
        str = str.trim();
        if (str.indexOf("  ") == -1) {
            return str;
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        Object obj = null;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == ' ') {
                if (obj == null) {
                    stringBuffer.append(charAt);
                }
                obj = 1;
            } else {
                stringBuffer.append(charAt);
                obj = null;
            }
        }
        return stringBuffer.toString();
    }
}
