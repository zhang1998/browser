package com.bumptech.glide.b.d.e;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: ProGuard */
final class l implements Callback {
    final /* synthetic */ n a;

    l(n nVar) {
        this.a = nVar;
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            j jVar = (j) message.obj;
            n nVar = this.a;
            if (nVar.h) {
                nVar.b.obtainMessage(2, jVar).sendToTarget();
            } else {
                if (jVar.b != null) {
                    nVar.d();
                    j jVar2 = nVar.g;
                    nVar.g = jVar;
                    for (int size = nVar.c.size() - 1; size >= 0; size--) {
                        ((k) nVar.c.get(size)).c();
                    }
                    if (jVar2 != null) {
                        nVar.b.obtainMessage(2, jVar2).sendToTarget();
                    }
                }
                nVar.f = false;
                nVar.c();
            }
            return true;
        }
        if (message.what == 2) {
            this.a.d.a((j) message.obj);
        }
        return false;
    }
}
