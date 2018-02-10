package com.ucpro.feature.video.player;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class e {
    private final int A;
    private List<a> B;
    public long a;
    public boolean b;
    public boolean c;
    public int d;
    public int e;
    public boolean f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public String o;
    public String p;
    public String q;
    public boolean r;
    public List<s> s;
    public List<p> t;
    public List<f> u;
    boolean v;
    public String w;
    public List<String> x;
    boolean y;
    public int z;

    e() {
        this.A = 200;
        this.v = false;
        this.w = "normal";
        this.x = null;
        this.y = false;
        this.z = 0;
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.B = new ArrayList();
        this.u = new ArrayList();
        this.x = new ArrayList();
        this.x.add("normal");
    }

    final void a(boolean z) {
        this.c = z;
        if (!z) {
            a();
        }
    }

    final void b(boolean z) {
        this.i = z;
        c(true);
    }

    final void a(int i) {
        if (!this.i && this.g > 0) {
            this.h = i;
            c(false);
        }
    }

    public final void a(p pVar) {
        if (!this.t.contains(pVar)) {
            this.t.add(pVar);
        }
    }

    public final void a(a aVar) {
        if (!this.B.contains(aVar)) {
            this.B.add(aVar);
        }
    }

    public final void a() {
        for (int i = 0; i < this.s.size(); i++) {
            boolean z;
            s sVar = (s) this.s.get(i);
            boolean z2 = this.b;
            if (this.c || this.f) {
                z = true;
            } else {
                z = false;
            }
            sVar.a(z2, z, this.d, this.e);
        }
    }

    public final void c(boolean z) {
        for (int i = 0; i < this.t.size(); i++) {
            ((p) this.t.get(i)).a(this.b, this.i, this.j, this.g, this.h, z);
        }
    }

    public final void b() {
        for (int i = 0; i < this.B.size(); i++) {
            boolean z;
            a aVar = (a) this.B.get(i);
            if (this.b && this.l && this.k) {
                z = true;
            } else {
                z = false;
            }
            aVar.a(z);
        }
    }
}
