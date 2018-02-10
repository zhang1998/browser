package com.taobao.weex;

import android.app.Application;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.ag;

/* compiled from: ProGuard */
final class n implements Runnable {
    final /* synthetic */ d a;
    final /* synthetic */ Application b;

    n(d dVar, Application application) {
        this.a = dVar;
        this.b = application;
    }

    public final void run() {
        String str = null;
        long currentTimeMillis = System.currentTimeMillis();
        ad a = ad.a();
        if (this.a != null) {
            d dVar = this.a;
            a.i = dVar.e;
            a.h = dVar.a;
            a.e = dVar.c;
            a.g = dVar.b;
            a.k = dVar.f;
            a.d = dVar.d;
            a.m = dVar.h;
            a.n = dVar.i;
            a.j = dVar.j;
            a.f = dVar.g;
        }
        ag.a(this.b, a.f, a.l);
        String b = m.b();
        if (b != null) {
            com.taobao.weex.a.n nVar;
            if (this.a != null) {
                nVar = this.a.d;
            } else {
                nVar = null;
            }
            ag.a(b, nVar);
        }
        if (this.a != null) {
            str = this.a.k;
        }
        a.b.b(str);
        i.t = System.currentTimeMillis() - currentTimeMillis;
        WXLogUtils.renderPerformanceLog("SDKInitExecuteTime", i.t);
    }
}
