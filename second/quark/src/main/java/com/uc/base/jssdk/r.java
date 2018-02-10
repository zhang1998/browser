package com.uc.base.jssdk;

import android.text.TextUtils;
import com.UCMobile.Apollo.Global;
import com.uc.apollo.impl.SettingsConst;

/* compiled from: ProGuard */
final class r implements Runnable {
    final /* synthetic */ f a;
    final /* synthetic */ n b;

    r(n nVar, f fVar) {
        this.b = nVar;
        this.a = fVar;
    }

    public final void run() {
        if (this.a.c == null || !this.a.c.equals(Global.APOLLO_SERIES)) {
            n nVar;
            if (this.a.c != null && this.a.c.equals(SettingsConst.TRUE)) {
                nVar = this.b;
                nVar.a.add(this.a);
            } else if (!TextUtils.isEmpty(this.a.b)) {
                nVar = this.b;
                nVar.b.a(this.a.b, this.a.d, this.a.a());
            }
        } else if (this.b.b != null) {
            this.b.b.a(this.a.b, this.a.d, this.a.a());
        }
    }
}
