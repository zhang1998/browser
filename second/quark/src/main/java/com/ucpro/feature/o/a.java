package com.ucpro.feature.o;

import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import com.ucpro.base.a.j;
import com.ucpro.base.c.b.c;
import com.ucpro.base.c.b.g;
import com.ucpro.base.e.e;
import com.ucpro.feature.o.a.f;
import com.ucpro.feature.o.a.k;
import com.ucweb.login.b;

/* compiled from: ProGuard */
public class a extends e implements c {
    public a() {
        String str;
        boolean d = com.ucpro.b.d.a.d();
        b bVar = b.WEIXIN;
        bVar.d = "wx85686879e8891882";
        bVar.e = "b00a4720d0dff9343b08aecd031d395a";
        b bVar2 = b.QQ;
        if (d) {
            str = "1105842820";
        } else {
            str = "1105781586";
        }
        bVar2.d = str;
        if (d) {
            str = "aSuo8HdX8uaf2pCM";
        } else {
            str = "8BcUwsGDZRQJsCZ";
        }
        bVar2.e = str;
        bVar = b.WEIBO;
        bVar.d = "685697311";
        bVar.e = "3f9782f18a8ec48dcb020bd3b089b596";
    }

    public final void a(int i, Message message) {
        if (com.ucpro.base.a.e.de == i) {
            g fVar = new f(this.b);
            k kVar = new k(fVar);
            fVar.setWindowCallBacks(this);
            this.a.b().a(fVar, true);
        }
    }

    public final void b(int i, Message message) {
        if (j.v == i) {
            com.ucweb.common.util.f.a(this.b, s_().a());
            s_().a(false);
            return;
        }
        int i2 = j.w;
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
