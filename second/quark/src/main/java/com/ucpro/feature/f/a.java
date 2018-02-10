package com.ucpro.feature.f;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.uc.base.a.a.a.a.d;
import com.uc.base.a.a.a.a.i;
import com.uc.base.a.a.a.d.b;
import com.ucpro.ui.b.e;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
final class a implements com.uc.base.a.a.a.e.a {
    final /* synthetic */ ValueCallback a;
    final /* synthetic */ String b;
    final /* synthetic */ Context c;
    final /* synthetic */ e d;

    a(e eVar, ValueCallback valueCallback, String str, Context context) {
        this.d = eVar;
        this.a = valueCallback;
        this.b = str;
        this.c = context;
    }

    public final void a(b bVar) {
        new StringBuilder("sendSmsCodeForLogin success\njsContent: \n").append(bVar.c).append("\nDebugInfo: \n").append(bVar.d);
        if (this.a != null) {
            this.a.onReceiveValue(Boolean.valueOf(true));
        }
    }

    public final void a(b bVar, i iVar) {
        new StringBuilder("sendSmsCodeForLogin onShowCaptcha\njsContent: \n").append(bVar.c).append("\nDebugInfo: \n").append(bVar.d);
        if (!TextUtils.isEmpty(bVar.b())) {
            e.a().a(bVar.b(), 0);
        }
        if (50058 == bVar.a()) {
            d.a("input_error", "true", null);
        }
        if (iVar instanceof d) {
            m.b(new q(this, iVar));
        }
    }

    public final void b(b bVar) {
        new StringBuilder("sendSmsCodeForLogin fail\njsContent: \n").append(bVar.c).append("\nDebugInfo: \n").append(bVar.d);
        if (!TextUtils.isEmpty(bVar.b())) {
            e.a().a(bVar.b(), 0);
        }
    }
}
