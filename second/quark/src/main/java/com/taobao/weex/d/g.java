package com.taobao.weex.d;

import android.util.Base64;
import com.alibaba.fastjson.e;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.taobao.weex.bridge.c;
import com.taobao.weex.common.s;
import com.taobao.weex.utils.WXLogUtils;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class g implements h {
    final /* synthetic */ c a;
    final /* synthetic */ e b;
    final /* synthetic */ c c;
    final /* synthetic */ j d;

    g(j jVar, c cVar, e eVar, c cVar2) {
        this.d = jVar;
        this.a = cVar;
        this.b = eVar;
        this.c = cVar2;
    }

    public final void a(s sVar, Map<String, String> map) {
        String str = null;
        if (this.a != null) {
            Map hashMap = new HashMap();
            if (sVar == null || "-1".equals(sVar.a)) {
                hashMap.put(INoCaptchaComponent.status, Integer.valueOf(-1));
                hashMap.put("statusText", "ERR_CONNECT_FAILED");
            } else {
                int parseInt = Integer.parseInt(sVar.a);
                hashMap.put(INoCaptchaComponent.status, Integer.valueOf(parseInt));
                String str2 = "ok";
                boolean z = parseInt >= 200 && parseInt <= SecExceptionCode.SEC_ERROR_STA_STORE_UNKNOWN_ERROR;
                hashMap.put(str2, Boolean.valueOf(z));
                if (sVar.b == null) {
                    hashMap.put("data", null);
                } else {
                    Object obj;
                    String a = map != null ? j.a((Map) map, "Content-Type") : "";
                    if (this.b == null || !this.b.containsKey("Response-Type")) {
                        obj = null;
                    } else {
                        obj = this.b.h("Response-Type");
                    }
                    if ("base64".equals(obj)) {
                        try {
                            str = new String(Base64.encode(sVar.b, 0), "utf-8");
                        } catch (UnsupportedEncodingException e) {
                        }
                    } else {
                        str = j.a(sVar.b, a);
                    }
                    try {
                        hashMap.put("data", j.a(str, this.c.e));
                    } catch (Throwable e2) {
                        WXLogUtils.e("", e2);
                        hashMap.put("ok", Boolean.valueOf(false));
                        hashMap.put("data", "{'err':'Data parse failed!'}");
                    }
                }
                hashMap.put("statusText", d.a(sVar.a));
            }
            hashMap.put("headers", map);
            this.a.a(hashMap);
        }
    }
}
