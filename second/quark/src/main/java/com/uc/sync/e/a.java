package com.uc.sync.e;

import android.util.SparseArray;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public final class a {
    public SparseArray<g> a;
    SparseArray<h> b;
    private b c;

    private a() {
        this.a = new SparseArray();
        this.b = new SparseArray();
        this.c = new b();
    }

    public final com.uc.sync.c.b.a a(int i) {
        g gVar = (g) this.a.get(i);
        if (gVar != null) {
            return gVar.n;
        }
        return null;
    }

    public final void a(int i, com.uc.sync.c.b.a aVar) {
        c.a((Object) aVar);
        if (this.a.get(i) == null) {
            g gVar = new g(i, aVar);
            gVar.a(this.c);
            this.a.put(i, gVar);
        }
    }

    public final void a(int i, h hVar) {
        g gVar = (g) this.a.get(i);
        if (gVar == null) {
            com.uc.sync.c.a.h();
            if (com.uc.sync.c.a.j()) {
                com.uc.sync.d.a.a("查无此业务, 无法开始同步");
                return;
            }
            return;
        }
        this.b.put(i, hVar);
        if (gVar.c()) {
            com.uc.sync.d.a.a("该业务当前有同步任务");
            return;
        }
        com.uc.sync.c.a.h().a("sync", "start", "id", String.valueOf(i));
        gVar.c(1);
    }
}
