package com.alibaba.appmonitor.f;

import com.alibaba.analytics.a.b;
import com.alibaba.appmonitor.e.c;
import com.alibaba.fastjson.e;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public class a extends e {
    public int a = 0;
    public int b = 0;
    public Map<String, String> c;
    public Map<String, Integer> d;

    public final synchronized void a(Long l) {
        this.a++;
        super.c(l);
    }

    public final synchronized void b(Long l) {
        this.b++;
        super.c(l);
    }

    public final synchronized void a(String str, String str2) {
        int i = 100;
        synchronized (this) {
            if (!b.c(str)) {
                if (this.c == null) {
                    this.c = new HashMap();
                }
                if (this.d == null) {
                    this.d = new HashMap();
                }
                if (b.b(str2)) {
                    if (str2.length() <= 100) {
                        i = str2.length();
                    }
                    this.c.put(str, str2.substring(0, i));
                }
                if (this.d.containsKey(str)) {
                    this.d.put(str, Integer.valueOf(((Integer) this.d.get(str)).intValue() + 1));
                } else {
                    this.d.put(str, Integer.valueOf(1));
                }
            }
        }
    }

    public final synchronized e b() {
        e b;
        b = super.b();
        b.a("successCount", Integer.valueOf(this.a));
        b.a("failCount", Integer.valueOf(this.b));
        if (this.d != null) {
            com.alibaba.fastjson.b bVar = (com.alibaba.fastjson.b) com.alibaba.appmonitor.e.b.a().a(c.class, new Object[0]);
            for (Entry entry : this.d.entrySet()) {
                e eVar = (e) com.alibaba.appmonitor.e.b.a().a(com.alibaba.appmonitor.e.e.class, new Object[0]);
                String str = (String) entry.getKey();
                eVar.a(INoCaptchaComponent.errorCode, str);
                eVar.a("errorCount", entry.getValue());
                if (this.c.containsKey(str)) {
                    eVar.a("errorMsg", this.c.get(str));
                }
                bVar.add(eVar);
            }
            b.a("errors", bVar);
        }
        return b;
    }

    public final synchronized void a() {
        super.a();
        this.a = 0;
        this.b = 0;
        if (this.c != null) {
            this.c.clear();
        }
        if (this.d != null) {
            this.d.clear();
        }
    }
}
