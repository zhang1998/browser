package com.ucpro.feature.webwindow.f.a.a;

import android.content.Context;
import com.uc.base.jssdk.a.c;
import com.uc.base.jssdk.i;
import com.uc.base.jssdk.q;
import com.uc.base.jssdk.t;
import com.ucpro.feature.webwindow.f.a.a;
import com.ucweb.common.util.d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class m implements c {
    private static q a(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("apiList");
            JSONObject jSONObject2 = new JSONObject();
            int i = 0;
            while (i < jSONArray.length() && i < 10) {
                String string = jSONArray.getString(i);
                a.a;
                jSONObject2.putOpt(string, "OK");
                i++;
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("checkResult", jSONObject2);
            return new q(i.a, jSONObject3);
        } catch (JSONException e) {
            JSONException jSONException = e;
            q qVar = new q(i.d, "");
            com.ucweb.common.util.c.a(jSONException.getMessage());
            return qVar;
        }
    }

    private static q b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "android");
            Context a = d.a();
            jSONObject.put("ver", a.getPackageManager().getPackageInfo(a.getPackageName(), 0).versionName);
            jSONObject.put("subver", com.ucpro.c.a.a());
            jSONObject.put("lang", "zh-cn");
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
        if ("base.checkAPI".equals(str)) {
            qVar = a(jSONObject);
        } else if ("base.getVersion".equals(str)) {
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
