package com.alibaba.appmonitor.f;

import com.alibaba.appmonitor.e.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public class b implements a {
    public String a;
    public int b;
    public String c;
    public String d;
    public String e;
    public Map<String, String> f;

    public final void a() {
        this.a = null;
        this.b = 0;
        this.c = null;
        this.d = null;
        this.e = null;
        if (this.f != null) {
            this.f.clear();
        }
    }

    public final void a(Object... objArr) {
        if (this.f == null) {
            this.f = new HashMap();
        }
    }
}
