package com.taobao.weex.ui;

import com.taobao.weex.c.p;

/* compiled from: ProGuard */
final class l implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ p b;
    final /* synthetic */ m c;

    l(m mVar, String str, p pVar) {
        this.c = mVar;
        this.a = str;
        this.b = pVar;
    }

    public final void run() {
        if (this.c.a.get(this.a) != null) {
            this.b.a(this.c.a(this.a));
        }
    }
}
