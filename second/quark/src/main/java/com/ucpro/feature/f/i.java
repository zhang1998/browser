package com.ucpro.feature.f;

import android.content.Context;
import android.webkit.ValueCallback;
import com.ucpro.ui.g.a;
import com.ucpro.ui.g.d;

/* compiled from: ProGuard */
final class i implements a {
    final /* synthetic */ d a;
    final /* synthetic */ ValueCallback b;
    final /* synthetic */ Context c;
    final /* synthetic */ e d;

    i(e eVar, d dVar, ValueCallback valueCallback, Context context) {
        this.d = eVar;
        this.a = dVar;
        this.b = valueCallback;
        this.c = context;
    }

    public final void a() {
        e.b().a(new o(this));
    }

    public final void a(String str, String str2, String str3) {
        new StringBuilder("showCaptchaDialog onUserSubmitCaptcha\nphoneNumber: ").append(str).append("\ncaptchaId: ").append(str2).append("\ncaptcha: ").append(str3);
        d.b();
        e.a(this.d, this.c, str, str2, str3, this.b);
    }
}
