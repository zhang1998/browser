package com.ucpro.feature.r.b;

import com.uc.webview.browser.interfaces.SettingKeys;
import com.ucpro.c.c;
import com.ucpro.c.d;
import com.ucpro.services.f.g;
import com.ucweb.a.b.b;
import okhttp3.OkHttpClient;

/* compiled from: ProGuard */
public final class a implements b {
    public final String a() {
        return com.ucpro.base.system.b.a.e();
    }

    public final int b() {
        return com.ucpro.base.system.b.a.f();
    }

    public final int c() {
        return com.ucpro.base.system.b.a.g();
    }

    public final String d() {
        return com.ucpro.base.system.b.a.h();
    }

    public final String e() {
        return com.ucpro.base.system.b.a.i();
    }

    public final String f() {
        return com.ucpro.base.system.b.a.j();
    }

    public final String g() {
        return com.ucpro.base.system.b.a.k();
    }

    public final String h() {
        return com.ucpro.base.system.b.a.l();
    }

    public final String i() {
        return com.ucpro.base.system.b.a.m();
    }

    public final int j() {
        int n = com.ucpro.base.system.b.a.n();
        if (n == com.ucweb.common.util.i.a.Wifi.h) {
            return 2;
        }
        if (n == com.ucweb.common.util.i.a.UnKnown.h) {
            return 99;
        }
        return 1;
    }

    public final String k() {
        return com.ucpro.base.system.b.a.o();
    }

    public final int l() {
        return com.ucpro.base.system.b.a.p();
    }

    public final long m() {
        return com.ucpro.base.system.b.a.s();
    }

    public final long n() {
        return com.ucpro.base.system.b.a.t();
    }

    public final String o() {
        return com.ucpro.base.system.b.a.u();
    }

    public final String p() {
        return com.ucpro.base.system.b.a.v();
    }

    public final String q() {
        return com.ucpro.base.system.b.a.w();
    }

    public final String r() {
        return "";
    }

    public final String s() {
        return com.ucpro.model.a.d(SettingKeys.UBISn);
    }

    public final String t() {
        return com.ucpro.base.system.b.a.x();
    }

    public final String u() {
        return com.ucpro.base.system.b.a.y();
    }

    public final String v() {
        return com.ucpro.base.system.b.a.z();
    }

    public final String w() {
        return com.ucpro.base.system.b.a.A();
    }

    public final String x() {
        return com.ucpro.base.system.b.a.B();
    }

    public final String y() {
        return com.ucpro.base.system.b.a.C();
    }

    public final String z() {
        String c = d.c();
        if (c == null || !c.toLowerCase().startsWith("zh-")) {
            return c;
        }
        return "zh-cn";
    }

    public final String A() {
        return com.ucpro.base.system.b.a.D();
    }

    public final String B() {
        return com.ucpro.base.system.b.a.E();
    }

    public final String C() {
        return com.ucpro.base.system.b.a.F();
    }

    public final String D() {
        return com.ucpro.base.system.b.a.G();
    }

    public final String E() {
        return com.ucpro.base.system.b.a.H();
    }

    public final String F() {
        return com.ucpro.model.a.d(SettingKeys.UBIUtdId);
    }

    public final String G() {
        return com.ucpro.model.a.d(SettingKeys.UBIAid);
    }

    public final String H() {
        return c.a().getAbsolutePath() + "/upgrade/upgradedata/";
    }

    public final String I() {
        return c.a().getAbsolutePath() + "/upgrade/userdata/";
    }

    public final void a(String str, String str2) {
        com.ucpro.model.a.a(str, str2);
    }

    public final boolean J() {
        return com.ucpro.base.system.b.a.J();
    }

    public final void a(String str, long j) {
        com.ucpro.model.a.a(str, j);
    }

    public final OkHttpClient K() {
        return g.a();
    }
}
