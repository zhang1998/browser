package com.ucpro.feature.w;

import android.os.Message;
import com.ucpro.base.a.j;
import com.ucpro.base.e.e;
import com.ucpro.business.e.d.g;
import com.ucpro.feature.webwindow.aj;
import com.ucweb.common.util.h.m;

/* compiled from: ProGuard */
public class a extends e {
    public final void a(int i, Message message) {
        if (com.ucpro.base.a.e.cs == i) {
            s_().b(true);
            Object ajVar = new aj();
            ajVar.o = g.a().a("tips_prizes_url", "http://rec.uc.cn/actplat/frontend/page/show/485/r.html?uc_param_str=dsdnfrpfbivesscpgimibtbmnijblauputogpintnw");
            ajVar.s = aj.b;
            s_().a(true);
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.k, ajVar);
            com.ucpro.services.a.a.a.c("56DB53DAD2D33272456868E88138FD31");
            com.ucpro.services.a.a.a.a("F2C1B9D490D098C810590705D2149EAA");
            com.ucpro.base.a.g.a().a(com.ucpro.base.a.e.cr, Boolean.valueOf(false));
        }
    }

    public final void b(int i, Message message) {
        if (j.q == i) {
            m.a(0, new c(this), 50);
        }
    }
}
