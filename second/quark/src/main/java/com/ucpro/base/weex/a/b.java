package com.ucpro.base.weex.a;

import android.content.Context;
import android.net.ConnectivityManager;
import com.uc.encrypt.f;
import com.ucweb.common.util.i.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class b {
    public int a = com.ucpro.base.system.b.a.g();
    public int b = com.ucpro.base.system.b.a.f();
    public Map<String, Object> c = new HashMap();
    private String d;
    private Map<String, Object> e = new HashMap();
    private Map<String, Object> f = new HashMap();

    private b(String str) {
        this.d = str;
    }

    public static b a(String str) {
        return new b(str);
    }

    public final Map<String, Object> a(Context context) {
        Object obj;
        this.e.put("uc", this.f);
        this.f.put("ucParams", com.ucpro.model.b.a("frdnpfvecpntgibiniprdswi", "http://www.uc.cn").toString());
        this.f.put("sno", f.a("ucweb"));
        this.f.put("devVersion", Boolean.valueOf(com.ucpro.c.b.b()));
        this.f.put("theme", a.a());
        Map hashMap = new HashMap();
        hashMap.put("pixelRatio", Float.valueOf(com.ucpro.base.system.b.a.a()));
        hashMap.put("windowHeight", Float.valueOf(((float) this.a) / com.ucpro.base.system.b.a.a()));
        hashMap.put("windowWidth", Float.valueOf(((float) this.b) / com.ucpro.base.system.b.a.a()));
        hashMap.put("statusBarHeight", Float.valueOf(((float) com.ucweb.common.util.f.b(context)) / com.ucpro.base.system.b.a.a()));
        this.f.put("env", hashMap);
        this.f.put("os", "android");
        this.f.put("screen", Integer.valueOf(com.ucpro.base.system.b.a.g() > com.ucpro.base.system.b.a.f() ? 1 : 0));
        Map map = this.f;
        String str = "network";
        String f = c.f();
        if (f == null || !c.g()) {
            obj = "NONE";
        } else if (ConnectivityManager.isNetworkTypeValid(c.e())) {
            obj = f.toUpperCase();
        } else {
            obj = "UNKNOWN";
        }
        map.put(str, obj);
        if (this.d == null) {
            this.f.putAll(this.c);
        } else {
            this.f.put(this.d, this.c);
        }
        return this.e;
    }
}
