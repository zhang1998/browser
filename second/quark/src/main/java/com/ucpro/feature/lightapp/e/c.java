package com.ucpro.feature.lightapp.e;

import com.ucpro.base.weex.l;

/* compiled from: ProGuard */
public class c extends l {
    private g a;

    public c(g gVar, com.ucpro.base.weex.c cVar) {
        super(cVar);
        this.a = gVar;
    }

    public final boolean b(String str, String str2, com.taobao.weex.bridge.c cVar) {
        if ("lightapp.gotoReport".equals(str)) {
            this.a.b(str2);
            return true;
        } else if ("lightapp.onGetArticleData".equals(str)) {
            this.a.a(str2);
            return true;
        } else if (!"lightapp.gotoOrigin".equals(str)) {
            return false;
        } else {
            this.a.i();
            return true;
        }
    }
}
