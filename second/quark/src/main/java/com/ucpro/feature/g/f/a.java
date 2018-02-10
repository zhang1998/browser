package com.ucpro.feature.g.f;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.uc.base.b.c.b.c;
import com.uc.sync.f.l;
import com.ucpro.feature.bookmarkhis.bookmark.a.ac;
import com.ucpro.feature.bookmarkhis.bookmark.a.f;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucpro.feature.bookmarkhis.bookmark.a.q;
import com.ucpro.feature.bookmarkhis.bookmark.a.s;
import com.ucpro.feature.bookmarkhis.bookmark.a.x;
import com.ucpro.feature.g.d.b.b;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class a implements com.uc.sync.c.b.a<x, b, com.ucpro.feature.g.d.b.a> {
    private s a = s.a();

    public final /* synthetic */ c a(c cVar, l lVar) {
        com.ucpro.feature.g.d.b.a aVar = (com.ucpro.feature.g.d.b.a) cVar;
        if (lVar.e()) {
            aVar.a = 1;
        }
        if (lVar.f()) {
            aVar.d = 1;
        }
        if (lVar.g()) {
            aVar.e = 1;
        }
        return aVar;
    }

    public final /* synthetic */ c a(l lVar) {
        x xVar = (x) lVar;
        c bVar = new b();
        bVar.a = com.uc.sync.a.a.a(xVar.o);
        bVar.f = com.uc.sync.a.a.a(xVar.n);
        bVar.b = com.uc.sync.a.a.a(xVar.m);
        bVar.c = xVar.p;
        bVar.d = com.uc.sync.a.a.a(xVar.l);
        bVar.e = com.uc.sync.a.a.a(xVar.k);
        bVar.g = xVar.r;
        bVar.h = xVar.q;
        return bVar;
    }

    public final /* synthetic */ void b(l lVar) {
        x xVar = (x) lVar;
        String str = xVar.m;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() < ac.a.length()) {
                Log.w("BookmarkSync", "path length is too short, must be illegal path");
                return;
            }
            String[] split = str.substring(ac.a.length()).split(ac.a);
            m mVar = null;
            if (split != null) {
                mVar = s.a().c(split[0]);
            }
            if (mVar != null) {
                xVar.s = mVar.b;
            }
        }
    }

    public final /* bridge */ /* synthetic */ void b(l lVar, l lVar2) {
        ((x) lVar).r = ((x) lVar2).r;
    }

    public final /* synthetic */ long c(l lVar) {
        x xVar = (x) lVar;
        xVar.c(0);
        xVar.b = 0;
        if (xVar == null) {
            return -1;
        }
        return this.a.a(m.a(xVar));
    }

    public final /* synthetic */ void c(l lVar, l lVar2) {
        q.a((x) lVar, (x) lVar2);
    }

    public final /* synthetic */ void d(l lVar) {
        x xVar = (x) lVar;
        xVar.c(0);
        xVar.b = 0;
        boolean a = this.a.a(m.a(xVar), null);
        new StringBuilder("updateSyncItem: ").append(a).append(" item: ").append(xVar);
        com.ucweb.common.util.c.b(a);
    }

    public final /* synthetic */ boolean d(l lVar, l lVar2) {
        return q.b((x) lVar, (x) lVar2);
    }

    public final Handler a() {
        return new Handler(com.ucweb.common.util.h.m.a());
    }

    public final ArrayList<x> a(int i, int i2) {
        return new ArrayList();
    }

    public final ArrayList<l> a(ArrayList<l> arrayList) {
        this.a.b();
        ArrayList<l> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            x xVar = (x) ((l) it.next());
            if (f.a(xVar.b()) == null) {
                arrayList2.add(xVar);
            }
        }
        return arrayList2;
    }

    public final void b() {
        s.a().b();
        f.a();
    }

    public final void c() {
        s.a().b();
        f.b();
    }

    public final int g() {
        return -1;
    }

    public final void a(int i) {
        com.ucpro.c.b.b();
    }

    public final void b(ArrayList<Long> arrayList) {
    }

    public final /* synthetic */ l b(String str) {
        m a = s.a(str);
        return a != null ? a.k() : null;
    }

    public final /* synthetic */ l a(long j) {
        m a = s.a(j);
        return a != null ? a.k() : null;
    }

    public final /* synthetic */ l a(String str) {
        this.a.b();
        m a = f.a(str);
        return a != null ? a.k() : null;
    }

    public final /* synthetic */ c f() {
        return new com.ucpro.feature.g.d.b.a();
    }

    public final /* synthetic */ l e() {
        return new x();
    }

    public final /* synthetic */ c d() {
        return new b();
    }
}
