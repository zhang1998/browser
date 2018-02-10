package com.tencent.wxop.stat;

import android.content.Context;

final class aa implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ ai b = null;

    aa(Context context) {
        this.a = context;
    }

    public final void run() {
        try {
            ah.a(this.a, false, this.b);
        } catch (Throwable th) {
            ah.q.b(th);
        }
    }
}
