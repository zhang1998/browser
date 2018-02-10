package com.ucpro.feature.g.c;

import android.app.Activity;
import android.text.TextUtils;
import com.quark.browser.R;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.base.c.b.m;
import com.ucpro.feature.g.c.b.b;
import com.ucweb.login.a;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class i implements b {
    private k a;
    private m b;

    public i(k kVar, m mVar) {
        this.a = kVar;
        this.b = mVar;
    }

    public final void a(boolean z) {
        g.a().a(e.bU, Boolean.valueOf(z));
    }

    public final com.ucpro.base.c.b.g a(com.ucpro.base.c.b.g gVar) {
        return this.b.b(gVar);
    }

    public final void a() {
        g.a().a(e.bU, Boolean.valueOf(true));
    }

    public final void a(b bVar) {
        switch (a.a[bVar.ordinal()]) {
            case 1:
                com.ucweb.e.b.a = new h(this, bVar);
                a.a((Activity) this.b.h(), com.ucweb.login.b.WEIXIN);
                return;
            case 2:
                com.ucweb.b.b.a = new f(this, bVar);
                a.a((Activity) this.b.h(), com.ucweb.login.b.QQ);
                return;
            case 3:
                com.ucweb.d.b.a = new g(this, bVar);
                a.a((Activity) this.b.h(), com.ucweb.login.b.WEIBO);
                return;
            default:
                return;
        }
    }

    public final void a(String str) {
        if (com.ucpro.base.system.b.a.f(str)) {
            g.a().a(e.bV, new Object[]{str, null});
            return;
        }
        com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.cloud_sync_phone_error), 1);
    }

    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Object arrayList = new ArrayList();
            arrayList.add(str);
            arrayList.add(str2);
            g.a().a(e.bW, arrayList);
        }
    }
}
