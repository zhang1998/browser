package com.uc.weex.h;

import com.uc.weex.c.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class k {
    public boolean a = true;
    public String b;
    public String c;
    public Map<String, Object> d;
    public g e;
    String f;
    public boolean g;
    a h;
    public boolean i;

    public final void a(String str, Object obj) {
        this.d.put(str, obj);
    }

    public final void a(Map<String, Object> map) {
        if (map != null) {
            this.d.putAll(map);
        }
    }

    private k() {
        this.d = new HashMap();
        this.i = false;
    }
}
