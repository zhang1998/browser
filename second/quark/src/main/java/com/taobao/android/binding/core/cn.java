package com.taobao.android.binding.core;

/* compiled from: ProGuard */
final class cn {
    double a;
    double b;
    double c;
    double d;

    cn() {
    }

    cn(double d, double d2) {
        this.a = d;
        this.b = 0.0d;
        this.c = 0.0d;
        this.d = d2;
    }

    public final String toString() {
        return "Quaternion{x=" + this.a + ", y=" + this.b + ", z=" + this.c + ", w=" + this.d + '}';
    }

    final cn a(cn cnVar) {
        double d = this.a;
        double d2 = this.b;
        double d3 = this.c;
        double d4 = this.d;
        double d5 = cnVar.a;
        double d6 = cnVar.b;
        double d7 = cnVar.c;
        double d8 = cnVar.d;
        this.a = (((d * d8) + (d4 * d5)) + (d2 * d7)) - (d3 * d6);
        this.b = (((d2 * d8) + (d4 * d6)) + (d3 * d5)) - (d * d7);
        this.c = (((d3 * d8) + (d4 * d7)) + (d * d6)) - (d2 * d5);
        this.d = (((d4 * d8) - (d * d5)) - (d2 * d6)) - (d3 * d7);
        return this;
    }
}
