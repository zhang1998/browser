package com.uc.b.a;

import android.graphics.Matrix;

/* compiled from: ProGuard */
public final class x extends d {
    private float e = 0.0f;
    private float f = 0.0f;
    private float g = 0.0f;
    private float h = 0.0f;
    private float i = 0.0f;
    private float j = 0.0f;
    private float k = 0.0f;
    private float l = 0.0f;
    private float m = 0.0f;
    private float n = 0.0f;
    private float o = 0.0f;
    private float p = 0.0f;

    public final /* bridge */ /* synthetic */ void a(float f, b bVar, boolean z) {
        super.a(f, bVar, z);
    }

    public final /* bridge */ /* synthetic */ void a(s sVar) {
        super.a(sVar);
    }

    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    public final /* bridge */ /* synthetic */ void b(float f, b bVar, boolean z) {
        super.b(f, bVar, z);
    }

    public final /* bridge */ /* synthetic */ Matrix d() {
        return super.d();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(char r12, float... r13) {
        /*
        r11 = this;
        r10 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r4 = 0;
        r0 = 1;
        r1 = 0;
        switch(r12) {
            case 65: goto L_0x0008;
            case 67: goto L_0x0126;
            case 72: goto L_0x00b7;
            case 76: goto L_0x0064;
            case 77: goto L_0x000a;
            case 81: goto L_0x0008;
            case 83: goto L_0x019d;
            case 84: goto L_0x0008;
            case 86: goto L_0x00ef;
            case 90: goto L_0x020a;
            case 97: goto L_0x0008;
            case 99: goto L_0x022b;
            case 104: goto L_0x00b6;
            case 108: goto L_0x0063;
            case 109: goto L_0x0009;
            case 113: goto L_0x0008;
            case 115: goto L_0x022e;
            case 116: goto L_0x0008;
            case 118: goto L_0x00ee;
            case 122: goto L_0x020a;
            default: goto L_0x0008;
        };
    L_0x0008:
        return;
    L_0x0009:
        r0 = r1;
    L_0x000a:
        r2 = r13.length;
        if (r0 == 0) goto L_0x0060;
    L_0x000d:
        if (r1 >= r2) goto L_0x0008;
    L_0x000f:
        r0 = r1 + 1;
        r1 = r13[r1];
        r11.e = r1;
        r1 = r0 + 1;
        r0 = r13[r0];
        r11.f = r0;
        r0 = r11.e;
        r11.k = r0;
        r11.m = r0;
        r11.o = r0;
        r0 = r11.f;
        r11.l = r0;
        r11.n = r0;
        r11.p = r0;
        r0 = r11.c;
        r3 = r11.e;
        r4 = r11.f;
        r0.moveTo(r3, r4);
        goto L_0x000d;
    L_0x0035:
        r0 = r1 + 1;
        r1 = r13[r1];
        r11.e = r1;
        r1 = r0 + 1;
        r0 = r13[r0];
        r11.f = r0;
        r0 = r11.k;
        r3 = r11.e;
        r0 = r0 + r3;
        r11.k = r0;
        r11.m = r0;
        r11.o = r0;
        r0 = r11.l;
        r3 = r11.f;
        r0 = r0 + r3;
        r11.l = r0;
        r11.n = r0;
        r11.p = r0;
        r0 = r11.c;
        r3 = r11.e;
        r4 = r11.f;
        r0.rMoveTo(r3, r4);
    L_0x0060:
        if (r1 < r2) goto L_0x0035;
    L_0x0062:
        goto L_0x0008;
    L_0x0063:
        r0 = r1;
    L_0x0064:
        r2 = r13.length;
        if (r0 == 0) goto L_0x00b2;
    L_0x0067:
        if (r1 >= r2) goto L_0x0008;
    L_0x0069:
        r0 = r1 + 1;
        r1 = r13[r1];
        r11.e = r1;
        r1 = r0 + 1;
        r0 = r13[r0];
        r11.f = r0;
        r0 = r11.e;
        r11.k = r0;
        r11.m = r0;
        r0 = r11.f;
        r11.l = r0;
        r11.n = r0;
        r0 = r11.c;
        r3 = r11.e;
        r4 = r11.f;
        r0.lineTo(r3, r4);
        goto L_0x0067;
    L_0x008b:
        r0 = r1 + 1;
        r1 = r13[r1];
        r11.e = r1;
        r1 = r0 + 1;
        r0 = r13[r0];
        r11.f = r0;
        r0 = r11.k;
        r3 = r11.e;
        r0 = r0 + r3;
        r11.k = r0;
        r11.m = r0;
        r0 = r11.l;
        r3 = r11.f;
        r0 = r0 + r3;
        r11.l = r0;
        r11.n = r0;
        r0 = r11.c;
        r3 = r11.e;
        r4 = r11.f;
        r0.rLineTo(r3, r4);
    L_0x00b2:
        if (r1 < r2) goto L_0x008b;
    L_0x00b4:
        goto L_0x0008;
    L_0x00b6:
        r0 = r1;
    L_0x00b7:
        r2 = r13.length;
        if (r0 == 0) goto L_0x00ea;
    L_0x00ba:
        if (r1 >= r2) goto L_0x0008;
    L_0x00bc:
        r0 = r1 + 1;
        r1 = r13[r1];
        r11.e = r1;
        r1 = r11.e;
        r11.k = r1;
        r11.m = r1;
        r1 = r11.c;
        r3 = r11.e;
        r4 = r11.l;
        r1.lineTo(r3, r4);
        r1 = r0;
        goto L_0x00ba;
    L_0x00d3:
        r0 = r1 + 1;
        r1 = r13[r1];
        r11.e = r1;
        r1 = r11.k;
        r3 = r11.e;
        r1 = r1 + r3;
        r11.k = r1;
        r11.m = r1;
        r1 = r11.c;
        r3 = r11.e;
        r1.rLineTo(r3, r4);
        r1 = r0;
    L_0x00ea:
        if (r1 < r2) goto L_0x00d3;
    L_0x00ec:
        goto L_0x0008;
    L_0x00ee:
        r0 = r1;
    L_0x00ef:
        r2 = r13.length;
        if (r0 == 0) goto L_0x0122;
    L_0x00f2:
        if (r1 >= r2) goto L_0x0008;
    L_0x00f4:
        r0 = r1 + 1;
        r1 = r13[r1];
        r11.f = r1;
        r1 = r11.f;
        r11.l = r1;
        r11.n = r1;
        r1 = r11.c;
        r3 = r11.k;
        r4 = r11.f;
        r1.lineTo(r3, r4);
        r1 = r0;
        goto L_0x00f2;
    L_0x010b:
        r0 = r1 + 1;
        r1 = r13[r1];
        r11.f = r1;
        r1 = r11.l;
        r3 = r11.f;
        r1 = r1 + r3;
        r11.l = r1;
        r11.n = r1;
        r1 = r11.c;
        r3 = r11.f;
        r1.rLineTo(r4, r3);
        r1 = r0;
    L_0x0122:
        if (r1 < r2) goto L_0x010b;
    L_0x0124:
        goto L_0x0008;
    L_0x0126:
        r7 = r0;
    L_0x0127:
        r9 = r13.length;
    L_0x0128:
        if (r1 >= r9) goto L_0x0008;
    L_0x012a:
        r0 = r1 + 1;
        r1 = r13[r1];
        r11.g = r1;
        r1 = r0 + 1;
        r0 = r13[r0];
        r11.h = r0;
        r0 = r1 + 1;
        r1 = r13[r1];
        r11.i = r1;
        r1 = r0 + 1;
        r0 = r13[r0];
        r11.j = r0;
        r0 = r1 + 1;
        r1 = r13[r1];
        r11.e = r1;
        r8 = r0 + 1;
        r0 = r13[r0];
        r11.f = r0;
        if (r7 != 0) goto L_0x017a;
    L_0x0150:
        r0 = r11.g;
        r1 = r11.k;
        r0 = r0 + r1;
        r11.g = r0;
        r0 = r11.h;
        r1 = r11.l;
        r0 = r0 + r1;
        r11.h = r0;
        r0 = r11.i;
        r1 = r11.k;
        r0 = r0 + r1;
        r11.i = r0;
        r0 = r11.j;
        r1 = r11.l;
        r0 = r0 + r1;
        r11.j = r0;
        r0 = r11.e;
        r1 = r11.k;
        r0 = r0 + r1;
        r11.e = r0;
        r0 = r11.f;
        r1 = r11.l;
        r0 = r0 + r1;
        r11.f = r0;
    L_0x017a:
        r0 = r11.c;
        r1 = r11.g;
        r2 = r11.h;
        r3 = r11.i;
        r4 = r11.j;
        r5 = r11.e;
        r6 = r11.f;
        r0.cubicTo(r1, r2, r3, r4, r5, r6);
        r0 = r11.i;
        r11.m = r0;
        r0 = r11.j;
        r11.n = r0;
        r0 = r11.e;
        r11.k = r0;
        r0 = r11.f;
        r11.l = r0;
        r1 = r8;
        goto L_0x0128;
    L_0x019d:
        r7 = r0;
    L_0x019e:
        r9 = r13.length;
    L_0x019f:
        if (r1 >= r9) goto L_0x0008;
    L_0x01a1:
        r0 = r1 + 1;
        r1 = r13[r1];
        r11.i = r1;
        r1 = r0 + 1;
        r0 = r13[r0];
        r11.j = r0;
        r0 = r1 + 1;
        r1 = r13[r1];
        r11.e = r1;
        r8 = r0 + 1;
        r0 = r13[r0];
        r11.f = r0;
        r0 = r11.k;
        r0 = r0 * r10;
        r1 = r11.m;
        r0 = r0 - r1;
        r11.g = r0;
        r0 = r11.l;
        r0 = r0 * r10;
        r1 = r11.n;
        r0 = r0 - r1;
        r11.h = r0;
        if (r7 != 0) goto L_0x01e7;
    L_0x01cb:
        r0 = r11.i;
        r1 = r11.k;
        r0 = r0 + r1;
        r11.i = r0;
        r0 = r11.j;
        r1 = r11.l;
        r0 = r0 + r1;
        r11.j = r0;
        r0 = r11.e;
        r1 = r11.k;
        r0 = r0 + r1;
        r11.e = r0;
        r0 = r11.f;
        r1 = r11.l;
        r0 = r0 + r1;
        r11.f = r0;
    L_0x01e7:
        r0 = r11.c;
        r1 = r11.g;
        r2 = r11.h;
        r3 = r11.i;
        r4 = r11.j;
        r5 = r11.e;
        r6 = r11.f;
        r0.cubicTo(r1, r2, r3, r4, r5, r6);
        r0 = r11.i;
        r11.m = r0;
        r0 = r11.j;
        r11.n = r0;
        r0 = r11.e;
        r11.k = r0;
        r0 = r11.f;
        r11.l = r0;
        r1 = r8;
        goto L_0x019f;
    L_0x020a:
        r0 = r11.c;
        r0.close();
        r0 = r11.c;
        r1 = r11.o;
        r2 = r11.p;
        r0.moveTo(r1, r2);
        r0 = r11.o;
        r11.k = r0;
        r11.m = r0;
        r0 = r11.p;
        r11.l = r0;
        r11.n = r0;
        r0 = r11.c;
        r0.close();
        goto L_0x0008;
    L_0x022b:
        r7 = r1;
        goto L_0x0127;
    L_0x022e:
        r7 = r1;
        goto L_0x019e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.b.a.x.a(char, float[]):void");
    }
}
