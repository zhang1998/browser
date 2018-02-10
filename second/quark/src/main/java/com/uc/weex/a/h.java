package com.uc.weex.a;

import com.taobao.weex.a.i;
import com.taobao.weex.common.r;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class h implements Runnable {
    final /* synthetic */ l a;
    final /* synthetic */ e b;
    final /* synthetic */ j c;

    h(j jVar, l lVar, e eVar) {
        this.c = jVar;
        this.a = lVar;
        this.b = eVar;
    }

    public final void run() {
        k kVar = this.c;
        i iVar = this.a;
        e eVar = this.b;
        List list = (List) kVar.a.get(iVar);
        if (list == null) {
            list = new ArrayList();
            list.add(eVar);
            kVar.a.put(iVar, list);
            iVar.l = kVar;
            r rVar = new r();
            rVar.b = iVar.b;
            rVar.e = iVar.j;
            rVar.a = iVar.i;
            iVar.a = rVar.b;
            ag.e.a(rVar, iVar);
            return;
        }
        list.add(eVar);
    }
}
