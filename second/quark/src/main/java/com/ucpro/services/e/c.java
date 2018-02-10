package com.ucpro.services.e;

import android.content.Context;
import com.ucweb.common.util.d;
import com.ucweb.common.util.j.a;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ f a;

    c(f fVar) {
        this.a = fVar;
    }

    public final void run() {
        f fVar = this.a;
        if (!fVar.d) {
            boolean b = a.b(d.a(), "29076939917A5F78", "89DA0C8B436AFF56", true);
            f.a = b;
            if (b && fVar.c == null && fVar.b != null) {
                fVar.c = new a(fVar, (Context) fVar.b.get());
            }
        }
    }
}
