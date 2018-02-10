package com.tencent.tinker.c.a;

import com.tencent.tinker.c.a.a.b;
import java.nio.ByteBuffer;

/* compiled from: ProGuard */
public final class q extends b {
    final /* synthetic */ u a;
    private final String d;

    private q(u uVar, String str, ByteBuffer byteBuffer) {
        this.a = uVar;
        super(byteBuffer);
        this.d = str;
    }

    public final af b() {
        a(this.a.b.n, false);
        return super.b();
    }

    public final aj c() {
        a(this.a.b.i, false);
        return super.c();
    }

    public final aa d() {
        a(this.a.b.e, false);
        return super.d();
    }

    public final ac e() {
        a(this.a.b.f, false);
        return super.e();
    }

    public final ae f() {
        a(this.a.b.d, false);
        return super.f();
    }

    public final h g() {
        a(this.a.b.g, false);
        return super.g();
    }

    public final k h() {
        a(this.a.b.m, false);
        return super.h();
    }

    public final l i() {
        a(this.a.b.o, false);
        return super.i();
    }

    public final g j() {
        a(this.a.b.l, false);
        return super.j();
    }

    public final a k() {
        a(this.a.b.p, false);
        return super.k();
    }

    public final b l() {
        a(this.a.b.k, false);
        return super.l();
    }

    public final c m() {
        a(this.a.b.j, false);
        return super.m();
    }

    public final d n() {
        a(this.a.b.r, false);
        return super.n();
    }

    public final x o() {
        a(this.a.b.q, false);
        return super.o();
    }

    private void a(ah ahVar, boolean z) {
        if (!ahVar.b) {
            return;
        }
        if (z) {
            super.b((((this.b.position() + 3) & -4) - this.b.position()) * 1);
            while ((this.b.position() & 3) != 0) {
                this.b.put((byte) 0);
            }
            if (this.b.position() > this.c) {
                this.c = this.b.position();
                return;
            }
            return;
        }
        this.b.position((this.b.position() + 3) & -4);
    }

    public final int a(af afVar) {
        a(this.a.b.n, true);
        return super.a(afVar);
    }

    public final int a(aj ajVar) {
        a(this.a.b.i, true);
        return super.a(ajVar);
    }

    public final int a(aa aaVar) {
        a(this.a.b.e, true);
        return super.a(aaVar);
    }

    public final int a(ac acVar) {
        a(this.a.b.f, true);
        return super.a(acVar);
    }

    public final int a(ae aeVar) {
        a(this.a.b.d, true);
        return super.a(aeVar);
    }

    public final int a(h hVar) {
        a(this.a.b.g, true);
        return super.a(hVar);
    }

    public final int a(k kVar) {
        a(this.a.b.m, true);
        return super.a(kVar);
    }

    public final int a(l lVar) {
        a(this.a.b.o, true);
        return super.a(lVar);
    }

    public final int a(g gVar) {
        a(this.a.b.l, true);
        return super.a(gVar);
    }

    public final int a(a aVar) {
        a(this.a.b.p, true);
        return super.a(aVar);
    }

    public final int a(b bVar) {
        a(this.a.b.k, true);
        return super.a(bVar);
    }

    public final int a(c cVar) {
        a(this.a.b.j, true);
        return super.a(cVar);
    }

    public final int a(d dVar) {
        a(this.a.b.r, true);
        return super.a(dVar);
    }

    public final int a(x xVar) {
        a(this.a.b.q, true);
        return super.a(xVar);
    }
}
