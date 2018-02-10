package com.ucpro.feature.f;

import android.text.TextUtils;
import com.uc.base.a.a.a.d.b;
import com.uc.base.a.a.a.e.c;
import com.ucpro.ui.b.e;

/* compiled from: ProGuard */
final class j implements c {
    final /* synthetic */ e a;

    j(e eVar) {
        this.a = eVar;
    }

    public final void a(b bVar) {
        new StringBuilder("LoginWithWechat success\njsContent: \n").append(bVar.c).append("\nDebugInfo: \n").append(bVar.d);
        CharSequence d = e.d();
        com.ucweb.common.util.c.a(d);
        if (!TextUtils.isEmpty(d)) {
            this.a.a(new f(this, bVar));
        }
    }

    public final void b(b bVar) {
        new StringBuilder("LoginWithWechat fail\njsContent: \n").append(bVar.c).append("\nDebugInfo: \n").append(bVar.d);
        if (!TextUtils.isEmpty(bVar.b())) {
            e.a().a(bVar.b(), 0);
        }
    }
}
