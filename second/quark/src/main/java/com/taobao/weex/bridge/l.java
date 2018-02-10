package com.taobao.weex.bridge;

import com.taobao.weex.ac;
import com.taobao.weex.ad;
import java.util.Map;

/* compiled from: ProGuard */
public final class l implements Runnable {
    final /* synthetic */ ac a;
    final /* synthetic */ String b;
    final /* synthetic */ Map c;
    final /* synthetic */ String d;
    final /* synthetic */ s e;

    public l(s sVar, ac acVar, String str, Map map, String str2) {
        this.e = sVar;
        this.a = acVar;
        this.b = str;
        this.c = map;
        this.d = str2;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        s.a(this.e, this.a, this.b, this.c, this.d);
        ad.a().a(new k(this, System.currentTimeMillis() - currentTimeMillis), 0);
    }
}
