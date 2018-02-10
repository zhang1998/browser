package com.ucpro.feature.t;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
final class j implements Runnable {
    final /* synthetic */ h a;

    j(h hVar) {
        this.a = hVar;
    }

    public final void run() {
        this.a.d = false;
        h hVar = this.a;
        Iterator it = hVar.b.iterator();
        while (it.hasNext()) {
            g gVar = (g) ((WeakReference) it.next()).get();
            if (gVar != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(hVar.c);
                gVar.a(arrayList);
            }
        }
        hVar.c.clear();
    }
}
