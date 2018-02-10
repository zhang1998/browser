package com.taobao.weex.utils;

/* compiled from: ProGuard */
final class b {
    int a;
    String b;
    private String c;
    private int d;

    static /* synthetic */ boolean a(b bVar) {
        boolean z = false;
        int i = bVar.d;
        while (bVar.d < bVar.c.length()) {
            char charAt = bVar.c.charAt(bVar.d);
            if (charAt == ' ') {
                int i2 = bVar.d;
                bVar.d = i2 + 1;
                if (i != i2) {
                    break;
                }
                i++;
            } else {
                boolean z2;
                if (('0' > charAt || charAt > '9') && (('a' > charAt || charAt > 'z') && ('A' > charAt || charAt > 'Z'))) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2 || charAt == '.' || charAt == '%' || charAt == '-' || charAt == '+') {
                    bVar.d++;
                } else if (i == bVar.d) {
                    bVar.d++;
                }
            }
        }
        if (i != bVar.d) {
            String substring = bVar.c.substring(i, bVar.d);
            if ("(".equals(substring)) {
                bVar.a = d.c;
                bVar.b = "(";
            } else if (")".equals(substring)) {
                bVar.a = d.d;
                bVar.b = ")";
            } else if (",".equals(substring)) {
                bVar.a = d.e;
                bVar.b = ",";
            } else {
                for (i = 0; i < substring.length(); i++) {
                    charAt = substring.charAt(i);
                    if (('a' > charAt || charAt > 'z') && (('A' > charAt || charAt > 'Z') && charAt != '-')) {
                        break;
                    }
                }
                z = true;
                if (z) {
                    bVar.a = d.a;
                    bVar.b = substring;
                } else {
                    bVar.a = d.b;
                    bVar.b = substring;
                }
            }
            return true;
        }
        bVar.a = 0;
        bVar.b = null;
        return false;
    }

    private b(String str) {
        this.d = 0;
        this.c = str;
    }
}
