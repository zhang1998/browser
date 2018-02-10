package com.ucpro.feature.webwindow.f.a.a;

import android.text.TextUtils;
import com.quark.browser.R;
import com.uc.quark.h;
import com.uc.quark.s;
import com.uc.quark.x;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucweb.c.a.c;
import com.ucweb.c.b.a;

/* compiled from: ProGuard */
final class i implements h {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    i(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public final void a(s sVar, int i, long j, long j2) {
        if (i == -3 || i == -1) {
            x.a().a(sVar.a(), sVar.h(), sVar.b(), false);
            switch (i) {
                case -3:
                    int i2 = TextUtils.isEmpty(this.a) ? c.d : c.c;
                    a aVar = new a();
                    aVar.a = this.a;
                    aVar.c = this.b;
                    aVar.b = this.c;
                    aVar.f = sVar.h();
                    aVar.e = sVar.h();
                    aVar.d = i2;
                    g.a().a(e.bC, aVar.a());
                    return;
                case -1:
                    com.ucpro.ui.b.e.a().a(com.ucpro.ui.c.a.d((int) R.string.js_sdk_biz_share_fail), 1);
                    return;
                default:
                    return;
            }
        }
    }
}
