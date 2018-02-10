package com.uc.weex.d.a;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class e {
    public static Map<String, Object> a(Uri uri) {
        Object b = b(uri);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(b);
        } catch (Throwable e) {
            Log.e("WeexUrl", "", e);
            jSONObject = null;
        }
        if (jSONObject != null) {
            return a(jSONObject);
        }
        return null;
    }

    private static String b(Uri uri) {
        String fragment = uri.getFragment();
        if (TextUtils.isEmpty(fragment)) {
            return null;
        }
        int i;
        int indexOf;
        int length = fragment.length();
        int i2 = 0;
        while (true) {
            int indexOf2 = fragment.indexOf(59, i2);
            i = indexOf2 != -1 ? indexOf2 : length;
            indexOf = fragment.indexOf(61, i2);
            if (indexOf > i || indexOf == -1) {
                indexOf = i;
            }
            if (indexOf - i2 == 17 && fragment.regionMatches(i2, "uc_wx_init_params", 0, 17)) {
                if (indexOf == i) {
                    return "";
                }
                try {
                    break;
                } catch (UnsupportedEncodingException e) {
                }
            }
            if (indexOf2 == -1) {
                return null;
            }
            i2 = indexOf2 + 1;
        }
        return URLDecoder.decode(fragment.substring(indexOf + 1, i), "UTF-8");
    }

    private static Map<String, Object> a(JSONObject jSONObject) {
        Map<String, Object> hashMap = new HashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object opt = jSONObject.opt(str);
            if (!(opt instanceof JSONArray)) {
                if (opt instanceof JSONObject) {
                    hashMap.put(str, a((JSONObject) opt));
                } else {
                    hashMap.put(str, opt);
                }
            }
        }
        return hashMap;
    }
}
