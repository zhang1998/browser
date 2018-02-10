package com.tencent.wxop.stat;

import android.content.Context;

final class u implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Context b;
    final /* synthetic */ ai c;

    u(String str, Context context, ai aiVar) {
        this.a = str;
        this.b = context;
        this.c = aiVar;
    }

    public final void run() {
        try {
            synchronized (ah.o) {
                if (ah.o.size() >= i.m()) {
                    ah.q.d("The number of page events exceeds the maximum value " + Integer.toString(i.m()));
                    return;
                }
                ah.m = this.a;
                if (ah.o.containsKey(ah.m)) {
                    ah.q.e("Duplicate PageID : " + ah.m + ", onResume() repeated?");
                    return;
                }
                ah.o.put(ah.m, Long.valueOf(System.currentTimeMillis()));
                ah.a(this.b, true, this.c);
            }
        } catch (Throwable th) {
            ah.q.b(th);
            ah.a(this.b, th);
        }
    }
}
