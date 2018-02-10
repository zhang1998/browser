package com.ucpro.feature.f;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.uc.base.a.a.a.a.d;
import com.uc.base.a.a.a.a.f;
import com.uc.base.a.a.a.a.i;
import com.uc.base.a.a.a.d.b;
import com.ucpro.ui.b.e;

/* compiled from: ProGuard */
final class r implements f {
    final /* synthetic */ String a;
    final /* synthetic */ Context b;
    final /* synthetic */ ValueCallback c;
    final /* synthetic */ e d;

    r(e eVar, String str, Context context, ValueCallback valueCallback) {
        this.d = eVar;
        this.a = str;
        this.b = context;
        this.c = valueCallback;
    }

    public final void a(b bVar, i iVar) {
        new StringBuilder("sendSmsCodeForLogin onSuccess\njsContent: \n").append(bVar.c).append("\nDebugInfo: \n").append(bVar.d);
        if (!TextUtils.equals(bVar.c(), "risk")) {
            e.a(this.d, this.b, this.a, "", "", this.c);
        } else if (iVar instanceof d) {
            e.a(this.d, this.a, ((d) iVar).a, ((d) iVar).b, this.b, this.c);
        }
    }

    public final void b(b bVar) {
        new StringBuilder("sendSmsCodeForLogin onFail\njsContent: \n").append(bVar.c).append("\nDebugInfo: \n").append(bVar.d);
        if (!TextUtils.isEmpty(bVar.b())) {
            e.a().a(bVar.b(), 0);
        }
        if (this.c != null) {
            this.c.onReceiveValue(Boolean.valueOf(false));
        }
    }
}
