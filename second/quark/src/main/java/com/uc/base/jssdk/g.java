package com.uc.base.jssdk;

import android.text.TextUtils;
import com.uc.base.jssdk.a.a;
import com.uc.base.jssdk.a.c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
final class g {
    l a;
    private e b;

    g(e eVar, l lVar) {
        this.a = lVar;
        this.b = eVar;
    }

    final String a(String str, String str2, String str3, String str4, int i, String str5, n nVar) {
        if (str.equals("__polling_result__")) {
            return nVar.a();
        }
        if (TextUtils.isEmpty(str2)) {
            JSONObject jSONObject = new JSONObject();
        } else {
            try {
                JSONObject jSONObject2 = new JSONObject(str2);
                t sVar = new s(this, str4, str3, i, nVar);
                a d = this.a.d(str);
                boolean z = false;
                if (d != null) {
                    z = d.a().booleanValue();
                }
                if (!z) {
                    c a = this.a.a(str);
                    if (a == null) {
                        sVar.a(new q(i.c, "", str4, str3, i));
                    } else {
                        a.a();
                        o a2 = u.a;
                        Runnable bVar = new b(this, a, str, jSONObject2, i, str5, sVar);
                        if (a2.b == null) {
                            throw new RuntimeException("should set JsApiExecute");
                        }
                        a2.b.b(bVar);
                    }
                }
            } catch (JSONException e) {
                a(nVar, new q(i.d, "", str4, str3, i));
                return "";
            }
        }
        return null;
    }

    static void a(n nVar, q qVar) {
        JSONObject jSONObject;
        f fVar = new f();
        fVar.b = qVar.d;
        fVar.a = qVar.e;
        fVar.c = qVar.c;
        try {
            if (TextUtils.isEmpty(qVar.b)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(qVar.b);
            }
        } catch (JSONException e) {
            jSONObject = new JSONObject();
        }
        fVar.d = qVar.a - 1;
        fVar.e = jSONObject;
        o a = u.a;
        Runnable rVar = new r(nVar, fVar);
        if (a.b == null) {
            throw new RuntimeException("should set JsApiExecute");
        }
        a.b.a(rVar);
    }
}
