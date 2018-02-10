package com.ucpro.feature.g.c;

import android.os.Message;
import com.ucpro.b.d.a;
import com.ucpro.base.e.e;
import com.ucweb.common.util.f;
import com.ucweb.login.b;

/* compiled from: ProGuard */
public class j extends e {
    private c c;

    public j() {
        String str;
        boolean d = a.d();
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
        if (com.ucpro.base.a.e.bT == i) {
            if (this.c == null) {
                this.c = new c(this.b);
                this.c.setPresenter(new i(this.c, s_()));
            }
            s_().a(this.c, true);
        } else if (com.ucpro.base.a.e.bU == i && (message.obj instanceof Boolean)) {
            boolean booleanValue = ((Boolean) message.obj).booleanValue();
            if (this.c != null) {
                f.a(this.b, this.c);
                s_().a(booleanValue);
                this.c = null;
            }
        }
    }

    public final void b(int i, Message message) {
    }
}
