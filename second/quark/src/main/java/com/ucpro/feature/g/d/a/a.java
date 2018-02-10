package com.ucpro.feature.g.d.a;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.raizlabs.android.dbflow.a.b.u;
import com.raizlabs.android.dbflow.a.b.z;
import com.uc.apollo.impl.SettingsConst;
import com.uc.base.b.c.b.c;
import com.uc.sync.f.l;
import com.ucpro.feature.bookmarkhis.bookmark.a.ac;
import com.ucpro.feature.bookmarkhis.bookmark.a.ah;
import com.ucpro.feature.bookmarkhis.bookmark.a.f;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucpro.feature.bookmarkhis.bookmark.a.q;
import com.ucpro.feature.bookmarkhis.bookmark.a.s;
import com.ucpro.feature.bookmarkhis.bookmark.a.x;
import com.ucpro.feature.bookmarkhis.bookmark.a.y;
import com.ucpro.feature.g.d.b.b;
import hugo.weaving.DebugLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProGuard */
public final class a implements com.uc.sync.c.b.a<x, b, com.ucpro.feature.g.d.b.a> {
    private s a = s.a();

    @DebugLog
    public final /* synthetic */ c a(c cVar, l lVar) {
        com.ucpro.feature.g.d.b.a aVar = (com.ucpro.feature.g.d.b.a) cVar;
        com.ucweb.common.util.c.b(lVar instanceof x);
        if (lVar.e()) {
            aVar.a = 1;
        }
        if (lVar.f()) {
            aVar.d = 1;
        }
        if (lVar.g()) {
            aVar.e = 1;
        }
        x xVar = (x) lVar;
        Log.w("chris", "isIconDataModify: " + xVar.h() + " for " + xVar.n);
        if (xVar.h()) {
            aVar.c = 1;
        }
        return aVar;
    }

    @DebugLog
    public final /* synthetic */ c a(l lVar) {
        byte[] bytes;
        x xVar = (x) lVar;
        c bVar = new b();
        bVar.f = com.uc.sync.a.a.a(xVar.n);
        bVar.a = com.uc.sync.a.a.a(xVar.o);
        bVar.b = com.uc.sync.a.a.a(xVar.m);
        bVar.c = xVar.p;
        bVar.d = com.uc.sync.a.a.a(xVar.l);
        bVar.e = com.uc.sync.a.a.a(xVar.k);
        bVar.g = xVar.r;
        bVar.h = xVar.q;
        String a = ah.a(xVar.u).a();
        if (a != null) {
            bytes = a.getBytes();
        } else {
            bytes = null;
        }
        bVar.i = bytes;
        new StringBuilder("icon data: ").append(bVar.i).append(" for title: ").append(bVar.f);
        return bVar;
    }

    @DebugLog
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

    @DebugLog
    public final /* bridge */ /* synthetic */ void b(l lVar, l lVar2) {
        ((x) lVar).r = ((x) lVar2).r;
    }

    @DebugLog
    public final /* synthetic */ long c(l lVar) {
        x xVar = (x) lVar;
        com.ucweb.common.util.c.a((Object) xVar);
        if (xVar == null) {
            return -1;
        }
        return this.a.c.b(m.a(xVar));
    }

    @DebugLog
    public final /* synthetic */ void c(l lVar, l lVar2) {
        q.a((x) lVar, (x) lVar2);
    }

    @DebugLog
    public final /* synthetic */ void d(l lVar) {
        x xVar = (x) lVar;
        boolean a = this.a.a(m.a(xVar), null);
        new StringBuilder("updateSyncItem: ").append(a).append(" item: ").append(xVar);
        com.ucweb.common.util.c.b(a);
    }

    @DebugLog
    public final /* synthetic */ boolean d(l lVar, l lVar2) {
        return q.b((x) lVar, (x) lVar2);
    }

    public final Handler a() {
        return new Handler(com.ucweb.common.util.h.m.a());
    }

    @DebugLog
    public final ArrayList<x> a(int i, int i2) {
        this.a.b();
        if (i < 0) {
            i = 0;
        }
        if (i2 <= 0 || i2 > SettingsConst.GLOBAL_SETTINGS) {
            i2 = SettingsConst.GLOBAL_SETTINGS;
        }
        u a = z.a(new com.raizlabs.android.dbflow.a.b.a.b[0]).a(m.class).a(y.f.c(Long.valueOf((long) i)), y.u.a(Integer.valueOf(0))).a(y.f);
        a.d = i2;
        List<m> c = a.c();
        ArrayList<x> arrayList = new ArrayList();
        for (m k : c) {
            arrayList.add(k.k());
        }
        return arrayList;
    }

    @DebugLog
    public final ArrayList<l> a(ArrayList<l> arrayList) {
        f b = this.a.b();
        ArrayList<l> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            x xVar = (x) ((l) it.next());
            m a = f.a(xVar.b());
            if (a != null) {
                a.c = xVar.e;
                a.q = 2;
                a.e = xVar.n;
                com.ucweb.common.util.c.b(b.a.c(a));
            } else {
                arrayList2.add(xVar);
            }
        }
        return arrayList2;
    }

    @DebugLog
    public final void b() {
        this.a.b();
        f.a();
    }

    @DebugLog
    public final void c() {
        this.a.b();
        f.b();
    }

    @DebugLog
    public final int g() {
        this.a.b();
        return f.c();
    }

    @DebugLog
    public final void a(int i) {
        this.a.b();
        f.a(i);
    }

    @DebugLog
    public final void b(ArrayList<Long> arrayList) {
        com.ucweb.common.util.c.a((Object) arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Long l = (Long) it.next();
            new StringBuilder("delete bookmark which id is ").append(l).append(" and result: ").append(s.b(l.longValue()));
        }
    }

    @DebugLog
    public final /* synthetic */ l b(String str) {
        m a = s.a(str);
        return a != null ? a.k() : null;
    }

    @DebugLog
    public final /* synthetic */ l a(long j) {
        m a = s.a(j);
        return a != null ? a.k() : null;
    }

    @DebugLog
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
