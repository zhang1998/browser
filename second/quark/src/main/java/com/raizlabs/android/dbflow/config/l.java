package com.raizlabs.android.dbflow.config;

import java.util.Comparator;

/* compiled from: ProGuard */
public final class l implements Comparator<Object> {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int compare(java.lang.Object r18, java.lang.Object r19) {
        /*
        r17 = this;
        r9 = r18.toString();
        r10 = r19.toString();
        r1 = 0;
        r0 = 0;
    L_0x000a:
        r3 = 0;
        r2 = a(r9, r1);
        r5 = a(r10, r0);
        r4 = r1;
        r1 = r2;
        r2 = r3;
    L_0x0016:
        r6 = java.lang.Character.isSpaceChar(r1);
        if (r6 != 0) goto L_0x0020;
    L_0x001c:
        r6 = 48;
        if (r1 != r6) goto L_0x00b5;
    L_0x0020:
        r6 = 48;
        if (r1 != r6) goto L_0x002d;
    L_0x0024:
        r2 = r2 + 1;
    L_0x0026:
        r4 = r4 + 1;
        r1 = a(r9, r4);
        goto L_0x0016;
    L_0x002d:
        r2 = 0;
        goto L_0x0026;
    L_0x002f:
        r6 = java.lang.Character.isSpaceChar(r0);
        if (r6 != 0) goto L_0x0039;
    L_0x0035:
        r6 = 48;
        if (r0 != r6) goto L_0x0048;
    L_0x0039:
        r6 = 48;
        if (r0 != r6) goto L_0x0046;
    L_0x003d:
        r3 = r3 + 1;
    L_0x003f:
        r5 = r5 + 1;
        r0 = a(r10, r5);
        goto L_0x002f;
    L_0x0046:
        r3 = 0;
        goto L_0x003f;
    L_0x0048:
        r6 = java.lang.Character.isDigit(r1);
        if (r6 == 0) goto L_0x00a0;
    L_0x004e:
        r6 = java.lang.Character.isDigit(r0);
        if (r6 == 0) goto L_0x00a0;
    L_0x0054:
        r11 = r9.substring(r4);
        r12 = r10.substring(r5);
        r8 = 0;
        r7 = 0;
        r6 = 0;
    L_0x005f:
        r13 = a(r11, r7);
        r14 = a(r12, r6);
        r15 = java.lang.Character.isDigit(r13);
        if (r15 != 0) goto L_0x0078;
    L_0x006d:
        r15 = java.lang.Character.isDigit(r14);
        if (r15 != 0) goto L_0x0078;
    L_0x0073:
        r6 = r8;
    L_0x0074:
        if (r6 == 0) goto L_0x00a0;
    L_0x0076:
        r0 = r6;
    L_0x0077:
        return r0;
    L_0x0078:
        r15 = java.lang.Character.isDigit(r13);
        if (r15 != 0) goto L_0x0081;
    L_0x007e:
        r8 = -1;
        r6 = r8;
        goto L_0x0074;
    L_0x0081:
        r15 = java.lang.Character.isDigit(r14);
        if (r15 != 0) goto L_0x008a;
    L_0x0087:
        r8 = 1;
        r6 = r8;
        goto L_0x0074;
    L_0x008a:
        if (r13 >= r14) goto L_0x0094;
    L_0x008c:
        if (r8 != 0) goto L_0x008f;
    L_0x008e:
        r8 = -1;
    L_0x008f:
        r7 = r7 + 1;
        r6 = r6 + 1;
        goto L_0x005f;
    L_0x0094:
        if (r13 <= r14) goto L_0x009a;
    L_0x0096:
        if (r8 != 0) goto L_0x008f;
    L_0x0098:
        r8 = 1;
        goto L_0x008f;
    L_0x009a:
        if (r13 != 0) goto L_0x008f;
    L_0x009c:
        if (r14 != 0) goto L_0x008f;
    L_0x009e:
        r6 = r8;
        goto L_0x0074;
    L_0x00a0:
        if (r1 != 0) goto L_0x00a7;
    L_0x00a2:
        if (r0 != 0) goto L_0x00a7;
    L_0x00a4:
        r0 = r2 - r3;
        goto L_0x0077;
    L_0x00a7:
        if (r1 >= r0) goto L_0x00ab;
    L_0x00a9:
        r0 = -1;
        goto L_0x0077;
    L_0x00ab:
        if (r1 <= r0) goto L_0x00af;
    L_0x00ad:
        r0 = 1;
        goto L_0x0077;
    L_0x00af:
        r1 = r4 + 1;
        r0 = r5 + 1;
        goto L_0x000a;
    L_0x00b5:
        r16 = r5;
        r5 = r0;
        r0 = r16;
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.raizlabs.android.dbflow.config.l.compare(java.lang.Object, java.lang.Object):int");
    }

    private static char a(String str, int i) {
        if (i >= str.length()) {
            return '\u0000';
        }
        return str.charAt(i);
    }
}
