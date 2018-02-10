package com.uc.a;

import android.text.TextUtils;
import java.util.HashMap;
import org.android.spdy.SpdyRequest;

/* compiled from: ProGuard */
public abstract class k implements n {
    public HashMap<String, HashMap<String, String>> a = new HashMap();
    protected int b;
    protected int c = -1;

    public k() {
        this.a.put("base", new HashMap());
        this.a.put("http_headers", new HashMap());
    }

    public final String a() {
        return b("req_url");
    }

    public final void a(int i) {
        this.b = i;
    }

    public final int b() {
        return this.b;
    }

    public final void b(int i) {
        this.c = i;
    }

    public final int c() {
        return this.c;
    }

    public final HashMap<String, String> a(String str) {
        return (HashMap) this.a.get(str);
    }

    public final void a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            HashMap hashMap = (HashMap) this.a.get(str);
            if (hashMap == null) {
                hashMap = new HashMap();
                this.a.put(str, hashMap);
            }
            if (hashMap != null) {
                hashMap.put(str2, str3);
            }
        }
    }

    public final String b(String str) {
        HashMap hashMap = (HashMap) this.a.get("base");
        if (hashMap != null) {
            return (String) hashMap.get(str);
        }
        return null;
    }

    public final void a(String str, String str2) {
        a("base", str, str2);
    }

    public final void b(String str, String str2) {
        a("http_headers", str, str2);
    }

    public final HashMap<String, String> d() {
        return (HashMap) this.a.get("http_headers");
    }

    public final void e() {
        a("method", SpdyRequest.POST_METHOD);
    }
}
