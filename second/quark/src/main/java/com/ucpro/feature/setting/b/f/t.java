package com.ucpro.feature.setting.b.f;

import com.alibaba.wireless.security.SecExceptionCode;
import com.uc.sync.d.a;
import com.ucpro.feature.bookmarkhis.bookmark.a.m;
import com.ucpro.feature.bookmarkhis.bookmark.a.s;
import com.ucpro.feature.setting.b.b.a.i;

/* compiled from: ProGuard */
public final class t implements i {
    public final void a() {
        int c = s.a().c();
        int a = s.a().b();
        a.a("[Del同步测试执行前]锚是：" + a);
        a.a("[Del同步测试执行前]本地共有书签条数：" + c);
        int i = 0;
        for (m mVar : s.a().d()) {
            if (i >= SecExceptionCode.SEC_ERROR_DYN_STORE) {
                break;
            }
            s.a().d(mVar);
            i++;
        }
        a.a("删掉了" + i + "条数据！！");
        com.ucpro.feature.g.a.a(new ae(this, a, c));
    }
}
