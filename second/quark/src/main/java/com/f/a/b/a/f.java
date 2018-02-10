package com.f.a.b.a;

/* compiled from: ProGuard */
final class f extends i {
    static final /* synthetic */ boolean h;
    private static final byte[] k = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
    private static final byte[] l = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
    final byte[] a;
    int b;
    int c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    final byte[] g;

    static {
        boolean z;
        if (g.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        h = z;
    }

    public f(int i) {
        boolean z;
        boolean z2 = true;
        this.i = null;
        this.d = (i & 1) == 0;
        if ((i & 2) == 0) {
            z = true;
        } else {
            z = false;
        }
        this.e = z;
        if ((i & 4) == 0) {
            z2 = false;
        }
        this.f = z2;
        this.g = (i & 8) == 0 ? k : l;
        this.a = new byte[2];
        this.b = 0;
        this.c = this.e ? 19 : -1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(byte[] r14, int r15) {
        /*
        r13 = this;
        r0 = 2;
        r12 = 13;
        r11 = 10;
        r2 = 1;
        r3 = 0;
        r7 = r13.g;
        r8 = r13.i;
        r4 = r13.c;
        r9 = r15 + 0;
        r1 = -1;
        r5 = r13.b;
        switch(r5) {
            case 0: goto L_0x00a4;
            case 1: goto L_0x00a8;
            case 2: goto L_0x00c4;
            default: goto L_0x0015;
        };
    L_0x0015:
        r5 = r1;
        r1 = r3;
    L_0x0017:
        r6 = -1;
        if (r5 == r6) goto L_0x01f2;
    L_0x001a:
        r6 = r5 >> 18;
        r6 = r6 & 63;
        r6 = r7[r6];
        r8[r3] = r6;
        r6 = r5 >> 12;
        r6 = r6 & 63;
        r6 = r7[r6];
        r8[r2] = r6;
        r6 = r5 >> 6;
        r6 = r6 & 63;
        r6 = r7[r6];
        r8[r0] = r6;
        r6 = 3;
        r0 = 4;
        r5 = r5 & 63;
        r5 = r7[r5];
        r8[r6] = r5;
        r4 = r4 + -1;
        if (r4 != 0) goto L_0x01ee;
    L_0x003e:
        r4 = r13.f;
        if (r4 == 0) goto L_0x0046;
    L_0x0042:
        r4 = 4;
        r0 = 5;
        r8[r4] = r12;
    L_0x0046:
        r5 = r0 + 1;
        r8[r0] = r11;
        r0 = 19;
        r6 = r0;
    L_0x004d:
        r0 = r1 + 3;
        if (r0 > r9) goto L_0x00e2;
    L_0x0051:
        r0 = r14[r1];
        r0 = r0 & 255;
        r0 = r0 << 16;
        r4 = r1 + 1;
        r4 = r14[r4];
        r4 = r4 & 255;
        r4 = r4 << 8;
        r0 = r0 | r4;
        r4 = r1 + 2;
        r4 = r14[r4];
        r4 = r4 & 255;
        r0 = r0 | r4;
        r4 = r0 >> 18;
        r4 = r4 & 63;
        r4 = r7[r4];
        r8[r5] = r4;
        r4 = r5 + 1;
        r10 = r0 >> 12;
        r10 = r10 & 63;
        r10 = r7[r10];
        r8[r4] = r10;
        r4 = r5 + 2;
        r10 = r0 >> 6;
        r10 = r10 & 63;
        r10 = r7[r10];
        r8[r4] = r10;
        r4 = r5 + 3;
        r0 = r0 & 63;
        r0 = r7[r0];
        r8[r4] = r0;
        r4 = r1 + 3;
        r1 = r5 + 4;
        r0 = r6 + -1;
        if (r0 != 0) goto L_0x01e9;
    L_0x0093:
        r0 = r13.f;
        if (r0 == 0) goto L_0x01e6;
    L_0x0097:
        r0 = r1 + 1;
        r8[r1] = r12;
    L_0x009b:
        r5 = r0 + 1;
        r8[r0] = r11;
        r0 = 19;
        r1 = r4;
        r6 = r0;
        goto L_0x004d;
    L_0x00a4:
        r5 = r1;
        r1 = r3;
        goto L_0x0017;
    L_0x00a8:
        if (r0 > r9) goto L_0x0015;
    L_0x00aa:
        r1 = r13.a;
        r1 = r1[r3];
        r1 = r1 & 255;
        r1 = r1 << 16;
        r5 = r14[r3];
        r5 = r5 & 255;
        r5 = r5 << 8;
        r1 = r1 | r5;
        r5 = r14[r2];
        r5 = r5 & 255;
        r1 = r1 | r5;
        r13.b = r3;
        r5 = r1;
        r1 = r0;
        goto L_0x0017;
    L_0x00c4:
        if (r9 <= 0) goto L_0x0015;
    L_0x00c6:
        r1 = r13.a;
        r1 = r1[r3];
        r1 = r1 & 255;
        r1 = r1 << 16;
        r5 = r13.a;
        r5 = r5[r2];
        r5 = r5 & 255;
        r5 = r5 << 8;
        r1 = r1 | r5;
        r5 = r14[r3];
        r5 = r5 & 255;
        r1 = r1 | r5;
        r13.b = r3;
        r5 = r1;
        r1 = r2;
        goto L_0x0017;
    L_0x00e2:
        r0 = r13.b;
        r0 = r1 - r0;
        r4 = r9 + -1;
        if (r0 != r4) goto L_0x0148;
    L_0x00ea:
        r0 = r13.b;
        if (r0 <= 0) goto L_0x0141;
    L_0x00ee:
        r0 = r13.a;
        r0 = r0[r3];
        r3 = r1;
        r1 = r2;
    L_0x00f4:
        r0 = r0 & 255;
        r4 = r0 << 4;
        r0 = r13.b;
        r0 = r0 - r1;
        r13.b = r0;
        r1 = r5 + 1;
        r0 = r4 >> 6;
        r0 = r0 & 63;
        r0 = r7[r0];
        r8[r5] = r0;
        r0 = r1 + 1;
        r4 = r4 & 63;
        r4 = r7[r4];
        r8[r1] = r4;
        r1 = r13.d;
        if (r1 == 0) goto L_0x011f;
    L_0x0113:
        r1 = r0 + 1;
        r4 = 61;
        r8[r0] = r4;
        r0 = r1 + 1;
        r4 = 61;
        r8[r1] = r4;
    L_0x011f:
        r1 = r13.e;
        if (r1 == 0) goto L_0x0131;
    L_0x0123:
        r1 = r13.f;
        if (r1 == 0) goto L_0x012c;
    L_0x0127:
        r1 = r0 + 1;
        r8[r0] = r12;
        r0 = r1;
    L_0x012c:
        r1 = r0 + 1;
        r8[r0] = r11;
        r0 = r1;
    L_0x0131:
        r1 = r3;
        r5 = r0;
    L_0x0133:
        r0 = h;
        if (r0 != 0) goto L_0x01d1;
    L_0x0137:
        r0 = r13.b;
        if (r0 == 0) goto L_0x01d1;
    L_0x013b:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0141:
        r4 = r1 + 1;
        r0 = r14[r1];
        r1 = r3;
        r3 = r4;
        goto L_0x00f4;
    L_0x0148:
        r0 = r13.b;
        r0 = r1 - r0;
        r4 = r9 + -2;
        if (r0 != r4) goto L_0x01b9;
    L_0x0150:
        r0 = r13.b;
        if (r0 <= r2) goto L_0x01ad;
    L_0x0154:
        r0 = r13.a;
        r0 = r0[r3];
        r3 = r2;
    L_0x0159:
        r0 = r0 & 255;
        r10 = r0 << 10;
        r0 = r13.b;
        if (r0 <= 0) goto L_0x01b3;
    L_0x0161:
        r0 = r13.a;
        r4 = r3 + 1;
        r0 = r0[r3];
        r3 = r4;
    L_0x0168:
        r0 = r0 & 255;
        r0 = r0 << 2;
        r0 = r0 | r10;
        r4 = r13.b;
        r3 = r4 - r3;
        r13.b = r3;
        r3 = r5 + 1;
        r4 = r0 >> 12;
        r4 = r4 & 63;
        r4 = r7[r4];
        r8[r5] = r4;
        r4 = r3 + 1;
        r5 = r0 >> 6;
        r5 = r5 & 63;
        r5 = r7[r5];
        r8[r3] = r5;
        r3 = r4 + 1;
        r0 = r0 & 63;
        r0 = r7[r0];
        r8[r4] = r0;
        r0 = r13.d;
        if (r0 == 0) goto L_0x01e4;
    L_0x0193:
        r0 = r3 + 1;
        r4 = 61;
        r8[r3] = r4;
    L_0x0199:
        r3 = r13.e;
        if (r3 == 0) goto L_0x01ab;
    L_0x019d:
        r3 = r13.f;
        if (r3 == 0) goto L_0x01a6;
    L_0x01a1:
        r3 = r0 + 1;
        r8[r0] = r12;
        r0 = r3;
    L_0x01a6:
        r3 = r0 + 1;
        r8[r0] = r11;
        r0 = r3;
    L_0x01ab:
        r5 = r0;
        goto L_0x0133;
    L_0x01ad:
        r4 = r1 + 1;
        r0 = r14[r1];
        r1 = r4;
        goto L_0x0159;
    L_0x01b3:
        r4 = r1 + 1;
        r0 = r14[r1];
        r1 = r4;
        goto L_0x0168;
    L_0x01b9:
        r0 = r13.e;
        if (r0 == 0) goto L_0x0133;
    L_0x01bd:
        if (r5 <= 0) goto L_0x0133;
    L_0x01bf:
        r0 = 19;
        if (r6 == r0) goto L_0x0133;
    L_0x01c3:
        r0 = r13.f;
        if (r0 == 0) goto L_0x01e2;
    L_0x01c7:
        r0 = r5 + 1;
        r8[r5] = r12;
    L_0x01cb:
        r5 = r0 + 1;
        r8[r0] = r11;
        goto L_0x0133;
    L_0x01d1:
        r0 = h;
        if (r0 != 0) goto L_0x01dd;
    L_0x01d5:
        if (r1 == r9) goto L_0x01dd;
    L_0x01d7:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x01dd:
        r13.j = r5;
        r13.c = r6;
        return r2;
    L_0x01e2:
        r0 = r5;
        goto L_0x01cb;
    L_0x01e4:
        r0 = r3;
        goto L_0x0199;
    L_0x01e6:
        r0 = r1;
        goto L_0x009b;
    L_0x01e9:
        r6 = r0;
        r5 = r1;
        r1 = r4;
        goto L_0x004d;
    L_0x01ee:
        r6 = r4;
        r5 = r0;
        goto L_0x004d;
    L_0x01f2:
        r6 = r4;
        r5 = r3;
        goto L_0x004d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.f.a.b.a.f.a(byte[], int):boolean");
    }
}
