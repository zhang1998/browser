package com.ucpro.feature.webwindow.f;

import com.uc.base.b.c.b.c;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: ProGuard */
final class e implements Runnable {
    final /* synthetic */ byte[] a;
    final /* synthetic */ c b;

    e(c cVar, byte[] bArr) {
        this.b = cVar;
        this.a = bArr;
    }

    public final void run() {
        c nVar = new n();
        if (com.uc.a.d.e.a(this.a, nVar)) {
            Object obj = nVar.a;
            if (obj != null && !obj.isEmpty()) {
                c.a(this.b);
                Collections.sort(obj, new k(this));
                Iterator it = obj.iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    if (bVar != null) {
                        c.a(this.b, bVar);
                    }
                }
            }
        }
    }
}
