package com.ucpro.feature.privacymode;

import android.os.Message;
import com.ucpro.base.e.e;
import com.ucpro.business.stat.m;
import com.ucpro.feature.privacymode.a.a;

/* compiled from: ProGuard */
public class n extends e {
    private i c;
    private h d;
    private q e;
    private j f;
    private p g;
    private o h;
    private c i;
    private l j;
    private d k;

    public final void a(int i, Message message) {
        boolean z = false;
        if (com.ucpro.base.a.e.ct == i) {
            if (this.c == null || s_().a() != this.c) {
                this.c = new i(this.b, s_());
                s_().a(this.c, true);
            }
        } else if (com.ucpro.base.a.e.cu == i) {
            d();
        } else if (com.ucpro.base.a.e.cw == i) {
            if (message != null && (message.obj instanceof Boolean)) {
                z = ((Boolean) message.obj).booleanValue();
                if (this.c != null) {
                    s_().a(z);
                    this.c = null;
                }
            }
        } else if (com.ucpro.base.a.e.cv == i) {
            if (message != null && (message.obj instanceof Boolean)) {
                z = ((Boolean) message.obj).booleanValue();
                if (this.d != null) {
                    s_().a(z);
                    this.d = null;
                }
            }
        } else if (com.ucpro.base.a.e.cx == i) {
            boolean a = a.a();
            boolean e = a.e();
            if (a && e) {
                if (com.ucweb.common.util.n.a.a(com.ucpro.feature.privacymode.c.a.a())) {
                    a(false);
                } else {
                    d();
                }
            } else if (this.e == null || s_().a() != this.e) {
                this.e = new q(this.b, s_());
                s_().a(this.e, true);
                m.a("privacy_mode", "privacy_guide_page", new String[0]);
            }
        } else if (com.ucpro.base.a.e.cy == i) {
            if (message != null && (message.obj instanceof Boolean)) {
                z = ((Boolean) message.obj).booleanValue();
                if (this.e != null) {
                    s_().a(z);
                    this.e = null;
                }
            }
        } else if (com.ucpro.base.a.e.cz == i) {
            if (this.f == null || s_().a() != this.f) {
                this.f = new j(this.b, s_());
                s_().a(this.f, true);
                m.a("privacy_mode", "privacy_box_page", new String[0]);
            }
        } else if (com.ucpro.base.a.e.cA == i) {
            if (message != null && (message.obj instanceof Boolean)) {
                z = ((Boolean) message.obj).booleanValue();
                if (this.f != null) {
                    s_().a(z);
                    this.f = null;
                }
            }
        } else if (com.ucpro.base.a.e.cB == i) {
            if (this.f != null) {
                this.f.g.k();
            }
        } else if (com.ucpro.base.a.e.cF == i) {
            if (message.obj instanceof Boolean) {
                z = ((Boolean) message.obj).booleanValue();
            }
            a(z);
        } else if (com.ucpro.base.a.e.cG == i) {
            if (message != null && (message.obj instanceof Boolean)) {
                z = ((Boolean) message.obj).booleanValue();
                if (this.g != null) {
                    s_().a(z);
                    this.g = null;
                }
            }
        } else if (com.ucpro.base.a.e.cH == i) {
            if (this.h == null || s_().a() != this.h) {
                this.h = new o(this.b, s_());
                s_().a(this.h, true);
            }
        } else if (com.ucpro.base.a.e.cI == i) {
            if (message != null && (message.obj instanceof Boolean)) {
                z = ((Boolean) message.obj).booleanValue();
                if (this.h != null) {
                    s_().a(z);
                    this.h = null;
                }
            }
        } else if (com.ucpro.base.a.e.cJ == i) {
            if (this.i == null || s_().a() != this.i) {
                this.i = new c(this.b, s_());
                s_().a(this.i, true);
            }
        } else if (com.ucpro.base.a.e.cK == i) {
            if (message != null && (message.obj instanceof Boolean)) {
                z = ((Boolean) message.obj).booleanValue();
                if (this.i != null) {
                    s_().a(z);
                    this.i = null;
                }
            }
        } else if (com.ucpro.base.a.e.cL == i) {
            if (this.j == null || s_().a() != this.j) {
                this.j = new l(this.b, s_());
                s_().a(this.j, true);
            }
        } else if (com.ucpro.base.a.e.cM == i) {
            if (message != null && (message.obj instanceof Boolean)) {
                z = ((Boolean) message.obj).booleanValue();
                if (this.j != null) {
                    s_().a(z);
                    this.j = null;
                }
            }
        } else if (com.ucpro.base.a.e.cN == i) {
            if (this.k == null || s_().a() != this.k) {
                this.k = new d(this.b, s_());
                s_().a(this.k, true);
            }
        } else if (com.ucpro.base.a.e.cO == i && message != null && (message.obj instanceof Boolean)) {
            z = ((Boolean) message.obj).booleanValue();
            if (this.k != null) {
                s_().a(z);
                this.k = null;
            }
        }
    }

    public final void b(int i, Message message) {
    }

    private void d() {
        if (this.d == null || s_().a() != this.d) {
            this.d = new h(this.b, s_());
            s_().a(this.d, true);
            m.a("privacy_mode", "privacy_unlock_page", new String[0]);
        }
    }

    private void a(boolean z) {
        if (this.g == null || s_().a() != this.g) {
            this.g = new p(this.b, s_());
            this.g.setFromChangePassword(z);
            s_().a(this.g, true);
        }
    }

    public final void q_() {
        super.q_();
        if (this.c != null) {
            i iVar = this.c;
            if (iVar.e != null) {
                iVar.e.b();
            }
        } else if (this.d != null) {
            h hVar = this.d;
            if (hVar.e != null) {
                hVar.e.b();
            }
        } else if (this.j != null) {
            l lVar = this.j;
            if (lVar.e != null) {
                lVar.e.b();
            }
        }
    }

    public final void v_() {
        super.v_();
        if (this.c != null) {
            i iVar = this.c;
            if (iVar.e != null) {
                iVar.e.a();
            }
        } else if (this.d != null) {
            h hVar = this.d;
            if (hVar.e != null) {
                hVar.e.a();
            }
        } else if (this.j != null) {
            l lVar = this.j;
            if (lVar.e != null) {
                lVar.e.a();
            }
        }
    }

    public final void g() {
        super.g();
        if (this.c != null) {
            this.c.m();
        } else if (this.d != null) {
            this.d.m();
        } else if (this.j != null) {
            this.j.m();
        }
    }
}
