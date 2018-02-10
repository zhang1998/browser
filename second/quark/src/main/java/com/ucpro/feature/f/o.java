package com.ucpro.feature.f;

import android.text.TextUtils;
import com.uc.base.a.a.a.a.d;
import com.uc.base.a.a.a.a.f;
import com.uc.base.a.a.a.a.i;
import com.uc.base.a.a.a.d.b;
import com.ucpro.ui.b.e;

/* compiled from: ProGuard */
final class o implements f {
    final /* synthetic */ i a;

    o(i iVar) {
        this.a = iVar;
    }

    public final void a(b bVar, i iVar) {
        new StringBuilder("getTextCaptcha success\njsContent: \n").append(bVar.c).append("\nDebugInfo: \n").append(bVar.d);
        if (iVar instanceof d) {
            this.a.a.a(((d) iVar).a, ((d) iVar).b);
        }
        d.a("manual", "true", null);
    }

    public final void b(b bVar) {
        new StringBuilder("getTextCaptcha fail\njsContent: \n").append(bVar.c).append("\nDebugInfo: \n").append(bVar.d);
        if (!TextUtils.isEmpty(bVar.b())) {
            e.a().a(bVar.b(), 0);
        }
        if (this.a.b != null) {
            this.a.b.onReceiveValue(Boolean.valueOf(false));
        }
        d.a("manual", "false", bVar.c);
    }
}
