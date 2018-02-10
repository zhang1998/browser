package com.uc.translate;

import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class h implements Runnable {
    final /* synthetic */ k a;
    final /* synthetic */ m b;
    final /* synthetic */ String c;
    final /* synthetic */ m d;
    final /* synthetic */ q e;

    h(k kVar, m mVar, String str, m mVar2, q qVar) {
        this.a = kVar;
        this.b = mVar;
        this.c = str;
        this.d = mVar2;
        this.e = qVar;
    }

    public final void run() {
        TranslateResponse[] translateResponseArr = new TranslateResponse[1];
        d dVar = new d("http://gw.api.taobao.com/router/rest", i.a.a(), i.a.b(), i.b);
        e oVar = new o();
        oVar.a = "offer";
        oVar.b = this.a.c;
        oVar.c = this.b.c;
        oVar.d = this.c;
        oVar.e = this.d.c;
        try {
            translateResponseArr[0] = dVar.a(oVar);
        } catch (a e) {
        }
        m.a(2, new g(this, translateResponseArr));
    }
}
