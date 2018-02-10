package com.tencent.wxop.stat.a;

public class i {
    static final /* synthetic */ boolean a = (!i.class.desiredAssertionStatus());

    private i() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(byte[] r14) {
        /*
        r13 = -2;
        r12 = -1;
        r11 = 6;
        r3 = 0;
        r0 = r14.length;
        r6 = new com.tencent.wxop.stat.a.g;
        r1 = r0 * 3;
        r1 = r1 / 4;
        r1 = new byte[r1];
        r6.<init>(r1);
        r1 = r6.c;
        if (r1 != r11) goto L_0x001f;
    L_0x0014:
        r0 = r3;
    L_0x0015:
        if (r0 != 0) goto L_0x013c;
    L_0x0017:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "bad base-64";
        r0.<init>(r1);
        throw r0;
    L_0x001f:
        r7 = r0 + 0;
        r0 = r6.c;
        r1 = r6.d;
        r8 = r6.a;
        r9 = r6.e;
        r2 = r3;
        r5 = r0;
        r0 = r3;
    L_0x002c:
        if (r2 >= r7) goto L_0x010f;
    L_0x002e:
        if (r5 != 0) goto L_0x0075;
    L_0x0030:
        r4 = r2 + 4;
        if (r4 > r7) goto L_0x0073;
    L_0x0034:
        r1 = r14[r2];
        r1 = r1 & 255;
        r1 = r9[r1];
        r1 = r1 << 18;
        r4 = r2 + 1;
        r4 = r14[r4];
        r4 = r4 & 255;
        r4 = r9[r4];
        r4 = r4 << 12;
        r1 = r1 | r4;
        r4 = r2 + 2;
        r4 = r14[r4];
        r4 = r4 & 255;
        r4 = r9[r4];
        r4 = r4 << 6;
        r1 = r1 | r4;
        r4 = r2 + 3;
        r4 = r14[r4];
        r4 = r4 & 255;
        r4 = r9[r4];
        r1 = r1 | r4;
        if (r1 < 0) goto L_0x0073;
    L_0x005d:
        r4 = r0 + 2;
        r10 = (byte) r1;
        r8[r4] = r10;
        r4 = r0 + 1;
        r10 = r1 >> 8;
        r10 = (byte) r10;
        r8[r4] = r10;
        r4 = r1 >> 16;
        r4 = (byte) r4;
        r8[r0] = r4;
        r0 = r0 + 3;
        r2 = r2 + 4;
        goto L_0x0030;
    L_0x0073:
        if (r2 >= r7) goto L_0x010f;
    L_0x0075:
        r4 = r2 + 1;
        r2 = r14[r2];
        r2 = r2 & 255;
        r2 = r9[r2];
        switch(r5) {
            case 0: goto L_0x0082;
            case 1: goto L_0x0090;
            case 2: goto L_0x00a1;
            case 3: goto L_0x00c1;
            case 4: goto L_0x00f9;
            case 5: goto L_0x0108;
            default: goto L_0x0080;
        };
    L_0x0080:
        r2 = r4;
        goto L_0x002c;
    L_0x0082:
        if (r2 < 0) goto L_0x008a;
    L_0x0084:
        r1 = r5 + 1;
        r5 = r1;
        r1 = r2;
        r2 = r4;
        goto L_0x002c;
    L_0x008a:
        if (r2 == r12) goto L_0x0080;
    L_0x008c:
        r6.c = r11;
        r0 = r3;
        goto L_0x0015;
    L_0x0090:
        if (r2 < 0) goto L_0x009a;
    L_0x0092:
        r1 = r1 << 6;
        r1 = r1 | r2;
        r2 = r5 + 1;
        r5 = r2;
        r2 = r4;
        goto L_0x002c;
    L_0x009a:
        if (r2 == r12) goto L_0x0080;
    L_0x009c:
        r6.c = r11;
        r0 = r3;
        goto L_0x0015;
    L_0x00a1:
        if (r2 < 0) goto L_0x00ab;
    L_0x00a3:
        r1 = r1 << 6;
        r1 = r1 | r2;
        r2 = r5 + 1;
        r5 = r2;
        r2 = r4;
        goto L_0x002c;
    L_0x00ab:
        if (r2 != r13) goto L_0x00ba;
    L_0x00ad:
        r2 = r0 + 1;
        r5 = r1 >> 4;
        r5 = (byte) r5;
        r8[r0] = r5;
        r0 = 4;
        r5 = r0;
        r0 = r2;
        r2 = r4;
        goto L_0x002c;
    L_0x00ba:
        if (r2 == r12) goto L_0x0080;
    L_0x00bc:
        r6.c = r11;
        r0 = r3;
        goto L_0x0015;
    L_0x00c1:
        if (r2 < 0) goto L_0x00dd;
    L_0x00c3:
        r1 = r1 << 6;
        r1 = r1 | r2;
        r2 = r0 + 2;
        r5 = (byte) r1;
        r8[r2] = r5;
        r2 = r0 + 1;
        r5 = r1 >> 8;
        r5 = (byte) r5;
        r8[r2] = r5;
        r2 = r1 >> 16;
        r2 = (byte) r2;
        r8[r0] = r2;
        r0 = r0 + 3;
        r2 = r4;
        r5 = r3;
        goto L_0x002c;
    L_0x00dd:
        if (r2 != r13) goto L_0x00f2;
    L_0x00df:
        r2 = r0 + 1;
        r5 = r1 >> 2;
        r5 = (byte) r5;
        r8[r2] = r5;
        r2 = r1 >> 10;
        r2 = (byte) r2;
        r8[r0] = r2;
        r0 = r0 + 2;
        r2 = 5;
        r5 = r2;
        r2 = r4;
        goto L_0x002c;
    L_0x00f2:
        if (r2 == r12) goto L_0x0080;
    L_0x00f4:
        r6.c = r11;
        r0 = r3;
        goto L_0x0015;
    L_0x00f9:
        if (r2 != r13) goto L_0x0101;
    L_0x00fb:
        r2 = r5 + 1;
        r5 = r2;
        r2 = r4;
        goto L_0x002c;
    L_0x0101:
        if (r2 == r12) goto L_0x0080;
    L_0x0103:
        r6.c = r11;
        r0 = r3;
        goto L_0x0015;
    L_0x0108:
        if (r2 == r12) goto L_0x0080;
    L_0x010a:
        r6.c = r11;
        r0 = r3;
        goto L_0x0015;
    L_0x010f:
        r2 = r1;
        switch(r5) {
            case 0: goto L_0x0113;
            case 1: goto L_0x011a;
            case 2: goto L_0x011f;
            case 3: goto L_0x0128;
            case 4: goto L_0x0137;
            default: goto L_0x0113;
        };
    L_0x0113:
        r6.c = r5;
        r6.b = r0;
        r0 = 1;
        goto L_0x0015;
    L_0x011a:
        r6.c = r11;
        r0 = r3;
        goto L_0x0015;
    L_0x011f:
        r1 = r0 + 1;
        r2 = r2 >> 4;
        r2 = (byte) r2;
        r8[r0] = r2;
        r0 = r1;
        goto L_0x0113;
    L_0x0128:
        r1 = r0 + 1;
        r4 = r2 >> 10;
        r4 = (byte) r4;
        r8[r0] = r4;
        r0 = r1 + 1;
        r2 = r2 >> 2;
        r2 = (byte) r2;
        r8[r1] = r2;
        goto L_0x0113;
    L_0x0137:
        r6.c = r11;
        r0 = r3;
        goto L_0x0015;
    L_0x013c:
        r0 = r6.b;
        r1 = r6.a;
        r1 = r1.length;
        if (r0 != r1) goto L_0x0146;
    L_0x0143:
        r0 = r6.a;
    L_0x0145:
        return r0;
    L_0x0146:
        r0 = r6.b;
        r0 = new byte[r0];
        r1 = r6.a;
        r2 = r6.b;
        java.lang.System.arraycopy(r1, r3, r0, r3, r2);
        goto L_0x0145;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.a.i.a(byte[]):byte[]");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] b(byte[] r12) {
        /*
        r4 = r12.length;
        r7 = new com.tencent.wxop.stat.a.h;
        r7.<init>();
        r0 = r4 / 3;
        r0 = r0 * 4;
        r1 = r7.f;
        if (r1 == 0) goto L_0x00d4;
    L_0x000e:
        r1 = r4 % 3;
        if (r1 <= 0) goto L_0x0014;
    L_0x0012:
        r0 = r0 + 4;
    L_0x0014:
        r1 = r7.g;
        if (r1 == 0) goto L_0x0027;
    L_0x0018:
        if (r4 <= 0) goto L_0x0027;
    L_0x001a:
        r1 = r4 + -1;
        r1 = r1 / 57;
        r2 = r1 + 1;
        r1 = r7.h;
        if (r1 == 0) goto L_0x00e3;
    L_0x0024:
        r1 = 2;
    L_0x0025:
        r1 = r1 * r2;
        r0 = r0 + r1;
    L_0x0027:
        r1 = new byte[r0];
        r7.a = r1;
        r8 = r7.i;
        r9 = r7.a;
        r5 = 0;
        r3 = r7.e;
        r2 = 0;
        r10 = r4 + 0;
        r1 = -1;
        r4 = r7.d;
        switch(r4) {
            case 0: goto L_0x00e6;
            case 1: goto L_0x00e9;
            case 2: goto L_0x010a;
            default: goto L_0x003b;
        };
    L_0x003b:
        r4 = r1;
    L_0x003c:
        r1 = -1;
        if (r4 == r1) goto L_0x025b;
    L_0x003f:
        r1 = 0;
        r5 = r4 >> 18;
        r5 = r5 & 63;
        r5 = r8[r5];
        r9[r1] = r5;
        r1 = 1;
        r5 = r4 >> 12;
        r5 = r5 & 63;
        r5 = r8[r5];
        r9[r1] = r5;
        r1 = 2;
        r5 = r4 >> 6;
        r5 = r5 & 63;
        r5 = r8[r5];
        r9[r1] = r5;
        r5 = 3;
        r1 = 4;
        r4 = r4 & 63;
        r4 = r8[r4];
        r9[r5] = r4;
        r3 = r3 + -1;
        if (r3 != 0) goto L_0x0257;
    L_0x0066:
        r3 = r7.h;
        if (r3 == 0) goto L_0x0070;
    L_0x006a:
        r3 = 4;
        r1 = 5;
        r4 = 13;
        r9[r3] = r4;
    L_0x0070:
        r5 = r1 + 1;
        r3 = 10;
        r9[r1] = r3;
        r1 = 19;
        r6 = r1;
    L_0x0079:
        r1 = r2 + 3;
        if (r1 > r10) goto L_0x012b;
    L_0x007d:
        r1 = r12[r2];
        r1 = r1 & 255;
        r1 = r1 << 16;
        r3 = r2 + 1;
        r3 = r12[r3];
        r3 = r3 & 255;
        r3 = r3 << 8;
        r1 = r1 | r3;
        r3 = r2 + 2;
        r3 = r12[r3];
        r3 = r3 & 255;
        r1 = r1 | r3;
        r3 = r1 >> 18;
        r3 = r3 & 63;
        r3 = r8[r3];
        r9[r5] = r3;
        r3 = r5 + 1;
        r4 = r1 >> 12;
        r4 = r4 & 63;
        r4 = r8[r4];
        r9[r3] = r4;
        r3 = r5 + 2;
        r4 = r1 >> 6;
        r4 = r4 & 63;
        r4 = r8[r4];
        r9[r3] = r4;
        r3 = r5 + 3;
        r1 = r1 & 63;
        r1 = r8[r1];
        r9[r3] = r1;
        r3 = r2 + 3;
        r2 = r5 + 4;
        r1 = r6 + -1;
        if (r1 != 0) goto L_0x0252;
    L_0x00bf:
        r1 = r7.h;
        if (r1 == 0) goto L_0x024f;
    L_0x00c3:
        r1 = r2 + 1;
        r4 = 13;
        r9[r2] = r4;
    L_0x00c9:
        r5 = r1 + 1;
        r2 = 10;
        r9[r1] = r2;
        r1 = 19;
        r2 = r3;
        r6 = r1;
        goto L_0x0079;
    L_0x00d4:
        r1 = r4 % 3;
        switch(r1) {
            case 0: goto L_0x0014;
            case 1: goto L_0x00db;
            case 2: goto L_0x00df;
            default: goto L_0x00d9;
        };
    L_0x00d9:
        goto L_0x0014;
    L_0x00db:
        r0 = r0 + 2;
        goto L_0x0014;
    L_0x00df:
        r0 = r0 + 3;
        goto L_0x0014;
    L_0x00e3:
        r1 = 1;
        goto L_0x0025;
    L_0x00e6:
        r4 = r1;
        goto L_0x003c;
    L_0x00e9:
        r4 = 2;
        if (r4 > r10) goto L_0x003b;
    L_0x00ec:
        r1 = r7.c;
        r2 = 0;
        r1 = r1[r2];
        r1 = r1 & 255;
        r1 = r1 << 16;
        r2 = 0;
        r2 = r12[r2];
        r2 = r2 & 255;
        r2 = r2 << 8;
        r1 = r1 | r2;
        r4 = 1;
        r2 = 2;
        r4 = r12[r4];
        r4 = r4 & 255;
        r1 = r1 | r4;
        r4 = 0;
        r7.d = r4;
        r4 = r1;
        goto L_0x003c;
    L_0x010a:
        if (r10 <= 0) goto L_0x003b;
    L_0x010c:
        r1 = r7.c;
        r2 = 0;
        r1 = r1[r2];
        r1 = r1 & 255;
        r1 = r1 << 16;
        r2 = r7.c;
        r4 = 1;
        r2 = r2[r4];
        r2 = r2 & 255;
        r2 = r2 << 8;
        r1 = r1 | r2;
        r4 = 0;
        r2 = 1;
        r4 = r12[r4];
        r4 = r4 & 255;
        r1 = r1 | r4;
        r4 = 0;
        r7.d = r4;
        goto L_0x003b;
    L_0x012b:
        r1 = r7.d;
        r1 = r2 - r1;
        r3 = r10 + -1;
        if (r1 != r3) goto L_0x0195;
    L_0x0133:
        r4 = 0;
        r1 = r7.d;
        if (r1 <= 0) goto L_0x018e;
    L_0x0138:
        r1 = r7.c;
        r4 = 0;
        r3 = 1;
        r1 = r1[r4];
    L_0x013e:
        r1 = r1 & 255;
        r4 = r1 << 4;
        r1 = r7.d;
        r1 = r1 - r3;
        r7.d = r1;
        r3 = r5 + 1;
        r1 = r4 >> 6;
        r1 = r1 & 63;
        r1 = r8[r1];
        r9[r5] = r1;
        r1 = r3 + 1;
        r4 = r4 & 63;
        r4 = r8[r4];
        r9[r3] = r4;
        r3 = r7.f;
        if (r3 == 0) goto L_0x0169;
    L_0x015d:
        r3 = r1 + 1;
        r4 = 61;
        r9[r1] = r4;
        r1 = r3 + 1;
        r4 = 61;
        r9[r3] = r4;
    L_0x0169:
        r3 = r7.g;
        if (r3 == 0) goto L_0x017f;
    L_0x016d:
        r3 = r7.h;
        if (r3 == 0) goto L_0x0178;
    L_0x0171:
        r3 = r1 + 1;
        r4 = 13;
        r9[r1] = r4;
        r1 = r3;
    L_0x0178:
        r3 = r1 + 1;
        r4 = 10;
        r9[r1] = r4;
        r1 = r3;
    L_0x017f:
        r5 = r1;
    L_0x0180:
        r1 = com.tencent.wxop.stat.a.h.j;
        if (r1 != 0) goto L_0x022a;
    L_0x0184:
        r1 = r7.d;
        if (r1 == 0) goto L_0x022a;
    L_0x0188:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x018e:
        r3 = r2 + 1;
        r1 = r12[r2];
        r2 = r3;
        r3 = r4;
        goto L_0x013e;
    L_0x0195:
        r1 = r7.d;
        r1 = r2 - r1;
        r3 = r10 + -2;
        if (r1 != r3) goto L_0x020e;
    L_0x019d:
        r4 = 0;
        r1 = r7.d;
        r3 = 1;
        if (r1 <= r3) goto L_0x0201;
    L_0x01a3:
        r1 = r7.c;
        r4 = 0;
        r3 = 1;
        r1 = r1[r4];
    L_0x01a9:
        r1 = r1 & 255;
        r11 = r1 << 10;
        r1 = r7.d;
        if (r1 <= 0) goto L_0x0208;
    L_0x01b1:
        r1 = r7.c;
        r4 = r3 + 1;
        r1 = r1[r3];
        r3 = r4;
    L_0x01b8:
        r1 = r1 & 255;
        r1 = r1 << 2;
        r1 = r1 | r11;
        r4 = r7.d;
        r3 = r4 - r3;
        r7.d = r3;
        r3 = r5 + 1;
        r4 = r1 >> 12;
        r4 = r4 & 63;
        r4 = r8[r4];
        r9[r5] = r4;
        r4 = r3 + 1;
        r5 = r1 >> 6;
        r5 = r5 & 63;
        r5 = r8[r5];
        r9[r3] = r5;
        r3 = r4 + 1;
        r1 = r1 & 63;
        r1 = r8[r1];
        r9[r4] = r1;
        r1 = r7.f;
        if (r1 == 0) goto L_0x024d;
    L_0x01e3:
        r1 = r3 + 1;
        r4 = 61;
        r9[r3] = r4;
    L_0x01e9:
        r3 = r7.g;
        if (r3 == 0) goto L_0x01ff;
    L_0x01ed:
        r3 = r7.h;
        if (r3 == 0) goto L_0x01f8;
    L_0x01f1:
        r3 = r1 + 1;
        r4 = 13;
        r9[r1] = r4;
        r1 = r3;
    L_0x01f8:
        r3 = r1 + 1;
        r4 = 10;
        r9[r1] = r4;
        r1 = r3;
    L_0x01ff:
        r5 = r1;
        goto L_0x0180;
    L_0x0201:
        r3 = r2 + 1;
        r1 = r12[r2];
        r2 = r3;
        r3 = r4;
        goto L_0x01a9;
    L_0x0208:
        r4 = r2 + 1;
        r1 = r12[r2];
        r2 = r4;
        goto L_0x01b8;
    L_0x020e:
        r1 = r7.g;
        if (r1 == 0) goto L_0x0180;
    L_0x0212:
        if (r5 <= 0) goto L_0x0180;
    L_0x0214:
        r1 = 19;
        if (r6 == r1) goto L_0x0180;
    L_0x0218:
        r1 = r7.h;
        if (r1 == 0) goto L_0x024b;
    L_0x021c:
        r1 = r5 + 1;
        r3 = 13;
        r9[r5] = r3;
    L_0x0222:
        r5 = r1 + 1;
        r3 = 10;
        r9[r1] = r3;
        goto L_0x0180;
    L_0x022a:
        r1 = com.tencent.wxop.stat.a.h.j;
        if (r1 != 0) goto L_0x0236;
    L_0x022e:
        if (r2 == r10) goto L_0x0236;
    L_0x0230:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0236:
        r7.b = r5;
        r7.e = r6;
        r1 = a;
        if (r1 != 0) goto L_0x0248;
    L_0x023e:
        r1 = r7.b;
        if (r1 == r0) goto L_0x0248;
    L_0x0242:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0248:
        r0 = r7.a;
        return r0;
    L_0x024b:
        r1 = r5;
        goto L_0x0222;
    L_0x024d:
        r1 = r3;
        goto L_0x01e9;
    L_0x024f:
        r1 = r2;
        goto L_0x00c9;
    L_0x0252:
        r6 = r1;
        r5 = r2;
        r2 = r3;
        goto L_0x0079;
    L_0x0257:
        r6 = r3;
        r5 = r1;
        goto L_0x0079;
    L_0x025b:
        r6 = r3;
        goto L_0x0079;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.a.i.b(byte[]):byte[]");
    }
}
