package com.ucpro.feature.setting.b.f;

import com.uc.sync.d.a;
import com.uc.sync.e.h;
import com.ucpro.feature.bookmarkhis.bookmark.a.s;
import com.ucpro.ui.b.e;

/* compiled from: ProGuard */
final class bh implements h {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ bz c;

    bh(bz bzVar, int i, int i2) {
        this.c = bzVar;
        this.a = i;
        this.b = i2;
    }

    public final void a(int i, int i2) {
        if (101 == i) {
            int c = s.a().c();
            int a = s.a().b();
            a.a("[Add同步测试执行后]锚是：" + a);
            a.a("[Add同步测试执行后]本地共有书签条数：" + c);
            e.a().a("Add同步测试:\nanchor:" + this.a + "-->" + a + "\nsize:" + this.b + "-->" + c, 1);
        }
    }
}
