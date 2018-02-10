package com.taobao.weex.common;

import com.taobao.weex.annotation.JSMethod;

/* compiled from: ProGuard */
public class l extends o {
    @JSMethod
    public void error(String str, String str2, String str3) {
        if (this.b != null) {
            this.b.a(str + "|" + str2, str3);
        }
    }
}
