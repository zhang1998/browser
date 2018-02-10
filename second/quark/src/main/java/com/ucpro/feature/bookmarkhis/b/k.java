package com.ucpro.feature.bookmarkhis.b;

import android.content.Context;
import com.quark.browser.R;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucpro.feature.webwindow.aj;
import com.ucpro.ui.c.a;
import com.ucpro.ui.contextmenu.b;
import com.ucpro.ui.contextmenu.d;
import com.ucpro.ui.contextmenu.f;
import com.ui.edittext.c;

/* compiled from: ProGuard */
public final class k implements h, b {
    private Context a;
    private n b;

    public k(Context context, n nVar) {
        this.a = context;
        this.b = nVar;
    }

    public final void a(m mVar) {
        if (mVar != null) {
            d a = f.a().a(this.a);
            a.c();
            if (mVar.h()) {
                a.a(a.d((int) R.string.bookmark_backgroud_open), 120001);
            }
            a.a((Object) mVar);
            f.a().a(this.a, (b) this);
        }
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void a(c cVar, Object obj) {
        if ((obj instanceof m) && cVar != null) {
            obj = (m) obj;
            switch (cVar.a) {
                case 120001:
                    com.ucpro.business.stat.m.a("privacy_mode", "privacy_bookmark_bg_open", new String[0]);
                    String str = obj.f;
                    Object ajVar = new aj();
                    ajVar.o = str;
                    g.a().a(e.l, ajVar);
                    com.ucpro.ui.b.e.a().a(a.d((int) R.string.bookmark_background_open_tips), 0);
                    return;
                case 120003:
                case 120005:
                    g.a().a(e.aL, obj);
                    return;
                case 120006:
                    g.a().a(e.aN);
                    return;
                default:
                    return;
            }
        }
    }
}
