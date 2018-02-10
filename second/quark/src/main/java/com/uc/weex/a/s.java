package com.uc.weex.a;

import com.uc.weex.h;
import java.util.List;

/* compiled from: ProGuard */
final class s implements e {
    final /* synthetic */ t a;
    private l b;
    private ac c;

    s(t tVar) {
        this.a = tVar;
    }

    public final void a(n nVar, String str, int i) {
        aa aaVar;
        if (this.b != null) {
            aaVar = new aa(this.b.k, this.b.b, false);
        } else {
            aaVar = new aa(h.WEEX_ERROR_REMOTE_URL_ILLEGAL, this.c.a);
        }
        for (e a : (List) this.a.c.i.remove(this.a.a)) {
            a.a(nVar, str, i);
        }
    }
}
