package com.ucpro.feature.setting.b.f;

import com.uc.sync.d.a;
import com.ucpro.feature.g.e.a.c;
import com.ucpro.feature.g.e.a.d;
import com.ucpro.feature.g.e.a.e;
import com.ucpro.feature.g.e.b;
import com.ucpro.feature.setting.b.b.a.i;

/* compiled from: ProGuard */
public final class au implements i {
    public final void a() {
        d.a;
        long c = e.c();
        d.a;
        b.a();
        a.a("[Add同步测试执行前]锚是：-1");
        a.a("[Add同步测试执行前]本地共有书签条数：" + c);
        c cVar = new c();
        cVar.d = "title " + System.nanoTime();
        cVar.e = "www.test.com/" + System.nanoTime();
        d.a.a(cVar);
        cVar = new c();
        cVar.d = "title " + System.nanoTime();
        cVar.e = "www.test.com/" + System.nanoTime();
        d.a.a(cVar);
        d.a;
        b.a();
        b.a(new n(this, c));
    }
}
