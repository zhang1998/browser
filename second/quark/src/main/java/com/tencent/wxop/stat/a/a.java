package com.tencent.wxop.stat.a;

import com.uc.apollo.impl.SettingsConst;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public String a = null;
    public String b = null;
    public int c;
    private String d = null;
    private String e = SettingsConst.FALSE;
    private int f = 0;
    private long g = 0;

    public a(String str, String str2, int i) {
        this.a = str;
        this.b = str2;
        this.c = i;
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            s.a(jSONObject, "ui", this.a);
            s.a(jSONObject, "mc", this.b);
            s.a(jSONObject, "mid", this.e);
            s.a(jSONObject, "aid", this.d);
            jSONObject.put("ts", this.g);
            jSONObject.put("ver", this.f);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public final String toString() {
        return a().toString();
    }
}
