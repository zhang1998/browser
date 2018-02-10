package com.uc.weex.component.h;

import com.uc.apollo.impl.SettingsConst;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public class j {
    static Pattern a = Pattern.compile("[a-df-z]|[\\-+]?(?:[\\d\\.]e[\\-+]?|[^\\s\\-+,a-z])+", 10);
    double b = 0.0d;
    double c = 0.0d;
    double d = 0.0d;
    double e = 0.0d;
    Double f;
    Double g;

    public static Double a(String str) {
        Double d = null;
        if (str != null) {
            try {
                d = Double.valueOf(Double.parseDouble(str));
            } catch (Exception e) {
            }
        }
        return d;
    }

    public static boolean b(String str) {
        if (str == null || SettingsConst.FALSE.equals(str)) {
            return false;
        }
        return true;
    }

    public final j a(double d, double d2) {
        return b(this.b + d, this.c + d2);
    }

    public final j b(double d, double d2) {
        if (this.f == null) {
            this.f = Double.valueOf(this.b);
            this.g = Double.valueOf(this.c);
        }
        double d3 = this.b;
        double d4 = this.c;
        this.b = d;
        this.d = d;
        this.c = d2;
        this.e = d2;
        a(d3, d4, d, d2);
        return this;
    }

    public final j a(double d, double d2, Double d3, Double d4, Double d5, Double d6) {
        Double d7;
        Double d8;
        Double d9;
        Double d10;
        double d11 = this.b;
        double d12 = this.c;
        double d13 = d11 + d;
        double d14 = d12 + d2;
        if (d3 == null) {
            d7 = null;
        } else {
            d7 = Double.valueOf(d3.doubleValue() + d11);
        }
        if (d4 == null) {
            d8 = null;
        } else {
            d8 = Double.valueOf(d4.doubleValue() + d12);
        }
        if (d5 == null) {
            d9 = null;
        } else {
            d9 = Double.valueOf(d11 + d5.doubleValue());
        }
        if (d6 == null) {
            d10 = null;
        } else {
            d10 = Double.valueOf(d6.doubleValue() + d12);
        }
        return b(d13, d14, d7, d8, d9, d10);
    }

    public final j b(double d, double d2, Double d3, Double d4, Double d5, Double d6) {
        double d7;
        double d8;
        double d9;
        double d10;
        double d11 = this.b;
        double d12 = this.c;
        double doubleValue = d3 == null ? 0.0d : d3.doubleValue();
        double doubleValue2 = d4 == null ? 0.0d : d4.doubleValue();
        double doubleValue3 = d5 == null ? 0.0d : d5.doubleValue();
        double doubleValue4 = d6 == null ? 0.0d : d6.doubleValue();
        if (d3 == null) {
            d7 = (2.0d * d11) - this.d;
            d8 = (2.0d * d12) - this.e;
            doubleValue2 = d2;
            doubleValue = d;
        } else {
            d8 = d2;
            d7 = d;
        }
        if (d5 == null) {
            this.d = d7;
            this.e = d8;
            d9 = ((2.0d * d7) + doubleValue) / 3.0d;
            d10 = ((2.0d * d8) + doubleValue2) / 3.0d;
            doubleValue3 = ((2.0d * d7) + d11) / 3.0d;
            d8 = ((2.0d * d8) + d12) / 3.0d;
        } else {
            this.d = doubleValue;
            this.e = doubleValue2;
            d10 = doubleValue2;
            d9 = doubleValue;
            doubleValue2 = doubleValue4;
            doubleValue = doubleValue3;
            doubleValue3 = d7;
        }
        if (this.f == null) {
            this.f = Double.valueOf(d11);
            this.g = Double.valueOf(d12);
        }
        this.b = doubleValue;
        this.c = doubleValue2;
        a(d11, d12, doubleValue3, d8, d9, d10, doubleValue, doubleValue2);
        return this;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.uc.weex.component.h.j a(double r38, double r40, double r42, double r44, boolean r46, boolean r47, java.lang.String r48) {
        /*
        r37 = this;
        r4 = 0;
        r4 = (r44 > r4 ? 1 : (r44 == r4 ? 0 : -1));
        if (r4 == 0) goto L_0x0043;
    L_0x0006:
        r20 = java.lang.Math.abs(r44);
    L_0x000a:
        r4 = 0;
        r4 = (r42 > r4 ? 1 : (r42 == r4 ? 0 : -1));
        if (r4 == 0) goto L_0x0059;
    L_0x0010:
        r4 = java.lang.Math.abs(r42);
    L_0x0014:
        r6 = 0;
        r6 = com.uc.weex.component.h.v.a(r4, r6);
        if (r6 != 0) goto L_0x003e;
    L_0x001c:
        r6 = 0;
        r0 = r20;
        r6 = com.uc.weex.component.h.v.a(r0, r6);
        if (r6 != 0) goto L_0x003e;
    L_0x0026:
        r0 = r37;
        r6 = r0.b;
        r0 = r38;
        r6 = com.uc.weex.component.h.v.a(r0, r6);
        if (r6 == 0) goto L_0x0064;
    L_0x0032:
        r0 = r37;
        r6 = r0.c;
        r0 = r40;
        r6 = com.uc.weex.component.h.v.a(r0, r6);
        if (r6 == 0) goto L_0x0064;
    L_0x003e:
        r37 = r37.b(r38, r40);
    L_0x0042:
        return r37;
    L_0x0043:
        r4 = 0;
        r4 = (r42 > r4 ? 1 : (r42 == r4 ? 0 : -1));
        if (r4 == 0) goto L_0x004e;
    L_0x0049:
        r20 = java.lang.Math.abs(r42);
        goto L_0x000a;
    L_0x004e:
        r0 = r37;
        r4 = r0.c;
        r4 = r40 - r4;
        r20 = java.lang.Math.abs(r4);
        goto L_0x000a;
    L_0x0059:
        r0 = r37;
        r4 = r0.b;
        r4 = r38 - r4;
        r4 = java.lang.Math.abs(r4);
        goto L_0x0014;
    L_0x0064:
        r0 = r37;
        r6 = r0.b;
        r0 = r37;
        r8 = r0.c;
        if (r47 != 0) goto L_0x0166;
    L_0x006e:
        r10 = 1;
        r26 = r10;
    L_0x0071:
        if (r48 == 0) goto L_0x016b;
    L_0x0073:
        r10 = com.uc.weex.component.h.v.a(r48);
        r12 = 4614256656552045848; // 0x400921fb54442d18 float:3.37028055E12 double:3.141592653589793;
        r10 = r10 * r12;
        r12 = 4640537203540230144; // 0x4066800000000000 float:0.0 double:180.0;
        r10 = r10 / r12;
    L_0x0083:
        r14 = java.lang.Math.cos(r10);
        r16 = java.lang.Math.sin(r10);
        r28 = r38 - r6;
        r30 = r40 - r8;
        r10 = r14 * r28;
        r12 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        r10 = r10 / r12;
        r12 = r16 * r30;
        r18 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        r12 = r12 / r18;
        r12 = r12 + r10;
        r0 = r16;
        r10 = -r0;
        r10 = r10 * r28;
        r18 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        r10 = r10 / r18;
        r18 = r14 * r30;
        r22 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        r18 = r18 / r22;
        r18 = r18 + r10;
        r10 = r4 * r4;
        r10 = r10 * r20;
        r10 = r10 * r20;
        r22 = r20 * r20;
        r22 = r22 * r12;
        r22 = r22 * r12;
        r24 = r4 * r4;
        r24 = r24 * r18;
        r24 = r24 * r18;
        r32 = r10 - r24;
        r32 = r32 - r22;
        r34 = 0;
        r27 = (r32 > r34 ? 1 : (r32 == r34 ? 0 : -1));
        if (r27 >= 0) goto L_0x016f;
    L_0x00c8:
        r12 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r10 = r32 / r10;
        r10 = r12 - r10;
        r10 = java.lang.Math.sqrt(r10);
        r18 = r4 * r10;
        r20 = r20 * r10;
        r4 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        r10 = r28 / r4;
        r4 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        r4 = r30 / r4;
    L_0x00de:
        r12 = r14 / r18;
        r24 = r16 / r18;
        r0 = r16;
        r0 = -r0;
        r16 = r0;
        r16 = r16 / r20;
        r14 = r14 / r20;
        r0 = -r10;
        r22 = r0;
        r22 = r22 * r16;
        r0 = -r4;
        r32 = r0;
        r32 = r32 * r14;
        r22 = r22 + r32;
        r0 = -r10;
        r32 = r0;
        r32 = r32 * r12;
        r0 = -r4;
        r34 = r0;
        r34 = r34 * r24;
        r32 = r32 + r34;
        r0 = r22;
        r2 = r32;
        r22 = java.lang.Math.atan2(r0, r2);
        r32 = r28 - r10;
        r16 = r16 * r32;
        r32 = r30 - r4;
        r14 = r14 * r32;
        r14 = r14 + r16;
        r16 = r28 - r10;
        r12 = r12 * r16;
        r16 = r30 - r4;
        r16 = r16 * r24;
        r12 = r12 + r16;
        r24 = java.lang.Math.atan2(r14, r12);
        r14 = r10 + r6;
        r16 = r4 + r8;
        r10 = r28 + r6;
        r12 = r30 + r8;
        r0 = r37;
        r4 = r0.f;
        if (r4 != 0) goto L_0x0149;
    L_0x0131:
        r0 = r37;
        r4 = r0.b;
        r4 = java.lang.Double.valueOf(r4);
        r0 = r37;
        r0.f = r4;
        r0 = r37;
        r4 = r0.c;
        r4 = java.lang.Double.valueOf(r4);
        r0 = r37;
        r0.g = r4;
    L_0x0149:
        r0 = r37;
        r0.b = r10;
        r0 = r37;
        r0.d = r10;
        r0 = r37;
        r0.c = r12;
        r0 = r37;
        r0.e = r12;
        if (r26 != 0) goto L_0x01a8;
    L_0x015b:
        r26 = 1;
    L_0x015d:
        r5 = r37;
        r27 = r48;
        r5.a(r6, r8, r10, r12, r14, r16, r18, r20, r22, r24, r26, r27);
        goto L_0x0042;
    L_0x0166:
        r10 = 0;
        r26 = r10;
        goto L_0x0071;
    L_0x016b:
        r10 = 0;
        goto L_0x0083;
    L_0x016f:
        r10 = r24 + r22;
        r10 = r32 / r10;
        r10 = java.lang.Math.sqrt(r10);
        r0 = r46;
        r1 = r26;
        if (r0 != r1) goto L_0x017e;
    L_0x017d:
        r10 = -r10;
    L_0x017e:
        r0 = -r10;
        r22 = r0;
        r18 = r18 * r22;
        r18 = r18 * r4;
        r18 = r18 / r20;
        r10 = r10 * r12;
        r10 = r10 * r20;
        r10 = r10 / r4;
        r12 = r14 * r18;
        r22 = r16 * r10;
        r12 = r12 - r22;
        r22 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        r22 = r28 / r22;
        r12 = r12 + r22;
        r18 = r18 * r16;
        r10 = r10 * r14;
        r10 = r10 + r18;
        r18 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        r18 = r30 / r18;
        r10 = r10 + r18;
        r18 = r4;
        r4 = r10;
        r10 = r12;
        goto L_0x00de;
    L_0x01a8:
        r26 = 0;
        goto L_0x015d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.weex.component.h.j.a(double, double, double, double, boolean, boolean, java.lang.String):com.uc.weex.component.h.j");
    }

    public void a() {
    }

    public void c(double d, double d2) {
    }

    public void a(double d, double d2, double d3, double d4) {
        a(d, d2, d, d2, d3, d4, d3, d4);
    }

    public void a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = d7 - d;
        double d10 = d8 - d2;
        double d11 = (d9 * d9) + (d10 * d10);
        double d12 = d3 - d;
        double d13 = d4 - d2;
        double d14 = (d12 * d9) + (d13 * d10);
        if (d14 > d11) {
            d12 -= d9;
            d13 -= d10;
        } else if (d14 > 0.0d && d11 != 0.0d) {
            d12 -= (d14 / d11) * d9;
            d13 -= (d14 / d11) * d10;
        }
        d14 = (d12 * d12) + (d13 * d13);
        d12 = d5 - d;
        d13 = d6 - d2;
        double d15 = (d12 * d9) + (d13 * d10);
        if (d15 > d11) {
            d12 -= d9;
            d13 -= d10;
        } else if (d15 > 0.0d && d11 != 0.0d) {
            d12 -= d9 * (d15 / d11);
            d13 -= (d15 / d11) * d10;
        }
        d13 = (d13 * d13) + (d12 * d12);
        if (d14 >= 0.01d || d13 >= 0.01d) {
            d13 = (d3 + d5) * 0.5d;
            d12 = (d4 + d6) * 0.5d;
            d10 = 0.5d * (d3 + d);
            d11 = 0.5d * (d4 + d2);
            d14 = 0.5d * (d10 + d13);
            d15 = 0.5d * (d11 + d12);
            double d16 = (d7 + d5) * 0.5d;
            double d17 = (d8 + d6) * 0.5d;
            double d18 = (d13 + d16) * 0.5d;
            double d19 = (d17 + d12) * 0.5d;
            double d20 = (d14 + d18) * 0.5d;
            double d21 = (d15 + d19) * 0.5d;
            a(d, d2, d10, d11, d14, d15, d20, d21);
            a(d20, d21, d18, d19, d16, d17, d7, d8);
            return;
        }
        a(d, d2, d7, d8);
    }

    public void a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, boolean z, String str) {
        double a = str != null ? (v.a(str) * 3.141592653589793d) / 180.0d : 0.0d;
        double cos = Math.cos(a);
        a = Math.sin(a);
        double d11 = cos * d7;
        double d12 = (-a) * d8;
        double d13 = a * d7;
        double d14 = cos * d8;
        a = d10 - d9;
        if (a < 0.0d && !z) {
            a += 6.283185307179586d;
        } else if (a > 0.0d && z) {
            a -= 6.283185307179586d;
        }
        int ceil = (int) Math.ceil(Math.abs(a / 1.5707963267948966d));
        double d15 = a / ((double) ceil);
        double tan = 1.0d * Math.tan(d15 / 4.0d);
        cos = Math.cos(d9);
        a = Math.sin(d9);
        double d16 = cos;
        int i = 0;
        double d17 = d2;
        cos = d;
        while (i < ceil) {
            double d18 = d16 - (tan * a);
            a += d16 * tan;
            d9 += d15;
            double cos2 = Math.cos(d9);
            double sin = Math.sin(d9);
            double d19 = cos2 + (tan * sin);
            double d20 = sin - (tan * cos2);
            d20 = (d12 * sin) + ((d11 * cos2) + d5);
            double d21 = (d14 * sin) + ((d13 * cos2) + d6);
            a(cos, d17, ((d11 * d18) + d5) + (d12 * a), ((d18 * d13) + d6) + (a * d14), (d12 * d20) + ((d11 * d19) + d5), (d14 * d20) + ((d13 * d19) + d6), d20, d21);
            d16 = cos2;
            i++;
            d17 = d21;
            cos = d20;
            a = sin;
        }
    }

    public void b(double d, double d2, double d3, double d4) {
        a(d, d2, d3, d4);
    }
}
