package com.alibaba.analytics.core.h;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class h {
    private static Map<String, String> b(JSONObject jSONObject) {
        Map<String, String> hashMap = new HashMap();
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                String string = jSONObject.getString(str);
                if (!(str == null || string == null)) {
                    hashMap.put(str, string);
                }
            }
        } catch (JSONException e) {
        }
        return hashMap;
    }

    public static final List<j> a(JSONObject jSONObject) {
        List<j> linkedList = new LinkedList();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            if (str.startsWith("B02N")) {
                JSONObject jSONObject2;
                String substring;
                try {
                    jSONObject2 = jSONObject.getJSONObject(str);
                } catch (JSONException e) {
                    jSONObject2 = null;
                }
                if (str.length() > 5) {
                    substring = str.substring(5);
                } else {
                    substring = str;
                }
                if (jSONObject2 != null) {
                    str = jSONObject2.optString("content");
                    if (str == null || !str.equals("gc_304")) {
                        JSONObject jSONObject3;
                        try {
                            jSONObject3 = jSONObject2.getJSONObject("content");
                        } catch (JSONException e2) {
                            jSONObject3 = null;
                        }
                        long j = 0;
                        if (jSONObject2.has("t")) {
                            try {
                                j = jSONObject2.getLong("t");
                            } catch (JSONException e3) {
                            }
                        }
                        if (jSONObject3 != null) {
                            linkedList.add(a(substring, b(jSONObject3), j));
                        }
                    } else {
                        j jVar = new j();
                        jVar.a = substring;
                        jVar.d = true;
                        linkedList.add(jVar);
                    }
                }
            }
        }
        return linkedList;
    }

    public static final j a(String str, Map<String, String> map, long j) {
        j jVar = new j();
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            stringBuffer.append(entry.getKey().toString()).append("'").append(entry.getValue() == null ? "" : entry.getValue().toString()).append(it.hasNext() ? "^" : "");
        }
        jVar.b = stringBuffer.toString();
        jVar.a = str;
        jVar.c = j;
        return jVar;
    }
}
