package com.ucpro.feature.downloadpage.c;

import android.app.Activity;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import com.quark.browser.R;
import com.ucpro.base.c.b.c;
import com.ucpro.base.c.b.g;
import com.ucpro.base.e.e;
import com.ucpro.feature.downloadpage.d.l;
import com.ucpro.feature.downloadpage.d.u;
import com.ucpro.feature.downloadpage.e.b;
import com.ucpro.feature.downloadpage.e.o;
import com.ucpro.services.download.b.d;
import com.ucpro.services.download.b.f;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class a extends e implements c, f {
    private boolean c;
    private Activity d;
    private b e;
    private u f;
    private com.ucpro.feature.downloadpage.c.a.a g;
    private ArrayList<com.ucpro.feature.downloadpage.c.a.c> h;

    public final void a(int i, Message message) {
        int intValue;
        if (i == com.ucpro.base.a.e.aw) {
            if (message.obj instanceof Integer) {
                intValue = ((Integer) message.obj).intValue();
            } else {
                intValue = 0;
            }
            a(intValue, 0);
        } else if (com.ucpro.base.a.e.y == i) {
            a(1, 0);
        } else if (i == com.ucpro.base.a.e.u) {
            intValue = (message == null || !(message.obj instanceof Integer)) ? -1 : ((Integer) message.obj).intValue();
            a(0, intValue);
        } else if (com.ucpro.base.a.e.v != i && com.ucpro.base.a.e.z != i) {
            this.e.a(i, message);
            this.f.a(i, message);
        } else if (this.g == null) {
        } else {
            if (this.g.getCurPage() == 0) {
                if (this.h != null && this.h.size() > 0 && (((com.ucpro.feature.downloadpage.c.a.c) this.h.get(0)).b instanceof o)) {
                    o oVar = (o) ((com.ucpro.feature.downloadpage.c.a.c) this.h.get(0)).b;
                    if (oVar.h) {
                        oVar.m();
                        return;
                    }
                    s_().a(true);
                    this.e.d();
                    this.f.d();
                    this.g = null;
                }
            } else if (this.h != null && this.h.size() > 0 && (((com.ucpro.feature.downloadpage.c.a.c) this.h.get(1)).b instanceof l)) {
                s_().a(true);
                this.e.d();
                this.f.d();
                this.g = null;
            }
        }
    }

    public final void b(int i, Message message) {
        this.e.b(i, message);
        if (this.g != null) {
            this.g.l();
        }
    }

    protected final void a(com.ucpro.base.c.b bVar) {
        super.a(bVar);
        this.d = bVar.a();
        this.e = new b();
        this.e.a(bVar);
        this.f = new u();
        this.f.a(bVar);
        d.b().b = this;
    }

    private void a(int i, int i2) {
        d.b().d();
        if (this.g == null || this.a.b().a() != this.g) {
            if (this.h == null) {
                this.h = new ArrayList();
            }
            this.h.clear();
            this.h.add(0, new com.ucpro.feature.downloadpage.c.a.c(com.ucpro.ui.c.a.d((int) R.string.download), this.e.a(i2, false)));
            this.h.add(1, new com.ucpro.feature.downloadpage.c.a.c(com.ucpro.ui.c.a.d((int) R.string.m3u8_cache), this.f.a(false)));
            this.g = new com.ucpro.feature.downloadpage.c.a.a(this.d, this.h);
            this.g.setWindowCallBacks(this);
            com.ucpro.feature.downloadpage.c.a.a aVar = this.g;
            if (aVar.g != null && i >= 0) {
                aVar.g.setCurrentItem$2563266(i);
            }
            this.g.getViewPager().a(new b(this));
            this.a.b().a(this.g, true);
        }
    }

    public final void a(boolean z) {
        b bVar = this.e;
        if (bVar.c != null) {
            bVar.c.b.a(z);
        }
        this.g = null;
    }

    public final void a(g gVar, byte b) {
        b bVar = this.e;
        if (bVar.c != null) {
            bVar.c.b.a(gVar, b);
        }
    }

    public final boolean a(g gVar, int i, KeyEvent keyEvent) {
        b bVar = this.e;
        if (bVar.c == null) {
            return false;
        }
        o oVar = bVar.c;
        return oVar.b.a(bVar.c, i, keyEvent);
    }

    public final View a(View view) {
        com.ucweb.common.util.f.a(this.d, view);
        b bVar = this.e;
        if (bVar.c != null) {
            bVar.c.b.a(view);
        }
        if (view instanceof g) {
            return s_().b((g) view);
        }
        return null;
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void a(com.ui.edittext.c cVar, Object obj) {
    }

    public final boolean c() {
        return this.g == null || this.c;
    }

    public final void v_() {
        super.v_();
        this.c = true;
    }

    public final void q_() {
        super.q_();
        this.c = false;
        if (this.g != null) {
            d.b().d();
        }
    }
}
