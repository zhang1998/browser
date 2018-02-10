package com.taobao.weex.c.a;

import com.alibaba.fastjson.b;
import com.taobao.weex.c.d;
import com.taobao.weex.c.e;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: ProGuard */
public final class o implements d {
    private final String a;
    private final String b;
    private final b c;

    public o(String str, String str2, b bVar) {
        this.a = str;
        this.b = str2;
        this.c = bVar;
    }

    public final void a(e eVar) {
        ab b = eVar.b(this.a);
        if (b == null) {
            WXLogUtils.e("DOMAction", "target component not found.");
        } else {
            b.invoke(this.b, this.c);
        }
    }
}
