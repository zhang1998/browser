package com.taobao.weex.c;

import android.mini.support.annotation.NonNull;
import android.mini.support.v4.d.b;
import com.taobao.weex.common.i;
import com.taobao.weex.utils.WXLogUtils;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ProGuard */
public final class v implements Cloneable, Map<String, Object> {
    @NonNull
    private final b<String, Object> a;

    protected final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return i();
    }

    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return this.a.put((String) obj, obj2);
    }

    public v() {
        this.a = new b();
    }

    public v(@NonNull Map<String, Object> map) {
        this();
        this.a.putAll(map);
    }

    public static String a(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        Object obj = map.get("value");
        if (obj == null) {
            obj = map.get("content");
            if (obj == null) {
                return null;
            }
        }
        return obj.toString();
    }

    public final int a() {
        Object obj;
        Object obj2 = get("quality");
        if (obj2 == null) {
            obj = get("imageQuality");
        } else {
            obj = obj2;
        }
        if (obj == null) {
            return aj.b;
        }
        int i = aj.b;
        String obj3 = obj.toString();
        if (obj3.equals("original")) {
            return aj.a;
        }
        if (obj3.equals("low")) {
            return aj.b;
        }
        if (obj3.equals("normal")) {
            return aj.c;
        }
        if (obj3.equals("high")) {
            return aj.d;
        }
        return i;
    }

    public final int b() {
        Object obj = get("sharpen");
        if (obj == null) {
            obj = get("imageSharpen");
        }
        if (obj == null) {
            return i.a;
        }
        String obj2 = obj.toString();
        int i = i.a;
        if (obj2.equals("sharpen")) {
            return i.b;
        }
        return i;
    }

    public final boolean c() {
        boolean z = true;
        Object obj = get("recycle");
        if (obj != null) {
            try {
                z = Boolean.parseBoolean(String.valueOf(obj));
            } catch (Throwable e) {
                WXLogUtils.e("[WXAttr] recycle:", e);
            }
        }
        return z;
    }

    public final String d() {
        Object obj = get("loadmoreoffset");
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public final String a(String str) {
        if (containsKey(str)) {
            Object obj = get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj != null) {
                return String.valueOf(obj);
            }
        }
        return "";
    }

    public final float e() {
        float f = -1.0f;
        Object obj = get("columnWidth");
        if (obj == null) {
            return f;
        }
        String valueOf = String.valueOf(obj);
        if ("auto".equals(valueOf)) {
            return f;
        }
        try {
            f = Float.parseFloat(valueOf);
            if (f <= 0.0f) {
                return 0.0f;
            }
            return f;
        } catch (Throwable e) {
            WXLogUtils.e("[WXAttr] getColumnWidth:", e);
            return f;
        }
    }

    public final int f() {
        Object obj = get("columnCount");
        if (obj == null) {
            return -1;
        }
        String valueOf = String.valueOf(obj);
        if ("auto".equals(valueOf)) {
            return -1;
        }
        try {
            int parseInt = Integer.parseInt(valueOf);
            if (parseInt > 0) {
                return parseInt;
            }
            return -1;
        } catch (Throwable e) {
            WXLogUtils.e("[WXAttr] getColumnCount:", e);
            return -1;
        }
    }

    public final float g() {
        float f = 32.0f;
        Object obj = get("columnGap");
        if (obj == null) {
            return f;
        }
        String valueOf = String.valueOf(obj);
        if ("normal".equals(valueOf)) {
            return f;
        }
        try {
            f = Float.parseFloat(valueOf);
            if (f < 0.0f) {
                return -1.0f;
            }
            return f;
        } catch (Throwable e) {
            WXLogUtils.e("[WXAttr] getColumnGap:", e);
            return f;
        }
    }

    public final int h() {
        Object obj = get("layout");
        if (obj == null) {
            return 1;
        }
        try {
            String valueOf = String.valueOf(obj);
            int i = -1;
            switch (valueOf.hashCode()) {
                case 3181382:
                    if (valueOf.equals("grid")) {
                        i = 1;
                        break;
                    }
                    break;
                case 674874986:
                    if (valueOf.equals("multi-column")) {
                        i = 0;
                        break;
                    }
                    break;
            }
            switch (i) {
                case 0:
                    return 3;
                case 1:
                    return 2;
                default:
                    return 1;
            }
        } catch (Throwable e) {
            WXLogUtils.e("[WXAttr] getLayoutType:", e);
            return 1;
        }
    }

    public final boolean equals(Object obj) {
        return this.a.equals(obj);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final void clear() {
        this.a.clear();
    }

    public final boolean containsKey(Object obj) {
        return this.a.containsKey(obj);
    }

    public final boolean containsValue(Object obj) {
        return this.a.containsValue(obj);
    }

    @NonNull
    public final Set<Entry<String, Object>> entrySet() {
        return this.a.entrySet();
    }

    public final Object get(Object obj) {
        return this.a.get(obj);
    }

    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    @NonNull
    public final Set<String> keySet() {
        return this.a.keySet();
    }

    public final void putAll(Map<? extends String, ?> map) {
        this.a.putAll(map);
    }

    public final Object remove(Object obj) {
        return this.a.remove(obj);
    }

    public final int size() {
        return this.a.size();
    }

    @NonNull
    public final Collection<Object> values() {
        return this.a.values();
    }

    protected final v i() {
        return new v(this.a);
    }
}
