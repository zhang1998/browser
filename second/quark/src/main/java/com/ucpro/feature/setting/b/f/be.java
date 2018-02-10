package com.ucpro.feature.setting.b.f;

import com.alibaba.wireless.security.SecExceptionCode;
import com.uc.sync.d.a;
import com.ucpro.feature.bookmarkhis.bookmark.a.s;
import com.ucpro.feature.setting.b.b.a.i;

/* compiled from: ProGuard */
public final class be implements i {
    public final void a() {
        int c = s.a().c();
        int a = s.a().b();
        a.a("[Add同步测试执行前]锚是：" + a);
        a.a("[Add同步测试执行前]本地共有书签条数：" + c);
        for (int i = 0; i < SecExceptionCode.SEC_ERROR_SIGNATURE_ILLEGEL_KEY; i++) {
            s.a().a("www.test" + i + ".com/" + System.nanoTime(), "test" + i + System.currentTimeMillis());
        }
        com.ucpro.feature.g.a.a(new bv(this, a, c));
    }
}
