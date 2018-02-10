package com.taobao.weex.ui;

import com.taobao.weex.ac;
import com.taobao.weex.c.q;
import com.taobao.weex.ui.component.ab;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public final class d implements q {
    public Map<String, ab> a = new HashMap();
    public ac b;

    public d(ac acVar) {
        this.b = acVar;
    }

    public final ac a() {
        return this.b;
    }

    public final ab a(String str) {
        return (ab) this.a.get(str);
    }

    public final ab b(String str) {
        return (ab) this.a.remove(str);
    }
}
