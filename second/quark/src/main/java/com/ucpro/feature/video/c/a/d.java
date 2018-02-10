package com.ucpro.feature.video.c.a;

import com.ucpro.feature.video.c.a;
import java.util.ArrayList;

/* compiled from: ProGuard */
final class d implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ String b;
    final /* synthetic */ ArrayList c;

    d(a aVar, String str, ArrayList arrayList) {
        this.a = aVar;
        this.b = str;
        this.c = arrayList;
    }

    public final void run() {
        this.a.a(this.b, this.c);
    }
}
