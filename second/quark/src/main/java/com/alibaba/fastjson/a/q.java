package com.alibaba.fastjson.a;

/* compiled from: ProGuard */
public final class q {
    private final p[] a = new p[16384];
    private final int b = 16383;

    public q() {
        a("$ref", 0, 4, "$ref".hashCode());
        a("@type", 0, 5, "@type".hashCode());
    }

    public final String a(char[] cArr, int i, int i2) {
        int i3 = i2 & this.b;
        p pVar = this.a[i3];
        if (pVar != null) {
            int i4 = 1;
            if (i2 == pVar.c && i == pVar.b.length) {
                i3 = 0;
                while (i3 < i) {
                    if (cArr[i3 + 0] == pVar.b[i3]) {
                        i3++;
                    }
                }
                if (i4 == 0) {
                    return pVar.a;
                }
                return new String(cArr, 0, i);
            }
            i4 = 0;
            if (i4 == 0) {
                return new String(cArr, 0, i);
            }
            return pVar.a;
        }
        String intern = new String(cArr, 0, i).intern();
        this.a[i3] = new p(intern, i2);
        return intern;
    }

    public final String a(String str, int i, int i2, int i3) {
        int i4 = i3 & this.b;
        p pVar = this.a[i4];
        if (pVar == null) {
            if (i2 != str.length()) {
                str = a(str, i, i2);
            }
            String intern = str.intern();
            this.a[i4] = new p(intern, i3);
            return intern;
        } else if (i3 == pVar.c && i2 == pVar.b.length && str.regionMatches(i, pVar.a, 0, i2)) {
            return pVar.a;
        } else {
            return a(str, i, i2);
        }
    }

    private static String a(String str, int i, int i2) {
        char[] cArr = new char[i2];
        str.getChars(i, i + i2, cArr, 0);
        return new String(cArr);
    }
}
