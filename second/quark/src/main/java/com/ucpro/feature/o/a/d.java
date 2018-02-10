package com.ucpro.feature.o.a;

import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth.Resp;
import com.ucpro.base.a.g;
import com.ucpro.feature.g.c.b.b;
import com.ucpro.ui.b.e;
import com.ucweb.e.a;
import java.util.ArrayList;

/* compiled from: ProGuard */
final class d implements a {
    final /* synthetic */ b a;
    final /* synthetic */ k b;

    d(k kVar, b bVar) {
        this.b = kVar;
        this.a = bVar;
    }

    public final void a(BaseResp baseResp) {
        if (baseResp instanceof Resp) {
            Resp resp = (Resp) baseResp;
            switch (baseResp.errCode) {
                case -5:
                    if (com.ucpro.c.b.b()) {
                        e.a().a("微信登录不支持", 0);
                    }
                    com.ucpro.feature.g.c.e.a(this.a, "error_exception", String.valueOf(baseResp.errCode));
                    return;
                case -4:
                case -3:
                case -1:
                    if (com.ucpro.c.b.b()) {
                        e.a().a("微信登录失败", 0);
                    }
                    com.ucpro.feature.g.c.e.a(this.a, "error_exception", String.valueOf(baseResp.errCode));
                    return;
                case -2:
                    if (com.ucpro.c.b.b()) {
                        e.a().a("微信登录取消", 0);
                    }
                    com.ucpro.feature.g.c.e.a(this.a, "error_cancel", null);
                    return;
                case 0:
                    Object arrayList = new ArrayList();
                    arrayList.add(com.ucweb.login.b.WEIXIN.d);
                    arrayList.add(com.ucweb.login.b.WEIXIN.e);
                    arrayList.add(resp.code);
                    com.ucpro.feature.g.c.e.b(this.a);
                    g.a().a(com.ucpro.base.a.e.ca, arrayList);
                    return;
                default:
                    return;
            }
        }
    }
}
