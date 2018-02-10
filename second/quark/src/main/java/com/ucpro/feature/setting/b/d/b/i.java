package com.ucpro.feature.setting.b.d.b;

import com.ucpro.feature.setting.b.b.a.b;
import com.ucpro.feature.setting.b.d.a.a;
import com.ucpro.ui.b.e;

/* compiled from: ProGuard */
final class i implements a {
    final /* synthetic */ b a;
    final /* synthetic */ j b;

    i(j jVar, b bVar) {
        this.b = jVar;
        this.a = bVar;
    }

    public final boolean a(String str) {
        try {
            double doubleValue = Double.valueOf(str).doubleValue();
            this.a.a(Double.valueOf(doubleValue));
            this.b.a(String.valueOf(doubleValue));
            return false;
        } catch (NumberFormatException e) {
            e.a().a("输入格式不合法，请重新输入", 1);
            return true;
        }
    }
}
