package com.tencent.b.a.a.a;

import android.util.Log;
import com.uc.apollo.impl.SettingsConst;
import org.json.JSONObject;

public final class c {
    String a = null;
    String b = null;
    public String c = SettingsConst.FALSE;
    long d = 0;

    static c a(String str) {
        c cVar = new c();
        if (h.a(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("ui")) {
                    cVar.a = jSONObject.getString("ui");
                }
                if (!jSONObject.isNull("mc")) {
                    cVar.b = jSONObject.getString("mc");
                }
                if (!jSONObject.isNull("mid")) {
                    cVar.c = jSONObject.getString("mid");
                }
                if (!jSONObject.isNull("ts")) {
                    cVar.d = jSONObject.getLong("ts");
                }
            } catch (Throwable e) {
                Log.w("MID", e);
            }
        }
        return cVar;
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            h.a(jSONObject, "ui", this.a);
            h.a(jSONObject, "mc", this.b);
            h.a(jSONObject, "mid", this.c);
            jSONObject.put("ts", this.d);
        } catch (Throwable e) {
            Log.w("MID", e);
        }
        return jSONObject;
    }

    public final String toString() {
        return a().toString();
    }
}
