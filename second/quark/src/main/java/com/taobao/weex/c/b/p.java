package com.taobao.weex.c.b;

/* compiled from: ProGuard */
public final class p {
    private static final int a = e.COLUMN.ordinal();
    private static final int b = e.COLUMN_REVERSE.ordinal();
    private static final int c = e.ROW.ordinal();
    private static final int d = e.ROW_REVERSE.ordinal();
    private static final int e = l.RELATIVE.ordinal();
    private static final int f = l.ABSOLUTE.ordinal();
    private static final int[] g = new int[]{1, 3, 0, 2};
    private static final int[] h = new int[]{3, 1, 2, 0};
    private static final int[] i = new int[]{1, 3, 0, 2};
    private static final int[] j = new int[]{1, 1, 0, 0};
    private static final int[] k = new int[]{1, 3, 6, 6};
    private static final int[] l = new int[]{3, 1, 7, 7};

    private static float a(k kVar, int i, float f) {
        float f2;
        float f3 = Float.NaN;
        if (i == a || i == b) {
            f2 = kVar.a_.p;
            f3 = kVar.a_.r;
        } else if (i == c || i == d) {
            f2 = kVar.a_.o;
            f3 = kVar.a_.q;
        } else {
            f2 = Float.NaN;
        }
        if (!Float.isNaN(f3) && ((double) f3) >= 0.0d && f > f3) {
            f = f3;
        }
        if (Float.isNaN(f2) || ((double) f2) < 0.0d || f >= f2) {
            return f;
        }
        return f2;
    }

    private static void a(k kVar, int i) {
        if (Float.isNaN(kVar.b.e[j[i]]) && !Float.isNaN(kVar.a_.n[j[i]]) && ((double) kVar.a_.n[j[i]]) > 0.0d) {
            kVar.b.e[j[i]] = Math.max(a(kVar, i, kVar.a_.n[j[i]]), ((kVar.a_.k.a(k[i], g[i]) + kVar.a_.k.a(l[i], h[i])) + kVar.a_.l.a(k[i], g[i])) + kVar.a_.l.a(l[i], h[i]));
        }
    }

    private static float b(k kVar, int i) {
        float f = kVar.a_.m[g[i]];
        if (!Float.isNaN(f)) {
            return f;
        }
        f = kVar.a_.m[h[i]];
        return Float.isNaN(f) ? 0.0f : -f;
    }

    private static int a(int i, d dVar) {
        if (dVar != d.RTL) {
            return i;
        }
        if (i == c) {
            return d;
        }
        if (i == d) {
            return c;
        }
        return i;
    }

    private static b a(k kVar, k kVar2) {
        if (kVar2.a_.f != b.AUTO) {
            return kVar2.a_.f;
        }
        return kVar.a_.e;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(com.taobao.weex.c.b.h r54, com.taobao.weex.c.b.k r55, float r56, com.taobao.weex.c.b.d r57) {
        /*
        r4 = r55.e_();
        if (r4 != 0) goto L_0x003e;
    L_0x0006:
        r0 = r55;
        r4 = r0.c;
        r4 = r4.b;
        r0 = r55;
        r5 = r0.b;
        r5 = r5.e;
        r6 = 1;
        r5 = r5[r6];
        r4 = com.taobao.weex.c.b.o.a(r4, r5);
        if (r4 == 0) goto L_0x003e;
    L_0x001b:
        r0 = r55;
        r4 = r0.c;
        r4 = r4.a;
        r0 = r55;
        r5 = r0.b;
        r5 = r5.e;
        r6 = 0;
        r5 = r5[r6];
        r4 = com.taobao.weex.c.b.o.a(r4, r5);
        if (r4 == 0) goto L_0x003e;
    L_0x0030:
        r0 = r55;
        r4 = r0.c;
        r4 = r4.c;
        r0 = r56;
        r4 = com.taobao.weex.c.b.o.a(r4, r0);
        if (r4 != 0) goto L_0x007c;
    L_0x003e:
        r4 = 1;
    L_0x003f:
        if (r4 == 0) goto L_0x1735;
    L_0x0041:
        r0 = r55;
        r4 = r0.c;
        r0 = r55;
        r5 = r0.b;
        r5 = r5.e;
        r6 = 0;
        r5 = r5[r6];
        r4.a = r5;
        r0 = r55;
        r4 = r0.c;
        r0 = r55;
        r5 = r0.b;
        r5 = r5.e;
        r6 = 1;
        r5 = r5[r6];
        r4.b = r5;
        r0 = r55;
        r4 = r0.c;
        r0 = r56;
        r4.c = r0;
        r4 = 0;
        r5 = r55.e();
    L_0x006c:
        if (r4 >= r5) goto L_0x007e;
    L_0x006e:
        r0 = r55;
        r6 = r0.a(r4);
        r6 = r6.b;
        r6.a();
        r4 = r4 + 1;
        goto L_0x006c;
    L_0x007c:
        r4 = 0;
        goto L_0x003f;
    L_0x007e:
        r0 = r55;
        r4 = r0.k;
        if (r4 == 0) goto L_0x1725;
    L_0x0084:
        r0 = r55;
        r4 = r0.a_;
        r4 = r4.a;
        r5 = com.taobao.weex.c.b.d.INHERIT;
        if (r4 != r5) goto L_0x1772;
    L_0x008e:
        if (r57 != 0) goto L_0x0092;
    L_0x0090:
        r57 = com.taobao.weex.c.b.d.LTR;
    L_0x0092:
        r0 = r55;
        r4 = r0.a_;
        r4 = r4.b;
        r4 = r4.ordinal();
        r0 = r57;
        r37 = a(r4, r0);
        r4 = a;
        r0 = r37;
        if (r0 == r4) goto L_0x00ae;
    L_0x00a8:
        r4 = b;
        r0 = r37;
        if (r0 != r4) goto L_0x028b;
    L_0x00ae:
        r4 = c;
        r0 = r57;
        r4 = a(r4, r0);
    L_0x00b6:
        r5 = c;
        r0 = r57;
        r38 = a(r5, r0);
        r0 = r55;
        r1 = r37;
        a(r0, r1);
        r0 = r55;
        a(r0, r4);
        r0 = r55;
        r5 = r0.b;
        r0 = r57;
        r5.f = r0;
        r0 = r55;
        r5 = r0.b;
        r5 = r5.d;
        r6 = g;
        r6 = r6[r37];
        r7 = r5[r6];
        r0 = r55;
        r8 = r0.a_;
        r8 = r8.j;
        r9 = k;
        r9 = r9[r37];
        r10 = g;
        r10 = r10[r37];
        r8 = r8.a(r9, r10);
        r0 = r55;
        r1 = r37;
        r9 = b(r0, r1);
        r8 = r8 + r9;
        r7 = r7 + r8;
        r5[r6] = r7;
        r0 = r55;
        r5 = r0.b;
        r5 = r5.d;
        r6 = h;
        r6 = r6[r37];
        r7 = r5[r6];
        r0 = r55;
        r8 = r0.a_;
        r8 = r8.j;
        r9 = l;
        r9 = r9[r37];
        r10 = h;
        r10 = r10[r37];
        r8 = r8.a(r9, r10);
        r0 = r55;
        r1 = r37;
        r9 = b(r0, r1);
        r8 = r8 + r9;
        r7 = r7 + r8;
        r5[r6] = r7;
        r0 = r55;
        r5 = r0.b;
        r5 = r5.d;
        r6 = g;
        r6 = r6[r4];
        r7 = r5[r6];
        r0 = r55;
        r8 = r0.a_;
        r8 = r8.j;
        r9 = k;
        r9 = r9[r4];
        r10 = g;
        r10 = r10[r4];
        r8 = r8.a(r9, r10);
        r0 = r55;
        r9 = b(r0, r4);
        r8 = r8 + r9;
        r7 = r7 + r8;
        r5[r6] = r7;
        r0 = r55;
        r5 = r0.b;
        r5 = r5.d;
        r6 = h;
        r6 = r6[r4];
        r7 = r5[r6];
        r0 = r55;
        r8 = r0.a_;
        r8 = r8.j;
        r9 = l;
        r9 = r9[r4];
        r10 = h;
        r10 = r10[r4];
        r8 = r8.a(r9, r10);
        r0 = r55;
        r9 = b(r0, r4);
        r8 = r8 + r9;
        r7 = r7 + r8;
        r5[r6] = r7;
        r26 = r55.e();
        r0 = r55;
        r5 = r0.a_;
        r5 = r5.k;
        r6 = k;
        r6 = r6[r38];
        r7 = g;
        r7 = r7[r38];
        r5 = r5.a(r6, r7);
        r0 = r55;
        r6 = r0.a_;
        r6 = r6.l;
        r7 = k;
        r7 = r7[r38];
        r8 = g;
        r8 = r8[r38];
        r6 = r6.a(r7, r8);
        r5 = r5 + r6;
        r0 = r55;
        r6 = r0.a_;
        r6 = r6.k;
        r7 = l;
        r7 = r7[r38];
        r8 = h;
        r8 = r8[r38];
        r6 = r6.a(r7, r8);
        r0 = r55;
        r7 = r0.a_;
        r7 = r7.l;
        r8 = l;
        r8 = r8[r38];
        r9 = h;
        r9 = r9[r38];
        r7 = r7.a(r8, r9);
        r6 = r6 + r7;
        r39 = r5 + r6;
        r5 = r55.d_();
        if (r5 == 0) goto L_0x0361;
    L_0x01cc:
        r0 = r55;
        r5 = r0.b;
        r5 = r5.e;
        r6 = j;
        r6 = r6[r38];
        r5 = r5[r6];
        r5 = java.lang.Float.isNaN(r5);
        if (r5 != 0) goto L_0x028f;
    L_0x01de:
        r5 = 1;
    L_0x01df:
        r0 = r55;
        r6 = r0.a_;
        r6 = r6.n;
        r7 = j;
        r7 = r7[r38];
        r6 = r6[r7];
        r6 = java.lang.Float.isNaN(r6);
        if (r6 != 0) goto L_0x0292;
    L_0x01f1:
        r0 = r55;
        r6 = r0.a_;
        r6 = r6.n;
        r7 = j;
        r7 = r7[r38];
        r6 = r6[r7];
        r6 = (double) r6;
        r8 = 0;
        r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r6 < 0) goto L_0x0292;
    L_0x0204:
        r0 = r55;
        r6 = r0.a_;
        r6 = r6.n;
        r7 = 0;
        r6 = r6[r7];
    L_0x020d:
        r7 = r6 - r39;
        r0 = r55;
        r6 = r0.a_;
        r6 = r6.n;
        r8 = j;
        r8 = r8[r38];
        r6 = r6[r8];
        r6 = java.lang.Float.isNaN(r6);
        if (r6 != 0) goto L_0x0234;
    L_0x0221:
        r0 = r55;
        r6 = r0.a_;
        r6 = r6.n;
        r8 = j;
        r8 = r8[r38];
        r6 = r6[r8];
        r8 = (double) r6;
        r10 = 0;
        r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r6 >= 0) goto L_0x02cb;
    L_0x0234:
        if (r5 != 0) goto L_0x02cb;
    L_0x0236:
        r5 = 1;
    L_0x0237:
        r0 = r55;
        r6 = r0.a_;
        r6 = r6.n;
        r8 = j;
        r9 = a;
        r8 = r8[r9];
        r6 = r6[r8];
        r6 = java.lang.Float.isNaN(r6);
        if (r6 != 0) goto L_0x0260;
    L_0x024b:
        r0 = r55;
        r6 = r0.a_;
        r6 = r6.n;
        r8 = j;
        r9 = a;
        r8 = r8[r9];
        r6 = r6[r8];
        r8 = (double) r6;
        r10 = 0;
        r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r6 >= 0) goto L_0x02ce;
    L_0x0260:
        r0 = r55;
        r6 = r0.b;
        r6 = r6.e;
        r8 = j;
        r9 = a;
        r8 = r8[r9];
        r6 = r6[r8];
        r6 = java.lang.Float.isNaN(r6);
        if (r6 == 0) goto L_0x02ce;
    L_0x0274:
        r6 = 1;
    L_0x0275:
        if (r5 != 0) goto L_0x0279;
    L_0x0277:
        if (r6 == 0) goto L_0x035f;
    L_0x0279:
        r0 = r54;
        r8 = r0.a;
        r9 = r55.d_();
        if (r9 != 0) goto L_0x02d0;
    L_0x0283:
        r4 = new java.lang.RuntimeException;
        r5 = "Measure function isn't defined!";
        r4.<init>(r5);
        throw r4;
    L_0x028b:
        r4 = a;
        goto L_0x00b6;
    L_0x028f:
        r5 = 0;
        goto L_0x01df;
    L_0x0292:
        if (r5 == 0) goto L_0x02a2;
    L_0x0294:
        r0 = r55;
        r6 = r0.b;
        r6 = r6.e;
        r7 = j;
        r7 = r7[r38];
        r6 = r6[r7];
        goto L_0x020d;
    L_0x02a2:
        r0 = r55;
        r6 = r0.a_;
        r6 = r6.j;
        r7 = k;
        r7 = r7[r38];
        r8 = g;
        r8 = r8[r38];
        r6 = r6.a(r7, r8);
        r0 = r55;
        r7 = r0.a_;
        r7 = r7.j;
        r8 = l;
        r8 = r8[r38];
        r9 = h;
        r9 = r9[r38];
        r7 = r7.a(r8, r9);
        r6 = r6 + r7;
        r6 = r56 - r6;
        goto L_0x020d;
    L_0x02cb:
        r5 = 0;
        goto L_0x0237;
    L_0x02ce:
        r6 = 0;
        goto L_0x0275;
    L_0x02d0:
        r9 = 2143289344; // 0x7fc00000 float:NaN double:1.058925634E-314;
        r8.b = r9;
        r9 = 2143289344; // 0x7fc00000 float:NaN double:1.058925634E-314;
        r8.a = r9;
        r0 = r55;
        r9 = r0.i;
        if (r9 == 0) goto L_0x02e7;
    L_0x02de:
        r0 = r55;
        r9 = r0.i;
        r0 = r55;
        r9.a(r0, r7, r8);
    L_0x02e7:
        if (r5 == 0) goto L_0x02f6;
    L_0x02e9:
        r0 = r55;
        r5 = r0.b;
        r5 = r5.e;
        r7 = 0;
        r9 = r8.a;
        r9 = r9 + r39;
        r5[r7] = r9;
    L_0x02f6:
        if (r6 == 0) goto L_0x035f;
    L_0x02f8:
        r0 = r55;
        r5 = r0.b;
        r5 = r5.e;
        r6 = 1;
        r7 = r8.b;
        r0 = r55;
        r8 = r0.a_;
        r8 = r8.k;
        r9 = k;
        r10 = a;
        r9 = r9[r10];
        r10 = g;
        r11 = a;
        r10 = r10[r11];
        r8 = r8.a(r9, r10);
        r0 = r55;
        r9 = r0.a_;
        r9 = r9.l;
        r10 = k;
        r11 = a;
        r10 = r10[r11];
        r11 = g;
        r12 = a;
        r11 = r11[r12];
        r9 = r9.a(r10, r11);
        r8 = r8 + r9;
        r0 = r55;
        r9 = r0.a_;
        r9 = r9.k;
        r10 = l;
        r11 = a;
        r10 = r10[r11];
        r11 = h;
        r12 = a;
        r11 = r11[r12];
        r9 = r9.a(r10, r11);
        r0 = r55;
        r10 = r0.a_;
        r10 = r10.l;
        r11 = l;
        r12 = a;
        r11 = r11[r12];
        r12 = h;
        r13 = a;
        r12 = r12[r13];
        r10 = r10.a(r11, r12);
        r9 = r9 + r10;
        r8 = r8 + r9;
        r7 = r7 + r8;
        r5[r6] = r7;
    L_0x035f:
        if (r26 == 0) goto L_0x1725;
    L_0x0361:
        r0 = r55;
        r5 = r0.a_;
        r5 = r5.h;
        r6 = com.taobao.weex.c.b.n.WRAP;
        if (r5 != r6) goto L_0x051e;
    L_0x036b:
        r5 = 1;
    L_0x036c:
        r0 = r55;
        r6 = r0.a_;
        r0 = r6.c;
        r40 = r0;
        r0 = r55;
        r6 = r0.a_;
        r6 = r6.k;
        r7 = k;
        r7 = r7[r37];
        r8 = g;
        r8 = r8[r37];
        r6 = r6.a(r7, r8);
        r0 = r55;
        r7 = r0.a_;
        r7 = r7.l;
        r8 = k;
        r8 = r8[r37];
        r9 = g;
        r9 = r9[r37];
        r7 = r7.a(r8, r9);
        r34 = r6 + r7;
        r0 = r55;
        r6 = r0.a_;
        r6 = r6.k;
        r7 = k;
        r7 = r7[r4];
        r8 = g;
        r8 = r8[r4];
        r6 = r6.a(r7, r8);
        r0 = r55;
        r7 = r0.a_;
        r7 = r7.l;
        r8 = k;
        r8 = r8[r4];
        r9 = g;
        r9 = r9[r4];
        r7 = r7.a(r8, r9);
        r25 = r6 + r7;
        r0 = r55;
        r6 = r0.a_;
        r6 = r6.k;
        r7 = k;
        r7 = r7[r37];
        r8 = g;
        r8 = r8[r37];
        r6 = r6.a(r7, r8);
        r0 = r55;
        r7 = r0.a_;
        r7 = r7.l;
        r8 = k;
        r8 = r8[r37];
        r9 = g;
        r9 = r9[r37];
        r7 = r7.a(r8, r9);
        r6 = r6 + r7;
        r0 = r55;
        r7 = r0.a_;
        r7 = r7.k;
        r8 = l;
        r8 = r8[r37];
        r9 = h;
        r9 = r9[r37];
        r7 = r7.a(r8, r9);
        r0 = r55;
        r8 = r0.a_;
        r8 = r8.l;
        r9 = l;
        r9 = r9[r37];
        r10 = h;
        r10 = r10[r37];
        r8 = r8.a(r9, r10);
        r7 = r7 + r8;
        r41 = r6 + r7;
        r0 = r55;
        r6 = r0.a_;
        r6 = r6.k;
        r7 = k;
        r7 = r7[r4];
        r8 = g;
        r8 = r8[r4];
        r6 = r6.a(r7, r8);
        r0 = r55;
        r7 = r0.a_;
        r7 = r7.l;
        r8 = k;
        r8 = r8[r4];
        r9 = g;
        r9 = r9[r4];
        r7 = r7.a(r8, r9);
        r6 = r6 + r7;
        r0 = r55;
        r7 = r0.a_;
        r7 = r7.k;
        r8 = l;
        r8 = r8[r4];
        r9 = h;
        r9 = r9[r4];
        r7 = r7.a(r8, r9);
        r0 = r55;
        r8 = r0.a_;
        r8 = r8.l;
        r9 = l;
        r9 = r9[r4];
        r10 = h;
        r10 = r10[r4];
        r8 = r8.a(r9, r10);
        r7 = r7 + r8;
        r42 = r6 + r7;
        r0 = r55;
        r6 = r0.b;
        r6 = r6.e;
        r7 = j;
        r7 = r7[r37];
        r6 = r6[r7];
        r6 = java.lang.Float.isNaN(r6);
        if (r6 != 0) goto L_0x0521;
    L_0x046a:
        r6 = 1;
    L_0x046b:
        r0 = r55;
        r7 = r0.b;
        r7 = r7.e;
        r8 = j;
        r8 = r8[r4];
        r7 = r7[r8];
        r7 = java.lang.Float.isNaN(r7);
        if (r7 != 0) goto L_0x0524;
    L_0x047d:
        r7 = 1;
    L_0x047e:
        r8 = c;
        r0 = r37;
        if (r0 == r8) goto L_0x048a;
    L_0x0484:
        r8 = d;
        r0 = r37;
        if (r0 != r8) goto L_0x0527;
    L_0x048a:
        r8 = 1;
        r36 = r8;
    L_0x048d:
        r15 = 0;
        r14 = 0;
        r8 = 2143289344; // 0x7fc00000 float:NaN double:1.058925634E-314;
        if (r6 == 0) goto L_0x04a1;
    L_0x0493:
        r0 = r55;
        r8 = r0.b;
        r8 = r8.e;
        r9 = j;
        r9 = r9[r37];
        r8 = r8[r9];
        r8 = r8 - r41;
    L_0x04a1:
        r27 = 0;
        r13 = 0;
        r12 = 0;
        r11 = 0;
        r10 = 0;
        r9 = 0;
        r28 = r9;
        r29 = r10;
        r30 = r11;
        r10 = r15;
    L_0x04af:
        r0 = r26;
        if (r13 >= r0) goto L_0x1310;
    L_0x04b3:
        r22 = 0;
        r21 = 0;
        r20 = 0;
        r19 = 0;
        if (r6 == 0) goto L_0x04c3;
    L_0x04bd:
        r9 = com.taobao.weex.c.b.f.FLEX_START;
        r0 = r40;
        if (r0 == r9) goto L_0x04cb;
    L_0x04c3:
        if (r6 != 0) goto L_0x052c;
    L_0x04c5:
        r9 = com.taobao.weex.c.b.f.CENTER;
        r0 = r40;
        if (r0 == r9) goto L_0x052c;
    L_0x04cb:
        r9 = 1;
        r11 = r9;
    L_0x04cd:
        if (r11 == 0) goto L_0x052f;
    L_0x04cf:
        r9 = r26;
    L_0x04d1:
        r18 = 1;
        r17 = 0;
        r16 = 0;
        r15 = 0;
        r31 = r13;
        r23 = r14;
        r24 = r10;
        r35 = r27;
        r13 = r26;
        r14 = r18;
        r10 = r34;
        r18 = r20;
        r20 = r22;
        r51 = r11;
        r11 = r16;
        r16 = r51;
        r52 = r19;
        r19 = r21;
        r21 = r12;
        r12 = r17;
        r17 = r52;
        r53 = r9;
        r9 = r15;
        r15 = r53;
    L_0x04ff:
        r0 = r35;
        r1 = r26;
        if (r0 >= r1) goto L_0x1762;
    L_0x0505:
        r0 = r55;
        r1 = r35;
        r32 = r0.a(r1);
        r0 = r32;
        r0 = r0.k;
        r22 = r0;
        if (r22 != 0) goto L_0x0532;
    L_0x0515:
        r22 = r35 + 1;
    L_0x0517:
        r31 = r35 + 1;
        r35 = r31;
        r31 = r22;
        goto L_0x04ff;
    L_0x051e:
        r5 = 0;
        goto L_0x036c;
    L_0x0521:
        r6 = 0;
        goto L_0x046b;
    L_0x0524:
        r7 = 0;
        goto L_0x047e;
    L_0x0527:
        r8 = 0;
        r36 = r8;
        goto L_0x048d;
    L_0x052c:
        r9 = 0;
        r11 = r9;
        goto L_0x04cd;
    L_0x052f:
        r9 = r27;
        goto L_0x04d1;
    L_0x0532:
        r0 = r28;
        r1 = r32;
        r1.d = r0;
        r22 = 0;
        r0 = r22;
        r1 = r32;
        r1.e = r0;
        r22 = 0;
        r0 = r22;
        r1 = r32;
        r1.f = r0;
        r0 = r55;
        r1 = r32;
        r43 = a(r0, r1);
        r22 = com.taobao.weex.c.b.b.STRETCH;
        r0 = r43;
        r1 = r22;
        if (r0 != r1) goto L_0x085f;
    L_0x0558:
        r0 = r32;
        r0 = r0.a_;
        r22 = r0;
        r0 = r22;
        r0 = r0.g;
        r22 = r0;
        r33 = com.taobao.weex.c.b.l.RELATIVE;
        r0 = r22;
        r1 = r33;
        if (r0 != r1) goto L_0x085f;
    L_0x056c:
        if (r7 == 0) goto L_0x085f;
    L_0x056e:
        r0 = r32;
        r0 = r0.a_;
        r22 = r0;
        r0 = r22;
        r0 = r0.n;
        r22 = r0;
        r33 = j;
        r33 = r33[r4];
        r22 = r22[r33];
        r22 = java.lang.Float.isNaN(r22);
        if (r22 != 0) goto L_0x05a3;
    L_0x0586:
        r0 = r32;
        r0 = r0.a_;
        r22 = r0;
        r0 = r22;
        r0 = r0.n;
        r22 = r0;
        r33 = j;
        r33 = r33[r4];
        r22 = r22[r33];
        r0 = r22;
        r0 = (double) r0;
        r44 = r0;
        r46 = 0;
        r22 = (r44 > r46 ? 1 : (r44 == r46 ? 0 : -1));
        if (r22 >= 0) goto L_0x085f;
    L_0x05a3:
        r0 = r32;
        r0 = r0.b;
        r22 = r0;
        r0 = r22;
        r0 = r0.e;
        r22 = r0;
        r33 = j;
        r33 = r33[r4];
        r0 = r55;
        r0 = r0.b;
        r44 = r0;
        r0 = r44;
        r0 = r0.e;
        r44 = r0;
        r45 = j;
        r45 = r45[r4];
        r44 = r44[r45];
        r44 = r44 - r42;
        r0 = r32;
        r0 = r0.a_;
        r45 = r0;
        r0 = r45;
        r0 = r0.j;
        r45 = r0;
        r46 = k;
        r46 = r46[r4];
        r47 = g;
        r47 = r47[r4];
        r45 = r45.a(r46, r47);
        r0 = r32;
        r0 = r0.a_;
        r46 = r0;
        r0 = r46;
        r0 = r0.j;
        r46 = r0;
        r47 = l;
        r47 = r47[r4];
        r48 = h;
        r48 = r48[r4];
        r46 = r46.a(r47, r48);
        r45 = r45 + r46;
        r44 = r44 - r45;
        r0 = r32;
        r1 = r44;
        r44 = a(r0, r4, r1);
        r0 = r32;
        r0 = r0.a_;
        r45 = r0;
        r0 = r45;
        r0 = r0.k;
        r45 = r0;
        r46 = k;
        r46 = r46[r4];
        r47 = g;
        r47 = r47[r4];
        r45 = r45.a(r46, r47);
        r0 = r32;
        r0 = r0.a_;
        r46 = r0;
        r0 = r46;
        r0 = r0.l;
        r46 = r0;
        r47 = k;
        r47 = r47[r4];
        r48 = g;
        r48 = r48[r4];
        r46 = r46.a(r47, r48);
        r45 = r45 + r46;
        r0 = r32;
        r0 = r0.a_;
        r46 = r0;
        r0 = r46;
        r0 = r0.k;
        r46 = r0;
        r47 = l;
        r47 = r47[r4];
        r48 = h;
        r48 = r48[r4];
        r46 = r46.a(r47, r48);
        r0 = r32;
        r0 = r0.a_;
        r47 = r0;
        r0 = r47;
        r0 = r0.l;
        r47 = r0;
        r48 = l;
        r48 = r48[r4];
        r49 = h;
        r49 = r49[r4];
        r47 = r47.a(r48, r49);
        r46 = r46 + r47;
        r45 = r45 + r46;
        r44 = java.lang.Math.max(r44, r45);
        r22[r33] = r44;
    L_0x066f:
        r33 = 0;
        if (r6 == 0) goto L_0x0ab4;
    L_0x0673:
        r0 = r32;
        r0 = r0.a_;
        r22 = r0;
        r0 = r22;
        r0 = r0.g;
        r22 = r0;
        r44 = com.taobao.weex.c.b.l.RELATIVE;
        r0 = r22;
        r1 = r44;
        if (r0 != r1) goto L_0x0ab4;
    L_0x0687:
        r0 = r32;
        r0 = r0.a_;
        r22 = r0;
        r0 = r22;
        r0 = r0.i;
        r22 = r0;
        r44 = 0;
        r22 = (r22 > r44 ? 1 : (r22 == r44 ? 0 : -1));
        if (r22 <= 0) goto L_0x0ab4;
    L_0x0699:
        r19 = r19 + 1;
        r0 = r32;
        r0 = r0.a_;
        r21 = r0;
        r0 = r21;
        r0 = r0.i;
        r21 = r0;
        r18 = r18 + r21;
        if (r12 != 0) goto L_0x06ad;
    L_0x06ab:
        r12 = r32;
    L_0x06ad:
        if (r11 == 0) goto L_0x06b3;
    L_0x06af:
        r0 = r32;
        r11.f = r0;
    L_0x06b3:
        r0 = r32;
        r11 = r0.a_;
        r11 = r11.k;
        r21 = k;
        r21 = r21[r37];
        r22 = g;
        r22 = r22[r37];
        r0 = r21;
        r1 = r22;
        r11 = r11.a(r0, r1);
        r0 = r32;
        r0 = r0.a_;
        r21 = r0;
        r0 = r21;
        r0 = r0.l;
        r21 = r0;
        r22 = k;
        r22 = r22[r37];
        r33 = g;
        r33 = r33[r37];
        r0 = r21;
        r1 = r22;
        r2 = r33;
        r21 = r0.a(r1, r2);
        r11 = r11 + r21;
        r0 = r32;
        r0 = r0.a_;
        r21 = r0;
        r0 = r21;
        r0 = r0.k;
        r21 = r0;
        r22 = l;
        r22 = r22[r37];
        r33 = h;
        r33 = r33[r37];
        r0 = r21;
        r1 = r22;
        r2 = r33;
        r21 = r0.a(r1, r2);
        r0 = r32;
        r0 = r0.a_;
        r22 = r0;
        r0 = r22;
        r0 = r0.l;
        r22 = r0;
        r33 = l;
        r33 = r33[r37];
        r44 = h;
        r44 = r44[r37];
        r0 = r22;
        r1 = r33;
        r2 = r44;
        r22 = r0.a(r1, r2);
        r21 = r21 + r22;
        r11 = r11 + r21;
        r0 = r32;
        r0 = r0.a_;
        r21 = r0;
        r0 = r21;
        r0 = r0.j;
        r21 = r0;
        r22 = k;
        r22 = r22[r37];
        r33 = g;
        r33 = r33[r37];
        r0 = r21;
        r1 = r22;
        r2 = r33;
        r21 = r0.a(r1, r2);
        r0 = r32;
        r0 = r0.a_;
        r22 = r0;
        r0 = r22;
        r0 = r0.j;
        r22 = r0;
        r33 = l;
        r33 = r33[r37];
        r44 = h;
        r44 = r44[r37];
        r0 = r22;
        r1 = r33;
        r2 = r44;
        r22 = r0.a(r1, r2);
        r21 = r21 + r22;
        r11 = r11 + r21;
        r22 = r11;
        r11 = r32;
    L_0x076d:
        if (r5 == 0) goto L_0x0bb8;
    L_0x076f:
        if (r6 == 0) goto L_0x0bb8;
    L_0x0771:
        r21 = r20 + r22;
        r21 = (r21 > r8 ? 1 : (r21 == r8 ? 0 : -1));
        if (r21 <= 0) goto L_0x0bb8;
    L_0x0777:
        r0 = r35;
        r1 = r27;
        if (r0 == r1) goto L_0x0bb8;
    L_0x077d:
        r17 = r17 + -1;
        r21 = 1;
        r22 = r17;
        r17 = r21;
        r21 = r12;
        r12 = r18;
        r18 = r23;
        r23 = r19;
        r19 = r24;
    L_0x078f:
        r14 = 0;
        r16 = 0;
        if (r6 == 0) goto L_0x0dc3;
    L_0x0794:
        r11 = r8 - r20;
    L_0x0796:
        if (r23 == 0) goto L_0x0f99;
    L_0x0798:
        r22 = r11 / r12;
        r20 = r21;
        r51 = r12;
        r12 = r11;
        r11 = r51;
    L_0x07a1:
        if (r20 == 0) goto L_0x0dce;
    L_0x07a3:
        r0 = r20;
        r0 = r0.k;
        r23 = r0;
        if (r23 == 0) goto L_0x0857;
    L_0x07ab:
        r0 = r20;
        r0 = r0.a_;
        r23 = r0;
        r0 = r23;
        r0 = r0.i;
        r23 = r0;
        r23 = r23 * r22;
        r0 = r20;
        r0 = r0.a_;
        r24 = r0;
        r0 = r24;
        r0 = r0.k;
        r24 = r0;
        r27 = k;
        r27 = r27[r37];
        r32 = g;
        r32 = r32[r37];
        r0 = r24;
        r1 = r27;
        r2 = r32;
        r24 = r0.a(r1, r2);
        r0 = r20;
        r0 = r0.a_;
        r27 = r0;
        r0 = r27;
        r0 = r0.l;
        r27 = r0;
        r32 = k;
        r32 = r32[r37];
        r33 = g;
        r33 = r33[r37];
        r0 = r27;
        r1 = r32;
        r2 = r33;
        r27 = r0.a(r1, r2);
        r24 = r24 + r27;
        r0 = r20;
        r0 = r0.a_;
        r27 = r0;
        r0 = r27;
        r0 = r0.k;
        r27 = r0;
        r32 = l;
        r32 = r32[r37];
        r33 = h;
        r33 = r33[r37];
        r0 = r27;
        r1 = r32;
        r2 = r33;
        r27 = r0.a(r1, r2);
        r0 = r20;
        r0 = r0.a_;
        r32 = r0;
        r0 = r32;
        r0 = r0.l;
        r32 = r0;
        r33 = l;
        r33 = r33[r37];
        r35 = h;
        r35 = r35[r37];
        r0 = r32;
        r1 = r33;
        r2 = r35;
        r32 = r0.a(r1, r2);
        r27 = r27 + r32;
        r24 = r24 + r27;
        r23 = r23 + r24;
        r0 = r20;
        r1 = r37;
        r2 = r23;
        r24 = a(r0, r1, r2);
        r23 = (r23 > r24 ? 1 : (r23 == r24 ? 0 : -1));
        if (r23 == 0) goto L_0x0857;
    L_0x0847:
        r12 = r12 - r24;
        r0 = r20;
        r0 = r0.a_;
        r23 = r0;
        r0 = r23;
        r0 = r0.i;
        r23 = r0;
        r11 = r11 - r23;
    L_0x0857:
        r0 = r20;
        r0 = r0.f;
        r20 = r0;
        goto L_0x07a1;
    L_0x085f:
        r0 = r32;
        r0 = r0.a_;
        r22 = r0;
        r0 = r22;
        r0 = r0.g;
        r22 = r0;
        r33 = com.taobao.weex.c.b.l.ABSOLUTE;
        r0 = r22;
        r1 = r33;
        if (r0 != r1) goto L_0x066f;
    L_0x0873:
        if (r24 != 0) goto L_0x0877;
    L_0x0875:
        r24 = r32;
    L_0x0877:
        if (r23 == 0) goto L_0x087f;
    L_0x0879:
        r0 = r32;
        r1 = r23;
        r1.e = r0;
    L_0x087f:
        r22 = 0;
        r33 = r22;
    L_0x0883:
        r22 = 2;
        r0 = r33;
        r1 = r22;
        if (r0 >= r1) goto L_0x175e;
    L_0x088b:
        if (r33 == 0) goto L_0x0a88;
    L_0x088d:
        r22 = c;
    L_0x088f:
        r0 = r55;
        r0 = r0.b;
        r23 = r0;
        r0 = r23;
        r0 = r0.e;
        r23 = r0;
        r44 = j;
        r44 = r44[r22];
        r23 = r23[r44];
        r23 = java.lang.Float.isNaN(r23);
        if (r23 != 0) goto L_0x0a82;
    L_0x08a7:
        r0 = r32;
        r0 = r0.a_;
        r23 = r0;
        r0 = r23;
        r0 = r0.n;
        r23 = r0;
        r44 = j;
        r44 = r44[r22];
        r23 = r23[r44];
        r23 = java.lang.Float.isNaN(r23);
        if (r23 != 0) goto L_0x08dc;
    L_0x08bf:
        r0 = r32;
        r0 = r0.a_;
        r23 = r0;
        r0 = r23;
        r0 = r0.n;
        r23 = r0;
        r44 = j;
        r44 = r44[r22];
        r23 = r23[r44];
        r0 = r23;
        r0 = (double) r0;
        r44 = r0;
        r46 = 0;
        r23 = (r44 > r46 ? 1 : (r44 == r46 ? 0 : -1));
        if (r23 >= 0) goto L_0x0a82;
    L_0x08dc:
        r0 = r32;
        r0 = r0.a_;
        r23 = r0;
        r0 = r23;
        r0 = r0.m;
        r23 = r0;
        r44 = g;
        r44 = r44[r22];
        r23 = r23[r44];
        r23 = java.lang.Float.isNaN(r23);
        if (r23 != 0) goto L_0x0a82;
    L_0x08f4:
        r0 = r32;
        r0 = r0.a_;
        r23 = r0;
        r0 = r23;
        r0 = r0.m;
        r23 = r0;
        r44 = h;
        r44 = r44[r22];
        r23 = r23[r44];
        r23 = java.lang.Float.isNaN(r23);
        if (r23 != 0) goto L_0x0a82;
    L_0x090c:
        r0 = r32;
        r0 = r0.b;
        r23 = r0;
        r0 = r23;
        r0 = r0.e;
        r44 = r0;
        r23 = j;
        r45 = r23[r22];
        r0 = r55;
        r0 = r0.b;
        r23 = r0;
        r0 = r23;
        r0 = r0.e;
        r23 = r0;
        r46 = j;
        r46 = r46[r22];
        r23 = r23[r46];
        r0 = r55;
        r0 = r0.a_;
        r46 = r0;
        r0 = r46;
        r0 = r0.k;
        r46 = r0;
        r47 = k;
        r47 = r47[r22];
        r48 = g;
        r48 = r48[r22];
        r46 = r46.a(r47, r48);
        r0 = r55;
        r0 = r0.a_;
        r47 = r0;
        r0 = r47;
        r0 = r0.l;
        r47 = r0;
        r48 = k;
        r48 = r48[r22];
        r49 = g;
        r49 = r49[r22];
        r47 = r47.a(r48, r49);
        r46 = r46 + r47;
        r0 = r55;
        r0 = r0.a_;
        r47 = r0;
        r0 = r47;
        r0 = r0.k;
        r47 = r0;
        r48 = l;
        r48 = r48[r22];
        r49 = h;
        r49 = r49[r22];
        r47 = r47.a(r48, r49);
        r0 = r55;
        r0 = r0.a_;
        r48 = r0;
        r0 = r48;
        r0 = r0.l;
        r48 = r0;
        r49 = l;
        r49 = r49[r22];
        r50 = h;
        r50 = r50[r22];
        r48 = r48.a(r49, r50);
        r47 = r47 + r48;
        r46 = r46 + r47;
        r23 = r23 - r46;
        r0 = r32;
        r0 = r0.a_;
        r46 = r0;
        r0 = r46;
        r0 = r0.j;
        r46 = r0;
        r47 = k;
        r47 = r47[r22];
        r48 = g;
        r48 = r48[r22];
        r46 = r46.a(r47, r48);
        r0 = r32;
        r0 = r0.a_;
        r47 = r0;
        r0 = r47;
        r0 = r0.j;
        r47 = r0;
        r48 = l;
        r48 = r48[r22];
        r49 = h;
        r49 = r49[r22];
        r47 = r47.a(r48, r49);
        r46 = r46 + r47;
        r46 = r23 - r46;
        r0 = r32;
        r0 = r0.a_;
        r23 = r0;
        r0 = r23;
        r0 = r0.m;
        r23 = r0;
        r47 = g;
        r47 = r47[r22];
        r23 = r23[r47];
        r23 = java.lang.Float.isNaN(r23);
        if (r23 == 0) goto L_0x0a8c;
    L_0x09e2:
        r23 = 0;
    L_0x09e4:
        r46 = r46 - r23;
        r0 = r32;
        r0 = r0.a_;
        r23 = r0;
        r0 = r23;
        r0 = r0.m;
        r23 = r0;
        r47 = h;
        r47 = r47[r22];
        r23 = r23[r47];
        r23 = java.lang.Float.isNaN(r23);
        if (r23 == 0) goto L_0x0aa0;
    L_0x09fe:
        r23 = 0;
    L_0x0a00:
        r23 = r46 - r23;
        r0 = r32;
        r1 = r22;
        r2 = r23;
        r23 = a(r0, r1, r2);
        r0 = r32;
        r0 = r0.a_;
        r46 = r0;
        r0 = r46;
        r0 = r0.k;
        r46 = r0;
        r47 = k;
        r47 = r47[r22];
        r48 = g;
        r48 = r48[r22];
        r46 = r46.a(r47, r48);
        r0 = r32;
        r0 = r0.a_;
        r47 = r0;
        r0 = r47;
        r0 = r0.l;
        r47 = r0;
        r48 = k;
        r48 = r48[r22];
        r49 = g;
        r49 = r49[r22];
        r47 = r47.a(r48, r49);
        r46 = r46 + r47;
        r0 = r32;
        r0 = r0.a_;
        r47 = r0;
        r0 = r47;
        r0 = r0.k;
        r47 = r0;
        r48 = l;
        r48 = r48[r22];
        r49 = h;
        r49 = r49[r22];
        r47 = r47.a(r48, r49);
        r0 = r32;
        r0 = r0.a_;
        r48 = r0;
        r0 = r48;
        r0 = r0.l;
        r48 = r0;
        r49 = l;
        r49 = r49[r22];
        r50 = h;
        r22 = r50[r22];
        r0 = r48;
        r1 = r49;
        r2 = r22;
        r22 = r0.a(r1, r2);
        r22 = r22 + r47;
        r22 = r22 + r46;
        r0 = r23;
        r1 = r22;
        r22 = java.lang.Math.max(r0, r1);
        r44[r45] = r22;
    L_0x0a82:
        r22 = r33 + 1;
        r33 = r22;
        goto L_0x0883;
    L_0x0a88:
        r22 = a;
        goto L_0x088f;
    L_0x0a8c:
        r0 = r32;
        r0 = r0.a_;
        r23 = r0;
        r0 = r23;
        r0 = r0.m;
        r23 = r0;
        r47 = g;
        r47 = r47[r22];
        r23 = r23[r47];
        goto L_0x09e4;
    L_0x0aa0:
        r0 = r32;
        r0 = r0.a_;
        r23 = r0;
        r0 = r23;
        r0 = r0.m;
        r23 = r0;
        r47 = h;
        r47 = r47[r22];
        r23 = r23[r47];
        goto L_0x0a00;
    L_0x0ab4:
        r22 = 2143289344; // 0x7fc00000 float:NaN double:1.058925634E-314;
        if (r36 != 0) goto L_0x0b01;
    L_0x0ab8:
        r0 = r55;
        r0 = r0.a_;
        r22 = r0;
        r0 = r22;
        r0 = r0.n;
        r22 = r0;
        r44 = j;
        r44 = r44[r38];
        r22 = r22[r44];
        r22 = java.lang.Float.isNaN(r22);
        if (r22 != 0) goto L_0x0b7a;
    L_0x0ad0:
        r0 = r55;
        r0 = r0.a_;
        r22 = r0;
        r0 = r22;
        r0 = r0.n;
        r22 = r0;
        r44 = j;
        r44 = r44[r38];
        r22 = r22[r44];
        r0 = r22;
        r0 = (double) r0;
        r44 = r0;
        r46 = 0;
        r22 = (r44 > r46 ? 1 : (r44 == r46 ? 0 : -1));
        if (r22 < 0) goto L_0x0b7a;
    L_0x0aed:
        r0 = r55;
        r0 = r0.b;
        r22 = r0;
        r0 = r22;
        r0 = r0.e;
        r22 = r0;
        r44 = j;
        r44 = r44[r38];
        r22 = r22[r44];
        r22 = r22 - r39;
    L_0x0b01:
        if (r21 != 0) goto L_0x0b0e;
    L_0x0b03:
        r0 = r54;
        r1 = r32;
        r2 = r22;
        r3 = r57;
        a(r0, r1, r2, r3);
    L_0x0b0e:
        r0 = r32;
        r0 = r0.a_;
        r21 = r0;
        r0 = r21;
        r0 = r0.g;
        r21 = r0;
        r22 = com.taobao.weex.c.b.l.RELATIVE;
        r0 = r21;
        r1 = r22;
        if (r0 != r1) goto L_0x175a;
    L_0x0b22:
        r17 = r17 + 1;
        r0 = r32;
        r0 = r0.b;
        r21 = r0;
        r0 = r21;
        r0 = r0.e;
        r21 = r0;
        r22 = j;
        r22 = r22[r37];
        r21 = r21[r22];
        r0 = r32;
        r0 = r0.a_;
        r22 = r0;
        r0 = r22;
        r0 = r0.j;
        r22 = r0;
        r33 = k;
        r33 = r33[r37];
        r44 = g;
        r44 = r44[r37];
        r0 = r22;
        r1 = r33;
        r2 = r44;
        r22 = r0.a(r1, r2);
        r21 = r21 + r22;
        r0 = r32;
        r0 = r0.a_;
        r22 = r0;
        r0 = r22;
        r0 = r0.j;
        r22 = r0;
        r33 = l;
        r33 = r33[r37];
        r44 = h;
        r44 = r44[r37];
        r0 = r22;
        r1 = r33;
        r2 = r44;
        r22 = r0.a(r1, r2);
        r21 = r21 + r22;
        r22 = r21;
        goto L_0x076d;
    L_0x0b7a:
        r0 = r55;
        r0 = r0.a_;
        r22 = r0;
        r0 = r22;
        r0 = r0.j;
        r22 = r0;
        r44 = k;
        r44 = r44[r38];
        r45 = g;
        r45 = r45[r38];
        r0 = r22;
        r1 = r44;
        r2 = r45;
        r22 = r0.a(r1, r2);
        r0 = r55;
        r0 = r0.a_;
        r44 = r0;
        r0 = r44;
        r0 = r0.j;
        r44 = r0;
        r45 = l;
        r45 = r45[r38];
        r46 = h;
        r46 = r46[r38];
        r44 = r44.a(r45, r46);
        r22 = r22 + r44;
        r22 = r56 - r22;
        r22 = r22 - r39;
        goto L_0x0b01;
    L_0x0bb8:
        if (r16 == 0) goto L_0x0bf8;
    L_0x0bba:
        r0 = r32;
        r0 = r0.a_;
        r21 = r0;
        r0 = r21;
        r0 = r0.g;
        r21 = r0;
        r31 = com.taobao.weex.c.b.l.RELATIVE;
        r0 = r21;
        r1 = r31;
        if (r0 != r1) goto L_0x0bf4;
    L_0x0bce:
        r0 = r32;
        r0 = r0.a_;
        r21 = r0;
        r0 = r21;
        r0 = r0.g;
        r21 = r0;
        r31 = com.taobao.weex.c.b.l.RELATIVE;
        r0 = r21;
        r1 = r31;
        if (r0 != r1) goto L_0x0bf8;
    L_0x0be2:
        r0 = r32;
        r0 = r0.a_;
        r21 = r0;
        r0 = r21;
        r0 = r0.i;
        r21 = r0;
        r31 = 0;
        r21 = (r21 > r31 ? 1 : (r21 == r31 ? 0 : -1));
        if (r21 <= 0) goto L_0x0bf8;
    L_0x0bf4:
        r16 = 0;
        r15 = r35;
    L_0x0bf8:
        if (r14 == 0) goto L_0x0c39;
    L_0x0bfa:
        r0 = r32;
        r0 = r0.a_;
        r21 = r0;
        r0 = r21;
        r0 = r0.g;
        r21 = r0;
        r31 = com.taobao.weex.c.b.l.RELATIVE;
        r0 = r21;
        r1 = r31;
        if (r0 != r1) goto L_0x0c36;
    L_0x0c0e:
        r21 = com.taobao.weex.c.b.b.STRETCH;
        r0 = r43;
        r1 = r21;
        if (r0 == r1) goto L_0x0c1e;
    L_0x0c16:
        r21 = com.taobao.weex.c.b.b.FLEX_START;
        r0 = r43;
        r1 = r21;
        if (r0 != r1) goto L_0x0c36;
    L_0x0c1e:
        r0 = r32;
        r0 = r0.b;
        r21 = r0;
        r0 = r21;
        r0 = r0.e;
        r21 = r0;
        r31 = j;
        r31 = r31[r4];
        r21 = r21[r31];
        r21 = java.lang.Float.isNaN(r21);
        if (r21 == 0) goto L_0x0c39;
    L_0x0c36:
        r14 = 0;
        r13 = r35;
    L_0x0c39:
        if (r16 == 0) goto L_0x0d53;
    L_0x0c3b:
        r0 = r32;
        r0 = r0.b;
        r21 = r0;
        r0 = r21;
        r0 = r0.d;
        r21 = r0;
        r31 = i;
        r31 = r31[r37];
        r33 = r21[r31];
        r33 = r33 + r10;
        r21[r31] = r33;
        if (r6 == 0) goto L_0x0c9f;
    L_0x0c53:
        r0 = r32;
        r0 = r0.b;
        r21 = r0;
        r0 = r21;
        r0 = r0.d;
        r21 = r0;
        r31 = h;
        r31 = r31[r37];
        r0 = r55;
        r0 = r0.b;
        r33 = r0;
        r0 = r33;
        r0 = r0.e;
        r33 = r0;
        r43 = j;
        r43 = r43[r37];
        r33 = r33[r43];
        r0 = r32;
        r0 = r0.b;
        r43 = r0;
        r0 = r43;
        r0 = r0.e;
        r43 = r0;
        r44 = j;
        r44 = r44[r37];
        r43 = r43[r44];
        r33 = r33 - r43;
        r0 = r32;
        r0 = r0.b;
        r43 = r0;
        r0 = r43;
        r0 = r0.d;
        r43 = r0;
        r44 = i;
        r44 = r44[r37];
        r43 = r43[r44];
        r33 = r33 - r43;
        r21[r31] = r33;
    L_0x0c9f:
        r0 = r32;
        r0 = r0.b;
        r21 = r0;
        r0 = r21;
        r0 = r0.e;
        r21 = r0;
        r31 = j;
        r31 = r31[r37];
        r21 = r21[r31];
        r0 = r32;
        r0 = r0.a_;
        r31 = r0;
        r0 = r31;
        r0 = r0.j;
        r31 = r0;
        r33 = k;
        r33 = r33[r37];
        r43 = g;
        r43 = r43[r37];
        r0 = r31;
        r1 = r33;
        r2 = r43;
        r31 = r0.a(r1, r2);
        r21 = r21 + r31;
        r0 = r32;
        r0 = r0.a_;
        r31 = r0;
        r0 = r31;
        r0 = r0.j;
        r31 = r0;
        r33 = l;
        r33 = r33[r37];
        r43 = h;
        r43 = r43[r37];
        r0 = r31;
        r1 = r33;
        r2 = r43;
        r31 = r0.a(r1, r2);
        r21 = r21 + r31;
        r10 = r10 + r21;
        r0 = r32;
        r0 = r0.b;
        r21 = r0;
        r0 = r21;
        r0 = r0.e;
        r21 = r0;
        r31 = j;
        r31 = r31[r4];
        r21 = r21[r31];
        r0 = r32;
        r0 = r0.a_;
        r31 = r0;
        r0 = r31;
        r0 = r0.j;
        r31 = r0;
        r33 = k;
        r33 = r33[r4];
        r43 = g;
        r43 = r43[r4];
        r0 = r31;
        r1 = r33;
        r2 = r43;
        r31 = r0.a(r1, r2);
        r21 = r21 + r31;
        r0 = r32;
        r0 = r0.a_;
        r31 = r0;
        r0 = r31;
        r0 = r0.j;
        r31 = r0;
        r33 = l;
        r33 = r33[r4];
        r43 = h;
        r43 = r43[r4];
        r0 = r31;
        r1 = r33;
        r2 = r43;
        r31 = r0.a(r1, r2);
        r21 = r21 + r31;
        r0 = r32;
        r1 = r21;
        r21 = a(r0, r4, r1);
        r0 = r21;
        r9 = java.lang.Math.max(r9, r0);
    L_0x0d53:
        if (r14 == 0) goto L_0x0dbb;
    L_0x0d55:
        r0 = r32;
        r0 = r0.b;
        r21 = r0;
        r0 = r21;
        r0 = r0.d;
        r21 = r0;
        r31 = i;
        r31 = r31[r4];
        r33 = r21[r31];
        r43 = r30 + r25;
        r33 = r33 + r43;
        r21[r31] = r33;
        if (r7 == 0) goto L_0x0dbb;
    L_0x0d6f:
        r0 = r32;
        r0 = r0.b;
        r21 = r0;
        r0 = r21;
        r0 = r0.d;
        r21 = r0;
        r31 = h;
        r31 = r31[r4];
        r0 = r55;
        r0 = r0.b;
        r33 = r0;
        r0 = r33;
        r0 = r0.e;
        r33 = r0;
        r43 = j;
        r43 = r43[r4];
        r33 = r33[r43];
        r0 = r32;
        r0 = r0.b;
        r43 = r0;
        r0 = r43;
        r0 = r0.e;
        r43 = r0;
        r44 = j;
        r44 = r44[r4];
        r43 = r43[r44];
        r33 = r33 - r43;
        r0 = r32;
        r0 = r0.b;
        r32 = r0;
        r0 = r32;
        r0 = r0.d;
        r32 = r0;
        r43 = i;
        r43 = r43[r4];
        r32 = r32[r43];
        r32 = r33 - r32;
        r21[r31] = r32;
    L_0x0dbb:
        r21 = 0;
        r20 = r20 + r22;
        r22 = r35 + 1;
        goto L_0x0517;
    L_0x0dc3:
        r11 = 0;
        r0 = r20;
        r11 = java.lang.Math.max(r0, r11);
        r11 = r11 - r20;
        goto L_0x0796;
    L_0x0dce:
        r11 = r12 / r11;
        r12 = 0;
        r12 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1));
        if (r12 >= 0) goto L_0x0dd6;
    L_0x0dd5:
        r11 = 0;
    L_0x0dd6:
        r20 = r21;
    L_0x0dd8:
        if (r20 == 0) goto L_0x0f19;
    L_0x0dda:
        r0 = r20;
        r12 = r0.k;
        if (r12 == 0) goto L_0x0ed2;
    L_0x0de0:
        r0 = r20;
        r12 = r0.b;
        r12 = r12.e;
        r21 = j;
        r21 = r21[r37];
        r0 = r20;
        r0 = r0.a_;
        r22 = r0;
        r0 = r22;
        r0 = r0.i;
        r22 = r0;
        r22 = r22 * r11;
        r0 = r20;
        r0 = r0.a_;
        r23 = r0;
        r0 = r23;
        r0 = r0.k;
        r23 = r0;
        r24 = k;
        r24 = r24[r37];
        r27 = g;
        r27 = r27[r37];
        r0 = r23;
        r1 = r24;
        r2 = r27;
        r23 = r0.a(r1, r2);
        r0 = r20;
        r0 = r0.a_;
        r24 = r0;
        r0 = r24;
        r0 = r0.l;
        r24 = r0;
        r27 = k;
        r27 = r27[r37];
        r32 = g;
        r32 = r32[r37];
        r0 = r24;
        r1 = r27;
        r2 = r32;
        r24 = r0.a(r1, r2);
        r23 = r23 + r24;
        r0 = r20;
        r0 = r0.a_;
        r24 = r0;
        r0 = r24;
        r0 = r0.k;
        r24 = r0;
        r27 = l;
        r27 = r27[r37];
        r32 = h;
        r32 = r32[r37];
        r0 = r24;
        r1 = r27;
        r2 = r32;
        r24 = r0.a(r1, r2);
        r0 = r20;
        r0 = r0.a_;
        r27 = r0;
        r0 = r27;
        r0 = r0.l;
        r27 = r0;
        r32 = l;
        r32 = r32[r37];
        r33 = h;
        r33 = r33[r37];
        r0 = r27;
        r1 = r32;
        r2 = r33;
        r27 = r0.a(r1, r2);
        r24 = r24 + r27;
        r23 = r23 + r24;
        r22 = r22 + r23;
        r0 = r20;
        r1 = r37;
        r2 = r22;
        r22 = a(r0, r1, r2);
        r12[r21] = r22;
        r12 = 2143289344; // 0x7fc00000 float:NaN double:1.058925634E-314;
        r0 = r55;
        r0 = r0.a_;
        r21 = r0;
        r0 = r21;
        r0 = r0.n;
        r21 = r0;
        r22 = j;
        r22 = r22[r38];
        r21 = r21[r22];
        r21 = java.lang.Float.isNaN(r21);
        if (r21 != 0) goto L_0x0ee2;
    L_0x0e9e:
        r0 = r55;
        r0 = r0.a_;
        r21 = r0;
        r0 = r21;
        r0 = r0.n;
        r21 = r0;
        r22 = j;
        r22 = r22[r38];
        r21 = r21[r22];
        r0 = r21;
        r0 = (double) r0;
        r22 = r0;
        r32 = 0;
        r21 = (r22 > r32 ? 1 : (r22 == r32 ? 0 : -1));
        if (r21 < 0) goto L_0x0ee2;
    L_0x0ebb:
        r0 = r55;
        r12 = r0.b;
        r12 = r12.e;
        r21 = j;
        r21 = r21[r38];
        r12 = r12[r21];
        r12 = r12 - r39;
    L_0x0ec9:
        r0 = r54;
        r1 = r20;
        r2 = r57;
        a(r0, r1, r12, r2);
    L_0x0ed2:
        r0 = r20;
        r12 = r0.f;
        r21 = 0;
        r0 = r21;
        r1 = r20;
        r1.f = r0;
        r20 = r12;
        goto L_0x0dd8;
    L_0x0ee2:
        if (r36 != 0) goto L_0x0ec9;
    L_0x0ee4:
        r0 = r55;
        r12 = r0.a_;
        r12 = r12.j;
        r21 = k;
        r21 = r21[r38];
        r22 = g;
        r22 = r22[r38];
        r0 = r21;
        r1 = r22;
        r12 = r12.a(r0, r1);
        r0 = r55;
        r0 = r0.a_;
        r21 = r0;
        r0 = r21;
        r0 = r0.j;
        r21 = r0;
        r22 = l;
        r22 = r22[r38];
        r23 = h;
        r23 = r23[r38];
        r21 = r21.a(r22, r23);
        r12 = r12 + r21;
        r12 = r56 - r12;
        r12 = r12 - r39;
        goto L_0x0ec9;
    L_0x0f19:
        r11 = r14;
        r12 = r16;
    L_0x0f1c:
        r11 = r11 + r10;
        r10 = r9;
    L_0x0f1e:
        r0 = r31;
        if (r15 >= r0) goto L_0x10e6;
    L_0x0f22:
        r0 = r55;
        r14 = r0.a(r15);
        r9 = r14.k;
        if (r9 == 0) goto L_0x1751;
    L_0x0f2c:
        r9 = r14.a_;
        r9 = r9.g;
        r16 = com.taobao.weex.c.b.l.ABSOLUTE;
        r0 = r16;
        if (r9 != r0) goto L_0x0ff3;
    L_0x0f36:
        r9 = r14.a_;
        r9 = r9.m;
        r16 = g;
        r16 = r16[r37];
        r9 = r9[r16];
        r9 = java.lang.Float.isNaN(r9);
        if (r9 != 0) goto L_0x0ff3;
    L_0x0f46:
        r9 = r14.b;
        r0 = r9.d;
        r16 = r0;
        r9 = i;
        r20 = r9[r37];
        r9 = r14.a_;
        r9 = r9.m;
        r21 = g;
        r21 = r21[r37];
        r9 = r9[r21];
        r9 = java.lang.Float.isNaN(r9);
        if (r9 == 0) goto L_0x0fe7;
    L_0x0f60:
        r9 = 0;
    L_0x0f61:
        r0 = r55;
        r0 = r0.a_;
        r21 = r0;
        r0 = r21;
        r0 = r0.l;
        r21 = r0;
        r22 = k;
        r22 = r22[r37];
        r23 = g;
        r23 = r23[r37];
        r21 = r21.a(r22, r23);
        r9 = r9 + r21;
        r14 = r14.a_;
        r14 = r14.j;
        r21 = k;
        r21 = r21[r37];
        r22 = g;
        r22 = r22[r37];
        r0 = r21;
        r1 = r22;
        r14 = r14.a(r0, r1);
        r9 = r9 + r14;
        r16[r20] = r9;
        r9 = r10;
        r10 = r11;
    L_0x0f94:
        r15 = r15 + 1;
        r11 = r10;
        r10 = r9;
        goto L_0x0f1e;
    L_0x0f99:
        r12 = com.taobao.weex.c.b.f.FLEX_START;
        r0 = r40;
        if (r0 == r12) goto L_0x1755;
    L_0x0f9f:
        r12 = com.taobao.weex.c.b.f.CENTER;
        r0 = r40;
        if (r0 != r12) goto L_0x0fac;
    L_0x0fa5:
        r12 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r11 = r11 / r12;
        r12 = r16;
        goto L_0x0f1c;
    L_0x0fac:
        r12 = com.taobao.weex.c.b.f.FLEX_END;
        r0 = r40;
        if (r0 != r12) goto L_0x0fb6;
    L_0x0fb2:
        r12 = r16;
        goto L_0x0f1c;
    L_0x0fb6:
        r12 = com.taobao.weex.c.b.f.SPACE_BETWEEN;
        r0 = r40;
        if (r0 != r12) goto L_0x0fd6;
    L_0x0fbc:
        r12 = 0;
        r11 = java.lang.Math.max(r11, r12);
        r12 = r23 + r22;
        r12 = r12 + -1;
        if (r12 == 0) goto L_0x0fd1;
    L_0x0fc7:
        r12 = r23 + r22;
        r12 = r12 + -1;
        r12 = (float) r12;
        r11 = r11 / r12;
        r12 = r11;
        r11 = r14;
        goto L_0x0f1c;
    L_0x0fd1:
        r11 = 0;
        r12 = r11;
        r11 = r14;
        goto L_0x0f1c;
    L_0x0fd6:
        r12 = com.taobao.weex.c.b.f.SPACE_AROUND;
        r0 = r40;
        if (r0 != r12) goto L_0x1755;
    L_0x0fdc:
        r12 = r23 + r22;
        r12 = (float) r12;
        r12 = r11 / r12;
        r11 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r11 = r12 / r11;
        goto L_0x0f1c;
    L_0x0fe7:
        r9 = r14.a_;
        r9 = r9.m;
        r21 = g;
        r21 = r21[r37];
        r9 = r9[r21];
        goto L_0x0f61;
    L_0x0ff3:
        r9 = r14.b;
        r9 = r9.d;
        r16 = i;
        r16 = r16[r37];
        r20 = r9[r16];
        r20 = r20 + r11;
        r9[r16] = r20;
        if (r6 == 0) goto L_0x1043;
    L_0x1003:
        r9 = r14.b;
        r9 = r9.d;
        r16 = h;
        r16 = r16[r37];
        r0 = r55;
        r0 = r0.b;
        r20 = r0;
        r0 = r20;
        r0 = r0.e;
        r20 = r0;
        r21 = j;
        r21 = r21[r37];
        r20 = r20[r21];
        r0 = r14.b;
        r21 = r0;
        r0 = r21;
        r0 = r0.e;
        r21 = r0;
        r22 = j;
        r22 = r22[r37];
        r21 = r21[r22];
        r20 = r20 - r21;
        r0 = r14.b;
        r21 = r0;
        r0 = r21;
        r0 = r0.d;
        r21 = r0;
        r22 = i;
        r22 = r22[r37];
        r21 = r21[r22];
        r20 = r20 - r21;
        r9[r16] = r20;
    L_0x1043:
        r9 = r14.a_;
        r9 = r9.g;
        r16 = com.taobao.weex.c.b.l.RELATIVE;
        r0 = r16;
        if (r9 != r0) goto L_0x1751;
    L_0x104d:
        r9 = r14.b;
        r9 = r9.e;
        r16 = j;
        r16 = r16[r37];
        r9 = r9[r16];
        r0 = r14.a_;
        r16 = r0;
        r0 = r16;
        r0 = r0.j;
        r16 = r0;
        r20 = k;
        r20 = r20[r37];
        r21 = g;
        r21 = r21[r37];
        r0 = r16;
        r1 = r20;
        r2 = r21;
        r16 = r0.a(r1, r2);
        r9 = r9 + r16;
        r0 = r14.a_;
        r16 = r0;
        r0 = r16;
        r0 = r0.j;
        r16 = r0;
        r20 = l;
        r20 = r20[r37];
        r21 = h;
        r21 = r21[r37];
        r0 = r16;
        r1 = r20;
        r2 = r21;
        r16 = r0.a(r1, r2);
        r9 = r9 + r16;
        r9 = r9 + r12;
        r11 = r11 + r9;
        r9 = r14.b;
        r9 = r9.e;
        r16 = j;
        r16 = r16[r4];
        r9 = r9[r16];
        r0 = r14.a_;
        r16 = r0;
        r0 = r16;
        r0 = r0.j;
        r16 = r0;
        r20 = k;
        r20 = r20[r4];
        r21 = g;
        r21 = r21[r4];
        r0 = r16;
        r1 = r20;
        r2 = r21;
        r16 = r0.a(r1, r2);
        r9 = r9 + r16;
        r0 = r14.a_;
        r16 = r0;
        r0 = r16;
        r0 = r0.j;
        r16 = r0;
        r20 = l;
        r20 = r20[r4];
        r21 = h;
        r21 = r21[r4];
        r0 = r16;
        r1 = r20;
        r2 = r21;
        r16 = r0.a(r1, r2);
        r9 = r9 + r16;
        r9 = a(r14, r4, r9);
        r9 = java.lang.Math.max(r10, r9);
        r10 = r11;
        goto L_0x0f94;
    L_0x10e6:
        r0 = r55;
        r9 = r0.b;
        r9 = r9.e;
        r12 = j;
        r12 = r12[r4];
        r9 = r9[r12];
        if (r7 != 0) goto L_0x1102;
    L_0x10f4:
        r9 = r10 + r42;
        r0 = r55;
        r9 = a(r0, r4, r9);
        r0 = r42;
        r9 = java.lang.Math.max(r9, r0);
    L_0x1102:
        r0 = r31;
        if (r13 >= r0) goto L_0x12f4;
    L_0x1106:
        r0 = r55;
        r14 = r0.a(r13);
        r12 = r14.k;
        if (r12 == 0) goto L_0x1172;
    L_0x1110:
        r12 = r14.a_;
        r12 = r12.g;
        r15 = com.taobao.weex.c.b.l.ABSOLUTE;
        if (r12 != r15) goto L_0x1180;
    L_0x1118:
        r12 = r14.a_;
        r12 = r12.m;
        r15 = g;
        r15 = r15[r4];
        r12 = r12[r15];
        r12 = java.lang.Float.isNaN(r12);
        if (r12 != 0) goto L_0x1180;
    L_0x1128:
        r12 = r14.b;
        r15 = r12.d;
        r12 = i;
        r16 = r12[r4];
        r12 = r14.a_;
        r12 = r12.m;
        r20 = g;
        r20 = r20[r4];
        r12 = r12[r20];
        r12 = java.lang.Float.isNaN(r12);
        if (r12 == 0) goto L_0x1175;
    L_0x1140:
        r12 = 0;
    L_0x1141:
        r0 = r55;
        r0 = r0.a_;
        r20 = r0;
        r0 = r20;
        r0 = r0.l;
        r20 = r0;
        r21 = k;
        r21 = r21[r4];
        r22 = g;
        r22 = r22[r4];
        r20 = r20.a(r21, r22);
        r12 = r12 + r20;
        r14 = r14.a_;
        r14 = r14.j;
        r20 = k;
        r20 = r20[r4];
        r21 = g;
        r21 = r21[r4];
        r0 = r20;
        r1 = r21;
        r14 = r14.a(r0, r1);
        r12 = r12 + r14;
        r15[r16] = r12;
    L_0x1172:
        r13 = r13 + 1;
        goto L_0x1102;
    L_0x1175:
        r12 = r14.a_;
        r12 = r12.m;
        r20 = g;
        r20 = r20[r4];
        r12 = r12[r20];
        goto L_0x1141;
    L_0x1180:
        r12 = r14.a_;
        r12 = r12.g;
        r15 = com.taobao.weex.c.b.l.RELATIVE;
        if (r12 != r15) goto L_0x174d;
    L_0x1188:
        r0 = r55;
        r12 = a(r0, r14);
        r15 = com.taobao.weex.c.b.b.STRETCH;
        if (r12 != r15) goto L_0x129a;
    L_0x1192:
        r12 = r14.b;
        r12 = r12.e;
        r15 = j;
        r15 = r15[r4];
        r12 = r12[r15];
        r12 = java.lang.Float.isNaN(r12);
        if (r12 == 0) goto L_0x174d;
    L_0x11a2:
        r12 = r14.b;
        r12 = r12.e;
        r15 = j;
        r15 = r15[r4];
        r16 = r9 - r42;
        r0 = r14.a_;
        r20 = r0;
        r0 = r20;
        r0 = r0.j;
        r20 = r0;
        r21 = k;
        r21 = r21[r4];
        r22 = g;
        r22 = r22[r4];
        r20 = r20.a(r21, r22);
        r0 = r14.a_;
        r21 = r0;
        r0 = r21;
        r0 = r0.j;
        r21 = r0;
        r22 = l;
        r22 = r22[r4];
        r23 = h;
        r23 = r23[r4];
        r21 = r21.a(r22, r23);
        r20 = r20 + r21;
        r16 = r16 - r20;
        r0 = r16;
        r16 = a(r14, r4, r0);
        r0 = r14.a_;
        r20 = r0;
        r0 = r20;
        r0 = r0.k;
        r20 = r0;
        r21 = k;
        r21 = r21[r4];
        r22 = g;
        r22 = r22[r4];
        r20 = r20.a(r21, r22);
        r0 = r14.a_;
        r21 = r0;
        r0 = r21;
        r0 = r0.l;
        r21 = r0;
        r22 = k;
        r22 = r22[r4];
        r23 = g;
        r23 = r23[r4];
        r21 = r21.a(r22, r23);
        r20 = r20 + r21;
        r0 = r14.a_;
        r21 = r0;
        r0 = r21;
        r0 = r0.k;
        r21 = r0;
        r22 = l;
        r22 = r22[r4];
        r23 = h;
        r23 = r23[r4];
        r21 = r21.a(r22, r23);
        r0 = r14.a_;
        r22 = r0;
        r0 = r22;
        r0 = r0.l;
        r22 = r0;
        r23 = l;
        r23 = r23[r4];
        r24 = h;
        r24 = r24[r4];
        r22 = r22.a(r23, r24);
        r21 = r21 + r22;
        r20 = r20 + r21;
        r0 = r16;
        r1 = r20;
        r16 = java.lang.Math.max(r0, r1);
        r12[r15] = r16;
        r12 = r25;
    L_0x124c:
        r15 = r14.b;
        r15 = r15.d;
        r16 = i;
        r16 = r16[r4];
        r20 = r15[r16];
        r12 = r12 + r30;
        r12 = r12 + r20;
        r15[r16] = r12;
        if (r7 == 0) goto L_0x1172;
    L_0x125e:
        r12 = r14.b;
        r12 = r12.d;
        r15 = h;
        r15 = r15[r4];
        r0 = r55;
        r0 = r0.b;
        r16 = r0;
        r0 = r16;
        r0 = r0.e;
        r16 = r0;
        r20 = j;
        r20 = r20[r4];
        r16 = r16[r20];
        r0 = r14.b;
        r20 = r0;
        r0 = r20;
        r0 = r0.e;
        r20 = r0;
        r21 = j;
        r21 = r21[r4];
        r20 = r20[r21];
        r16 = r16 - r20;
        r14 = r14.b;
        r14 = r14.d;
        r20 = i;
        r20 = r20[r4];
        r14 = r14[r20];
        r14 = r16 - r14;
        r12[r15] = r14;
        goto L_0x1172;
    L_0x129a:
        r15 = com.taobao.weex.c.b.b.FLEX_START;
        if (r12 == r15) goto L_0x174d;
    L_0x129e:
        r15 = r9 - r42;
        r0 = r14.b;
        r16 = r0;
        r0 = r16;
        r0 = r0.e;
        r16 = r0;
        r20 = j;
        r20 = r20[r4];
        r16 = r16[r20];
        r0 = r14.a_;
        r20 = r0;
        r0 = r20;
        r0 = r0.j;
        r20 = r0;
        r21 = k;
        r21 = r21[r4];
        r22 = g;
        r22 = r22[r4];
        r20 = r20.a(r21, r22);
        r16 = r16 + r20;
        r0 = r14.a_;
        r20 = r0;
        r0 = r20;
        r0 = r0.j;
        r20 = r0;
        r21 = l;
        r21 = r21[r4];
        r22 = h;
        r22 = r22[r4];
        r20 = r20.a(r21, r22);
        r16 = r16 + r20;
        r15 = r15 - r16;
        r16 = com.taobao.weex.c.b.b.CENTER;
        r0 = r16;
        if (r12 != r0) goto L_0x12f0;
    L_0x12e8:
        r12 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r12 = r15 / r12;
        r12 = r12 + r25;
        goto L_0x124c;
    L_0x12f0:
        r12 = r25 + r15;
        goto L_0x124c;
    L_0x12f4:
        r12 = r30 + r10;
        r0 = r29;
        r10 = java.lang.Math.max(r0, r11);
        r9 = r28 + 1;
        r28 = r9;
        r29 = r10;
        r30 = r12;
        r13 = r31;
        r27 = r31;
        r14 = r18;
        r12 = r17;
        r10 = r19;
        goto L_0x04af;
    L_0x1310:
        r5 = 1;
        r0 = r28;
        if (r0 <= r5) goto L_0x147f;
    L_0x1315:
        if (r7 == 0) goto L_0x147f;
    L_0x1317:
        r0 = r55;
        r5 = r0.b;
        r5 = r5.e;
        r8 = j;
        r8 = r8[r4];
        r5 = r5[r8];
        r8 = r5 - r42;
        r9 = r8 - r30;
        r5 = 0;
        r0 = r55;
        r11 = r0.a_;
        r11 = r11.d;
        r12 = com.taobao.weex.c.b.b.FLEX_END;
        if (r11 != r12) goto L_0x139e;
    L_0x1332:
        r25 = r25 + r9;
    L_0x1334:
        r9 = 0;
        r8 = 0;
        r12 = r8;
    L_0x1337:
        r0 = r28;
        if (r12 >= r0) goto L_0x147f;
    L_0x133b:
        r8 = 0;
        r11 = r9;
    L_0x133d:
        r0 = r26;
        if (r11 >= r0) goto L_0x13b8;
    L_0x1341:
        r0 = r55;
        r13 = r0.a(r11);
        r14 = r13.k;
        if (r14 == 0) goto L_0x139b;
    L_0x134b:
        r14 = r13.a_;
        r14 = r14.g;
        r15 = com.taobao.weex.c.b.l.RELATIVE;
        if (r14 != r15) goto L_0x139b;
    L_0x1353:
        r14 = r13.d;
        if (r14 != r12) goto L_0x13b8;
    L_0x1357:
        r14 = r13.b;
        r14 = r14.e;
        r15 = j;
        r15 = r15[r4];
        r14 = r14[r15];
        r14 = java.lang.Float.isNaN(r14);
        if (r14 != 0) goto L_0x139b;
    L_0x1367:
        r14 = r13.b;
        r14 = r14.e;
        r15 = j;
        r15 = r15[r4];
        r14 = r14[r15];
        r15 = r13.a_;
        r15 = r15.j;
        r16 = k;
        r16 = r16[r4];
        r17 = g;
        r17 = r17[r4];
        r15 = r15.a(r16, r17);
        r13 = r13.a_;
        r13 = r13.j;
        r16 = l;
        r16 = r16[r4];
        r17 = h;
        r17 = r17[r4];
        r0 = r16;
        r1 = r17;
        r13 = r13.a(r0, r1);
        r13 = r13 + r15;
        r13 = r13 + r14;
        r8 = java.lang.Math.max(r8, r13);
    L_0x139b:
        r11 = r11 + 1;
        goto L_0x133d;
    L_0x139e:
        r12 = com.taobao.weex.c.b.b.CENTER;
        if (r11 != r12) goto L_0x13a9;
    L_0x13a2:
        r8 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r8 = r9 / r8;
        r25 = r25 + r8;
        goto L_0x1334;
    L_0x13a9:
        r12 = com.taobao.weex.c.b.b.STRETCH;
        if (r11 != r12) goto L_0x1334;
    L_0x13ad:
        r8 = (r8 > r30 ? 1 : (r8 == r30 ? 0 : -1));
        if (r8 <= 0) goto L_0x1334;
    L_0x13b1:
        r0 = r28;
        r5 = (float) r0;
        r5 = r9 / r5;
        goto L_0x1334;
    L_0x13b8:
        r13 = r8 + r5;
        r8 = r9;
    L_0x13bb:
        if (r8 >= r11) goto L_0x1477;
    L_0x13bd:
        r0 = r55;
        r9 = r0.a(r8);
        r14 = r9.k;
        if (r14 == 0) goto L_0x13f9;
    L_0x13c7:
        r14 = r9.a_;
        r14 = r14.g;
        r15 = com.taobao.weex.c.b.l.RELATIVE;
        if (r14 != r15) goto L_0x13f9;
    L_0x13cf:
        r0 = r55;
        r14 = a(r0, r9);
        r15 = com.taobao.weex.c.b.b.FLEX_START;
        if (r14 != r15) goto L_0x13fc;
    L_0x13d9:
        r14 = r9.b;
        r14 = r14.d;
        r15 = i;
        r15 = r15[r4];
        r9 = r9.a_;
        r9 = r9.j;
        r16 = k;
        r16 = r16[r4];
        r17 = g;
        r17 = r17[r4];
        r0 = r16;
        r1 = r17;
        r9 = r9.a(r0, r1);
        r9 = r9 + r25;
        r14[r15] = r9;
    L_0x13f9:
        r8 = r8 + 1;
        goto L_0x13bb;
    L_0x13fc:
        r15 = com.taobao.weex.c.b.b.FLEX_END;
        if (r14 != r15) goto L_0x1431;
    L_0x1400:
        r14 = r9.b;
        r14 = r14.d;
        r15 = i;
        r15 = r15[r4];
        r16 = r25 + r13;
        r0 = r9.a_;
        r17 = r0;
        r0 = r17;
        r0 = r0.j;
        r17 = r0;
        r18 = l;
        r18 = r18[r4];
        r19 = h;
        r19 = r19[r4];
        r17 = r17.a(r18, r19);
        r16 = r16 - r17;
        r9 = r9.b;
        r9 = r9.e;
        r17 = j;
        r17 = r17[r4];
        r9 = r9[r17];
        r9 = r16 - r9;
        r14[r15] = r9;
        goto L_0x13f9;
    L_0x1431:
        r15 = com.taobao.weex.c.b.b.CENTER;
        if (r14 != r15) goto L_0x1452;
    L_0x1435:
        r14 = r9.b;
        r14 = r14.e;
        r15 = j;
        r15 = r15[r4];
        r14 = r14[r15];
        r9 = r9.b;
        r9 = r9.d;
        r15 = i;
        r15 = r15[r4];
        r14 = r13 - r14;
        r16 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r14 = r14 / r16;
        r14 = r14 + r25;
        r9[r15] = r14;
        goto L_0x13f9;
    L_0x1452:
        r15 = com.taobao.weex.c.b.b.STRETCH;
        if (r14 != r15) goto L_0x13f9;
    L_0x1456:
        r14 = r9.b;
        r14 = r14.d;
        r15 = i;
        r15 = r15[r4];
        r9 = r9.a_;
        r9 = r9.j;
        r16 = k;
        r16 = r16[r4];
        r17 = g;
        r17 = r17[r4];
        r0 = r16;
        r1 = r17;
        r9 = r9.a(r0, r1);
        r9 = r9 + r25;
        r14[r15] = r9;
        goto L_0x13f9;
    L_0x1477:
        r25 = r25 + r13;
        r8 = r12 + 1;
        r9 = r11;
        r12 = r8;
        goto L_0x1337;
    L_0x147f:
        r8 = 0;
        r5 = 0;
        if (r6 != 0) goto L_0x14d2;
    L_0x1483:
        r0 = r55;
        r6 = r0.b;
        r6 = r6.e;
        r9 = j;
        r9 = r9[r37];
        r0 = r55;
        r11 = r0.a_;
        r11 = r11.k;
        r12 = l;
        r12 = r12[r37];
        r13 = h;
        r13 = r13[r37];
        r11 = r11.a(r12, r13);
        r0 = r55;
        r12 = r0.a_;
        r12 = r12.l;
        r13 = l;
        r13 = r13[r37];
        r14 = h;
        r14 = r14[r37];
        r12 = r12.a(r13, r14);
        r11 = r11 + r12;
        r11 = r11 + r29;
        r0 = r55;
        r1 = r37;
        r11 = a(r0, r1, r11);
        r0 = r41;
        r11 = java.lang.Math.max(r11, r0);
        r6[r9] = r11;
        r6 = d;
        r0 = r37;
        if (r0 == r6) goto L_0x14d0;
    L_0x14ca:
        r6 = b;
        r0 = r37;
        if (r0 != r6) goto L_0x14d2;
    L_0x14d0:
        r6 = 1;
        r8 = r6;
    L_0x14d2:
        if (r7 != 0) goto L_0x174a;
    L_0x14d4:
        r0 = r55;
        r6 = r0.b;
        r6 = r6.e;
        r7 = j;
        r7 = r7[r4];
        r9 = r30 + r42;
        r0 = r55;
        r9 = a(r0, r4, r9);
        r0 = r42;
        r9 = java.lang.Math.max(r9, r0);
        r6[r7] = r9;
        r6 = d;
        if (r4 == r6) goto L_0x14f6;
    L_0x14f2:
        r6 = b;
        if (r4 != r6) goto L_0x174a;
    L_0x14f6:
        r5 = 1;
        r6 = r5;
    L_0x14f8:
        if (r8 != 0) goto L_0x14fc;
    L_0x14fa:
        if (r6 == 0) goto L_0x156b;
    L_0x14fc:
        r5 = 0;
    L_0x14fd:
        r0 = r26;
        if (r5 >= r0) goto L_0x156b;
    L_0x1501:
        r0 = r55;
        r7 = r0.a(r5);
        r9 = r7.k;
        if (r9 == 0) goto L_0x1568;
    L_0x150b:
        if (r8 == 0) goto L_0x1539;
    L_0x150d:
        r9 = r7.b;
        r9 = r9.d;
        r11 = h;
        r11 = r11[r37];
        r0 = r55;
        r12 = r0.b;
        r12 = r12.e;
        r13 = j;
        r13 = r13[r37];
        r12 = r12[r13];
        r13 = r7.b;
        r13 = r13.e;
        r14 = j;
        r14 = r14[r37];
        r13 = r13[r14];
        r12 = r12 - r13;
        r13 = r7.b;
        r13 = r13.d;
        r14 = i;
        r14 = r14[r37];
        r13 = r13[r14];
        r12 = r12 - r13;
        r9[r11] = r12;
    L_0x1539:
        if (r6 == 0) goto L_0x1568;
    L_0x153b:
        r9 = r7.b;
        r9 = r9.d;
        r11 = h;
        r11 = r11[r4];
        r0 = r55;
        r12 = r0.b;
        r12 = r12.e;
        r13 = j;
        r13 = r13[r4];
        r12 = r12[r13];
        r13 = r7.b;
        r13 = r13.e;
        r14 = j;
        r14 = r14[r4];
        r13 = r13[r14];
        r12 = r12 - r13;
        r7 = r7.b;
        r7 = r7.d;
        r13 = i;
        r13 = r13[r4];
        r7 = r7[r13];
        r7 = r12 - r7;
        r9[r11] = r7;
    L_0x1568:
        r5 = r5 + 1;
        goto L_0x14fd;
    L_0x156b:
        r7 = r10;
    L_0x156c:
        if (r7 == 0) goto L_0x1725;
    L_0x156e:
        r4 = r7.k;
        if (r4 == 0) goto L_0x171d;
    L_0x1572:
        r4 = 0;
        r6 = r4;
    L_0x1574:
        r4 = 2;
        if (r6 >= r4) goto L_0x171d;
    L_0x1577:
        if (r6 == 0) goto L_0x16f6;
    L_0x1579:
        r4 = c;
    L_0x157b:
        r0 = r55;
        r5 = r0.b;
        r5 = r5.e;
        r8 = j;
        r8 = r8[r4];
        r5 = r5[r8];
        r5 = java.lang.Float.isNaN(r5);
        if (r5 != 0) goto L_0x169d;
    L_0x158d:
        r5 = r7.a_;
        r5 = r5.n;
        r8 = j;
        r8 = r8[r4];
        r5 = r5[r8];
        r5 = java.lang.Float.isNaN(r5);
        if (r5 != 0) goto L_0x15ae;
    L_0x159d:
        r5 = r7.a_;
        r5 = r5.n;
        r8 = j;
        r8 = r8[r4];
        r5 = r5[r8];
        r8 = (double) r5;
        r10 = 0;
        r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r5 >= 0) goto L_0x169d;
    L_0x15ae:
        r5 = r7.a_;
        r5 = r5.m;
        r8 = g;
        r8 = r8[r4];
        r5 = r5[r8];
        r5 = java.lang.Float.isNaN(r5);
        if (r5 != 0) goto L_0x169d;
    L_0x15be:
        r5 = r7.a_;
        r5 = r5.m;
        r8 = h;
        r8 = r8[r4];
        r5 = r5[r8];
        r5 = java.lang.Float.isNaN(r5);
        if (r5 != 0) goto L_0x169d;
    L_0x15ce:
        r5 = r7.b;
        r8 = r5.e;
        r5 = j;
        r9 = r5[r4];
        r0 = r55;
        r5 = r0.b;
        r5 = r5.e;
        r10 = j;
        r10 = r10[r4];
        r5 = r5[r10];
        r0 = r55;
        r10 = r0.a_;
        r10 = r10.l;
        r11 = k;
        r11 = r11[r4];
        r12 = g;
        r12 = r12[r4];
        r10 = r10.a(r11, r12);
        r0 = r55;
        r11 = r0.a_;
        r11 = r11.l;
        r12 = l;
        r12 = r12[r4];
        r13 = h;
        r13 = r13[r4];
        r11 = r11.a(r12, r13);
        r10 = r10 + r11;
        r5 = r5 - r10;
        r10 = r7.a_;
        r10 = r10.j;
        r11 = k;
        r11 = r11[r4];
        r12 = g;
        r12 = r12[r4];
        r10 = r10.a(r11, r12);
        r11 = r7.a_;
        r11 = r11.j;
        r12 = l;
        r12 = r12[r4];
        r13 = h;
        r13 = r13[r4];
        r11 = r11.a(r12, r13);
        r10 = r10 + r11;
        r10 = r5 - r10;
        r5 = r7.a_;
        r5 = r5.m;
        r11 = g;
        r11 = r11[r4];
        r5 = r5[r11];
        r5 = java.lang.Float.isNaN(r5);
        if (r5 == 0) goto L_0x16fa;
    L_0x163b:
        r5 = 0;
    L_0x163c:
        r10 = r10 - r5;
        r5 = r7.a_;
        r5 = r5.m;
        r11 = h;
        r11 = r11[r4];
        r5 = r5[r11];
        r5 = java.lang.Float.isNaN(r5);
        if (r5 == 0) goto L_0x1706;
    L_0x164d:
        r5 = 0;
    L_0x164e:
        r5 = r10 - r5;
        r5 = a(r7, r4, r5);
        r10 = r7.a_;
        r10 = r10.k;
        r11 = k;
        r11 = r11[r4];
        r12 = g;
        r12 = r12[r4];
        r10 = r10.a(r11, r12);
        r11 = r7.a_;
        r11 = r11.l;
        r12 = k;
        r12 = r12[r4];
        r13 = g;
        r13 = r13[r4];
        r11 = r11.a(r12, r13);
        r10 = r10 + r11;
        r11 = r7.a_;
        r11 = r11.k;
        r12 = l;
        r12 = r12[r4];
        r13 = h;
        r13 = r13[r4];
        r11 = r11.a(r12, r13);
        r12 = r7.a_;
        r12 = r12.l;
        r13 = l;
        r13 = r13[r4];
        r14 = h;
        r14 = r14[r4];
        r12 = r12.a(r13, r14);
        r11 = r11 + r12;
        r10 = r10 + r11;
        r5 = java.lang.Math.max(r5, r10);
        r8[r9] = r5;
    L_0x169d:
        r5 = r7.a_;
        r5 = r5.m;
        r8 = h;
        r8 = r8[r4];
        r5 = r5[r8];
        r5 = java.lang.Float.isNaN(r5);
        if (r5 != 0) goto L_0x16f1;
    L_0x16ad:
        r5 = r7.a_;
        r5 = r5.m;
        r8 = g;
        r8 = r8[r4];
        r5 = r5[r8];
        r5 = java.lang.Float.isNaN(r5);
        if (r5 == 0) goto L_0x16f1;
    L_0x16bd:
        r5 = r7.b;
        r5 = r5.d;
        r8 = g;
        r8 = r8[r4];
        r0 = r55;
        r9 = r0.b;
        r9 = r9.e;
        r10 = j;
        r10 = r10[r4];
        r9 = r9[r10];
        r10 = r7.b;
        r10 = r10.e;
        r11 = j;
        r11 = r11[r4];
        r10 = r10[r11];
        r9 = r9 - r10;
        r10 = r7.a_;
        r10 = r10.m;
        r11 = h;
        r11 = r11[r4];
        r10 = r10[r11];
        r10 = java.lang.Float.isNaN(r10);
        if (r10 == 0) goto L_0x1712;
    L_0x16ec:
        r4 = 0;
    L_0x16ed:
        r4 = r9 - r4;
        r5[r8] = r4;
    L_0x16f1:
        r4 = r6 + 1;
        r6 = r4;
        goto L_0x1574;
    L_0x16f6:
        r4 = a;
        goto L_0x157b;
    L_0x16fa:
        r5 = r7.a_;
        r5 = r5.m;
        r11 = g;
        r11 = r11[r4];
        r5 = r5[r11];
        goto L_0x163c;
    L_0x1706:
        r5 = r7.a_;
        r5 = r5.m;
        r11 = h;
        r11 = r11[r4];
        r5 = r5[r11];
        goto L_0x164e;
    L_0x1712:
        r10 = r7.a_;
        r10 = r10.m;
        r11 = h;
        r4 = r11[r4];
        r4 = r10[r4];
        goto L_0x16ed;
    L_0x171d:
        r4 = r7.e;
        r5 = 0;
        r7.e = r5;
        r7 = r4;
        goto L_0x156c;
    L_0x1725:
        r0 = r55;
        r4 = r0.b;
        r0 = r55;
        r0.a(r4);
    L_0x172e:
        r4 = com.taobao.weex.c.b.i.b;
        r0 = r55;
        r0.j = r4;
        return;
    L_0x1735:
        r0 = r55;
        r4 = r0.b;
        r0 = r55;
        r5 = r0.c;
        r4.a(r5);
        r0 = r55;
        r4 = r0.c;
        r0 = r55;
        r0.a(r4);
        goto L_0x172e;
    L_0x174a:
        r6 = r5;
        goto L_0x14f8;
    L_0x174d:
        r12 = r25;
        goto L_0x124c;
    L_0x1751:
        r9 = r10;
        r10 = r11;
        goto L_0x0f94;
    L_0x1755:
        r11 = r14;
        r12 = r16;
        goto L_0x0f1c;
    L_0x175a:
        r22 = r33;
        goto L_0x076d;
    L_0x175e:
        r23 = r32;
        goto L_0x066f;
    L_0x1762:
        r22 = r17;
        r17 = r21;
        r21 = r12;
        r12 = r18;
        r18 = r23;
        r23 = r19;
        r19 = r24;
        goto L_0x078f;
    L_0x1772:
        r57 = r4;
        goto L_0x0092;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.c.b.p.a(com.taobao.weex.c.b.h, com.taobao.weex.c.b.k, float, com.taobao.weex.c.b.d):void");
    }
}
