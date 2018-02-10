package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.c;
import com.tencent.wxop.stat.b.f;

final class r implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ Throwable b;

    r(Context context, Throwable th) {
        this.a = context;
        this.b = th;
    }

    public final void run() {
        try {
            if (i.c()) {
                new ag(new c(this.a, ah.a(this.a, false, null), this.b, f.a)).a();
            }
        } catch (Throwable th) {
            ah.q.e("reportSdkSelfException error: " + th);
        }
    }
}
