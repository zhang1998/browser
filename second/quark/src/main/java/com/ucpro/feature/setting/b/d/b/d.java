package com.ucpro.feature.setting.b.d.b;

import com.ucpro.feature.setting.b.b.a.c;
import com.ucpro.feature.setting.b.d.a.a;
import com.ucpro.ui.b.e;

/* compiled from: ProGuard */
final class d implements a {
    final /* synthetic */ c a;
    final /* synthetic */ j b;

    d(j jVar, c cVar) {
        this.b = jVar;
        this.a = cVar;
    }

    public final boolean a(String str) {
        try {
            long longValue = Long.valueOf(str).longValue();
            this.a.a(Long.valueOf(longValue));
            this.b.a(String.valueOf(longValue));
            return false;
        } catch (NumberFormatException e) {
            e.a().a("输入格式不合法，请重新输入", 1);
            return true;
        }
    }
}
