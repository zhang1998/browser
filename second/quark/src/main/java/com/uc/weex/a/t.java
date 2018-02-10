package com.uc.weex.a;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class t implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ e b;
    final /* synthetic */ y c;

    t(y yVar, String str, e eVar) {
        this.c = yVar;
        this.a = str;
        this.b = eVar;
    }

    public final void run() {
        s sVar = new s(this);
        List list = (List) this.c.i.get(this.a);
        if (list != null) {
            list.add(this.b);
            return;
        }
        list = new ArrayList();
        this.c.i.put(this.a, list);
        list.add(this.b);
    }
}
