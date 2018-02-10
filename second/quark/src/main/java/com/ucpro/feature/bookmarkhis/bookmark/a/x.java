package com.ucpro.feature.bookmarkhis.bookmark.a;

import android.util.Log;
import com.uc.sync.a.a;
import com.uc.sync.f.l;
import com.ucpro.feature.g.d.b.b;

/* compiled from: ProGuard */
public final class x extends l {
    public String m;
    public String n;
    public String o;
    public int p;
    public long q;
    public int r;
    public long s;
    int t;
    public long u;

    public x() {
        this.k = "android";
        this.l = "phone";
        this.t = 1;
    }

    public final void a(x xVar) {
        super.a((l) xVar);
        this.m = xVar.m;
        this.n = xVar.n;
        this.o = xVar.o;
        this.p = xVar.p;
        this.u = xVar.u;
        this.q = xVar.q;
        this.r = xVar.r;
        this.s = xVar.s;
        this.t = xVar.t;
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.m = a.b(bVar.b);
            this.o = a.b(bVar.a);
            this.p = bVar.c;
            Object obj = bVar.i;
            Log.w("chris", "icon data for " + this.n + obj);
            ah a = ah.a(a.b(obj));
            if (a != null) {
                this.u = a.a;
            }
            this.q = bVar.h;
            this.k = a.b(bVar.e);
            this.r = bVar.g;
            if (this.p == 1) {
                this.n = this.o;
            } else {
                this.n = a.b(bVar.f);
            }
            this.l = a.b(bVar.d);
            if (bVar.g < 0) {
                this.r = Integer.MAX_VALUE;
            }
        }
    }

    public final String toString() {
        return "luid:" + this.j + ",guid:" + this.e + ",parentId:" + this.s + ",folder:" + this.p + ",property:" + this.t + ",optState:" + this.b + ",syncState:" + this.d + ",pinTime:" + this.u + ",title:" + this.n + ",url:" + this.o;
    }
}
