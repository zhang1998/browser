package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.n;

final class z implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ ai b = null;

    z(Context context) {
        this.a = context;
    }

    public final void run() {
        if (this.a == null) {
            ah.q.d("The Context of StatService.onResume() can not be null!");
        } else {
            ah.a(this.a, n.h(this.a), this.b);
        }
    }
}
