package com.taobao.weex.utils;

import com.taobao.weex.c.b.c;
import com.taobao.weex.c.b.r;
import com.taobao.weex.c.o;

/* compiled from: ProGuard */
public final class t {
    public static float a(o oVar) {
        float o = oVar.o();
        r k = oVar.k();
        r l = oVar.l();
        float a = k.a(0);
        if (!c.a(a)) {
            o -= a;
        }
        float a2 = k.a(2);
        if (!c.a(a2)) {
            o -= a2;
        }
        a2 = l.a(0);
        if (!c.a(a2)) {
            o -= a2;
        }
        a2 = l.a(2);
        if (c.a(a2)) {
            return o;
        }
        return o - a2;
    }
}
