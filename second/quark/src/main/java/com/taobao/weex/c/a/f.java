package com.taobao.weex.c.a;

import android.text.TextUtils;
import com.alibaba.fastjson.e;
import com.taobao.weex.ac;
import com.taobao.weex.c.d;
import com.taobao.weex.utils.a;
import com.taobao.weex.utils.r;

/* compiled from: ProGuard */
public final class f implements d {
    private final String a;
    private final e b;

    public f(String str, e eVar) {
        this.a = str;
        this.b = eVar;
    }

    public final void a(com.taobao.weex.c.e eVar) {
        if ("fontFace".equals(this.a)) {
            a aVar;
            e eVar2 = this.b;
            ac d = eVar.d();
            if (eVar2 == null) {
                aVar = null;
            } else {
                aVar = new a(eVar2.h("fontFamily"), eVar2.h("src"), d);
            }
            if (aVar != null && !TextUtils.isEmpty(aVar.a)) {
                a a = r.a(aVar.a);
                if (a == null || !TextUtils.equals(a.b, aVar.b)) {
                    r.a(aVar);
                    r.b(aVar);
                    return;
                }
                r.b(a);
            }
        }
    }
}
