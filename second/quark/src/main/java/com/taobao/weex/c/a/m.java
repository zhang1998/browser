package com.taobao.weex.c.a;

import com.taobao.weex.c.d;
import com.taobao.weex.c.e;
import com.taobao.weex.c.p;
import com.taobao.weex.c.q;

/* compiled from: ProGuard */
final class m implements d, p {
    private Runnable a;

    m(Runnable runnable) {
        this.a = runnable;
    }

    public final void a(e eVar) {
        eVar.a((p) this);
    }

    public final void a(q qVar) {
        if (this.a != null) {
            this.a.run();
        }
    }
}
