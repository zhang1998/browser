package com.taobao.weex.bridge;

/* compiled from: ProGuard */
final class f implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ Object b;
    final /* synthetic */ Object[] c;
    final /* synthetic */ g d;

    f(g gVar, a aVar, Object obj, Object[] objArr) {
        this.d = gVar;
        this.a = aVar;
        this.b = obj;
        this.c = objArr;
    }

    public final void run() {
        try {
            this.a.a(this.b, this.c);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
