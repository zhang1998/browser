package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.a;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.d;

final class t implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ ai b = null;
    final /* synthetic */ a c;

    t(Context context, a aVar) {
        this.a = context;
        this.c = aVar;
    }

    public final void run() {
        try {
            d bVar = new b(this.a, ah.a(this.a, false, this.b), this.c.a, this.b);
            bVar.a().c = this.c.c;
            new ag(bVar).a();
        } catch (Throwable th) {
            ah.q.b(th);
            ah.a(this.a, th);
        }
    }
}
