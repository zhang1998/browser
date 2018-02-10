package com.taobao.weex.ui.component;

import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class c implements com.taobao.weex.ui.component.a.c {
    final /* synthetic */ l a;

    c(l lVar) {
        this.a = lVar;
    }

    public final void a(boolean z) {
        if (this.a.k) {
            Map hashMap = new HashMap(1);
            hashMap.put("isShow", Boolean.valueOf(z));
            this.a.fireEvent("keyboard", hashMap);
        }
        if (!z) {
            this.a.blur();
        }
    }
}
