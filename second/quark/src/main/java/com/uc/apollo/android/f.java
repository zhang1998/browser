package com.uc.apollo.android;

import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class f {
    static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    static Map<String, String> b(String str) {
        return a(str, ",", "=");
    }

    static Map<String, String> a(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        if (a(str)) {
            return hashMap;
        }
        String[] split = str.split(str2);
        if (split != null && split.length > 0) {
            for (String trim : split) {
                String trim2 = trim2.trim();
                if (!a(trim2)) {
                    String[] split2 = trim2.split(str3);
                    if (split2 != null && split2.length == 2) {
                        Object obj = split2[0];
                        String str4 = split2[1];
                        if (hashMap.containsKey(obj)) {
                            hashMap.put(obj, ((String) hashMap.get(obj)) + ", " + str4);
                        } else {
                            hashMap.put(obj, str4);
                        }
                    }
                }
            }
        }
        return hashMap;
    }
}
