package com.b.a.a.a.a;

/* compiled from: ProGuard */
public class c {
    static final /* synthetic */ boolean g = (!c.class.desiredAssertionStatus());
    private boolean A = false;
    private int B;
    private boolean C = true;
    private d D = new d();
    private d E = new d();
    private d F = new d();
    private d G = new d();
    private d H = new d();
    private d I = new d();
    private d J = new d();
    private d K = new d();
    private a L = new a();
    private a M = new a();
    private a N = new a();
    private a O = new a();
    private a P = new a();
    private a Q = new a();
    private a R = new a();
    private a S = new a();
    private d T = new d();
    private d U = new d();
    private d V = new d();
    private d W = new d();
    private d X = new d();
    private d Y = new d();
    private d Z = new d();
    public double[] a = new double[16];
    private d aa = new d();
    private d ab = new d();
    private boolean ac;
    private boolean ad;
    public d b = new d();
    public final a c = new a();
    public d d = new d();
    public d e = new d();
    public a f = new a();
    private d h = new d();
    private d i = new d();
    private d j = new d();
    private d k = new d();
    private d l = new d();
    private d m = new d();
    private d n = new d();
    private d o = new d();
    private a p = new a();
    private a q = new a();
    private a r = new a();
    private a s = new a();
    private a t = new a();
    private a u = new a();
    private a v = new a();
    private long w = 0;
    private double x = 0.0d;
    private double y = 0.0d;
    private float z;

    public c() {
        this.b.b();
        this.h.b();
        this.i.a();
        this.i.a(25.0d);
        this.j.a();
        this.j.a(1.0d);
        this.k.a();
        this.k.a(0.0625d);
        this.l.a();
        this.l.a(0.5625d);
        this.m.a();
        this.n.a();
        this.o.a();
        this.p.a();
        this.q.a();
        this.r.a();
        this.s.a();
        this.t.a();
        this.u.a(0.0d, 0.0d, 9.81d);
        this.v.a(0.0d, 1.0d, 0.0d);
        this.ac = false;
        this.ad = false;
    }

    public final synchronized void a(a aVar, long j) {
        if (this.w != 0) {
            int i;
            float f = ((float) (j - this.w)) * 1.0E-9f;
            if (f > 0.04f) {
                f = this.C ? this.z : 0.01f;
            } else if (this.A) {
                this.z = (0.95f * this.z) + (0.050000012f * f);
                int i2 = this.B + 1;
                this.B = i2;
                if (i2 > 10) {
                    this.C = true;
                }
            } else {
                this.z = f;
                this.B = 1;
                this.A = true;
            }
            this.s.a(aVar);
            this.s.a((double) (-f));
            b.a(this.s, this.h);
            d.a(this.h, this.b, this.b);
            a();
            this.F.a(this.j);
            d dVar = this.F;
            double d = (double) (f * f);
            for (i = 0; i < 9; i++) {
                double[] dArr = dVar.a;
                dArr[i] = dArr[i] * d;
            }
            dVar = this.i;
            d dVar2 = this.F;
            for (i = 0; i < 9; i++) {
                double[] dArr2 = dVar.a;
                dArr2[i] = dArr2[i] + dVar2.a[i];
            }
        }
        this.w = j;
        this.c.a(aVar);
    }

    public final synchronized void a(a aVar) {
        this.q.a(aVar);
        double c = this.q.c();
        double abs = Math.abs(c - this.x);
        this.x = c;
        this.y = (0.5d * abs) + (0.5d * this.y);
        c = Math.min(7.0d, ((this.y / 0.15d) * 6.25d) + 0.75d);
        this.l.a(c * c);
        if (this.ac) {
            int i;
            a(this.b, this.p);
            for (i = 0; i < 3; i++) {
                a aVar2 = this.N;
                aVar2.a();
                aVar2.a(i, 1.0E-7d);
                b.a(aVar2, this.G);
                d.a(this.G, this.b, this.H);
                a(this.H, this.L);
                a.a(this.p, this.L, this.M);
                this.M.a(1.0E7d);
                this.n.a(i, this.M);
            }
            this.n.b(this.I);
            d.a(this.i, this.I, this.J);
            d.a(this.n, this.J, this.K);
            d dVar = this.K;
            d dVar2 = this.l;
            d dVar3 = this.m;
            dVar3.a[0] = dVar.a[0] + dVar2.a[0];
            dVar3.a[1] = dVar.a[1] + dVar2.a[1];
            dVar3.a[2] = dVar.a[2] + dVar2.a[2];
            dVar3.a[3] = dVar.a[3] + dVar2.a[3];
            dVar3.a[4] = dVar.a[4] + dVar2.a[4];
            dVar3.a[5] = dVar.a[5] + dVar2.a[5];
            dVar3.a[6] = dVar.a[6] + dVar2.a[6];
            dVar3.a[7] = dVar.a[7] + dVar2.a[7];
            dVar3.a[8] = dVar2.a[8] + dVar.a[8];
            dVar = this.m;
            dVar2 = this.I;
            abs = ((dVar.a(0, 0) * ((dVar.a(1, 1) * dVar.a(2, 2)) - (dVar.a(2, 1) * dVar.a(1, 2)))) - (dVar.a(0, 1) * ((dVar.a(1, 0) * dVar.a(2, 2)) - (dVar.a(1, 2) * dVar.a(2, 0))))) + (dVar.a(0, 2) * ((dVar.a(1, 0) * dVar.a(2, 1)) - (dVar.a(1, 1) * dVar.a(2, 0))));
            if (abs != 0.0d) {
                double d = 1.0d / abs;
                dVar2.a(((dVar.a[4] * dVar.a[8]) - (dVar.a[7] * dVar.a[5])) * d, (-((dVar.a[1] * dVar.a[8]) - (dVar.a[2] * dVar.a[7]))) * d, ((dVar.a[1] * dVar.a[5]) - (dVar.a[2] * dVar.a[4])) * d, (-((dVar.a[3] * dVar.a[8]) - (dVar.a[5] * dVar.a[6]))) * d, ((dVar.a[0] * dVar.a[8]) - (dVar.a[2] * dVar.a[6])) * d, (-((dVar.a[0] * dVar.a[5]) - (dVar.a[3] * dVar.a[2]))) * d, ((dVar.a[3] * dVar.a[7]) - (dVar.a[6] * dVar.a[4])) * d, (-((dVar.a[0] * dVar.a[7]) - (dVar.a[6] * dVar.a[1]))) * d, d * ((dVar.a[0] * dVar.a[4]) - (dVar.a[3] * dVar.a[1])));
            }
            this.n.b(this.J);
            d.a(this.J, this.I, this.K);
            d.a(this.i, this.K, this.o);
            d.a(this.o, this.p, this.t);
            d.a(this.o, this.n, this.I);
            this.J.b();
            dVar2 = this.J;
            dVar3 = this.I;
            for (i = 0; i < 9; i++) {
                double[] dArr = dVar2.a;
                dArr[i] = dArr[i] - dVar3.a[i];
            }
            d.a(this.J, this.i, this.I);
            this.i.a(this.I);
            b.a(this.t, this.h);
            d.a(this.h, this.b, this.b);
            a();
        } else {
            b.a(this.u, this.q, this.b);
            this.ac = true;
        }
    }

    private void a() {
        this.h.b(this.Y);
        d.a(this.i, this.Y, this.Z);
        d.a(this.h, this.Z, this.i);
        this.h.b();
    }

    private void a(d dVar, a aVar) {
        d.a(dVar, this.u, this.r);
        b.a(this.r, this.q, this.aa);
        b.a(this.aa, aVar);
    }
}
