package com.ucpro.feature.d;

import android.os.Message;
import com.ucpro.b.a.a;
import com.ucpro.base.e.e;
import com.ucweb.c.b.b;

/* compiled from: ProGuard */
public class d extends e {
    private f c;
    private m d;

    public final void a(int i, Message message) {
        if (com.ucpro.base.a.e.bC != i || !(message.obj instanceof b)) {
            return;
        }
        if (a.b()) {
            com.ucweb.c.a.a(this.b, (b) message.obj, com.ucweb.c.a.b.SHARE_MORE);
            return;
        }
        b bVar = (b) message.obj;
        if (this.c == null) {
            this.c = null;
            this.c = new f(this.b);
            this.c.a(new i(this));
            this.d = new m(this.c, s_());
            this.c.setPresenter(this.d);
            m mVar = this.d;
            mVar.a.a(bVar, this.b);
        }
    }

    public final void b(int i, Message message) {
    }

    public final void g() {
        super.g();
        this.c = null;
    }
}
