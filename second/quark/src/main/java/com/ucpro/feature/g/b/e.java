package com.ucpro.feature.g.b;

import android.content.SharedPreferences.Editor;
import com.alibaba.wireless.security.SecExceptionCode;
import com.quark.browser.R;
import com.uc.sync.e.h;
import com.ucpro.feature.g.g.b;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class e implements h {
    final /* synthetic */ o a;

    e(o oVar) {
        this.a = oVar;
    }

    public final void a(int i, int i2) {
        switch (i) {
            case 101:
                com.ucpro.ui.b.e.a().a(a.d((int) R.string.cloud_sync_successful) + com.ucpro.feature.g.a.a(5001), 0);
                com.ucpro.feature.g.g.a a = b.a;
                String str = "C3F8534E79898E10";
                if (!"".equals(str)) {
                    Editor edit = a.a.edit();
                    edit.putBoolean(str, true);
                    edit.apply();
                }
                if (b.a.a()) {
                    this.a.a.b();
                    return;
                }
                return;
            case 102:
                if (i2 == SecExceptionCode.SEC_ERROR_SECURITYBODY_INVALID_PARAM) {
                    com.ucpro.ui.b.e.a().a(a.d((int) R.string.cloud_sync_failure_account_too_old), 0);
                } else if (i2 == SecExceptionCode.SEC_ERROR_SECURITYBODY) {
                    com.ucpro.ui.b.e.a().a(a.d((int) R.string.cloud_sync_account_invalidate), 0);
                } else {
                    com.ucpro.ui.b.e.a().a(a.d((int) R.string.cloud_sync_failure), 0);
                }
                com.uc.sync.d.a.a("业务：5001,同步失败，状态码：" + i + ",错误码：" + i2);
                return;
            case 105:
                com.ucpro.ui.b.e.a().a(a.d((int) R.string.cloud_sync_account_unlogin), 0);
                return;
            default:
                return;
        }
    }
}
