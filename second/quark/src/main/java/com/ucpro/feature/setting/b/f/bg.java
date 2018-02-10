package com.ucpro.feature.setting.b.f;

import com.uc.sync.d.a;
import com.ucpro.feature.bookmarkhis.bookmark.a.f;
import com.ucpro.feature.bookmarkhis.bookmark.a.s;
import com.ucpro.feature.setting.b.b.a.i;

/* compiled from: ProGuard */
public final class bg implements i {
    public final void a() {
        s.a();
        s.g();
        s.a().b();
        f.a(-1);
        StringBuilder stringBuilder = new StringBuilder("[Get执行前]锚是：");
        s.a().b();
        a.a(stringBuilder.append(f.c()).toString());
        int c = s.a().c();
        a.a("[Get执行前]本地共有书签条数：" + c);
        com.ucpro.feature.g.a.a(new ba(this, c));
    }
}
