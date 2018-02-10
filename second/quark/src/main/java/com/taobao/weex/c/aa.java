package com.taobao.weex.c;

/* compiled from: ProGuard */
public final class aa implements Runnable {
    final /* synthetic */ m a;
    final /* synthetic */ ab b;

    public aa(ab abVar, m mVar) {
        this.b = abVar;
        this.a = mVar;
    }

    public final void run() {
        m mVar = this.a;
        mVar.i = true;
        mVar.a.clear();
        mVar.b = null;
        mVar.e.clear();
        mVar.j.clear();
        mVar.g = null;
        mVar.d = null;
        mVar.f.clear();
    }
}
