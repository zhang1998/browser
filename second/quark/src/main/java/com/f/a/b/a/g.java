package com.f.a.b.a;

import java.io.UnsupportedEncodingException;

/* compiled from: ProGuard */
public class g {
    static final /* synthetic */ boolean a = (!g.class.desiredAssertionStatus());

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(java.lang.String r15) {
        /*
        r14 = -2;
        r13 = -1;
        r12 = 6;
        r3 = 0;
        r6 = r15.getBytes();
        r0 = r6.length;
        r7 = new com.f.a.b.a.h;
        r1 = r0 * 3;
        r1 = r1 / 4;
        r1 = new byte[r1];
        r7.<init>(r1);
        r1 = r7.a;
        if (r1 != r12) goto L_0x0023;
    L_0x0018:
        r0 = r3;
    L_0x0019:
        if (r0 != 0) goto L_0x0140;
    L_0x001b:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "bad base-64";
        r0.<init>(r1);
        throw r0;
    L_0x0023:
        r8 = r0 + 0;
        r0 = r7.a;
        r1 = r7.b;
        r9 = r7.i;
        r10 = r7.c;
        r2 = r3;
        r5 = r0;
        r0 = r3;
    L_0x0030:
        if (r2 >= r8) goto L_0x0113;
    L_0x0032:
        if (r5 != 0) goto L_0x0079;
    L_0x0034:
        r4 = r2 + 4;
        if (r4 > r8) goto L_0x0077;
    L_0x0038:
        r1 = r6[r2];
        r1 = r1 & 255;
        r1 = r10[r1];
        r1 = r1 << 18;
        r4 = r2 + 1;
        r4 = r6[r4];
        r4 = r4 & 255;
        r4 = r10[r4];
        r4 = r4 << 12;
        r1 = r1 | r4;
        r4 = r2 + 2;
        r4 = r6[r4];
        r4 = r4 & 255;
        r4 = r10[r4];
        r4 = r4 << 6;
        r1 = r1 | r4;
        r4 = r2 + 3;
        r4 = r6[r4];
        r4 = r4 & 255;
        r4 = r10[r4];
        r1 = r1 | r4;
        if (r1 < 0) goto L_0x0077;
    L_0x0061:
        r4 = r0 + 2;
        r11 = (byte) r1;
        r9[r4] = r11;
        r4 = r0 + 1;
        r11 = r1 >> 8;
        r11 = (byte) r11;
        r9[r4] = r11;
        r4 = r1 >> 16;
        r4 = (byte) r4;
        r9[r0] = r4;
        r0 = r0 + 3;
        r2 = r2 + 4;
        goto L_0x0034;
    L_0x0077:
        if (r2 >= r8) goto L_0x0113;
    L_0x0079:
        r4 = r2 + 1;
        r2 = r6[r2];
        r2 = r2 & 255;
        r2 = r10[r2];
        switch(r5) {
            case 0: goto L_0x0086;
            case 1: goto L_0x0094;
            case 2: goto L_0x00a5;
            case 3: goto L_0x00c5;
            case 4: goto L_0x00fd;
            case 5: goto L_0x010c;
            default: goto L_0x0084;
        };
    L_0x0084:
        r2 = r4;
        goto L_0x0030;
    L_0x0086:
        if (r2 < 0) goto L_0x008e;
    L_0x0088:
        r1 = r5 + 1;
        r5 = r1;
        r1 = r2;
        r2 = r4;
        goto L_0x0030;
    L_0x008e:
        if (r2 == r13) goto L_0x0084;
    L_0x0090:
        r7.a = r12;
        r0 = r3;
        goto L_0x0019;
    L_0x0094:
        if (r2 < 0) goto L_0x009e;
    L_0x0096:
        r1 = r1 << 6;
        r1 = r1 | r2;
        r2 = r5 + 1;
        r5 = r2;
        r2 = r4;
        goto L_0x0030;
    L_0x009e:
        if (r2 == r13) goto L_0x0084;
    L_0x00a0:
        r7.a = r12;
        r0 = r3;
        goto L_0x0019;
    L_0x00a5:
        if (r2 < 0) goto L_0x00af;
    L_0x00a7:
        r1 = r1 << 6;
        r1 = r1 | r2;
        r2 = r5 + 1;
        r5 = r2;
        r2 = r4;
        goto L_0x0030;
    L_0x00af:
        if (r2 != r14) goto L_0x00be;
    L_0x00b1:
        r2 = r0 + 1;
        r5 = r1 >> 4;
        r5 = (byte) r5;
        r9[r0] = r5;
        r0 = 4;
        r5 = r0;
        r0 = r2;
        r2 = r4;
        goto L_0x0030;
    L_0x00be:
        if (r2 == r13) goto L_0x0084;
    L_0x00c0:
        r7.a = r12;
        r0 = r3;
        goto L_0x0019;
    L_0x00c5:
        if (r2 < 0) goto L_0x00e1;
    L_0x00c7:
        r1 = r1 << 6;
        r1 = r1 | r2;
        r2 = r0 + 2;
        r5 = (byte) r1;
        r9[r2] = r5;
        r2 = r0 + 1;
        r5 = r1 >> 8;
        r5 = (byte) r5;
        r9[r2] = r5;
        r2 = r1 >> 16;
        r2 = (byte) r2;
        r9[r0] = r2;
        r0 = r0 + 3;
        r2 = r4;
        r5 = r3;
        goto L_0x0030;
    L_0x00e1:
        if (r2 != r14) goto L_0x00f6;
    L_0x00e3:
        r2 = r0 + 1;
        r5 = r1 >> 2;
        r5 = (byte) r5;
        r9[r2] = r5;
        r2 = r1 >> 10;
        r2 = (byte) r2;
        r9[r0] = r2;
        r0 = r0 + 2;
        r2 = 5;
        r5 = r2;
        r2 = r4;
        goto L_0x0030;
    L_0x00f6:
        if (r2 == r13) goto L_0x0084;
    L_0x00f8:
        r7.a = r12;
        r0 = r3;
        goto L_0x0019;
    L_0x00fd:
        if (r2 != r14) goto L_0x0105;
    L_0x00ff:
        r2 = r5 + 1;
        r5 = r2;
        r2 = r4;
        goto L_0x0030;
    L_0x0105:
        if (r2 == r13) goto L_0x0084;
    L_0x0107:
        r7.a = r12;
        r0 = r3;
        goto L_0x0019;
    L_0x010c:
        if (r2 == r13) goto L_0x0084;
    L_0x010e:
        r7.a = r12;
        r0 = r3;
        goto L_0x0019;
    L_0x0113:
        r2 = r1;
        switch(r5) {
            case 0: goto L_0x0117;
            case 1: goto L_0x011e;
            case 2: goto L_0x0123;
            case 3: goto L_0x012c;
            case 4: goto L_0x013b;
            default: goto L_0x0117;
        };
    L_0x0117:
        r7.a = r5;
        r7.j = r0;
        r0 = 1;
        goto L_0x0019;
    L_0x011e:
        r7.a = r12;
        r0 = r3;
        goto L_0x0019;
    L_0x0123:
        r1 = r0 + 1;
        r2 = r2 >> 4;
        r2 = (byte) r2;
        r9[r0] = r2;
        r0 = r1;
        goto L_0x0117;
    L_0x012c:
        r1 = r0 + 1;
        r4 = r2 >> 10;
        r4 = (byte) r4;
        r9[r0] = r4;
        r0 = r1 + 1;
        r2 = r2 >> 2;
        r2 = (byte) r2;
        r9[r1] = r2;
        goto L_0x0117;
    L_0x013b:
        r7.a = r12;
        r0 = r3;
        goto L_0x0019;
    L_0x0140:
        r0 = r7.j;
        r1 = r7.i;
        r1 = r1.length;
        if (r0 != r1) goto L_0x014a;
    L_0x0147:
        r0 = r7.i;
    L_0x0149:
        return r0;
    L_0x014a:
        r0 = r7.j;
        r0 = new byte[r0];
        r1 = r7.i;
        r2 = r7.j;
        java.lang.System.arraycopy(r1, r3, r0, r3, r2);
        goto L_0x0149;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.f.a.b.a.g.a(java.lang.String):byte[]");
    }

    public static String a(byte[] bArr, int i) {
        try {
            int i2;
            int length = bArr.length;
            f fVar = new f(i);
            int i3 = (length / 3) * 4;
            if (!fVar.d) {
                switch (length % 3) {
                    case 0:
                        break;
                    case 1:
                        i3 += 2;
                        break;
                    case 2:
                        i3 += 3;
                        break;
                    default:
                        break;
                }
            } else if (length % 3 > 0) {
                i3 += 4;
            }
            if (!fVar.e || length <= 0) {
                i2 = i3;
            } else {
                i2 = ((fVar.f ? 2 : 1) * (((length - 1) / 57) + 1)) + i3;
            }
            fVar.i = new byte[i2];
            fVar.a(bArr, length);
            if (a || fVar.j == i2) {
                return new String(fVar.i, "US-ASCII");
            }
            throw new AssertionError();
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    private g() {
    }
}
