package com.ucpro.feature.g.b;

import android.text.TextUtils;
import com.quark.browser.R;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.base.c.b.m;
import com.ucpro.feature.f.n;
import com.ucpro.feature.g.g.b;
import com.ucpro.ui.c.a;
import com.ucweb.common.util.i.c;

/* compiled from: ProGuard */
public final class o implements n {
    l a;
    private m b;
    private int c = -1;

    public o(l lVar, m mVar) {
        this.a = lVar;
        this.b = mVar;
    }

    public final void a(boolean z) {
        g.a().a(e.bS, Boolean.valueOf(z));
    }

    public final com.ucpro.base.c.b.g a(com.ucpro.base.c.b.g gVar) {
        return this.b.b(gVar);
    }

    public final void b() {
        g.a().a(e.bS, Boolean.valueOf(true));
    }

    public final void c() {
        com.ucpro.ui.g.m mVar = new com.ucpro.ui.g.m(this.b.h());
        mVar.a(1);
        mVar.a(a.d((int) R.string.cloud_sync_exit_ok), a.d((int) R.string.cloud_sync_exit_cancel));
        mVar.a(a.d((int) R.string.cloud_sync_exit_info));
        mVar.a(new a(this));
        mVar.show();
    }

    public final void e() {
        if (c.g()) {
            n.a;
            if (com.ucpro.feature.f.e.c()) {
                n.a.a(new c(this));
                this.c = 0;
                return;
            }
            return;
        }
        com.ucpro.ui.b.e.a().a(a.d((int) R.string.cloud_sync_account_no_network), 0);
    }

    public final String f() {
        Object a = com.ucpro.feature.g.a.a(50011);
        if (TextUtils.isEmpty(a)) {
            return a.d((int) R.string.cloud_sync_not_yet);
        }
        return a.d((int) R.string.cloud_sync_succ_time) + a;
    }

    public final boolean a() {
        return b.a.a();
    }

    public final void d() {
        com.uc.base.a.a.a.h.a e;
        n.a;
        if (com.ucpro.feature.f.e.c()) {
            n.a;
            e = com.ucpro.feature.f.e.e();
            if (e != null) {
                this.a.b(com.ucpro.feature.f.e.a(e));
            } else {
                n.a.b(new p(this));
            }
        }
        if (c.g()) {
            n.a.a(new j(this));
            this.c = 1;
            return;
        }
        com.ucpro.ui.b.e.a().a(a.d((int) R.string.cloud_sync_account_no_network), 0);
        n.a;
        e = com.ucpro.feature.f.e.e();
        if (e != null) {
            this.a.b(com.ucpro.feature.f.e.a(e));
        } else {
            n.a.b(new q(this));
        }
    }

    public final void h() {
        n.a;
        if (com.ucpro.feature.f.e.c()) {
            switch (this.c) {
                case 0:
                    com.ucpro.feature.g.a.c(new e(this));
                    return;
                case 1:
                    com.ucpro.feature.g.a.a(new b(this));
                    return;
                default:
                    return;
            }
        }
        com.ucpro.ui.b.e.a().a(a.d((int) R.string.cloud_sync_account_empty), 0);
    }

    public final boolean g() {
        n.a;
        if (!com.ucpro.feature.f.e.c() || n.a.a) {
            return false;
        }
        return true;
    }
}
