package com.uc.weex.a;

import android.os.SystemClock;
import java.util.List;

/* compiled from: ProGuard */
final class i implements Runnable {
    final /* synthetic */ l a;
    final /* synthetic */ n b;
    final /* synthetic */ String c;
    final /* synthetic */ j d;

    i(j jVar, l lVar, n nVar, String str) {
        this.d = jVar;
        this.a = lVar;
        this.b = nVar;
        this.c = str;
    }

    public final void run() {
        List<e> list = (List) this.d.a.get(this.a);
        if (!(list == null || list.isEmpty())) {
            for (e eVar : list) {
                if (eVar != null) {
                    eVar.a(this.b, this.c, ab.c);
                }
            }
        }
        this.d.a.remove(this.a);
        this.d.b.put(this.a, Long.valueOf(SystemClock.uptimeMillis()));
        if (this.d.c != null) {
            aa aaVar = new aa(this.a.k, this.a.b, this.a.h);
        }
    }
}
