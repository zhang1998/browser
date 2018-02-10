package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.n;

final class q implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ ai b = null;

    q(Context context) {
        this.a = context;
    }

    public final void run() {
        if (this.a == null) {
            ah.q.d("The Context of StatService.onPause() can not be null!");
        } else {
            ah.b(this.a, n.h(this.a), this.b);
        }
    }
}
