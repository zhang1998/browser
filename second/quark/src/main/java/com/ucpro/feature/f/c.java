package com.ucpro.feature.f;

import android.text.TextUtils;
import com.uc.base.a.a.a.d.b;
import com.ucpro.ui.b.e;

/* compiled from: ProGuard */
final class c implements com.uc.base.a.a.a.e.c {
    final /* synthetic */ e a;

    c(e eVar) {
        this.a = eVar;
    }

    public final void a(b bVar) {
        new StringBuilder("thirdPartyName success\njsContent: \n").append(bVar.c).append("\nDebugInfo: \n").append(bVar.d);
        CharSequence d = e.d();
        com.ucweb.common.util.c.a(d);
        if (!TextUtils.isEmpty(d)) {
            this.a.a(new l(this, bVar));
        }
    }

    public final void b(b bVar) {
        new StringBuilder("thirdPartyName fail\njsContent: \n").append(bVar.c).append("\nDebugInfo: \n").append(bVar.d);
        if (!TextUtils.isEmpty(bVar.b())) {
            e.a().a(bVar.b(), 0);
        }
    }
}
