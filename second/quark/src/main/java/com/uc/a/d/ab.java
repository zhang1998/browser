package com.uc.a.d;

import com.uc.a.b.h;
import com.uc.base.b.b.a;

/* compiled from: ProGuard */
final class ab implements Runnable {
    final /* synthetic */ h a;
    final /* synthetic */ r b;

    ab(r rVar, h hVar) {
        this.b = rVar;
        this.a = hVar;
    }

    public final void run() {
        try {
            if (this.a != null) {
                w.a("handleBusinessData, parse usdata ok...");
                this.b.e.a(this.a);
                this.b.e.a(this.b.c, this.a);
                this.b.e.b(this.a);
                this.b.e.b(this.b.d, this.a);
            } else {
                w.a("handleBusinessData, parse usdata failed...");
            }
            w.a("handleBusinessData finish...\n\n");
            h.b(new n(this));
        } catch (Throwable th) {
            a.a(th);
            this.b.e.a(this.b.c, this.b.d, -1, "handle data error");
            w.a("handleBusinessData occured exception:" + th.getMessage());
        }
        w.a();
    }
}
