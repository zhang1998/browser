package com.taobao.weex.ui.component;

import com.taobao.weex.ui.view.c;
import com.uc.apollo.android.GuideDialog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class cc implements c {
    final /* synthetic */ cd a;

    cc(cd cdVar) {
        this.a = cdVar;
    }

    public final void a(String str) {
        if (this.a.getDomObject().c_().contains("receivedtitle")) {
            Map hashMap = new HashMap();
            hashMap.put(GuideDialog.TITLE, str);
            this.a.fireEvent("receivedtitle", hashMap);
        }
    }

    public final void b(String str) {
        if (this.a.getDomObject().c_().contains("pagestart")) {
            Map hashMap = new HashMap();
            hashMap.put("url", str);
            this.a.fireEvent("pagestart", hashMap);
        }
    }

    public final void a(String str, boolean z, boolean z2) {
        if (this.a.getDomObject().c_().contains("pagefinish")) {
            Map hashMap = new HashMap();
            hashMap.put("url", str);
            hashMap.put("canGoBack", Boolean.valueOf(z));
            hashMap.put("canGoForward", Boolean.valueOf(z2));
            this.a.fireEvent("pagefinish", hashMap);
        }
    }
}
