package com.ucpro.feature.setting.b.f;

import com.uc.sync.d.a;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucpro.feature.bookmarkhis.bookmark.a.s;
import com.ucpro.feature.setting.b.b.a.i;
import java.util.List;

/* compiled from: ProGuard */
public final class bu implements i {
    public final void a() {
        int c = s.a().c();
        int a = s.a().b();
        a.a("[Edit同步测试执行前]锚是：" + a);
        a.a("[Edit同步测试执行前]本地共有书签条数：" + c);
        List d = s.a().d();
        if (d.size() > 0) {
            m mVar = (m) d.get(0);
            a.a("改掉了1条数据！！newTitle=" + (mVar.e + "edit" + System.currentTimeMillis()));
            s.a().b(mVar);
            com.ucpro.feature.g.a.a(new ar(this, a, c));
        }
    }
}
