package com.uc.a.f;

import com.uc.a.e;
import com.uc.a.e.d;
import com.uc.apollo.impl.SettingsConst;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class k implements d {
    private Map<String, String> a;

    public k(Map map) {
        this.a = map;
    }

    public final g a(int i, String str) {
        g gVar = new g();
        gVar.a("req_url", str);
        gVar.e();
        gVar.a(e.b);
        gVar.b(i);
        Map a = gVar.a("dispatcher_upload");
        Map hashMap = new HashMap();
        hashMap.putAll(this.a);
        a.putAll(hashMap);
        if (i == 1) {
            return gVar;
        }
        if (i != 2) {
            return null;
        }
        gVar.a("dispatcher_upload", "localserver", SettingsConst.TRUE);
        return gVar;
    }
}
