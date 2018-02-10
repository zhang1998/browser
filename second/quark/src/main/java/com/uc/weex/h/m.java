package com.uc.weex.h;

import java.util.Map;

/* compiled from: ProGuard */
final class m implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Map b;
    final /* synthetic */ o c;

    m(o oVar, String str, Map map) {
        this.c = oVar;
        this.a = str;
        this.b = map;
    }

    public final void run() {
        this.c.a(this.a, this.b);
    }
}
