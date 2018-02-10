package com.ucpro.feature.g.e;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.raizlabs.android.dbflow.a.b.a.b;
import com.raizlabs.android.dbflow.a.b.u;
import com.raizlabs.android.dbflow.a.b.x;
import com.raizlabs.android.dbflow.a.b.z;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.uc.base.b.c.b.c;
import com.uc.sync.c.b.a;
import com.uc.sync.f.l;
import com.ucpro.feature.g.e.a.d;
import hugo.weaving.DebugLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
public final class e implements a<f, a, d> {
    @DebugLog
    public final /* synthetic */ c a(c cVar, l lVar) {
        d dVar = (d) cVar;
        if (lVar.e()) {
            dVar.a = 1;
        }
        if (lVar.f()) {
            dVar.c = 1;
        }
        if (lVar.g()) {
            dVar.d = 1;
        }
        return dVar;
    }

    @DebugLog
    public final /* synthetic */ c a(l lVar) {
        f fVar = (f) lVar;
        c aVar = new a();
        aVar.d = com.uc.sync.a.a.a(fVar.m);
        aVar.a = com.uc.sync.a.a.a(fVar.n);
        aVar.e = fVar.o;
        aVar.b = com.uc.sync.a.a.a(fVar.l);
        aVar.c = com.uc.sync.a.a.a(fVar.k);
        aVar.f = fVar.p;
        return aVar;
    }

    @DebugLog
    public final /* synthetic */ l a(long j) {
        d.a;
        com.ucpro.feature.g.e.a.c cVar = (com.ucpro.feature.g.e.a.c) z.a(new b[0]).a(com.ucpro.feature.g.e.a.c.class).a(com.ucpro.feature.g.e.a.a.f.a(Long.valueOf(j))).d();
        if (cVar == null) {
            return null;
        }
        l fVar = new f();
        fVar.j = cVar.a;
        fVar.m = cVar.d;
        return fVar;
    }

    @DebugLog
    public final /* synthetic */ l a(l lVar, c cVar) {
        f fVar = (f) lVar;
        a aVar = (a) cVar;
        fVar.m = com.uc.sync.a.a.b(aVar.d);
        fVar.n = com.uc.sync.a.a.b(aVar.a);
        fVar.o = aVar.e;
        fVar.p = aVar.f;
        return fVar;
    }

    @DebugLog
    public final /* bridge */ /* synthetic */ void b(l lVar, l lVar2) {
        f fVar = (f) lVar;
        f fVar2 = (f) lVar2;
        fVar.m = fVar2.m;
        fVar.o = fVar2.o;
    }

    @DebugLog
    public final /* synthetic */ long c(l lVar) {
        return d.a.a((f) lVar);
    }

    @DebugLog
    public final /* synthetic */ void c(l lVar, l lVar2) {
        f fVar = (f) lVar;
        f fVar2 = (f) lVar2;
        byte[] c = fVar2.c();
        if (c != null) {
            d dVar = new d();
            if (dVar.a(c)) {
                if (dVar.a == 1) {
                    fVar.m = fVar2.m;
                }
                if (dVar.c == 1) {
                    fVar.o = fVar2.o;
                }
                if (dVar.d == 1) {
                    fVar.p = fVar2.p;
                }
            }
        }
    }

    @DebugLog
    public final /* synthetic */ void d(l lVar) {
        f fVar = (f) lVar;
        d.a;
        com.ucweb.common.util.c.b(com.ucpro.feature.g.e.a.c.a(fVar).b());
    }

    @DebugLog
    public final /* synthetic */ boolean d(l lVar, l lVar2) {
        f fVar = (f) lVar;
        f fVar2 = (f) lVar2;
        boolean equals = TextUtils.equals(fVar.b(), fVar2.b());
        boolean equals2 = TextUtils.equals(fVar.m, fVar2.m);
        boolean z;
        if (fVar.o == fVar2.o) {
            z = true;
        } else {
            z = false;
        }
        if (equals && equals2 && r2) {
            return false;
        }
        return true;
    }

    @DebugLog
    public final Handler a() {
        return new Handler(Looper.getMainLooper());
    }

    @DebugLog
    public final int g() {
        b.a();
        return -1;
    }

    @DebugLog
    public final void a(int i) {
        b.a();
        b.a(i);
    }

    @DebugLog
    public final ArrayList<l> a(ArrayList<l> arrayList) {
        ArrayList<l> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            f fVar = (f) ((l) it.next());
            d.a;
            arrayList2.add(fVar);
        }
        return arrayList2;
    }

    @DebugLog
    public final void b() {
        FlowManager.c(com.ucpro.feature.g.e.a.b.class).a().a();
    }

    @DebugLog
    public final void c() {
        FlowManager.c(com.ucpro.feature.g.e.a.b.class).a().c();
    }

    @DebugLog
    public final void b(ArrayList<Long> arrayList) {
        d.a;
        com.ucweb.common.util.c.a((Object) arrayList);
        new x().a(com.ucpro.feature.g.e.a.c.class).a(com.ucpro.feature.g.e.a.a.f.a((Collection) arrayList)).f().a();
    }

    @DebugLog
    public final ArrayList<f> a(int i, int i2) {
        d.a;
        long j = (long) i;
        u a = z.a(new b[0]).a(com.ucpro.feature.g.e.a.c.class).a(com.ucpro.feature.g.e.a.a.f.c(Long.valueOf(j))).a(com.ucpro.feature.g.e.a.a.t.a(Integer.valueOf(0)));
        a.d = i2;
        List<com.ucpro.feature.g.e.a.c> c = a.a(com.ucpro.feature.g.e.a.a.f).c();
        ArrayList<f> arrayList = new ArrayList();
        for (com.ucpro.feature.g.e.a.c a2 : c) {
            arrayList.add(f.a(a2));
        }
        return arrayList;
    }

    @DebugLog
    public final /* synthetic */ l b(String str) {
        d.a;
        return f.a((com.ucpro.feature.g.e.a.c) z.a(new b[0]).a(com.ucpro.feature.g.e.a.c.class).a(com.ucpro.feature.g.e.a.a.h.a((Object) str)).d());
    }

    @DebugLog
    public final /* synthetic */ c f() {
        return new d();
    }

    @DebugLog
    public final /* synthetic */ l e() {
        return new f();
    }

    @DebugLog
    public final /* synthetic */ c d() {
        return new a();
    }
}
