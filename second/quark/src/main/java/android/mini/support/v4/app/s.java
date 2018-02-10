package android.mini.support.v4.app;

import android.mini.support.annotation.Nullable;

/* compiled from: ProGuard */
public final class s {
    final t<?> a;

    s(t<?> tVar) {
        this.a = tVar;
    }

    @Nullable
    final Fragment a(String str) {
        return this.a.f.a(str);
    }

    public final void a() {
        this.a.f.t = false;
    }

    public final boolean b() {
        return this.a.f.c();
    }

    public final void c() {
        t tVar = this.a;
        if (!tVar.k) {
            tVar.k = true;
            if (tVar.i != null) {
                tVar.i.b();
            } else if (!tVar.j) {
                tVar.i = tVar.b("(root)");
                if (!(tVar.i == null || tVar.i.e)) {
                    tVar.i.b();
                }
            }
            tVar.j = true;
        }
    }

    public final void a(boolean z) {
        t tVar = this.a;
        tVar.h = z;
        if (tVar.i != null && tVar.k) {
            tVar.k = false;
            if (z) {
                tVar.i.d();
            } else {
                tVar.i.c();
            }
        }
    }
}
