package com.ucpro.feature.ab;

import android.net.Uri;
import android.os.Message;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.ucpro.business.stat.m;

/* compiled from: ProGuard */
public class e extends com.ucpro.base.e.e {
    private b c;

    public final void a(int i, Message message) {
        if (com.ucpro.base.a.e.bD == i) {
            if (this.c == null || s_().a() != this.c) {
                m.a("qrcode", "qrcode_show", new String[0]);
                this.c = new b(this.b, s_());
                this.c.setPresenter(new k(this.c, s_()));
                s_().a(this.c, true);
            }
        } else if (com.ucpro.base.a.e.bE == i) {
            if (message.obj instanceof Boolean) {
                a(((Boolean) message.obj).booleanValue());
            }
        } else if (com.ucpro.base.a.e.bF == i) {
            m.a("qrcode", "image_qrcode", new String[0]);
            if (message.obj instanceof String) {
                c.a((String) message.obj);
            }
        } else if (com.ucpro.base.a.e.bG == i && (message.obj instanceof Uri)) {
            c.a(c.a((Uri) message.obj, this.b), new o(this), false);
        }
    }

    public final void b(int i, Message message) {
    }

    public final void v_() {
        super.v_();
        if (this.c != null) {
            b bVar = this.c;
            if (bVar.e != null) {
                Callback callback = bVar.e;
                callback.c();
                if (!callback.a) {
                    callback.b = new SurfaceView(callback.d, null);
                    callback.b.getHolder().removeCallback(callback);
                }
            }
        }
    }

    public final void q_() {
        super.q_();
        if (this.c != null) {
            b bVar = this.c;
            if (bVar.e != null) {
                bVar.e.b();
            }
        }
    }

    public final void g() {
        super.g();
        if (this.c != null) {
            this.c.a();
            this.c = null;
        }
    }

    private void a(boolean z) {
        if (this.c != null) {
            s_().a(z);
            this.c = null;
        }
    }
}
