package com.ucpro.feature.p;

import android.app.Activity;
import android.os.Message;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.base.c.b;
import com.ucpro.base.e.e;
import com.ucweb.common.util.c;
import hugo.weaving.DebugLog;

/* compiled from: ProGuard */
public class i extends e {
    private Activity c;
    private o d;
    private n e;

    @DebugLog
    protected final void a(b bVar) {
        super.a(bVar);
        this.c = bVar.a();
    }

    public final void a(int i, Message message) {
        if (i == com.ucpro.base.a.e.g) {
            boolean z;
            int i2 = message.arg1;
            if (this.d == null) {
                this.d = new o(this.c);
                this.e = new n(this.d, s_());
                this.d.setPresenter(this.e);
                if (this.d != null && this.d.getParent() == null) {
                    this.a.b().a(this.d);
                }
            }
            this.e.b = i2;
            o oVar = this.d;
            if (oVar.d == null || !oVar.d.isRunning()) {
                z = false;
            } else {
                z = true;
            }
            if (!z && !oVar.e) {
                oVar.setVisibility(0);
                oVar.e = true;
                if (oVar.a.getAlpha() == IPictureView.DEFAULT_MIN_SCALE) {
                    oVar.a.setAlpha(0.0f);
                }
                if (oVar.c.getTranslationY() == 0.0f) {
                    oVar.c.setTranslationY((float) oVar.c.getContentHeight());
                }
                oVar.b.a(new t(oVar));
                oVar.b.a();
                oVar.f = false;
            }
        } else if (i == com.ucpro.base.a.e.h) {
            c.a(this.d);
            if (this.d != null) {
                this.d.a("unknow", true);
            }
        } else if (i == com.ucpro.base.a.e.i) {
            n nVar = this.e;
            nVar.c = nVar.b;
            nVar.b = 4;
            s sVar = nVar.a;
            g a = f.a(4);
            nVar.a((b[]) a.c.get(0));
            nVar.a((b[]) a.c.get(1));
            nVar.a(a.a);
            nVar.a(a.b);
            sVar.a(a);
        } else if (i == com.ucpro.base.a.e.j) {
            n nVar2 = this.e;
            nVar2.b = nVar2.c;
            nVar2.c = -1;
            nVar2.a.a();
        }
    }

    public final void b(int i, Message message) {
    }
}
