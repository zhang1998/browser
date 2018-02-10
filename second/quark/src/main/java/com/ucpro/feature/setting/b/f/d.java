package com.ucpro.feature.setting.b.f;

import com.uc.sync.d.a;
import com.ucpro.feature.g.e.a.e;
import com.ucpro.feature.g.e.b;
import com.ucpro.feature.setting.b.b.a.i;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public final class d implements i {
    public final void a() {
        com.ucpro.feature.g.e.a.d.a;
        long c = e.c();
        com.ucpro.feature.g.e.a.d.a;
        b.a();
        a.a("[Del同步测试执行前]锚是：-1");
        a.a("[Del同步测试执行前]本地共有导航条数：" + c);
        com.ucpro.feature.g.e.a.d.a;
        Object b = e.b();
        c.a(b);
        if (b.size() > 0) {
            com.ucpro.feature.g.e.a.d.a.b((com.ucpro.feature.g.e.a.c) b.get(0));
            a.a("删掉了1条数据！");
        }
        com.ucpro.feature.g.e.a.d.a;
        b.a();
        b.a(new u(this, c));
    }
}
