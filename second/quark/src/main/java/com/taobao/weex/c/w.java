package com.taobao.weex.c;

import com.UCMobile.Apollo.ApolloMetaData;
import com.taobao.weex.c.b.j;
import com.taobao.weex.c.b.k;
import com.taobao.weex.c.b.q;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;

/* compiled from: ProGuard */
final class w implements j {
    w() {
    }

    public final void a(k kVar, float f, q qVar) {
        if (kVar != null) {
            k kVar2 = kVar.h;
            if (kVar2 != null && (kVar2 instanceof am)) {
                am amVar = (am) kVar2;
                amVar.d();
                ae aeVar = (ae) kVar;
                if ("cell".equals(aeVar.r)) {
                    kVar.c(((am) kVar2).c());
                } else if (ApolloMetaData.KEY_HEADER.equals(aeVar.r)) {
                    float a = WXViewUtils.a(amVar.y, amVar.o);
                    WXLogUtils.d("getAvailableWidth:" + a);
                    kVar.c(a);
                }
            }
        }
    }
}
