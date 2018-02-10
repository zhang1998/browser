package com.alibaba.analytics.core.b;

import com.alibaba.analytics.a.af;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public final class a {
    private static Pattern a = Pattern.compile("(\\|\\||[\t\r\n]|\u0001|\u0000)+");

    public static Map<String, String> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        Map<String, String> hashMap = new HashMap();
        Iterator it = map.keySet().iterator();
        if (it != null) {
            while (it.hasNext()) {
                try {
                    String str = (String) it.next();
                    if (str != null) {
                        Object obj = (String) map.get(str);
                        if (!(obj == null || "".equals(obj))) {
                            obj = a.matcher(obj).replaceAll("");
                        }
                        hashMap.put(str, obj);
                    }
                } catch (Throwable th) {
                    af.b("[_checkMapFields]", th, new Object[0]);
                }
            }
        }
        return hashMap;
    }
}
