package com.uc.base.a.a.a.a;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class d implements i {
    public String a;
    public String b;

    private d(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public static d a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject optJSONObject = new JSONObject(str).getJSONObject("data").optJSONObject("handle_metadata");
                    return new d(optJSONObject.optString("captcha_id"), optJSONObject.optString("captcha_image"));
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
        }
        return null;
    }

    public static d b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
                    return new d(jSONObject.optString("captcha_id"), jSONObject.optString("captcha_image"));
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
        }
        return null;
    }
}
