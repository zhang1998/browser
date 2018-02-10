package com.ucpro.feature.r;

import android.content.Context;
import com.quark.browser.R;
import com.ucpro.feature.r.a.a;
import com.ucpro.feature.r.a.b;
import com.ucweb.a.b.d;
import com.ucweb.a.u;
import com.ucweb.common.util.h.m;
import hugo.weaving.DebugLog;

/* compiled from: ProGuard */
public final class h implements d {
    Context a;
    b b;
    long c;

    public h(Context context) {
        this.a = context;
    }

    @DebugLog
    public final void a(u uVar) {
        if (this.b == null || this.b.isShowing()) {
            if (this.b != null) {
                this.b.dismiss();
            }
            a aVar = new a(this.a);
            aVar.a(new b(this, uVar));
            aVar.a(uVar);
            return;
        }
        this.b = null;
    }

    @DebugLog
    public final void a() {
        a(com.ucpro.ui.c.a.d((int) R.string.upgrade_loading_info_fail));
    }

    public final void a(boolean z) {
        if (!z) {
            a(com.ucpro.ui.c.a.d((int) R.string.upgrade_toast_latest_version));
        }
    }

    private void a(String str) {
        long currentTimeMillis = System.currentTimeMillis() - this.c;
        if (currentTimeMillis < 800) {
            m.a(2, new f(this, str), 800 - currentTimeMillis);
        }
    }
}
