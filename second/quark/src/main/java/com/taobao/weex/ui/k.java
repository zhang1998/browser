package com.taobao.weex.ui;

/* compiled from: ProGuard */
public final class k implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ c b;
    final /* synthetic */ m c;

    public k(m mVar, String str, c cVar) {
        this.c = mVar;
        this.a = str;
        this.b = cVar;
    }

    public final void run() {
        if (this.c.a.get(this.a) != null) {
            this.b.a();
        }
    }
}
