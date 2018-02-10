package com.ucpro.feature.webwindow.f.a.a;

import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.uc.base.jssdk.a.c;
import com.uc.base.jssdk.i;
import com.uc.base.jssdk.q;
import com.uc.base.jssdk.t;
import com.ucpro.business.stat.f;
import com.ucpro.feature.webwindow.f.a.a;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class l implements c {
    private static q b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(INoCaptchaComponent.token, f.c());
            return new q(i.a, jSONObject);
        } catch (Exception e) {
            Exception exception = e;
            q qVar = new q(i.e, "");
            com.ucweb.common.util.c.a(exception.getMessage());
            return qVar;
        }
    }

    public final String a(String str, JSONObject jSONObject, t tVar) {
        q qVar = null;
        if ("activity.createToken".equals(str)) {
            qVar = b();
        }
        if (!(tVar == null || qVar == null)) {
            tVar.a(qVar);
        }
        return "";
    }

    public final boolean a() {
        a.a;
        return true;
    }
}
