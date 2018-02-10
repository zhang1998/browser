package com.taobao.weex.utils.a;

import java.util.Iterator;

/* compiled from: ProGuard */
public final class b implements Runnable {
    final /* synthetic */ c a;

    public b(c cVar) {
        this.a = cVar;
    }

    public final void run() {
        Iterator it = this.a.b.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
            it.remove();
        }
    }
}
