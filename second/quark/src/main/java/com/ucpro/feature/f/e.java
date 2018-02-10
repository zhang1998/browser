package com.ucpro.feature.f;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.uc.base.a.a.a.b;
import com.uc.base.a.a.a.c;
import com.uc.base.a.a.a.e.i;
import com.uc.base.a.a.a.e.l;
import com.uc.base.a.a.a.g;
import com.uc.encrypt.j;
import com.ucpro.business.stat.m;
import com.ucpro.model.a.a;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
public final class e {
    public boolean a;

    private e() {
        this.a = false;
        b bVar = g.a;
        Context a = d.a();
        String str = j.c;
        com.uc.base.a.a.a.b.b bVar2 = new b();
        bVar.a = a;
        com.uc.base.a.a.a.f.b.a = str;
        com.uc.base.a.a.a.f.b.b = "20000";
        c.a = bVar2;
        ((com.uc.base.a.a.a.e.j) bVar.b()).a(new com.uc.base.a.a.a.j(bVar));
        this.a = a.a.a("account_is_new_register", false);
    }

    public final void a(@NonNull ValueCallback<String> valueCallback) {
        a().a(new s(this, valueCallback));
    }

    public static String a(com.uc.base.a.a.a.h.a aVar) {
        com.ucweb.common.util.c.a((Object) aVar, "profile info should not null when get UserNickName");
        String str = "";
        if (aVar == null) {
            return str;
        }
        if (!TextUtils.isEmpty(aVar.f)) {
            return aVar.f;
        }
        if (!TextUtils.isEmpty(aVar.a)) {
            return aVar.a;
        }
        if (TextUtils.isEmpty(com.uc.base.a.a.a.h.a.a())) {
            return str;
        }
        return com.uc.base.a.a.a.h.a.a();
    }

    public static com.uc.base.a.a.a.h.a e() {
        return f().a();
    }

    public final void b(@Nullable ValueCallback<com.uc.base.a.a.a.h.a> valueCallback) {
        f().a(new g(this, valueCallback));
    }

    public final void a(l lVar, String str) {
        new StringBuilder("loginWithThirdPartyAccount\nthirdPartyName: ").append(lVar.f).append("\nthirdPartyToekn: ").append(str).append("\n");
        a().a(lVar, str, null, new c(this));
    }

    private static com.uc.base.a.a.a.h.d f() {
        return (com.uc.base.a.a.a.h.d) g.a.a().a(com.uc.base.a.a.a.h.d.class);
    }

    static com.uc.base.a.a.a.e.d a() {
        return (com.uc.base.a.a.a.e.d) g.a.b();
    }

    static com.uc.base.a.a.a.a.c b() {
        return (com.uc.base.a.a.a.a.c) g.a.a().a(com.uc.base.a.a.a.a.c.class);
    }

    public static boolean c() {
        b bVar = g.a;
        return !TextUtils.isEmpty(c.a().b(i.a));
    }

    public static String d() {
        b bVar = g.a;
        Object c = b.c();
        if (TextUtils.isEmpty(c)) {
            m.a("account", "empty_st", new String[0]);
        }
        return c;
    }

    static /* synthetic */ void a(e eVar, Context context, String str, String str2, String str3, ValueCallback valueCallback) {
        new StringBuilder("sendSmsCodeForLogin step 2\nphoneNumber: ").append(str).append("\ncaptchaId: ").append(str2).append("\ncaptcha: ").append(str3);
        a().a(str, str2, str3, new a(eVar, valueCallback, str, context));
    }

    static /* synthetic */ void a(e eVar, String str, String str2, String str3, Context context, ValueCallback valueCallback) {
        new StringBuilder("showCaptchaDialog\nphoneNumber:  ").append(str).append("\ncaptchaId: ").append(str2).append("\ncaptchaImage: ").append(str3);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            com.ucpro.ui.g.d dVar = new com.ucpro.ui.g.d(context, str);
            dVar.a.setText(com.ucpro.ui.c.a.d((int) R.string.captcha_dialog_title_text));
            dVar.a(str2, str3);
            dVar.b = new i(eVar, dVar, valueCallback, context);
            d.a();
            dVar.show();
        }
    }

    static /* synthetic */ void a(e eVar, boolean z) {
        eVar.a = z;
        a.a.b("account_is_new_register", z);
    }
}
