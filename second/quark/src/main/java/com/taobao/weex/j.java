package com.taobao.weex;

import android.text.TextUtils;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.o;
import java.util.Map;

/* compiled from: ProGuard */
public class j extends o {
    @JSMethod
    public void addEventListener(String str, String str2) {
        this.b.c(str, str2);
    }

    @JSMethod
    public void removeEventListener(String str) {
        ac acVar = this.b;
        if (!TextUtils.isEmpty(str)) {
            acVar.z.remove(str);
        }
    }

    public void addEventListener(String str, String str2, Map<String, Object> map) {
        super.addEventListener(str, str2, map);
        addEventListener(str, str2);
    }
}
