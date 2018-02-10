package com.ucpro.feature.j;

import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import com.ucpro.base.c.b.c;
import com.ucpro.base.c.b.g;
import com.ucpro.base.e.e;

/* compiled from: ProGuard */
public class f extends e implements c {
    public final void a(int i, Message message) {
        if (com.ucpro.base.a.e.dc == i) {
            g lVar = new l(this.b);
            g gVar = new g(lVar);
            lVar.setWindowCallBacks(this);
            this.a.b().a(lVar, true);
        }
    }

    public final void b(int i, Message message) {
    }

    public final void a(boolean z) {
        s_().a(z);
    }

    public final void a(g gVar, byte b) {
    }

    public final boolean a(g gVar, int i, KeyEvent keyEvent) {
        if (!(gVar instanceof g) || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        a(true);
        return true;
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void a(com.ui.edittext.c cVar, Object obj) {
    }

    public final View a(View view) {
        return this.a.b().b(this.a.b().a());
    }
}
