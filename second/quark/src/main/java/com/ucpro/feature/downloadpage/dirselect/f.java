package com.ucpro.feature.downloadpage.dirselect;

import android.os.Message;
import com.ucpro.base.e.e;

/* compiled from: ProGuard */
public class f extends e {
    private k c;

    public final void a(int i, Message message) {
        if (com.ucpro.base.a.e.df == i) {
            this.c = new k(this.b, s_());
            this.c.setPresenter(new m(this.c));
            s_().a(this.c, true);
        } else if (com.ucpro.base.a.e.dg == i && (message.obj instanceof Boolean)) {
            boolean booleanValue = ((Boolean) message.obj).booleanValue();
            if (this.c != null && s_().a() == this.c) {
                this.c = null;
                s_().a(booleanValue);
            }
        }
    }

    public final void b(int i, Message message) {
    }
}
