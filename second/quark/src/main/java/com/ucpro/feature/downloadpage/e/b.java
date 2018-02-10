package com.ucpro.feature.downloadpage.e;

import android.os.Message;
import com.quark.browser.R;
import com.ucpro.base.a.j;
import com.ucpro.base.e.e;
import com.ucpro.business.stat.m;
import com.ucpro.feature.downloadpage.e.b.a;
import com.ucpro.feature.webwindow.external.c;
import com.ucpro.services.f.g;
import com.ucweb.common.util.i.f;
import com.ucweb.common.util.l.d;
import hugo.weaving.DebugLog;
import java.lang.ref.WeakReference;
import okhttp3.Request.Builder;

/* compiled from: ProGuard */
public final class b extends e {
    public o c;
    private y d;

    public final void a(int i, Message message) {
        boolean z = true;
        int intValue;
        if (i == com.ucpro.base.a.e.u) {
            intValue = (message == null || !(message.obj instanceof Integer)) ? -1 : ((Integer) message.obj).intValue();
            a(intValue, z);
        } else if (i == com.ucpro.base.a.e.v) {
            d();
        } else if (i == com.ucpro.base.a.e.bl) {
            if (message.obj instanceof a) {
                a aVar = (a) message.obj;
                f.a.a = new WeakReference(this.b);
                f.a.b = aVar;
                af a = f.a;
                if (a.a != null && a.a.get() != null && a.b != null && !com.ucweb.common.util.n.a.a(a.b.a) && a.b.a.contains("http")) {
                    if (com.ucweb.common.util.n.a.b(a.b.b) && com.ucweb.common.util.n.a.b(c.b) && c.a) {
                        if (c.b.contains(f.c(a.b.b))) {
                            c.b = null;
                            c.a = false;
                            return;
                        }
                    }
                    if (!d.b(a.b.a, a.b.c, a.b.d) && com.ucweb.common.util.n.a.a(a.b.c) && com.ucweb.common.util.n.a.a(a.b.d)) {
                        try {
                            g.a().newCall(new Builder().url(a.b.a).build()).enqueue(new g(a));
                            return;
                        } catch (Exception e) {
                            com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.download_illegal_url), (int) z);
                            return;
                        }
                    }
                    a.a();
                }
            }
        } else if (i == com.ucpro.base.a.e.bm) {
            if (this.c == null) {
                com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.task_downloaded), com.ucpro.ui.c.a.d((int) R.string.click_to_see), new d(this));
                m.a("download", "s_c_toast", new String[0]);
            }
        } else if (i == com.ucpro.base.a.e.w) {
            if (message.obj instanceof Integer) {
                intValue = ((Integer) message.obj).intValue();
                if (this.c != null) {
                    this.c.a(intValue, z);
                    this.c.a();
                }
            }
        } else if (com.ucpro.base.a.e.cW == i) {
            if (message.obj != null && (message.obj instanceof com.ucpro.feature.downloadpage.a.g)) {
                this.d = new y(this.b, (com.ucpro.feature.downloadpage.a.g) message.obj);
                this.d.setPresenter(new ah(this.d, s_()));
                s_().a(this.d, z);
                m.a("download", "rename", new String[0]);
            }
        } else if (com.ucpro.base.a.e.cX == i) {
            boolean z2;
            if (message.obj == null || !(message.obj instanceof Boolean)) {
                z2 = z;
            } else {
                z2 = ((Boolean) message.obj).booleanValue();
            }
            if (this.d != null) {
                this.d = null;
                s_().a(z2);
            }
        } else if (com.ucpro.base.a.e.x == i && this.c != null) {
            this.c.p();
        }
    }

    public final void b(int i, Message message) {
        if (j.f == i) {
            com.ucpro.feature.downloadpage.e.b.b.a();
            if (this.c != null) {
                this.c.l();
            }
        }
    }

    @DebugLog
    public final void a(com.ucpro.base.c.b bVar) {
        super.a(bVar);
    }

    public final com.ucpro.ui.widget.j a(int i, boolean z) {
        this.c = new o(this.b);
        this.c.setPresenter(new ah(this.c, s_()));
        this.c.d(z);
        this.c.setEnableSwipeGesture(z);
        this.c.a();
        if (z) {
            s_().a(this.c, true);
        } else {
            this.c.f();
        }
        if (i != -1 && i <= 2) {
            m.a("download", i == 0 ? "home_enter" : "web_enter", new String[0]);
        }
        return this.c;
    }

    @DebugLog
    public final void d() {
        if (this.c != null && !this.c.h) {
            this.c.b();
            this.c = null;
        }
    }
}
