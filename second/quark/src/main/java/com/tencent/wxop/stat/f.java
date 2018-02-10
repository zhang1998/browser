package com.tencent.wxop.stat;

import com.tencent.wxop.stat.a.n;
import java.util.TimerTask;

final class f extends TimerTask {
    final /* synthetic */ g a;

    f(g gVar) {
        this.a = gVar;
    }

    public final void run() {
        if (i.b()) {
            n.c().a((Object) "TimerTask run");
        }
        ah.f(this.a.c);
        cancel();
        this.a.a();
    }
}
