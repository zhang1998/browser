package com.ucpro.feature.bookmarkhis.bookmark.a;

import android.text.TextUtils;
import android.util.Log;
import com.ucweb.common.util.c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class ah {
    private static final String b = ah.class.getSimpleName();
    public long a;

    private ah() {
    }

    public static ah a(long j) {
        ah ahVar = new ah();
        ahVar.a = j;
        return ahVar;
    }

    public final String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pinTime", this.a);
            return jSONObject.toString();
        } catch (JSONException e) {
            c.a(e.getMessage());
            return null;
        }
    }

    public static ah a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            Log.e(b, "fail to construct json object");
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        long optLong = jSONObject.optLong("pinTime");
        ah ahVar = new ah();
        ahVar.a = optLong;
        return ahVar;
    }
}
