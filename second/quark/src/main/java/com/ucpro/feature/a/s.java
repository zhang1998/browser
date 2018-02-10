package com.ucpro.feature.a;

import android.os.Message;
import android.view.View;
import com.uc.weex.h.k;
import com.uc.weex.o;
import com.ucpro.base.c.b;
import com.ucpro.base.e.e;
import com.ucpro.base.weex.c;
import com.ucpro.base.weex.f;
import com.ucpro.ui.c.a;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
public class s extends e {
    private c c;

    protected final void a(b bVar) {
        super.a(bVar);
        this.c = new c();
        f.a().a(this.b);
        com.uc.weex.component.b.a(r.c());
    }

    public final void a(int i, Message message) {
        if (com.ucpro.base.a.e.bM == i) {
            f.a().a((String) message.obj);
        } else if (com.ucpro.base.a.e.bN == i) {
            k kVar = (k) message.obj;
            d dVar = new d(new o(this.b), this.b, this, this.c);
            kVar = dVar.a(kVar);
            kVar.e = dVar.h;
            dVar.e = o.a.a(dVar.b, kVar);
            dVar.e.a(new m(dVar, dVar.c));
            dVar.f = new a(dVar, dVar.b);
            dVar.f.setWindowCallBacks(dVar.g);
            dVar.f.b((View) dVar.a);
            ((View) dVar.a).setBackgroundColor(a.c("background_color"));
            dVar.d.a.b().a(dVar.f, true);
            m.a(2, new c(dVar), 300);
        } else if (com.ucpro.base.a.e.bO == i) {
            s_().a().setEnableSwipeGesture(((Boolean) message.obj).booleanValue());
        }
    }

    public final void b(int i, Message message) {
    }
}
