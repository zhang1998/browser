package com.tencent.wxop.stat;

import android.content.Context;

final class v implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ int b = -1;

    v(Context context) {
        this.a = context;
    }

    public final void run() {
        try {
            ah.e(this.a);
            as.a(this.a).a(this.b);
        } catch (Throwable th) {
            ah.q.b(th);
            ah.a(this.a, th);
        }
    }
}
