package com.uc.quark;

import android.text.TextUtils;
import com.uc.quark.a.e;
import com.uc.quark.filedownloader.aa;
import com.uc.quark.filedownloader.ak;
import com.uc.quark.filedownloader.at;
import com.uc.quark.filedownloader.t;
import java.util.ConcurrentModificationException;
import java.util.List;

/* compiled from: ProGuard */
final class b extends t {
    final /* synthetic */ k a;

    b(k kVar) {
        this.a = kVar;
    }

    protected final void a(aa aaVar, long j, long j2) {
        k.a(this.a, aaVar, 1, j, j2, 0);
        if (!k.a(aaVar)) {
            i.a.a(1, aaVar);
        }
    }

    protected final synchronized void b(aa aaVar, long j, long j2) {
        if (aaVar.w() == null) {
            List g;
            if (aaVar.v()) {
                g = x.a().g();
            } else {
                g = x.a().e();
            }
            try {
                for (Object obj : r0) {
                    if (obj.a() == aaVar.e()) {
                        obj.a(aaVar.v());
                        aaVar.a(obj);
                        at b = ak.a.b(obj.a());
                        if (b != null) {
                            b.a(obj);
                        }
                        k.a(this.a, aaVar, 3, j, j2, 1);
                    }
                }
            } catch (ConcurrentModificationException e) {
            }
        } else {
            k.a(this.a, aaVar, 3, j, j2, 1);
            if (!k.a(aaVar)) {
                i.a.a(3, aaVar);
            }
        }
    }

    protected final void a(aa aaVar) {
        k.a(this.a, aaVar, -3, aaVar.o(), aaVar.q(), 1);
        if (!k.a(aaVar)) {
            i.a.a(-3, aaVar);
            if ((aaVar.w() instanceof s) && TextUtils.equals(e.b(((s) aaVar.w()).i()), "apk") && this.a.e != null) {
                this.a.e.a((s) aaVar.w());
            }
        }
    }

    protected final void c(aa aaVar, long j, long j2) {
        if (!k.a(aaVar)) {
            i.a.a(-2, aaVar);
        }
        if (j2 > 0 || j > 0) {
            k.a(this.a, aaVar, -2, j, j2, 1);
        }
    }

    protected final void a(aa aaVar, Throwable th) {
        k.a(this.a, aaVar, -1, aaVar.o(), aaVar.q(), 1);
        if (!k.a(aaVar)) {
            i.a.a(-1, aaVar);
            if (this.a.e != null) {
                this.a.e.a(th);
            }
        }
    }

    protected final void b(aa aaVar) {
        k.a(this.a, aaVar, -4, aaVar.o(), aaVar.q(), 1);
        if (!k.a(aaVar)) {
            i.a.a(-4, aaVar);
        }
    }

    protected final void a(aa aaVar, int i) {
        k.a(this.a, aaVar, 7, aaVar.o(), aaVar.q(), i);
    }

    protected final void c(aa aaVar) {
        k.a(this.a, aaVar, -5, aaVar.o(), aaVar.q(), 1);
        if (!k.a(aaVar)) {
            i.a.a(-5, aaVar);
        }
    }

    protected final void d(aa aaVar) {
        k.a(this.a, aaVar, 6, aaVar.o(), aaVar.q(), 1);
    }
}
