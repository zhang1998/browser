package com.taobao.weex.ui.component;

import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class x implements aa {
    final /* synthetic */ ab a;

    x(ab abVar) {
        this.a = abVar;
    }

    public final void a(boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
        this.a.fireEvent(z ? "focus" : "blur", hashMap);
    }
}
