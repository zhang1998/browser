package com.ucpro.a.c;

import com.ucweb.common.util.i.a;

/* compiled from: ProGuard */
final class c implements com.ucpro.a.c {
    final /* synthetic */ j a;

    private c(j jVar) {
        this.a = jVar;
    }

    public final void a(a aVar) {
        int i;
        new StringBuilder("network_changedonNetwoekChanged, current NetType : ").append(aVar.toString());
        boolean c = j.c(p.b("enable_smart_no_image"));
        new StringBuilder("network_changedhandleSmartNoImage, shouldSetNoImage: ").append(String.valueOf(c));
        if (c) {
            i = t.a;
        } else {
            i = t.c;
        }
        j.b(i);
        j.a(j.d(p.b("enable_smart_pre_read")));
    }
}
