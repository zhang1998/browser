package com.ucpro.feature.setting.b.f;

import com.uc.sync.d.a;
import com.uc.sync.e.h;
import com.ucpro.feature.g.e.a.d;
import com.ucpro.feature.g.e.a.e;

/* compiled from: ProGuard */
final class ce implements h {
    final /* synthetic */ long a;
    final /* synthetic */ bf b;

    ce(bf bfVar, long j) {
        this.b = bfVar;
        this.a = j;
    }

    public final void a(int i, int i2) {
        if (101 == i) {
            d.a;
            long c = e.c();
            a.a("[Get执行后]锚是：" + c);
            d.a;
            long c2 = e.c();
            a.a("[Get执行后]本地共有书签条数：" + c2);
            com.ucpro.ui.b.e.a().a("Get同步测试:\nanchor: -1 -->" + c + "\nsize:" + this.a + "-->" + c2, 1);
        }
    }
}
