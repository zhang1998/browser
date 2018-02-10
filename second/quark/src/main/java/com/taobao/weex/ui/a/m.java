package com.taobao.weex.ui.a;

import com.taobao.weex.ad;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.o;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.cd;

/* compiled from: ProGuard */
public class m extends o {
    @JSMethod(uiThread = true)
    public void goBack(String str) {
        a(l.goBack, str);
    }

    @JSMethod(uiThread = true)
    public void goForward(String str) {
        a(l.goForward, str);
    }

    @JSMethod(uiThread = true)
    public void reload(String str) {
        a(l.reload, str);
    }

    private void a(l lVar, String str) {
        ab a = ad.a().c.a(this.b.e, str);
        if (a instanceof cd) {
            ((cd) a).a(lVar.name());
        }
    }
}
