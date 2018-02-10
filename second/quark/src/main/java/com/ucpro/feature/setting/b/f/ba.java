package com.ucpro.feature.setting.b.f;

import com.uc.sync.d.a;
import com.uc.sync.e.h;
import com.ucpro.feature.bookmarkhis.bookmark.a.f;
import com.ucpro.feature.bookmarkhis.bookmark.a.s;
import com.ucpro.ui.b.e;

/* compiled from: ProGuard */
final class ba implements h {
    final /* synthetic */ int a;
    final /* synthetic */ bg b;

    ba(bg bgVar, int i) {
        this.b = bgVar;
        this.a = i;
    }

    public final void a(int i, int i2) {
        if (101 == i) {
            s.a().b();
            int c = f.c();
            a.a("[Get执行后]锚是：" + c);
            int c2 = s.a().c();
            a.a("[Get执行后]本地共有书签条数：" + c2);
            e.a().a("Get同步测试:\nanchor: -1 -->" + c + "\nsize:" + this.a + "-->" + c2, 1);
        }
    }
}
