package com.ucpro.feature.navigation.view;

import com.ucweb.common.util.a.a;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
public final class b implements Runnable {
    public int a;
    final /* synthetic */ ai b;

    public b(ai aiVar) {
        this.b = aiVar;
    }

    public final void run() {
        int a = (int) a.a(d.a(), 5.0f);
        if (this.a == ai.a) {
            ai.a(this.b, -a);
        } else {
            ai.a(this.b, a);
        }
        this.b.e.postDelayed(this.b.c, 16);
    }
}
