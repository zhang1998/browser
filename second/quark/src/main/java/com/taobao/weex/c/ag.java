package com.taobao.weex.c;

import android.text.TextUtils;
import com.taobao.weex.common.h;
import com.taobao.weex.i;
import com.taobao.weex.utils.WXLogUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class ag {
    public static Class<? extends ae> a = ae.class;
    private static Map<String, Class<? extends ae>> b = new HashMap();

    public static boolean a(String str, Class<? extends ae> cls) throws h {
        if (cls == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (!b.containsKey(str)) {
            b.put(str, cls);
            return true;
        } else if (i.c()) {
            throw new h("WXDomRegistry had duplicate Dom:" + str);
        } else {
            WXLogUtils.e("WXDomRegistry had duplicate Dom: " + str);
            return false;
        }
    }

    public static Class<? extends ae> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return a;
        }
        Class<? extends ae> cls = (Class) b.get(str);
        return cls == null ? a : cls;
    }
}
