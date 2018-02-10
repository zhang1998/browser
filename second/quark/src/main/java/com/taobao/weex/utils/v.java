package com.taobao.weex.utils;

import android.mini.support.annotation.NonNull;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.b.z;
import com.taobao.weex.common.t;
import com.taobao.weex.i;

/* compiled from: ProGuard */
public final class v {
    @NonNull
    public static String a(Object obj, boolean z) {
        if (!z) {
            return a.a(obj);
        }
        try {
            return a.a(obj, z.WriteNonStringKeyAsString);
        } catch (Throwable e) {
            if (i.c()) {
                throw new t("fromObjectToJSONString parse error!");
            }
            WXLogUtils.e("fromObjectToJSONString error:", e);
            return "{}";
        }
    }
}
