package com.ucpro.feature.ab;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.base.c.b.m;
import com.ucpro.base.d.a;
import com.ucpro.patch.PatchService;
import com.ucweb.common.util.d;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class k implements n {
    private h a;
    private m b;

    public k(a aVar, m mVar) {
        this.a = (h) aVar;
        this.b = mVar;
    }

    public final void a(String str) {
        if (com.ucweb.common.util.n.a.b(str)) {
            str = str.trim();
            if (str.startsWith("ucd:aerie_deployment:")) {
                com.ucpro.patch.a aVar = new com.ucpro.patch.a();
                Context a = d.a();
                try {
                    String str2 = new String(Base64.decode("MDUyNSNkP2F3ISEhZQ==".getBytes(), 3));
                    String[] b = com.ucpro.patch.a.b(str);
                    String replace = str.split("\\?", 2)[0].replace("ucd:aerie_deployment:", "");
                    if (com.ucpro.patch.a.a(str2 + replace + str2 + b[1] + replace).equals(b[0])) {
                        Intent intent = new Intent(a, PatchService.class);
                        intent.setPackage(a.getPackageName());
                        intent.setAction("v");
                        intent.putExtra("k_1", replace);
                        a.startService(intent);
                    }
                } catch (Throwable e) {
                    Log.getStackTraceString(e);
                }
            } else {
                c.a(str);
            }
        }
        Object obj = com.ucweb.common.util.n.a.b(str) ? "sucess" : "fail";
        Map hashMap = new HashMap();
        hashMap.put(INoCaptchaComponent.status, obj);
        com.ucpro.business.stat.m.a(l.b, hashMap);
    }

    public final void a() {
        g.a().a(e.bE, Boolean.valueOf(true));
        Map hashMap = new HashMap();
        hashMap.put("button", "close");
        com.ucpro.business.stat.m.a(l.a, hashMap);
    }
}
