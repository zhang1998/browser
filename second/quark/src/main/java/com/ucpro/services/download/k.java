package com.ucpro.services.download;

import com.uc.quark.filedownloader.a.b;
import com.uc.quark.filedownloader.a.d;
import com.uc.quark.j;
import com.uc.quark.s;
import com.ucpro.services.download.a.a;
import com.ucpro.ui.b.e;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class k implements j {
    k() {
    }

    public final void a(Throwable th) {
        if (th instanceof d) {
            e.a().a(a.a(((d) th).a), 1);
        } else if (th instanceof com.uc.quark.filedownloader.a.a) {
            e.a().a(a.a("outofspace"), 1);
        } else if (th instanceof b) {
            e.a().a(a.a("peimission_denied"), 1);
        }
    }

    public final void a(s sVar) {
        m.a(0, new g(sVar), 500);
    }
}
