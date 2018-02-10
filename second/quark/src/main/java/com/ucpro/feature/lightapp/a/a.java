package com.ucpro.feature.lightapp.a;

import android.content.Context;
import com.uc.weex.h.h;
import com.uc.weex.h.j;
import com.uc.weex.h.k;
import com.ucpro.base.weex.a.b;
import com.ucweb.common.util.d;

/* compiled from: ProGuard */
public final class a {
    public static k a(String str, Context context) {
        b a = b.a("lightapp");
        a.b = com.ucpro.base.system.b.a.f();
        a.a = com.ucpro.base.system.b.a.g();
        h a2 = new j(str).a(a.a(context)).a("density", String.valueOf(d.a().getResources().getDisplayMetrics().density)).a("debug", String.valueOf(com.ucpro.c.b.b()));
        a2.a("imageUrlParamsSmall", com.ucweb.common.util.j.a.b(d.a(), "E90E9F38934E1448", "8CEDE4C0E847CFEF", "?imageView2/2/w/264"));
        a2.a("imageUrlParamsBig", com.ucweb.common.util.j.a.b(d.a(), "E90E9F38934E1448", "D9C439262A4E1828", "?imageView2/2/w/750"));
        a2.a("timeout", String.valueOf(com.ucweb.common.util.j.a.b(d.a(), "E90E9F38934E1448", "E8741860F76EC2A2", 10000)));
        return a2.b();
    }
}
