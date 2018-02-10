package com.ucpro.feature.g.b;

import com.alibaba.wireless.security.SecExceptionCode;
import com.quark.browser.R;
import com.uc.base.a.a.a.h.a;
import com.uc.sync.e.h;
import com.ucpro.feature.f.e;
import com.ucpro.feature.f.n;

/* compiled from: ProGuard */
final class b implements h {
    final /* synthetic */ o a;

    b(o oVar) {
        this.a = oVar;
    }

    public final void a(int i, int i2) {
        a e;
        switch (i) {
            case 101:
                this.a.a.a(com.ucpro.ui.c.a.d((int) R.string.cloud_sync_succ_time) + com.ucpro.feature.g.a.a(50011));
                n.a;
                e = e.e();
                if (e != null) {
                    this.a.a.b(e.a(e));
                } else {
                    n.a.b(new f(this));
                }
                com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.cloud_sync_successful), 0);
                return;
            case 102:
                n.a;
                e = e.e();
                if (e != null) {
                    this.a.a.b(e.a(e));
                } else {
                    n.a.b(new k(this));
                }
                if (i2 == SecExceptionCode.SEC_ERROR_SECURITYBODY_INVALID_PARAM) {
                    com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.cloud_sync_failure_account_too_old), 0);
                } else if (i2 == SecExceptionCode.SEC_ERROR_SECURITYBODY) {
                    com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.cloud_sync_account_invalidate), 0);
                } else {
                    com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.cloud_sync_failure), 0);
                }
                com.uc.sync.d.a.a("业务：50011,同步失败，状态码：" + i + ",错误码：" + i2);
                return;
            case 105:
                n.a;
                e = e.e();
                if (e != null) {
                    this.a.a.b(e.a(e));
                } else {
                    n.a.b(new g(this));
                }
                com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.cloud_sync_account_unlogin), 0);
                return;
            default:
                return;
        }
    }
}
