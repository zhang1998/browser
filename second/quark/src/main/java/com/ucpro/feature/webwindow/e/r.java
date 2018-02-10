package com.ucpro.feature.webwindow.e;

import com.ucpro.business.stat.m;
import com.ucweb.common.util.i.c;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class r {
    static void a(boolean z, int i, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("is_ssl_error", String.valueOf(z));
        hashMap.put("error_code", String.valueOf(i));
        hashMap.put("description", str);
        hashMap.put("url", str2);
        hashMap.put("net_type", c.f());
        m.a("webview", "receive_error", hashMap);
    }

    public static void a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("exception_message", str);
        m.a("webview", "webview_tel_error", hashMap);
    }
}
