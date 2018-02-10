package com.ucpro.feature.webwindow.b;

import android.view.KeyEvent;
import android.view.View;
import com.ucpro.base.a.f;
import com.ucpro.base.a.j;
import com.ucpro.base.c.b.g;
import com.ucpro.base.c.b.m;
import com.ui.edittext.c;

/* compiled from: ProGuard */
public final class b implements j {
    u a;
    m b;

    public b(i iVar, m mVar) {
        this.a = iVar;
        this.b = mVar;
    }

    public final void a(boolean z) {
        this.a.c();
        this.b.a(z);
    }

    public final void a(g gVar, byte b) {
        if ((gVar instanceof i) && gVar == this.a) {
            switch (b) {
                case (byte) 13:
                    this.a.setPresenter(null);
                    return;
                default:
                    return;
            }
        }
    }

    public final boolean a(g gVar, int i, KeyEvent keyEvent) {
        if (!(gVar instanceof g) || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        f.a().a(j.y);
        return true;
    }

    public final View a(View view) {
        return null;
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void a(c cVar, Object obj) {
    }
}
