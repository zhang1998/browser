package com.ucpro.business.a.b.a;

import com.ucweb.common.util.k.a;
import java.io.File;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ c a;

    b(c cVar) {
        this.a = cVar;
    }

    public final void run() {
        try {
            a.i(new File(this.a.a()));
        } catch (Throwable th) {
        }
    }
}
