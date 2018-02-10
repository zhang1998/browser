package com.taobao.weex.ui.component;

import android.text.TextUtils;
import com.taobao.weex.c.ae;
import com.taobao.weex.common.t;
import com.taobao.weex.ui.b;
import com.taobao.weex.ui.i;
import com.taobao.weex.utils.WXLogUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: ProGuard */
public final class ac {
    private static Map<String, Set<String>> a = new HashMap();

    public static Set<String> a(String str) {
        return (Set) a.get(str);
    }

    public static void b(String str) {
        a.remove(str);
    }

    public static ab a(com.taobao.weex.ac acVar, ae aeVar, bv bvVar) {
        if (acVar == null || aeVar == null || TextUtils.isEmpty(aeVar.r)) {
            return null;
        }
        if (a.get(acVar.e) == null) {
            a.put(acVar.e, new HashSet());
        }
        ((Set) a.get(acVar.e)).add(aeVar.r);
        b a = i.a(aeVar.r);
        if (a == null) {
            if (com.taobao.weex.i.c()) {
                WXLogUtils.e("WXComponentFactory error type:[" + aeVar.r + "] class not found");
            }
            a = i.a("container");
            if (a == null) {
                throw new t("Container component not found.");
            }
        }
        try {
            return a.a(acVar, aeVar, bvVar);
        } catch (Throwable e) {
            WXLogUtils.e("WXComponentFactory Exception type:[" + aeVar.r + "] ", e);
            return null;
        }
    }
}
