package com.alibaba.analytics.a;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/* compiled from: ProGuard */
public final class b {
    public static String a(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return ((String) obj).toString();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue();
        }
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        if (obj instanceof Short) {
            return ((Short) obj).shortValue();
        }
        if (obj instanceof Byte) {
            return ((Byte) obj).byteValue();
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).toString();
        }
        if (obj instanceof Character) {
            return ((Character) obj).toString();
        }
        return obj.toString();
    }

    public static String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        Object obj = 1;
        StringBuffer stringBuffer = new StringBuffer();
        for (Object next : map.keySet()) {
            String a = a(map.get(next));
            String a2 = a(next);
            if (!(a == null || a2 == null)) {
                if (obj != null) {
                    stringBuffer.append(a2 + "=" + a);
                    obj = null;
                } else {
                    stringBuffer.append(",").append(a2 + "=" + a);
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String b(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        Object obj = 1;
        StringBuffer stringBuffer = new StringBuffer();
        for (Object next : map.keySet()) {
            String a = a(map.get(next));
            String a2 = a(next);
            if (!(a == null || a2 == null)) {
                if (obj != null) {
                    try {
                        stringBuffer.append(URLEncoder.encode(a2, "UTF-8") + "=" + URLEncoder.encode(a, "UTF-8"));
                        obj = null;
                    } catch (UnsupportedEncodingException e) {
                    }
                } else {
                    try {
                        stringBuffer.append(",").append(URLEncoder.encode(a2, "UTF-8") + "=" + URLEncoder.encode(a, "UTF-8"));
                    } catch (UnsupportedEncodingException e2) {
                    }
                }
            }
        }
        return stringBuffer.toString();
    }

    public static Map<String, String> a(String str) {
        Map<String, String> hashMap = new HashMap();
        StringTokenizer stringTokenizer = new StringTokenizer(str, "^");
        while (stringTokenizer.hasMoreTokens()) {
            StringTokenizer stringTokenizer2 = new StringTokenizer(stringTokenizer.nextToken(), "'");
            hashMap.put(stringTokenizer2.nextToken(), stringTokenizer2.hasMoreTokens() ? stringTokenizer2.nextToken() : null);
        }
        return hashMap;
    }

    public static boolean b(String str) {
        return !c(str);
    }

    public static boolean c(String str) {
        if (str != null) {
            int length = str.length();
            if (length != 0) {
                for (int i = 0; i < length; i++) {
                    if (!Character.isWhitespace(str.charAt(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }
}
