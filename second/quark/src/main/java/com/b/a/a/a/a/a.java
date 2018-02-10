package com.b.a.a.a.a;

/* compiled from: ProGuard */
public final class a {
    public double a;
    public double b;
    public double c;

    public final void a(double d, double d2, double d3) {
        this.a = d;
        this.b = d2;
        this.c = d3;
    }

    public final void a(int i, double d) {
        if (i == 0) {
            this.a = d;
        } else if (i == 1) {
            this.b = d;
        } else {
            this.c = d;
        }
    }

    public final void a() {
        this.c = 0.0d;
        this.b = 0.0d;
        this.a = 0.0d;
    }

    public final void a(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
    }

    public final void a(double d) {
        this.a *= d;
        this.b *= d;
        this.c *= d;
    }

    public final void b() {
        double c = c();
        if (c != 0.0d) {
            a(1.0d / c);
        }
    }

    public static double a(a aVar, a aVar2) {
        return ((aVar.a * aVar2.a) + (aVar.b * aVar2.b)) + (aVar.c * aVar2.c);
    }

    public final double c() {
        return Math.sqrt(((this.a * this.a) + (this.b * this.b)) + (this.c * this.c));
    }

    public static void a(a aVar, a aVar2, a aVar3) {
        aVar3.a(aVar.a - aVar2.a, aVar.b - aVar2.b, aVar.c - aVar2.c);
    }

    public static void b(a aVar, a aVar2, a aVar3) {
        aVar3.a((aVar.b * aVar2.c) - (aVar.c * aVar2.b), (aVar.c * aVar2.a) - (aVar.a * aVar2.c), (aVar.a * aVar2.b) - (aVar.b * aVar2.a));
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("{ ");
        stringBuilder.append(Double.toString(this.a));
        stringBuilder.append(", ");
        stringBuilder.append(Double.toString(this.b));
        stringBuilder.append(", ");
        stringBuilder.append(Double.toString(this.c));
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
