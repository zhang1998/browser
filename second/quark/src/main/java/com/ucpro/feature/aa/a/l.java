package com.ucpro.feature.aa.a;

import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.feature.webwindow.aj;

/* compiled from: ProGuard */
final class l implements Runnable {
    final /* synthetic */ a a;

    l(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        Object ajVar = new aj();
        ajVar.o = "http://bbs.myquark.cn/";
        g.a().a(e.k, ajVar);
    }
}
