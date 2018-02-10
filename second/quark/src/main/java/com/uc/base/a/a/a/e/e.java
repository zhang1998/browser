package com.uc.base.a.a.a.e;

import com.uc.base.a.a.a.d.a;
import com.uc.base.a.a.a.d.b;
import java.util.TreeMap;

/* compiled from: ProGuard */
final class e implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ c c;
    final /* synthetic */ j d;

    e(j jVar, String str, String str2, c cVar) {
        this.d = jVar;
        this.a = str;
        this.b = str2;
        this.c = cVar;
    }

    public final void run() {
        TreeMap treeMap = new TreeMap();
        treeMap.put("method", "cas.loginWithSmsCode");
        treeMap.put("mobile", this.a);
        treeMap.put("sms_code", this.b);
        b a = a.a(treeMap);
        if (this.c != null) {
            this.d.b(new m(this, a));
        }
    }
}
