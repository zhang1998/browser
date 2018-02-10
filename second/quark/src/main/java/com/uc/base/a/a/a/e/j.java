package com.uc.base.a.a.a.e;

import com.uc.base.a.a.a.a;
import com.uc.base.a.a.a.c;
import com.uc.base.a.a.a.h.b;
import com.uc.base.a.a.a.k;
import com.uc.base.a.a.a.m;

/* compiled from: ProGuard */
public final class j extends a implements d {
    public final void a(String str, c cVar) {
        a(new f(this, str, cVar));
    }

    public final void a(n nVar) {
        a(new o(this, c.a().b(i.a), nVar));
    }

    public final void a(String str, String str2, String str3, c cVar) {
        a(new g(this, "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + str3 + "&secret=" + str2 + "&code=" + str + "&grant_type=authorization_code", cVar));
    }

    public final void a(String str, String str2, c cVar) {
        k.a(k.a("login_sdk", m.SMSLOGIN.c, str));
        a(new e(this, str, str2, cVar));
    }

    public final void a(l lVar, String str, String str2, c cVar) {
        String str3 = lVar.f;
        k.a(k.a("tplogin_sdk", lVar.f, ""));
        a(new p(this, str3, str, str2, cVar));
    }

    public final void a(String str, String str2, String str3, a aVar) {
        k.a(k.a("send_sms_code_sdk", "login", str));
        a(new b(this, str, str2, str3, aVar));
    }

    static /* synthetic */ void a() {
        i.b();
        b.a = null;
        com.uc.base.a.a.a.f.a a = c.a();
        a.d("nickname");
        a.d("gender");
        a.d("unaudited_avatar_uri");
        a.d("unaudited_avatar_id");
        a.d("avatar_state");
        a.d("avatar_url");
        a.d("avatar_id");
        a.d("thirdPartyAvatar_url");
        a.d("thirdPartyNickName");
    }
}
