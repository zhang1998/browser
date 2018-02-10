package com.ucpro.feature.f;

import android.text.TextUtils;
import com.uc.base.a.a.a.d.b;
import com.uc.base.a.a.a.e.c;
import com.ucpro.base.a.f;
import com.ucpro.base.a.j;
import com.ucpro.ui.b.e;

/* compiled from: ProGuard */
final class h implements c {
    final /* synthetic */ e a;

    h(e eVar) {
        this.a = eVar;
    }

    public final void a(b bVar) {
        new StringBuilder("logout success\njsContent: \n").append(bVar.c).append("\nDebugInfo: \n").append(bVar.d);
        e.a(this.a, false);
        f.a().a(j.w, 0, null);
    }

    public final void b(b bVar) {
        new StringBuilder("logout fail\njsContent: \n").append(bVar.c).append("\nDebugInfo: \n").append(bVar.d);
        if (!TextUtils.isEmpty(bVar.b())) {
            e.a().a(bVar.b(), 0);
        }
    }
}
