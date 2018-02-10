package com.taobao.weex.a;

import com.alibaba.wireless.security.SecExceptionCode;
import com.taobao.weex.common.r;
import com.taobao.weex.common.s;
import java.net.HttpURLConnection;
import java.util.Map;

/* compiled from: ProGuard */
final class b implements Runnable {
    final /* synthetic */ r a;
    final /* synthetic */ i b;
    final /* synthetic */ e c;

    b(e eVar, r rVar, i iVar) {
        this.c = eVar;
        this.a = rVar;
        this.b = iVar;
    }

    public final void run() {
        s sVar = new s();
        c a = e.a();
        try {
            HttpURLConnection a2 = e.a(this.a);
            Map headerFields = a2.getHeaderFields();
            int responseCode = a2.getResponseCode();
            if (this.b != null) {
                this.b.a(responseCode, headerFields);
            }
            sVar.a = String.valueOf(responseCode);
            if (responseCode < 200 || responseCode > SecExceptionCode.SEC_ERROR_STA_STORE_UNKNOWN_ERROR) {
                sVar.d = e.b(a2.getErrorStream(), this.b);
            } else {
                sVar.b = e.a(a.a(a2.getInputStream()), this.b);
            }
            if (this.b != null) {
                this.b.a(sVar);
            }
        } catch (Exception e) {
            sVar.a = "-1";
            sVar.c = "-1";
            sVar.d = e.getMessage();
            if (this.b != null) {
                this.b.a(sVar);
            }
        }
    }
}
