package com.uc.weex.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class ad {
    private static JSONArray b(String str) {
        try {
            return new JSONObject(str).getJSONArray("data");
        } catch (JSONException e) {
            return null;
        }
    }

    static JSONObject a(String str) {
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            return null;
        }
    }

    static List<n> a(String str, int i) {
        JSONArray b = b(str);
        if (b == null) {
            return null;
        }
        List<n> arrayList = new ArrayList();
        for (int i2 = 0; i2 < b.length(); i2++) {
            n a = a(b.optJSONObject(i2));
            if (a != null) {
                a.g = i;
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    static n a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        n nVar = new n();
        nVar.a = jSONObject.optString("name");
        nVar.c = jSONObject.optString("bundle_version");
        nVar.d = jSONObject.optString("js_rel_version");
        nVar.e = jSONObject.optString("last_modified");
        nVar.b = jSONObject.optString("etag");
        nVar.f = jSONObject.optString("js_digest");
        nVar.h = jSONObject.optString("bundle_path");
        return nVar;
    }

    static String a(Map<String, n> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject.put("data", jSONArray);
            for (n nVar : map.values()) {
                if (!(nVar == null || nVar.a())) {
                    JSONObject a = a(nVar);
                    if (a != null) {
                        jSONArray.put(a);
                    }
                }
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            return "";
        }
    }

    private static JSONObject a(n nVar) {
        if (nVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js_rel_version", nVar.d);
            jSONObject.put("bundle_version", nVar.c);
            jSONObject.put("name", nVar.a);
            jSONObject.put("etag", nVar.b);
            jSONObject.put("last_modified", nVar.e);
            jSONObject.put("js_digest", nVar.f);
            jSONObject.put("bundle_path", nVar.h);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
