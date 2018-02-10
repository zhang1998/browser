package com.alibaba.appmonitor.e;

import com.alibaba.fastjson.b;
import java.util.Iterator;

/* compiled from: ProGuard */
public class c extends b implements a {
    public final void a() {
        Iterator it = iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof a) {
                b.a().a((a) next);
            }
        }
        super.clear();
    }

    public final void a(Object... objArr) {
    }
}
