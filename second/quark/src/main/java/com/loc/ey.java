package com.loc;

import android.content.Context;
import android.os.Looper;

/* compiled from: ProGuard */
final class ey implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ ep b;
    final /* synthetic */ boolean c;
    final /* synthetic */ fa d;

    ey(fa faVar, Context context, ep epVar, boolean z) {
        this.d = faVar;
        this.a = context;
        this.b = epVar;
        this.c = z;
    }

    public final void run() {
        try {
            synchronized (Looper.getMainLooper()) {
                w wVar = new w(this.a, true);
                Object obj = this.b;
                if (obj != null) {
                    try {
                        if (wVar.a == null) {
                            wVar.a = w.a(wVar.b, false);
                        }
                        String a = ep.a(obj.a());
                        if (wVar.a.a(a, ep.class, false).size() == 0) {
                            wVar.a.a(obj);
                        } else {
                            wVar.a.a(a, obj, false);
                        }
                    } catch (Throwable th) {
                        es.a(th, "SDKDB", "insert");
                    }
                }
            }
            if (this.c) {
                synchronized (Looper.getMainLooper()) {
                    x xVar = new x(this.a);
                    y yVar = new y();
                    yVar.c(true);
                    yVar.a(true);
                    yVar.b(true);
                    xVar.a(yVar);
                }
                ew.a(this.d.d);
            }
        } catch (Throwable th2) {
        }
    }
}
