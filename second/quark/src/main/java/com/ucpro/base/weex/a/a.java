package com.ucpro.base.weex.a;

import com.uc.framework.resources.r;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class a {
    public static String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("themeType", r.a().a.c);
            jSONObject.put("mainColor", "#" + Integer.toHexString(com.ucpro.ui.c.a.c("background_color")));
            jSONObject.put("isColorTheme", 0);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
