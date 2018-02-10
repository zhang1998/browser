package com.b.a.a.a.a;

/* compiled from: ProGuard */
public final class d {
    public double[] a = new double[9];

    public final void a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.a[0] = d;
        this.a[1] = d2;
        this.a[2] = d3;
        this.a[3] = d4;
        this.a[4] = d5;
        this.a[5] = d6;
        this.a[6] = d7;
        this.a[7] = d8;
        this.a[8] = d9;
    }

    public final void a(d dVar) {
        this.a[0] = dVar.a[0];
        this.a[1] = dVar.a[1];
        this.a[2] = dVar.a[2];
        this.a[3] = dVar.a[3];
        this.a[4] = dVar.a[4];
        this.a[5] = dVar.a[5];
        this.a[6] = dVar.a[6];
        this.a[7] = dVar.a[7];
        this.a[8] = dVar.a[8];
    }

    public final void a() {
        this.a[0] = 0.0d;
        this.a[1] = 0.0d;
        this.a[2] = 0.0d;
        this.a[3] = 0.0d;
        this.a[4] = 0.0d;
        this.a[5] = 0.0d;
        this.a[6] = 0.0d;
        this.a[7] = 0.0d;
        this.a[8] = 0.0d;
    }

    public final void b() {
        this.a[0] = 1.0d;
        this.a[1] = 0.0d;
        this.a[2] = 0.0d;
        this.a[3] = 0.0d;
        this.a[4] = 1.0d;
        this.a[5] = 0.0d;
        this.a[6] = 0.0d;
        this.a[7] = 0.0d;
        this.a[8] = 1.0d;
    }

    public final void a(double d) {
        this.a[0] = d;
        this.a[4] = d;
        this.a[8] = d;
    }

    public final double a(int i, int i2) {
        return this.a[(i * 3) + i2];
    }

    public final void a(int i, int i2, double d) {
        this.a[(i * 3) + i2] = d;
    }

    public final void a(int i, a aVar) {
        this.a[i] = aVar.a;
        this.a[i + 3] = aVar.b;
        this.a[i + 6] = aVar.c;
    }

    public final void b(d dVar) {
        double d = this.a[1];
        double d2 = this.a[2];
        double d3 = this.a[5];
        dVar.a[0] = this.a[0];
        dVar.a[1] = this.a[3];
        dVar.a[2] = this.a[6];
        dVar.a[3] = d;
        dVar.a[4] = this.a[4];
        dVar.a[5] = this.a[7];
        dVar.a[6] = d2;
        dVar.a[7] = d3;
        dVar.a[8] = this.a[8];
    }

    public static void a(d dVar, d dVar2, d dVar3) {
        d dVar4 = dVar3;
        dVar4.a((dVar.a[2] * dVar2.a[6]) + ((dVar.a[0] * dVar2.a[0]) + (dVar.a[1] * dVar2.a[3])), (dVar.a[2] * dVar2.a[7]) + ((dVar.a[0] * dVar2.a[1]) + (dVar.a[1] * dVar2.a[4])), (dVar.a[2] * dVar2.a[8]) + ((dVar.a[0] * dVar2.a[2]) + (dVar.a[1] * dVar2.a[5])), (dVar.a[5] * dVar2.a[6]) + ((dVar.a[3] * dVar2.a[0]) + (dVar.a[4] * dVar2.a[3])), (dVar.a[5] * dVar2.a[7]) + ((dVar.a[3] * dVar2.a[1]) + (dVar.a[4] * dVar2.a[4])), (dVar.a[5] * dVar2.a[8]) + ((dVar.a[3] * dVar2.a[2]) + (dVar.a[4] * dVar2.a[5])), (dVar.a[8] * dVar2.a[6]) + ((dVar.a[6] * dVar2.a[0]) + (dVar.a[7] * dVar2.a[3])), (dVar.a[8] * dVar2.a[7]) + ((dVar.a[6] * dVar2.a[1]) + (dVar.a[7] * dVar2.a[4])), (dVar.a[8] * dVar2.a[8]) + ((dVar.a[6] * dVar2.a[2]) + (dVar.a[7] * dVar2.a[5])));
    }

    public static void a(d dVar, a aVar, a aVar2) {
        double d = ((dVar.a[3] * aVar.a) + (dVar.a[4] * aVar.b)) + (dVar.a[5] * aVar.c);
        double d2 = ((dVar.a[6] * aVar.a) + (dVar.a[7] * aVar.b)) + (dVar.a[8] * aVar.c);
        aVar2.a = ((dVar.a[0] * aVar.a) + (dVar.a[1] * aVar.b)) + (dVar.a[2] * aVar.c);
        aVar2.b = d;
        aVar2.c = d2;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("{ ");
        for (int i = 0; i < 9; i++) {
            stringBuilder.append(Double.toString(this.a[i]));
            if (i < 8) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
