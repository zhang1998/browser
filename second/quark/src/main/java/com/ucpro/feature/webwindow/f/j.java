package com.ucpro.feature.webwindow.f;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: ProGuard */
final class j implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ String b;
    final /* synthetic */ ConcurrentHashMap c;
    final /* synthetic */ h d;
    final /* synthetic */ c e;

    j(c cVar, ArrayList arrayList, String str, ConcurrentHashMap concurrentHashMap, h hVar) {
        this.e = cVar;
        this.a = arrayList;
        this.b = str;
        this.c = concurrentHashMap;
        this.d = hVar;
    }

    public final void run() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            synchronized (c.c(this.b)) {
                CharSequence charSequence;
                if (aVar.a == null) {
                    charSequence = null;
                } else {
                    charSequence = aVar.a.toString();
                }
                if (TextUtils.isEmpty(charSequence)) {
                    return;
                } else if (this.c.containsKey(charSequence)) {
                    ((CopyOnWriteArrayList) this.c.get(charSequence)).add(this.d);
                } else {
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(new ArrayList());
                    copyOnWriteArrayList.add(this.d);
                    this.c.putIfAbsent(charSequence, copyOnWriteArrayList);
                }
            }
        }
    }
}
