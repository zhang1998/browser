package com.taobao.weex.b.c;

import java.util.Map;

/* compiled from: ProGuard */
final class a implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ h c;
    final /* synthetic */ g d;

    a(g gVar, String str, String str2, h hVar) {
        this.d = gVar;
        this.a = str;
        this.b = str2;
        this.c = hVar;
    }

    public final void run() {
        Map a = j.a(this.d.a(this.a, this.b, false, true));
        if (this.c != null) {
            this.c.a(a);
        }
    }
}
