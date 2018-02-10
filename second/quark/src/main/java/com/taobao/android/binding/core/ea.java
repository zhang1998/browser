package com.taobao.android.binding.core;

/* compiled from: ProGuard */
final class ea {
    double a = 0.0d;
    double b;
    double c;

    ea(double d) {
        this.b = d;
        this.c = 1.0d;
    }

    final void a(double d) {
        this.a = 0.0d;
        this.b = d;
        this.c = 1.0d;
    }

    final ea a(cn cnVar) {
        double d = this.a;
        double d2 = this.b;
        double d3 = this.c;
        double d4 = cnVar.a;
        double d5 = cnVar.b;
        double d6 = cnVar.c;
        double d7 = cnVar.d;
        double d8 = ((d7 * d) + (d5 * d3)) - (d6 * d2);
        double d9 = ((d7 * d2) + (d6 * d)) - (d4 * d3);
        double d10 = ((d7 * d3) + (d4 * d2)) - (d5 * d);
        d = ((d * (-d4)) - (d2 * d5)) - (d6 * d3);
        this.a = (((d8 * d7) + ((-d4) * d)) + ((-d6) * d9)) - ((-d5) * d10);
        this.b = (((d9 * d7) + ((-d5) * d)) + ((-d4) * d10)) - ((-d6) * d8);
        this.c = (((d * (-d6)) + (d10 * d7)) + ((-d5) * d8)) - ((-d4) * d9);
        return this;
    }
}
