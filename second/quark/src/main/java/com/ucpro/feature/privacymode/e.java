package com.ucpro.feature.privacymode;

import com.ucpro.base.system.b;
import com.ucweb.common.util.f.a;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class e implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ r b;

    e(r rVar, String str) {
        this.b = rVar;
        this.a = str;
    }

    public final void run() {
        try {
            a.a(this.a, com.ucpro.feature.privacymode.a.a.b());
            b.a.d(this.a);
            m.a(2, new a(this));
        } catch (Throwable th) {
        }
    }
}
