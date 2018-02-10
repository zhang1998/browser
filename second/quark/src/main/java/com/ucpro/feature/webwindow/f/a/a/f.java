package com.ucpro.feature.webwindow.f.a.a;

import android.text.TextUtils;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.uc.base.jssdk.a.c;
import com.uc.base.jssdk.i;
import com.uc.base.jssdk.q;
import com.uc.base.jssdk.t;
import com.uc.encrypt.d;
import com.uc.encrypt.k;
import com.uc.encrypt.l;
import com.ucpro.feature.webwindow.f.a.a;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class f implements c {
    private static q a(JSONObject jSONObject) {
        try {
            String a = a(jSONObject, "text");
            if (TextUtils.isEmpty(a)) {
                return new q(i.d, a("parameter text should be non-empty string"));
            }
            com.uc.encrypt.c.a;
            a = l.a(a);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("output_text", a);
            return new q(i.a, jSONObject2);
        } catch (k e) {
            return new q(i.e, a(e.a));
        } catch (Exception e2) {
            return new q(i.e, a(2));
        }
    }

    private static String a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        if (jSONObject.isNull(str)) {
            return null;
        }
        Object obj = jSONObject.get(str);
        return obj instanceof String ? (String) obj : null;
    }

    private static q b(JSONObject jSONObject) {
        try {
            Object a = a(jSONObject, "text");
            if (TextUtils.isEmpty(a)) {
                return new q(i.d, a("parameter text should be non-empty string"));
            }
            Object a2 = a(jSONObject, "salt");
            if (TextUtils.isEmpty(a2)) {
                return new q(i.d, a("parameter salt should be non-empty string"));
            }
            com.uc.encrypt.c.a;
            d.a();
            String a3 = l.a(d.d(), a + a2);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("output_text", a3);
            return new q(i.a, jSONObject2);
        } catch (k e) {
            return new q(i.e, a(e.a));
        } catch (Exception e2) {
            return new q(i.e, a(2));
        }
    }

    private static JSONObject a(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error_code", i);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    private static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error_msg", str);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    public final String a(String str, JSONObject jSONObject, t tVar) {
        q qVar = null;
        if (TextUtils.equals(str, "spam.getActivityToken")) {
            qVar = b();
        } else if (TextUtils.equals(str, "spam.encrypt")) {
            qVar = a(jSONObject);
        } else if (TextUtils.equals(str, "spam.sign")) {
            qVar = b(jSONObject);
        }
        if (!(tVar == null || qVar == null)) {
            tVar.a(qVar);
        }
        return "";
    }

    private static q b() {
        try {
            com.uc.encrypt.c.a;
            CharSequence a = l.a(com.ucweb.common.util.d.a());
            if (TextUtils.isEmpty(a)) {
                return new q(i.e, a(8));
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(INoCaptchaComponent.token, a);
            return new q(i.a, jSONObject);
        } catch (k e) {
            return new q(i.e, a(e.a));
        } catch (Exception e2) {
            return new q(i.e, a(2));
        }
    }

    public final boolean a() {
        a.a;
        return true;
    }
}
