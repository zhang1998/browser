package com.tencent.tinker.b.a;

import com.alibaba.wireless.security.SecExceptionCode;
import com.tencent.tinker.b.a.a.a.e;
import com.tencent.tinker.b.a.a.a.f;
import com.tencent.tinker.b.a.a.a.j;
import com.tencent.tinker.b.a.a.a.m;
import com.tencent.tinker.b.a.a.a.n;
import com.tencent.tinker.b.a.a.a.o;
import com.tencent.tinker.b.a.a.a.p;
import com.tencent.tinker.b.a.c.i;
import com.tencent.tinker.c.a.aa;
import com.tencent.tinker.c.a.ac;
import com.tencent.tinker.c.a.ae;
import com.tencent.tinker.c.a.af;
import com.tencent.tinker.c.a.ai;
import com.tencent.tinker.c.a.aj;
import com.tencent.tinker.c.a.b;
import com.tencent.tinker.c.a.c;
import com.tencent.tinker.c.a.d;
import com.tencent.tinker.c.a.g;
import com.tencent.tinker.c.a.h;
import com.tencent.tinker.c.a.k;
import com.tencent.tinker.c.a.l;
import com.tencent.tinker.c.a.q;
import com.tencent.tinker.c.a.u;
import com.tencent.tinker.c.a.x;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* compiled from: ProGuard */
public final class a {
    private final u a;
    private final u b;
    private final com.tencent.tinker.b.a.b.a c;
    private final i d;
    private com.tencent.tinker.b.a.a.a.i<af> e;
    private com.tencent.tinker.b.a.a.a.i<Integer> f;
    private com.tencent.tinker.b.a.a.a.i<ae> g;
    private com.tencent.tinker.b.a.a.a.i<aa> h;
    private com.tencent.tinker.b.a.a.a.i<ac> i;
    private com.tencent.tinker.b.a.a.a.i<h> j;
    private com.tencent.tinker.b.a.a.a.i<aj> k;
    private com.tencent.tinker.b.a.a.a.i<c> l;
    private com.tencent.tinker.b.a.a.a.i<b> m;
    private com.tencent.tinker.b.a.a.a.i<g> n;
    private com.tencent.tinker.b.a.a.a.i<k> o;
    private com.tencent.tinker.b.a.a.a.i<l> p;
    private com.tencent.tinker.b.a.a.a.i<com.tencent.tinker.c.a.a> q;
    private com.tencent.tinker.b.a.a.a.i<x> r;
    private com.tencent.tinker.b.a.a.a.i<d> s;

    public a(InputStream inputStream, InputStream inputStream2) throws IOException {
        this(new u(inputStream), new com.tencent.tinker.b.a.b.a(inputStream2));
    }

    private a(u uVar, com.tencent.tinker.b.a.b.a aVar) {
        this.a = uVar;
        this.c = aVar;
        this.b = new u(aVar.c);
        this.d = new i();
    }

    public final void a(OutputStream outputStream) throws IOException {
        int i = 0;
        byte[] a = this.a.a(false);
        if (a == null) {
            throw new IOException("failed to compute old dex's signature.");
        } else if (this.c == null) {
            throw new IllegalArgumentException("patch file is null.");
        } else {
            if (com.tencent.tinker.c.a.b.c.a(a, this.c.u) != 0) {
                throw new IOException(String.format("old dex signature mismatch! expected: %s, actual: %s", new Object[]{Arrays.toString(a), Arrays.toString(this.c.u)}));
            }
            int i2;
            ai aiVar = this.b.b;
            aiVar.a.d = 0;
            aiVar.a.c = 1;
            aiVar.h.c = 1;
            aiVar.b.d = this.c.d;
            aiVar.c.d = this.c.e;
            aiVar.i.d = this.c.k;
            aiVar.d.d = this.c.f;
            aiVar.e.d = this.c.g;
            aiVar.f.d = this.c.h;
            aiVar.g.d = this.c.i;
            aiVar.h.d = this.c.j;
            aiVar.n.d = this.c.p;
            aiVar.p.d = this.c.r;
            aiVar.k.d = this.c.m;
            aiVar.j.d = this.c.l;
            aiVar.r.d = this.c.t;
            aiVar.q.d = this.c.s;
            aiVar.o.d = this.c.q;
            aiVar.m.d = this.c.o;
            aiVar.l.d = this.c.n;
            aiVar.v = this.c.c;
            Arrays.sort(aiVar.s);
            aiVar.a();
            this.e = new n(this.c, this.a, this.b, this.d);
            this.f = new o(this.c, this.a, this.b, this.d);
            this.g = new com.tencent.tinker.b.a.a.a.l(this.c, this.a, this.b, this.d);
            this.h = new j(this.c, this.a, this.b, this.d);
            this.i = new com.tencent.tinker.b.a.a.a.k(this.c, this.a, this.b, this.d);
            this.j = new f(this.c, this.a, this.b, this.d);
            this.k = new p(this.c, this.a, this.b, this.d);
            this.l = new com.tencent.tinker.b.a.a.a.b(this.c, this.a, this.b, this.d);
            this.m = new com.tencent.tinker.b.a.a.a.c(this.c, this.a, this.b, this.d);
            this.n = new e(this.c, this.a, this.b, this.d);
            this.o = new com.tencent.tinker.b.a.a.a.g(this.c, this.a, this.b, this.d);
            this.p = new com.tencent.tinker.b.a.a.a.h(this.c, this.a, this.b, this.d);
            this.q = new com.tencent.tinker.b.a.a.a.a(this.c, this.a, this.b, this.d);
            this.r = new m(this.c, this.a, this.b, this.d);
            this.s = new com.tencent.tinker.b.a.a.a.d(this.c, this.a, this.b, this.d);
            this.e.a();
            this.f.a();
            this.k.a();
            this.g.a();
            this.h.a();
            this.i.a();
            this.q.a();
            this.m.a();
            this.l.a();
            this.s.a();
            this.p.a();
            this.o.a();
            this.n.a();
            this.r.a();
            this.j.a();
            q a2 = this.b.a(aiVar.a.d);
            a2.a(("dex\n" + "035" + "\u0000").getBytes("UTF-8"));
            a2.d(aiVar.t);
            a2.a(aiVar.u);
            a2.d(aiVar.v);
            a2.d(SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED);
            a2.d(305419896);
            a2.d(aiVar.w);
            a2.d(aiVar.x);
            a2.d(aiVar.h.d);
            a2.d(aiVar.b.c);
            a2.d(aiVar.b.a() ? aiVar.b.d : 0);
            a2.d(aiVar.c.c);
            if (aiVar.c.a()) {
                i2 = aiVar.c.d;
            } else {
                i2 = 0;
            }
            a2.d(i2);
            a2.d(aiVar.d.c);
            if (aiVar.d.a()) {
                i2 = aiVar.d.d;
            } else {
                i2 = 0;
            }
            a2.d(i2);
            a2.d(aiVar.e.c);
            if (aiVar.e.a()) {
                i2 = aiVar.e.d;
            } else {
                i2 = 0;
            }
            a2.d(i2);
            a2.d(aiVar.f.c);
            if (aiVar.f.a()) {
                i2 = aiVar.f.d;
            } else {
                i2 = 0;
            }
            a2.d(i2);
            a2.d(aiVar.g.c);
            if (aiVar.g.a()) {
                i = aiVar.g.d;
            }
            a2.d(i);
            a2.d(aiVar.y);
            a2.d(aiVar.z);
            aiVar.b(this.b.a(aiVar.h.d));
            u uVar = this.b;
            uVar.a(12).a(uVar.a(true));
            uVar.a(8).d(uVar.a());
            outputStream.write(this.b.c.array());
            outputStream.flush();
        }
    }
}
