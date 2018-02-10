package com.ucpro.feature.bookmarkhis.bookmark;

import android.content.Context;
import android.text.TextUtils;
import com.quark.browser.R;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.feature.bookmarkhis.bookmark.a.af;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucpro.feature.bookmarkhis.bookmark.a.s;
import com.ucpro.feature.webwindow.aj;
import com.ucpro.ui.c.a;
import com.ucpro.ui.contextmenu.b;
import com.ucpro.ui.contextmenu.d;
import com.ucpro.ui.contextmenu.f;
import com.ui.edittext.c;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class n implements b, b {
    q a;
    boolean b = false;
    u c;
    private Context d;
    private boolean e = false;
    private af f = new f(this);

    public n(Context context, q qVar) {
        this.d = context;
        this.a = qVar;
        a(true);
    }

    public final void a(m mVar) {
        if (mVar != null) {
            d a = f.a().a(this.d);
            a.c();
            if (mVar.h()) {
                a.a(a.d((int) R.string.bookmark_share), 120009);
                if (mVar.i()) {
                    a.a(a.d((int) R.string.bookmark_cancel_top_stick), 120008);
                } else {
                    a.a(a.d((int) R.string.bookmark_top_stick), 120007);
                }
                a.a(a.d((int) R.string.bookmark_edit_url), 120003);
                a.a(a.d((int) R.string.delete_history_item), 120012);
                a.a(a.d((int) R.string.bookmark_add_to_nav), 120013);
                a.a(a.d((int) R.string.bookmark_more), 120010);
                if (mVar.d != 0) {
                    a.a(a.d((int) R.string.bookmark_cancel_classify), 120011);
                }
            } else if (mVar.g()) {
                a.a(a.d((int) R.string.bookmark_edit_dir), 120005);
                a.a(a.d((int) R.string.bookmark_more), 120010);
            }
            a.a((Object) mVar);
            f.a().a(this.d, (b) this);
        }
    }

    public final void a() {
        if (this.e) {
            this.a.a_(true);
            s.a().b().a(this.f);
            this.b = true;
            return;
        }
        g.a().a(e.aI);
        g.a().a(e.de);
    }

    public final void d() {
    }

    public final void e() {
    }

    public final void a(c cVar, Object obj) {
        if ((obj instanceof m) && cVar != null) {
            obj = (m) obj;
            String str;
            switch (cVar.a) {
                case 120001:
                    com.ucpro.business.stat.m.a("bookmark", "bookmark_background_open", new String[0]);
                    str = obj.f;
                    Object ajVar = new aj();
                    ajVar.o = str;
                    g.a().a(e.l, ajVar);
                    com.ucpro.ui.b.e.a().a(a.d((int) R.string.bookmark_background_open_tips), 0);
                    return;
                case 120003:
                case 120005:
                    com.ucpro.business.stat.m.a("bookmark", "bookmark_revise", new String[0]);
                    g.a().a(e.aL, obj);
                    return;
                case 120006:
                    g.a().a(e.aN);
                    return;
                case 120007:
                    com.ucpro.business.stat.m.a("bookmark", "bookmark_top_stick", new String[0]);
                    g.a().a(e.aU, obj);
                    return;
                case 120008:
                    com.ucpro.business.stat.m.a("bookmark", "bookmark_cancle_top_stick", new String[0]);
                    g.a().a(e.aV, obj);
                    return;
                case 120009:
                    com.ucpro.business.stat.m.a("bookmark", "bookmark_share", new String[0]);
                    if (obj != null) {
                        str = com.ucpro.feature.d.a.b.a(com.ucpro.services.c.f.a.a.a(this.d, obj.f));
                        com.ucweb.c.b.a aVar = new com.ucweb.c.b.a();
                        aVar.a = obj.f;
                        aVar.b = obj.e;
                        aVar.c = "";
                        aVar.e = str;
                        aVar.f = str;
                        aVar.d = com.ucweb.c.a.c.c;
                        g.a().a(e.bC, aVar.a());
                        return;
                    }
                    return;
                case 120010:
                    com.ucpro.business.stat.m.a("bookmark", "bookmark_click_more", new String[0]);
                    g.a().a(e.aS);
                    return;
                case 120011:
                    com.ucpro.business.stat.m.a("bookmark", "bookmark_cancel_classify", new String[0]);
                    g.a().a(e.aT, obj);
                    return;
                case 120012:
                    com.ucpro.business.stat.m.a("bookmark", "bookmark_context_delete", new String[0]);
                    if (this.c != null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(Long.valueOf(obj.b));
                        this.c.a(arrayList);
                        return;
                    }
                    return;
                case 120013:
                    com.ucpro.business.stat.m.a("bookmark", "bookmark_add_to_nav", new String[0]);
                    g.a().b(e.c, new ab(this, obj.e, obj.f));
                    return;
                default:
                    return;
            }
        }
    }

    final void a(boolean z) {
        if (this.a != null) {
            com.ucpro.feature.f.n.a;
            if (com.ucpro.feature.f.e.c()) {
                com.ucpro.feature.f.n.a;
                com.uc.base.a.a.a.h.a e = com.ucpro.feature.f.e.e();
                if (e != null) {
                    this.a.setLoginName(com.ucpro.feature.f.e.a(e));
                } else {
                    com.ucpro.feature.f.n.a.b(new ae(this));
                }
                this.e = true;
                s.a().b();
                if (TextUtils.isEmpty(com.ucpro.feature.g.a.a(50011))) {
                    this.a.setSyncTime(a.d((int) R.string.bookmark_cloudbar_not_sync));
                } else {
                    q qVar = this.a;
                    s.a().b();
                    qVar.setSyncTime(com.ucpro.feature.g.a.a(50011));
                }
                if (z) {
                    s.a().b().a(this.f);
                    return;
                }
                return;
            }
            this.a.setLoginName(a.d((int) R.string.bookmark_cloudbar_not_login));
            this.a.setSyncTime(a.d((int) R.string.bookmark_cloudbar_not_sync));
        }
    }
}
