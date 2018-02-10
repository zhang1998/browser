package com.tencent.wxop.stat;

import java.util.List;

final class ao implements k {
    final /* synthetic */ List a;
    final /* synthetic */ boolean b;
    final /* synthetic */ as c;

    ao(as asVar, List list, boolean z) {
        this.c = asVar;
        this.a = list;
        this.b = z;
    }

    public final void a() {
        ah.b();
        as asVar = this.c;
        List list = this.a;
        boolean z = this.b;
        if (asVar.a != null) {
            asVar.a.a(new ak(asVar, list, z));
        }
    }

    public final void b() {
        ah.c();
        as asVar = this.c;
        List list = this.a;
        boolean z = this.b;
        if (asVar.a != null) {
            asVar.a.a(new aj(asVar, list, z));
        }
    }
}
