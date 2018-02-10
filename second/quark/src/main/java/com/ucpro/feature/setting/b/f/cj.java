package com.ucpro.feature.setting.b.f;

import com.uc.sync.d.a;
import com.ucpro.feature.g.e.a.c;
import com.ucpro.feature.g.e.a.d;
import com.ucpro.feature.g.e.a.e;
import com.ucpro.feature.g.e.b;
import com.ucpro.feature.setting.b.b.a.i;
import java.util.List;

/* compiled from: ProGuard */
public final class cj implements i {
    public final void a() {
        d.a;
        long c = e.c();
        d.a;
        b.a();
        a.a("[Edit同步测试执行前]锚是：-1");
        a.a("[Edit同步测试执行前]本地共有书签条数：" + c);
        d.a;
        List b = e.b();
        if (b.size() > 0) {
            c cVar = (c) b.get(0);
            a.a("改掉了1条数据！！newTitle=" + (cVar.d + " edit" + System.currentTimeMillis()));
            d.a;
            com.ucweb.common.util.c.b(cVar.b());
            d.a;
            b.a();
            b.a(new as(this, c));
            return;
        }
        a.a("no navigation to be edited");
    }
}
