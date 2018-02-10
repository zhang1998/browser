package com.ucpro.feature.setting.b.f;

import com.uc.sync.e.h;
import com.ucpro.feature.g.e.a.d;
import com.ucpro.ui.b.e;

/* compiled from: ProGuard */
final class av implements h {
    final /* synthetic */ long a;
    final /* synthetic */ b b;

    av(b bVar, long j) {
        this.b = bVar;
        this.a = j;
    }

    public final void a(int i, int i2) {
        if (101 == i) {
            d.a;
            e.a().a("UC PRO标准同步: size:" + this.a + "-->" + com.ucpro.feature.g.e.a.e.c(), 1);
            return;
        }
        e.a().a("同步失败：" + i + " errorCode: " + i2, 1);
    }
}
