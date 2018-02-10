package com.ucpro.feature.setting.b.d.b;

import com.ucpro.feature.setting.b.d.a.a;
import com.ucpro.ui.b.e;

/* compiled from: ProGuard */
final class f implements a {
    final /* synthetic */ com.ucpro.feature.setting.b.b.a.a a;
    final /* synthetic */ j b;

    f(j jVar, com.ucpro.feature.setting.b.b.a.a aVar) {
        this.b = jVar;
        this.a = aVar;
    }

    public final boolean a(String str) {
        try {
            int intValue = Integer.valueOf(str).intValue();
            this.a.a(Integer.valueOf(intValue));
            this.b.a(String.valueOf(intValue));
            return false;
        } catch (NumberFormatException e) {
            e.a().a("输入格式不合法，请重新输入", 1);
            return true;
        }
    }
}
