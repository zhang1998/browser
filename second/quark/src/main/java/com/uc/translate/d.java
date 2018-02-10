package com.uc.translate;

import com.alibaba.fastjson.a.e;
import com.uc.translate.TranslateResponse.TranslateError;
import com.uc.translate.a.a;
import com.uc.translate.a.b;
import com.uc.translate.a.f;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
final class d {
    private String a;
    private String b = "json";
    private String c;
    private String d;
    private String e = "hmac";
    private int f = 15000;
    private int g = 30000;
    private boolean h = true;
    private boolean i = false;
    private boolean j = true;
    private boolean k = false;
    private String l = null;
    private n m;

    public d(String str, String str2, String str3, n nVar) {
        this.c = str2;
        this.d = str3;
        this.a = str;
        this.m = nVar;
    }

    final <T extends TranslateResponse> T a(e<T> eVar) throws a {
        Long valueOf;
        String str;
        f fVar = new f();
        Map lVar = new l(eVar.d());
        fVar.d = lVar;
        l lVar2 = new l();
        lVar2.a("method", eVar.c());
        lVar2.a("v", "2.0");
        lVar2.a("app_key", this.c);
        Long b = eVar.b();
        if (b == null) {
            valueOf = Long.valueOf(System.currentTimeMillis());
        } else {
            valueOf = b;
        }
        String str2 = "timestamp";
        Date date = new Date(valueOf.longValue());
        if (date instanceof String) {
            str = (String) date;
        } else if (date instanceof Integer) {
            str = ((Integer) date).toString();
        } else if (date instanceof Long) {
            str = ((Long) date).toString();
        } else if (date instanceof Float) {
            str = ((Float) date).toString();
        } else if (date instanceof Double) {
            str = ((Double) date).toString();
        } else if (date instanceof Boolean) {
            str = ((Boolean) date).toString();
        } else {
            str = a.a(date);
        }
        lVar2.a(str2, str);
        fVar.b = lVar2;
        l lVar3 = new l();
        lVar3.a("format", this.b);
        lVar3.a("sign_method", this.e);
        lVar3.a("session", null);
        str2 = "partner_id";
        if (this.k) {
            str = "top-sdk-java-httpdns-20171018";
        } else {
            str = "top-sdk-java-20171018";
        }
        lVar3.a(str2, str);
        if (this.i) {
            lVar3.a("simplify", Boolean.TRUE.toString());
        }
        fVar.c = lVar3;
        try {
            T t;
            a aVar;
            str = "sign";
            String str3 = this.d;
            str2 = this.e;
            Map hashMap = new HashMap();
            if (!(fVar.b == null || fVar.b.isEmpty())) {
                hashMap.putAll(fVar.b);
            }
            if (!(fVar.c == null || fVar.c.isEmpty())) {
                hashMap.putAll(fVar.c);
            }
            if (!(fVar.d == null || fVar.d.isEmpty())) {
                hashMap.putAll(fVar.d);
            }
            lVar2.a(str, b.a(hashMap, str3, str2));
            str = this.a;
            str3 = f.a(fVar.b, "UTF-8");
            String a = f.a(fVar.c, "UTF-8");
            str = f.a(str, str3, a);
            if (this.j) {
                eVar.a().put("Accept-Encoding", "gzip");
            }
            if (a() != null) {
                eVar.a().put("TOP_HTTP_DNS_HOST", a());
            }
            if (this.m == null) {
                str = f.a(str, lVar, "UTF-8", this.f, this.g, eVar.a());
            } else {
                str3 = "application/x-www-form-urlencoded;charset=UTF-8";
                a = f.a(lVar, "UTF-8");
                byte[] bArr = new byte[0];
                if (a != null) {
                    bArr = a.getBytes("UTF-8");
                }
                URL url = new URL(str);
                if (eVar.a() == null || eVar.a().get("TOP_HTTP_DNS_HOST") == null) {
                    eVar.a().put("Host", url.getHost());
                } else {
                    eVar.a().put("Host", eVar.a().get("TOP_HTTP_DNS_HOST"));
                }
                eVar.a().put("Accept", "text/xml,text/javascript");
                eVar.a().put("User-Agent", "top-sdk-java");
                eVar.a().put("Content-Type", str3);
                str = this.m.a(url, bArr, eVar.a());
            }
            fVar.a = str;
            if (this.h) {
                try {
                    t = (TranslateResponse) com.alibaba.fastjson.a.a(fVar.a, new c(this).a(), new e[0]);
                    aVar = null;
                } catch (Throwable th) {
                    aVar = new a(th);
                    t = null;
                }
            } else {
                aVar = null;
                t = null;
            }
            if (t == null) {
                t = new TranslateResponse();
                if (aVar != null) {
                    t.mTranslateError = new TranslateError();
                    t.mTranslateError.mCode = -1;
                    t.mTranslateError.mErrorMsg = aVar.a;
                }
            }
            return t;
        } catch (Throwable th2) {
            throw new a(th2);
        }
    }

    private String a() {
        if (this.k) {
            return this.l;
        }
        return null;
    }
}
