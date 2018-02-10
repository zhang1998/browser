package com.ucpro.feature.g.b;

import android.os.Message;
import com.uc.base.a.a.a.h.a;
import com.ucpro.base.a.g;
import com.ucpro.base.a.j;
import com.ucpro.base.e.e;
import com.ucpro.feature.f.n;

/* compiled from: ProGuard */
public class m extends e {
    private d c;
    private o d;

    public final void a(int i, Message message) {
        if (com.ucpro.base.a.e.bR == i) {
            if (this.c == null) {
                this.c = new d(this.b);
                this.d = new o(this.c, s_());
                this.c.setPresenter(this.d);
            }
            String str = "";
            n.a;
            a e = com.ucpro.feature.f.e.e();
            if (e != null) {
                str = com.ucpro.feature.f.e.a(e);
            } else {
                n.a.b(new i(this));
            }
            this.c.b(str);
            s_().a(this.c, true);
        } else if (com.ucpro.base.a.e.bS == i && (message.obj instanceof Boolean)) {
            boolean booleanValue = ((Boolean) message.obj).booleanValue();
            if (this.c != null) {
                s_().a(booleanValue);
                this.c = null;
            }
        }
    }

    public final void b(int i, Message message) {
        if (j.v == i) {
            n.a;
            if (com.ucpro.feature.f.e.c()) {
                g.a().a(com.ucpro.base.a.e.bR);
            }
            com.ucpro.feature.g.a.a();
        } else if (j.w == i) {
            com.ucpro.feature.g.a.b();
            g.a().a(com.ucpro.base.a.e.bS, Boolean.valueOf(false));
        }
    }
}
