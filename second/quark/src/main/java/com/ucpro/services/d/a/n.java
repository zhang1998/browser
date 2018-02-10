package com.ucpro.services.d.a;

import java.util.List;

/* compiled from: ProGuard */
final class n implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ u b;

    n(u uVar, List list) {
        this.b = uVar;
        this.a = list;
    }

    public final void run() {
        s.a().a(this.b.a, this.b);
        s a = s.a();
        List list = this.a;
        if (s.a) {
            new StringBuilder("==getResFromLocal, resCodeList: ").append(list.toString());
        }
        a.b.a(list);
    }
}
