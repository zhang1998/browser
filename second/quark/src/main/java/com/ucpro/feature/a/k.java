package com.ucpro.feature.a;

import android.view.KeyEvent;
import android.view.View;
import com.ucpro.base.c.b.c;
import com.ucpro.base.c.b.g;
import com.ucpro.base.weex.component.h;

/* compiled from: ProGuard */
final class k implements c {
    final /* synthetic */ d a;

    k(d dVar) {
        this.a = dVar;
    }

    public final void a(boolean z) {
        this.a.a(z);
    }

    public final void a(g gVar, byte b) {
        if (b == (byte) 13) {
            d dVar = this.a;
            h a = h.a(dVar.e.f());
            if (a != null) {
                Runnable vVar = new v(dVar);
                if (a.d != null) {
                    h.a.remove(a.d);
                }
                if (a.e) {
                    for (com.ucpro.base.weex.component.g gVar2 : a.f) {
                        gVar2.b = vVar;
                        gVar2.a.b(null);
                    }
                    a.a(5000000);
                    return;
                }
                vVar.run();
                return;
            }
            dVar.a();
        }
    }

    public final boolean a(g gVar, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        if (keyEvent.getAction() != 1 || this.a.e == null) {
            return true;
        }
        this.a.e.b("hardwareBackPress", "{}");
        return true;
    }

    public final View a(View view) {
        if (view instanceof g) {
            return this.a.d.a.b().b((g) view);
        }
        return null;
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void a(com.ui.edittext.c cVar, Object obj) {
    }
}
