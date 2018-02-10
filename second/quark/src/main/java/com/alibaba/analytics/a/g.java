package com.alibaba.analytics.a;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class g {
    public static Map<String, String> a(Map<String, String> map) {
        if (map == null) {
            return map;
        }
        Map<String, String> hashMap = new HashMap();
        for (String str : map.keySet()) {
            if (str instanceof String) {
                String str2 = (String) map.get(str);
                if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
                    try {
                        hashMap.put(URLEncoder.encode(str, "UTF-8"), URLEncoder.encode(str2, "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                    }
                }
            }
        }
        return hashMap;
    }
}
