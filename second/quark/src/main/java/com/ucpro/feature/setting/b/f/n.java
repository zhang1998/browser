package com.ucpro.feature.setting.b.f;

import com.uc.sync.d.a;
import com.uc.sync.e.h;
import com.ucpro.feature.g.e.a.d;
import com.ucpro.feature.g.e.a.e;
import com.ucpro.feature.g.e.b;

/* compiled from: ProGuard */
final class n implements h {
    final /* synthetic */ int a = -1;
    final /* synthetic */ long b;
    final /* synthetic */ au c;

    n(au auVar, long j) {
        this.c = auVar;
        this.b = j;
    }

    public final void a(int i, int i2) {
        if (101 == i) {
            d.a;
            long c = e.c();
            d.a;
            b.a();
            a.a("[Add同步测试执行后]锚是：-1");
            a.a("[Add同步测试执行后]本地共有导航条数：" + c);
            com.ucpro.ui.b.e.a().a("Add同步测试:\nanchor:" + this.a + "-->-1\nsize:" + this.b + "-->" + c, 1);
        }
    }
}
