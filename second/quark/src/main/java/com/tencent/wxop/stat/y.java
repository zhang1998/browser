package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.d;
import com.tencent.wxop.stat.b.h;

final class y implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ ai c;

    y(Context context, String str, ai aiVar) {
        this.a = context;
        this.b = str;
        this.c = aiVar;
    }

    public final void run() {
        try {
            Long l;
            ah.e(this.a);
            synchronized (ah.o) {
                l = (Long) ah.o.remove(this.b);
            }
            if (l != null) {
                Long valueOf = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
                if (valueOf.longValue() <= 0) {
                    valueOf = Long.valueOf(1);
                }
                String i = ah.n;
                if (i != null && i.equals(this.b)) {
                    i = "-";
                }
                d hVar = new h(this.a, i, this.b, ah.a(this.a, false, this.c), valueOf, this.c);
                if (!this.b.equals(ah.m)) {
                    ah.q.b((Object) "Invalid invocation since previous onResume on diff page.");
                }
                new ag(hVar).a();
                ah.n = this.b;
                return;
            }
            ah.q.e("Starttime for PageID:" + this.b + " not found, lost onResume()?");
        } catch (Throwable th) {
            ah.q.b(th);
            ah.a(this.a, th);
        }
    }
}
