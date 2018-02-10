package com.ucpro.feature.downloadpage.b;

import android.os.Message;
import com.ucpro.base.e.e;
import com.ucpro.base.system.b;
import com.ucpro.business.stat.m;

/* compiled from: ProGuard */
public class q extends e {
    private p c;
    private a d;

    public final void a(int i, Message message) {
        if (com.ucpro.base.a.e.cc == i) {
            m.a("download", "ext_sd_click", new String[0]);
            this.d = new a(this.b);
            b.a.a(this.b, new d(this, new j(this.d, s_())));
        } else if (com.ucpro.base.a.e.cd == i) {
            if (message != null && (message.obj instanceof Boolean)) {
                ((Boolean) message.obj).booleanValue();
            }
        } else if (com.ucpro.base.a.e.ce == i) {
            if (this.c == null) {
                this.c = new p(this.b);
                this.c.setPresenter(new b(this.c, s_()));
            }
            s_().a(this.c, true);
        } else if (com.ucpro.base.a.e.cf == i) {
            if (message != null && (message.obj instanceof Boolean)) {
                boolean booleanValue = ((Boolean) message.obj).booleanValue();
                if (this.c != null) {
                    s_().a(booleanValue);
                    this.c = null;
                }
            }
        } else if (com.ucpro.base.a.e.cg == i && this.c != null) {
            p pVar = this.c;
            if (pVar.g != null) {
                pVar.g.k();
            }
        }
    }

    public final void b(int i, Message message) {
    }
}
