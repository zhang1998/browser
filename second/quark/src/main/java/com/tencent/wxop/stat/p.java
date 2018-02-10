package com.tencent.wxop.stat;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.wxop.stat.a.n;

final class p implements Runnable {
    final /* synthetic */ Context a;

    p(Context context) {
        this.a = context;
    }

    public final void run() {
        d a = d.a(ah.t);
        a.f.getApplicationContext().registerReceiver(new c(a), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        n.a(this.a, true);
        as.a(this.a);
        n.b(this.a);
        ah.r = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new ab());
        if (i.a() == o.APP_LAUNCH) {
            ah.d(this.a);
        }
        if (i.b()) {
            ah.q.g("Init MTA StatService success.");
        }
    }
}
