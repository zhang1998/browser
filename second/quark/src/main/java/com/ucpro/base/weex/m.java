package com.ucpro.base.weex;

import com.taobao.weex.utils.WXLogUtils;
import com.uc.weex.a.n;
import com.uc.weex.f;
import com.ucpro.base.weex.b.a;
import java.util.HashMap;

/* compiled from: ProGuard */
final class m implements f {
    final /* synthetic */ f a;

    m(f fVar) {
        this.a = fVar;
    }

    public final void a(String str, String str2, String str3) {
        String str4 = "instanceId:" + str + " errCode:" + str2 + " msg:" + str3;
        HashMap hashMap = new HashMap();
        hashMap.put("msg", str4);
        a.a(WXLogUtils.WEEX_TAG, "exception", hashMap);
    }

    public final void a(String str, String str2, String str3, n nVar) {
        String str4 = "instanceId:" + str + " errCode:" + str2 + " msg:" + str3;
        HashMap hashMap = new HashMap();
        hashMap.put("msg", str4);
        if (nVar != null) {
            hashMap.put("app_name", nVar.a);
        }
        a.a(WXLogUtils.WEEX_TAG, "exception", hashMap);
    }
}
