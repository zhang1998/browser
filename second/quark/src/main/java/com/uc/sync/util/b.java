package com.uc.sync.util;

import android.graphics.Bitmap;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class b {
    private static List<Field> a(Class cls) {
        List<Field> arrayList = new ArrayList();
        do {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Object add : declaredFields) {
                arrayList.add(add);
            }
            cls = cls.getSuperclass();
        } while (!cls.equals(Object.class));
        return arrayList;
    }

    public static String a(Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Field field : a(obj.getClass())) {
                String name;
                field.setAccessible(true);
                JsonName jsonName = (JsonName) field.getAnnotation(JsonName.class);
                if (jsonName == null) {
                    name = field.getName();
                } else {
                    name = jsonName.value();
                }
                if (!("VERSION_MAX".equals(name) || "VERSION_BASE".equals(name) || "VERSION_BEAN_1".equals(name) || "USE_DESCRIPTOR".equals(name))) {
                    jSONObject.put(name, b(field.get(obj)));
                }
            }
            return jSONObject.toString();
        } catch (Throwable e) {
            throw new a(e);
        }
    }

    private static String a(List list) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (Object b : list) {
                jSONArray.put(b(b));
            }
            return jSONArray.toString();
        } catch (Throwable e) {
            throw new a(e);
        }
    }

    private static String a(Map<String, ?> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Entry entry : map.entrySet()) {
                jSONObject.put((String) entry.getKey(), b(entry.getValue()));
            }
            return jSONObject.toString();
        } catch (Throwable e) {
            throw new a(e);
        }
    }

    private static Object b(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            return new JSONArray(a((List) obj));
        }
        if (obj instanceof Map) {
            return new JSONObject(a((Map) obj));
        }
        Object obj2;
        if ((obj instanceof String) || (obj instanceof Integer) || (obj instanceof Boolean) || (obj instanceof Double) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Byte) || (obj instanceof Short)) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            return obj;
        }
        if (obj instanceof byte[]) {
            return new String((byte[]) obj);
        }
        if (obj instanceof Bitmap) {
            return new JSONObject();
        }
        return new JSONObject(a(obj));
    }
}
