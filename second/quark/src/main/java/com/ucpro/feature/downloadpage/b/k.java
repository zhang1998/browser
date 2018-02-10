package com.ucpro.feature.downloadpage.b;

import com.ucweb.common.util.k.a;
import com.ucweb.common.util.k.c;
import java.io.File;

/* compiled from: ProGuard */
final class k implements Runnable {
    final /* synthetic */ n a;
    final /* synthetic */ n b;

    k(n nVar, n nVar2) {
        this.b = nVar;
        this.a = nVar2;
    }

    public final void run() {
        c i = a.i(new File(this.a.c).getPath());
        this.b.f = i.b;
        this.b.g = i.a;
    }
}
