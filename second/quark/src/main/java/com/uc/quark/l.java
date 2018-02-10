package com.uc.quark;

import java.util.Iterator;

/* compiled from: ProGuard */
final class l implements Runnable {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public final void run() {
        Iterator it = this.a.c.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            if (this.a.d.contains(hVar)) {
                it.remove();
                this.a.d.remove(hVar);
            }
        }
    }
}
