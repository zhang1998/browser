package com.alibaba.appmonitor.model;

import com.alibaba.appmonitor.e.a;
import com.alibaba.appmonitor.e.b;
import com.alibaba.appmonitor.f.e;
import com.alibaba.appmonitor.f.h;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public class c implements a {
    public Map<b, e> a = Collections.synchronizedMap(new HashMap());

    public final e a(Integer num, String str, String str2, String str3, Class<? extends e> cls) {
        int i = 1;
        if (num.intValue() == h.STAT.d) {
            i = 0;
            a a = a.a().a(str, str2);
        } else {
            Object obj = (b) b.a().a(b.class, str, str2, str3);
        }
        e eVar = null;
        if (a != null) {
            if (this.a.containsKey(a)) {
                eVar = (e) this.a.get(a);
            } else {
                synchronized (c.class) {
                    eVar = (e) b.a().a(cls, num, str, str2, str3);
                    this.a.put(a, eVar);
                }
                i = 0;
            }
            if (i != 0) {
                b.a().a(a);
            }
        }
        return eVar;
    }

    public final void a() {
        for (a a : this.a.values()) {
            b.a().a(a);
        }
        this.a.clear();
    }

    public final void a(Object... objArr) {
        if (this.a == null) {
            this.a = Collections.synchronizedMap(new HashMap());
        }
    }
}
