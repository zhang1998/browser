package com.taobao.weex.c;

import android.mini.support.annotation.Nullable;
import android.text.TextUtils;
import com.taobao.weex.i;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: ProGuard */
public final class af {
    @Nullable
    public static ae a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Class a = ag.a(str);
        if (a == null && i.c()) {
            WXLogUtils.e("WXDomObjectFactory error type:[" + str + "] class not found");
        }
        try {
            if (ae.class.isAssignableFrom(a)) {
                return (ae) a.getConstructor(new Class[0]).newInstance(new Object[0]);
            }
        } catch (Throwable e) {
            WXLogUtils.e("WXDomObjectFactory Exception type:[" + str + "] ", e);
        }
        return null;
    }
}
