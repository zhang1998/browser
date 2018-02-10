package com.ucpro.feature.o.a;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.quark.browser.R;
import com.ucpro.b.d.a;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.business.stat.m;
import com.ucpro.feature.g.c.b.b;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class k implements a {
    g a;

    public k(g gVar) {
        this.a = gVar;
        gVar.setPresenter(this);
        if (a.d()) {
            this.a.a();
        }
    }

    public final void a() {
        j.a("wb");
        a(b.WEIBO);
    }

    public final void b() {
        j.a("qq");
        a(b.QQ);
    }

    public final void c() {
        j.a("wx");
        a(b.WECHAT);
    }

    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Object arrayList = new ArrayList();
            arrayList.add(str);
            arrayList.add(str2);
            g.a().b(e.bW, arrayList);
        }
    }

    private void a(b bVar) {
        com.ucpro.feature.g.c.e.a(bVar);
        switch (e.a[bVar.ordinal()]) {
            case 1:
                com.ucweb.e.b.a = new d(this, bVar);
                com.ucweb.login.a.a((Activity) ((View) this.a).getContext(), com.ucweb.login.b.WEIXIN);
                return;
            case 2:
                com.ucweb.b.b.a = new h(this, bVar);
                com.ucweb.login.a.a((Activity) ((View) this.a).getContext(), com.ucweb.login.b.QQ);
                return;
            case 3:
                com.ucweb.d.b.a = new c(this, bVar);
                com.ucweb.login.a.a((Activity) ((View) this.a).getContext(), com.ucweb.login.b.WEIBO);
                return;
            default:
                return;
        }
    }

    public final void a(String str) {
        m.a("login", "get_vercode", new String[0]);
        if (com.ucpro.base.system.b.a.f(str) && str.length() == 11) {
            l lVar = new l(this, str);
            g.a().b(e.bV, new Object[]{str, lVar});
            return;
        }
        com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.cloud_sync_phone_error), 0);
    }
}
