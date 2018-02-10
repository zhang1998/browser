package com.ucpro.base.weex;

import com.taobao.weex.bridge.c;
import com.taobao.weex.utils.v;
import com.uc.weex.h.f;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class l implements f {
    private String a = "default";
    private ConcurrentHashMap<String, Long> b = new ConcurrentHashMap();
    private c c;

    public l(c cVar) {
        this.c = cVar;
    }

    public boolean b(String str, String str2, c cVar) {
        return false;
    }

    public final boolean a(String str, String str2, c cVar) {
        if (!b(str, str2, cVar)) {
            this.c.a(str, str2, cVar);
        }
        return false;
    }

    public static void a(c cVar, Object obj, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", z);
            jSONObject.put("data", obj);
            cVar.a(v.a(jSONObject, false));
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public final void a() {
    }
}
