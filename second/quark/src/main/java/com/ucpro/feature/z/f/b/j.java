package com.ucpro.feature.z.f.b;

import java.util.ArrayList;

/* compiled from: ProGuard */
final class j implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ ArrayList b;
    final /* synthetic */ k c;

    j(k kVar, String str, ArrayList arrayList) {
        this.c = kVar;
        this.a = str;
        this.b = arrayList;
    }

    public final void run() {
        this.c.b(this.a, this.b);
    }
}
