package com.taobao.android.binding.core;

import android.mini.support.annotation.Nullable;
import android.text.TextUtils;

/* compiled from: ProGuard */
final class cm {
    private cn a = new cn(0.0d, 1.0d);
    private Double b = null;
    private Double c = null;
    private Double d = null;
    private double e = 0.0d;
    private double f = 0.0d;
    private double g = 0.0d;
    private final ea h = new ea(0.0d);
    private final g i = new g();
    private final cn j = new cn();
    private final cn k = new cn(-Math.sqrt(0.5d), Math.sqrt(0.5d));

    cm(@Nullable Double d, @Nullable Double d2, @Nullable Double d3) {
        this.b = d;
        this.c = d2;
        this.d = d3;
    }

    final cn a(double d, double d2, double d3) {
        double doubleValue;
        double toRadians = Math.toRadians(this.b != null ? this.b.doubleValue() : this.e + d3);
        double toRadians2 = Math.toRadians(this.c != null ? this.c.doubleValue() : this.f + d);
        if (this.d != null) {
            doubleValue = this.d.doubleValue();
        } else {
            doubleValue = this.g + d2;
        }
        doubleValue = Math.toRadians(doubleValue);
        cn cnVar = this.a;
        g gVar = this.i;
        double d4 = -doubleValue;
        String str = "YXZ";
        gVar.b = toRadians2;
        gVar.c = toRadians;
        gVar.d = d4;
        if (TextUtils.isEmpty(str)) {
            str = "XYZ";
        }
        gVar.a = str;
        g gVar2 = this.i;
        if (gVar2 != null && gVar2.e) {
            toRadians = Math.cos(gVar2.b / 2.0d);
            toRadians2 = Math.cos(gVar2.c / 2.0d);
            d4 = Math.cos(gVar2.d / 2.0d);
            double sin = Math.sin(gVar2.b / 2.0d);
            double sin2 = Math.sin(gVar2.c / 2.0d);
            double sin3 = Math.sin(gVar2.d / 2.0d);
            str = gVar2.a;
            if ("XYZ".equals(str)) {
                cnVar.a = ((sin * toRadians2) * d4) + ((toRadians * sin2) * sin3);
                cnVar.b = ((toRadians * sin2) * d4) - ((sin * toRadians2) * sin3);
                cnVar.c = ((toRadians * toRadians2) * sin3) + ((sin * sin2) * d4);
                cnVar.d = ((toRadians * toRadians2) * d4) - ((sin * sin2) * sin3);
            } else if ("YXZ".equals(str)) {
                cnVar.a = ((sin * toRadians2) * d4) + ((toRadians * sin2) * sin3);
                cnVar.b = ((toRadians * sin2) * d4) - ((sin * toRadians2) * sin3);
                cnVar.c = ((toRadians * toRadians2) * sin3) - ((sin * sin2) * d4);
                cnVar.d = ((toRadians * toRadians2) * d4) + ((sin * sin2) * sin3);
            } else if ("ZXY".equals(str)) {
                cnVar.a = ((sin * toRadians2) * d4) - ((toRadians * sin2) * sin3);
                cnVar.b = ((toRadians * sin2) * d4) + ((sin * toRadians2) * sin3);
                cnVar.c = ((toRadians * toRadians2) * sin3) + ((sin * sin2) * d4);
                cnVar.d = ((toRadians * toRadians2) * d4) - ((sin * sin2) * sin3);
            } else if ("ZYX".equals(str)) {
                cnVar.a = ((sin * toRadians2) * d4) - ((toRadians * sin2) * sin3);
                cnVar.b = ((toRadians * sin2) * d4) + ((sin * toRadians2) * sin3);
                cnVar.c = ((toRadians * toRadians2) * sin3) - ((sin * sin2) * d4);
                cnVar.d = ((toRadians * toRadians2) * d4) + ((sin * sin2) * sin3);
            } else if ("YZX".equals(str)) {
                cnVar.a = ((sin * toRadians2) * d4) + ((toRadians * sin2) * sin3);
                cnVar.b = ((toRadians * sin2) * d4) + ((sin * toRadians2) * sin3);
                cnVar.c = ((toRadians * toRadians2) * sin3) - ((sin * sin2) * d4);
                cnVar.d = ((toRadians * toRadians2) * d4) - ((sin * sin2) * sin3);
            } else if ("XZY".equals(str)) {
                cnVar.a = ((sin * toRadians2) * d4) - ((toRadians * sin2) * sin3);
                cnVar.b = ((toRadians * sin2) * d4) - ((sin * toRadians2) * sin3);
                cnVar.c = ((toRadians * toRadians2) * sin3) + ((sin * sin2) * d4);
                cnVar.d = ((toRadians * toRadians2) * d4) + ((sin * sin2) * sin3);
            }
        }
        cnVar.a(this.k);
        cn cnVar2 = this.j;
        ea eaVar = this.h;
        toRadians = Math.sin(-0.0d);
        cnVar2.a = eaVar.a * toRadians;
        cnVar2.b = eaVar.b * toRadians;
        cnVar2.c = toRadians * eaVar.c;
        cnVar2.d = Math.cos(-0.0d);
        cnVar.a(cnVar2);
        return this.a;
    }
}
