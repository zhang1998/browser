package com.ucpro.feature.l;

import android.app.Activity;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.base.a.g;
import com.ucpro.base.c.b;
import com.ucpro.base.e.e;
import com.ucpro.business.stat.m;
import com.ucpro.feature.l.c.a;
import com.ucpro.feature.l.c.i;
import com.ucpro.feature.l.c.j;
import com.ucpro.feature.webwindow.aj;
import com.ucpro.ui.widget.h;

/* compiled from: ProGuard */
public class c extends e implements com.ucpro.base.c.b.c {
    private a c = null;
    private j d = null;
    private boolean e = false;
    private boolean f = false;

    static /* synthetic */ void c(c cVar) {
        if (cVar.s_().a() == cVar.c) {
            cVar.s_().a(false);
            j jVar = cVar.d;
            com.ucweb.common.util.j.a.a(jVar.e, "0FD35766FBF86241", "D453CF393F9E62D2", jVar.a.getContent().getViewPager().getCurrentItem());
            cVar.c = null;
            cVar.d = null;
        }
    }

    protected final void a(b bVar) {
        super.a(bVar);
    }

    public final void a(int i, Message message) {
        int i2 = 0;
        boolean z = true;
        if (i == com.ucpro.base.a.e.cP) {
            i();
            if (!this.e) {
                this.e = true;
                m.a("discoverp_page", "dis_ent", new String[0]);
                k();
                j jVar = this.d;
                jVar.a.a(true, 0.0f, new a(this));
                if (jVar.i == 0) {
                    jVar.b.a();
                } else if (jVar.i == 1) {
                    jVar.c.a();
                }
                com.ucweb.common.util.j.a.a(this.b, "ECC3CF22A48D384F", "24E6E448A6A97026", true);
            }
        } else if (com.ucpro.base.a.e.cS == i) {
            if (message != null && (message.obj instanceof String)) {
                Object obj = (String) message.obj;
                if (!TextUtils.isEmpty(obj)) {
                    s_().b(true);
                    if (com.ucpro.feature.lightapp.d.a.b(obj)) {
                        g.a().b(com.ucpro.base.a.e.bH, obj);
                        return;
                    }
                    Object ajVar = new aj();
                    ajVar.o = obj;
                    ajVar.s = aj.c;
                    g.a().a(com.ucpro.base.a.e.k, ajVar);
                    s_().a(true);
                }
            }
        } else if (com.ucpro.base.a.e.cT == i) {
            j();
        } else if (i == com.ucpro.base.a.e.cQ) {
            int i3 = -message.arg1;
            if (message.arg2 == 0) {
                i2 = com.ucpro.ui.c.a.c((int) R.dimen.dicover_page_pullup_enter_delta_slop);
            }
            if (i3 > i2 && !this.e) {
                i();
                k();
                this.e = true;
            }
            if (this.e) {
                int i4;
                j jVar2 = this.d;
                i2 = i3 - i2;
                if (i2 >= 0) {
                    i4 = i2;
                }
                if (i4 > jVar2.f) {
                    jVar2.f = i4;
                }
                jVar2.g = i4;
                float height = ((float) i4) / ((float) ((Activity) jVar2.e).findViewById(R.id.view_homepage).getHeight());
                jVar2.h = height;
                jVar2.a.a(height);
            }
        } else if (i == com.ucpro.base.a.e.cR && this.e) {
            j jVar3 = this.d;
            com.ucpro.ui.animation.g bVar = new b(this);
            if (jVar3.f - jVar3.g > com.ucpro.ui.c.a.c((int) R.dimen.dicover_page_pullup_enter_delta_slop)) {
                jVar3.a.a(false, IPictureView.DEFAULT_MIN_SCALE - jVar3.h, bVar);
                z = false;
            } else {
                jVar3.a.a(true, jVar3.h, bVar);
            }
            this.f = z;
        }
    }

    private void i() {
        if (this.c == null) {
            View findViewById = this.b.findViewById(R.id.view_homepage);
            if (findViewById != null) {
                this.c = new a(this.b);
                this.c.setEnableSwipeGesture(false);
                this.d = new j(this.b, this.c.getDiscoverPage());
                this.c.setWindowCallBacks(this);
                this.c.getDiscoverPage().setHomePage(findViewById);
                View findViewById2 = this.b.findViewById(R.id.home_toolbar_multi);
                findViewById = this.b.findViewById(R.id.home_toolbar_menu);
                if (findViewById2 != null && findViewById != null) {
                    i discoverPage = this.c.getDiscoverPage();
                    if (discoverPage.a == null) {
                        discoverPage.a = new h(discoverPage.getContext());
                        discoverPage.addView(discoverPage.a);
                    }
                    discoverPage.a.setSourceView(findViewById2);
                    if (discoverPage.b == null) {
                        discoverPage.b = new h(discoverPage.getContext());
                        discoverPage.addView(discoverPage.b);
                    }
                    discoverPage.b.setSourceView(findViewById);
                }
            }
        }
    }

    private void j() {
        if (!this.e) {
            this.e = true;
            m.a("discoverp_page", "dis_lea", new String[0]);
            j jVar = this.d;
            jVar.a.a(false, 0.0f, new d(this));
        }
    }

    public final void b(int i, Message message) {
        if (i == com.ucpro.base.a.j.f && this.c != null) {
            this.c.l();
        }
    }

    private void k() {
        s_().a(this.c, false);
    }

    public final void a(boolean z) {
        j();
    }

    public final void a(com.ucpro.base.c.b.g gVar, byte b) {
    }

    public final boolean a(com.ucpro.base.c.b.g gVar, int i, KeyEvent keyEvent) {
        boolean z = false;
        if (!(gVar instanceof com.ucpro.base.c.b.g) || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        j jVar = this.d;
        if (jVar.a.getContent().getViewPager().getCurrentItem() == 1) {
            z = jVar.c.b();
        }
        if (z) {
            return true;
        }
        j();
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
